
package Model.Notificaciones;

import Model.Notificaciones.NotificacionesDOU;


public class NotificacionModel {
    
    public static String estado_notificaciones;
    public static String Tipo_noteficacion;
    

    public static String getEstado_notificaciones() {
        return estado_notificaciones;
    }
    public static void setEstado_notificaciones(String estado_notificaciones) {
        NotificacionModel.estado_notificaciones = estado_notificaciones;
    }

    public static String getTipo_noteficacion() {
        return Tipo_noteficacion;
    }

    public static void setTipo_noteficacion(String Tipo_noteficacion) {
        NotificacionModel.Tipo_noteficacion = Tipo_noteficacion;
    }
    
    
    
}
