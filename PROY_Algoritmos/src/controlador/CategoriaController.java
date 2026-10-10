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

        String nombre = categoria.getNombreCategoria().trim();
        categoria.setNombreCategoria(nombre);

        List<Categoria> todas = dao.verTodasLasCategorias();

        // Nombre único (la BD tiene UNIQUE; aquí se avisa con un mensaje claro)
        for (Categoria c : todas) {
            if (c.getIdCategoria() != categoria.getIdCategoria()
                    && c.getNombreCategoria().equalsIgnoreCase(nombre)) {
                throw new Exception("Ya existe una categoria con ese nombre.");
            }
        }

        validarPadre(categoria, todas);
    }

    private void validarPadre(Categoria categoria, List<Categoria> todas) throws Exception {
        Integer idPadre = categoria.getIdCategoriaPadre();
        if (idPadre == null) {
            return; // categoría raíz
        }
        if (idPadre <= 0) {
            throw new Exception("La categoria padre no es válida.");
        }
        if (idPadre == categoria.getIdCategoria()) {
            throw new Exception("Una categoria no puede ser su propia categoria padre.");
        }

        Categoria padre = buscarPorId(todas, idPadre);
        if (padre == null) {
            throw new Exception("La categoria padre seleccionada no existe.");
        }
        if (!padre.isEstado()) {
            throw new Exception("La categoria padre seleccionada está inactiva.");
        }

        // Evitar ciclos (A padre de B y B padre de A): se sube por los ancestros del padre
        // y si aparece la categoría actual, se formaría un ciclo.
        Integer actual = padre.getIdCategoriaPadre();
        int limite = todas.size();
        while (actual != null && limite-- > 0) {
            if (actual == categoria.getIdCategoria()) {
                throw new Exception("La categoria padre seleccionada es una subcategoria de esta categoria.");
            }
            Categoria ancestro = buscarPorId(todas, actual);
            actual = (ancestro != null) ? ancestro.getIdCategoriaPadre() : null;
        }
    }

    private Categoria buscarPorId(List<Categoria> lista, int idCategoria) {
        for (Categoria c : lista) {
            if (c.getIdCategoria() == idCategoria) {
                return c;
            }
        }
        return null;
    }
}