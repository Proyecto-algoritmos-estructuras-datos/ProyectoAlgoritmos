package controlador;

import dao.MarcaDAO;
import interfaces.IMarcaDAO;
import java.util.List;
import modelo.Marca;
import util.ListaEnlazadaSimple;
import util.NodoEnlazadaSimple;

public class MarcaController {
    private final IMarcaDAO dao;

    // Lista enlazada simple con las marcas (en memoria)
    private final ListaEnlazadaSimple listaMarcas = new ListaEnlazadaSimple();

    public MarcaController() {
        this(new MarcaDAO());
    }

    // Permite pasar otro DAO (por ejemplo, uno falso para probar sin base de datos)
    public MarcaController(IMarcaDAO dao) {
        this.dao = dao;
    }

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

    // ===================== LISTA ENLAZADA SIMPLE =====================

    // Lee la BD y arma la lista: cada fila de la BD pasa a ser un nodo (al final)
    public void cargarLista() throws Exception {
        listaMarcas.vaciar();
        for (Marca marca : dao.verTodasLasMarcas()) {
            listaMarcas.agregarAlFinal(marca);
        }
    }

    public NodoEnlazadaSimple getCabeza() {
        return listaMarcas.getCabeza();
    }

    // INSERCIÓN: guarda en la BD y luego agrega el nodo AL FINAL de la lista
    public void agregarMarca(Marca marca) throws Exception {
        validar(marca);
        if (listaMarcas.buscarNodoPorNombre(marca.getNombreMarca()) != null) {
            throw new Exception("Ya existe una marca con ese nombre.");
        }
        dao.registrarMarca(marca);          // aquí la BD le asigna el ID a la marca
        listaMarcas.agregarAlFinal(marca);
    }

    // BÚSQUEDA por ID (para la actualización)
    public NodoEnlazadaSimple buscarNodoPorId(int id) {
        return listaMarcas.buscarNodoPorId(id);
    }

    // BÚSQUEDA por nombre
    public NodoEnlazadaSimple buscarNodoPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Ingrese el nombre de la marca a buscar.");
        }
        return listaMarcas.buscarNodoPorNombre(nombre);
    }

    // ACTUALIZACIÓN: actualiza la BD y luego el nodo de la lista
    public void actualizarNodo(Marca marca) throws Exception {
        if (marca.getIdMarca() <= 0) {
            throw new Exception("Marca inválida para actualizar.");
        }
        validar(marca);
        NodoEnlazadaSimple repetido = listaMarcas.buscarNodoPorNombre(marca.getNombreMarca());
        if (repetido != null && repetido.getDato().getIdMarca() != marca.getIdMarca()) {
            throw new Exception("Ya existe otra marca con ese nombre.");
        }
        dao.actualizarMarca(marca);
        listaMarcas.actualizar(marca);
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