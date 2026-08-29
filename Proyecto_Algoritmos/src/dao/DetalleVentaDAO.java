package dao;

import conexion.Conexion;
import interfaces.IDetalleVentaDAO;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Venta;

public class DetalleVentaDAO implements IDetalleVentaDAO {

    @Override
    public void registrarDetalleVenta(DetalleVenta detalleVenta) throws Exception {
        String sql = """
                 INSERT INTO Detalle_Venta
                 (
                    id_venta,
                    id_producto,
                    cantidad,
                    precio_unitario,
                    precio_total
                 )
                 VALUES (?,?,?,?,?)
                 """;

        try (Connection conn = new Conexion().conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, detalleVenta.getVenta().getIdVenta());
            ps.setInt(2, detalleVenta.getProducto().getIdProducto());
            ps.setInt(3, detalleVenta.getCantidad());
            ps.setDouble(4, detalleVenta.getPrecioUnitario());
            ps.setDouble(5, detalleVenta.getPrecioTotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al registrar el detalle de venta: " + e.getMessage());
        }
    }
    
    @Override
    public List<DetalleVenta> buscarDetallesPorVenta(int idVenta) throws Exception {
        List<DetalleVenta> listaDetalleVenta = new ArrayList<>();
        String sql = """
                     SELECT dv.*, p.nombre AS nombre_producto
                     FROM Detalle_Venta dv
                     LEFT JOIN Producto p ON dv.id_producto = p.id_producto
                     WHERE dv.id_venta = ?
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {

            ps.setInt(1, idVenta);

            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    DetalleVenta detalle = mapearDetalleVenta(rs);
                    detalle.getProducto().setNombre(rs.getString("nombre_producto")); // solo aquí, por el JOIN
                    listaDetalleVenta.add(detalle);
                }
            }
            return listaDetalleVenta;
        } catch (SQLException e) {
            throw new Exception("Error al buscar el detalle venta por id venta:" + e.getMessage());
        }
    }
    
    public DetalleVenta mapearDetalleVenta (ResultSet rs) throws SQLException {
        DetalleVenta detalleVenta = new DetalleVenta();
        
        Venta venta = new Venta();
        venta.setIdVenta(rs.getInt("id_venta"));
        detalleVenta.setVenta(venta);
        
        Producto producto = new Producto();
        producto.setIdProducto(rs.getInt("id_producto"));
        detalleVenta.setProducto(producto);
        
        detalleVenta.setCantidad(rs.getInt("cantidad"));
        detalleVenta.setPrecioUnitario(rs.getDouble("precio_unitario"));
        detalleVenta.setPrecioTotal(rs.getDouble("precio_total"));
                
        return detalleVenta;
    }
    
}
