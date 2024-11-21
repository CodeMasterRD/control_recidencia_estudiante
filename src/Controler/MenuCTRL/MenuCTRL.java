
package Controler.MenuCTRL;
// Clase cotroladora del menu

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.MenuDOU.MenuDOU;
import View.MenuGUI;
import View.Dialogos.DialogoConfirmarGUI;
public class MenuCTRL implements ActionListener{
    
    MenuDOU menuDOU = new MenuDOU();
    MenuGUI menuGUI = new MenuGUI();
    DialogoConfirmarGUI dcgui = new DialogoConfirmarGUI();
    
    
    public MenuCTRL(MenuGUI m, DialogoConfirmarGUI d) {
        // inicilizamos los eventos del la clase MenuGUI
        this.menuGUI = m;
        this.menuGUI.btnRegistra.addActionListener(this);
        this.menuGUI.btnSalida.addActionListener(this);
        this.menuGUI.btnBeginCocina.addActionListener(this);
        this.menuGUI.btnENDCocina.addActionListener(this);
        this.menuGUI.btnBeginBotellon.addActionListener(this);
        
        //evetos del dialogo
        this.dcgui.btnValidar.addActionListener(this);
        this.dcgui.btnCancelar.addActionListener(this);
        
        
    }
    

    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //eveto sobre btnRegistrar
        if (e.getSource() == this.menuGUI.btnRegistra) {
            dcgui.setVisible(true);
            
            
            
            // validamos la comfirmacion
            
            if (e.getSource() == this.dcgui.btnValidar) {
                System.out.println("llamando al metodo registra..");
                
            }
            
            if (e.getSource() == this.dcgui.btnCancelar) {
                System.out.println("Operacion Cacelada..");
                
            }
            
            
        }
        
    }
    
    
    
}
