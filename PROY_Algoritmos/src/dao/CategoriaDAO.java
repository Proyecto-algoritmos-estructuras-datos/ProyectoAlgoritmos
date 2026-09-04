package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;
import interfaces.ICategoriaDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;

public class CategoriaDAO implements ICategoriaDAO{

    @Override
    public List<Categoria> verTodasLasCategorias() throws Exception {
        List<Categoria> listaCategorias = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM categoria
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            ) {
            while (rs.next()) {
                listaCategorias.add(mapearCategoria(rs));
            }
            return listaCategorias;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de las categorias: " + e.getMessage());
        }
    }

    @Override
    public void registrarCategoria(Categoria categoria) throws Exception {
        String sql = """
                     INSERT INTO categoria
                     (
                     nombre_categoria,
                     descripcion
                     )
                     VALUES (?, ?)
                     """;
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setString(1, categoria.getNombreCategoria());
            ps.setString(2, categoria.getDescripcion());
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new Exception("No se pudo registrar la categoria!");
            }
            
        } catch (SQLException e) {
            throw new Exception("Error al registrar la categoria: " + e.getMessage());
        }
    }

    @Override
    public void actualizarCategoria(Categoria categoria) throws Exception {
        String sql = """
                     UPDATE categoria
                     SET
                     nombre_categoria = ?,
                     descripcion = ?
                     WHERE id_categoria = ?
                     """;
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setString(1, categoria.getNombreCategoria());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, categoria.getIdCategoria());
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new Exception("No se encontró la categoria a actualizar!");
            }
        } catch (SQLException e) {
            throw new Exception("Error al actualizar la categoria: " + e.getMessage());
        }
    }

    @Override
    public void eliminarCategoria(Categoria categoria) throws Exception {
        String sql = """
                     UPDATE categoria
                     SET
                     estado = ?
                     WHERE id_categoria = ?
                     """;
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setBoolean(1, false);
            ps.setInt(2, categoria.getIdCategoria());
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new Exception("No se encontró la categoria a eliminar!");
            }
        } catch (SQLException e) {
            throw new Exception("Error al eliminar la categoria: " + e.getMessage());
        }
    }
    
    private Categoria mapearCategoria(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(rs.getInt("id_categoria"));
        categoria.setNombreCategoria(rs.getString("nombre_categoria"));
        categoria.setDescripcion(rs.getString("descripcion"));
        categoria.setEstado(rs.getBoolean("estado"));
        categoria.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
        categoria.setFechaModificacion(rs.getTimestamp("fecha_modificacion").toLocalDateTime());
        return categoria;
    }
}
