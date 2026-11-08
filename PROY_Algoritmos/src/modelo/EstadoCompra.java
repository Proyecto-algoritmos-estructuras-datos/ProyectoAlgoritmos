package modelo;

/**
 * Estados posibles de una compra. Coinciden con el CHECK chk_compra_estado
 * de la tabla compra, por lo que name() se guarda tal cual en la base.
 */
public enum EstadoCompra {
    PENDIENTE,
    RECIBIDA,
    ANULADA
}
