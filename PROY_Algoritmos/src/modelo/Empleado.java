package modelo;

import java.time.LocalDateTime;

public class Empleado {

    private int idEmpleado;
    private String dni;
    private String nombres;
    private String apellidos;
    private String correo;      // puede ser null
    private String telefono;    // puede ser null
    private Rol rol;
    private String usuario;
    private String contrasena;  // texto plano en este avance (TODO: hash en un avance posterior)
    private boolean estado;     // true = activo, false = inactivo
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String dni, String nombres, String apellidos,
                    String correo, String telefono, Rol rol, String usuario,
                    String contrasena, boolean estado,
                    LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public LocalDateTime getFechaModificacion() { return fechaModificacion; }
    public void setFechaModificacion(LocalDateTime fechaModificacion) { this.fechaModificacion = fechaModificacion; }

    // Útil para mostrar el empleado en tablas y mensajes
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    // La contraseña NO se imprime nunca
    @Override
    public String toString() {
        return getNombreCompleto() + " (" + usuario + ")";
    }
}