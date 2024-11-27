
package Controler.MenuCTRL;
// Clase cotroladora del menu

import Controler.HomeCTRL.HomeCTRL;
import Controler.DialogoCTRL.DialogoConfimarCTRL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.MenuDOU.MenuDOU;
import View.MenuGUI;
import View.Dialogos.DialogoConfirmarGUI;
import java.io.FileNotFoundException;
import View.HomeStudentGUI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuCTRL implements ActionListener{
    
    MenuGUI menuGUI = new MenuGUI();
    
    DialogoConfirmarGUI dcgui = new DialogoConfirmarGUI();
    
    
    
    public MenuCTRL(MenuGUI m, DialogoConfirmarGUI d) throws FileNotFoundException {
        // inicilizamos los eventos del la clase MenuGUI
        this.menuGUI = m;
        
        this.dcgui = d;
        this.menuGUI.btnEntradaSalida.addActionListener(this);
        
        this.menuGUI.btnComenzarFinalizarCocina.addActionListener(this);
        this.menuGUI.btnComenzarFinalizarCocina.addActionListener(this);
        this.menuGUI.btnBeginBotellon.addActionListener(this);
        this.menuGUI.btnVolver.addActionListener(this);

        
        
        // Establecemos el estado inicial de los botones según el estado del estudiante
        actualizarEstadoBotones();
        
        
    }
    
     // Método que actualiza la visibilidad y el texto de los botones según el estado del estudiante
    private void actualizarEstadoBotones() throws FileNotFoundException {
         MenuDOU.getEstadoSTU(); // Obtiene el estado actual del estudiante
        System.out.println(MenuDOU.getEstadoEstudiante());
        if ("Dentro".equals(MenuDOU.getEstadoEstudiante())) {
            this.menuGUI.btnEntradaSalida.setVisible(true);
            this.menuGUI.btnEntradaSalida.setText("Registrar salida");

            // Mostrar botones de cocina y botellón solo si está dentro
            this.menuGUI.btnComenzarFinalizarCocina.setVisible(true);
            
            this.menuGUI.btnBeginBotellon.setVisible(true);
        } else if ("Fuera".equals(MenuDOU.getEstadoEstudiante())) {
            this.menuGUI.btnEntradaSalida.setVisible(true);
            this.menuGUI.btnEntradaSalida.setText("Registrar entrada");

            // Ocultar botones de cocina y botellón si está fuera
            this.menuGUI.btnComenzarFinalizarCocina.setVisible(false);
            this.menuGUI.btnComenzarFinalizarCocina.setVisible(false);
            this.menuGUI.btnBeginBotellon.setVisible(false);
        } else if ("En cocina".equals(MenuDOU.getEstadoEstudiante())) {
            this.menuGUI.btnEntradaSalida.setVisible(false); // Ocultar entrada/salida mientras está en cocina

            // Mostrar solo el botón para finalizar 
            this.menuGUI.btnComenzarFinalizarCocina.setText("Fenilizar uso cocina");
            this.menuGUI.btnComenzarFinalizarCocina.setVisible(false);
            this.menuGUI.btnBeginBotellon.setVisible(false);
        }
    }
    
   
        
    // llamar a registar entrada
 public  void llamarRegistrarEntrada(){
         try {
                    // Lógica para registrar entrada
                    System.out.println("Registrando entrada");
                    boolean resultado = MenuDOU.registrarEntrada();
                    System.out.println("Entrada lista");
                    if (resultado) {
                        menuGUI.dispose();
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    MenuGUI menuGUI = new MenuGUI();
                    System.out.println("cerrando desde entrada");
                        
                    
                    
                    hsgui.setVisible(true);
                    actualizarEstadoBotones();
                    }
                    
                    
                    
                        
            
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MenuCTRL.class.getName()).log(Level.SEVERE, null, ex);
                }
         
    }
    
      // llamar a registar entrada
    public  void llamarRegistrarSalida(){
         try {
                    // Lógica para registrar entrada
                    System.out.println("Registrando salida");
                    boolean resultado = MenuDOU.registrarSalida();
                    if (resultado) {
                        System.out.println("salida lista");
                    menuGUI.dispose();
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    MenuGUI menuGUI = new MenuGUI();
                    System.out.println("cerrando desde entrada");
                    
                    hsgui.setVisible(true);
                    actualizarEstadoBotones();
                    }
                    
            
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MenuCTRL.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
   
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
         

        if (e.getSource() == this.menuGUI.btnEntradaSalida) {
            try {
                if ("Registrar entrada".equals(this.menuGUI.btnEntradaSalida.getText())) {
                    
                    
                    DialogoConfimarCTRL dcctrl = new  DialogoConfimarCTRL(dcgui, menuGUI);
                    dcgui.setVisible(true);
                    
                    
                    
                    
                } else if ("Registrar salida".equals(this.menuGUI.btnEntradaSalida.getText())) {
                    
                    // Lógica para registrar salida
                    
                    
                    DialogoConfimarCTRL dcctrl = new  DialogoConfimarCTRL(dcgui, menuGUI);
                    dcgui.setVisible(true);
                    
                    
                    
                    
                    
                }
                actualizarEstadoBotones(); // Actualiza el estado de los botones después de la acción
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MenuCTRL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == this.menuGUI.btnComenzarFinalizarCocina) {
            try {
                // Lógica para iniciar cocina
                if ("Solicitar uso cocina".equals(this.menuGUI.btnComenzarFinalizarCocina.getText())) {
                    // Lógica para registrar entrada
                    MenuDOU.setEstadoEstudiante("En cocina");
                } else if ("Fenilizar uso cocina".equals(this.menuGUI.btnEntradaSalida.getText())) {
                    // Lógica para registrar salida
                    MenuDOU.setEstadoEstudiante("Dentro");
                }
                actualizarEstadoBotones(); // Actualiza el estado de los botones después de la acción
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MenuCTRL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

        if (e.getSource() == this.menuGUI.btnComenzarFinalizarCocina) {
            // Lógica para finalizar cocina
            MenuDOU.setEstadoEstudiante("Dentro");
            try {
                actualizarEstadoBotones(); // Actualiza los botones
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MenuCTRL.class.getName()).log(Level.SEVERE, null, ex);
            }
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

