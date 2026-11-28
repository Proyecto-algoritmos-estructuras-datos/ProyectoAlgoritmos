package interfaces;

import java.util.List;
import modelo.DetalleVenta;
import modelo.Venta;

public interface IVentaDAO {

    //Busca por id_venta (número) o por código (empieza con V). Devuelve null si no existe
    Venta buscarVenta(String texto) throws Exception;
    // Una fila por línea de la venta, en el orden en que se registraron

    List<DetalleVenta> verDetalle(int idVenta) throws Exception;
    
    // Pares (id_venta, id_producto) de las ventas COMPLETADA, ordenados por venta.
    // Cada int[] tiene 2 posiciones: [0] = id_venta, [1] = id_producto
    List<int[]> listarLineasVentasCompletadas() throws Exception;

}
