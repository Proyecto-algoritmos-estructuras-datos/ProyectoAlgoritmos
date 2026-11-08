/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author antho
 */
public enum ResultadoGarantia {

    ACEPTAR_CAMBIO("Aceptar cambio o devolución"),
    GARANTIA_FABRICANTE("Enviar a garantía del fabricante"),
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
