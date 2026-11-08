package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Pila estática genérica (basada en arreglo) con capacidad fija.
 * Regla LIFO: el último en entrar es el primero en salir.
 * No acepta elementos null, porque null se usa para indicar que una
 * operación falló.
 */
public class Pila<T> {

    private final Object[] vectorPila;
    private int cima;               // índice de la cima, no el tamaño
    private final int capacidad;

    public Pila(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0");
        }
        this.capacidad = capacidad;
        this.vectorPila = new Object[capacidad];
        this.cima = -1;
    }

    public boolean estaVacia() {
        return cima == -1;
    }

    public boolean estaLlena() {
        return cima == capacidad - 1;
    }

    /** Apila el elemento. Devuelve false si la pila está llena (evita desbordamiento). */
    public boolean insertar(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("La pila no acepta elementos null");
        }
        if (estaLlena()) {
            return false;
        }
        cima++;
        vectorPila[cima] = elemento;
        return true;
    }

    /** Desapila y devuelve la cima, o null si la pila está vacía. */
    @SuppressWarnings("unchecked")
    public T eliminar() {
        if (estaVacia()) {
            return null;
        }
        T elemento = (T) vectorPila[cima];
        vectorPila[cima] = null;    // suelta la referencia al objeto
        cima--;
        return elemento;
    }

    /** Devuelve la cima sin sacarla, o null si la pila está vacía. */
    @SuppressWarnings("unchecked")
    public T ultimoElemento() {
        if (estaVacia()) {
            return null;
        }
        return (T) vectorPila[cima];
    }

    /** Vacía la pila. Se limpian las referencias para no retener objetos en memoria. */
    public void vaciar() {
        for (int i = 0; i <= cima; i++) {
            vectorPila[i] = null;
        }
        cima = -1;
    }

    public int getTamano() {
        return cima + 1;
    }

    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Devuelve una copia de los elementos en el orden en que entraron
     * (de la base a la cima), sin modificar la pila. Sirve para llenar
     * la tabla del carrito: la última fila es la cima.
     */
    @SuppressWarnings("unchecked")
    public List<T> obtenerElementos() {
        List<T> lista = new ArrayList<>();
        for (int i = 0; i <= cima; i++) {
            lista.add((T) vectorPila[i]);
        }
        return lista;
    }

    /** Texto para una ventana de mensaje, de cima a base (opcional). */
    public String mostrarGrafico() {
        if (estaVacia()) {
            return "La pila está vacía.";
        }
        StringBuilder sb = new StringBuilder("Elementos de la pila:\n");
        for (int i = cima; i >= 0; i--) {
            sb.append(vectorPila[i]).append("\n");
        }
        return sb.toString();
    }
}