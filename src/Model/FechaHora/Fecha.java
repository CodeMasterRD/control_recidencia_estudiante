
package Model.FechaHora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Fecha {
    // Método para obtener la fecha y hora actuales en formato "yyyy-MM-dd" compatible con MySQL
    public static String getFechaActual() {
        LocalDateTime fechaHora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fechaHora.format(formato);
    }
}
