package interfaces;

import java.util.List;
import modelo.Empleado;

public interface IEmpleadoDAO {
    List<Empleado> verTodosLosEmpleados() throws Exception;
    void registrarEmpleado(Empleado empleado) throws Exception;
    void actualizarEmpleado(Empleado empleado) throws Exception;
    void eliminarEmpleado(Empleado empleado) throws Exception;
    void reactivarEmpleado(Empleado empleado) throws Exception;
    Empleado buscarEmpleadoPorId(int idEmpleado) throws Exception;
    Empleado buscarEmpleadoPorDni(String dni) throws Exception;
    Empleado buscarEmpleadoPorUsuario(String usuario) throws Exception;
    Empleado autenticarEmpleado(String dni, String contrasena) throws Exception;
}