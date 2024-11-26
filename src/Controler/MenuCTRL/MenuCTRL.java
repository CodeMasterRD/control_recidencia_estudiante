
package Controler.MenuCTRL;
// Clase cotroladora del menu

import Controler.HomeCTRL.HomeCTRL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.MenuDOU.MenuDOU;
import View.MenuGUI;
import View.Dialogos.DialogoConfirmarGUI;
import Model.DialogosDOU.DialogoConfirmarDOU;
import View.Dialogos.DialogoValidado;
import java.io.FileNotFoundException;
import View.HomeStudentGUI;
import Controler.DialogoCTRL.DialogoConfimarCTRL;

public class MenuCTRL implements ActionListener{
    
    MenuDOU menuDOU = new MenuDOU();
    MenuGUI menuGUI = new MenuGUI();
    
    DialogoConfirmarGUI dcgui = new DialogoConfirmarGUI();
    DialogoValidado dv = new DialogoValidado();
    
    
    
    
    public MenuCTRL(MenuGUI m, DialogoConfirmarGUI d, DialogoValidado dv) throws FileNotFoundException {
        // inicilizamos los eventos del la clase MenuGUI
        this.menuGUI = m;
        this.dv = dv;
        this.dcgui = d;
        this.menuGUI.btnEntradaSalida.addActionListener(this);
        
        this.menuGUI.btnBeginCocina.addActionListener(this);
        this.menuGUI.btnENDCocina.addActionListener(this);
        this.menuGUI.btnBeginBotellon.addActionListener(this);
        this.menuGUI.btnVolver.addActionListener(this);
        
        
       // System.out.println("MenuCTRL cargado");
        // eveto dialogo validado
        this.dv.btnOk.addActionListener(this);
        
        MenuDOU.getEstadoSTU();
        cambiarNombrebtn();
        
        
    }
    
    //metodo que llama los metodos del menu segun el estado del estudiante
    public void OperacionesMenu(){
        System.out.println("");
    }
    
    // metodo que cambien el nombre del boton registra Entrad/registrar salida segun el estado del estudiante
       private void cambiarNombrebtn(){
           if ("Dentro".equals(MenuDOU.getEstatoEstudiante())) {
               this.menuGUI.btnEntradaSalida.setText("Registra salida");
               System.out.println("Registrar salida");
               
           }else if ("Fuera".equals(MenuDOU.getEstatoEstudiante())){
               this.menuGUI.btnEntradaSalida.setText("Registra entrada");
           }
           
       }

        

    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
         // validamos la comfirmacion
        
        
        if (e.getSource() == this.menuGUI.btnEntradaSalida) {
            System.out.println("btn Actual: " + this.menuGUI.btnEntradaSalida.getText());
            DialogoConfirmarGUI d = new DialogoConfirmarGUI();
            DialogoConfimarCTRL dcctrl = new DialogoConfimarCTRL(d);
                    
                    
            d.setVisible(true);
        }
        
        
            
            if (e.getSource() == this.menuGUI.btnVolver) {
                        menuGUI.dispose();
                        HomeStudentGUI hsgui = new HomeStudentGUI();
                        HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                        hsgui.setVisible(true);
                        dcgui.dispose();
           
            }
            
           
        
    }
}  

