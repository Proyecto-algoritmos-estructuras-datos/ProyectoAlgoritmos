package interfaces;

import java.util.List;
import modelo.Marca;

public interface IMarcaDAO {
    List<Marca> verTodasLasMarcas() throws Exception; // Recorrido
    void registrarMarca(Marca marca) throws Exception; // Inserción
    void actualizarMarca(Marca marca) throws Exception; // Actualización
    void eliminarMarca(Marca marca) throws Exception; // Eliminación
}
