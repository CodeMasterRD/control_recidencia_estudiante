
package Controler.MenuCTRL;
// Clase cotroladora del menu

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.MenuDOU.MenuDOU;
import View.MenuGUI;
public class MenuCTRL implements ActionListener{
    
    MenuDOU menuDOU = new MenuDOU();
    MenuGUI menuGUI = new MenuGUI();
    
    public MenuCTRL(MenuGUI m) {
        // inicilizamos los eventos del la clase MenuGUI
        this.menuGUI = m;
        this.menuGUI.btnRegistra.addActionListener(this);
        this.menuGUI.btnSalida.addActionListener(this);
        this.menuGUI.btnBeginCocina.addActionListener(this);
        this.menuGUI.btnENDCocina.addActionListener(this);
        this.menuGUI.btnBeginBotellon.addActionListener(this);
        
    }
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
}
