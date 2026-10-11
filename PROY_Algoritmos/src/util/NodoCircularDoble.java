package util;

// Nodo de la lista circular doblemente enlazada.
// Guarda un dato y dos punteros: siguiente y anterior.
public class NodoCircularDoble<T> {

    private T dato;
    private NodoCircularDoble<T> siguiente;
    private NodoCircularDoble<T> anterior;

    public NodoCircularDoble(T dato) {
        this.dato = dato;
        // Un nodo recién creado apunta a sí mismo: así ya es una lista circular de un solo nodo
        this.siguiente = this;
        this.anterior = this;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoCircularDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircularDoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCircularDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCircularDoble<T> anterior) {
        this.anterior = anterior;
    }
}