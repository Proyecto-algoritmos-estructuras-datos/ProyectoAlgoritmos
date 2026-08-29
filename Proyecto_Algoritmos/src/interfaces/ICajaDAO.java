package interfaces;

import java.time.LocalDate;
import java.util.List;
import modelo.Caja;

public interface ICajaDAO {
    void abrirCaja(Caja caja) throws Exception;

    void cerrarCaja(Caja caja) throws Exception;

    // No implementado aún
    Caja buscarCajaPorID(int id) throws Exception;
    
    Caja buscarCajaAbierta() throws Exception;

    List<Caja> buscarCajasPorRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception;

    List<Caja> verTodasLasCajas() throws Exception;

    List<Caja> buscarCajaPorEstado(String estado) throws Exception;
}
