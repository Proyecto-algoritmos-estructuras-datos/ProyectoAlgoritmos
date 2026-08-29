package modelo;

import java.time.LocalDateTime;

public class Cliente {

    // Atributos
    private int idCliente;
    private String nombre;
    private String dni;
    private String direccion;
    private String telefono;
    private boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con atributos
    public Cliente(int idCliente, String nombre, String dni, boolean activo,
            LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.dni = dni;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    // Getters y Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    // toString()
    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", activo=" + activo +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }
}