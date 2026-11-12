/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ArbolBinarioBusqueda<T> {

    private NodoABB<T> raiz;
    private final Comparator<T> comparador;

    public ArbolBinarioBusqueda(Comparator<T> comparador) {
        this.comparador = comparador;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    // Menor va a la izquierda; igual o mayor va a la derecha
    public void insertar(T dato) {
        raiz = insertar(raiz, dato);
    }

    private NodoABB<T> insertar(NodoABB<T> nodo, T dato) {
        if (nodo == null) {
            return new NodoABB<>(dato);
        }
        if (comparador.compare(dato, nodo.getDato()) < 0) {
            nodo.setIzquierdo(insertar(nodo.getIzquierdo(), dato));
        } else {
            nodo.setDerecho(insertar(nodo.getDerecho(), dato));
        }
        return nodo;
    }

    // Izquierda, raíz, derecha: sale ordenado de menor a mayor
    public List<T> recorridoInorden() {
        List<T> resultado = new ArrayList<>();
        inorden(raiz, resultado);
        return resultado;
    }

    private void inorden(NodoABB<T> nodo, List<T> resultado) {
        if (nodo == null) {
            return;
        }
        inorden(nodo.getIzquierdo(), resultado);
        resultado.add(nodo.getDato());
        inorden(nodo.getDerecho(), resultado);
    }

    // Todos los elementos cuyo valor es igual al de "referencia" (según el comparador)
    public List<T> buscarExacto(T referencia) {
        List<T> resultado = new ArrayList<>();
        buscarExacto(raiz, referencia, resultado);
        return resultado;
    }

    private void buscarExacto(NodoABB<T> nodo, T referencia, List<T> resultado) {
        if (nodo == null) {
            return;
        }
        int c = comparador.compare(referencia, nodo.getDato());
        if (c < 0) {
            buscarExacto(nodo.getIzquierdo(), referencia, resultado);
        } else if (c > 0) {
            buscarExacto(nodo.getDerecho(), referencia, resultado);
        } else {
            resultado.add(nodo.getDato());
            // Los repetidos siempre se insertaron a la derecha
            buscarExacto(nodo.getDerecho(), referencia, resultado);
        }
    }

    // Todos los elementos cuya clave empieza con el prefijo (sin distinguir mayúsculas)
    public List<T> buscarPorPrefijo(String prefijo, Function<T, String> clave) {
        List<T> resultado = new ArrayList<>();
        buscarPorPrefijo(raiz, prefijo, clave, resultado);
        return resultado;
    }

    private void buscarPorPrefijo(NodoABB<T> nodo, String prefijo,
            Function<T, String> clave, List<T> resultado) {
        if (nodo == null) {
            return;
        }
        String texto = clave.apply(nodo.getDato());
        if (texto == null) {
            texto = "";
        }
        String inicio = texto.substring(0, Math.min(texto.length(), prefijo.length()));
        int c = String.CASE_INSENSITIVE_ORDER.compare(prefijo, inicio);
        if (c < 0) {
            // Todo lo que empieza con el prefijo es menor que este nodo
            buscarPorPrefijo(nodo.getIzquierdo(), prefijo, clave, resultado);
        } else if (c > 0) {
            buscarPorPrefijo(nodo.getDerecho(), prefijo, clave, resultado);
        } else {
            // Coincide: puede haber más a ambos lados (inorden: sale ordenado)
            buscarPorPrefijo(nodo.getIzquierdo(), prefijo, clave, resultado);
            resultado.add(nodo.getDato());
            buscarPorPrefijo(nodo.getDerecho(), prefijo, clave, resultado);
        }
    }

}
