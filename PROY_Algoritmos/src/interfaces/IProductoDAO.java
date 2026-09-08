package interfaces;

import java.util.List;
import modelo.Producto;

public interface IProductoDAO {
    List<Producto> verTodosLosProductos() throws Exception;
    void registrarProducto(Producto producto) throws Exception;
    void actualizarProducto(Producto producto) throws Exception;
    void eliminarProducto(Producto producto) throws Exception;
}
