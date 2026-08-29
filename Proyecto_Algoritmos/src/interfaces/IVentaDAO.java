package interfaces;

import java.time.LocalDate;
import java.util.List;
import modelo.Venta;

public interface IVentaDAO {
    void registrarVenta(Venta venta) throws Exception;

    List<Venta> verTodasLasVentas() throws Exception;
    
    // No usado
    Venta buscarVentaPorID(int id) throws Exception;
    
    List<Venta> listarConFiltros(LocalDate fechaInicio, LocalDate fechaFinal, String tipoDespacho, String metodoPago) throws Exception;
    
    double sumarVentasPorCaja(int idCaja) throws Exception;

}
