
package Model.FechaHora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Hora {
    // Método para obtener la fecha y hora actuales en formato "HH:mm:ss" compatible con MySQL
    public static String getHoraActual() {
        LocalDateTime fechaHora = LocalDateTime.now();
        DateTimeFormatter formato;
        formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        return fechaHora.format(formato);
    }
}
