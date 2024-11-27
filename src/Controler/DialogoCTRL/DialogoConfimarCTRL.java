
package Controler.DialogoCTRL;

import Controler.MenuCTRL.MenuCTRL;
import Model.DialogosDOU.DialogoConfirmarDOU;
import View.Dialogos.DialogoConfirmarGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.MenuGUI;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DialogoConfimarCTRL implements ActionListener{

    
    DialogoConfirmarGUI dcgui = new DialogoConfirmarGUI();
    MenuGUI menuGUI = new MenuGUI();
     
    
    
    
    
    public DialogoConfimarCTRL(DialogoConfirmarGUI v, MenuGUI m ) {
        this.dcgui =v;
        this.menuGUI = m;
        //evetos del dialogo
        this.dcgui.btnValidar.addActionListener(this);
        this.dcgui.btnCancelar.addActionListener(this);
        System.out.println("BTN Cargadodo");
    }
    
    
    
    
   
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
           
        if (e.getSource() == this.dcgui.btnValidar) {
           if ("Registrar entrada".equals(this.menuGUI.btnEntradaSalida.getText())) {
               MenuCTRL mctrl;
               try {
                   mctrl = new MenuCTRL(menuGUI, dcgui);
                   mctrl.llamarRegistrarEntrada();
                dcgui.dispose();
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(DialogoConfimarCTRL.class.getName()).log(Level.SEVERE, null, ex);
               }
                

                
            } else if ("Registrar salida".equals(this.menuGUI.btnEntradaSalida.getText())) {
               MenuCTRL mctrl;
               try {
                   mctrl = new MenuCTRL(menuGUI, dcgui);
                   mctrl.llamarRegistrarSalida();
                    dcgui.dispose();
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(DialogoConfimarCTRL.class.getName()).log(Level.SEVERE, null, ex);
               }
                
            }
       
            
        }
        if (e.getSource() == this.dcgui.btnCancelar) {    
                DialogoConfirmarDOU.setComfimar(false);
                dcgui.dispose();
            }
    }
}    
