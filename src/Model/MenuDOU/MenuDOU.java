
package Model.MenuDOU;
import java.sql.*;
import Model.ConexionDB;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import Model.RegistroMatricula.HomeDOU;
import com.mysql.cj.jdbc.CallableStatement;

public class MenuDOU {
    
    private String btnSeleccionado;
    
    // Atribuo que guarda el estado del estudiante
    public static String estatoEstudiante; 

    public static String getEstatoEstudiante() {
        return estatoEstudiante;
    }

    public static void setEstatoEstudiante(String estatoEstudiante) {
        MenuDOU.estatoEstudiante = estatoEstudiante;
    }

    
    
    
    
    

    public MenuDOU() {
    }

    public MenuDOU(String btnSeleccionado) {
        this.btnSeleccionado = btnSeleccionado;
    }

    public String getBtnSeleccionado() {
        return btnSeleccionado;
    }

    public void setBtnSeleccionado(String btnSeleccionado) {
        this.btnSeleccionado = btnSeleccionado;
    }
    
    
    public static void getEstadoSTU() throws FileNotFoundException{
        System.out.println("obteniendo estado.. ");
        String PSQL_GET_ESTADO = "{CALL p_Estado_estudiante (?)}";
        try(Connection conexion = ConexionDB.getConexion();
                CallableStatement statement = (CallableStatement) conexion.prepareCall(PSQL_GET_ESTADO)){
            
          
             
            // Establecer el valor del parámetro de entrada
            int mat =  HomeDOU.getMatricula();
            System.out.println(mat);
            statement.setInt(1, mat);
            

            // Procesar los resultados
            try ( // Ejecutar el procedimiento
                    ResultSet resultSet = statement.executeQuery()) {
                // Procesar los resultados
                while (resultSet.next()) {
                    String estadoEstudianteActual = resultSet.getString("Estado_estudiante");
                    setEstatoEstudiante(estadoEstudianteActual);
                    System.out.println("Estado del estudiante: " +  estadoEstudianteActual);
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
    
      public static boolean registrarEntrada() throws FileNotFoundException{
        System.out.println("obteniendo estado.. ");
        String SQL_REGISTRARENTRADA = "{CALL registraentrada(?)}";
        try(Connection conexion = ConexionDB.getConexion();
                CallableStatement statement = (CallableStatement) conexion.prepareCall(SQL_REGISTRARENTRADA)){
            
          
             
            // Establecer el valor del parámetro de entrada
            int mat =  HomeDOU.getMatricula();
            System.out.println(mat);
            statement.setInt(1, mat);
             statement.close();

            // Ejecutar el procedimiento
            return statement.execute();
            // Cerrar recursos
            
        } catch (SQLException e) {
            if ("45000".equals(e.getMessage())) {
                System.out.println(e.getMessage());
                return false;
            } else {
                System.out.println("Algo saliomal " + e.getMessage());
                return false;
            }      
        
        }
        
        
               
    }
    
}