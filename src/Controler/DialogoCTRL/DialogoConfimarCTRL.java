
package Controler.DialogoCTRL;

import Model.DialogosDOU.DialogoConfirmarDOU;
import View.Dialogos.DialogoConfirmarGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.MenuDOU.MenuDOU;
import View.Dialogos.DialogoValidado;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DialogoConfimarCTRL implements ActionListener{

    
    DialogoConfirmarDOU dOU = new DialogoConfirmarDOU();
    DialogoConfirmarGUI dcgui = new DialogoConfirmarGUI();
    DialogoValidado dv = new DialogoValidado();
    
    
    
    
    public DialogoConfimarCTRL(DialogoConfirmarGUI v) {
        this.dcgui =v;
        
        //evetos del dialogo
        this.dcgui.btnValidar.addActionListener(this);
        this.dcgui.btnCancelar.addActionListener(this);
        System.out.println("BTN Cargadodo");
    }
    // metodo que llama la operacion segun el estado del estudiante
    private void validarEstado() throws FileNotFoundException{
        
        if ("Dentro".equals(MenuDOU.getEstadoEstudiante())) {
               
               System.out.println("Registrar salida");
               
           }else if ("Fuera".equals(MenuDOU.getEstadoEstudiante())){
               boolean result = MenuDOU.registrarEntrada();
            if (result) {
                System.out.println("Entrada registrada correctamente");
                
            }else{
                System.out.println("Operacion Fallida");
            }
               
           }
           
    }
    
  
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
          
           
        if (e.getSource() == this.dcgui.btnValidar) {
            try {
                System.out.println("llamando al metodo registra..");
                DialogoConfirmarDOU.setComfimar(true);
                System.out.println("validar");
                validarEstado();
                
                dcgui.dispose();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DialogoConfimarCTRL.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
            
        if (e.getSource() == this.dcgui.btnCancelar) {    
            System.out.println("llamando al metodo registra..");
                DialogoConfirmarDOU.setComfimar(false);
                System.out.println("cancelar");
                dcgui.dispose();
        }
    }
    
}
