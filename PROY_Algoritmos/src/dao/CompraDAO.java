package dao;

import conexion.Conexion;
import interfaces.ICompraDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Compra;
import modelo.DetalleCompra;
import modelo.Empleado;
import modelo.EstadoCompra;
import modelo.Producto;
import modelo.Proveedor;
import modelo.TipoMovimiento;

public class CompraDAO implements ICompraDAO {

    // Guarda la cabecera y todos los detalles en una sola transacción.
    // Si algo falla no queda nada guardado. No toca stock ni kardex: eso
    // lo hace el módulo de compras en espera cuando la compra se recibe.
    @Override
    public Compra registrarCompra(Compra compra) throws Exception {
        String sqlCompra = """
                           INSERT INTO compra
                           (
                           id_proveedor,
                           id_empleado,
                           total,
                           estado
                           )
                           VALUES (?, ?, ?, ?)
                           """;
        String sqlDetalle = """
                            INSERT INTO detalle_compra
                            (
                            id_compra,
                            id_producto,
                            cantidad,
                            precio_unitario
                            )
                            VALUES (?, ?, ?, ?)
                            """;

        // Aquí no se usa try-with-resources para la conexión porque hay que controlar
        // commit, rollback y restaurar el autoCommit a mano.
        Connection conn = null;
        try {
            conn = new Conexion().conectar();
            conn.setAutoCommit(false);

            int idCompra;

            // 1) Cabecera: estado PENDIENTE y fecha_recepcion queda en NULL
            try (PreparedStatement psCompra = conn.prepareStatement(sqlCompra, Statement.RETURN_GENERATED_KEYS)) {
                psCompra.setInt(1, compra.getProveedor().getIdProveedor());
                psCompra.setInt(2, compra.getEmpleado().getIdEmpleado());
                psCompra.setBigDecimal(3, compra.getTotal());
                psCompra.setString(4, compra.getEstado().name());

                int filas = psCompra.executeUpdate();
                if (filas == 0) {
                    throw new Exception("No se pudo registrar la compra!");
                }

                try (ResultSet rs = psCompra.getGeneratedKeys()) {
                    if (rs.next()) {
                        idCompra = rs.getInt(1);
                    } else {
                        throw new Exception("No se pudo obtener el id de la compra registrada!");
                    }
                }
            }

            // 2) Detalles (el subtotal lo calcula MySQL, es una columna generada)
            try (PreparedStatement psDetalle = conn.prepareStatement(sqlDetalle)) {
                for (DetalleCompra detalle : compra.getDetalles()) {
                    psDetalle.setInt(1, idCompra);
                    psDetalle.setInt(2, detalle.getProducto().getIdProducto());
                    psDetalle.setInt(3, detalle.getCantidad());
                    psDetalle.setBigDecimal(4, detalle.getPrecioUnitario());
                    psDetalle.executeUpdate();
                }
            }

            conn.commit();

            // Solo después del commit se actualizan los objetos en memoria
            compra.setIdCompra(idCompra);
            for (DetalleCompra detalle : compra.getDetalles()) {
                detalle.setIdCompra(idCompra);
            }
            return compra;

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    // si el rollback falla, igual se informa el error original
                }
            }
            throw new Exception("No se guardó la compra. Error al registrar la compra: " + e.getMessage());
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

