package modelo;

public enum TipoMovimiento {
    ENTRADA("Entrada"),
    SALIDA("Salida"),
    AJUSTE("Ajuste");

    private final String etiqueta;

    TipoMovimiento(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public String toString() {
        return etiqueta;
    }
}