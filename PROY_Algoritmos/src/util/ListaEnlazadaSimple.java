
package util;

import java.util.*;
import modelo.Marca;



public class ListaEnlazadaSimple {

     private NodoEnlazadaSimple cabeza;
    private NodoEnlazadaSimple cola;
    private int tamanio;

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public NodoEnlazadaSimple getCabeza() {
        return cabeza;
    }

    // INSERCIÓN: siempre al final
    public void agregarAlFinal(Marca marca) {
        NodoEnlazadaSimple nuevo = new NodoEnlazadaSimple(marca);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            cola.setSiguiente(nuevo);
        }
        cola = nuevo;
        tamanio++;
    }

    // BÚSQUEDA por ID: devuelve el NODO (el formulario lo necesita para poder seguir avanzando)
    public NodoEnlazadaSimple buscarNodoPorId(int id) {
        NodoEnlazadaSimple actual = cabeza;
        while (actual != null) {
            if (actual.getDato().getIdMarca() == id) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // BÚSQUEDA por nombre (sin distinguir mayúsculas/minúsculas)
    public NodoEnlazadaSimple buscarNodoPorNombre(String nombre) {
        if (nombre == null) {
            return null;
        }
        String buscado = nombre.trim();
        NodoEnlazadaSimple actual = cabeza;
        while (actual != null) {
            if (actual.getDato().getNombreMarca().trim().equalsIgnoreCase(buscado)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // ACTUALIZACIÓN: cambia los datos del nodo que tiene ese ID
    public boolean actualizar(Marca marcaNueva) {
        NodoEnlazadaSimple nodo = buscarNodoPorId(marcaNueva.getIdMarca());
        if (nodo == null) {
            return false;
        }
        nodo.setDato(marcaNueva);
        return true;
    }

    public void vaciar() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }
 
}