package utilidades;

// Clase que calcula el stock del inventario y los clasifica
public class _ResumenStock {
    
    private int total;
    private int suficiente;
    private int bajo;
    private int sinStock;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSuficiente() {
        return suficiente;
    }

    public void setSuficiente(int suficiente) {
        this.suficiente = suficiente;
    }

    public int getBajo() {
        return bajo;
    }

    public void setBajo(int bajo) {
        this.bajo = bajo;
    }

    public int getSinStock() {
        return sinStock;
    }

    public void setSinStock(int sinStock) {
        this.sinStock = sinStock;
    }
    
    
}
