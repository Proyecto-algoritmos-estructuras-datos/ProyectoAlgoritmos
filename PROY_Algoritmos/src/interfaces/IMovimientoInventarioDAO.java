package interfaces;

import java.util.List;
import java.util.Map;
import modelo.Empleado;
import modelo.MovimientoInventario;

public interface IMovimientoInventarioDAO {
    List<MovimientoInventario> verTodosLosMovimientos() throws Exception;
    List<MovimientoInventario> verMovimientosPorProducto(int idProducto) throws Exception;

    // conteos: idProducto -> conteo físico. Devuelve los ajustes realmente aplicados.
    List<MovimientoInventario> aplicarTomaInventario(Map<Integer, Integer> conteos, Empleado empleado, String motivo) throws Exception;
}