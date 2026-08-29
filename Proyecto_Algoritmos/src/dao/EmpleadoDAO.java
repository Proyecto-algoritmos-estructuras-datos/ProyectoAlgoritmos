package dao;

import conexion.Conexion;
import interfaces.IEmpleadoDAO;
import modelo.Empleado;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Types;
import utilidades.SQLUtils;

public class EmpleadoDAO implements IEmpleadoDAO{
    
    @Override
    public void registrarEmpleado(Empleado empleado) throws Exception {
        String sql = """
                     INSERT INTO Empleado
                     (
                        nombres,
                        apellidos,
                        dni,
                        contrasenia,
                        direccion,
                        telefono,
                        rol
                     )
                     VALUES (?, ?, ?, ?, ?, ? ,?)
                     """;
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, empleado.getNombres());
            ps.setString(2, empleado.getApellidos());
            ps.setString(3, empleado.getDni());
            ps.setString(4, empleado.getContrasenia());
            SQLUtils.setNullableString(ps, 5, empleado.getDireccion(), Types.VARCHAR);
            SQLUtils.setNullableString(ps, 6, empleado.getTelefono(), Types.VARCHAR);
            ps.setString(7, empleado.getRol());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al registrar empleado: " + e.getMessage());
        }
    }
    

    @Override
    public void actualizarEmpleado(Empleado empleado) throws Exception {
        String sql = """
                     UPDATE Empleado 
                     SET nombres = ?,
                     apellidos = ?,
                     dni = ?,
                     contrasenia = ?,
                     direccion = ?,
                     telefono = ?,
                     rol = ?
                     WHERE id_empleado = ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setString(1, empleado.getNombres());
            ps.setString(2, empleado.getApellidos());
            ps.setString(3, empleado.getDni());
            ps.setString(4, empleado.getContrasenia());
            SQLUtils.setNullableString(ps, 5, empleado.getDireccion(), Types.VARCHAR);
            SQLUtils.setNullableString(ps, 6, empleado.getTelefono(), Types.VARCHAR);
            ps.setString(7, empleado.getRol());
            ps.setInt(8, empleado.getIdEmpleado());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al actualizar empleado: " + e.getMessage());
        }
    }

    @Override
    public void cambiarEstadoEmpleado(int idEmpleado, boolean activo) throws Exception {
        String sql = """
                     UPDATE Empleado 
                     SET activo = ?
                     WHERE id_empleado = ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setBoolean(1, activo);
            ps.setInt(2, idEmpleado);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al cambiar el estado del empleado: " + e.getMessage());
        }
    }

    @Override
    public List<Empleado> verTodosLosEmpleados() throws Exception {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM Empleado
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
            throw new Exception("Error al cargar la lista de los empleado: " + e.getMessage());
        }
    }

    @Override
    public List<Empleado> verEmpleadosPorEstado(boolean activo) throws Exception {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM Empleado
                     WHERE activo = ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setBoolean(1, activo);
            
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    listaEmpleados.add(mapearEmpleado(rs));
                }
            }
            
            return listaEmpleados;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de los empleado filtrados por estado: " + e.getMessage());
        }
    }

    @Override
    public Empleado buscarEmpleadoPorID(int id) throws Exception {
        Empleado empleado = null;
        
        String sql = """
                     SELECT *
                     FROM Empleado
                     WHERE id_empleado = ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    empleado = mapearEmpleado(rs);
                }
            }
            
            return empleado;
        } catch (SQLException e) {
            throw new Exception("Error al buscar el empleado por ID: " + e.getMessage());
        }
    }

    @Override
    public Empleado buscarEmpleadoPorDNI(String dni) throws Exception {
        Empleado empleado = null;
        
        String sql = """
                     SELECT *
                     FROM Empleado
                     WHERE dni = ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setString(1, dni);
            
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    empleado = mapearEmpleado(rs);
                }
            }
            
            return empleado;
        } catch (SQLException e) {
            throw new Exception("Error al buscar el empleado por DNI: " + e.getMessage());
        }
    }

    @Override
    public List<Empleado> buscarEmpleadoPorNombre(String nombre) throws Exception {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM Empleado
                     WHERE nombres LIKE ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setString(1, "%" + nombre + "%");
            
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    listaEmpleados.add(mapearEmpleado(rs));
                }
            }
            
            return listaEmpleados;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de los empleado filtrados por nombre: " + e.getMessage());
        }
    }

    @Override
    public Empleado iniciarSesionEmpleado(String dni, String contrasenia) throws Exception {
        Empleado empleado = null;
        
        String sql = """
                     SELECT *
                     FROM Empleado
                     WHERE dni = ? AND contrasenia = ? AND activo = TRUE
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setString(1, dni);
            ps.setString(2, contrasenia);
            
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    empleado = mapearEmpleado(rs);
                }
            }
            
            return empleado;
        } catch (SQLException e) {
            throw new Exception("Error al Iniciar Sesion: " + e.getMessage());
        }
    }
    
    private Empleado mapearEmpleado(ResultSet rs) throws SQLException {
        Empleado empleado = new Empleado();

        empleado.setIdEmpleado(rs.getInt("id_empleado"));
        empleado.setNombres(rs.getString("nombres"));
        empleado.setApellidos(rs.getString("apellidos"));
        empleado.setDni(rs.getString("dni"));
        empleado.setContrasenia(rs.getString("contrasenia"));
        empleado.setDireccion(rs.getString("direccion"));
        empleado.setTelefono(rs.getString("telefono"));
        empleado.setRol(rs.getString("rol"));
        empleado.setActivo(rs.getBoolean("activo"));
        empleado.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
        empleado.setFechaModificacion(rs.getTimestamp("fecha_modificacion").toLocalDateTime());

        return empleado;
    }

}
