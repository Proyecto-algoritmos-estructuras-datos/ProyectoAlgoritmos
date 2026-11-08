package controlador;

import dao.ProveedorDAO;
import interfaces.IProveedorDAO;
import java.util.List;
import modelo.Proveedor;

public class ProveedorController {
    private final IProveedorDAO dao = new ProveedorDAO();

    public List<Proveedor> verTodosLosProveedores() throws Exception {
        return dao.verTodosLosProveedores();
    }

    public List<Proveedor> verProveedoresActivos() throws Exception {
        return dao.verProveedoresActivos();
    }

    // Devuelve el proveedor ya con su id, para poder seleccionarlo en Registro de Compras
    public Proveedor registrarProveedor(Proveedor proveedor) throws Exception {
        validar(proveedor);
        return dao.registrarProveedor(proveedor);
    }

    private void validar(Proveedor proveedor) throws Exception {
        if (proveedor.getRuc() == null || !proveedor.getRuc().trim().matches("^[0-9]{11}$")) {
            throw new Exception("El RUC debe tener exactamente 11 dígitos.");
        }
        if (proveedor.getRazonSocial() == null || proveedor.getRazonSocial().trim().isEmpty()) {
            throw new Exception("La razón social es obligatoria.");
        }
        if (proveedor.getRazonSocial().trim().length() > 120) {
            throw new Exception("La razón social no puede superar los 120 caracteres.");
        }

        // Campos opcionales: vacío = NULL
        String contacto = vacioANull(proveedor.getContacto());
        if (contacto != null && contacto.length() > 100) {
            throw new Exception("El contacto no puede superar los 100 caracteres.");
        }
        String telefono = vacioANull(proveedor.getTelefono());
        if (telefono != null && !telefono.matches("^9[0-9]{8}$")) {
            throw new Exception("El teléfono debe tener 9 dígitos y empezar con 9.");
        }
        String correo = vacioANull(proveedor.getCorreo());
        if (correo != null) {
            if (correo.length() > 100) {
                throw new Exception("El correo no puede superar los 100 caracteres.");
            }
            if (!correo.matches("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$")) {
                throw new Exception("El correo no tiene un formato válido.");
            }
        }
        String direccion = vacioANull(proveedor.getDireccion());
        if (direccion != null && direccion.length() > 150) {
            throw new Exception("La dirección no puede superar los 150 caracteres.");
        }

        proveedor.setRuc(proveedor.getRuc().trim());
        proveedor.setRazonSocial(proveedor.getRazonSocial().trim());
        proveedor.setContacto(contacto);
        proveedor.setTelefono(telefono);
        proveedor.setCorreo(correo);
        proveedor.setDireccion(direccion);

        // RUC único (se revisan también los inactivos, porque el UNIQUE de la tabla los incluye)
        for (Proveedor p : dao.verTodosLosProveedores()) {
            if (p.getIdProveedor() != proveedor.getIdProveedor()
                    && p.getRuc().equals(proveedor.getRuc())) {
                throw new Exception("Ya existe un proveedor con ese RUC.");
            }
        }
    }

    private String vacioANull(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return null;
        }
        return texto.trim();
    }
}