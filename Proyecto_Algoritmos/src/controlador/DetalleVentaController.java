package controlador;

import dao.DetalleVentaDAO;
import dao.VentaDAO;
import interfaces.IDetalleVentaDAO;
import interfaces.IVentaDAO;
import java.util.List;
import modelo.DetalleVenta;

public class DetalleVentaController {

    private final IDetalleVentaDAO detalleVentaDAO;
    private final IVentaDAO ventaDAO;

    public DetalleVentaController() {
        this.detalleVentaDAO = new DetalleVentaDAO();
        this.ventaDAO = new VentaDAO();
    }
    
    public void registrarDetalleVenta(DetalleVenta detalleVenta) throws Exception {
        if (detalleVenta == null) {
            throw new Exception("El detalle de venta no puede ser nulo.");
        }
        if (detalleVenta.getVenta() == null || detalleVenta.getVenta().getIdVenta() <= 0) {
            throw new Exception("Debe asignar una venta válida al detalle.");
        }
        if (detalleVenta.getProducto() == null || detalleVenta.getProducto().getIdProducto() <= 0) {
            throw new Exception("Debe asignar un producto válido al detalle.");
        }
        if (detalleVenta.getCantidad() <= 0) {
            throw new Exception("La cantidad debe ser mayor a 0.");
        }
        if (detalleVenta.getPrecioUnitario() <= 0) {
            throw new Exception("El precio unitario debe ser mayor a 0.");
        }
        if (detalleVenta.getPrecioTotal() <= 0) {
            throw new Exception("El precio total debe ser mayor a 0.");
        }

        detalleVentaDAO.registrarDetalleVenta(detalleVenta);
    }

    public List<DetalleVenta> buscarDetallesPorVenta(int idVenta) throws Exception {
        if (idVenta <= 0) {
            throw new Exception("El ID de la venta no es válido.");
        }

        // Verificar que la venta exista antes de buscar sus detalles
        if (ventaDAO.buscarVentaPorID(idVenta) == null) {
            throw new Exception("No se encontró ninguna venta con el ID: " + idVenta);
        }

        List<DetalleVenta> lista = detalleVentaDAO.buscarDetallesPorVenta(idVenta);

        if (lista.isEmpty()) {
            throw new Exception("La venta con ID " + idVenta + " no tiene detalles registrados.");
        }

        return lista;
    }

}