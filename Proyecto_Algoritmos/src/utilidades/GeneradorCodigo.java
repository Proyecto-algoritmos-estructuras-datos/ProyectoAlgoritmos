package utilidades;

public class GeneradorCodigo {

    private GeneradorCodigo() {
    }

    //Código del producto
    public static String generarCodigoProducto(int numero) {
        return String.format("P%03d", numero);
    }
    //Código del empleado
    public static String generarCodigoEmpleado(int numero) {
        return String.format("EMP%03d", numero);
    }
    //Código de la boleta
    public static String generarCodigoBoleta(int numero) {
        return String.format("BO%03d", numero);
    }

}
