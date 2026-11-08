/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.DecisionGarantia;
import modelo.ResultadoGarantia;
import util.ArbolBinario;
import util.NodoArbol;

public class GarantiaController {

    public static final int DIAS_DEVOLUCION = 7;
    public static final int MESES_GARANTIA = 12;

    private final ArbolBinario<DecisionGarantia> arbol = new ArbolBinario<>();
    private NodoArbol<DecisionGarantia> actual;
    private final List<String> ruta = new ArrayList<>();

    public GarantiaController() {
        construirArbol();
        reiniciar();
    }

    private void construirArbol() {
        // Hojas (decisiones)
        NodoArbol<DecisionGarantia> d1 = hoja("D1", "Sin comprobante, no se puede atender", ResultadoGarantia.RECHAZAR);
        NodoArbol<DecisionGarantia> d2 = hoja("D2", "Producto completo dentro del plazo", ResultadoGarantia.ACEPTAR_CAMBIO);
        NodoArbol<DecisionGarantia> d3 = hoja("D3", "Falla de fábrica dentro del plazo", ResultadoGarantia.ACEPTAR_CAMBIO);
        NodoArbol<DecisionGarantia> d4 = hoja("D4", "Sin empaque y sin falla de fábrica", ResultadoGarantia.RECHAZAR);
        NodoArbol<DecisionGarantia> d5 = hoja("D5", "Garantía vencida", ResultadoGarantia.RECHAZAR);
        NodoArbol<DecisionGarantia> d6 = hoja("D6", "Daño de fábrica dentro de la garantía", ResultadoGarantia.GARANTIA_FABRICANTE);
        NodoArbol<DecisionGarantia> d7 = hoja("D7", "Daño causado por el cliente", ResultadoGarantia.RECHAZAR);

        // Preguntas: pregunta(codigo, texto, hijoSi, hijoNo)
        NodoArbol<DecisionGarantia> p4 = pregunta("P4", "¿La falla es de fábrica?", d3, d4);
        NodoArbol<DecisionGarantia> p3 = pregunta("P3", "¿El empaque está completo?", d2, p4);
        NodoArbol<DecisionGarantia> p6 = pregunta("P6", "¿La falla es de fábrica?", d6, d7);
        NodoArbol<DecisionGarantia> p5 = pregunta("P5", "¿Está dentro de los " + MESES_GARANTIA + " meses?", p6, d5);
        NodoArbol<DecisionGarantia> p2 = pregunta("P2", "¿Han pasado más de " + DIAS_DEVOLUCION + " días?", p5, p3);
        NodoArbol<DecisionGarantia> p1 = pregunta("P1", "¿Tiene comprobante?", p2, d1);

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

    // --- Uso del asistente ---
    public DecisionGarantia getActual() {
        return actual.getDato();
    }

    public boolean hayDecision() {
        return actual.esHoja();
    }

    public void responder(boolean si) throws Exception {
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

    public void reiniciar() {
        actual = arbol.getRaiz();
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
