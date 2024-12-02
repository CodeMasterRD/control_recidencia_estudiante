
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
import Model.Notificaciones.NotificacionModel;
import Model.Asignacionbotellon.AsignacionBotellonModel;
import Model.Asignacionbotellon.AsingnacionBotellonDOU;



public class MenuCTRL implements ActionListener{
    
    MenuGUI menuGUI = new MenuGUI();
    MenuDOU mdou = new MenuDOU();
    HomeDOU homeDOU = new  HomeDOU();
    

    
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
        
        
        AsingnacionBotellonDOU.getEstadoBotellon();
        NotificacionesDOU.getEstadoNotificacio();
        actualizarEstadoBotones();
        
        m.jbNombre.setText(EstudianteModel.getNombre() +" "+ EstudianteModel.getApellido());
        // System.out.println("Estado Botellon " + AsignacionBotellonModel.getEstadoBotellon() );
        
        
    }
    
//     // Método que actualiza la visibilidad y el texto de los botones según el estado del estudiante
//    private void actualizarEstadoBotones() throws FileNotFoundException {
//        
//        String estadoEstidiante = EstudianteModel.getEstado();
//        String estadoNotificacion = NotificacionModel.getEstado_notificaciones();
//        String tipoNotificacion = NotificacionModel.getTipo_noteficacion();
//        String estadoBotellon = AsignacionBotellonModel.getEstadoBotellon();
//        
//        System.out.println("Estado En actualizar  " + estadoEstidiante );
//        System.out.println("Notificacion En actualizar " + estadoNotificacion);
//        System.out.println("Estado botellon " + estadoBotellon);
//        System.out.println("Tipo notificacion " + tipoNotificacion);
//        
//        if ("En cocina".equals(estadoEstidiante) ) {
//            this.menuGUI.btnEntradaSalida.setVisible(false); // Ocultar entrada/salida mientras está en cocina
//            // Mostrar solo el botón para finalizar 
//            this.menuGUI.btnRegistrarUsoCocina.setVisible(false);
//            this.menuGUI.btnFinalizarUsoCocina.setVisible(true);
//            this.menuGUI.btnSolicitarBotellon.setVisible(false);
//            this.menuGUI.btnDepositarbotellon.setVisible(false);
//        }
//        //&& "en uso".equals(estadoBotellon) ) || (("Dentro".equals(estadoEstidiante) && "depositado".equals(estadoBotellon)) )
//        else if ("en uso".equals(estadoBotellon) && "Dentro".equals(estadoEstidiante)) {
//
//            this.menuGUI.btnEntradaSalida.setVisible(true);
//            this.menuGUI.btnEntradaSalida.setText("Registrar salida");
//
//            // Mostrar botones de cocina y botellón solo si está dentro
//            this.menuGUI.btnRegistrarUsoCocina.setVisible(true);
//            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
//            this.menuGUI.btnSolicitarBotellon.setVisible(false);
//            this.menuGUI.btnDepositarbotellon.setVisible(true);
//        } if ("Dentro".equals(estadoEstidiante) && "Pendiente".equals(estadoNotificacion)) {
//            System.out.println("Estado En actualizar " + EstudianteModel.getEstado() );
//            this.menuGUI.btnEntradaSalida.setVisible(true);
//            this.menuGUI.btnEntradaSalida.setText("Registrar salida");
//
//            // Mostrar botones de cocina y botellón solo si está dentro
//            this.menuGUI.btnRegistrarUsoCocina.setVisible(true);
//            
//            this.menuGUI.btnSolicitarBotellon.setVisible(false);
//            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);   
//            this.menuGUI.btnSolicitarBotellon.setText("En espara de confirmacion");
//            this.menuGUI.btnDepositarbotellon.setVisible(false);
//            
//            
//        }
//        
//        else if ("Dentro".equals(estadoEstidiante) && "Solicitar botellon".equals(tipoNotificacion)) {
//
//            this.menuGUI.btnEntradaSalida.setVisible(true);
//            this.menuGUI.btnEntradaSalida.setText("Registrar salida");
//            // Mostrar botones de cocina y botellón solo si está dentro
//            this.menuGUI.btnRegistrarUsoCocina.setVisible(true);
//            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
//            this.menuGUI.btnSolicitarBotellon.setVisible(true);
//            this.menuGUI.btnSolicitarBotellon.setText("En espera de confirmacion botellon");
//            this.menuGUI.btnDepositarbotellon.setVisible(false);
//        } else if ("Depositar botellon".equals(tipoNotificacion) && "Dentro".equals(estadoEstidiante) ) {
//
//            this.menuGUI.btnEntradaSalida.setVisible(true);
//            this.menuGUI.btnEntradaSalida.setText("Registrar salida");
//
//            // Mostrar botones de cocina y botellón solo si está dentro
//            this.menuGUI.btnRegistrarUsoCocina.setVisible(true);
//            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
//            this.menuGUI.btnSolicitarBotellon.setVisible(true);
//            this.menuGUI.btnSolicitarBotellon.setText("En espera de confirmacion");
//            this.menuGUI.btnDepositarbotellon.setVisible(false);
//        } 
//        
//        else if ("Fuera".equals(estadoEstidiante) ) {
//            
//            this.menuGUI.btnEntradaSalida.setVisible(true);
//            this.menuGUI.btnEntradaSalida.setText("Registrar entrada");
//
//            // Ocultar botones de cocina y botellón si está fuera
//            this.menuGUI.btnSolicitarBotellon.setVisible(false);
//            this.menuGUI.btnRegistrarUsoCocina.setVisible(false);
//            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
//            this.menuGUI.btnDepositarbotellon.setVisible(false);
//            
//        }else if ("Dentro".equals(estadoEstidiante)) {
//
//            this.menuGUI.btnEntradaSalida.setVisible(true);
//            this.menuGUI.btnEntradaSalida.setText("Registrar salida");
//
//            // Mostrar botones de cocina y botellón solo si está dentro
//            this.menuGUI.btnRegistrarUsoCocina.setVisible(true);
//            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
//            this.menuGUI.btnSolicitarBotellon.setVisible(true);
//            this.menuGUI.btnDepositarbotellon.setVisible(false);
//        }  
//        else{
//            System.out.println("no entro a ningun btn");
//        }
////        else if ("Pendiente".equals(NotificacionesDOU.getEstado_notificaciones())){
////            this.menuGUI.btnEntradaSalida.setVisible(false); // Ocultar entrada/salida mientras está en cocina
////            // Mostrar solo el botón para finalizar 
////            this.menuGUI.btnRegistrarUsoCocina.setVisible(false);
////            this.menuGUI.btnFinalizarUsoCocina.setVisible(false);
////            this.menuGUI.btnSolicitarBotellon_DepositarBotello.setVisible(false);
////            
////        }
//    }
    
    private void actualizarEstadoBotones() throws FileNotFoundException {
        
    String estadoEstudiante = EstudianteModel.getEstado();
    String  estadoNotificacion = NotificacionModel.getEstado_notificaciones();
    String  tipoNotificacion = NotificacionModel.getTipo_noteficacion();
    String estadoBotellon = AsignacionBotellonModel.getEstadoBotellon();

    System.out.println("Estado estudiante: " + estadoEstudiante);
    System.out.println("Estado notificación: " + estadoNotificacion );
    System.out.println("Tipo notificación: " + tipoNotificacion);
    System.out.println("Estado botellón: " + estadoBotellon);

    switch (estadoEstudiante) {
        case "Fuera":
            configurarBotones(true, false, false, false, false, "Registrar entrada", "");
            break;

        case "Dentro":
             if ("Pendiente".equals(estadoNotificacion) && "Depositar botellon".equals(tipoNotificacion)) {
                configurarBotones(true, true, false, true, false, "Solicitar salida", "Confimando botellon vacio");
            }else if ("en uso".equals(estadoBotellon)) {
                configurarBotones(true, true, false, false, true, "Solicitar salida", "");
            } 
            else if ("Aceptada".equals(estadoNotificacion) && "Depositar botellon".equals(tipoNotificacion)) {
                configurarBotones(true, true, false, true, false, "Solicitar salida", "Solicitar botellon");
            }else if ("Pendiente".equals(estadoNotificacion)) {
                configurarBotones(true, true, false, true, false, "Solicitar salida", "En espera de un botellón");
            }
            else {
                configurarBotones(true, true, false, true, false, "Solicitar salida", "Solicitar botellon");
            }
            break;

        case "En cocina":
            configurarBotones(false, false, true, false, false, "Finalizar uso cocina", "");
            break;

        default:
            System.out.println("Estado inválido.");
            break;
    }
}

