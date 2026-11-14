/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.VentaDAO;
import interfaces.IVentaDAO;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import modelo.DecisionGarantia;
import modelo.DetalleVenta;
import modelo.ResultadoGarantia;
import modelo.UnidadVenta;
import modelo.Venta;
import util.ArbolBinario;
import util.NodoArbol;

public class GarantiaController {

    public static final int DIAS_DEVOLUCION = 7;
    public static final int MESES_GARANTIA = 12;
    private final IVentaDAO dao;
    private final ArbolBinario<DecisionGarantia> arbol = new ArbolBinario<>();
    private NodoArbol<DecisionGarantia> actual; // null mientras no se elige un producto
    private final List<String> ruta = new ArrayList<>();
    private Venta venta;
    private List<UnidadVenta> unidades = new ArrayList<>();
    private UnidadVenta productoElegido;
    private long diasTranscurridos;

    public GarantiaController() {
        this(new VentaDAO());
    }
    // Permite probar el controlador sin base de datos

    public GarantiaController(IVentaDAO dao) {
        this.dao = dao;
        construirArbol();
    }

    private void construirArbol() {
        // Hojas (decisiones)
        NodoArbol<DecisionGarantia> d1 = hoja("D1", "Fuera del plazo de cambio o devolución",
                ResultadoGarantia.RECHAZAR);
        NodoArbol<DecisionGarantia> d2 = hoja("D2", "Garantía vencida", ResultadoGarantia.RECHAZAR);
        NodoArbol<DecisionGarantia> d3 = hoja("D3", "Falla de fábrica dentro de la garantía",
                ResultadoGarantia.GARANTIA);
        NodoArbol<DecisionGarantia> d4 = hoja("D4", "Daño o mal uso del cliente",
                ResultadoGarantia.RECHAZAR);
        NodoArbol<DecisionGarantia> d5 = hoja("D5", "Falla de fábrica dentro de los " + DIAS_DEVOLUCION
                + " días", ResultadoGarantia.CAMBIO);
        NodoArbol<DecisionGarantia> d6 = hoja("D6", "Producto sin uso y con empaque completo",
                ResultadoGarantia.DEVOLUCION);
        NodoArbol<DecisionGarantia> d7 = hoja("D7", "Producto usado o con empaque incompleto",
                ResultadoGarantia.RECHAZAR);
        // Preguntas, de abajo hacia arriba: pregunta(codigo, texto, hijoSi, hijoNo)
        NodoArbol<DecisionGarantia> p6 = pregunta("P6", "¿La falla es de fábrica?", d3, d4);
        NodoArbol<DecisionGarantia> p5 = pregunta("P5", "¿Está dentro de los " + MESES_GARANTIA + "meses ?", p6, d2);
 NodoArbol<DecisionGarantia> p4 = pregunta("P4", "¿El motivo es una falla del producto?", p5,
                d1);
        NodoArbol<DecisionGarantia> p3 = pregunta("P3", "¿Está sin uso y con el empaque completo?", d6,
                d7);
        NodoArbol<DecisionGarantia> p2 = pregunta("P2", "¿El producto tiene falla de fábrica?", d5, p3);
        NodoArbol<DecisionGarantia> p1 = pregunta("P1", "¿Han pasado más de " + DIAS_DEVOLUCION + "días ?", p4, p2); 
         arbol.setRaiz(p1);
    }

    private NodoArbol<DecisionGarantia> hoja(String codigo, String texto, ResultadoGarantia resultado) {
        return new NodoArbol<>(new DecisionGarantia(codigo, texto, resultado));
    }

    private NodoArbol<DecisionGarantia> pregunta(String codigo, String texto,
            NodoArbol<DecisionGarantia> si, NodoArbol<DecisionGarantia> no) {
        NodoArbol<DecisionGarantia> nodo = new NodoArbol<>(new DecisionGarantia(codigo, texto));
        nodo.setIzquierdo(si);
        nodo.setDerecho(no);
        return nodo;
    }
// --- Venta ---
    // Busca la venta por id o por código (V0001) y devuelve una fila por cada UNIDAD vendida.
    // Limpia cualquier evaluación anterior

