package controlador;

import dao.CajaDAO;
import dao.VentaDAO;
import interfaces.ICajaDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import modelo.Caja;
import modelo.Empleado;
import utilidades.Validaciones;

public class CajaController {

    private final ICajaDAO cajaDAO;
    private final VentaDAO ventaDAO = new VentaDAO();

    public CajaController() {
        this.cajaDAO = new CajaDAO();
    }

    public void abrirCaja(Caja caja) throws Exception {
        if (caja == null) {
            throw new Exception("La caja no puede ser nula.");
        }
        if (caja.getEmpleadoApertura() == null || caja.getEmpleadoApertura().getIdEmpleado() <= 0) {
            throw new Exception("Debe asignar un empleado de apertura válido.");
        }
        if (caja.getMontoApertura() < 0) {
            throw new Exception("El monto de apertura no puede ser negativo.");
        }

        caja.setFecha(LocalDate.now());
        caja.setHoraApertura(LocalTime.now());

        List<Caja> cajasAbiertas = cajaDAO.buscarCajaPorEstado("Abierta");
        if (!cajasAbiertas.isEmpty()) {
            throw new Exception("Ya existe una caja abierta. Debe cerrarla antes de abrir una nueva.");
        }

        cajaDAO.abrirCaja(caja);
    }

    public void cerrarCaja(Empleado empleado) throws Exception {
        Caja cajaAbierta = cajaDAO.buscarCajaAbierta();

        if (cajaAbierta == null) {
            throw new Exception("No hay ninguna caja abierta para cerrar.");
        }

        double totalVentas = ventaDAO.sumarVentasPorCaja(cajaAbierta.getIdCaja());
        double montoCierreCalculado = cajaAbierta.getMontoApertura() + totalVentas;

        cajaAbierta.setEmpleadoCierre(empleado);
        cajaAbierta.setHoraCierre(LocalTime.now());
        cajaAbierta.setMontoCierre(montoCierreCalculado);

        cajaDAO.cerrarCaja(cajaAbierta);
    }

    public Caja buscarCajaPorID(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("El ID de la caja no es válido.");
        }

        Caja caja = cajaDAO.buscarCajaPorID(id);

        if (caja == null) {
            throw new Exception("No se encontró ninguna caja con el ID: " + id);
        }

        return caja;
    }
    
    public Caja buscarCajaAbierta() throws Exception {
        Caja caja = cajaDAO.buscarCajaAbierta();
        return caja;
    }

    public List<Caja> buscarCajasPorRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        if (fechaInicio == null || fechaFin == null) {
            throw new Exception("Las fechas de inicio y fin son obligatorias.");
        }
        if (fechaInicio.isAfter(fechaFin)) {
            throw new Exception("La fecha de inicio no puede ser posterior a la fecha fin.");
        }

        List<Caja> lista = cajaDAO.buscarCajasPorRangoDeFechas(fechaInicio, fechaFin);

        if (lista.isEmpty()) {
            throw new Exception("No se encontraron cajas en el rango de fechas indicado.");
        }

        return lista;
    }

    public List<Caja> verTodasLasCajas() throws Exception {
        List<Caja> lista = cajaDAO.verTodasLasCajas();

        if (lista.isEmpty()) {
            throw new Exception("No hay cajas registradas.");
        }

        return lista;
    }

    public List<Caja> buscarCajaPorEstado(String estado) throws Exception {
        if (Validaciones.campoVacio(estado)) {
            throw new Exception("Ingrese un estado para realizar la búsqueda.");
        }
        if (!"Abierta".equals(estado) && !"Cerrada".equals(estado)) {
            throw new Exception("El estado debe ser 'Abierta' o 'Cerrada'.");
        }

        List<Caja> lista = cajaDAO.buscarCajaPorEstado(estado);

        if (lista.isEmpty()) {
            throw new Exception("No se encontraron cajas con el estado: " + estado);
        }

        return lista;
    }
}
