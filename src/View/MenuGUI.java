
package View;


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
        btnSolicitarBotellon_DepositarBotello = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnFinalizarUsoCocina = new javax.swing.JButton();

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
        jpContenedor.add(btnEntradaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 340, 70));

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleciona una operacion");
        jpContenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 280, -1));

        btnSolicitarBotellon_DepositarBotello.setBackground(new java.awt.Color(45, 45, 45));
        btnSolicitarBotellon_DepositarBotello.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnSolicitarBotellon_DepositarBotello.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitarBotellon_DepositarBotello.setText("Solicitar botellon");
        btnSolicitarBotellon_DepositarBotello.setBorder(null);
        btnSolicitarBotellon_DepositarBotello.setBorderPainted(false);
        jpContenedor.add(btnSolicitarBotellon_DepositarBotello, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 340, 70));

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
        jpContenedor.add(btnFinalizarUsoCocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 340, 70));

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

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEntradaSalida;
    public javax.swing.JButton btnFinalizarUsoCocina;
    public javax.swing.JButton btnRegistrarUsoCocina;
    public javax.swing.JButton btnSolicitarBotellon_DepositarBotello;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpContenedor;
    // End of variables declaration//GEN-END:variables
}
