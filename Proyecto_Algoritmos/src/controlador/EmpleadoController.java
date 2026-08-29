package controlador;

import dao.EmpleadoDAO;
import interfaces.IEmpleadoDAO;
import java.util.List;
import modelo.Empleado;
import utilidades.Validaciones;

public class EmpleadoController {

    private final IEmpleadoDAO empleadoDAO;

    public EmpleadoController() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    public void registrarEmpleado(Empleado empleado) throws Exception {
        if (empleado == null) {
            throw new Exception("El empleado no puede ser nulo.");
        }
        if (Validaciones.campoVacio(empleado.getNombres()) || !Validaciones.soloLetras(empleado.getNombres())) {
            throw new Exception("Ingrese un nombre válido (solo letras).");
        }
        if (Validaciones.campoVacio(empleado.getApellidos()) || !Validaciones.soloLetras(empleado.getApellidos())) {
            throw new Exception("Ingrese apellidos válidos (solo letras).");
        }
        if (Validaciones.campoVacio(empleado.getDni()) 
                || !Validaciones.soloNumeros(empleado.getDni()) 
                || !Validaciones.longitudMinima(empleado.getDni(), 8) 
                || !Validaciones.longitudMaxima(empleado.getDni(), 8)) {
            throw new Exception("El DNI debe tener exactamente 8 dígitos numéricos.");
        }
        if (Validaciones.campoVacio(empleado.getContrasenia()) || !Validaciones.contraseniaValida(empleado.getContrasenia())) {
            throw new Exception("La contraseña debe tener mínimo 8 caracteres, una mayúscula, una minúscula y un número.");
        }
        if (!empleado.getTelefono().isBlank()) {
            if (!Validaciones.soloNumeros(empleado.getTelefono())) {
                throw new Exception("El telefono solo puede tener numeros.");
            }
            if (!(empleado.getTelefono().length() == 7) && !(empleado.getTelefono().length() == 9)) {
                throw new Exception("El telefono debe tener 7 numeros para fijo y 9 para numero celular.");
            }
            if (empleado.getTelefono().length() == 7 && empleado.getTelefono().startsWith("1")) {
                throw new Exception("El telefono fijo debe empezar por cualquier numero, menos el 1");
                }
            if (empleado.getTelefono().length() == 9 && !empleado.getTelefono().startsWith("9")) {
                throw new Exception("El telefono celular debe empezar con el numero 9.");
            }
        }
        if (Validaciones.campoVacio(empleado.getRol())) {
            throw new Exception("Debe asignar un rol al empleado.");
        }
        if (empleadoDAO.buscarEmpleadoPorDNI(empleado.getDni()) != null) {
            throw new Exception("Ya existe un empleado registrado con ese DNI.");
        }

        empleadoDAO.registrarEmpleado(empleado);
    }

    public void actualizarEmpleado(Empleado empleado) throws Exception {
        if (empleado == null) {
            throw new Exception("El empleado no puede ser nulo.");
        }
        if (empleado.getIdEmpleado() <= 0) {
            throw new Exception("El ID del empleado no es válido.");
        }
        if (Validaciones.campoVacio(empleado.getNombres()) || !Validaciones.soloLetras(empleado.getNombres())) {
            throw new Exception("Ingrese un nombre válido (solo letras).");
        }
        if (Validaciones.campoVacio(empleado.getApellidos()) || !Validaciones.soloLetras(empleado.getApellidos())) {
            throw new Exception("Ingrese apellidos válidos (solo letras).");
        }
        if (Validaciones.campoVacio(empleado.getDni())
                || !Validaciones.soloNumeros(empleado.getDni())
                || !Validaciones.longitudMinima(empleado.getDni(), 8)
                || !Validaciones.longitudMaxima(empleado.getDni(), 8)) {
            throw new Exception("El DNI debe tener exactamente 8 dígitos numéricos.");
        }
        if (Validaciones.campoVacio(empleado.getContrasenia()) || !Validaciones.contraseniaValida(empleado.getContrasenia())) {
            throw new Exception("La contraseña debe tener mínimo 8 caracteres, una mayúscula, una minúscula y un número.");
        }
        if (Validaciones.campoVacio(empleado.getRol())) {
            throw new Exception("Debe asignar un rol al empleado.");
        }
        if (empleadoDAO.buscarEmpleadoPorID(empleado.getIdEmpleado()) == null) {
            throw new Exception("No se encontró el empleado a actualizar.");
        }

        Empleado empleadoConMismoDNI = empleadoDAO.buscarEmpleadoPorDNI(empleado.getDni());
        if (empleadoConMismoDNI != null && empleadoConMismoDNI.getIdEmpleado() != empleado.getIdEmpleado()) {
            throw new Exception("El DNI ingresado ya pertenece a otro empleado.");
        }

        empleadoDAO.actualizarEmpleado(empleado);
    }

