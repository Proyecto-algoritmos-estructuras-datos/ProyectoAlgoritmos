package dao;

import conexion.Conexion;
import interfaces.ICompraDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Compra;
import modelo.DetalleCompra;

public class CompraDAO implements ICompraDAO {

    // Guarda la cabecera y todos los detalles en una sola transacción.
    // Si algo falla no queda nada guardado. No toca stock ni kardex: eso
    // lo hace el módulo de compras en espera cuando la compra se recibe.
    @Override
    public Compra registrarCompra(Compra compra) throws Exception {
        String sqlCompra = """
                           INSERT INTO compra
                           (
                           id_proveedor,
                           id_empleado,
                           total,
                           estado
                           )
                           VALUES (?, ?, ?, ?)
                           """;
        String sqlDetalle = """
                            INSERT INTO detalle_compra
                            (
                            id_compra,
                            id_producto,
                            cantidad,
                            precio_unitario
                            )
                            VALUES (?, ?, ?, ?)
                            """;

        // Aquí no se usa try-with-resources para la conexión porque hay que controlar
        // commit, rollback y restaurar el autoCommit a mano.
        Connection conn = null;
        try {
            conn = new Conexion().conectar();
            conn.setAutoCommit(false);

            int idCompra;

            // 1) Cabecera: estado PENDIENTE y fecha_recepcion queda en NULL
            try (PreparedStatement psCompra = conn.prepareStatement(sqlCompra, Statement.RETURN_GENERATED_KEYS)) {
                psCompra.setInt(1, compra.getProveedor().getIdProveedor());
                psCompra.setInt(2, compra.getEmpleado().getIdEmpleado());
                psCompra.setBigDecimal(3, compra.getTotal());
                psCompra.setString(4, compra.getEstado().name());

                int filas = psCompra.executeUpdate();
                if (filas == 0) {
                    throw new Exception("No se pudo registrar la compra!");
                }

                try (ResultSet rs = psCompra.getGeneratedKeys()) {
                    if (rs.next()) {
                        idCompra = rs.getInt(1);
                    } else {
                        throw new Exception("No se pudo obtener el id de la compra registrada!");
                    }
                }
            }

            // 2) Detalles (el subtotal lo calcula MySQL, es una columna generada)
            try (PreparedStatement psDetalle = conn.prepareStatement(sqlDetalle)) {
                for (DetalleCompra detalle : compra.getDetalles()) {
                    psDetalle.setInt(1, idCompra);
                    psDetalle.setInt(2, detalle.getProducto().getIdProducto());
                    psDetalle.setInt(3, detalle.getCantidad());
                    psDetalle.setBigDecimal(4, detalle.getPrecioUnitario());
                    psDetalle.executeUpdate();
                }
            }

            conn.commit();

            // Solo después del commit se actualizan los objetos en memoria
            compra.setIdCompra(idCompra);
            for (DetalleCompra detalle : compra.getDetalles()) {
                detalle.setIdCompra(idCompra);
            }
            return compra;

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    // si el rollback falla, igual se informa el error original
                }
            }
            throw new Exception("No se guardó la compra. Error al registrar la compra: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException ex) {
                    // nada más que hacer
                }
            }
        }
    }

}