
package Controler.HomeCTRL;

// Clase controlado del Home

import Controler.MenuCTRL.MenuCTRL;
import Model.MenuDOU.MenuDOU;
import View.HomeStudentGUI;
import Model.RegistroMatricula.HomeDOU;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import View.MenuGUI;
import java.util.Map;
import javax.swing.JOptionPane;
import Model.EstudianteModel.EstudianteModel;


public class HomeCTRL implements ActionListener{
    // Instanciar la clase
    
    HomeStudentGUI vistaHome = new HomeStudentGUI();
    HomeDOU homeDOU = new HomeDOU();
    MenuDOU mdou = new MenuDOU();
    
    MenuGUI menuGUI = new MenuGUI();

    private final JTextField matricula;
    

    public HomeCTRL( HomeStudentGUI v ) {
        this.vistaHome = v;
        //inicilizar los btns
        this.vistaHome.btn0.addActionListener(this);
        this.vistaHome.btn1.addActionListener(this);
        this.vistaHome.btn2.addActionListener(this);
        this.vistaHome.btn3.addActionListener(this);
        this.vistaHome.btn4.addActionListener(this);
        this.vistaHome.btn5.addActionListener(this);
        this.vistaHome.btn6.addActionListener(this);
        this.vistaHome.btn7.addActionListener(this);
        this.vistaHome.btn8.addActionListener(this);
        this.vistaHome.btn9.addActionListener(this);
        this.vistaHome.btnEntrar.addActionListener(this);
        this.vistaHome.btnEliminar.addActionListener(this);
        
        //campon txtMatricula
        this.matricula = this.vistaHome.txtMatricula;
        System.out.println("Botones cargados");
    }
  
    @Override
public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();

    // Mapa para asociar botones de números con sus valores
    Map<Object, String> buttonToDigitMap = Map.of(
        vistaHome.btn0, "0",
        vistaHome.btn1, "1",
        vistaHome.btn2, "2",
        vistaHome.btn3, "3",
        vistaHome.btn4, "4",
        vistaHome.btn5, "5",
        vistaHome.btn6, "6",
        vistaHome.btn7, "7",
        vistaHome.btn8, "8",
        vistaHome.btn9, "9"
    );

    if (buttonToDigitMap.containsKey(source)) {
        agregarDigito(buttonToDigitMap.get(source));
    } else if (source == vistaHome.btnEntrar) {
        validarYEntrar();
    } else if (source == vistaHome.btnEliminar) {
        eliminarUltimoDigito();
    }
}

// Método para agregar un dígito a la matrícula si no supera el límite de 8 caracteres
private void agregarDigito(String digito) {
    if (matricula.getText().length() < 8) {
        matricula.setText(matricula.getText() + digito);
    }
}

// Método para validar la matrícula y proceder al menú si es válida
private void validarYEntrar() {
    String textoMatricula = matricula.getText();

    if (textoMatricula.isEmpty()) {
        JOptionPane.showMessageDialog(vistaHome, "La matrícula no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int mat = Integer.parseInt(textoMatricula); // Convertir a entero
        boolean validarMatricula = HomeDOU.validarMatricula(mat);

        if (validarMatricula) {
            // Abrir pantalla del menú
            // set mtricula en la clase estudiante 
            menuGUI.setVisible(true);
            new MenuCTRL(menuGUI); // Crear el controlador del menú
            vistaHome.dispose();   // Cerrar la pantalla actual
        } else {
            JOptionPane.showMessageDialog(vistaHome, "Matrícula inválida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(vistaHome, "La matrícula debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException | FileNotFoundException ex) {
        Logger.getLogger(HomeCTRL.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(vistaHome, "Error al validar la matrícula: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Método para eliminar el último dígito de la matrícula
private void eliminarUltimoDigito() {
    String txt = matricula.getText();
    if (!txt.isEmpty()) {
        matricula.setText(txt.substring(0, txt.length() - 1));
    }
}

     
    
}
