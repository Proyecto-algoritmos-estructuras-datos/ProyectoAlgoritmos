package dao;

import conexion.Conexion;
import interfaces.IProveedorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;

public class ProveedorDAO implements IProveedorDAO {

    // SELECT base compartido por las consultas de lectura
    private static final String SQL_SELECT_PROVEEDOR = """
                     SELECT
                         id_proveedor,
                         ruc,
                         razon_social,
                         contacto,
                         telefono,
                         correo,
                         direccion,
                         estado,
                         fecha_creacion,
                         fecha_modificacion
                     FROM proveedor
                     """;

    @Override
    public List<Proveedor> verTodosLosProveedores() throws Exception {
        List<Proveedor> listaProveedores = new ArrayList<>();
        String sql = SQL_SELECT_PROVEEDOR + """
                     ORDER BY razon_social
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                listaProveedores.add(mapearProveedor(rs));
            }
            return listaProveedores;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de los proveedores: " + e.getMessage());
        }
    }

    @Override
    public List<Proveedor> verProveedoresActivos() throws Exception {
        List<Proveedor> listaProveedores = new ArrayList<>();
        String sql = SQL_SELECT_PROVEEDOR + """
                     WHERE estado = 1
                     ORDER BY razon_social
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                listaProveedores.add(mapearProveedor(rs));
            }
            return listaProveedores;
        } catch (SQLException e) {
            throw new Exception("Error al cargar los proveedores activos: " + e.getMessage());
        }
    }

    // Devuelve el mismo proveedor con el id generado por la base de datos
    @Override
    public Proveedor registrarProveedor(Proveedor proveedor) throws Exception {
        String sql = """
                     INSERT INTO proveedor
                     (
                     ruc,
                     razon_social,
                     contacto,
                     telefono,
                     correo,
                     direccion
                     )
                     VALUES (?, ?, ?, ?, ?, ?)
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, proveedor.getRuc());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getContacto());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getCorreo());
            ps.setString(6, proveedor.getDireccion());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Exception("No se pudo registrar el proveedor!");
            }

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    proveedor.setIdProveedor(rs.getInt(1));
                } else {
                    throw new Exception("No se pudo obtener el id del proveedor registrado!");
                }
            }
            proveedor.setEstado(true);
            return proveedor;
        } catch (SQLException e) {
            throw new Exception("Error al registrar el proveedor: " + e.getMessage());
        }
    }

    private Proveedor mapearProveedor(ResultSet rs) throws SQLException {
        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(rs.getInt("id_proveedor"));
        proveedor.setRuc(rs.getString("ruc"));
        proveedor.setRazonSocial(rs.getString("razon_social"));
        proveedor.setContacto(rs.getString("contacto"));
        proveedor.setTelefono(rs.getString("telefono"));
        proveedor.setCorreo(rs.getString("correo"));
        proveedor.setDireccion(rs.getString("direccion"));
        proveedor.setEstado(rs.getBoolean("estado"));
        proveedor.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
        proveedor.setFechaModificacion(rs.getTimestamp("fecha_modificacion").toLocalDateTime());

        return proveedor;
    }

}