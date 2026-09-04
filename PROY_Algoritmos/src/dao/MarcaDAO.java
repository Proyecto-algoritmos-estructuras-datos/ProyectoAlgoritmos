package dao;

import conexion.Conexion;
import interfaces.IMarcaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Marca;

public class MarcaDAO implements IMarcaDAO{

    @Override
    public List<Marca> verTodasLasMarcas() throws Exception {
        List<Marca> listaMarcas = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM marca
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            ) {
            while (rs.next()) {
                listaMarcas.add(mapearMarca(rs));
            }
            return listaMarcas;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de las marcas: " + e.getMessage());
        }
    }

    @Override
    public void registrarMarca(Marca marca) throws Exception {
        String sql = """
                     INSERT INTO marca
                     (
                     nombre_marca,
                     descripcion,
                     pais_origen
                     )
                     VALUES (?, ?, ?)
                     """;
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setString(1, marca.getNombreMarca());
            ps.setString(2, marca.getDescripcion());
            ps.setString(3, marca.getPaisOrigen());
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new Exception("No se pudo registrar la marca!");
            }
            
        } catch (SQLException e) {
            throw new Exception("Error al registrar la marca: " + e.getMessage());
        }
    }

    @Override
    public void actualizarMarca(Marca marca) throws Exception {
        String sql = """
                     UPDATE marca
                     SET
                     nombre_marca = ?,
                     descripcion = ?,
                     pais_origen = ?
                     WHERE id_marca = ?
                     """;
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setString(1, marca.getNombreMarca());
            ps.setString(2, marca.getDescripcion());
            ps.setString(3, marca.getPaisOrigen());
            ps.setInt(4, marca.getIdMarca());
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new Exception("No se encontró la marca a actualizar!");
            }
        } catch (SQLException e) {
            throw new Exception("Error al actualizar la marca: " + e.getMessage());
        }
    }

    @Override
    public void eliminarMarca(Marca marca) throws Exception {
        String sql = """
                     UPDATE marca
                     SET
                     estado = ?
                     WHERE id_marca = ?
                     """;
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setBoolean(1, false);
            ps.setInt(2, marca.getIdMarca());
            
            int filas = ps.executeUpdate();
            
            if (filas == 0) {
                throw new Exception("No se encontró la marca a eliminar!");
            }
        } catch (SQLException e) {
            throw new Exception("Error al eliminar la marca: " + e.getMessage());
        }
    }
    
    private Marca mapearMarca(ResultSet rs) throws SQLException {
        Marca marca = new Marca();
        marca.setIdMarca(rs.getInt("id_marca"));
        marca.setNombreMarca(rs.getString("nombre_marca"));
        marca.setDescripcion(rs.getString("descripcion"));
        marca.setPaisOrigen(rs.getString("pais_origen"));
        marca.setEstado(rs.getBoolean("estado"));
        marca.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
        marca.setFechaModificacion(rs.getTimestamp("fecha_modificacion").toLocalDateTime());
        return marca;
    }
    
}
