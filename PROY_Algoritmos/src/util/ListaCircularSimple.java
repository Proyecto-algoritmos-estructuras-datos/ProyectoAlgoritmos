package util;

/**
 *
 * @author ASUS
 */
import java.util.function.Predicate;

// Lista circular simple. Solo guarda el ÚLTIMO nodo: el primero es ultimo.siguiente.
// "actual" es la alerta que se está mostrando.
public class ListaCircularSimple<T> {

    private NodoCircularSimple<T> ultimo;
    private NodoCircularSimple<T> actual;
    private int tamanio;

    public boolean estaVacia() { return ultimo == null; }

    public int tamanio() { return tamanio; }

    public void vaciar() {
        ultimo = null;
        actual = null;
        tamanio = 0;
    }

    // O(1)
    public void insertarAlFinal(T dato) {
        NodoCircularSimple<T> nuevo = new NodoCircularSimple<>(dato);
        if (estaVacia()) {
            ultimo = nuevo;
            actual = nuevo;
        } else {
            nuevo.setSiguiente(ultimo.getSiguiente());
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        tamanio++;
    }

    // O(1)
    public void insertarAlInicio(T dato) {
        NodoCircularSimple<T> nuevo = new NodoCircularSimple<>(dato);
        if (estaVacia()) {
            ultimo = nuevo;
            actual = nuevo;
        } else {
            nuevo.setSiguiente(ultimo.getSiguiente());
            ultimo.setSiguiente(nuevo); // ultimo no cambia
        }
        tamanio++;
    }

    // O(1)
    public boolean eliminarAlInicio() {
        if (estaVacia()) {
            return false;
        }
        NodoCircularSimple<T> primero = ultimo.getSiguiente();
        if (primero == ultimo) { // único nodo
            ultimo = null;
            actual = null;
        } else {
            ultimo.setSiguiente(primero.getSiguiente());
            if (actual == primero) {
                actual = primero.getSiguiente();
            }
        }
        primero.setSiguiente(null);
        tamanio--;
        return true;
    }

    // O(n): elimina el primer nodo que cumpla el criterio
    public boolean eliminar(Predicate<T> criterio) {
        if (estaVacia()) {
            return false;
        }
        NodoCircularSimple<T> previo = ultimo;
        do {
            NodoCircularSimple<T> nodo = previo.getSiguiente();
            if (criterio.test(nodo.getDato())) {
                if (tamanio == 1) {
                    ultimo = null;
                    actual = null;
                } else {
                    previo.setSiguiente(nodo.getSiguiente());
                    if (nodo == ultimo) {
                        ultimo = previo;
                    }
                    if (nodo == actual) {
                        actual = nodo.getSiguiente();
                    }
                }
                nodo.setSiguiente(null);
                tamanio--;
                return true;
            }
            previo = nodo;
        } while (previo != ultimo);
        return false;
    }

    // O(1): pasa a la siguiente alerta (después de la última vuelve a la primera)
    public T avanzar() {
        if (estaVacia()) {
            return null;
        }
        actual = actual.getSiguiente();
        return actual.getDato();
    }

    public T getActual() {
        return (actual == null) ? null : actual.getDato();
    }
}
