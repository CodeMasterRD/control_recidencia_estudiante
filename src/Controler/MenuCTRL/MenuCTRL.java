
package Controler.MenuCTRL;
// Clase cotroladora del menu

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.MenuDOU.MenuDOU;
import View.MenuGUI;
import View.Dialogos.DialogoConfirmarGUI;
import Model.DialogosDOU.DialogoConfirmarDOU;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        System.out.println("MenuCTRL cargado");
        
        
    }
    
// metodo que setea al esta dialogo si es estudiate valido para continar o cancelo
    public void llamarOperaciones(){
         if (DialogoConfirmarDOU.isComfimar()) {
                try {
                    boolean resultado = menuDOU.opracineMenu();
                    if (resultado) {
                        System.out.println("Oprecionregistra exitosa.");
                    }else{
                        System.out.println("la operacipn no fue exitosa");
                    }
                } catch (FileNotFoundException | SQLException ex) {
                    Logger.getLogger(MenuCTRL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //eveto sobre btnRegistrar
        if (e.getSource() == this.menuGUI.btnRegistra) {
            menuDOU.setBtnSeleccionado("btnEntrada");
            System.out.println("Desde el btn entrar");
            
            dcgui.setVisible(true);                      
          
        }   
        
        if (e.getSource() == this.menuGUI.btnSalida) {
            dcgui.setVisible(true);
            menuDOU.setBtnSeleccionado("btnSalida");
          
        }  
        if (e.getSource() == this.menuGUI.btnBeginCocina) {
            dcgui.setVisible(true);
            menuDOU.setBtnSeleccionado("btnSalida");
          
        }  
        if (e.getSource() == this.menuGUI.btnENDCocina) {
            dcgui.setVisible(true);
            menuDOU.setBtnSeleccionado("btnSalida");
          
        }  
        if (e.getSource() == this.menuGUI.btnBeginBotellon) {
            dcgui.setVisible(true);
            menuDOU.setBtnSeleccionado("btnSalida");
          
        }  
            
        // validamos la comfirmacion
            
            if (e.getSource() == this.dcgui.btnValidar) {
                System.out.println("llamando al metodo registra..");
                DialogoConfirmarDOU.setComfimar(true);
                llamarOperaciones();
                dcgui.dispose();
                
            }
            
            if (e.getSource() == this.dcgui.btnCancelar) {
                DialogoConfirmarDOU.setComfimar(true);
                dcgui.dispose();
                System.out.println("Operacion Cacelada..");
                
            }
            
            
            
            
        
        
    }
    
    
    
}
