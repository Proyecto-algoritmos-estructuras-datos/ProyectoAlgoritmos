package util;

import java.math.BigDecimal;

public class Validaciones {
    public static BigDecimal parsearPrecio(String texto) throws Exception {
        if (texto == null || texto.trim().isEmpty()) {
            throw new Exception("Ingrese el precio del producto.");
        }
        try {
            return new BigDecimal(texto.trim().replace(",", "."));
        } catch (NumberFormatException nfe) {
            throw new Exception("El precio ingresado no es válido.");
        }
    }

    public static int parsearStock(String texto) throws Exception {
        if (texto == null || texto.trim().isEmpty()) {
            throw new Exception("Ingrese el stock del producto.");
        }
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException nfe) {
            throw new Exception("El stock ingresado no es válido.");
        }
    }
    

      public static int parsearId(String texto) throws Exception {
        if (texto == null || texto.trim().isEmpty()) {
            throw new Exception("Ingrese el ID de la marca.");
        }
        try {
            int id = Integer.parseInt(texto.trim());
            if (id <= 0) {
                throw new Exception("El ID debe ser un número mayor que 0.");
            }
            return id;
        } catch (NumberFormatException nfe) {
            throw new Exception("El ID ingresado no es válido.");
        }
    }
    
    
}
