package controlador;

import dao.ProductoDAO;
import interfaces.IProductoDAO;
import java.math.BigDecimal;
import java.util.List;
import modelo.Producto;

public class ProductoController {
    private final IProductoDAO dao = new ProductoDAO();

    public List<Producto> verTodosLosProductos() throws Exception {
        return dao.verTodosLosProductos();
    }

    public Producto[] obtenerArray() throws Exception {
        List<Producto> lista = dao.verTodosLosProductos();
        return lista.toArray(new Producto[0]);
    }

    public void registrarProducto(Producto producto) throws Exception {
        validar(producto);
        dao.registrarProducto(producto);
    }

    public void actualizarProducto(Producto producto) throws Exception {
        if (producto.getIdProducto() <= 0) {
            throw new Exception("Producto inválido para actualizar.");
        }
        validar(producto);
        dao.actualizarProducto(producto);
    }

    public void eliminarProducto(Producto producto) throws Exception {
        if (producto.getIdProducto() <= 0) {
            throw new Exception("Producto inválido para eliminar.");
        }
        dao.eliminarProducto(producto);
    }

    private void validar(Producto producto) throws Exception {
        if (producto.getNombreProducto() == null || producto.getNombreProducto().trim().isEmpty()) {
            throw new Exception("El nombre del producto es obligatorio.");
        }
        if (producto.getNombreProducto().trim().length() > 120) {
            throw new Exception("El nombre del producto no puede superar los 120 caracteres.");
        }
        if (producto.getCategoria() == null || producto.getCategoria().getIdCategoria() <= 0) {
            throw new Exception("Debe seleccionar una categoría válida.");
        }
        if (producto.getMarca() == null || producto.getMarca().getIdMarca() <= 0) {
            throw new Exception("Debe seleccionar una marca válida.");
        }
        if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("El precio no puede ser negativo.");
        }
        if (producto.getStock() < 0) {
            throw new Exception("El stock no puede ser negativo.");
        }
    }
}
