package interfaces;

import java.util.List;
import modelo.Compra;
import modelo.DetalleCompra;
import modelo.Empleado;

public interface ICompraDAO {

    Compra registrarCompra(Compra compra) throws Exception;

    // Compras PENDIENTE ordenadas por fecha_compra (y luego por id_compra)
    List<Compra> verPendientes() throws Exception;

    List<DetalleCompra> verDetalle(int idCompra) throws Exception;

    // Recibe la compra: estado, stock, precio_compra y kardex en una sola transacción
    void recibirCompra(int idCompra, Empleado empleado) throws Exception;
}
