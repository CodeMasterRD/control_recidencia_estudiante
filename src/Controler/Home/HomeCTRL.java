
package Controler.Home;

// Clase controlado del Home

import View.HomeStudentGUI;
import Model.RegistroMatricula.HomeDOU;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class HomeCTRL implements ActionListener{
    // Instanciar la clase
    
    HomeStudentGUI vistaHome = new HomeStudentGUI();
    HomeDOU homeDOU = new HomeDOU();
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
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaHome.btn0) {
            if (!(matricula.getText().length() >= 8)) {                   
                    matricula.setText( matricula.getText() + "0");
                }           
        }else if (e.getSource() == this.vistaHome.btn1) {
            if (!(matricula.getText().length() >= 8)) {
                    matricula.setText( matricula.getText() + "1");
                }
        }else if (e.getSource() == this.vistaHome.btn2) {
            if (!(matricula.getText().length() >= 8)) {
                    matricula.setText( matricula.getText() + "2");
                }
        }else if (e.getSource() == this.vistaHome.btn3) {
            if (!(matricula.getText().length() >= 8)) {
                    matricula.setText( matricula.getText() + "3");
                }
        }else if (e.getSource() == this.vistaHome.btn4) {
            if (!(matricula.getText().length() >= 8)) {
                    matricula.setText( matricula.getText() + "4");
                }
        }else if (e.getSource() == this.vistaHome.btn5) {
            if (!(matricula.getText().length() >= 8)) {
                    matricula.setText( matricula.getText() + "5");
                }
        }else if (e.getSource() == this.vistaHome.btn6) {
            if (!(matricula.getText().length() >= 8)) {
                    matricula.setText( matricula.getText() + "6");
                }
        }else if (e.getSource() == this.vistaHome.btn7) {
            if (!(matricula.getText().length() >= 8)) {
                    matricula.setText( matricula.getText() + "7");
                };
        }else if (e.getSource() == this.vistaHome.btn8) {
            if (!(matricula.getText().length() >= 8)) {
                    matricula.setText( matricula.getText() + "8");
                }
        }else if (e.getSource() == this.vistaHome.btn9) {
            if (!(matricula.getText().length() >= 8)) {
                    matricula.setText( matricula.getText() + "9");
                }
        }else if (e.getSource() == this.vistaHome.btnEntrar) {
            int mat = Integer.parseInt(matricula.getText()); 
            System.out.println("cobertido a int");
            try {
                boolean validarMatricula = HomeDOU.validarMatricula(mat);
                if (validarMatricula) {
                    //Llamar A la pantalla Menu
                    System.out.println("llamando a Menu.");
                }
            } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(HomeCTRL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if (e.getSource() == this.vistaHome.btnEliminar) {
            String txt = matricula.getText();
            if (!txt.isEmpty()) {
                matricula.setText(txt.substring(0, txt.length() - 1));
            } 
        }
        
        
        
    }
    
    
    
    
}
