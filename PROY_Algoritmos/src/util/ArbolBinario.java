/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinario<T> {

    private NodoArbol<T> raiz;

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
        this.raiz = raiz;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    // Raíz, izquierda, derecha
    public List<T> preorden() {
        List<T> resultado = new ArrayList<>();
        preorden(raiz, resultado);
        return resultado;
    }

    private void preorden(NodoArbol<T> nodo, List<T> resultado) {
        if (nodo == null) {
            return;
        }
        resultado.add(nodo.getDato());
        preorden(nodo.getIzquierdo(), resultado);
        preorden(nodo.getDerecho(), resultado);
    }

    // Izquierda, raíz, derecha
    public List<T> inorden() {
        List<T> resultado = new ArrayList<>();
        inorden(raiz, resultado);
        return resultado;
    }

    private void inorden(NodoArbol<T> nodo, List<T> resultado) {
        if (nodo == null) {
            return;
        }
        inorden(nodo.getIzquierdo(), resultado);
        resultado.add(nodo.getDato());
        inorden(nodo.getDerecho(), resultado);
    }

    // Izquierda, derecha, raíz
    public List<T> postorden() {
        List<T> resultado = new ArrayList<>();
        postorden(raiz, resultado);
        return resultado;
    }

    private void postorden(NodoArbol<T> nodo, List<T> resultado) {
        if (nodo == null) {
            return;
        }
        postorden(nodo.getIzquierdo(), resultado);
        postorden(nodo.getDerecho(), resultado);
        resultado.add(nodo.getDato());
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(NodoArbol<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.esHoja()) {
            return 1;
        }
        return contarHojas(nodo.getIzquierdo()) + contarHojas(nodo.getDerecho());
    }

// Número de nodos de la ruta más larga (nivel del último nodo + 1, como en el PDF)
    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoArbol<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
    }
}
