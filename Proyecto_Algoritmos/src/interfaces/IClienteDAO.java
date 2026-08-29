package interfaces;

import java.util.List;
import modelo.Cliente;

// No implementado aún
public interface IClienteDAO {
    void registrarCliente(Cliente cliente) throws Exception;
    void actualizarCliente(Cliente cliente) throws Exception;
    
    List<Cliente> verTodosLosClientes() throws Exception;
    List<Cliente> verClientesPorEstado(boolean activo) throws Exception;
    
    void cambiarEstadoCliente(int idCliente, boolean activo) throws Exception;
    
    Cliente buscarClientePorID(int id) throws Exception;
    Cliente buscarClientePorDNI(String dni) throws Exception;
    List<Cliente> buscarClientePorTelefono(String telefono) throws Exception;
    List<Cliente> buscarClientePorNombre(String nombre) throws Exception;
}