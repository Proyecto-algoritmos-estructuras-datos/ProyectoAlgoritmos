package controlador;

import dao.EmpleadoDAO;
import interfaces.IEmpleadoDAO;
import java.util.List;
import modelo.Empleado;
import modelo.Rol;
import util.SesionActual;

public class EmpleadoController {
    private final IEmpleadoDAO dao = new EmpleadoDAO();

    public List<Empleado> verTodosLosEmpleados() throws Exception {
        return dao.verTodosLosEmpleados();
    }

    public void registrarEmpleado(Empleado empleado) throws Exception {
        validar(empleado);
        if (empleado.getContrasena() == null || empleado.getContrasena().isEmpty()) {
            throw new Exception("La contraseña es obligatoria.");
        }
        validarContrasena(empleado);
        dao.registrarEmpleado(empleado);
    }

    public void actualizarEmpleado(Empleado empleado) throws Exception {
        if (empleado.getIdEmpleado() <= 0) {
            throw new Exception("Empleado inválido para actualizar.");
        }
        Empleado actual = dao.buscarEmpleadoPorId(empleado.getIdEmpleado());
        if (actual == null) {
            throw new Exception("No se encontró el empleado a actualizar.");
        }
        validar(empleado);

        // Si la contraseña viene vacía al editar, se conserva la actual
        if (empleado.getContrasena() == null || empleado.getContrasena().isEmpty()) {
            empleado.setContrasena(actual.getContrasena());
        } else {
            validarContrasena(empleado);
        }

        // No se puede quitar el rol de administrador al último administrador activo
        if (actual.getRol() == Rol.ADMINISTRADOR && actual.isEstado()
                && empleado.getRol() != Rol.ADMINISTRADOR
                && esUltimoAdministradorActivo(actual.getIdEmpleado())) {
            throw new Exception("No se puede cambiar el rol: es el último administrador activo.");
        }
        dao.actualizarEmpleado(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) throws Exception {
        if (empleado.getIdEmpleado() <= 0) {
            throw new Exception("Empleado inválido para eliminar.");
        }
        Empleado actual = dao.buscarEmpleadoPorId(empleado.getIdEmpleado());
        if (actual == null) {
            throw new Exception("No se encontró el empleado a eliminar.");
        }
        Empleado enSesion = SesionActual.getEmpleado();
        if (enSesion != null && enSesion.getIdEmpleado() == actual.getIdEmpleado()) {
            throw new Exception("No puedes eliminar tu propio usuario mientras tienes la sesión iniciada.");
        }
        if (actual.getRol() == Rol.ADMINISTRADOR && actual.isEstado()
                && esUltimoAdministradorActivo(actual.getIdEmpleado())) {
            throw new Exception("No se puede eliminar al último administrador activo.");
        }
        dao.eliminarEmpleado(empleado);
    }

    public void reactivarEmpleado(Empleado empleado) throws Exception {
        if (empleado.getIdEmpleado() <= 0) {
            throw new Exception("Empleado inválido para reactivar.");
        }
        dao.reactivarEmpleado(empleado);
    }

    public Empleado buscarEmpleadoPorId(int idEmpleado) throws Exception {
        if (idEmpleado <= 0) {
            throw new Exception("Id de empleado inválido.");
        }
        return dao.buscarEmpleadoPorId(idEmpleado);
    }

    public Empleado buscarEmpleadoPorDni(String dni) throws Exception {
        if (dni == null || !dni.trim().matches("^[0-9]{8}$")) {
            throw new Exception("El DNI debe tener 8 dígitos.");
        }
        return dao.buscarEmpleadoPorDni(dni.trim());
    }

    public Empleado buscarEmpleadoPorUsuario(String usuario) throws Exception {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new Exception("El usuario es obligatorio.");
        }
        return dao.buscarEmpleadoPorUsuario(usuario.trim());
    }

