package modelo;

import java.math.BigDecimal;

/**
 * Línea de una compra. También es el elemento que se apila en el carrito
 * (Pila<DetalleCompra>), por eso idCompra y idDetalleCompra valen 0
 * hasta que la compra se guarda en la base de datos.
 */
public class DetalleCompra {
    private int idDetalleCompra;
    private int idCompra;
    private Producto producto;
    private int cantidad;
    private BigDecimal precioUnitario;

    public DetalleCompra() {
    }

    // Constructor para el carrito (todavía no existe en la base de datos)
    public DetalleCompra(Producto producto, int cantidad, BigDecimal precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public DetalleCompra(int idDetalleCompra, int idCompra, Producto producto, int cantidad, BigDecimal precioUnitario) {
        this.idDetalleCompra = idDetalleCompra;
        this.idCompra = idCompra;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    // En la base es una columna generada (cantidad * precio_unitario), aquí se calcula igual
    public BigDecimal getSubtotal() {
        return precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }

    @Override
    public String toString() {
        return "DetalleCompra{" + "idDetalleCompra=" + idDetalleCompra + ", idCompra=" + idCompra + ", producto=" + (producto != null ? producto.getNombreProducto() : null) + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }

}