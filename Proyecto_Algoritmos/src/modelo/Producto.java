package modelo;

import java.time.LocalDateTime;

public class Producto {

    // Atributos
    private int idProducto;
    private String nombre;
    private String categoria;
    private int stock;
    private double precio;
    private String unidMedida;
    private boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    // Constructor vacío
    public Producto() {
    }

    // Constructor con atributos
    public Producto(int idProducto, String nombre, String categoria, int stock,
            double precio, String unidMedida, boolean activo,
            LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {

        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
        this.unidMedida = unidMedida;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUnidMedida() {
        return unidMedida;
    }

    public void setUnidMedida(String unidMedida) {
        this.unidMedida = unidMedida;
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
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                ", unidMedida='" + unidMedida + '\'' +
                ", activo=" + activo +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }
}