    // Compras PENDIENTE en orden de registro: las más antiguas primero.
    // El id_compra desempata cuando dos compras tienen la misma fecha.
    @Override
    public List<Compra> verPendientes() throws Exception {
        List<Compra> listaCompras = new ArrayList<>();
        String sql = """
                     SELECT
                     c.id_compra,
                     c.fecha_compra,
                     c.total,
                     p.id_proveedor,
                     p.razon_social
                     FROM compra c
                     INNER JOIN proveedor p ON c.id_proveedor = p.id_proveedor
                     WHERE c.estado = 'PENDIENTE'
                     ORDER BY c.fecha_compra, c.id_compra
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            ) {
            while (rs.next()) {
                // Proveedor "parcial": solo los datos que muestra la cola
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("id_proveedor"));
                proveedor.setRazonSocial(rs.getString("razon_social"));

                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("id_compra"));
                compra.setProveedor(proveedor);
                compra.setFechaCompra(rs.getTimestamp("fecha_compra").toLocalDateTime());
                compra.setTotal(rs.getBigDecimal("total"));
                compra.setEstado(EstadoCompra.PENDIENTE);
                listaCompras.add(compra);
            }
            return listaCompras;
        } catch (SQLException e) {
            throw new Exception("Error al cargar las compras pendientes: " + e.getMessage());
        }
    }

    @Override
    public List<DetalleCompra> verDetalle(int idCompra) throws Exception {
        List<DetalleCompra> listaDetalles = new ArrayList<>();
        String sql = """
                     SELECT
                     d.id_detalle_compra,
                     d.id_compra,
                     d.cantidad,
                     d.precio_unitario,
                     p.id_producto,
                     p.codigo,
                     p.nombre_producto
                     FROM detalle_compra d
                     INNER JOIN producto p ON d.id_producto = p.id_producto
                     WHERE d.id_compra = ?
                     ORDER BY d.id_detalle_compra
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setInt(1, idCompra);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setIdProducto(rs.getInt("id_producto"));
                    producto.setCodigo(rs.getString("codigo"));
                    producto.setNombreProducto(rs.getString("nombre_producto"));

                    listaDetalles.add(new DetalleCompra(
                            rs.getInt("id_detalle_compra"),
                            rs.getInt("id_compra"),
                            producto,
                            rs.getInt("cantidad"),
                            rs.getBigDecimal("precio_unitario")));
                }
            }
            return listaDetalles;
        } catch (SQLException e) {
            throw new Exception("Error al cargar el detalle de la compra: " + e.getMessage());
        }
    }

    // Recibe la compra del frente de la cola en UNA sola transacción:
    // estado RECIBIDA + stock + precio_compra + movimiento ENTRADA en el kardex.
    // Si algo falla se hace rollback y la compra sigue PENDIENTE.
    @Override
    public void recibirCompra(int idCompra, Empleado empleado) throws Exception {
        String sqlRecibir = """
                            UPDATE compra
                            SET estado = 'RECIBIDA', fecha_recepcion = NOW()
                            WHERE id_compra = ? AND estado = 'PENDIENTE'
                            """;

        // No se usa try-with-resources para la conexión porque hay que controlar
        // commit, rollback y restaurar el autoCommit a mano.
        Connection conn = null;
        try {
            conn = new Conexion().conectar();
            conn.setAutoCommit(false);

            // 1) Cambiar el estado. Si no afecta filas, la compra ya fue atendida o anulada.
            try (PreparedStatement ps = conn.prepareStatement(sqlRecibir)) {
                ps.setInt(1, idCompra);
                if (ps.executeUpdate() == 0) {
                    throw new Exception("La compra N° " + idCompra + " ya fue atendida o anulada.");
                }
            }

            // 2) Leer todas las líneas antes de modificar nada
            List<DetalleCompra> lineas = leerLineasParaRecibir(conn, idCompra);
            if (lineas.isEmpty()) {
                throw new Exception("La compra N° " + idCompra + " no tiene productos.");
            }

            // 3) Por cada línea: stock, precio_compra y kardex
            for (DetalleCompra linea : lineas) {
                sumarStockYRegistrarEntrada(conn, idCompra, linea, empleado);
            }

            conn.commit();

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    // si el rollback falla, igual se informa el error original
                }
            }
            throw new Exception("No se recibió la compra. " + e.getMessage());
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

    // Líneas de la compra, ordenadas por producto para bloquear siempre en el mismo orden
    private List<DetalleCompra> leerLineasParaRecibir(Connection conn, int idCompra) throws SQLException {
        List<DetalleCompra> lineas = new ArrayList<>();
        String sql = """
                     SELECT id_producto, cantidad, precio_unitario
                     FROM detalle_compra
                     WHERE id_compra = ?
                     ORDER BY id_producto
                     """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCompra);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setIdProducto(rs.getInt("id_producto"));
                    lineas.add(new DetalleCompra(
                            producto,
                            rs.getInt("cantidad"),
                            rs.getBigDecimal("precio_unitario")));
                }
            }
        }
        return lineas;
    }

    // Usa la MISMA conexión (y por tanto la misma transacción) de recibirCompra.
    // No hace commit ni rollback: eso lo decide recibirCompra.
    private void sumarStockYRegistrarEntrada(Connection conn, int idCompra,
            DetalleCompra linea, Empleado empleado) throws Exception {
        String sqlBloquear = """
                             SELECT stock
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
                               motivo,
                               id_compra
                               )
                               VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                               """;
        String sqlProducto = """
                             UPDATE producto
                             SET stock = ?, precio_compra = ?
                             WHERE id_producto = ?
                             """;

        int idProducto = linea.getProducto().getIdProducto();

        // El stock anterior sale de la BD (bloqueando la fila), no de la pantalla
        int stockAnterior;
        try (PreparedStatement ps = conn.prepareStatement(sqlBloquear)) {
            ps.setInt(1, idProducto);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    throw new Exception("El producto con id " + idProducto + " ya no existe!");
                }
                stockAnterior = rs.getInt("stock");
            }
        }
        int stockNuevo = stockAnterior + linea.getCantidad();

        // Movimiento ENTRADA en el kardex
        try (PreparedStatement ps = conn.prepareStatement(sqlMovimiento)) {
            ps.setInt(1, idProducto);
            ps.setInt(2, empleado.getIdEmpleado());
            ps.setString(3, TipoMovimiento.ENTRADA.name());
            ps.setInt(4, linea.getCantidad());
            ps.setInt(5, stockAnterior);
            ps.setInt(6, stockNuevo);
            ps.setString(7, "Recepción de compra " + idCompra);
            ps.setInt(8, idCompra);
            ps.executeUpdate();
        }

        // Stock y precio de costo real (el de la compra, no el sugerido)
        try (PreparedStatement ps = conn.prepareStatement(sqlProducto)) {
            ps.setInt(1, stockNuevo);
            ps.setBigDecimal(2, linea.getPrecioUnitario());
            ps.setInt(3, idProducto);
            ps.executeUpdate();
        }
    }

}