    // Devuelve el empleado si las credenciales son correctas y está activo; si no, null.
    public Empleado autenticarEmpleado(String dni, String contrasena) throws Exception {
        if (dni == null || dni.trim().isEmpty()) {
            throw new Exception("Ingrese el DNI.");
        }
        if (!dni.trim().matches("^[0-9]{8}$")) {
            throw new Exception("El DNI debe tener 8 dígitos.");
        }
        if (contrasena == null || contrasena.isEmpty()) {
            throw new Exception("Ingrese la contraseña.");
        }
        return dao.autenticarEmpleado(dni.trim(), contrasena);
    }

    private void validar(Empleado empleado) throws Exception {
        if (empleado.getDni() == null || !empleado.getDni().trim().matches("^[0-9]{8}$")) {
            throw new Exception("El DNI debe tener exactamente 8 dígitos.");
        }
        if (empleado.getNombres() == null || empleado.getNombres().trim().isEmpty()) {
            throw new Exception("Los nombres son obligatorios.");
        }
        if (empleado.getNombres().trim().length() > 80) {
            throw new Exception("Los nombres no pueden superar los 80 caracteres.");
        }
        if (empleado.getApellidos() == null || empleado.getApellidos().trim().isEmpty()) {
            throw new Exception("Los apellidos son obligatorios.");
        }
        if (empleado.getApellidos().trim().length() > 80) {
            throw new Exception("Los apellidos no pueden superar los 80 caracteres.");
        }
        if (empleado.getRol() == null) {
            throw new Exception("Debe seleccionar un rol.");
        }
        
        empleado.setUsuario(empleado.getDni().trim());
        
        if (empleado.getUsuario() == null || empleado.getUsuario().trim().isEmpty()) {
            throw new Exception("El usuario es obligatorio.");
        }
        if (empleado.getUsuario().trim().length() > 30) {
            throw new Exception("El usuario no puede superar los 30 caracteres.");
        }
        if (empleado.getUsuario().trim().contains(" ")) {
            throw new Exception("El usuario no puede contener espacios.");
        }

        // Campos opcionales: vacío = NULL
        String correo = vacioANull(empleado.getCorreo());
        if (correo != null) {
            if (correo.length() > 100) {
                throw new Exception("El correo no puede superar los 100 caracteres.");
            }
            if (!correo.matches("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$")) {
                throw new Exception("El correo no tiene un formato válido.");
            }
        }
        String telefono = vacioANull(empleado.getTelefono());
        if (telefono != null && !telefono.matches("^\\+?[0-9 \\-]{6,15}$")) {
            throw new Exception("El teléfono no es válido (6 a 15 caracteres, solo números).");
        }

        empleado.setDni(empleado.getDni().trim());
        empleado.setNombres(empleado.getNombres().trim());
        empleado.setApellidos(empleado.getApellidos().trim());
        empleado.setUsuario(empleado.getUsuario().trim());
        empleado.setCorreo(correo);
        empleado.setTelefono(telefono);

        // DNI y usuario únicos (se ignora el propio empleado al actualizar)
        Empleado porDni = dao.buscarEmpleadoPorDni(empleado.getDni());
        if (porDni != null && porDni.getIdEmpleado() != empleado.getIdEmpleado()) {
            throw new Exception("Ya existe un empleado con ese DNI.");
        }
        Empleado porUsuario = dao.buscarEmpleadoPorUsuario(empleado.getUsuario());
        if (porUsuario != null && porUsuario.getIdEmpleado() != empleado.getIdEmpleado()) {
            throw new Exception("Ya existe un empleado con ese usuario.");
        }
    }

    private void validarContrasena(Empleado empleado) throws Exception {
        if (empleado.getContrasena().length() > 255) {
            throw new Exception("La contraseña no puede superar los 255 caracteres.");
        }
    }

    private boolean esUltimoAdministradorActivo(int idEmpleado) throws Exception {
        for (Empleado e : dao.verTodosLosEmpleados()) {
            if (e.getIdEmpleado() != idEmpleado && e.isEstado() && e.getRol() == Rol.ADMINISTRADOR) {
                return false; // hay otro administrador activo
            }
        }
        return true;
    }

    private String vacioANull(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return null;
        }
        return texto.trim();
    }
}