
package recidencia_contro;

import Model.ConexionDB;
import View.HomeStudentGUI;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import Controler.HomeCTRL.HomeCTRL;
import View.MenuGUI;
import View.Dialogos.DialogoConfirmarGUI;
import Controler.MenuCTRL.MenuCTRL;


public class Recidencia_contro {

   
    public static void main(String[] args) throws SQLException, FileNotFoundException{
        ConexionDB conexionDB = new ConexionDB();
        Connection conexion = ConexionDB.getConexion();
        
        HomeStudentGUI home = new HomeStudentGUI();
        //home.setVisible(true);
        home.setLocationRelativeTo(null);
        // le pasamos la clase home(HomeStudentGUI) al controlador
        HomeCTRL homeCTRL = new HomeCTRL(home);
        //intacias MenuGUI de prueba
        MenuGUI menuGUI = new MenuGUI();
        menuGUI.setVisible(true);
        // instancia del dialogo
        DialogoConfirmarGUI dcgui = new DialogoConfirmarGUI();
        //Instacin del Controlador del Menu
        MenuCTRL mctrl = new MenuCTRL(menuGUI, dcgui);
        
        
        
        
        
    }
    
}
