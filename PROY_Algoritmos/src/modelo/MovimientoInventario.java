package modelo;

import java.time.LocalDateTime;

// Representa una fila del kardex. Una vez registrado no se modifica ni se elimina
// (la BD lo protege con triggers), por eso no hay lógica de actualización.
public class MovimientoInventario {

    private int idMovimiento;
    private Producto producto;
    private Empleado empleado;
    private TipoMovimiento tipoMovimiento;
    private int cantidad;
    private int stockAnterior;
    private int stockNuevo;
    private String motivo;          // puede ser null
    private Integer idCompra;       // null si no viene de una compra (no se usa en el Avance 2)
    private Integer idVenta;        // null si no viene de una venta (no se usa en el Avance 2)
    private LocalDateTime fechaMovimiento;

    public MovimientoInventario() {
    }

    public MovimientoInventario(int idMovimiento, Producto producto, Empleado empleado,
                                TipoMovimiento tipoMovimiento, int cantidad,
                                int stockAnterior, int stockNuevo, String motivo,
                                Integer idCompra, Integer idVenta,
                                LocalDateTime fechaMovimiento) {
        this.idMovimiento = idMovimiento;
        this.producto = producto;
        this.empleado = empleado;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.stockAnterior = stockAnterior;
        this.stockNuevo = stockNuevo;
        this.motivo = motivo;
        this.idCompra = idCompra;
        this.idVenta = idVenta;
        this.fechaMovimiento = fechaMovimiento;
    }

    public int getIdMovimiento() { return idMovimiento; }
    public void setIdMovimiento(int idMovimiento) { this.idMovimiento = idMovimiento; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public TipoMovimiento getTipoMovimiento() { return tipoMovimiento; }
    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) { this.tipoMovimiento = tipoMovimiento; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public int getStockAnterior() { return stockAnterior; }
    public void setStockAnterior(int stockAnterior) { this.stockAnterior = stockAnterior; }

    public int getStockNuevo() { return stockNuevo; }
    public void setStockNuevo(int stockNuevo) { this.stockNuevo = stockNuevo; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public Integer getIdCompra() { return idCompra; }
    public void setIdCompra(Integer idCompra) { this.idCompra = idCompra; }

    public Integer getIdVenta() { return idVenta; }
    public void setIdVenta(Integer idVenta) { this.idVenta = idVenta; }

    public LocalDateTime getFechaMovimiento() { return fechaMovimiento; }
    public void setFechaMovimiento(LocalDateTime fechaMovimiento) { this.fechaMovimiento = fechaMovimiento; }

    @Override
    public String toString() {
        String nombreProducto = (producto != null) ? producto.getNombreProducto() : "?";
        return tipoMovimiento + " | " + nombreProducto + " | " + stockAnterior + " -> " + stockNuevo;
    }
}