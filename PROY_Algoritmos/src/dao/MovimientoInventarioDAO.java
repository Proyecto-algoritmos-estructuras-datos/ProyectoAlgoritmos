package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import conexion.Conexion;
import interfaces.IMovimientoInventarioDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import modelo.Empleado;
import modelo.MovimientoInventario;
import modelo.Producto;
import modelo.Rol;
import modelo.TipoMovimiento;

public class MovimientoInventarioDAO implements IMovimientoInventarioDAO {

    // SELECT base del kardex. Producto y Empleado vienen "parciales" (solo los datos para mostrar).
    // No se trae la contraseña del empleado.
    private static final String SQL_SELECT_MOVIMIENTO = """
                     SELECT
                         m.id_movimiento,
                         m.tipo_movimiento,
                         m.cantidad,
                         m.stock_anterior,
                         m.stock_nuevo,
                         m.motivo,
                         m.id_compra,
                         m.id_venta,
                         m.fecha_movimiento,
                         p.id_producto,
                         p.codigo,
                         p.nombre_producto,
                         e.id_empleado,
                         e.dni,
                         e.nombres,
                         e.apellidos,
                         e.usuario,
                         e.rol
                     FROM movimiento_inventario m
                     INNER JOIN producto p ON m.id_producto = p.id_producto
                     INNER JOIN empleado e ON m.id_empleado = e.id_empleado
                     """;

    @Override
    public List<MovimientoInventario> verTodosLosMovimientos() throws Exception {
        String sql = SQL_SELECT_MOVIMIENTO + """
                     ORDER BY m.fecha_movimiento DESC, m.id_movimiento DESC
                     """;
        return consultarMovimientos(sql, null);
    }

    @Override
    public List<MovimientoInventario> verMovimientosPorProducto(int idProducto) throws Exception {
        String sql = SQL_SELECT_MOVIMIENTO + """
                     WHERE m.id_producto = ?
                     ORDER BY m.fecha_movimiento DESC, m.id_movimiento DESC
                     """;
        return consultarMovimientos(sql, idProducto);
    }

