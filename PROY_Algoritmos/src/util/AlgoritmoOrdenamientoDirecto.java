package util;

import java.util.Comparator;
import modelo.Categoria;
import modelo.Marca;

public class AlgoritmoOrdenamientoDirecto {

    // Métodos para Categoria
    public static void burbuja(Categoria[] arreglo, Comparator<Categoria> comparador) {
        // Implementación de codigo
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
        // Implementación de codigo
    }

    // Métodos para Marca
    public static void burbuja(Marca[] arreglo, Comparator<Marca> comparador) {
        // Implementación de codigo
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
        // Implementación de codigo
    }
}
