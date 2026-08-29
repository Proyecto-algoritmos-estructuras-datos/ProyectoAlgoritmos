package utilidades;

import javax.swing.JOptionPane;

public class Mensajes {

    private Mensajes() {
    }

    // Campos incompletos
    public static void camposVacios() {
        JOptionPane.showMessageDialog(null,
                "Complete todos los campos.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
    }

    // Datos son incorrectos
    public static void loginIncorrecto() {
        JOptionPane.showMessageDialog(null,
                "Usuario o contraseña incorrectos.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
    
    // Mensaje de Cerrar Sesión
    public static boolean cerrarSesion() {
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Esta seguro que desea salir de la sesión?",
                "Cerrar Sesión",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return respuesta == JOptionPane.YES_OPTION;
    }

    // Registro ha sido guardado exitosamente
    public static void registroGuardado() {
        JOptionPane.showMessageDialog(null,
                "Registro guardado correctamente.",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Mensaje de contraseña inválida
    public static void contraseñaInvalida() {
        JOptionPane.showMessageDialog(
            null,
            "La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número.",
            "Advertencia",
            JOptionPane.WARNING_MESSAGE
        );
    }
    
    // Exito en una accion
    public static void exito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, 
                "Operación exitosa!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Fallo en una accion
    public static void error(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, 
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Confirmación
    public static boolean confirmacion(String mensaje, String tipo) {
        int respuesta = JOptionPane.showConfirmDialog(null,
                mensaje,
                tipo,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return respuesta == JOptionPane.YES_OPTION;
    }
    
    // Exito en una accion
    public static void aviso(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, 
                "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    

    // Confirmación de actualizar un registro
    public static void registroActualizado() {
        JOptionPane.showMessageDialog(null,
                "Registro actualizado correctamente.",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Confirmación de eliminación
    public static boolean confirmarEliminacion() {
        int respuesta = JOptionPane.showConfirmDialog(null,
                "¿Esta seguro que desea eliminar el empleado?",
                "Eliminación de Empleado",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return respuesta == JOptionPane.YES_OPTION;
    }

    // Confirmación de eliminar un registro 
    public static void registroEliminado() {
        JOptionPane.showMessageDialog(null,
                "Registro eliminado correctamente.",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Registro no encontrado
    public static void registroNoEncontrado() {
        JOptionPane.showMessageDialog(null,
                "No se encontró el registro.",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Empleado sin rol
    public static void rolDesconocido() {
        JOptionPane.showMessageDialog(null,
                "Rol no reconocido, contacte al administrador.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

}