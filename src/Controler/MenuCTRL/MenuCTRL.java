
package Controler.MenuCTRL;
// Clase cotroladora del menu

import Controler.HomeCTRL.HomeCTRL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.MenuDOU.MenuDOU;
import View.MenuGUI;
import View.Dialogos.DialogoConfirmarGUI;
import View.Dialogos.DialogoValidado;
import java.io.FileNotFoundException;
import View.HomeStudentGUI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuCTRL implements ActionListener{
    
    MenuGUI menuGUI = new MenuGUI();
    
    DialogoConfirmarGUI dcgui = new DialogoConfirmarGUI();
    DialogoValidado dv = new DialogoValidado();
    
    
    
    
    public MenuCTRL(MenuGUI m, DialogoConfirmarGUI d, DialogoValidado dv) throws FileNotFoundException {
        // inicilizamos los eventos del la clase MenuGUI
        this.menuGUI = m;
        this.dv = dv;
        this.dcgui = d;
        this.menuGUI.btnEntradaSalida.addActionListener(this);
        
        this.menuGUI.btnComenzarFinalizarCocina.addActionListener(this);
        this.menuGUI.btnComenzarFinalizarCocina.addActionListener(this);
        this.menuGUI.btnBeginBotellon.addActionListener(this);
        this.menuGUI.btnVolver.addActionListener(this);
        
        
       // System.out.println("MenuCTRL cargado");
        // eveto dialogo validado
        this.dv.btnOk.addActionListener(this);
        
        MenuDOU.getEstadoSTU();
        
        // Establecemos el estado inicial de los botones según el estado del estudiante
        actualizarEstadoBotones();
        
        
    }
    
     // Método que actualiza la visibilidad y el texto de los botones según el estado del estudiante
    private void actualizarEstadoBotones() {
        String estadoEstudiante = MenuDOU.getEstadoEstudiante(); // Obtiene el estado actual del estudiante

        if ("Dentro".equals(estadoEstudiante)) {
            this.menuGUI.btnEntradaSalida.setVisible(true);
            this.menuGUI.btnEntradaSalida.setText("Registrar salida");

            // Mostrar botones de cocina y botellón solo si está dentro
            this.menuGUI.btnComenzarFinalizarCocina.setVisible(true);
            
            this.menuGUI.btnBeginBotellon.setVisible(true);
        } else if ("Fuera".equals(estadoEstudiante)) {
            this.menuGUI.btnEntradaSalida.setVisible(true);
            this.menuGUI.btnEntradaSalida.setText("Registrar entrada");

            // Ocultar botones de cocina y botellón si está fuera
            this.menuGUI.btnComenzarFinalizarCocina.setVisible(false);
            this.menuGUI.btnComenzarFinalizarCocina.setVisible(false);
            this.menuGUI.btnBeginBotellon.setVisible(false);
        } else if ("En cocina".equals(estadoEstudiante)) {
            this.menuGUI.btnEntradaSalida.setVisible(false); // Ocultar entrada/salida mientras está en cocina

            // Mostrar solo el botón para finalizar 
            this.menuGUI.btnComenzarFinalizarCocina.setText("Fenilizar uso cocina");
            this.menuGUI.btnComenzarFinalizarCocina.setVisible(false);
            this.menuGUI.btnBeginBotellon.setVisible(false);
        }
    }
    
   
        
    // lamar a tegistar entrada
    
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
         String estadoEstudiante = MenuDOU.getEstadoEstudiante();

        if (e.getSource() == this.menuGUI.btnEntradaSalida) {
            if ("Registrar entrada".equals(this.menuGUI.btnEntradaSalida.getText())) {
                try {
                    // Lógica para registrar entrada
                    System.out.println("Registrando entrada");
                    boolean resultado = MenuDOU.registrarEntrada();
                    System.out.println("Entrada lista");
                    
                    
                    
                    MenuDOU.setEstadoEstudiante("Dentro");
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
                        
            
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MenuCTRL.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if ("Registrar salida".equals(this.menuGUI.btnEntradaSalida.getText())) {
                // Lógica para registrar salida
                 try {
                    // Lógica para registrar entrada
                    System.out.println("Registrando salida");
                    boolean resultado = MenuDOU.registrarSalida();
                    System.out.println("salida lista");
                    
                    
                    
                    MenuDOU.setEstadoEstudiante("Fuera");
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
                        
            
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MenuCTRL.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            actualizarEstadoBotones(); // Actualiza el estado de los botones después de la acción
        }

        if (e.getSource() == this.menuGUI.btnComenzarFinalizarCocina) {
            // Lógica para iniciar cocina
            if ("Solicitar uso cocina".equals(this.menuGUI.btnComenzarFinalizarCocina.getText())) {
                // Lógica para registrar entrada
                MenuDOU.setEstadoEstudiante("En cocina");
            } else if ("Fenilizar uso cocina".equals(this.menuGUI.btnEntradaSalida.getText())) {
                // Lógica para registrar salida
                MenuDOU.setEstadoEstudiante("Dentro");
            }
            actualizarEstadoBotones(); // Actualiza el estado de los botones después de la acción
            
            
        }

        if (e.getSource() == this.menuGUI.btnComenzarFinalizarCocina) {
            // Lógica para finalizar cocina
            MenuDOU.setEstadoEstudiante("Dentro");
            actualizarEstadoBotones(); // Actualiza los botones
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

