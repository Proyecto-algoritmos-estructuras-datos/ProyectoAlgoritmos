package controlador;

import dao.MovimientoInventarioDAO;
import interfaces.IMovimientoInventarioDAO;
import java.util.List;
import java.util.Map;
import modelo.Empleado;
import modelo.MovimientoInventario;

public class MovimientoInventarioController {
    private final IMovimientoInventarioDAO dao = new MovimientoInventarioDAO();

    public List<MovimientoInventario> verTodosLosMovimientos() throws Exception {
        return dao.verTodosLosMovimientos();
    }

    public List<MovimientoInventario> verMovimientosPorProducto(int idProducto) throws Exception {
        if (idProducto <= 0) {
            throw new Exception("Debe seleccionar un producto válido.");
        }
        return dao.verMovimientosPorProducto(idProducto);
    }

    public List<MovimientoInventario> aplicarTomaInventario(Map<Integer, Integer> conteos, Empleado empleado, String motivo) throws Exception {
        if (empleado == null || empleado.getIdEmpleado() <= 0) {
            throw new Exception("No hay un empleado válido en sesión.");
        }
        if (conteos == null || conteos.isEmpty()) {
            throw new Exception("No hay conteos registrados para aplicar.");
        }
        for (Map.Entry<Integer, Integer> entrada : conteos.entrySet()) {
            if (entrada.getKey() == null || entrada.getKey() <= 0) {
                throw new Exception("Hay un producto inválido en la toma de inventario.");
            }
            if (entrada.getValue() == null || entrada.getValue() < 0) {
                throw new Exception("El conteo físico no puede ser negativo.");
            }
        }
        if (motivo == null || motivo.trim().isEmpty()) {
            throw new Exception("El motivo del ajuste es obligatorio.");
        }
        if (motivo.trim().length() > 150) {
            throw new Exception("El motivo no puede superar los 150 caracteres.");
        }
        return dao.aplicarTomaInventario(conteos, empleado, motivo.trim());
    }
}
