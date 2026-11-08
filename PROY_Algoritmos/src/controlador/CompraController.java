package controlador;

import dao.CompraDAO;
import interfaces.ICompraDAO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import modelo.Compra;
import modelo.DetalleCompra;
import modelo.Empleado;
import modelo.Producto;
import modelo.Proveedor;
import util.Pila;
import util.SesionActual;

// Una instancia de este controller representa UNA compra en curso: guarda el proveedor
// elegido y el carrito (una Pila). El formulario debe crear una sola instancia y reutilizarla.
public class CompraController {
    public static final int LIMITE_CARRITO = 20;

    // Límites de las columnas DECIMAL de la base de datos
    private static final BigDecimal MAX_PRECIO = new BigDecimal("99999999.99");   // DECIMAL(10,2)
    private static final BigDecimal MAX_TOTAL = new BigDecimal("9999999999.99");  // DECIMAL(12,2)

    private final ICompraDAO dao = new CompraDAO();
    private final Pila<DetalleCompra> carrito = new Pila<>(LIMITE_CARRITO);
    private Proveedor proveedorSeleccionado;

    // ---------------------------------------------------------------- Proveedor

    public void seleccionarProveedor(Proveedor proveedor) throws Exception {
        if (proveedor == null || proveedor.getIdProveedor() <= 0) {
            throw new Exception("Debe seleccionar un proveedor válido.");
        }
        if (!proveedor.isEstado()) {
            throw new Exception("El proveedor seleccionado está inactivo.");
        }
        if (proveedorBloqueado() && proveedorSeleccionado.getIdProveedor() != proveedor.getIdProveedor()) {
            throw new Exception("No se puede cambiar de proveedor con productos en el carrito. Vacíe el carrito primero.");
        }
        proveedorSeleccionado = proveedor;
    }

    public Proveedor getProveedorSeleccionado() {
        return proveedorSeleccionado;
    }

    // Una vez que hay productos en el carrito, el proveedor ya no se puede cambiar
    public boolean proveedorBloqueado() {
        return proveedorSeleccionado != null && !carrito.estaVacia();
    }

    // ------------------------------------------------------------------ Carrito

    // Precio de costo que se muestra al elegir un producto. Devuelve null si el producto
    // nunca se compró (precio 0), para que el campo salga vacío y el usuario deba escribirlo.
    public BigDecimal sugerirPrecioCosto(Producto producto) {
        if (producto == null || producto.getPrecioCompra() == null
                || producto.getPrecioCompra().compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }
        return producto.getPrecioCompra();
    }

    public void agregarAlCarrito(Producto producto, int cantidad, BigDecimal precioUnitario) throws Exception {
        if (proveedorSeleccionado == null) {
            throw new Exception("Primero debe seleccionar un proveedor.");
        }
        if (producto == null || producto.getIdProducto() <= 0) {
            throw new Exception("Debe seleccionar un producto válido.");
        }
        if (!producto.isEstado()) {
            throw new Exception("El producto seleccionado está inactivo.");
        }
        if (cantidad <= 0) {
            throw new Exception("La cantidad debe ser mayor a 0.");
        }
        if (precioUnitario == null) {
            throw new Exception("Ingrese el precio de costo.");
        }
        precioUnitario = precioUnitario.setScale(2, RoundingMode.HALF_UP);
        if (precioUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("El precio de costo debe ser mayor a 0.");
        }
        if (precioUnitario.compareTo(MAX_PRECIO) > 0) {
            throw new Exception("El precio de costo no puede superar 99,999,999.99.");
        }
        if (carrito.estaLlena()) {
            throw new Exception("El carrito está lleno (máximo " + LIMITE_CARRITO + " productos).");
        }
        if (estaEnElCarrito(producto)) {
            throw new Exception("Ese producto ya está en el carrito. Use \"Deshacer último\" si necesita corregirlo.");
        }

        DetalleCompra detalle = new DetalleCompra(producto, cantidad, precioUnitario);
        if (calcularTotal().add(detalle.getSubtotal()).compareTo(MAX_TOTAL) > 0) {
            throw new Exception("El total de la compra supera el máximo permitido.");
        }
        carrito.insertar(detalle);
    }

    // Quita el último producto agregado (la cima de la pila) y lo devuelve
    public DetalleCompra deshacerUltimo() throws Exception {
        DetalleCompra eliminado = carrito.eliminar();
        if (eliminado == null) {
            throw new Exception("No hay productos en el carrito para deshacer.");
        }
        return eliminado;
    }

    // Solo vacía el carrito; el proveedor elegido se conserva
    public void vaciarCarrito() {
        carrito.vaciar();
    }

    // Deja el controller como nuevo: sin productos y sin proveedor (Cancelar y después de guardar)
    public void reiniciarCompra() {
        carrito.vaciar();
        proveedorSeleccionado = null;
    }

    // Productos en orden de ingreso; el último de la lista es la cima de la pila
    public List<DetalleCompra> verCarrito() {
        return carrito.obtenerElementos();
    }

    public DetalleCompra getUltimoDelCarrito() {
        return carrito.ultimoElemento();
    }

    public int getCantidadEnCarrito() {
        return carrito.getTamano();
    }

    public boolean carritoVacio() {
        return carrito.estaVacia();
    }

    public boolean carritoLleno() {
        return carrito.estaLlena();
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO.setScale(2);
        for (DetalleCompra detalle : carrito.obtenerElementos()) {
            total = total.add(detalle.getSubtotal());
        }
        return total;
    }

    // Texto de la pila de cima a base, para el botón opcional "Ver pila"
    public String mostrarPila() {
        return carrito.mostrarGrafico();
    }

    // ------------------------------------------------------------------ Guardar

    // Guarda la compra como PENDIENTE y devuelve la compra con su id. Si falla, el carrito se conserva.
    public Compra guardarCompra() throws Exception {
        if (proveedorSeleccionado == null) {
            throw new Exception("Debe seleccionar un proveedor.");
        }
        if (carrito.estaVacia()) {
            throw new Exception("El carrito está vacío. Agregue al menos un producto.");
        }
        Empleado empleado = SesionActual.getEmpleado();
        if (empleado == null) {
            throw new Exception("No hay una sesión activa. Inicie sesión nuevamente.");
        }

        Compra compra = new Compra(proveedorSeleccionado, empleado, calcularTotal(), carrito.obtenerElementos());
        Compra guardada = dao.registrarCompra(compra);
        reiniciarCompra();
        return guardada;
    }

    // ------------------------------------------------------------------ Apoyo

    private boolean estaEnElCarrito(Producto producto) {
        for (DetalleCompra detalle : carrito.obtenerElementos()) {
            if (detalle.getProducto().getIdProducto() == producto.getIdProducto()) {
                return true;
            }
        }
        return false;
    }
}