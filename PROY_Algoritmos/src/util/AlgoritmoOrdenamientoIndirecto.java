package util;

import java.util.Comparator;
import modelo.Producto;

public class AlgoritmoOrdenamientoIndirecto {
    // QuickSort -
    public static void quickSort(Producto[] arreglo, Comparator<Producto> comparador) {
        // Implementación de codigo
    }

    // MergeSort - Bryan
    public static void mergeSort(Producto[] arreglo, Comparator<Producto> comparador) {
        if (arreglo == null || arreglo.length < 2) {
            return;
        }
        Producto[] temporal = new Producto[arreglo.length];
        mergeSortRecursivo(arreglo, temporal, 0, arreglo.length - 1, comparador);
    }

    private static void mergeSortRecursivo(Producto[] arreglo, Producto[] temporal, int inicio, int fin, Comparator<Producto> comparador) {
        if (inicio >= fin) {
            return;
        }

        int medio = (inicio + fin) / 2;

        mergeSortRecursivo(arreglo, temporal, inicio, medio, comparador);
        mergeSortRecursivo(arreglo, temporal, medio + 1, fin, comparador);
        mezclar(arreglo, temporal, inicio, medio, fin, comparador);
    }

    private static void mezclar(Producto[] arreglo, Producto[] temporal, int inicio, int medio, int fin, Comparator<Producto> comparador) {
        // Copiamos el rango actual al arreglo temporal
        for (int i = inicio; i <= fin; i++) {
            temporal[i] = arreglo[i];
        }

        int i = inicio;      // puntero mitad izquierda
        int j = medio + 1;    // puntero mitad derecha
        int k = inicio;       // puntero de escritura en el arreglo original

        while (i <= medio && j <= fin) {
            if (comparador.compare(temporal[i], temporal[j]) <= 0) {
                arreglo[k] = temporal[i];
                i++;
            } else {
                arreglo[k] = temporal[j];
                j++;
            }
            k++;
        }

        // Si sobraron elementos en la mitad izquierda
        while (i <= medio) {
            arreglo[k] = temporal[i];
            i++;
            k++;
        }

        // Si sobraron elementos en la mitad derecha
        while (j <= fin) {
            arreglo[k] = temporal[j];
            j++;
            k++;
        }
    }

    // ShellSort - 
    public static void shellSort(Producto[] arreglo, Comparator<Producto> comparador) {
        // Implementación de codigo
    }
}
