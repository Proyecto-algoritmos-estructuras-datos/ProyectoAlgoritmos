
package util;

import java.util.*;



public class ListaEnlazadaSimple {

    private NodoEnlazadoSimple cabeza;
    private int totalNodos;
    
    // Constructor
    public ListaEnlazadaSimple() {
        this.cabeza = null;
        this.totalNodos = 0;
    }
    
    // ============ INSERTAR AL FINAL ============
    public boolean insertarAlFinal(String nombreMarca) {
        NodoEnlazadoSimple nuevoNodo = new NodoEnlazadoSimple(nombreMarca);
        
        // Si la lista está vacía
        if (cabeza == null) {
            cabeza = nuevoNodo;
            totalNodos++;
            return true;
        }
        
        // Recorrer hasta el último nodo
        NodoEnlazadoSimple aux = cabeza;
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        
        // Insertar al final
        aux.setSiguiente(nuevoNodo);
        totalNodos++;
        return true;
    }
    
    // ============ BUSCAR POR NOMBRE ============
    public NodoEnlazadoSimple buscar(String nombreMarca) {
        NodoEnlazadoSimple aux = cabeza;
        
        while (aux != null) {
            if (aux.getNombreMarca().equalsIgnoreCase(nombreMarca)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        
        return null; // No encontrado
    }
    
    // ============ BUSCAR POR POSICIÓN ============
    public NodoEnlazadoSimple buscarPorPosicion(int posicion) {
        // Las posiciones empiezan en 1
        if (posicion < 1 || posicion > totalNodos) {
            return null;
        }
        
        NodoEnlazadoSimple aux = cabeza;
        int contador = 1;
        
        while (aux != null && contador < posicion) {
            aux = aux.getSiguiente();
            contador++;
        }
        
        return aux;
    }
    
    // ============ ACTUALIZAR POR POSICIÓN ============
    public boolean actualizarPorPosicion(int posicion, String nuevoNombre) {
        NodoEnlazadoSimple nodo = buscarPorPosicion(posicion);
        
        if (nodo != null) {
            nodo.setNombreMarca(nuevoNombre);
            return true;
        }
        
        return false;
    }
    
    // ============ OBTENER POSICIÓN DE UN NODO ============
    public int obtenerPosicion(String nombreMarca) {
        NodoEnlazadoSimple aux = cabeza;
        int posicion = 1;
        
        while (aux != null) {
            if (aux.getNombreMarca().equalsIgnoreCase(nombreMarca)) {
                return posicion;
            }
            aux = aux.getSiguiente();
            posicion++;
        }
        
        return -1; // No encontrado
    }
    
    // ============ LISTAR TODO ============
    public List<NodoEnlazadoSimple> listarTodo() {
        List<NodoEnlazadoSimple> lista = new ArrayList<>();
        NodoEnlazadoSimple aux = cabeza;
        
        while (aux != null) {
            lista.add(aux);
            aux = aux.getSiguiente();
        }
        
        return lista;
    }
    
    // ============ GETTERS ============
    public NodoEnlazadoSimple getCabeza() {
        return cabeza;
    }
    
    public int getTotalNodos() {
        return totalNodos;
    }
    
    public boolean estaVacia() {
        return totalNodos == 0;
    }
}