private void configurarBotones(
    boolean entradaSalidaVisible, boolean registrarUsoCocinaVisible,
    boolean finalizarUsoCocinaVisible, boolean solicitarBotellonVisible, boolean depositarBotellonVisible,
    String textoEntradaSalida, String textoSolicitarBotellon
) {
    // Configura la visibilidad de los botones
    this.menuGUI.btnEntradaSalida.setVisible(entradaSalidaVisible);
    this.menuGUI.btnEntradaSalida.setText(textoEntradaSalida);

    this.menuGUI.btnRegistrarUsoCocina.setVisible(registrarUsoCocinaVisible);
    this.menuGUI.btnFinalizarUsoCocina.setVisible(finalizarUsoCocinaVisible);

    this.menuGUI.btnSolicitarBotellon.setVisible(solicitarBotellonVisible);
    this.menuGUI.btnSolicitarBotellon.setText(textoSolicitarBotellon);

    this.menuGUI.btnDepositarbotellon.setVisible(depositarBotellonVisible);
}


@Override
public void actionPerformed(ActionEvent e) {
    try {
        Object source = e.getSource();
        System.out.println("---Action---");

        if (source == menuGUI.btnEntradaSalida) {
            System.out.println("entro");
            handleEntradaSalidaAction();
        } else if (source == menuGUI.btnRegistrarUsoCocina) {
            handleRegistrarCocinaAction();
        } else if (source == menuGUI.btnFinalizarUsoCocina) {
            handleFinalizarUsoCocinaAction();
        } else if (source == menuGUI.btnSolicitarBotellon) {
            System.out.println("Entro");
            handleSolicitarBotellonAction();
        } else if (source == menuGUI.btnDepositarbotellon) {
            handleDepositarBotellonAction();
        } else if (source == menuGUI.btnVolver) {
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
            cambiarVista();
        }
    } else if ("Solicitar salida".equals(buttonText)) {
        if (mostrarDialogoConfirmacion("¿Deseas registrar la salida?")) {
            MenuDOU.registrarSalida();
            cambiarVista();
        }
    }
}

