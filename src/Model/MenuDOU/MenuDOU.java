
package Model.MenuDOU;
import java.sql.*;
import Model.ConexionDB;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import Model.RegistroMatricula.HomeDOU;
import com.mysql.cj.jdbc.CallableStatement;
import Model.EstudianteModel.EstudianteModel;
import Model.Notificaciones.NotificacionesDOU;
public class MenuDOU {
    
    
    
    public MenuDOU() {
    }

   
    
    // METODO PARA OTENER EL ESTADO DE LA NOTIFICACIONE

      public static boolean registrarEntrada() throws FileNotFoundException{
        System.out.println("obteniendo estado.. ");
        String SQL_REGISTRARENTRADA = "{CALL registraentrada(?)}";
        try(Connection conexion = ConexionDB.getConexion();
                CallableStatement statement = (CallableStatement) conexion.prepareCall(SQL_REGISTRARENTRADA)){
            
          
             
            // Establecer el valor del parámetro de entrada
            int mat =  EstudianteModel.getMatricula();
            System.out.println(mat);
            statement.setInt(1, mat);
            

            // Ejecutar el procedimiento
            statement.execute();
            return true;
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
      
    public static boolean registrarSalida() throws FileNotFoundException{
        System.out.println("obteniendo estado.. ");
        String SQL_REGISTRARENTRADA = "{CALL registrasalida(?)}";
        try(Connection conexion = ConexionDB.getConexion();
                CallableStatement statement = (CallableStatement) conexion.prepareCall(SQL_REGISTRARENTRADA)){
            
          
             
            // Establecer el valor del parámetro de entrada
            int mat =  EstudianteModel.getMatricula();
            System.out.println(mat);
            statement.setInt(1, mat);
            

            // Ejecutar el procedimiento
            statement.execute();
            return true;
            
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
    
    
    // solicitar uso de la cocina
    
        public static boolean registrarUsoCocina() throws FileNotFoundException {
        String SQL_REGISTRAR_USO_COCINA = "{CALL RegistrarUsoCocina(?)}";

        try (Connection conexion = ConexionDB.getConexion();  // Conexión automática usando try-with-resources
             CallableStatement statement = (CallableStatement) conexion.prepareCall(SQL_REGISTRAR_USO_COCINA)) {
            int mat =  EstudianteModel.getMatricula();
            // Establecer el valor del parámetro de entrada
            statement.setInt(1, mat);

            // Ejecutar el procedimiento almacenado
            statement.execute();

            
            return true;

        } catch (SQLException e) {
            // Manejar errores de SQL
            if ("45000".equals(e.getSQLState())) {
                System.out.println("Error personalizado: " + e.getMessage());
            } else {
                System.out.println("Error inesperado: " + e.getMessage());
            }
            return false;
        }
    }
       public static boolean finalizaUsoCocina() throws FileNotFoundException {
        String SQL_REGISTRAR_USO_COCINA = "{CALL FinalizarUsoCocina(?)}";

        try (Connection conexion = ConexionDB.getConexion();  // Conexión automática usando try-with-resources
             CallableStatement statement = (CallableStatement) conexion.prepareCall(SQL_REGISTRAR_USO_COCINA)) {
            int mat =  EstudianteModel.getMatricula();
            // Establecer el valor del parámetro de entrada
            statement.setInt(1, mat);

            // Ejecutar el procedimiento almacenado
            statement.execute();

            return true;

        } catch (SQLException e) {
            // Manejar errores de SQL
            if ("45000".equals(e.getSQLState())) {
                System.out.println("Error personalizado: " + e.getMessage());
            } else {
                System.out.println("Error inesperado: " + e.getMessage());
            }
            return false;
        }
    }
       
       
      public static boolean SolicitarBotellon() throws FileNotFoundException{
        System.out.println("Soolicitando botellon");
        String SQL_REGISTRARENTRADA = "{CALL solicitarBotellones(?)}";
        try(Connection conexion = ConexionDB.getConexion();
                CallableStatement statement = (CallableStatement) conexion.prepareCall(SQL_REGISTRARENTRADA)){
             
            // Establecer el valor del parámetro de entrada
            int mat =  EstudianteModel.getMatricula();
            System.out.println(mat);
            statement.setInt(1, mat);
            

            // Ejecutar el procedimiento
            statement.execute();
            return true;
            
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
        
    
      
      
      
      
       public static boolean DepocitarBotellon() throws FileNotFoundException{
        System.out.println("Depocitando Botellon");
        String SQL_REGISTRARENTRADA = "{CALL depositoBotellones(?)}";
        try(Connection conexion = ConexionDB.getConexion();
                CallableStatement statement = (CallableStatement) conexion.prepareCall(SQL_REGISTRARENTRADA)){
            
          
             
            // Establecer el valor del parámetro de entrada
            int mat =  EstudianteModel.getMatricula();
            System.out.println(mat);
            statement.setInt(1, mat);
            

            // Ejecutar el procedimiento
            statement.execute();
            return true;
            
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