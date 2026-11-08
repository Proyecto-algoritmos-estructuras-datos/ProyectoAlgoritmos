package interfaces;

import modelo.Compra;

public interface ICompraDAO {
    Compra registrarCompra(Compra compra) throws Exception;
}