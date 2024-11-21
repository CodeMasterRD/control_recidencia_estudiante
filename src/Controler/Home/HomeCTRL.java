
package Controler.Home;

// Clase controlado del Home

import View.HomeStudentGUI;
import Model.RegistroMatricula.HomeDOU;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeCTRL implements ActionListener{
    // Instanciar la clase
    
    HomeStudentGUI vistaHome = new HomeStudentGUI();
    HomeDOU homeDOU = new HomeDOU();
    

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
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
    
}
