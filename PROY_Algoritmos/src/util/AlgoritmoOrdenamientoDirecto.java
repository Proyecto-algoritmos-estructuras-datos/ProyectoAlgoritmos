package util;

import java.util.Comparator;
import modelo.Categoria;
import modelo.Marca;

public class AlgoritmoOrdenamientoDirecto {

    // Métodos para Categoria
    public static void burbuja(Categoria[] arreglo, Comparator<Categoria> comparador) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (comparador.compare(arreglo[j], arreglo[j + 1]) > 0) {
                    Categoria temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void seleccion(Categoria[] arreglo, Comparator<Categoria> comparador) {

        for (int i = 0; i < arreglo.length - 1; i++) {

            int posicionMenor = i;

            for (int j = i + 1; j < arreglo.length; j++) {

                if (comparador.compare(arreglo[j], arreglo[posicionMenor]) < 0) {
                    posicionMenor = j;
                }
            }

            if (posicionMenor != i) {

                Categoria temporal = arreglo[i];
                arreglo[i] = arreglo[posicionMenor];
                arreglo[posicionMenor] = temporal;
            }
        }
    }

    public static void insercion(Categoria[] arreglo, Comparator<Categoria> comparador) {
        for (int i = 1; i < arreglo.length; i++) {
            Categoria actual = arreglo[i];
            int j = i - 1;

            while (j >= 0 && comparador.compare(arreglo[j], actual) > 0) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }

            arreglo[j + 1] = actual;
        }
    }

    // Métodos para Marca
    public static void burbuja(Marca[] arreglo, Comparator<Marca> comparador) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (comparador.compare(arreglo[j], arreglo[j + 1]) > 0) {
                    Marca temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void seleccion(Marca[] arreglo, Comparator<Marca> comparador) {
        for (int i = 0; i < arreglo.length - 1; i++) {

            int posicionMenor = i;

            for (int j = i + 1; j < arreglo.length; j++) {

                if (comparador.compare(arreglo[j], arreglo[posicionMenor]) < 0) {
                    posicionMenor = j;
                }
            }

            if (posicionMenor != i) {

                Marca temporal = arreglo[i];
                arreglo[i] = arreglo[posicionMenor];
                arreglo[posicionMenor] = temporal;
            }
        }
    }

    public static void insercion(Marca[] arreglo, Comparator<Marca> comparador) {
        for (int i = 1; i < arreglo.length; i++) {
            Marca actual = arreglo[i];
            int j = i - 1;

            while (j >= 0 && comparador.compare(arreglo[j], actual) > 0) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }

            arreglo[j + 1] = actual;
        }
    }
}
