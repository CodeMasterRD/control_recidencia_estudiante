
package View;

import javax.swing.JButton;
import javax.swing.JLabel;


public class MenuGUI extends javax.swing.JFrame {

  
    public MenuGUI() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenedor = new javax.swing.JPanel();
        btnRegistrarUsoCocina = new javax.swing.JButton();
        btnEntradaSalida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnDepositarbotellon = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnFinalizarUsoCocina = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbNombre = new javax.swing.JLabel();
        btnSolicitarBotellon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jpContenedor.setBackground(new java.awt.Color(0, 117, 250));
        jpContenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrarUsoCocina.setBackground(new java.awt.Color(45, 45, 45));
        btnRegistrarUsoCocina.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnRegistrarUsoCocina.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarUsoCocina.setText("Solicitar uso cocina");
        btnRegistrarUsoCocina.setBorder(null);
        btnRegistrarUsoCocina.setBorderPainted(false);
        btnRegistrarUsoCocina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarUsoCocina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsoCocinaActionPerformed(evt);
            }
        });
        jpContenedor.add(btnRegistrarUsoCocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 340, 70));

        btnEntradaSalida.setBackground(new java.awt.Color(45, 45, 45));
        btnEntradaSalida.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnEntradaSalida.setForeground(new java.awt.Color(255, 255, 255));
        btnEntradaSalida.setText("Registra entrada");
        btnEntradaSalida.setBorder(null);
        btnEntradaSalida.setBorderPainted(false);
        btnEntradaSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntradaSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaSalidaActionPerformed(evt);
            }
        });
        jpContenedor.add(btnEntradaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 340, 70));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleciona una operacion");
        jpContenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 280, -1));

        btnDepositarbotellon.setBackground(new java.awt.Color(45, 45, 45));
        btnDepositarbotellon.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnDepositarbotellon.setForeground(new java.awt.Color(255, 255, 255));
        btnDepositarbotellon.setText("Depositar botellon");
        btnDepositarbotellon.setBorder(null);
        btnDepositarbotellon.setBorderPainted(false);
        btnDepositarbotellon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpContenedor.add(btnDepositarbotellon, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 340, 70));

        btnVolver.setBackground(new java.awt.Color(250, 76, 76));
        btnVolver.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        jpContenedor.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 110, 40));

        btnFinalizarUsoCocina.setBackground(new java.awt.Color(45, 45, 45));
        btnFinalizarUsoCocina.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnFinalizarUsoCocina.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarUsoCocina.setText("Finalizar uso cocina");
        btnFinalizarUsoCocina.setBorder(null);
        btnFinalizarUsoCocina.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jpContenedor.add(btnFinalizarUsoCocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 340, 70));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hola!");
        jpContenedor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 50, 30));

        jbNombre.setBackground(new java.awt.Color(255, 255, 255));
        jbNombre.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jbNombre.setForeground(new java.awt.Color(255, 255, 255));
        jpContenedor.add(jbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 270, 30));

        btnSolicitarBotellon.setBackground(new java.awt.Color(45, 45, 45));
        btnSolicitarBotellon.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnSolicitarBotellon.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitarBotellon.setText("Solicitar botellon");
        btnSolicitarBotellon.setBorder(null);
        btnSolicitarBotellon.setBorderPainted(false);
        btnSolicitarBotellon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpContenedor.add(btnSolicitarBotellon, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 340, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarUsoCocinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsoCocinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarUsoCocinaActionPerformed

    public JButton getBtnEntradaSalida() {
        return btnEntradaSalida;
    }

    public void setBtnEntradaSalida(JButton btnEntradaSalida) {
        this.btnEntradaSalida = btnEntradaSalida;
    }

    public JButton getBtnFinalizarUsoCocina() {
        return btnFinalizarUsoCocina;
    }

    public void setBtnFinalizarUsoCocina(JButton btnFinalizarUsoCocina) {
        this.btnFinalizarUsoCocina = btnFinalizarUsoCocina;
    }

    public JButton getBtnRegistrarUsoCocina() {
        return btnRegistrarUsoCocina;
    }

    public void setBtnRegistrarUsoCocina(JButton btnRegistrarUsoCocina) {
        this.btnRegistrarUsoCocina = btnRegistrarUsoCocina;
    }

    public JButton getBtnSolicitarBotellon_DepositarBotello() {
        return btnDepositarbotellon;
    }

    public void setBtnSolicitarBotellon_DepositarBotello(JButton btnSolicitarBotellon_DepositarBotello) {
        this.btnDepositarbotellon = btnSolicitarBotellon_DepositarBotello;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public void setBtnVolver(JButton btnVolver) {
        this.btnVolver = btnVolver;
    }

    public JLabel getJbNombre() {
        return jbNombre;
    }

    public void setJbNombre(JLabel jbNombre) {
        this.jbNombre = jbNombre;
    }

    private void btnEntradaSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntradaSalidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDepositarbotellon;
    public javax.swing.JButton btnEntradaSalida;
    public javax.swing.JButton btnFinalizarUsoCocina;
    public javax.swing.JButton btnRegistrarUsoCocina;
    public javax.swing.JButton btnSolicitarBotellon;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jbNombre;
    private javax.swing.JPanel jpContenedor;
    // End of variables declaration//GEN-END:variables
}
