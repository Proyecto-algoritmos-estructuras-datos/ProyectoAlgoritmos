package dao;

import conexion.Conexion;
import interfaces.IVentaDAO;
import java.time.LocalDate;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Types;
import java.util.ArrayList;
import modelo.Caja;
import modelo.Empleado;
import modelo.Venta;
import utilidades.SQLUtils;

public class VentaDAO implements IVentaDAO {

    @Override
    public void registrarVenta(Venta venta) throws Exception {
        String sql = """
                     INSERT INTO Venta
                     (
                        id_empleado,
                        id_caja,
                        id_cliente,
                        tipo_despacho,
                        nota_adicional,
                        subtotal_venta,
                        igv_venta,
                        total_venta,
                        metodo_pago
                     )
                     VALUES (?,?,?,?,?,?,?,?,?)
                     """;
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ) {
            ps.setInt(1, venta.getEmpleado().getIdEmpleado());
            ps.setInt(2, venta.getCaja().getIdCaja());
            if (venta.getCliente() != null) {
                ps.setInt(3, venta.getCliente().getIdCliente());
            } else {
                ps.setNull(3, Types.INTEGER);
            }
            ps.setString(4, venta.getTipoDespacho());
            SQLUtils.setNullableString(ps, 5, venta.getNotaAdicional(), Types.VARCHAR);
            ps.setDouble(6, venta.getSubtotalVenta());
            ps.setDouble(7, venta.getIgvVenta());
            ps.setDouble(8, venta.getTotalVenta());
            ps.setString(9, venta.getMetodoPago());
            ps.executeUpdate();
            
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    venta.setIdVenta(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al registrar venta: " + e.getMessage());
        }
    }

    @Override
    public List<Venta> verTodasLasVentas() throws Exception {
        List<Venta> listaVentas = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM Venta
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            ) {
                
            while (rs.next()) {
                listaVentas.add(mapearVenta(rs));
            }
            return listaVentas;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de las ventas: " + e.getMessage());
        }
    }

    @Override
    public Venta buscarVentaPorID(int id) throws Exception {
        Venta venta = null;
        
        String sql = """
                     SELECT *
                     FROM Venta
                     WHERE id_venta = ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    venta = mapearVenta(rs);
                }
            }
            
            return venta;
        } catch (SQLException e) {
            throw new Exception("Error al buscar la venta por ID: " + e.getMessage());
        }
    }
    
    @Override
    public List<Venta> listarConFiltros(LocalDate fechaInicio, LocalDate fechaFinal, String tipoDespacho, String metodoPago) throws Exception {
        List<Venta> listaVentas = new ArrayList<>();
        StringBuilder sql = new StringBuilder("""
            SELECT v.*, e.nombres AS nombre_empleado
            FROM Venta v
            LEFT JOIN Empleado e ON v.id_empleado = e.id_empleado
            WHERE 1=1
            """);
        List<Object> parametros = new ArrayList<>();

        if (fechaInicio != null && fechaFinal != null) {
            sql.append(" AND v.fecha_venta BETWEEN ? AND ?");
            parametros.add(java.sql.Date.valueOf(fechaInicio));
            parametros.add(java.sql.Date.valueOf(fechaFinal));
        }

        if (tipoDespacho != null && !tipoDespacho.equalsIgnoreCase("Todos")) {
            sql.append(" AND v.tipo_despacho = ?");
            parametros.add(tipoDespacho);
        }

        if (metodoPago != null && !metodoPago.equalsIgnoreCase("Todos")) {
            sql.append(" AND v.metodo_pago = ?");
            parametros.add(metodoPago);
        }

        sql.append(" ORDER BY v.fecha_venta DESC, v.hora_venta DESC");

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < parametros.size(); i++) {
                ps.setObject(i + 1, parametros.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Venta venta = mapearVenta(rs);
                    venta.getEmpleado().setNombres(rs.getString("nombre_empleado"));
                    listaVentas.add(venta);
                }
            }

            return listaVentas;

        } catch (SQLException e) {
            throw new Exception("Error al filtrar ventas: " + e.getMessage());
        }
    }
    
    @Override
    public double sumarVentasPorCaja(int idCaja) throws Exception {
        double total = 0;

        String sql = """
                 SELECT COALESCE(SUM(total_venta), 0) AS total_ventas
                 FROM Venta
                 WHERE id_caja = ? AND metodo_pago = 'Efectivo'
                 """;

        try (Connection conn = new Conexion().conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setInt(1, idCaja);

            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    total = rs.getDouble("total_ventas");
                }
            }

            return total;
        } catch (SQLException e) {
            throw new Exception("Error al sumar las ventas de la caja: " + e.getMessage());
        }
    }
    
    private Venta mapearVenta(ResultSet rs) throws SQLException {
        Venta venta = new Venta();
        venta.setIdVenta(rs.getInt("id_venta"));

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(rs.getInt("id_empleado"));
        venta.setEmpleado(empleado);

        Caja caja = new Caja();
        caja.setIdCaja(rs.getInt("id_caja"));
        venta.setCaja(caja);

        venta.setFechaVenta(rs.getDate("fecha_venta").toLocalDate());
        venta.setHoraVenta(rs.getTime("hora_venta").toLocalTime());
        venta.setTipoDespacho(rs.getString("tipo_despacho"));
        venta.setNotaAdicional(rs.getString("nota_adicional"));

        venta.setSubtotalVenta(rs.getDouble("subtotal_venta"));
        venta.setIgvVenta(rs.getDouble("igv_venta"));
        venta.setTotalVenta(rs.getDouble("total_venta"));
        venta.setMetodoPago(rs.getString("metodo_pago"));

        return venta;
    }
}
