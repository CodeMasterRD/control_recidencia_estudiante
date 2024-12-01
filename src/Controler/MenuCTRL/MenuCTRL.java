
package Controler.MenuCTRL;
// Clase cotroladora del menu

import Controler.HomeCTRL.HomeCTRL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.MenuDOU.MenuDOU;
import Model.RegistroMatricula.HomeDOU;
import View.MenuGUI;
import java.io.FileNotFoundException;
import View.HomeStudentGUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.EstudianteModel.EstudianteModel;
import Model.Notificaciones.NotificacionesDOU;
import Model.notificacion.NotificacionModel;




public class MenuCTRL implements ActionListener{
    
    MenuGUI menuGUI = new MenuGUI();
    MenuDOU mdou = new MenuDOU();
    HomeDOU homeDOU = new  HomeDOU();
    EstudianteModel estudianteModel = new EstudianteModel();
    NotificacionesDOU ndou = new NotificacionesDOU();
    
    
    
    

    
    public MenuCTRL(MenuGUI m) throws FileNotFoundException {
        
        // inicilizamos los eventos del la clase MenuGUI
        this.menuGUI = m;
        
        this.menuGUI.btnEntradaSalida.addActionListener(this);

        this.menuGUI.btnRegistrarUsoCocina.addActionListener(this);
        this.menuGUI.btnFinalizarUsoCocina.addActionListener(this);
        this.menuGUI.btnDepositarbotellon.addActionListener(this);
        this.menuGUI.btnSolicitarBotellon.addActionListener(this);
        this.menuGUI.btnVolver.addActionListener(this);

        // Establecemos el estado inicial de los botones según el estado del estudiante
        
        
        NotificacionesDOU.getEstadoNotificacio();
        actualizarEstadoBotones();
        m.jbNombre.setText(EstudianteModel.getNombre() +" "+ EstudianteModel.getApellido());
        
        
    }
    
     // Método que actualiza la visibilidad y el texto de los botones según el estado del estudiante
    private void actualizarEstadoBotones() throws FileNotFoundException {
        
        String estadoEstidiante = EstudianteModel.getEstado();
        String estadoNotificacion = NotificacionModel.getEstado_notificaciones();
        System.out.println("Estado En actualizar 1 " + estadoEstidiante );
        System.out.println("Notificacion En actualizar 2" + estadoNotificacion);

        if ("Dentro".equals(estadoEstidiante) && "Pendiente".equals(estadoNotificacion)) {
            System.out.println("Estado En actualizar " + EstudianteModel.getEstado() );
            this.menuGUI.btnEntradaSalida.setVisible(true);
            this.menuGUI.btnEntradaSalida.setText("Registrar salida");

            // Mostrar botones de cocina y botellón solo si está dentro
            this.menuGUI.btnRegistrarUsoCocina.setVisible(true);
            
            this.menuGUI.btnSolicitarBotellon.setVisible(true);
            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);   
            this.menuGUI.btnSolicitarBotellon.setText("En espera de botellon");
            this.menuGUI.btnDepositarbotellon.setVisible(false);
            
            
        }else if ("Dentro".equals(estadoEstidiante)) {

            this.menuGUI.btnEntradaSalida.setVisible(true);
            this.menuGUI.btnEntradaSalida.setText("Registrar salida");

            // Mostrar botones de cocina y botellón solo si está dentro
            this.menuGUI.btnRegistrarUsoCocina.setVisible(true);
            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
            this.menuGUI.btnSolicitarBotellon.setVisible(true);
            this.menuGUI.btnDepositarbotellon.setVisible(false);
        }  else if ("Fuera".equals(estadoEstidiante) ) {
            
            this.menuGUI.btnEntradaSalida.setVisible(true);
            this.menuGUI.btnEntradaSalida.setText("Registrar entrada");

            // Ocultar botones de cocina y botellón si está fuera
            this.menuGUI.btnSolicitarBotellon.setVisible(false);
            this.menuGUI.btnRegistrarUsoCocina.setVisible(false);
            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
            this.menuGUI.btnDepositarbotellon.setVisible(false);
            
        } else if ("En cocina".equals(estadoEstidiante) ) {
            this.menuGUI.btnEntradaSalida.setVisible(false); // Ocultar entrada/salida mientras está en cocina
            // Mostrar solo el botón para finalizar 
            this.menuGUI.btnRegistrarUsoCocina.setVisible(false);
            this.menuGUI.btnFinalizarUsoCocina.setVisible(true);
            this.menuGUI.btnSolicitarBotellon.setVisible(false);
            this.menuGUI.btnDepositarbotellon.setVisible(false);
        }else{
            System.out.println("no entro a ningun btn");
        }
//        else if ("Pendiente".equals(NotificacionesDOU.getEstado_notificaciones())){
//            this.menuGUI.btnEntradaSalida.setVisible(false); // Ocultar entrada/salida mientras está en cocina
//            // Mostrar solo el botón para finalizar 
//            this.menuGUI.btnRegistrarUsoCocina.setVisible(false);
//            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
//            this.menuGUI.btnSolicitarBotellon_DepositarBotello.setVisible(false);
//            
//        }
    }
 
    @Override
