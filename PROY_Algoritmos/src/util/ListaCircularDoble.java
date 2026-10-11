package util;

import java.util.Objects;
import java.util.function.Consumer;

// Lista circular doblemente enlazada
// - El siguiente del último nodo es la cabeza.
// - El anterior de la cabeza es el último nodo.
// - Con un solo nodo, siguiente y anterior apuntan a sí mismo.
// "actual" es el cursor: el nodo que se está viendo en pantalla.
public class ListaCircularDoble<T> {

    private NodoCircularDoble<T> cabeza;
    private NodoCircularDoble<T> actual;
    private int tamanio;

    public ListaCircularDoble() {
        cabeza = null;
        actual = null;
        tamanio = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int tamanio() {
        return tamanio;
    }

    // ---------------------------------------------------------------
    // Inserción
    // ---------------------------------------------------------------

    public void insertarAlInicio(T dato) {
        NodoCircularDoble<T> nuevo = new NodoCircularDoble<>(dato);
        if (estaVacia()) {
            cabeza = nuevo;
            actual = nuevo;
        } else {
            enlazarAntesDeLaCabeza(nuevo);
            cabeza = nuevo; // el nuevo pasa a ser la cabeza
        }
        tamanio++;
    }

    public void insertarAlFinal(T dato) {
        NodoCircularDoble<T> nuevo = new NodoCircularDoble<>(dato);
        if (estaVacia()) {
            cabeza = nuevo;
            actual = nuevo;
        } else {
            enlazarAntesDeLaCabeza(nuevo); // antes de la cabeza = al final de la vuelta
        }
        tamanio++;
    }

    // Mete el nodo entre el último y la cabeza (la lista no debe estar vacía)
    private void enlazarAntesDeLaCabeza(NodoCircularDoble<T> nuevo) {
        NodoCircularDoble<T> ultimo = cabeza.getAnterior();
        nuevo.setSiguiente(cabeza);
        nuevo.setAnterior(ultimo);
        ultimo.setSiguiente(nuevo);
        cabeza.setAnterior(nuevo);
    }

    // ---------------------------------------------------------------
    // Eliminación (cabeza, cola, medio o único nodo)
    // ---------------------------------------------------------------

    // Elimina el primer nodo que contenga el dato. Devuelve false si no lo encontró.
    public boolean eliminar(T dato) {
        NodoCircularDoble<T> nodo = buscarNodo(dato);
        if (nodo == null) {
            return false;
        }

        if (tamanio == 1) {
            // Único nodo: la lista queda vacía
            cabeza = null;
            actual = null;
        } else {
            NodoCircularDoble<T> previo = nodo.getAnterior();
            NodoCircularDoble<T> posterior = nodo.getSiguiente();
            previo.setSiguiente(posterior);
            posterior.setAnterior(previo);

            if (nodo == cabeza) {
                cabeza = posterior;
            }
            if (nodo == actual) {
                actual = posterior;
            }
        }

        // Se sueltan los punteros del nodo eliminado
        nodo.setSiguiente(null);
        nodo.setAnterior(null);
        tamanio--;
        return true;
    }

    public void vaciar() {
        cabeza = null;
        actual = null;
        tamanio = 0;
    }

    // ---------------------------------------------------------------
    // Navegación con el cursor (circular)
    // ---------------------------------------------------------------

    // Mueve el cursor al siguiente y devuelve su dato (null si la lista está vacía)
    public T avanzar() {
        if (estaVacia()) {
            return null;
        }
        actual = actual.getSiguiente();
        return actual.getDato();
    }

    // Mueve el cursor al anterior y devuelve su dato (null si la lista está vacía)
    public T retroceder() {
        if (estaVacia()) {
            return null;
        }
        actual = actual.getAnterior();
        return actual.getDato();
    }

    public void irAlPrimero() {
        actual = cabeza;
    }

    // Lleva el cursor a la posición indicada (0 = primero). Devuelve false si el índice no es válido.
    public boolean irAIndice(int indice) {
        if (indice < 0 || indice >= tamanio) {
            return false;
        }
        actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return true;
    }

    // Dato bajo el cursor (null si la lista está vacía)
    public T getActual() {
        return (actual == null) ? null : actual.getDato();
    }

    // Posición del cursor (0 = primero, -1 si la lista está vacía)
    public int getIndiceActual() {
        if (estaVacia()) {
            return -1;
        }
        int indice = 0;
        NodoCircularDoble<T> aux = cabeza;
        do {
            if (aux == actual) {
                return indice;
            }
            aux = aux.getSiguiente();
            indice++;
        } while (aux != cabeza);
        return -1;
    }

    // ---------------------------------------------------------------
    // Búsqueda y recorrido
    // ---------------------------------------------------------------

    // Devuelve la posición del dato (0 = primero) o -1 si no está. No mueve el cursor.
    public int buscar(T dato) {
        if (estaVacia()) {
            return -1;
        }
        int indice = 0;
        NodoCircularDoble<T> aux = cabeza;
        do {
            if (Objects.equals(aux.getDato(), dato)) {
                return indice;
            }
            aux = aux.getSiguiente();
            indice++;
        } while (aux != cabeza);
        return -1;
    }

    // Recorre UNA vuelta completa desde la cabeza y ejecuta la acción en cada dato.
    // Con do-while se termina al volver a la cabeza (no hay bucle infinito).
    public void recorrer(Consumer<T> accion) {
        if (estaVacia()) {
            return;
        }
        NodoCircularDoble<T> aux = cabeza;
        do {
            accion.accept(aux.getDato());
            aux = aux.getSiguiente();
        } while (aux != cabeza);
    }

    // Igual que buscar pero devuelve el nodo (uso interno)
    private NodoCircularDoble<T> buscarNodo(T dato) {
        if (estaVacia()) {
            return null;
        }
        NodoCircularDoble<T> aux = cabeza;
        do {
            if (Objects.equals(aux.getDato(), dato)) {
                return aux;
            }
            aux = aux.getSiguiente();
        } while (aux != cabeza);
        return null;
    }
}