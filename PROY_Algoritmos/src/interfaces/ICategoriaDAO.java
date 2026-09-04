package interfaces;

import java.util.List;
import modelo.Categoria;

public interface ICategoriaDAO {
    List<Categoria> verTodasLasCategorias() throws Exception; // Recorrido
    void registrarCategoria(Categoria categoria) throws Exception; // Inserción
    void actualizarCategoria(Categoria categoria) throws Exception; // Actualización
    void eliminarCategoria(Categoria categoria) throws Exception; // Eliminación
}
