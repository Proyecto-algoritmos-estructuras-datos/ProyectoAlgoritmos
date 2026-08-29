package controlador;

import dao.ProductoDAO;
import interfaces.IProductoDAO;
import java.util.List;
import modelo.Producto;
import utilidades._ResumenStock;
import utilidades.Validaciones;

public class ProductoController {

    private final IProductoDAO productoDAO;

    public ProductoController() {
        this.productoDAO = new ProductoDAO();
    }

    public void registrarProducto(Producto producto) throws Exception {
        if (producto == null) {
            throw new Exception("El producto no puede ser nulo.");
        }
        if (Validaciones.campoVacio(producto.getNombre())) {
            throw new Exception("Ingrese el nombre del producto.");
        }
        if (!Validaciones.longitudMaxima(producto.getNombre(), 100)) {
            throw new Exception("El nombre del producto no puede superar los 100 caracteres.");
        }
        if (Validaciones.campoVacio(producto.getCategoria())) {
            throw new Exception("Ingrese la categoría del producto.");
        }
        if (producto.getStock() < 0) {
            throw new Exception("El stock no puede ser negativo.");
        }
        if (producto.getPrecio() <= 0) {
            throw new Exception("El precio debe ser mayor a 0.");
        }

        productoDAO.registrarProducto(producto);
    }

    public void actualizarProducto(Producto producto) throws Exception {
        if (producto == null) {
            throw new Exception("El producto no puede ser nulo.");
        }
        if (producto.getIdProducto() <= 0) {
            throw new Exception("El ID del producto no es válido.");
        }
        if (Validaciones.campoVacio(producto.getNombre())) {
            throw new Exception("Ingrese el nombre del producto.");
        }
        if (!Validaciones.longitudMaxima(producto.getNombre(), 100)) {
            throw new Exception("El nombre del producto no puede superar los 100 caracteres.");
        }
        if (Validaciones.campoVacio(producto.getCategoria())) {
            throw new Exception("Ingrese la categoría del producto.");
        }
        if (producto.getStock() < 0) {
            throw new Exception("El stock no puede ser negativo.");
        }
        if (producto.getPrecio() <= 0) {
            throw new Exception("El precio debe ser mayor a 0.");
        }
        if (productoDAO.buscarProductoPorID(producto.getIdProducto()) == null) {
            throw new Exception("No se encontró el producto a actualizar.");
        }

        productoDAO.actualizarProducto(producto);
    }

    public void cambiarEstadoProducto(int idProducto, boolean activo) throws Exception {
        if (idProducto <= 0) {
            throw new Exception("El ID del producto no es válido.");
        }
        if (productoDAO.buscarProductoPorID(idProducto) == null) {
            throw new Exception("No se encontró el producto.");
        }

        productoDAO.cambiarEstadoProducto(idProducto, activo);
    }

    public List<Producto> verTodosLosProductos() throws Exception {
        List<Producto> lista = productoDAO.verTodosLosProductos();

        if (lista.isEmpty()) {
            throw new Exception("No hay productos registrados.");
        }

        return lista;
    }

    public List<Producto> verProductosPorEstado(boolean activo) throws Exception {
        List<Producto> lista = productoDAO.verProductosPorEstado(activo);
        String estado = activo ? "activos" : "inactivos";

        if (lista.isEmpty()) {
            throw new Exception("No hay productos " + estado + ".");
        }

        return lista;
    }

    public Producto buscarProductoPorID(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("El ID del producto no es válido.");
        }

        Producto producto = productoDAO.buscarProductoPorID(id);

        if (producto == null) {
            throw new Exception("No se encontró ningún producto con el ID: " + id);
        }

        return producto;
    }
    
    public List<Producto> listarConFiltros(String nombre, String categoria, String estadoStock, String precioMinTexto, String precioMaxTexto) throws Exception {
        Double precioMin = null;
        Double precioMax = null;

        try {
            if (precioMinTexto != null && !precioMinTexto.isBlank()) {
                precioMin = Double.parseDouble(precioMinTexto.trim());
            }
            if (precioMaxTexto != null && !precioMaxTexto.isBlank()) {
                precioMax = Double.parseDouble(precioMaxTexto.trim());
            }
        } catch (NumberFormatException e) {
            throw new Exception("El precio debe ser un número válido (ej: 15.50)");
        }

        if (precioMin != null && precioMin < 0) {
            throw new Exception("El precio mínimo no puede ser negativo.");
        }
        if (precioMax != null && precioMax < 0) {
            throw new Exception("El precio máximo no puede ser negativo.");
        }
    
        if (precioMin != null && precioMax != null && precioMin > precioMax) {
            throw new Exception("El precio mínimo no puede ser mayor al precio máximo.");
        }
        
        return productoDAO.listarConFiltros(nombre, categoria, estadoStock, precioMin, precioMax);
    }
    
    public _ResumenStock obtenerResumenStock() throws Exception {
        return productoDAO.obtenerResumenStock();
    }
}