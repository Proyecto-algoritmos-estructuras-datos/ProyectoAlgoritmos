package modelo;

// Estado de un producto dentro de la toma de inventario (no se guarda en la BD)
public enum EstadoToma {
    PENDIENTE,  // todavía no se contó
    COINCIDE,   // el conteo es igual al stock del sistema
    SOBRANTE,   // se contó más de lo que dice el sistema
    FALTANTE    // se contó menos de lo que dice el sistema
}