    public List<UnidadVenta> buscarVenta(String texto) throws Exception {
        // Si algo falla, no debe quedar una venta anterior a medias
        venta = null;
        unidades = new ArrayList<>();
        reiniciar();
        if (texto == null || texto.trim().isEmpty()) {
            throw new Exception("Escriba el código de la venta.");
        }
        Venta encontrada = dao.buscarVenta(texto);
        if (encontrada == null) {
            throw new Exception("No existe una venta con el código \"" + texto.trim() + "\".");
        }
        if (encontrada.estaAnulada()) {
            throw new Exception("La venta " + encontrada.getNumero() + " está ANULADA. No se puede evaluar.");
 }
 List<DetalleVenta> lineas = dao.verDetalle(encontrada.getIdVenta());
        if (lineas.isEmpty()) {
            throw new Exception("La venta no tiene productos.");
        }
        // Una línea con cantidad 3 se convierte en 3 unidades separadas
        List<UnidadVenta> lista = new ArrayList<>();
        for (DetalleVenta linea : lineas) {
            for (int n = 1; n <= linea.getCantidad(); n++) {
                lista.add(new UnidadVenta(linea.getProducto(), linea.getPrecioUnitario(), n,
                        linea.getCantidad()));
            }
        }
        venta = encontrada;
        unidades = lista;
        return unidades;
    }

    public Venta getVenta() {
        return venta;
    }

    // Días entre la fecha de la venta y hoy
    public long calcularDias(LocalDate hoy) {
        if (venta == null || venta.getFechaVenta() == null) {
            return 0;
        }
        return ChronoUnit.DAYS.between(venta.getFechaVenta().toLocalDate(), hoy);
    }
    // Se elige una línea de la venta y el árbol responde solo la primera pregunta (los 7 días)

    public void elegirProducto(int fila) throws Exception {
        if (venta == null) {
            throw new Exception("Primero busque una venta.");
        }
        if (fila < 0 || fila >= unidades.size()) {
            throw new Exception("Seleccione un producto de la tabla.");
        }
        reiniciar();
        productoElegido = unidades.get(fila);
        diasTranscurridos = calcularDias(LocalDate.now());
        boolean masDe7 = diasTranscurridos > DIAS_DEVOLUCION;
        actual = arbol.getRaiz();
        ruta.add(actual.getDato().getTexto() + " (han pasado " + diasTranscurridos + " días) → "
                + (masDe7 ? "Sí" : "No"));
        actual = masDe7 ? actual.getIzquierdo() : actual.getDerecho();
    }

    public UnidadVenta getProductoElegido() {
        return productoElegido;
    }

    public long getDiasTranscurridos() {
        return diasTranscurridos;
    }
    // --- Uso del asistente ---

    public boolean hayProductoElegido() {
        return actual != null;
    }

    public DecisionGarantia getActual() {
        return actual == null ? null : actual.getDato();
    }

    public boolean hayDecision() {
        return actual != null && actual.esHoja();
    }

    public void responder(boolean si) throws Exception {
        if (actual == null) {
            throw new Exception("Primero elija un producto de la venta.");
        }
        if (actual.esHoja()) {
            throw new Exception("Ya hay una decisión. Pulsa Reiniciar para atender otro reclamo.");
        }
        ruta.add(actual.getDato().getTexto() + " → " + (si ? "Sí" : "No"));
        actual = si ? actual.getIzquierdo() : actual.getDerecho();
    }

    public int contarHojas() {
        return arbol.contarHojas();
    }

    public int altura() {
        return arbol.altura();
    }

    public int longitudMaxima() {
        return arbol.altura() - 1;
    } // número de nodos - 1
    // Vuelve al inicio de la evaluación. La venta buscada se conserva para elegir otro producto

    public void reiniciar() {
        actual = null;
        productoElegido = null;
        diasTranscurridos = 0;
        ruta.clear();
    }

    public List<String> getRuta() {
        return ruta;
    }
    // --- Recorridos ---

    public List<DecisionGarantia> preorden() {
        return arbol.preorden();
    }

    public List<DecisionGarantia> inorden() {
        return arbol.inorden();
    }

    public List<DecisionGarantia> postorden() {
        return arbol.postorden();
    }
}
