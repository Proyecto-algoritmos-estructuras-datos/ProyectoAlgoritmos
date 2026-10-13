
package util;



public class NodoEnlazadoSimple {

    private String nombreMarca;
    private NodoEnlazadoSimple siguiente;

    public NodoEnlazadoSimple() {
    }
    
    // Getters - setters

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public NodoEnlazadoSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEnlazadoSimple siguiente) {
        this.siguiente = siguiente;
    }

    




}