package util;

import javax.swing.JButton;
import javax.swing.JFrame;
import modelo.Empleado;
import modelo.Rol;

// Reglas de acceso por rol:
//  - Administración: solo ADMINISTRADOR
//  - Ajuste de stock (toma de inventario): ADMINISTRADOR y EMPLEADO
//  - El resto de módulos: todos los roles
public class ControlAcceso {

    private ControlAcceso() {
    }

    public static boolean puedeAdministrar() {
        return SesionActual.tieneRol(Rol.ADMINISTRADOR);
    }

    public static boolean puedeAjustarStock() {
        return SesionActual.tieneRol(Rol.ADMINISTRADOR, Rol.EMPLEADO);
    }

    // Se llama en el constructor de cada formulario: pone el nombre y rol en el título
    // y oculta del menú lo que el rol no puede usar.
    public static void configurarVentana(JFrame ventana, JButton btnAjusteStock, JButton btnAdministracion) {
        Empleado empleado = SesionActual.getEmpleado();
        if (empleado != null) {
            ventana.setTitle("Alpha Technology - " + empleado.getNombreCompleto() + " (" + empleado.getRol() + ")");
        } else {
            ventana.setTitle("Alpha Technology");
        }
        btnAjusteStock.setVisible(puedeAjustarStock());
        btnAdministracion.setVisible(puedeAdministrar());
    }

    // Se llama en el botón del menú antes de abrir la pantalla (segunda barrera,
    // por si el botón no estuviera oculto).
    public static boolean validarAjusteStock() {
        if (!puedeAjustarStock()) {
            Mensajes.error("No tienes permiso para acceder al ajuste de stock.");
            return false;
        }
        return true;
    }

    public static boolean validarAdministracion() {
        if (!puedeAdministrar()) {
            Mensajes.error("No tienes permiso para acceder a Administración.");
            return false;
        }
        return true;
    }
}