    @Override
    public List<MovimientoInventario> aplicarTomaInventario(Map<Integer, Integer> conteos, Empleado empleado, String motivo) throws Exception {
        List<MovimientoInventario> ajustes = new ArrayList<>();

        String sqlBloquear = """
                             SELECT nombre_producto, stock
                             FROM producto
                             WHERE id_producto = ?
                             FOR UPDATE
                             """;
        String sqlMovimiento = """
                               INSERT INTO movimiento_inventario
                               (
                               id_producto,
                               id_empleado,
                               tipo_movimiento,
                               cantidad,
                               stock_anterior,
                               stock_nuevo,
                               motivo
                               )
                               VALUES (?, ?, ?, ?, ?, ?, ?)
                               """;
        String sqlStock = """
                          UPDATE producto
                          SET stock = ?
                          WHERE id_producto = ?
                          """;

        // Aquí no se usa try-with-resources para la conexión porque hay que controlar
        // commit, rollback y restaurar el autoCommit a mano.
        Connection conn = null;
        try {
            conn = new Conexion().conectar();
            conn.setAutoCommit(false);

            try (PreparedStatement psBloquear = conn.prepareStatement(sqlBloquear);
                 PreparedStatement psMovimiento = conn.prepareStatement(sqlMovimiento);
                 PreparedStatement psStock = conn.prepareStatement(sqlStock);
                ) {
                // TreeMap: se recorre en orden de id para bloquear siempre en el mismo orden
                for (Map.Entry<Integer, Integer> entrada : new TreeMap<>(conteos).entrySet()) {
                    int idProducto = entrada.getKey();
                    int conteoFisico = entrada.getValue();

                    // 1) El stock anterior sale de la BD (bloqueando la fila), no de la pantalla
                    String nombreProducto;
                    int stockAnterior;
                    psBloquear.setInt(1, idProducto);
                    try (ResultSet rs = psBloquear.executeQuery()) {
                        if (!rs.next()) {
                            throw new Exception("El producto con id " + idProducto + " ya no existe!");
                        }
                        nombreProducto = rs.getString("nombre_producto");
                        stockAnterior = rs.getInt("stock");
                    }

                    // 2) Si coincide no se registra nada (el CHECK de la tabla exige cantidad > 0)
                    if (conteoFisico == stockAnterior) {
                        continue;
                    }

                    // 3) Movimiento AJUSTE en el kardex
                    int cantidad = Math.abs(conteoFisico - stockAnterior);
                    psMovimiento.setInt(1, idProducto);
                    psMovimiento.setInt(2, empleado.getIdEmpleado());
                    psMovimiento.setString(3, TipoMovimiento.AJUSTE.name());
                    psMovimiento.setInt(4, cantidad);
                    psMovimiento.setInt(5, stockAnterior);
                    psMovimiento.setInt(6, conteoFisico);
                    psMovimiento.setString(7, motivo);
                    psMovimiento.executeUpdate();

                    // 4) Actualizar solo la columna stock
                    psStock.setInt(1, conteoFisico);
                    psStock.setInt(2, idProducto);
                    psStock.executeUpdate();

                    // Detalle para el resumen que verá la pantalla
                    Producto producto = new Producto();
                    producto.setIdProducto(idProducto);
                    producto.setNombreProducto(nombreProducto);
                    producto.setStock(conteoFisico);

                    MovimientoInventario ajuste = new MovimientoInventario();
                    ajuste.setProducto(producto);
                    ajuste.setEmpleado(empleado);
                    ajuste.setTipoMovimiento(TipoMovimiento.AJUSTE);
                    ajuste.setCantidad(cantidad);
                    ajuste.setStockAnterior(stockAnterior);
                    ajuste.setStockNuevo(conteoFisico);
                    ajuste.setMotivo(motivo);
                    ajustes.add(ajuste);
                }
            }

            conn.commit();
            return ajustes;

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    // si el rollback falla, igual se informa el error original
                }
            }
            throw new Exception("No se aplicó ningún ajuste. Error en la toma de inventario: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException ex) {
                    // nada más que hacer
                }
            }
        }
    }

    // Ejecuta el SELECT del kardex; idProducto es null cuando no hay filtro
    private List<MovimientoInventario> consultarMovimientos(String sql, Integer idProducto) throws Exception {
        List<MovimientoInventario> listaMovimientos = new ArrayList<>();
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            if (idProducto != null) {
                ps.setInt(1, idProducto);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    listaMovimientos.add(mapearMovimiento(rs));
                }
            }
            return listaMovimientos;
        } catch (SQLException e) {
            throw new Exception("Error al cargar los movimientos de inventario: " + e.getMessage());
        }
    }

    private MovimientoInventario mapearMovimiento(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setIdProducto(rs.getInt("id_producto"));
        producto.setCodigo(rs.getString("codigo"));
        producto.setNombreProducto(rs.getString("nombre_producto"));

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(rs.getInt("id_empleado"));
        empleado.setDni(rs.getString("dni"));
        empleado.setNombres(rs.getString("nombres"));
        empleado.setApellidos(rs.getString("apellidos"));
        empleado.setUsuario(rs.getString("usuario"));
        empleado.setRol(Rol.valueOf(rs.getString("rol")));

        MovimientoInventario movimiento = new MovimientoInventario();
        movimiento.setIdMovimiento(rs.getInt("id_movimiento"));
        movimiento.setProducto(producto);
        movimiento.setEmpleado(empleado);
        movimiento.setTipoMovimiento(TipoMovimiento.valueOf(rs.getString("tipo_movimiento")));
        movimiento.setCantidad(rs.getInt("cantidad"));
        movimiento.setStockAnterior(rs.getInt("stock_anterior"));
        movimiento.setStockNuevo(rs.getInt("stock_nuevo"));
        movimiento.setMotivo(rs.getString("motivo"));

        int idCompra = rs.getInt("id_compra");
        movimiento.setIdCompra(rs.wasNull() ? null : idCompra);
        int idVenta = rs.getInt("id_venta");
        movimiento.setIdVenta(rs.wasNull() ? null : idVenta);

        Timestamp fecha = rs.getTimestamp("fecha_movimiento");
        movimiento.setFechaMovimiento(fecha != null ? fecha.toLocalDateTime() : null);

        return movimiento;
    }
}