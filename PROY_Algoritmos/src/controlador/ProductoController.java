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

    public List<Producto> verProductosActivosPorCategoria(int idCategoria) throws Exception {
        if (idCategoria <= 0) {
            throw new Exception("Debe seleccionar una categoría válida.");
        }
        return dao.verProductosActivosPorCategoria(idCategoria);
    }

    public List<Producto> verProductosConStockBajo() throws Exception {
        return dao.verProductosConStockBajo();
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
        if (producto.getDescripcion() != null && producto.getDescripcion().length() > 255) {
            throw new Exception("La descripción no puede superar los 255 caracteres.");
        }
        if (producto.getCategoria() == null || producto.getCategoria().getIdCategoria() <= 0) {
            throw new Exception("Debe seleccionar una categoría válida.");
        }
        if (producto.getMarca() == null || producto.getMarca().getIdMarca() <= 0) {
            throw new Exception("Debe seleccionar una marca válida.");
        }
        
        // Modificar luego y unificar esta condicional con la que le sigue
        if (producto.getPrecioCompra() == null) {
            producto.setPrecioCompra(BigDecimal.ZERO);
        }
        if (producto.getPrecioCompra().compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("El precio de compra no puede ser negativo.");
        }
        if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception("El precio no puede ser negativo.");
        }
        if (producto.getStock() < 0) {
            throw new Exception("El stock no puede ser negativo.");
        }
        if (producto.getStockMinimo() < 0) {
            throw new Exception("El stock mínimo no puede ser negativo.");
        }

        producto.setNombreProducto(producto.getNombreProducto().trim());
        validarCodigo(producto);
    }

    private void validarCodigo(Producto producto) throws Exception {
        // El código es opcional: un campo vacío se guarda como NULL. Si se guardara "",
        // el segundo producto sin código chocaría con el UNIQUE de la tabla.
        String codigo = producto.getCodigo();
        if (codigo == null || codigo.trim().isEmpty()) {
            producto.setCodigo(null);
            return;
        }
        codigo = codigo.trim();
        if (codigo.length() > 30) {
            throw new Exception("El código no puede superar los 30 caracteres.");
        }
        producto.setCodigo(codigo);

        for (Producto p : dao.verTodosLosProductos()) {
            if (p.getIdProducto() != producto.getIdProducto()
                    && p.getCodigo() != null
                    && p.getCodigo().equalsIgnoreCase(codigo)) {
                throw new Exception("Ya existe un producto con ese código.");
            }
        }
    }
}