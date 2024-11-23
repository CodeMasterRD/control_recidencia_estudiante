
package Model.MenuDOU;
import Model.ConexionDB;
import Model.FechaHora.Fecha;
import Model.FechaHora.FechaHora;
import Model.FechaHora.Hora;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import Model.RegistroMatricula.HomeDOU;
import com.mysql.cj.jdbc.CallableStatement;
import javax.swing.*;
// Clase que menejalos dato del MenuGUI

public class MenuDOU {
    
    private String btnSeleccionado;
    int matricula = HomeDOU.getMatricula();
    
    private String fechaHora = FechaHora.getFechaHoraActual();
    private String fecha = Fecha.getFechaActual();
    private String hora = Hora.getHoraActual();
    
    

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
    
    
    //metodo que registra la entrada del estudiante a la residencia
    public static boolean registraEntrada(int matricula, String fechaHora, String fecha, String hora) throws SQLException, FileNotFoundException{
        //procedure 
        String SQL_REGISTRAR_ENTRADA = "{call registraentrada(?,?,?,?)}";
        //eje: call registraentrada(20231861, '2024-11-24 06:22:30', '2024-11-22', '06:22:30');
        try(java.sql.Connection conexion = ConexionDB.getConexion();
                CallableStatement call = (CallableStatement) conexion.prepareCall(SQL_REGISTRAR_ENTRADA)){
            
            // Convertir LocalDateTime a SQL Date y Time
            
             // Establecer parámetros del procedimiento almacenado
            call.setInt(1, matricula); // Matricula
            call.setString(2,fechaHora); // Fecha y Hora completa
            
            call.setString(3, fecha); // Fecha (DATE)
            call.setString(4, hora); // Hora (TIME)
            
            // Ejecutar el procedimiento
            call.execute();
            System.out.println("Entrada registrada exitosamente.");
            return true;
            
        } catch (SQLException e) {
            // Manejo de excepciones SQL
            if ("45000".equals(e.getSQLState())) {
                System.err.println("Error personalizado: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "No puedes registrar una entrada, si ya esta dentro .", "Arvertencia", JOptionPane.INFORMATION_MESSAGE);
                return false;
            } else {
                System.err.println("eError SQL: " + e.getMessage());
            }
            return false;
        }
       
        
    }
    //metodo que registra la entrada del estudiante a la residencia
    public static boolean registraSalida(int matricula, String fechaHora, String fecha, String hora) throws SQLException, FileNotFoundException{
        //procedure 
        String SQL_REGISTRAR_ENTRADA = "{call registrasalida(?,?,?,?)}";
        //eje: call registraentrada(20231861, '2024-11-24 06:22:30', '2024-11-22', '06:22:30');
        try(java.sql.Connection conexion = ConexionDB.getConexion();
                CallableStatement call = (CallableStatement) conexion.prepareCall(SQL_REGISTRAR_ENTRADA)){
            
            // Convertir LocalDateTime a SQL Date y Time
            
             // Establecer parámetros del procedimiento almacenado
            call.setInt(1, matricula); // Matricula
            call.setString(2,fechaHora); // Fecha y Hora completa
            
            call.setString(3, fecha); // Fecha (DATE)
            call.setString(4, hora); // Hora (TIME)
            
            // Ejecutar el procedimiento
            call.execute();
            System.out.println("salida registrada exitosamente.");
            return true;
            
        } catch (SQLException e) {
            // Manejo de excepciones SQL
            if ("45000".equals(e.getSQLState())) {
                System.err.println("Error personalizado: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "No puedes registrar una salida, sii saliste .", "Arvertencia", JOptionPane.INFORMATION_MESSAGE);
                return false;
                
                
            } else {
                System.err.println("Error SQL: " + e.getMessage());
                System.out.println("Algo salio mal ");
            }
            return false;
        }
       
        
    }
    
    
    
    
    // metodo que registra la entrada del estudiante
    public  boolean opracineMenu() throws  FileNotFoundException, SQLException{
        
        
        switch (btnSeleccionado) {
            case "btnEntrada" -> {
               
                              
               return registraEntrada(matricula, fechaHora, fecha, hora);
            }
            case "btnSalida" -> {
                
               return registraSalida(matricula, fechaHora, fecha, hora);
            }    
            
            case "btnBeginCocina" -> {
                
            }
                
            case "btnEndCocina" -> {
                
            }
            case "btnBeginBotellon" -> {
                
            }
            default -> throw new AssertionError();
        }
        return false;
        
    }
}
