package interfaces;

import java.util.List;
import modelo.Marca;

public interface IMarcaDAO {
    List<Marca> verTodasLasMarcas() throws Exception;
    void registrarMarca(Marca marca) throws Exception;
    void actualizarMarca(Marca marca) throws Exception;
    void eliminarMarca(Marca marca) throws Exception;
}
