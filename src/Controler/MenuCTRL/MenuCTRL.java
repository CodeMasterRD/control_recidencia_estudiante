
package Controler.MenuCTRL;
// Clase cotroladora del menu

import Controler.HomeCTRL.HomeCTRL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.MenuDOU.MenuDOU;
import View.MenuGUI;
import java.io.FileNotFoundException;
import View.HomeStudentGUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MenuCTRL implements ActionListener{
    
    MenuGUI menuGUI = new MenuGUI();
    MenuDOU mdou = new MenuDOU();
    
    
    
    
    
    public MenuCTRL(MenuGUI m) throws FileNotFoundException {
        // inicilizamos los eventos del la clase MenuGUI
        this.menuGUI = m;
        
        this.menuGUI.btnEntradaSalida.addActionListener(this);
        
        this.menuGUI.btnRegistrarUsoCocina.addActionListener(this);
        this.menuGUI.btnFinalizarUsoCocina.addActionListener(this);
        this.menuGUI.btnSolicitarBotellon_DepositarBotello.addActionListener(this);
        this.menuGUI.btnVolver.addActionListener(this);
        
        
        
        // Establecemos el estado inicial de los botones según el estado del estudiante
        actualizarEstadoBotones();
        
        
    }
    
     // Método que actualiza la visibilidad y el texto de los botones según el estado del estudiante
    private void actualizarEstadoBotones() throws FileNotFoundException {
          // Obtiene el estado actual del estudiante
          //MenuDOU.getEstadoSTU();
        
        
        if ("Dentro".equals(MenuDOU.getEstadoSTU() ) && "Pendiente".equals(MenuDOU.getEstadoNotificacio()) ) {

            this.menuGUI.btnEntradaSalida.setVisible(true);
            this.menuGUI.btnEntradaSalida.setText("Registrar salida");

            // Mostrar botones de cocina y botellón solo si está dentro
            this.menuGUI.btnRegistrarUsoCocina.setVisible(true);
            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);   
            this.menuGUI.btnSolicitarBotellon_DepositarBotello.setVisible(true);
            this.menuGUI.btnSolicitarBotellon_DepositarBotello.setText("En espera de botellon");
            
            
        }else if ("Dentro".equals(MenuDOU.getEstadoSTU() ) ) {

            this.menuGUI.btnEntradaSalida.setVisible(true);
            this.menuGUI.btnEntradaSalida.setText("Registrar salida");

            // Mostrar botones de cocina y botellón solo si está dentro
            this.menuGUI.btnRegistrarUsoCocina.setVisible(true);
            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
            
            this.menuGUI.btnSolicitarBotellon_DepositarBotello.setVisible(true);
        }  else if ("Fuera".equals(MenuDOU.getEstadoSTU())) {
            
            this.menuGUI.btnEntradaSalida.setVisible(true);
            this.menuGUI.btnEntradaSalida.setText("Registrar entrada");

            // Ocultar botones de cocina y botellón si está fuera
            this.menuGUI.btnRegistrarUsoCocina.setVisible(false);
            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
            this.menuGUI.btnSolicitarBotellon_DepositarBotello.setVisible(false);
        } else if ("En cocina".equals(MenuDOU.getEstadoSTU())) {
            this.menuGUI.btnEntradaSalida.setVisible(false); // Ocultar entrada/salida mientras está en cocina
            // Mostrar solo el botón para finalizar 
            this.menuGUI.btnRegistrarUsoCocina.setVisible(false);
            this.menuGUI.btnFinalizarUsoCocina.setVisible(true);
            this.menuGUI.btnSolicitarBotellon_DepositarBotello.setVisible(false);
        }
        else if ("Pendiente".equals(MenuDOU.getEstadoNotificacio())) {
            this.menuGUI.btnEntradaSalida.setVisible(false); // Ocultar entrada/salida mientras está en cocina
            // Mostrar solo el botón para finalizar 
            this.menuGUI.btnRegistrarUsoCocina.setVisible(false);
            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
            this.menuGUI.btnSolicitarBotellon_DepositarBotello.setVisible(false);
        }
    }

    
    @Override
