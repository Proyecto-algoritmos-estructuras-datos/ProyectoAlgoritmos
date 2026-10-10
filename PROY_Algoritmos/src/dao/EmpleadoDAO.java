package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;
import interfaces.IEmpleadoDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;
import modelo.Rol;

public class EmpleadoDAO implements IEmpleadoDAO {

    @Override
    public List<Empleado> verTodosLosEmpleados() throws Exception {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM empleado
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            ) {
            while (rs.next()) {
                listaEmpleados.add(mapearEmpleado(rs));
            }
            return listaEmpleados;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de los empleados: " + e.getMessage());
        }
    }

    @Override
    public void registrarEmpleado(Empleado empleado) throws Exception {
        String sql = """
                     INSERT INTO empleado
                     (
                     dni,
                     nombres,
                     apellidos,
                     correo,
                     telefono,
                     rol,
                     usuario,
                     contrasena
                     )
                     VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setString(1, empleado.getDni());
            ps.setString(2, empleado.getNombres());
            ps.setString(3, empleado.getApellidos());
            ps.setString(4, empleado.getCorreo());
            ps.setString(5, empleado.getTelefono());
            ps.setString(6, empleado.getRol().name());
            ps.setString(7, empleado.getUsuario());
            ps.setString(8, empleado.getContrasena()); // texto plano en este avance

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Exception("No se pudo registrar el empleado!");
            }
        } catch (SQLException e) {
            throw new Exception("Error al registrar el empleado: " + e.getMessage());
        }
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) throws Exception {
        String sql = """
                     UPDATE empleado
                     SET
                     dni = ?,
                     nombres = ?,
                     apellidos = ?,
                     correo = ?,
                     telefono = ?,
                     rol = ?,
                     usuario = ?,
                     contrasena = ?
                     WHERE id_empleado = ?
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setString(1, empleado.getDni());
            ps.setString(2, empleado.getNombres());
            ps.setString(3, empleado.getApellidos());
            ps.setString(4, empleado.getCorreo());
            ps.setString(5, empleado.getTelefono());
            ps.setString(6, empleado.getRol().name());
            ps.setString(7, empleado.getUsuario());
            ps.setString(8, empleado.getContrasena());
            ps.setInt(9, empleado.getIdEmpleado());

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Exception("No se encontró el empleado a actualizar!");
            }
        } catch (SQLException e) {
            throw new Exception("Error al actualizar el empleado: " + e.getMessage());
        }
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) throws Exception {
        cambiarEstado(empleado.getIdEmpleado(), false, "eliminar");
    }

    @Override
    public void reactivarEmpleado(Empleado empleado) throws Exception {
        cambiarEstado(empleado.getIdEmpleado(), true, "reactivar");
    }

    @Override
    public Empleado buscarEmpleadoPorId(int idEmpleado) throws Exception {
        return buscarUno("id_empleado = ?", idEmpleado);
    }

    @Override
    public Empleado buscarEmpleadoPorDni(String dni) throws Exception {
        return buscarUno("dni = ?", dni);
    }

    @Override
    public Empleado buscarEmpleadoPorUsuario(String usuario) throws Exception {
        return buscarUno("usuario = ?", usuario);
    }

    @Override
    public Empleado autenticarEmpleado(String dni, String contrasena) throws Exception {
        // Se busca solo por dni (activo) y la contraseña se compara en Java con equals().
        // Si se comparara en el SQL, MySQL (collation _ci) ignoraría mayúsculas/minúsculas.
        // TODO: en un avance posterior, aquí se cambiará a comparar con hash.
        Empleado empleado = buscarUno("dni = ? AND estado = 1", dni);
        if (empleado != null && empleado.getContrasena().equals(contrasena)) {
            return empleado;
        }
        return null;
    }

    private Empleado buscarUno(String condicion, Object valor) throws Exception {
        String sql = "SELECT * FROM empleado WHERE " + condicion;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setObject(1, valor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearEmpleado(rs);
                }
                return null;
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar el empleado: " + e.getMessage());
        }
    }

    private void cambiarEstado(int idEmpleado, boolean estado, String accion) throws Exception {
        String sql = """
                     UPDATE empleado
                     SET estado = ?
                     WHERE id_empleado = ?
                     """;

        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setBoolean(1, estado);
            ps.setInt(2, idEmpleado);

            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new Exception("No se encontró el empleado a " + accion + "!");
            }
        } catch (SQLException e) {
            throw new Exception("Error al " + accion + " el empleado: " + e.getMessage());
        }
    }

    private Empleado mapearEmpleado(ResultSet rs) throws SQLException {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(rs.getInt("id_empleado"));
        empleado.setDni(rs.getString("dni"));
        empleado.setNombres(rs.getString("nombres"));
        empleado.setApellidos(rs.getString("apellidos"));
        empleado.setCorreo(rs.getString("correo"));
        empleado.setTelefono(rs.getString("telefono"));
        empleado.setRol(Rol.valueOf(rs.getString("rol")));
        empleado.setUsuario(rs.getString("usuario"));
        empleado.setContrasena(rs.getString("contrasena"));
        empleado.setEstado(rs.getBoolean("estado"));
        empleado.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
        empleado.setFechaModificacion(rs.getTimestamp("fecha_modificacion").toLocalDateTime());
        return empleado;
    }
}