package util;

import modelo.Empleado;
import modelo.Rol;

// Guarda al empleado que inició sesión mientras la aplicación está abierta.
public class SesionActual {

    private static Empleado empleado;

    private SesionActual() {
    }

    public static void iniciarSesion(Empleado empleadoLogueado) {
        // La contraseña no necesita quedarse en memoria durante la sesión
        empleadoLogueado.setContrasena(null);
        empleado = empleadoLogueado;
    }

    public static void cerrarSesion() {
        empleado = null;
    }

    public static Empleado getEmpleado() {
        return empleado;
    }

    public static boolean haySesionActiva() {
        return empleado != null;
    }

    // true si hay sesión y el rol del empleado es alguno de los indicados
    public static boolean tieneRol(Rol... roles) {
        if (empleado == null) {
            return false;
        }
        for (Rol rol : roles) {
            if (empleado.getRol() == rol) {
                return true;
            }
        }
        return false;
    }
}