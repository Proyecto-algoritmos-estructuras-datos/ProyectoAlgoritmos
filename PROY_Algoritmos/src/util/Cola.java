package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Cola genérica con nodos enlazados (frente y final), sin límite de tamaño.
 * Regla FIFO: el primero en entrar es el primero en salir.
 * No acepta elementos null, porque null se usa para indicar que la cola
 * está vacía (igual que en Pila).
 */
public class Cola<T> {

    private NodoCola<T> nodoFrente;
    private NodoCola<T> nodoFinal;
    private int tamanio;

    public boolean estaVacia() {
        return nodoFrente == null;
    }

    public int tamanio() {
        return tamanio;
    }

    /** Agrega el elemento al final de la cola. */
    public void encolar(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("La cola no acepta elementos null");
        }
        NodoCola<T> nuevo = new NodoCola<>(elemento);
        if (estaVacia()) {
            nodoFrente = nuevo;
        } else {
            nodoFinal.setSiguiente(nuevo);
        }
        nodoFinal = nuevo;
        tamanio++;
    }

    /** Saca y devuelve el elemento del frente, o null si la cola está vacía. */
    public T desencolar() {
        if (estaVacia()) {
            return null;
        }
        T dato = nodoFrente.getDato();
        nodoFrente = nodoFrente.getSiguiente();
        if (nodoFrente == null) {
            nodoFinal = null;
        }
        tamanio--;
        return dato;
    }

    /** Devuelve el elemento del frente sin sacarlo, o null si la cola está vacía. */
    public T frente() {
        if (estaVacia()) {
            return null;
        }
        return nodoFrente.getDato();
    }

    /** Vacía la cola. */
    public void vaciar() {
        nodoFrente = null;
        nodoFinal = null;
        tamanio = 0;
    }

    /** Texto para una ventana de mensaje, del frente al final. */
    public String mostrar() {
        if (estaVacia()) {
            return "La cola está vacía.";
        }
        StringBuilder sb = new StringBuilder("Elementos de la cola (frente → final):\n");
        int posicion = 1;
        for (NodoCola<T> nodo = nodoFrente; nodo != null; nodo = nodo.getSiguiente()) {
            sb.append(posicion++).append(". ").append(nodo.getDato()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Devuelve una copia de los elementos del frente al final, sin modificar
     * la cola. Sirve para llenar la tabla: la primera fila es el frente.
     */
    public List<T> obtenerElementos() {
        List<T> lista = new ArrayList<>();
        for (NodoCola<T> nodo = nodoFrente; nodo != null; nodo = nodo.getSiguiente()) {
            lista.add(nodo.getDato());
        }
        return lista;
    }
}
