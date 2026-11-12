/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

public class NodoABB<T> {

    private T dato;
    private NodoABB<T> izquierdo;
    private NodoABB<T> derecho;

    public NodoABB(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public NodoABB<T> getIzquierdo() {
        return izquierdo;
    }

    public NodoABB<T> getDerecho() {
        return derecho;
    }

    public void setIzquierdo(NodoABB<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoABB<T> derecho) {
        this.derecho = derecho;
    }

}
