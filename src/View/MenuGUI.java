
package View;


public class MenuGUI extends javax.swing.JFrame {

  
    public MenuGUI() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenedor = new javax.swing.JPanel();
        btnSalida = new javax.swing.JButton();
        btnBeginCocina = new javax.swing.JButton();
        btnENDCocina = new javax.swing.JButton();
        btnRegistra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBeginBotellon = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jpContenedor.setBackground(new java.awt.Color(0, 117, 250));
        jpContenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalida.setBackground(new java.awt.Color(237, 237, 237));
        btnSalida.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnSalida.setForeground(new java.awt.Color(30, 30, 30));
        btnSalida.setText("Registra salida");
        btnSalida.setBorder(null);
        btnSalida.setBorderPainted(false);
        jpContenedor.add(btnSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 340, 70));

        btnBeginCocina.setBackground(new java.awt.Color(237, 237, 237));
        btnBeginCocina.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnBeginCocina.setForeground(new java.awt.Color(30, 30, 30));
        btnBeginCocina.setText("Solicitar uso cocina");
        btnBeginCocina.setBorder(null);
        btnBeginCocina.setBorderPainted(false);
        jpContenedor.add(btnBeginCocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 340, 70));

        btnENDCocina.setBackground(new java.awt.Color(237, 237, 237));
        btnENDCocina.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnENDCocina.setForeground(new java.awt.Color(30, 30, 30));
        btnENDCocina.setText("Terminar uso cocina");
        btnENDCocina.setBorder(null);
        btnENDCocina.setBorderPainted(false);
        jpContenedor.add(btnENDCocina, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 340, 70));

        btnRegistra.setBackground(new java.awt.Color(237, 237, 237));
        btnRegistra.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnRegistra.setForeground(new java.awt.Color(30, 30, 30));
        btnRegistra.setText("Registra entrada");
        btnRegistra.setBorder(null);
        btnRegistra.setBorderPainted(false);
        btnRegistra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistraActionPerformed(evt);
            }
        });
        jpContenedor.add(btnRegistra, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 340, 70));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleciona una operacion");
        jpContenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 210, 20));

        btnBeginBotellon.setBackground(new java.awt.Color(237, 237, 237));
        btnBeginBotellon.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        btnBeginBotellon.setForeground(new java.awt.Color(30, 30, 30));
        btnBeginBotellon.setText("Solicitar Botellon");
        btnBeginBotellon.setBorder(null);
        btnBeginBotellon.setBorderPainted(false);
        jpContenedor.add(btnBeginBotellon, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 500, 340, 70));

        btnVolver.setBackground(new java.awt.Color(250, 76, 76));
        btnVolver.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        jpContenedor.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 130, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 1306, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistraActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBeginBotellon;
    public javax.swing.JButton btnBeginCocina;
    public javax.swing.JButton btnENDCocina;
    public javax.swing.JButton btnRegistra;
    public javax.swing.JButton btnSalida;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpContenedor;
    // End of variables declaration//GEN-END:variables
}
