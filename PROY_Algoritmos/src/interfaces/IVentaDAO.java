/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;
import java.util.List;
import modelo.DetalleVenta;
import modelo.Venta;

public interface IVentaDAO {
    //Busca por id_venta (número) o por código (empieza con V). Devuelve null si no existe
 Venta buscarVenta(String texto) throws Exception;
 // Una fila por línea de la venta, en el orden en que se registraron
 List<DetalleVenta> verDetalle(int idVenta) throws Exception;

}
