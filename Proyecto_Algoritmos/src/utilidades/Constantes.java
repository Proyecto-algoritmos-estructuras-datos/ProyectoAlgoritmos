package utilidades;

public final class Constantes {

    private Constantes() {
    }

    //Datos de la panaderia

    public static final String NOMBRE_EMPRESA = "Panadería Marcela";
    public static final String RUC_EMPRESA = "20123456789";
    public static final String TELEFONO = "351 2604";
    public static final String DIRECCION = "Av. Marco Puente 3024";

    //Impuesto general

    public static final double IGV = 0.18;

    //Roles

    public static final String ADMIN = "Administrador";
    public static final String EMPLEADO = "Empleado";

    //Prefijos

    public static final String PREFIJO_PRODUCTO = "P";
    public static final String PREFIJO_PEDIDO = "PED";
    public static final String PREFIJO_BOLETA = "B";
    public static final String PREFIJO_EMPLEADO = "EMP";
    public static final String PREFIJO_CLIENTE = "CLI";

    // Monto inicial
    public static final double MONTO_APERTURA_FIJO = 100.0;

    // Cantidad del stock de un producto para considerarse BAJO
    public static final int STOCK_BAJO_UMBRAL = 10;
}
