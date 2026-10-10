package modelo;

public enum Rol {
    ADMINISTRADOR("Administrador"),
    EMPLEADO("Empleado");

    private final String etiqueta;

    Rol(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    // Lo que se muestra en un JComboBox o en una tabla
    @Override
    public String toString() {
        return etiqueta;
    }
}