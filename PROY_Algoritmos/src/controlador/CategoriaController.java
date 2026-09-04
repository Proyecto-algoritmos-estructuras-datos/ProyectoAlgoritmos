package controlador;

import dao.CategoriaDAO;
import interfaces.ICategoriaDAO;
import java.util.List;
import modelo.Categoria;

public class CategoriaController {
    private final ICategoriaDAO dao = new CategoriaDAO();

    public List<Categoria> verTodasLasCategorias() throws Exception {
        return dao.verTodasLasCategorias();
    }

    public Categoria[] obtenerArray() throws Exception {
        List<Categoria> lista = dao.verTodasLasCategorias();
        return lista.toArray(new Categoria[0]);
    }

    public void registrarCategoria(Categoria categoria) throws Exception {
        validar(categoria);
        dao.registrarCategoria(categoria);
    }

    public void actualizarCategoria(Categoria categoria) throws Exception {
        if (categoria.getIdCategoria() <= 0) {
            throw new Exception("Categoria inválida para actualizar.");
        }
        validar(categoria);
        dao.actualizarCategoria(categoria);
    }

    public void eliminarCategoria(Categoria categoria) throws Exception {
        if (categoria.getIdCategoria() <= 0) {
            throw new Exception("Categoria inválida para eliminar.");
        }
        dao.eliminarCategoria(categoria);
    }

    private void validar(Categoria categoria) throws Exception {
        if (categoria.getNombreCategoria() == null || categoria.getNombreCategoria().trim().isEmpty()) {
            throw new Exception("El nombre de la categoria es obligatorio.");
        }
        if (categoria.getNombreCategoria().trim().length() > 80) {
            throw new Exception("El nombre de la categoria no puede superar los 80 caracteres.");
        }
        if (categoria.getDescripcion() != null && categoria.getDescripcion().length() > 255) {
            throw new Exception("La descripción no puede superar los 255 caracteres.");
        }
    }
}
