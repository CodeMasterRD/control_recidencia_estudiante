
package Controler.DialogoCTRL;

import Model.DialogosDOU.DialogoConfirmarDOU;
import View.Dialogos.DialogoConfirmarGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.MenuDOU.MenuDOU;

public class DialogoConfimarCTRL implements ActionListener{

    
    DialogoConfirmarDOU dOU = new DialogoConfirmarDOU();
    DialogoConfirmarGUI dcgui = new DialogoConfirmarGUI();
    
    
    
    
    public DialogoConfimarCTRL(DialogoConfirmarGUI v) {
        this.dcgui =v;
        
        //evetos del dialogo
        this.dcgui.btnValidar.addActionListener(this);
        this.dcgui.btnCancelar.addActionListener(this);
        System.out.println("BTN Cargadodo");
    }
    // metodo que llama la operacion segun el estado del estudiante
    private void validarEstado(){
        System.out.println(MenuDOU.getEstatoEstudiante());
        if ("Dentro".equals(MenuDOU.getEstatoEstudiante())) {
               
               System.out.println("Registrar salida");
               
           }else if ("Fuera".equals(MenuDOU.getEstatoEstudiante())){
               System.out.println("Registrar salida");
               
           }
           
    }
    
  
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
          
           
        if (e.getSource() == this.dcgui.btnValidar) {
                System.out.println("llamando al metodo registra..");
                DialogoConfirmarDOU.setComfimar(true);
                System.out.println("validar");
                validarEstado();
                
                dcgui.dispose();
                
            }
            
        if (e.getSource() == this.dcgui.btnCancelar) {    
            System.out.println("llamando al metodo registra..");
                DialogoConfirmarDOU.setComfimar(false);
                System.out.println("cancelar");
                dcgui.dispose();
        }
    }
    
}
