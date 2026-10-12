package util;

/**
 *
 * @author ASUS
 */
public class NodoCircularSimple<T> {
    
    private T dato;
    private NodoCircularSimple<T> siguiente;

    public NodoCircularSimple(T dato) {
        this.dato = dato;
        this.siguiente = this; // un nodo solo ya es circular
    }

    public T getDato() { return dato; }

    public NodoCircularSimple<T> getSiguiente() { return siguiente; }

    public void setSiguiente(NodoCircularSimple<T> siguiente) { this.siguiente = siguiente; }
}
    