public void actionPerformed(ActionEvent e) {
    try {
        Object source = e.getSource();

        if (source == menuGUI.btnEntradaSalida) {
            handleEntradaSalidaAction();
        } else if (source == menuGUI.btnRegistrarUsoCocina) {
            handleRegistrarCocinaAction();
        } else if (source == menuGUI.btnFinalizarUsoCocina) {
//            System.out.println("finalizar uso cocina");
            handleFinalizarUsoCocinaAction();
        } else if (source == menuGUI.btnSolicitarBotellon_DepositarBotello) {
            System.out.println("CLick solicitar o depositar");
            handleSolicitar_Depositar_Botellon();
            
        }else if (source == menuGUI.btnVolver) {
            handleVolverAction();
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(MenuCTRL.class.getName()).log(Level.SEVERE, "Error al manejar la acción", ex);
        JOptionPane.showMessageDialog(menuGUI, "Error al realizar la operación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void handleEntradaSalidaAction() throws FileNotFoundException {
    String buttonText = menuGUI.btnEntradaSalida.getText();

    if ("Registrar entrada".equals(buttonText)) {
         if (mostrarDialogoConfirmacion("¿Deseas registrar la entrada?")) {
            
                    MenuDOU.registrarEntrada();  
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.setVisible(false);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
        }
    } else if ("Registrar salida".equals(buttonText)) {
        if (mostrarDialogoConfirmacion("¿Deseas registrar la salida?")) {
            
                    MenuDOU.registrarSalida();  
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.setVisible(false);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
        }
    }

    actualizarEstadoBotones();
}

    private void handleRegistrarCocinaAction()throws FileNotFoundException {
        String buttonText = menuGUI.btnRegistrarUsoCocina.getText();

        if ("Solicitar uso cocina".equals(buttonText)) {
            if (mostrarDialogoConfirmacion("¿Deseas solicitar el uso de la cocina?")) {
                    MenuDOU.registrarUsoCocina();
                     
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.setVisible(false);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
            }
        }

        actualizarEstadoBotones();
    } 
    
    private void handleFinalizarUsoCocinaAction()throws FileNotFoundException {
        String buttonText = menuGUI.btnFinalizarUsoCocina.getText();

        if ("Finalizar uso cocina".equals(buttonText)) {
           if (mostrarDialogoConfirmacion("¿Deseas finalizar el uso de la cocina?")) {
                System.out.println("llamando a finalizar uso cocina");
                    MenuDOU.finalizaUsoCocina();
                     
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.setVisible(false);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
        }
        }

        actualizarEstadoBotones();
    } 
    
    
    private void handleSolicitar_Depositar_Botellon() throws FileNotFoundException {
    String buttonText = menuGUI.btnSolicitarBotellon_DepositarBotello.getText();

    if ("Solicitar botellon".equals(buttonText)) {
         if (mostrarDialogoConfirmacion("¿Deseas solicitar un botellon?")) {
            
                    MenuDOU.SolicitarBotellon();  
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.setVisible(false);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
        }
    } else if ("Depocitar botellon".equals(buttonText)) {
        if (mostrarDialogoConfirmacion("¿Deseas depositar botellon?")) {
            
                    MenuDOU.DepocitarBotellon();  
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.setVisible(false);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
        }
    }else if ("En espera de botellon".equals(buttonText)) {
        
    }

    actualizarEstadoBotones();
}
    

    private void handleVolverAction() {
        HomeStudentGUI hsgui = new HomeStudentGUI();
        HomeCTRL homeCTRL = new HomeCTRL(hsgui);
        hsgui.setVisible(true);
        menuGUI.setVisible(false);
        menuGUI.dispose();
    }
    
        /**
     * Método que muestra un diálogo de confirmación y retorna true si el usuario selecciona "Sí".
     */
    private boolean mostrarDialogoConfirmacion(String mensaje) {
        int opcion = JOptionPane.showConfirmDialog(
            menuGUI,                           // Componente padre
            mensaje,                           // Mensaje a mostrar
            "Confirmación",                    // Título del cuadro de diálogo
            JOptionPane.YES_NO_OPTION,         // Botones "Sí" y "No"
            JOptionPane.QUESTION_MESSAGE       // Icono de pregunta
        );
        return opcion == JOptionPane.YES_OPTION; // Retorna true si el usuario selecciona "Sí"
    }

}  

