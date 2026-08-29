package interfaces;

import java.util.List;
import modelo.Empleado;

public interface IEmpleadoDAO {
    void registrarEmpleado(Empleado empleado) throws Exception;
    void actualizarEmpleado(Empleado empleado) throws Exception;
    
    void cambiarEstadoEmpleado(int idEmpleado, boolean activo) throws Exception;
    
    List<Empleado> verTodosLosEmpleados() throws Exception;
    List<Empleado> verEmpleadosPorEstado(boolean activo) throws Exception;
    
    Empleado buscarEmpleadoPorID(int id) throws Exception;
    Empleado buscarEmpleadoPorDNI(String dni) throws Exception;
    List<Empleado> buscarEmpleadoPorNombre(String nombre) throws Exception;
    
    Empleado iniciarSesionEmpleado(String dni, String contrasenia) throws Exception;
}