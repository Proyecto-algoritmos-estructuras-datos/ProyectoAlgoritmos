
package util;

import modelo.Marca;



public class NodoEnlazadaSimple {

    
    private Marca dato;
    private NodoEnlazadaSimple siguiente;
 
    public NodoEnlazadaSimple(Marca dato) {
        this.dato = dato;
        this.siguiente = null;
    }
 
    // GETTERS - SETTERS
    public Marca getDato() {
        return dato;
    }
 
    public void setDato(Marca dato) {
        this.dato = dato;
    }
 
    public NodoEnlazadaSimple getSiguiente() {
        return siguiente;
    }
 
    public void setSiguiente(NodoEnlazadaSimple siguiente) {
        this.siguiente = siguiente;
    }
    
}