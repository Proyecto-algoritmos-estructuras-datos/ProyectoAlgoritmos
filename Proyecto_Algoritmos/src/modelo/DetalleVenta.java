package modelo;

public class DetalleVenta {

    // Atributos
    private int idDetalleVenta;
    private Venta venta;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private double precioTotal;

    // Constructor vacío
    public DetalleVenta() {
    }

    // Constructor con atributos

    public DetalleVenta(int idDetalleVenta, Venta venta, Producto producto, int cantidad, double precioUnitario, double precioTotal) {
        this.idDetalleVenta = idDetalleVenta;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }
    

    // Getters y Setters
    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    // toString()

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", venta=" + venta + ", producto=" + producto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", precioTotal=" + precioTotal + '}';
    }
    
}