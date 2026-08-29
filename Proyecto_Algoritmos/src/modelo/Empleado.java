package modelo;

import java.time.LocalDateTime;

public class Empleado {

    // Atributos
    private int idEmpleado;
    private String nombres;
    private String apellidos;
    private String dni;
    private String contrasenia;
    private String direccion;
    private String telefono;
    private String rol;
    private boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    // Constructor vacío
    public Empleado() {
    }

    // Constructor con atributos
    public Empleado(int idEmpleado, String nombres, String apellidos, String dni,
            String contrasenia, String direccion, String telefono, String rol,
            boolean activo, LocalDateTime fechaCreacion,
            LocalDateTime fechaModificacion) {

        this.idEmpleado = idEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.contrasenia = contrasenia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rol = rol;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", rol='" + rol + '\'' +
                ", activo=" + activo +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }
}