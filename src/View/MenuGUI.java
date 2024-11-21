
package View;


public class MenuGUI extends javax.swing.JFrame {

  
    public MenuGUI() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenedor = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jpContenedor.setBackground(new java.awt.Color(0, 117, 250));
        jpContenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(237, 237, 237));
        jButton1.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(30, 30, 30));
        jButton1.setText("jButton1");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jpContenedor.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 340, 70));

        jButton2.setBackground(new java.awt.Color(237, 237, 237));
        jButton2.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(30, 30, 30));
        jButton2.setText("jButton1");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jpContenedor.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 340, 70));

        jButton3.setBackground(new java.awt.Color(237, 237, 237));
        jButton3.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(30, 30, 30));
        jButton3.setText("jButton1");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jpContenedor.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 340, 70));

        jButton4.setBackground(new java.awt.Color(237, 237, 237));
        jButton4.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(30, 30, 30));
        jButton4.setText("jButton1");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jpContenedor.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, 340, 70));

        jButton5.setBackground(new java.awt.Color(237, 237, 237));
        jButton5.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(30, 30, 30));
        jButton5.setText("Registra entrada");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jpContenedor.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 340, 70));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleciona una operacion");
        jpContenedor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 210, 20));

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpContenedor;
    // End of variables declaration//GEN-END:variables
}
