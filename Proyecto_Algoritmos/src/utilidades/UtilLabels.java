package utilidades;

import controlador.CajaController;
import java.awt.Component;
import javax.swing.JLabel;
import modelo.Caja;

public class UtilLabels {
    public static void refrescarEstadoCaja(JLabel txtEstadoCaja, CajaController controller, Component parent) {
        try {
            Caja caja = controller.buscarCajaAbierta();
            if (caja == null) {
                txtEstadoCaja.setText("CERRADA");
            } else {
                txtEstadoCaja.setText("ABIERTA");
            }
        } catch (Exception e) {
            Mensajes.error("Error al verificar la caja." + e.getMessage());
        }
    }
    
}