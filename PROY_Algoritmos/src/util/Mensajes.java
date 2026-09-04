package util;

import javax.swing.JOptionPane;

public class Mensajes {
    private Mensajes() {
    }
    
    public static void error(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, 
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static boolean confirmacion(String mensaje, String tipo) {
        int respuesta = JOptionPane.showConfirmDialog(null,
                mensaje,
                tipo,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return respuesta == JOptionPane.YES_OPTION;
    }
    
    public static void exito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, 
                "Operación exitosa!", JOptionPane.INFORMATION_MESSAGE);
    }
}
