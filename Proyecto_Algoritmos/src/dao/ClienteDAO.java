package dao;

import conexion.Conexion;
import interfaces.IClienteDAO;
import modelo.Cliente;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Types;
import utilidades.SQLUtils;

public class ClienteDAO implements IClienteDAO {

    @Override
    public void registrarCliente(Cliente cliente) throws Exception {
        String sql = """
                     INSERT INTO Cliente
                     (
                     nombre,
                     dni,
                     direccion,
                     telefono
                     )
                     VALUES (?,?,?,?)
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setString(1, cliente.getNombre());
            SQLUtils.setNullableString(ps, 2, cliente.getDni(), Types.CHAR);
            SQLUtils.setNullableString(ps, 3, cliente.getDireccion(), Types.VARCHAR);
            SQLUtils.setNullableString(ps, 4, cliente.getTelefono(), Types.VARCHAR);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al registrar al cliente: " + e.getMessage());
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) throws Exception {
        String sql = """
                     UPDATE Cliente
                     SET 
                     nombre = ?,
                     dni = ?,
                     direccion = ?,
                     telefono = ?
                     WHERE id_cliente = ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {

            ps.setString(1, cliente.getNombre());
            SQLUtils.setNullableString(ps, 2, cliente.getDni(), Types.CHAR);
            SQLUtils.setNullableString(ps, 3, cliente.getDireccion(), Types.VARCHAR);
            SQLUtils.setNullableString(ps, 4, cliente.getTelefono(), Types.VARCHAR);
            ps.setInt(5, cliente.getIdCliente());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al actualizar al cliente: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> verTodosLosClientes() throws Exception {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM Cliente
                     """;
        
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
            ) {
            
            while (rs.next()) {
                listaClientes.add(mapearCliente(rs));
            }
            return listaClientes;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de los empleado: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> verClientesPorEstado(boolean activo) throws Exception {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = """
                     SELECT *
                     FROM Cliente
                     WHERE activo = ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setBoolean(1, activo);
            
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    listaClientes.add(mapearCliente(rs));
                }
            }
            
            return listaClientes;
        } catch (SQLException e) {
            throw new Exception("Error al cargar la lista de los clientes filtrados por estado: " + e.getMessage());
        }
    }

    @Override
    public void cambiarEstadoCliente(int idCliente, boolean activo) throws Exception {
        String sql = """
                     UPDATE Cliente 
                     SET activo = ?
                     WHERE id_cliente = ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            ps.setBoolean(1, activo);
            ps.setInt(2, idCliente);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("Error al cambiar el estado del cliente: " + e.getMessage());
        }
    }

    @Override
    public Cliente buscarClientePorID(int id) throws Exception {
        Cliente cliente = null;
        
        String sql = """
                     SELECT *
                     FROM Cliente
                     WHERE id_cliente = ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    cliente = mapearCliente(rs);
                }
            }
            
            return cliente;
        } catch (SQLException e) {
            throw new Exception("Error al buscar el cliente por ID: " + e.getMessage());
        }
    }

    @Override
    public Cliente buscarClientePorDNI(String dni) throws Exception {
        Cliente cliente = null;
        
        String sql = """
                     SELECT *
                     FROM Cliente
                     WHERE dni = ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setString(1, dni);
            
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    cliente = mapearCliente(rs);
                }
            }
            
            return cliente;
        } catch (SQLException e) {
            throw new Exception("Error al buscar el cliente por DNI: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> buscarClientePorTelefono(String telefono) throws Exception {
        List<Cliente> listaClientes = new ArrayList<>();
        
        String sql = """
                     SELECT *
                     FROM Cliente
                     WHERE telefono LIKE ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setString(1, "%" + telefono + "%");
            
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    listaClientes.add(mapearCliente(rs));
                }
            }
            
            return listaClientes;
        } catch (SQLException e) {
            throw new Exception("Error al buscar el cliente por telefono: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> buscarClientePorNombre(String nombre) throws Exception {
        List<Cliente> listaClientes = new ArrayList<>();
        
        String sql = """
                     SELECT *
                     FROM Cliente
                     WHERE nombre LIKE ?
                     """;
        try (Connection conn = new Conexion().conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
            ) {
            
            ps.setString(1, "%" + nombre + "%");
            
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    listaClientes.add(mapearCliente(rs));
                }
            }
            
            return listaClientes;
        } catch (SQLException e) {
            throw new Exception("Error al buscar el cliente por nombre: " + e.getMessage());
        }
    }
    
    private Cliente mapearCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();

        cliente.setIdCliente(rs.getInt("id_cliente"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setDni(rs.getString("dni"));
        cliente.setDireccion(rs.getString("direccion"));
        cliente.setTelefono(rs.getString("telefono"));
        cliente.setActivo(rs.getBoolean("activo"));
        cliente.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
        cliente.setFechaModificacion(rs.getTimestamp("fecha_modificacion").toLocalDateTime());

        return cliente;
    }
    
}
