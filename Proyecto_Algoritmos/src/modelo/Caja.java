package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Caja {

    // Atributos
    private int idCaja;
    private Empleado empleadoApertura;
    private Empleado empleadoCierre;
    private LocalDate fecha;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private double montoApertura;
    private double montoCierre;
    private String estado;

    // Constructor vacío
    public Caja() {
    }

    // Constructor con atributos

    public Caja(int idCaja, Empleado empleadoApertura, Empleado empleadoCierre, LocalDate fecha, LocalTime horaApertura, LocalTime horaCierre, double montoApertura, double montoCierre, String estado) {
        this.idCaja = idCaja;
        this.empleadoApertura = empleadoApertura;
        this.empleadoCierre = empleadoCierre;
        this.fecha = fecha;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.montoApertura = montoApertura;
        this.montoCierre = montoCierre;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public Empleado getEmpleadoApertura() {
        return empleadoApertura;
    }

    public void setEmpleadoApertura(Empleado empleadoApertura) {
        this.empleadoApertura = empleadoApertura;
    }

    public Empleado getEmpleadoCierre() {
        return empleadoCierre;
    }

    public void setEmpleadoCierre(Empleado empleadoCierre) {
        this.empleadoCierre = empleadoCierre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    public double getMontoApertura() {
        return montoApertura;
    }

    public void setMontoApertura(double montoApertura) {
        this.montoApertura = montoApertura;
    }

    public double getMontoCierre() {
        return montoCierre;
    }

    public void setMontoCierre(double montoCierre) {
        this.montoCierre = montoCierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // toString()
    @Override
    public String toString() {
        return "Caja{" + "idCaja=" + idCaja + ", empleadoApertura=" + empleadoApertura + ", empleadoCierre=" + empleadoCierre + ", fecha=" + fecha + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", montoApertura=" + montoApertura + ", montoCierre=" + montoCierre + ", estado=" + estado + '}';
    }
    
}