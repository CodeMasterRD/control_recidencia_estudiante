
package Model.MenuDOU;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import Model.RegistroMatricula.HomeDOU;
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
    public static boolean registraEntrada() throws SQLException, FileNotFoundException{
        try {
            int mat = HomeDOU.getMatricula();
            System.out.println("Registrando entrada");
            System.out.println("La matricula a registra la entrada es: ");
            System.out.println(mat);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    
    
    // metodo que registra la entrada del estudiante
    public  boolean opracineMenu() throws  FileNotFoundException, SQLException{
        
        
        switch (btnSeleccionado) {
            case "btnEntrada" -> {
                
                return registraEntrada();
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
