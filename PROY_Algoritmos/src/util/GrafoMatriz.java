package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Grafo no dirigido y con pesos, representado con matriz de adyacencia.
 * Los vertices van en un arreglo ORDENADO segun el comparador recibido, asi
 * se pueden encontrar con busqueda binaria. El peso de una arista es la
 * cantidad de veces que se agrego (0 = no existe arista).
 */
public class GrafoMatriz<T> {

    private final T[] vertices;
    private final int[][] matriz;
    private final Comparator<T> orden;

    // El arreglo debe venir ya ordenado de menor a mayor segun "orden" y sin repetidos
    public GrafoMatriz(T[] vertices, Comparator<T> orden) {
        if (vertices == null || orden == null) {
            throw new IllegalArgumentException("Los vertices y el comparador son obligatorios.");
        }
        for (int i = 1; i < vertices.length; i++) {
            if (orden.compare(vertices[i - 1], vertices[i]) >= 0) {
                throw new IllegalArgumentException(
                        "Los vertices deben venir ordenados y sin repetidos.");
            }
        }
        this.vertices = vertices;
        this.orden = orden;
        this.matriz = new int[vertices.length][vertices.length];
    }

    public int cantidadVertices() {
        return vertices.length;
    }

    // Busqueda binaria. Devuelve la posicion del vertice o -1 si no existe
    public int indiceDe(T vertice) {
        if (vertice == null) {
            return -1;
        }
        int inicio = 0;
        int fin = vertices.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = orden.compare(vertice, vertices[medio]);
            if (comparacion == 0) {
                return medio;
            }
            if (comparacion < 0) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }
        return -1;
    }

    // Suma 1 al peso en ambas posiciones. Devuelve false si algun vertice no existe o son el mismo
    public boolean agregarArista(T a, T b) {
        int i = indiceDe(a);
        int j = indiceDe(b);
        if (i < 0 || j < 0 || i == j) {
            return false;
        }
        matriz[i][j]++;
        matriz[j][i]++;
        return true;
    }

    public boolean existeArista(T a, T b) {
        return peso(a, b) > 0;
    }

    // Peso de la arista entre a y b. 0 si no hay arista o algun vertice no existe
    public int peso(T a, T b) {
        int i = indiceDe(a);
        int j = indiceDe(b);
        if (i < 0 || j < 0) {
            return 0;
        }
        return matriz[i][j];
    }

    // Vertices conectados con "vertice" (lista vacia si no tiene o no existe)
    public List<T> adyacentes(T vertice) {
        List<T> lista = new ArrayList<>();
        int i = indiceDe(vertice);
        if (i < 0) {
            return lista;
        }
        for (int j = 0; j < vertices.length; j++) {
            if (matriz[i][j] > 0) {
                lista.add(vertices[j]);
            }
        }
        return lista;
    }

    // Cantidad de vecinos distintos (no suma los pesos)
    public int grado(T vertice) {
        return adyacentes(vertice).size();
    }

    // Vertices que no tienen ningun vecino
    public int contarSinReferencias() {
        int cantidad = 0;
        for (int i = 0; i < vertices.length; i++) {
            if (!tieneVecino(i)) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Igual que en el laboratorio: true si cada fila tiene al menos una arista
    public boolean validarReferenciasMinimas() {
        return contarSinReferencias() == 0;
    }

    private boolean tieneVecino(int i) {
        for (int j = 0; j < vertices.length; j++) {
            if (matriz[i][j] > 0) {
                return true;
            }
        }
        return false;
    }

    // Solo util con grafos chicos (pruebas)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("=== Matriz de adyacencia ===\n");
        for (int i = 0; i < vertices.length; i++) {
            sb.append(String.format("%-20s | ", vertices[i]));
            for (int j = 0; j < vertices.length; j++) {
                sb.append(matriz[i][j]).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}