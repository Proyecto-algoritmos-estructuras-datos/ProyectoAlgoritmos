package utilidades;

import modelo.Producto;

public class _ItemCarrito {
    
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public _ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = producto.getPrecio();
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public double getPrecioTotal() {
        return precioUnitario * cantidad;
    }
}