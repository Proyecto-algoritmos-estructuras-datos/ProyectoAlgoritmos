package utilidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Fecha {

    //Formato de fecha actual
    public static String fechaActual() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    //Formato de hora actual
    public static String horaActual() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    //Formato de fecha y hora actual
    public static String fechaHoraActual() {
        return LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}