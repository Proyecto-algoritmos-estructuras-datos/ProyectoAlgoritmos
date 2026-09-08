package util;

import java.util.Comparator;
import modelo.Producto;


public class AlgoritmoOrdenamientoIndirecto {
        
    public static void quickSort(Producto[] arreglo, Comparator<Producto> comparador) {
        if (arreglo == null || arreglo.length < 2) {
            return;
        }

        quickSortRecursivo(arreglo, 0, arreglo.length - 1, comparador);
    }

    private static void quickSortRecursivo(
            Producto[] arreglo,
            int inicio,
            int fin,
            Comparator<Producto> comparador) {

        if (inicio >= fin) {
            return;
        }

        int izquierda = inicio;
        int derecha = fin;

        // Elegimos el elemento del medio como pivote
        Producto pivote = arreglo[(inicio + fin) / 2];

        while (izquierda <= derecha) {

            // Buscar elemento mayor que el pivote desde la izquierda
            while (comparador.compare(arreglo[izquierda], pivote) < 0) {
                izquierda++;
            }

            // Buscar elemento menor que el pivote desde la derecha
            while (comparador.compare(arreglo[derecha], pivote) > 0) {
                derecha--;
            }

            // Intercambiar
            if (izquierda <= derecha) {
                Producto temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;

                izquierda++;
                derecha--;
            }
        }

        // Ordenamos la parte izquierda
        if (inicio < derecha) {
            quickSortRecursivo(arreglo, inicio, derecha, comparador);
        }

        // Ordenamos la parte derecha
        if (izquierda < fin) {
            quickSortRecursivo(arreglo, izquierda, fin, comparador);
        }
    }

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
        for (int i = inicio; i <= fin; i++) {
            temporal[i] = arreglo[i];
        }

        int i = inicio;
        int j = medio + 1;
        int k = inicio;

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

        while (i <= medio) {
            arreglo[k] = temporal[i];
            i++;
            k++;
        }

        while (j <= fin) {
            arreglo[k] = temporal[j];
            j++;
            k++;
        }
    }
    
    public static void shellSort(Producto[] arreglo, Comparator<Producto> comparador) {

        if (arreglo == null || arreglo.length < 2) {
            return;
        }

        // Empezamos con la mitad del tamaño del arreglo
        for (int gap = arreglo.length / 2; gap > 0; gap /= 2) {

            // Recorremos los elementos
            for (int i = gap; i < arreglo.length; i++) {

                Producto temporal = arreglo[i];

                int j = i;

                // Movemos elementos mientras sean mayores
                while (j >= gap &&
                       comparador.compare(arreglo[j - gap], temporal) > 0) {

                    arreglo[j] = arreglo[j - gap];
                    j -= gap;
                }

                // Colocamos el elemento en su posición
                arreglo[j] = temporal;
            }
        }
    }
}
    