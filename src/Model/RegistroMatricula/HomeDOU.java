
package Model.RegistroMatricula;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import Model.ConexionDB;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;
import Model.EstudianteModel.EstudianteModel;

public class HomeDOU {
    
    
    
    public HomeDOU() {
    }
       

    public static boolean validarMatricula(int matricula) throws SQLException, FileNotFoundException {
        String SQL = "{CALL validarMatriculaEstudiante(?)}";

        // Conexión y llamada al procedimiento
        try (Connection conexion = ConexionDB.getConexion();
             CallableStatement callableStatement = (CallableStatement) conexion.prepareCall(SQL)) {

            // Establecer el parámetro de entrada
            callableStatement.setInt(1, matricula);

            // Ejecutar el procedimiento
            boolean hasResultSet = callableStatement.execute();

            // Procesar resultados
            if (hasResultSet) {
                try (ResultSet resultSet = callableStatement.getResultSet()) {
                    if (resultSet.next()) {
                        int matriculaObtenida = resultSet.getInt("Matricula");
                        String nombre = resultSet.getString("Nombres");
                        String apellido = resultSet.getString("Apellido");
                        String estado = resultSet.getString("Estado_estudiante");
                        EstudianteModel.setMatricula(matricula);
                        EstudianteModel.setNombre(nombre);
                        EstudianteModel.setEstado(estado);
                        EstudianteModel.setApellido(apellido);
                        System.out.println("Nombre: " + nombre );
                        System.out.println("Nombre: " + apellido );
                        System.out.println("Matricula: " + matricula );
                        System.out.println("Estado: " + estado );
                        
                        return true;
                    } else {
                        System.out.println("La matrícula ingresada no es correcta.");
                        JOptionPane.showMessageDialog(null, "La matrícula ingresada no es correcta.", "Arvertencia", JOptionPane.INFORMATION_MESSAGE);
                        return false;
                    }
                }
            } else {
                //System.out.println("El procedimiento no devolvió resultados.");
                return false;
            }

        } catch (SQLException e) {
            // Manejar errores SQL personalizados
            if ("45000".equals(e.getSQLState())) {
                System.err.println("Error personalizado: " + e.getMessage());
//                JOptionPane.showMessageDialog(null, e.getMessage(), "Arvertencia", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.err.println("Error SQL: " + e.getMessage());
            }
            return false;
        }
    }
    


    
    
   
}
