
package Model.MenuDOU;
import java.io.FileNotFoundException;
import java.sql.SQLException;

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
    
    
    
    // metodo que registra la entrada del estudiante
    public  boolean opracineMenu() throws  FileNotFoundException, SQLException{
        
        
        switch (btnSeleccionado) {
            case "btnEntrada" -> {
                
                
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