    public void cambiarEstadoEmpleado(int idEmpleado, boolean activo) throws Exception {
        if (idEmpleado <= 0) {
            throw new Exception("El ID del empleado no es válido.");
        }
        if (empleadoDAO.buscarEmpleadoPorID(idEmpleado) == null) {
            throw new Exception("No se encontró el empleado.");
        }

        empleadoDAO.cambiarEstadoEmpleado(idEmpleado, activo);
    }

    public List<Empleado> verTodosLosEmpleados() throws Exception {
        List<Empleado> lista = empleadoDAO.verTodosLosEmpleados();

        if (lista.isEmpty()) {
            throw new Exception("No hay empleados registrados.");
        }

        return lista;
    }

    public List<Empleado> verEmpleadosPorEstado(boolean activo) throws Exception {
        List<Empleado> lista = empleadoDAO.verEmpleadosPorEstado(activo);
        String estado = activo ? "activos" : "inactivos";

        if (lista.isEmpty()) {
            throw new Exception("No hay empleados " + estado + ".");
        }

        return lista;
    }

    public Empleado buscarEmpleadoPorID(String idTexto) throws Exception {
        
        if (Validaciones.campoVacio(idTexto)
                || !Validaciones.soloNumeros(idTexto)
            ) {
            throw new Exception("El ID no puede estar vacio y debe ser numérico.");
        }
        
        int id = Integer.parseInt(idTexto);
        
        if (id <= 0) {
            throw new Exception("El ID del empleado no es válido.");
        }

        Empleado empleado = empleadoDAO.buscarEmpleadoPorID(id);

        if (empleado == null) {
            throw new Exception("No se encontró ningún empleado con el ID: " + id);
        }

        return empleado;
    }

    public Empleado buscarEmpleadoPorDNI(String dni) throws Exception {
        if (Validaciones.campoVacio(dni)
                || !Validaciones.soloNumeros(dni)
                || !Validaciones.longitudMinima(dni, 8)
                || !Validaciones.longitudMaxima(dni, 8)) {
            throw new Exception("El DNI debe tener exactamente 8 dígitos numéricos.");
        }

        Empleado empleado = empleadoDAO.buscarEmpleadoPorDNI(dni);
        if (empleado == null) {
            throw new Exception("No se encontró ningún empleado con el DNI: " + dni);
        }

        return empleado;
    }

    public List<Empleado> buscarEmpleadoPorNombre(String nombre) throws Exception {
        if (Validaciones.campoVacio(nombre) || !Validaciones.soloLetras(nombre)) {
            throw new Exception("Ingrese un nombre válido para realizar la búsqueda.");
        }

        List<Empleado> lista = empleadoDAO.buscarEmpleadoPorNombre(nombre.trim());
        if (lista.isEmpty()) {
            throw new Exception("No se encontraron empleados con el nombre: " + nombre);
        }

        return lista;
    }

    public Empleado iniciarSesionEmpleado(String dni, String contrasenia) throws Exception {
        if (Validaciones.campoVacio(dni)
                || !Validaciones.soloNumeros(dni)
                || !Validaciones.longitudMinima(dni, 8)
                || !Validaciones.longitudMaxima(dni, 8)) {
            throw new Exception("El DNI debe tener exactamente 8 dígitos numéricos.");
        }
        if (Validaciones.campoVacio(contrasenia)) {
            throw new Exception("Ingrese su contraseña.");
        }

        Empleado empleado = empleadoDAO.iniciarSesionEmpleado(dni, contrasenia);
        if (empleado == null) {
            throw new Exception("DNI o contraseña incorrectos, o la cuenta está inactiva.");
        }

        return empleado;
    }
}