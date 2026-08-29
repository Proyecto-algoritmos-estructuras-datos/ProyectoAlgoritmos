package utilidades;

public class Validaciones {

    private Validaciones() {
    }

    // Verifica si un campo está vacío
    public static boolean campoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    // Solo escribir números
    public static boolean soloNumeros(String texto) {
        return texto.matches("\\d+");
    }

    // Solo escribir letras y espacios
    public static boolean soloLetras(String texto) {
        return texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }

    // Longitud mínima
    public static boolean longitudMinima(String texto, int longitud) {
        return texto.length() >= longitud;
    }

    // Longitud máxima
    public static boolean longitudMaxima(String texto, int longitud) {
        return texto.length() <= longitud;
    }
    
    //Validar que la contraseña sea válida
    public static boolean contraseniaValida(String contrasenia) {
        return contrasenia.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
        //toda la linea de arriba verifica que tenga 
        //los criterios que debe tener la contraseña
    }
}
