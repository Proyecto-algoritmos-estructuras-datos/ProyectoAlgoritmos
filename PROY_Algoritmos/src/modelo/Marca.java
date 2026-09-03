package modelo;

import java.time.LocalDateTime;

public class Marca {
    private int idMarca;
    private String nombreMarca;
    private String descripcion;
    private String paisOrigen;
    private boolean estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public Marca() {
    }
    
    public Marca(String nombreMarca, String descripcion, String paisOrigen, boolean estado) {
        this.nombreMarca = nombreMarca;
        this.descripcion = descripcion;
        this.paisOrigen = paisOrigen;
        this.estado = estado;
    }

    public Marca(int idMarca, String nombreMarca, String descripcion, String paisOrigen, boolean estado, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.descripcion = descripcion;
        this.paisOrigen = paisOrigen;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    @Override
    public String toString() {
        return "Marca{" + "idMarca=" + idMarca + ", nombreMarca=" + nombreMarca + ", descripcion=" + descripcion + ", paisOrigen=" + paisOrigen + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + '}';
    }
    
}
