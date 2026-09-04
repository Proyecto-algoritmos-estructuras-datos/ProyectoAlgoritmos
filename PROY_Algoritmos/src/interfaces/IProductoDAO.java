package interfaces;

import java.util.List;
import modelo.Producto;

public interface IProductoDAO {
    List<Producto> verTodosLosProductos() throws Exception; // Recorrido
    void registrarProducto(Producto producto) throws Exception; // Inserción
    void actualizarProducto(Producto producto) throws Exception; // Actualización
    void eliminarProducto(Producto producto) throws Exception; // Eliminación
}
