package modelo;

// Un producto dentro de la toma de inventario. No mapea a ninguna tabla:
// solo vive en memoria mientras el empleado cuenta.
public class ItemTomaInventario {

    private Producto producto;
    private int stockSistema;       // stock que tenía el sistema al iniciar la toma
    private Integer conteoFisico;   // null = pendiente (todavía no se cuenta)

    public ItemTomaInventario(Producto producto) {
        this.producto = producto;
        this.stockSistema = producto.getStock();
        this.conteoFisico = null;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getStockSistema() {
        return stockSistema;
    }

    public Integer getConteoFisico() {
        return conteoFisico;
    }

    public void setConteoFisico(Integer conteoFisico) {
        this.conteoFisico = conteoFisico;
    }

    public boolean estaContado() {
        return conteoFisico != null;
    }

    // Conteo - stock del sistema: negativo = faltante, positivo = sobrante.
    // Si todavía está pendiente devuelve 0.
    public int calcularDiferencia() {
        if (conteoFisico == null) {
            return 0;
        }
        return conteoFisico - stockSistema;
    }

    public EstadoToma getEstado() {
        if (conteoFisico == null) {
            return EstadoToma.PENDIENTE;
        }
        int diferencia = calcularDiferencia();
        if (diferencia == 0) {
            return EstadoToma.COINCIDE;
        }
        return (diferencia > 0) ? EstadoToma.SOBRANTE : EstadoToma.FALTANTE;
    }

    @Override
    public String toString() {
        return producto.getNombreProducto() + " | sistema: " + stockSistema
                + " | conteo: " + (conteoFisico == null ? "-" : conteoFisico)
                + " | " + getEstado();
    }
}