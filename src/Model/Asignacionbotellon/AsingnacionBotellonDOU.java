
package Model.Asignacionbotellon;

import Model.ConexionDB;
import Model.EstudianteModel.EstudianteModel;
import Model.Notificaciones.NotificacionModel;
import com.mysql.cj.jdbc.CallableStatement;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Asignacionbotellon.AsignacionBotellonModel;


public class AsingnacionBotellonDOU {
    
    
    
    // METODO PARA OTENER EL ESTADO DEL de la tabla asignacion botellon
    // devuelve el estado de la asinacion con respecto a la habitacion,
    // resibe como parametro de entra la matricula para busca la Habitacion de ese estudiante
    public static void getEstadoBotellon() throws FileNotFoundException{
        System.out.println("obteniendo estado notificacion.. ");
        String PSQL_GET_ESTADO = "{CALL BuscarEstadoBotellon(?)}";
        try(Connection conexion = ConexionDB.getConexion();
                CallableStatement statement = (CallableStatement) conexion.prepareCall(PSQL_GET_ESTADO)){
            
          
             
            // Establecer el valor del parámetro de entrada
            int mat =  EstudianteModel.getMatricula();
           // System.out.println("Mat para el estado notificacion");
            // System.out.println(mat);
            statement.setInt(1, mat);
            

            // Procesar los resultados
            try ( // Ejecutar el procedimiento
                    ResultSet resultSet = statement.executeQuery()) {
                // Procesar los resultados
                while (resultSet.next()) {
                    String estadoActual = resultSet.getString("Estado_botellon");

                    AsignacionBotellonModel.setEstadoBotellon(estadoActual);// setea el estado del botellon
                    System.out.println("Estado Botelon" +  estadoActual);
                    
                }
                // Cerrar recursos
            }
            statement.close();
            
        } catch (SQLException e) {
            if ("45000".equals(e.getMessage())) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("Algo saliomal " + e.getMessage());
            }
           
        
        }
        
    }
    
    
}
