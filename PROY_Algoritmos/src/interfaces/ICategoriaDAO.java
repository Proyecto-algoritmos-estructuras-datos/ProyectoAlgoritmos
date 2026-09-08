package interfaces;

import java.util.List;
import modelo.Categoria;

public interface ICategoriaDAO {
    List<Categoria> verTodasLasCategorias() throws Exception;
    void registrarCategoria(Categoria categoria) throws Exception;
    void actualizarCategoria(Categoria categoria) throws Exception;
    void eliminarCategoria(Categoria categoria) throws Exception;
}
