
package Model.MenuDOU;
import Model.ConexionDB;
import Model.FechaHora.FechaHora;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import Model.RegistroMatricula.HomeDOU;
import View.HomeStudentGUI;
import View.Dialogos.DialogoValidado;
import com.mysql.cj.jdbc.CallableStatement;
import com.sun.jdi.connect.spi.Connection;

// Clase que menejalos dato del MenuGUI

public class MenuDOU {
    
    private String btnSeleccionado;
    
    

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
    public static boolean registraEntrada(int matricula, String fechaHora, String estado, String fecha, String hora) throws SQLException, FileNotFoundException{
        //procedure 
        String SQL_REGISTRAR_ENTRADA = "{call registraentrada(?,?,?,?,?)}";
        try(java.sql.Connection conexion = ConexionDB.getConexion();
                CallableStatement call = (CallableStatement) conexion.prepareCall(SQL_REGISTRAR_ENTRADA)){
            
            // Convertir LocalDateTime a SQL Date y Time
            
             // Establecer parámetros del procedimiento almacenado
            call.setInt(1, matricula); // Matricula
            call.setTimestamp(2, java.sql.Timestamp.valueOf(fechaHora)); // Fecha y Hora completa
            call.setString(3, estado); // Estado ('Fuera' o 'Dentro')
            //call.setDate(4, fecha); // Fecha (DATE)
            //call.setTime(5, hora); // Hora (TIME)
            
            // Ejecutar el procedimiento
            call.execute();
            System.out.println("Entrada registrada exitosamente.");
            return true;
            
        } catch (SQLException e) {
            // Manejo de excepciones SQL
            if ("45000".equals(e.getSQLState())) {
                System.err.println("Error personalizado: " + e.getMessage());
            } else {
                System.err.println("Error SQL: " + e.getMessage());
            }
            return false;
        }
       
        
    }
    
    
    
    // metodo que registra la entrada del estudiante
    public  boolean opracineMenu() throws  FileNotFoundException, SQLException{
        
        
        switch (btnSeleccionado) {
            case "btnEntrada" -> {
                int matricula = HomeDOU.getMatricula();
//                String fechaHora = FechaHora.getFechaHoraActual();
//                String estado = 
//                return registraEntrada( );
            }
            case "btnSalida" -> {
               
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
