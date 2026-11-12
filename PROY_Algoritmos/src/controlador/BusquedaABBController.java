/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import util.ArbolBinarioBusqueda;

public class BusquedaABBController {

    // Sin texto: todo ordenado por el comparador
    public <T> List<T> ordenar(List<T> datos, Comparator<T> comparador) throws Exception {
        return construirArbol(datos, comparador).recorridoInorden();
    }

    // Campos de texto: "empieza con", sin distinguir mayúsculas
    public <T> List<T> buscarPorPrefijo(List<T> datos, Comparator<T> comparador,
            String texto, Function<T, String> clave) throws Exception {
        if (texto == null || texto.trim().isEmpty()) {
            throw new Exception("Escriba el texto a buscar.");
        }
        return construirArbol(datos, comparador).buscarPorPrefijo(texto.trim(), clave);
    }

    // Campos numéricos: valor exacto. "referencia" es un objeto con solo ese campo lleno.
    public <T> List<T> buscarExacto(List<T> datos, Comparator<T> comparador, T referencia) throws Exception {
        if (referencia == null) {
            throw new Exception("Valor de búsqueda inválido.");
        }
        return construirArbol(datos, comparador).buscarExacto(referencia);
    }

    private <T> ArbolBinarioBusqueda<T> construirArbol(List<T> datos, Comparator<T> comparador) throws Exception {
        if (datos == null || datos.isEmpty()) {
            throw new Exception("No hay datos cargados para ordenar o buscar.");
        }
        if (comparador == null) {
            throw new Exception("Seleccione un campo en 'Ordenar por'.");
        }
        ArbolBinarioBusqueda<T> arbol = new ArbolBinarioBusqueda<>(comparador);
        for (T dato : datos) {
            arbol.insertar(dato);
        }
        return arbol;
    }
}
