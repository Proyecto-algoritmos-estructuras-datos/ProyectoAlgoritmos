/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;

public class Venta {

    private int idVenta;
    private String numero; // V0001, V0002... (puede ser null)
    private LocalDateTime fechaVenta;
    private String estado; // COMPLETADA o ANULADA

    public Venta() {
    }

    public Venta(int idVenta, String numero, LocalDateTime fechaVenta, String estado) {
        this.idVenta = idVenta;
        this.numero = numero;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean estaAnulada() {
        return "ANULADA".equalsIgnoreCase(estado);
    }
}