private void handleRegistrarCocinaAction() throws FileNotFoundException {
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

private void handleFinalizarUsoCocinaAction() throws FileNotFoundException {
    if (mostrarDialogoConfirmacion("¿Deseas finalizar el uso de la cocina?")) {
        MenuDOU.finalizaUsoCocina();
        actualizarEstadoBotones();
        
        HomeStudentGUI hsgui = new HomeStudentGUI();
        HomeCTRL homeCTRL = new HomeCTRL(hsgui);
        menuGUI.setVisible(false);
        menuGUI.dispose();
        hsgui.setVisible(true);
    }
}

private void handleSolicitarBotellonAction() throws FileNotFoundException {
    String buttonText = menuGUI.btnSolicitarBotellon.getText();
    
    if ("Solicitar botellon".equals(buttonText)) {
        if (mostrarDialogoConfirmacion("¿Deseas solicitar un botellón?")) {
            MenuDOU.SolicitarBotellon();
            actualizarEstadoBotones();
            HomeStudentGUI hsgui = new HomeStudentGUI();
            HomeCTRL homeCTRL = new HomeCTRL(hsgui);
            menuGUI.setVisible(false);
            menuGUI.dispose();
            hsgui.setVisible(true);
        }
    } else if ("En espera de un botellón".equals(buttonText)) {
        JOptionPane.showMessageDialog(menuGUI, "Solicitud en espera. Por favor, espere confirmación.");
    }
}

private void handleDepositarBotellonAction() throws FileNotFoundException {
    String buttonText = menuGUI.btnSolicitarBotellon.getText();
    if (mostrarDialogoConfirmacion("¿Deseas depositar el botellón?")) {
       
        MenuDOU.DepositarBotellon();
        actualizarEstadoBotones();
         HomeStudentGUI hsgui = new HomeStudentGUI();
        HomeCTRL homeCTRL = new HomeCTRL(hsgui);
        menuGUI.setVisible(false);
        menuGUI.dispose();
        hsgui.setVisible(true);
    }
    else if ("Confimando botellon vacio".equals(buttonText)) {
        JOptionPane.showMessageDialog(menuGUI, "Solicitud en espera. Por favor, espere confirmación.");
    }
}

private void handleVolverAction() {
    cambiarVista();
}

//Método Reutilizable para Cambiar de Vista:

private void cambiarVista() {
    HomeStudentGUI hsgui = new HomeStudentGUI();
    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
    hsgui.setVisible(true);
    menuGUI.setVisible(false);
    menuGUI.dispose();
}


 // Muestra un cuadro de diálogo de confirmación y retorna `true` si el usuario selecciona "Sí".
 
private boolean mostrarDialogoConfirmacion(String mensaje) {
    int opcion = JOptionPane.showConfirmDialog(
        menuGUI,                           // Componente padre
        mensaje,                           // Mensaje a mostrar
        "Confirmación",                    // Título del cuadro de diálogo
        JOptionPane.YES_NO_OPTION,         // Botones "Sí" y "No"
        JOptionPane.QUESTION_MESSAGE       // Icono de pregunta
    );
    return opcion == JOptionPane.YES_OPTION; // Retorna true si el usuario selecciona "Sí".
}



    
 
//    @Override
//public void actionPerformed(ActionEvent e) {
//    try {
//        Object source = e.getSource();
//        System.out.println("---Aciton---");
//
//        if (source == menuGUI.btnEntradaSalida) {
//            System.out.println("Click en entrada y salida");
//            handleEntradaSalidaAction();
//        } else if (source == menuGUI.btnRegistrarUsoCocina) {
//            System.out.println("Click Registra uso cocina");
//            handleRegistrarCocinaAction();
//        } else if (source == menuGUI.btnFinalizarUsoCocina) {
//            System.out.println("finalizar uso cocina");
//            handleFinalizarUsoCocinaAction();
//        } else if (source == menuGUI.btnDepositarbotellon) {
//            System.out.println("Click depositar");
//            handleDepositarBotellon();
//            
//            
//        } else if (source == menuGUI.btnSolicitarBotellon) {
//            System.out.println("CLick solicitar ");
//            handleSolicitarBotellon();
//        }else if (source == menuGUI.btnVolver) {
//            handleVolverAction();
//        }
//    } catch (FileNotFoundException ex) {
//        Logger.getLogger(MenuCTRL.class.getName()).log(Level.SEVERE, "Error al manejar la acción", ex);
//        JOptionPane.showMessageDialog(menuGUI, "Error al realizar la operación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//    }
//}
//
//private void handleEntradaSalidaAction() throws FileNotFoundException {
//    String buttonText = menuGUI.btnEntradaSalida.getText();
//
//    if ("Registrar entrada".equals(buttonText)) {
//         if (mostrarDialogoConfirmacion("¿Deseas registrar la entrada?")) {
//            
//                    MenuDOU.registrarEntrada();
//                    actualizarEstadoBotones();
//                    HomeStudentGUI hsgui = new HomeStudentGUI();
//                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
//                    menuGUI.setVisible(false);
//                    menuGUI.dispose();
//                    hsgui.setVisible(true);
//                    
//        }
//    } else if ("Registrar salida".equals(buttonText)) {
//        if (mostrarDialogoConfirmacion("¿Deseas registrar la salida?")) {
//            
//                    MenuDOU.registrarSalida();  
//                    actualizarEstadoBotones();
//                    HomeStudentGUI hsgui = new HomeStudentGUI();
//                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
//                    menuGUI.setVisible(false);
//                    menuGUI.dispose();
//                    hsgui.setVisible(true);
//        }
//    }
//
//   // actualizarEstadoBotones();
//}
//
//    private void handleRegistrarCocinaAction()throws FileNotFoundException {
//        String buttonText = menuGUI.btnRegistrarUsoCocina.getText();
//
//        if ("Solicitar uso cocina".equals(buttonText)) {
//            if (mostrarDialogoConfirmacion("¿Deseas solicitar el uso de la cocina?")) {
//                    MenuDOU.registrarUsoCocina();
//                     actualizarEstadoBotones();
//                    HomeStudentGUI hsgui = new HomeStudentGUI();
//                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
//                    menuGUI.setVisible(false);
//                    menuGUI.dispose();
//                    hsgui.setVisible(true);
//            }
//        }
//
//       // actualizarEstadoBotones();
//    } 
//    
//    private void handleFinalizarUsoCocinaAction()throws FileNotFoundException {
//        String buttonText = menuGUI.btnFinalizarUsoCocina.getText();
//
//        if ("Finalizar uso cocina".equals(buttonText)) {
//           if (mostrarDialogoConfirmacion("¿Deseas finalizar el uso de la cocina?")) {
//                System.out.println("llamando a finalizar uso cocina");
//                    MenuDOU.finalizaUsoCocina();
//                    actualizarEstadoBotones();
//                    HomeStudentGUI hsgui = new HomeStudentGUI();
//                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
//                    menuGUI.setVisible(false);
//                    menuGUI.dispose();
//                    hsgui.setVisible(true);
//        }
//        }
//
//       // actualizarEstadoBotones();
//    } 
//    
//    
//    private void handleSolicitarBotellon() throws FileNotFoundException {
//    String buttonText = menuGUI.btnSolicitarBotellon.getText();
//
//    if ("Solicitar botellon".equals(buttonText)) {
//         if (mostrarDialogoConfirmacion("¿Deseas solicitar un botellon?")) {
//            
//                    MenuDOU.SolicitarBotellon();
//                    actualizarEstadoBotones();
//                    HomeStudentGUI hsgui = new HomeStudentGUI();
//                    HomeCTRL homeCTRL = new HomeCTRL(hsgui);
//                    menuGUI.setVisible(false);
//                    menuGUI.dispose();
//                    hsgui.setVisible(true);
//        }
//    }
//
//  
//}
//    private void handleDepositarBotellon() throws FileNotFoundException {
//        String buttonText = menuGUI.btnDepositarbotellon.getText();
//        if ("Depositar botellon".equals(buttonText)) {
//            if (mostrarDialogoConfirmacion("¿Deseas depositar botellon?")) {
//
//                        MenuDOU.DepocitarBotellon();  
//                        actualizarEstadoBotones();
//                        HomeStudentGUI hsgui = new HomeStudentGUI();
//                        HomeCTRL homeCTRL = new HomeCTRL(hsgui);
//                        menuGUI.setVisible(false);
//                        menuGUI.dispose();
//                        hsgui.setVisible(true);
//            }
//        }
//  
//}
//
//    private void handleVolverAction() {
//        HomeStudentGUI hsgui = new HomeStudentGUI();
//        HomeCTRL homeCTRL = new HomeCTRL(hsgui);
//        hsgui.setVisible(true);
//        menuGUI.setVisible(false);
//        menuGUI.dispose();
//    }
//    
//        /**
//     * Método que muestra un diálogo de confirmación y retorna true si el usuario selecciona "Sí".
//     */
//    private boolean mostrarDialogoConfirmacion(String mensaje) {
//        int opcion = JOptionPane.showConfirmDialog(
//            menuGUI,                           // Componente padre
//            mensaje,                           // Mensaje a mostrar
//            "Confirmación",                    // Título del cuadro de diálogo
//            JOptionPane.YES_NO_OPTION,         // Botones "Sí" y "No"
//            JOptionPane.QUESTION_MESSAGE       // Icono de pregunta
//        );
//        return opcion == JOptionPane.YES_OPTION; // Retorna true si el usuario selecciona "Sí"
//    }

}  

