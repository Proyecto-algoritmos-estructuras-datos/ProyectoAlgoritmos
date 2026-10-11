package util;

import java.util.List;
import modelo.MovimientoInventario;

public class NodoEnlazadaDoble {
    private List<MovimientoInventario> subLista; // Los registros de esta página
    private NodoEnlazadaDoble anterior;
    private NodoEnlazadaDoble siguiente;

    public NodoEnlazadaDoble(List<MovimientoInventario> subLista) {
        this.subLista = subLista;
        this.anterior = null;
        this.siguiente = null;
    }

    public List<MovimientoInventario> getSubLista() { return subLista; }
    public void setSubLista(List<MovimientoInventario> subLista) { this.subLista = subLista; }

    public NodoEnlazadaDoble getAnterior() { return anterior; }
    public void setAnterior(NodoEnlazadaDoble anterior) { this.anterior = anterior; }

    public NodoEnlazadaDoble getSiguiente() { return siguiente; }
    public void setSiguiente(NodoEnlazadaDoble siguiente) { this.siguiente = siguiente; }
}
