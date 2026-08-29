package interfaces;

import java.util.List;
import modelo.DetalleVenta;

public interface IDetalleVentaDAO {
    void registrarDetalleVenta(DetalleVenta detalleVenta) throws Exception;
    
    List<DetalleVenta> buscarDetallesPorVenta(int idVenta) throws Exception;

}
