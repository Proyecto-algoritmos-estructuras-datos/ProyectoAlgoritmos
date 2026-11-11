package controlador;

import dao.CompraDAO;
import interfaces.ICompraDAO;
import java.util.List;
import modelo.Compra;
import modelo.DetalleCompra;
import modelo.Empleado;
import util.Cola;
import util.SesionActual;

// Cola de recepción: las compras PENDIENTE esperan en el orden en que se registraron
// y solo se puede atender la del frente. La BD es la fuente de verdad: la cola se
// reconstruye desde ella cada vez que se abre la pantalla.
public class CompraEsperaController {

    private final ICompraDAO dao = new CompraDAO();
    private final Cola<Compra> cola = new Cola<>();

    // Reconstruye la cola desde la BD: las compras PENDIENTE de la más antigua a la más reciente
    public void cargarCola() throws Exception {
        // Se consulta primero: si falla, la cola actual se conserva
        List<Compra> pendientes = dao.verPendientes();
        cola.vaciar();
        for (Compra compra : pendientes) {
            cola.encolar(compra);
        }
    }

    // Compras en espera, del frente al final (la primera es el frente)
    public List<Compra> verCola() {
        return cola.obtenerElementos();
    }

    // Compra del frente sin sacarla, o null si no hay compras en espera
    public Compra verFrente() {
        return cola.frente();
    }

    public int getCantidadEnCola() {
        return cola.tamanio();
    }

    public boolean colaVacia() {
        return cola.estaVacia();
    }

    // Texto de la cola de frente a final, para un botón opcional "Ver cola"
    public String mostrarCola() {
        return cola.mostrar();
    }

    public List<DetalleCompra> verDetalleDelFrente() throws Exception {
        Compra frente = cola.frente();
        if (frente == null) {
            throw new Exception("No hay compras en espera.");
        }
        return dao.verDetalle(frente.getIdCompra());
    }

    // Atiende la compra del frente. Solo se desencola si la transacción terminó bien.
    public Compra recibirSiguiente() throws Exception {
        Compra frente = cola.frente();
        if (frente == null) {
            throw new Exception("No hay compras en espera para recibir.");
        }
        Empleado empleado = SesionActual.getEmpleado();
        if (empleado == null) {
            throw new Exception("No hay una sesión activa. Inicie sesión nuevamente.");
        }

        try {
            dao.recibirCompra(frente.getIdCompra(), empleado);
        } catch (Exception e) {
            // Si otra persona ya la atendió o la anuló, la cola en memoria quedó
            // desactualizada: se vuelve a leer la BD. Si la compra sigue PENDIENTE,
            // seguirá en el frente.
            try {
                cargarCola();
            } catch (Exception ex) {
                // se informa el error original
            }
            throw e;
        }
        return cola.desencolar();
    }
}
