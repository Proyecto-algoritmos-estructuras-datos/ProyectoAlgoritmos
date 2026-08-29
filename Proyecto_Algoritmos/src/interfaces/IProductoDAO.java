package interfaces;

import java.util.List;
import modelo.Producto;
import utilidades._ResumenStock;

public interface IProductoDAO {
    void registrarProducto(Producto producto) throws Exception;
    void actualizarProducto(Producto producto) throws Exception;
    
    List<Producto> verTodosLosProductos() throws Exception;
    List<Producto> verProductosPorEstado(boolean activo) throws Exception;
    
    void cambiarEstadoProducto(int idProducto, boolean activo) throws Exception;
    
    Producto buscarProductoPorID(int id) throws Exception;
      
    // Método para el módulo inventario (filtros múltiples)
    List<Producto> listarConFiltros(String nombre, String categoria, String estadoStock, Double precioMin, Double precioMax) throws Exception;
    
    // Método para el cálculo y clasificación del stock
    _ResumenStock obtenerResumenStock() throws Exception;
    
    // Para descontar stock de un producto luego de la venta
    void descontarStock(int idProducto, int cantidad) throws Exception;
}
