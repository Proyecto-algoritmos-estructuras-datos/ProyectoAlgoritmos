package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private Categoria categoria;
    private Marca marca;
    private BigDecimal precio;
    private int stock;
    private boolean estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

    public Producto() {
    }

    public Producto(String nombreProducto, Categoria categoria, Marca marca, BigDecimal precio, int stock, boolean estado) {
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(int idProducto, String nombreProducto, Categoria categoria, Marca marca, BigDecimal precio, int stock, boolean estado, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        return "Producto{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", categoria=" + categoria + ", marca=" + marca + ", precio=" + precio + ", stock=" + stock + ", estado=" + estado + ", fechaCreacion=" + fechaCreacion + ", fechaModificacion=" + fechaModificacion + '}';
    }
    
}
