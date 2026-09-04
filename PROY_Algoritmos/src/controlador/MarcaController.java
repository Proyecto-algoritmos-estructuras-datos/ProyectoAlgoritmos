package controlador;

import dao.MarcaDAO;
import interfaces.IMarcaDAO;
import java.util.List;
import modelo.Marca;

public class MarcaController {
    private final IMarcaDAO dao = new MarcaDAO();

    public List<Marca> verTodasLasMarcas() throws Exception {
        return dao.verTodasLasMarcas();
    }

    public Marca[] obtenerArray() throws Exception {
        List<Marca> lista = dao.verTodasLasMarcas();
        return lista.toArray(new Marca[0]);
    }

    public void registrarMarca(Marca marca) throws Exception {
        validar(marca);
        dao.registrarMarca(marca);
    }

    public void actualizarMarca(Marca marca) throws Exception {
        if (marca.getIdMarca() <= 0) {
            throw new Exception("Marca inválida para actualizar.");
        }
        validar(marca);
        dao.actualizarMarca(marca);
    }

    public void eliminarMarca(Marca marca) throws Exception {
        if (marca.getIdMarca() <= 0) {
            throw new Exception("Marca inválida para eliminar.");
        }
        dao.eliminarMarca(marca);
    }

    private void validar(Marca marca) throws Exception {
        if (marca.getNombreMarca() == null || marca.getNombreMarca().trim().isEmpty()) {
            throw new Exception("El nombre de la marca es obligatorio.");
        }
        if (marca.getNombreMarca().trim().length() > 80) {
            throw new Exception("El nombre de la marca no puede superar los 80 caracteres.");
        }
        if (marca.getDescripcion() != null && marca.getDescripcion().length() > 255) {
            throw new Exception("La descripción no puede superar los 255 caracteres.");
        }
        if (marca.getPaisOrigen() != null && marca.getPaisOrigen().length() > 60) {
            throw new Exception("El país de origen no puede superar los 60 caracteres.");
        }
    }
}
