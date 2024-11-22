
package Model.Procedure;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import Model.ConexionDB;
import java.io.FileNotFoundException;
import java.sql.ResultSet;

public class ProcedimientoUtils {
    // Metodo que retorna el estado del estudiante "Dentr" o Fuera
    public static String getEstado(int mat) throws SQLException, FileNotFoundException{
        String GET_ESTADO_SQL = "{getestado(?)}";
        try {
            Connection conexion = ConexionDB.getConexion();
            CallableStatement call = conexion.prepareCall(GET_ESTADO_SQL);
            
            // establecer los parametro del procedimiento
            call.setInt(1, mat);
            
            // ejecutar el procedure
            boolean hasResultSet = call.execute();
            if (hasResultSet) {
            try (ResultSet resultSet = call.getResultSet()) {
                if (resultSet.next()) {
                    return resultSet.getString("Estado");
                } else {
                    System.out.println("No se encontró el estado para la matrícula dada.");
                    return null;
                }
            }
        } else {
            System.out.println("El procedimiento no devolvió resultados.");
            return null;
        }

            
            
        } catch (SQLException e) {
                if ("45000".equals(e.getSQLState())) {
                System.err.println("Error personalizado: " + e.getMessage());
            } else {
                System.err.println("Error SQL: " + e.getMessage());
            }
        return null;
       }
   
    }
}    
