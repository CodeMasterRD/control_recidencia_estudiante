
package Model.RegistroMatricula;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import Model.ConexionDB;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

public class HomeDOU {
    //definimos los atributos
    public static int matricula;

    public static int getMatricula() {
        return matricula;
    }

    public static void setMatricula(int matricula) {
        HomeDOU.matricula = matricula;
    }
    
    //metodo que validad la entrada
    // resive un parametro tipo String
    // retorna un true or false

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
                        setMatricula(matriculaObtenida);
                        System.out.println("Matrícula encontrada: " + matriculaObtenida);
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
                JOptionPane.showMessageDialog(null, e.getMessage(), "Arvertencia", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.err.println("Error SQL: " + e.getMessage());
            }
            return false;
        }
    }



    
    
   
}
