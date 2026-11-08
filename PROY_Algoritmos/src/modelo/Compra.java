package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private int idCompra;
    private Proveedor proveedor;
    private Empleado empleado;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaRecepcion; // null mientras la compra esté PENDIENTE
    private BigDecimal total;
    private EstadoCompra estado;
    private LocalDateTime fechaModificacion;
    private List<DetalleCompra> detalles;

    public Compra() {
        this.detalles = new ArrayList<>();
    }

    // Constructor para registrar una compra nueva: queda PENDIENTE y sin fecha de recepción
    public Compra(Proveedor proveedor, Empleado empleado, BigDecimal total, List<DetalleCompra> detalles) {
        this.proveedor = proveedor;
        this.empleado = empleado;
        this.total = total;
        this.estado = EstadoCompra.PENDIENTE;
        this.detalles = detalles;
    }

    public Compra(int idCompra, Proveedor proveedor, Empleado empleado, LocalDateTime fechaCompra, LocalDateTime fechaRecepcion, BigDecimal total, EstadoCompra estado, LocalDateTime fechaModificacion) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.empleado = empleado;
        this.fechaCompra = fechaCompra;
        this.fechaRecepcion = fechaRecepcion;
        this.total = total;
        this.estado = estado;
        this.fechaModificacion = fechaModificacion;
        this.detalles = new ArrayList<>();
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public LocalDateTime getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public EstadoCompra getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompra> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", proveedor=" + (proveedor != null ? proveedor.getRazonSocial() : null) + ", empleado=" + empleado + ", fechaCompra=" + fechaCompra + ", fechaRecepcion=" + fechaRecepcion + ", total=" + total + ", estado=" + estado + ", fechaModificacion=" + fechaModificacion + ", detalles=" + detalles + '}';
    }

}