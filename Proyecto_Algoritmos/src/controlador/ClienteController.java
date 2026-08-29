package controlador;

import dao.ClienteDAO;
import interfaces.IClienteDAO;
import java.util.List;
import modelo.Cliente;
import utilidades.Validaciones;

public class ClienteController {

    private final IClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public void registrarCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente no puede ser nulo.");
        }
        if (Validaciones.campoVacio(cliente.getNombre()) || !Validaciones.soloLetras(cliente.getNombre())) {
            throw new Exception("Ingrese un nombre válido (solo letras).");
        }

        if (!Validaciones.campoVacio(cliente.getDni())) {
            if (!Validaciones.soloNumeros(cliente.getDni())
                    || !Validaciones.longitudMinima(cliente.getDni(), 8)
                    || !Validaciones.longitudMaxima(cliente.getDni(), 8)) {
                throw new Exception("El DNI debe tener exactamente 8 dígitos numéricos.");
            }
            if (clienteDAO.buscarClientePorDNI(cliente.getDni()) != null) {
                throw new Exception("Ya existe un cliente registrado con ese DNI.");
            }
        }

        if (!Validaciones.campoVacio(cliente.getTelefono())) {
            if (!Validaciones.soloNumeros(cliente.getTelefono())
                    || !Validaciones.longitudMinima(cliente.getTelefono(), 7)
                    || !Validaciones.longitudMaxima(cliente.getTelefono(), 15)) {
                throw new Exception("El teléfono debe contener solo dígitos (entre 7 y 15).");
            }
        }

        clienteDAO.registrarCliente(cliente);
    }

    public void actualizarCliente(Cliente cliente) throws Exception {
        if (cliente == null) {
            throw new Exception("El cliente no puede ser nulo.");
        }
        if (cliente.getIdCliente() <= 0) {
            throw new Exception("El ID del cliente no es válido.");
        }
        if (Validaciones.campoVacio(cliente.getNombre()) || !Validaciones.soloLetras(cliente.getNombre())) {
            throw new Exception("Ingrese un nombre válido (solo letras).");
        }

        if (clienteDAO.buscarClientePorID(cliente.getIdCliente()) == null) {
            throw new Exception("No se encontró el cliente a actualizar.");
        }

        if (!Validaciones.campoVacio(cliente.getDni())) {
            if (!Validaciones.soloNumeros(cliente.getDni())
                    || !Validaciones.longitudMinima(cliente.getDni(), 8)
                    || !Validaciones.longitudMaxima(cliente.getDni(), 8)) {
                throw new Exception("El DNI debe tener exactamente 8 dígitos numéricos.");
            }
            
            Cliente clienteConMismoDNI = clienteDAO.buscarClientePorDNI(cliente.getDni());
            if (clienteConMismoDNI != null && clienteConMismoDNI.getIdCliente() != cliente.getIdCliente()) {
                throw new Exception("El DNI ingresado ya pertenece a otro cliente.");
            }
        }

        if (!Validaciones.campoVacio(cliente.getTelefono())) {
            if (!Validaciones.soloNumeros(cliente.getTelefono())
                    || !Validaciones.longitudMinima(cliente.getTelefono(), 7)
                    || !Validaciones.longitudMaxima(cliente.getTelefono(), 15)) {
                throw new Exception("El teléfono debe contener solo dígitos (entre 7 y 15).");
            }
        }

        clienteDAO.actualizarCliente(cliente);
    }

    public void cambiarEstadoCliente(int idCliente, boolean activo) throws Exception {
        if (idCliente <= 0) {
            throw new Exception("El ID del cliente no es válido.");
        }
        if (clienteDAO.buscarClientePorID(idCliente) == null) {
            throw new Exception("No se encontró el cliente.");
        }

        clienteDAO.cambiarEstadoCliente(idCliente, activo);
    }

    public List<Cliente> verTodosLosClientes() throws Exception {
        List<Cliente> lista = clienteDAO.verTodosLosClientes();

        if (lista.isEmpty()) {
            throw new Exception("No hay clientes registrados.");
        }

        return lista;
    }

    public List<Cliente> verClientesPorEstado(boolean activo) throws Exception {
        List<Cliente> lista = clienteDAO.verClientesPorEstado(activo);
        String estado = activo ? "activos" : "inactivos";

        if (lista.isEmpty()) {
            throw new Exception("No hay clientes " + estado + ".");
        }

        return lista;
    }

    public Cliente buscarClientePorID(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("El ID del cliente no es válido.");
        }

        Cliente cliente = clienteDAO.buscarClientePorID(id);

        if (cliente == null) {
            throw new Exception("No se encontró ningún cliente con el ID: " + id);
        }

        return cliente;
    }

    public Cliente buscarClientePorDNI(String dni) throws Exception {
        if (Validaciones.campoVacio(dni)
                || !Validaciones.soloNumeros(dni)
                || !Validaciones.longitudMinima(dni, 8)
                || !Validaciones.longitudMaxima(dni, 8)) {
            throw new Exception("El DNI debe tener exactamente 8 dígitos numéricos.");
        }

        Cliente cliente = clienteDAO.buscarClientePorDNI(dni);

        if (cliente == null) {
            throw new Exception("No se encontró ningún cliente con el DNI: " + dni);
        }

        return cliente;
    }

    public List<Cliente> buscarClientePorTelefono(String telefono) throws Exception {
        if (Validaciones.campoVacio(telefono)) {
            throw new Exception("Ingrese un teléfono para realizar la búsqueda.");
        }
        if (!Validaciones.soloNumeros(telefono)) {
            throw new Exception("El teléfono debe contener solo dígitos.");
        }

        List<Cliente> lista = clienteDAO.buscarClientePorTelefono(telefono.trim());

        if (lista.isEmpty()) {
            throw new Exception("No se encontraron clientes con el teléfono: " + telefono);
        }

        return lista;
    }

    public List<Cliente> buscarClientePorNombre(String nombre) throws Exception {
        if (Validaciones.campoVacio(nombre) || !Validaciones.soloLetras(nombre)) {
            throw new Exception("Ingrese un nombre válido para realizar la búsqueda.");
        }

        List<Cliente> lista = clienteDAO.buscarClientePorNombre(nombre.trim());

        if (lista.isEmpty()) {
            throw new Exception("No se encontraron clientes con el nombre: " + nombre);
        }

        return lista;
    }
}