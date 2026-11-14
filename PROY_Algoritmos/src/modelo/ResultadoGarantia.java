/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public enum ResultadoGarantia {
    CAMBIO("Cambio del producto"),
    DEVOLUCION("Devolución del dinero"),
    GARANTIA("Garantía: reparar o cambiar"),
    RECHAZAR("Rechazar el reclamo");
    private final String etiqueta;

    ResultadoGarantia(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public String toString() {
        return etiqueta;

    }
}
