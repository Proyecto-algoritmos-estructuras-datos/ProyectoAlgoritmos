package util;

import java.util.List;
import modelo.MovimientoInventario;

public class ListaEnlazadaDoble {
    private NodoEnlazadaDoble inicio;
    private NodoEnlazadaDoble fin;
    private NodoEnlazadaDoble actual;
    private int ElementosPorPagina; // Cantidad de elementos por página (ej. 15)

    public ListaEnlazadaDoble(List<MovimientoInventario> listaTotal, int elementosPorPagina) {
        this.ElementosPorPagina = elementosPorPagina;
        construirLista(listaTotal);
    }

    private void construirLista(List<MovimientoInventario> listaTotal) {
        if (listaTotal == null || listaTotal.isEmpty()) {
            inicio = null;
            fin = null;
            actual = null;
            return;
        }

        NodoEnlazadaDoble ultimoNodo = null;
        for (int i = 0; i < listaTotal.size(); i += ElementosPorPagina) {
            int finIndice = Math.min(i + ElementosPorPagina, listaTotal.size());
            List<MovimientoInventario> sub = listaTotal.subList(i, finIndice);

            NodoEnlazadaDoble nuevoNodo = new NodoEnlazadaDoble(sub);
            if (inicio == null) {
                inicio = nuevoNodo;
                actual = inicio;
            } else {
                ultimoNodo.setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(ultimoNodo);
            }
            ultimoNodo = nuevoNodo;
        }
        fin = ultimoNodo;
    }

    public NodoEnlazadaDoble getActual() { return actual; }
    
    public List<MovimientoInventario> irPrimero() {
        if (inicio != null) actual = inicio;
        return actual != null ? actual.getSubLista() : null;
    }

    public List<MovimientoInventario> irUltimo() {
        if (fin != null) actual = fin;
        return actual != null ? actual.getSubLista() : null;
    }

    public List<MovimientoInventario> irSiguiente() {
        if (actual != null && actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual != null ? actual.getSubLista() : null;
    }

    public List<MovimientoInventario> irAnterior() {
        if (actual != null && actual.getAnterior() != null) {
            actual = actual.getAnterior();
        }
        return actual != null ? actual.getSubLista() : null;
    }
}