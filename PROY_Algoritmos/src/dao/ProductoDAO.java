package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;
import interfaces.IProductoDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import modelo.Marca;
import modelo.Producto;

public class ProductoDAO implements IProductoDAO {

    @Override
    public List<Producto> verTodosLosProductos() throws Exception {
        List<Producto> listaProductos = new ArrayList<>();
        String sql = """
                     SELECT
                         p.id_producto,
                         p.nombre_producto,
                         p.precio,
                         p.stock,
                         p.estado,
                         p.fecha_creacion,
                         p.fecha_modificacion,
                         c.id_categoria,
                         c.nombre_categoria,
                         c.descripcion AS descripcion_categoria,
                         c.estado AS estado_categoria,
                         c.fecha_creacion AS fecha_creacion_categoria,
                         c.fecha_modificacion AS fecha_modificacion_categoria,
                         m.id_marca,
                         m.nombre_marca,
                         m.descripcion AS descripcion_marca,
                         m.pais_origen,
                         m.estado AS estado_marca,
                         m.fecha_creacion AS fecha_creacion_marca,
                         m.fecha_modificacion AS fecha_modificacion_marca
                     FROM producto p
                     INNER JOIN categoria c ON p.id_categoria = c.id_categoria
                     INNER JOIN marca m ON p.id_marca = m.id_marca
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            ) {
            while (rs.next()) {
                listaProductos.add(mapearProducto(rs));
            }
            return listaProductos;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de los productos: " + e.getMessage());
        }
    }

    @Override
    public void registrarProducto(Producto producto) throws Exception {
        String sql = """
                     INSERT INTO producto
                     (
                     nombre_producto,
                     id_categoria,
                     id_marca,
                     precio,
                     stock
                     )
                     VALUES (?, ?, ?, ?, ?)
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setString(1, producto.getNombreProducto());
            ps.setInt(2, producto.getCategoria().getIdCategoria());
            ps.setInt(3, producto.getMarca().getIdMarca());
            ps.setBigDecimal(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Exception("No se pudo registrar el producto!");
            }
        } catch (SQLException e) {
            throw new Exception("Error al registrar el producto: " + e.getMessage());
        }
    }

    @Override
    public void actualizarProducto(Producto producto) throws Exception {
        String sql = """
                     UPDATE producto
                     SET
                     nombre_producto = ?,
                     id_categoria = ?,
                     id_marca = ?,
                     precio = ?,
                     stock = ?
                     WHERE id_producto = ?
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setString(1, producto.getNombreProducto());
            ps.setInt(2, producto.getCategoria().getIdCategoria());
            ps.setInt(3, producto.getMarca().getIdMarca());
            ps.setBigDecimal(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());
            ps.setInt(6, producto.getIdProducto());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Exception("No se encontró el producto a actualizar!");
            }
        } catch (SQLException e) {
            throw new Exception("Error al actualizar el producto: " + e.getMessage());
        }
    }

    @Override
    public void eliminarProducto(Producto producto) throws Exception {
        String sql = """
                     UPDATE producto
                     SET estado = ?
                     WHERE id_producto = ?
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setBoolean(1, false);
            ps.setInt(2, producto.getIdProducto());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Exception("No se encontró el producto a eliminar!");
            }
        } catch (SQLException e) {
            throw new Exception("Error al eliminar el producto: " + e.getMessage());
        }
    }
    
    private Producto mapearProducto(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(rs.getInt("id_categoria"));
        categoria.setNombreCategoria(rs.getString("nombre_categoria"));
        categoria.setDescripcion(rs.getString("descripcion_categoria"));
        categoria.setEstado(rs.getBoolean("estado_categoria"));
        categoria.setFechaCreacion(rs.getTimestamp("fecha_creacion_categoria").toLocalDateTime());
        categoria.setFechaModificacion(rs.getTimestamp("fecha_modificacion_categoria").toLocalDateTime());

        Marca marca = new Marca();
        marca.setIdMarca(rs.getInt("id_marca"));
        marca.setNombreMarca(rs.getString("nombre_marca"));
        marca.setDescripcion(rs.getString("descripcion_marca"));
        marca.setPaisOrigen(rs.getString("pais_origen"));
        marca.setEstado(rs.getBoolean("estado_marca"));
        marca.setFechaCreacion(rs.getTimestamp("fecha_creacion_marca").toLocalDateTime());
        marca.setFechaModificacion(rs.getTimestamp("fecha_modificacion_marca").toLocalDateTime());

        Producto producto = new Producto();
        producto.setIdProducto(rs.getInt("id_producto"));
        producto.setNombreProducto(rs.getString("nombre_producto"));
        producto.setCategoria(categoria);
        producto.setMarca(marca);
        producto.setPrecio(rs.getBigDecimal("precio"));
        producto.setStock(rs.getInt("stock"));
        producto.setEstado(rs.getBoolean("estado"));
        producto.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
        producto.setFechaModificacion(rs.getTimestamp("fecha_modificacion").toLocalDateTime());

        return producto;
    }
    
}
