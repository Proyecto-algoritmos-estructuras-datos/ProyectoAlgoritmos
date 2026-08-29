package controlador;

import dao.CajaDAO;
import dao.DetalleVentaDAO;
import dao.ProductoDAO;
import dao.VentaDAO;
import interfaces.ICajaDAO;
import interfaces.IDetalleVentaDAO;
import interfaces.IProductoDAO;
import interfaces.IVentaDAO;
import java.time.LocalDate;
import java.util.List;
import modelo.Caja;
import modelo.DetalleVenta;
import modelo.Venta;
import utilidades._ItemCarrito;
import utilidades.Validaciones;

public class VentaController {

    private final IVentaDAO ventaDAO;
    private final ICajaDAO cajaDAO;
    private final IDetalleVentaDAO detalleVentaDAO;
    private final IProductoDAO productoDAO;

    public VentaController() {
        this.ventaDAO = new VentaDAO();
        this.cajaDAO = new CajaDAO();
        this.detalleVentaDAO = new DetalleVentaDAO();
        this.productoDAO = new ProductoDAO();
    }

    public void registrarVenta(Venta venta) throws Exception {
        if (venta == null) {
            throw new Exception("La venta no puede ser nula.");
        }
        if (venta.getEmpleado() == null || venta.getEmpleado().getIdEmpleado() <= 0) {
            throw new Exception("Debe asignar un empleado válido a la venta.");
        }
        if (venta.getCaja() == null || venta.getCaja().getIdCaja() <= 0) {
            throw new Exception("Debe asignar una caja válida a la venta.");
        }
        if (venta.getCliente() != null && venta.getCliente().getIdCliente() <= 0) {
            throw new Exception("El cliente asignado no es válido.");
        }
       
        if (Validaciones.campoVacio(venta.getTipoDespacho())) {
            throw new Exception("Seleccione el tipo de despacho.");
        }
        if (Validaciones.campoVacio(venta.getMetodoPago())) {
            throw new Exception("Seleccione el método de pago.");
        }
        
        if (venta.getSubtotalVenta() <= 0) {
            throw new Exception("El subtotal de la venta debe ser mayor a 0.");
        }
        
        if (venta.getIgvVenta() <= 0) {
            throw new Exception("El IGV de la venta debe ser mayor a 0.");
        }
        
        if (venta.getTotalVenta() <= 0) {
            throw new Exception("El total de la venta debe ser mayor a 0.");
        }

        // Verificar que la caja asignada exista y esté abierta
        Caja caja = cajaDAO.buscarCajaPorID(venta.getCaja().getIdCaja());
        if (caja == null) {
            throw new Exception("La caja asignada no existe.");
        }
        if (!"Abierta".equals(caja.getEstado())) {
            throw new Exception("No se puede registrar una venta en una caja cerrada.");
        }

        ventaDAO.registrarVenta(venta);
    }
    
    public void registrarVentaConDetalles(Venta venta, List<_ItemCarrito> carrito) throws Exception {
        if (carrito == null || carrito.isEmpty()) {
            throw new Exception("El carrito está vacío. Agregue al menos un producto.");
        }

        // 1. Cabecera de la venta (reutiliza las validaciones ya existentes en registrarVenta)
        registrarVenta(venta); // aquí se le asigna el idVenta generado

        // 2. Detalles, uno por cada producto del carrito
        for (_ItemCarrito item : carrito) {
            DetalleVenta detalle = new DetalleVenta();
            detalle.setVenta(venta);
            detalle.setProducto(item.getProducto());
            detalle.setCantidad(item.getCantidad());
            detalle.setPrecioUnitario(item.getPrecioUnitario());
            detalle.setPrecioTotal(item.getPrecioTotal());
            detalleVentaDAO.registrarDetalleVenta(detalle);
        }

        // 3. Descuento de stock, al final
        for (_ItemCarrito item : carrito) {
            productoDAO.descontarStock(item.getProducto().getIdProducto(), item.getCantidad());
        }
    }

    public Venta buscarVentaPorID(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("El ID de la venta no es válido.");
        }

        Venta venta = ventaDAO.buscarVentaPorID(id);

        if (venta == null) {
            throw new Exception("No se encontró ninguna venta con el ID: " + id);
        }

        return venta;
    }

    public List<Venta> verTodasLasVentas() throws Exception {
        List<Venta> lista = ventaDAO.verTodasLasVentas();

        if (lista.isEmpty()) {
            throw new Exception("No hay ventas registradas.");
        }

        return lista;
    }
    
    public List<Venta> listarConFiltros(LocalDate fechaInicio, LocalDate fechaFinal, String tipoDespacho, String metodoPago) throws Exception {
        if (fechaInicio != null && fechaFinal != null && fechaInicio.isAfter(fechaFinal)) {
            throw new Exception("La fecha de inicio no puede ser posterior a la fecha final.");
        }

        List<Venta> lista = ventaDAO.listarConFiltros(fechaInicio, fechaFinal, tipoDespacho, metodoPago);

        if (lista.isEmpty()) {
            throw new Exception("No se encontraron pedidos con los filtros indicados.");
        }

        return lista;
    }
}