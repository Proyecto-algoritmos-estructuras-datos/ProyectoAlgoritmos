package util;

import modelo.Categoria;
import modelo.Producto;

public class MatrizInventario {

    // Columna 0 = Activos, Columna 1 = Inactivos
    private int[][] matriz;

    public MatrizInventario(int filas) {
        matriz = new int[filas][2];
    }

    public void generarMatriz(Producto[] productos, Categoria[] categorias) {
        matriz = new int[categorias.length][2];

        for (Producto producto : productos) {
            if (producto == null || producto.getCategoria() == null) {
                continue;
            }

            int idCategoria = producto.getCategoria().getIdCategoria();
            int fila = buscarCategoria(categorias, idCategoria);

            if (fila == -1) {
                continue;
            }

            if (producto.isEstado()) {
                matriz[fila][0]++; // activo
            } else {
                matriz[fila][1]++; // inactivo
            }
        }
    }

    private int buscarCategoria(Categoria[] categorias, int idCategoria) {
        for (int i = 0; i < categorias.length; i++) {
            if (categorias[i].getIdCategoria() == idCategoria) {
                return i;
            }
        }
        return -1;
    }

    public int obtenerActivos(int fila) {
        return matriz[fila][0];
    }

    public int obtenerInactivos(int fila) {
        return matriz[fila][1];
    }

    public int obtenerTotal(int fila) {
        return matriz[fila][0] + matriz[fila][1];
    }

    public int getFilas() {
        return matriz.length;
    }
}