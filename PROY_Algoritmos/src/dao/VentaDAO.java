/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import interfaces.IVentaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.Venta;

public class VentaDAO implements IVentaDAO {

    private static final String SQL_VENTA_POR_ID = """
 SELECT id_venta, numero, fecha_venta, estado
 FROM venta
 WHERE id_venta = ?
 """;
    private static final String SQL_VENTA_POR_NUMERO = """
 SELECT id_venta, numero, fecha_venta, estado
 FROM venta
 WHERE numero = ?
 """;
    private static final String SQL_DETALLE = """
 SELECT
 d.id_detalle_venta,
 d.id_venta,
 d.cantidad,
 d.precio_unitario,
 p.id_producto,
 p.codigo,
 p.nombre_producto
 FROM detalle_venta d
 INNER JOIN producto p ON d.id_producto = p.id_producto
 WHERE d.id_venta = ?
 ORDER BY d.id_detalle_venta
 """;
    // "v2", "V2" o "V0002" se convierten en "V0002", que es como se guarda en la tabla venta

    public static String normalizarNumero(String dato) {
        String resto = dato.trim().substring(1);
        try {
            return String.format("V%04d", Integer.parseInt(resto));
        } catch (NumberFormatException e) {
            return dato.trim().toUpperCase();
        }
    }

    @Override
    public Venta buscarVenta(String texto) throws Exception {
        String dato = texto.trim();
        boolean porNumero = dato.toUpperCase().startsWith("V");
        String sql = porNumero ? SQL_VENTA_POR_NUMERO : SQL_VENTA_POR_ID;
        try (Connection conn = new Conexion().conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            if (porNumero) {
                ps.setString(1, normalizarNumero(dato));
            } else {
                ps.setInt(1, Integer.parseInt(dato));
            }
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                Timestamp fecha = rs.getTimestamp("fecha_venta");
                return new Venta(
                        rs.getInt("id_venta"),
                        rs.getString("numero"),
                        fecha == null ? null : fecha.toLocalDateTime(),
                        rs.getString("estado"));
            }
        } catch (NumberFormatException e) {
            throw new Exception("Escriba el número de la venta o su código (ejemplo: V0001).");
        } catch (SQLException e) {
            throw new Exception("Error al buscar la venta: " + e.getMessage());
        }
    }

    @Override
    public List<DetalleVenta> verDetalle(int idVenta) throws Exception {
        List<DetalleVenta> lista = new ArrayList<>();
        try (Connection conn = new Conexion().conectar(); PreparedStatement ps = conn.prepareStatement(SQL_DETALLE)) {
            ps.setInt(1, idVenta);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setIdProducto(rs.getInt("id_producto"));
                    producto.setCodigo(rs.getString("codigo"));
                    producto.setNombreProducto(rs.getString("nombre_producto"));
                    lista.add(new DetalleVenta(
                            rs.getInt("id_detalle_venta"),
                            rs.getInt("id_venta"),
                            producto,
                            rs.getInt("cantidad"),
                            rs.getBigDecimal("precio_unitario")));
                }
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Error al cargar el detalle de la venta: " + e.getMessage());
        }
    }
}
