package controlador;

import dao.VentaDAO;
import interfaces.IVentaDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import modelo.Producto;
import util.AlgoritmoOrdenamientoIndirecto;
import util.GrafoMatriz;

/**
 * Productos relacionados: dos productos estan conectados si se vendieron en la
 * misma venta COMPLETADA, y el peso de la conexion es la cantidad de ventas
 * que comparten. El grafo se arma de nuevo en cada consulta (sin cache).
 */
public class RelacionProductosController {

    private static final Comparator<Producto> POR_ID = Comparator.comparingInt(Producto::getIdProducto);

    private final IVentaDAO ventaDao;
    private final ProductoController productoController;
    private GrafoMatriz<Producto> grafo; // el ultimo que se armo; null mientras no se consulte

    public RelacionProductosController() {
        this(new VentaDAO(), new ProductoController());
    }

    // Permite probar el controlador sin base de datos
    public RelacionProductosController(IVentaDAO ventaDao, ProductoController productoController) {
        this.ventaDao = ventaDao;
        this.productoController = productoController;
    }

    // Productos que se venden junto con "base": solo activos y con stock mayor a 0,
    // de mayor a menor "veces juntos" y, si empatan, por nombre A-Z.
    // El producto base puede estar inactivo o sin stock.
    public List<Producto> sugerirProductos(Producto base) throws Exception {
        if (base == null) {
            throw new Exception("Seleccione un producto de la tabla.");
        }
        construirGrafo();
        final GrafoMatriz<Producto> g = grafo;

        List<Producto> candidatos = new ArrayList<>();
        for (Producto vecino : g.adyacentes(base)) {
            if (vecino.isEstado() && vecino.getStock() > 0) {
                candidatos.add(vecino);
            }
        }

        Producto[] arreglo = candidatos.toArray(new Producto[0]);
        AlgoritmoOrdenamientoIndirecto.quickSort(arreglo, (a, b) -> {
            int diferencia = g.peso(base, b) - g.peso(base, a); // mayor peso primero
            if (diferencia != 0) {
                return diferencia;
            }
            int porNombre = a.getNombreProducto().compareToIgnoreCase(b.getNombreProducto());
            if (porNombre != 0) {
                return porNombre;
            }
            return Integer.compare(a.getIdProducto(), b.getIdProducto());
        });
        return new ArrayList<>(Arrays.asList(arreglo));
    }

    // "Veces juntos" de dos productos, segun el ultimo grafo armado por sugerirProductos
    public int pesoCon(Producto base, Producto otro) throws Exception {
        if (grafo == null) {
            throw new Exception("Primero consulte los productos relacionados.");
        }
        return grafo.peso(base, otro);
    }

    // Igual que en el laboratorio, pero sin bloquear nada: solo informa
    public boolean validarReferenciasMinimas() throws Exception {
        construirGrafo();
        return grafo.validarReferenciasMinimas();
    }

    // Productos que todavia no se vendieron junto con ningun otro
    public int contarSinReferencias() throws Exception {
        construirGrafo();
        return grafo.contarSinReferencias();
    }

    private void construirGrafo() throws Exception {
        // Vertices: todos los productos, ordenados por id con nuestro quickSort
        Producto[] vertices = productoController.obtenerArray();
        AlgoritmoOrdenamientoIndirecto.quickSort(vertices, POR_ID);
        GrafoMatriz<Producto> nuevo = new GrafoMatriz<>(vertices, POR_ID);

        // Las lineas llegan ordenadas por venta: [inicio, fin) son de una misma venta
        List<int[]> lineas = ventaDao.listarLineasVentasCompletadas();
        int inicio = 0;
        while (inicio < lineas.size()) {
            int idVenta = lineas.get(inicio)[0];
            int fin = inicio;
            while (fin < lineas.size() && lineas.get(fin)[0] == idVenta) {
                fin++;
            }
            // Cada par de productos de la venta suma 1 en ambas posiciones
            for (int i = inicio; i < fin - 1; i++) {
                for (int j = i + 1; j < fin; j++) {
                    nuevo.agregarArista(clave(lineas.get(i)[1]), clave(lineas.get(j)[1]));
                }
            }
            inicio = fin;
        }
        grafo = nuevo;
    }

    // Producto "de busqueda": el comparador solo mira el id
    private Producto clave(int idProducto) {
        Producto p = new Producto();
        p.setIdProducto(idProducto);
        return p;
    }
}