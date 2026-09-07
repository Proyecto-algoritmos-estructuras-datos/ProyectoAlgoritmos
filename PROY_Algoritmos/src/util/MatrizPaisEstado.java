package util;

import modelo.Marca;

public class MatrizPaisEstado {

    private String[] paises;
    private int[][] matriz; // columna 0 = Activo, columna 1 = Inactivo

    public MatrizPaisEstado(String[] paises) {
        this.paises = paises;
        this.matriz = new int[paises.length][2];
    }

    public void generarMatriz(Marca[] marcas) {
        matriz = new int[paises.length][2];

        for (Marca marca : marcas) {
            if (marca == null || marca.getPaisOrigen() == null) {
                continue;
            }

            int fila = buscarPais(marca.getPaisOrigen());
            if (fila == -1) {
                continue;
            }

            if (marca.isEstado()) {
                matriz[fila][0]++;
            } else {
                matriz[fila][1]++;
            }
        }
    }

    private int buscarPais(String pais) {
        for (int i = 0; i < paises.length; i++) {
            if (paises[i].equalsIgnoreCase(pais)) {
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
        return paises.length;
    }
}

