/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;

public class UnidadVenta {

    private final Producto producto;
    private final BigDecimal precioUnitario;
    private final int numero; // 1, 2, 3...
    private final int total; // cantidad de la línea

    public UnidadVenta(Producto producto, BigDecimal precioUnitario, int numero, int total) {
        this.producto = producto;
        this.precioUnitario = precioUnitario;
        this.numero = numero;
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public int getNumero() {
        return numero;
    }

    public int getTotal() {
        return total;
    }

    public String getEtiquetaUnidad() {
        return numero + " de " + total;
    }

}
