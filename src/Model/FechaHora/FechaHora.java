
package Model.FechaHora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FechaHora {
    // Método para obtener la fecha y hora actuales en formato "yyyy-MM-dd HH:mm:ss" compatible con MySQL
    public static String getFechaHoraActual() {
        LocalDateTime fechaHora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fechaHora.format(formato);
    }
}
