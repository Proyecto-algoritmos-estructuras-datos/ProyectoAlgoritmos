package interfaces;

import java.util.List;
import modelo.Proveedor;

public interface IProveedorDAO {
    List<Proveedor> verTodosLosProveedores() throws Exception;
    List<Proveedor> verProveedoresActivos() throws Exception;
    Proveedor registrarProveedor(Proveedor proveedor) throws Exception;
}