public void actionPerformed(ActionEvent e) {
    try {
        Object source = e.getSource();
        System.out.println("---Aciton---");

        if (source == menuGUI.btnEntradaSalida) {
            System.out.println("Click en entrada y salida");
            handleEntradaSalidaAction();
        } else if (source == menuGUI.btnRegistrarUsoCocina) {
            System.out.println("Click Registra uso cocina");
            handleRegistrarCocinaAction();
        } else if (source == menuGUI.btnFinalizarUsoCocina) {
            System.out.println("finalizar uso cocina");
            handleFinalizarUsoCocinaAction();
        } else if (source == menuGUI.btnDepositarbotellon) {
            System.out.println("Click depositar");
            handleDepositarBotellon();
            
            
        } else if (source == menuGUI.btnSolicitarBotellon) {
            System.out.println("CLick solicitar ");
            handleSolicitarBotellon();
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
                    actualizarEstadoBotones();
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.setVisible(false);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
                    
        }
    } else if ("Registrar salida".equals(buttonText)) {
        if (mostrarDialogoConfirmacion("¿Deseas registrar la salida?")) {
            
                    MenuDOU.registrarSalida();  
                    actualizarEstadoBotones();
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.setVisible(false);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
        }
    }

   // actualizarEstadoBotones();
}

    private void handleRegistrarCocinaAction()throws FileNotFoundException {
        String buttonText = menuGUI.btnRegistrarUsoCocina.getText();

        if ("Solicitar uso cocina".equals(buttonText)) {
            if (mostrarDialogoConfirmacion("¿Deseas solicitar el uso de la cocina?")) {
                    MenuDOU.registrarUsoCocina();
                     actualizarEstadoBotones();
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.setVisible(false);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
            }
        }

       // actualizarEstadoBotones();
    } 
    
    private void handleFinalizarUsoCocinaAction()throws FileNotFoundException {
        String buttonText = menuGUI.btnFinalizarUsoCocina.getText();

        if ("Finalizar uso cocina".equals(buttonText)) {
           if (mostrarDialogoConfirmacion("¿Deseas finalizar el uso de la cocina?")) {
                System.out.println("llamando a finalizar uso cocina");
                    MenuDOU.finalizaUsoCocina();
                     actualizarEstadoBotones();
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.setVisible(false);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
        }
        }

       // actualizarEstadoBotones();
    } 
    
    
    private void handleSolicitarBotellon() throws FileNotFoundException {
    String buttonText = menuGUI.btnSolicitarBotellon.getText();

    if ("Solicitar botellon".equals(buttonText)) {
         if (mostrarDialogoConfirmacion("¿Deseas solicitar un botellon?")) {
            
                    MenuDOU.SolicitarBotellon();
                    actualizarEstadoBotones();
                    HomeStudentGUI hsgui = new HomeStudentGUI();
                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                    menuGUI.setVisible(false);
                    menuGUI.dispose();
                    hsgui.setVisible(true);
        }
    }

  
}
    private void handleDepositarBotellon() throws FileNotFoundException {
        String buttonText = menuGUI.btnDepositarbotellon.getText();
        if ("Depositar botellon".equals(buttonText)) {
            if (mostrarDialogoConfirmacion("¿Deseas depositar botellon?")) {

                        MenuDOU.DepocitarBotellon();  
                        actualizarEstadoBotones();
                        HomeStudentGUI hsgui = new HomeStudentGUI();
                        HomeCTRL homeCTRL = new HomeCTRL(hsgui);
                        menuGUI.setVisible(false);
                        menuGUI.dispose();
                        hsgui.setVisible(true);
            }
        }
  
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

