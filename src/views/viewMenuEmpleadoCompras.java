/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author Octaviano
 */
public class viewMenuEmpleadoCompras extends javax.swing.JFrame {

    /**
     * Creates new form viewMenuEmpleado
     */
    public viewMenuEmpleadoCompras() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jl_CiaLogo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_catalogos = new javax.swing.JMenu();
        jmi_proveedores = new javax.swing.JMenuItem();
        jmi_clientes = new javax.swing.JMenuItem();
        jmi_sucursales = new javax.swing.JMenuItem();
        jmi_productos = new javax.swing.JMenuItem();
        jm_acciones = new javax.swing.JMenu();
        jmi_compras = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jl_CiaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CIA-Developers.png"))); // NOI18N

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(88, 35));

        jm_catalogos.setBackground(new java.awt.Color(255, 255, 102));
        jm_catalogos.setForeground(new java.awt.Color(255, 255, 255));
        jm_catalogos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/catalogos.png"))); // NOI18N
        jm_catalogos.setText("Catalogos");

        jmi_proveedores.setBackground(new java.awt.Color(255, 255, 255));
        jmi_proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/Proveedores.png"))); // NOI18N
        jmi_proveedores.setText("Proveedores");
        jm_catalogos.add(jmi_proveedores);

        jmi_clientes.setBackground(new java.awt.Color(255, 255, 255));
        jmi_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/clientes.png"))); // NOI18N
        jmi_clientes.setText("Clientes");
        jm_catalogos.add(jmi_clientes);

        jmi_sucursales.setBackground(new java.awt.Color(255, 255, 255));
        jmi_sucursales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/sucursales.png"))); // NOI18N
        jmi_sucursales.setText("sucursales");
        jm_catalogos.add(jmi_sucursales);

        jmi_productos.setBackground(new java.awt.Color(255, 255, 255));
        jmi_productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/productos.png"))); // NOI18N
        jmi_productos.setText("Productos");
        jm_catalogos.add(jmi_productos);

        jMenuBar1.add(jm_catalogos);

        jm_acciones.setForeground(new java.awt.Color(255, 255, 255));
        jm_acciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/acciones.png"))); // NOI18N
        jm_acciones.setText("Acciones");

        jmi_compras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu/compras.png"))); // NOI18N
        jmi_compras.setText("COMPRAS");
        jm_acciones.add(jmi_compras);

        jMenuBar1.add(jm_acciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(926, Short.MAX_VALUE)
                .addComponent(jl_CiaLogo)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(422, Short.MAX_VALUE)
                .addComponent(jl_CiaLogo)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewMenuEmpleadoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewMenuEmpleadoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewMenuEmpleadoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewMenuEmpleadoCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewMenuEmpleadoCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jl_CiaLogo;
    public javax.swing.JMenu jm_acciones;
    public javax.swing.JMenu jm_catalogos;
    public javax.swing.JMenuItem jmi_clientes;
    public javax.swing.JMenuItem jmi_compras;
    public javax.swing.JMenuItem jmi_productos;
    public javax.swing.JMenuItem jmi_proveedores;
    public javax.swing.JMenuItem jmi_sucursales;
    // End of variables declaration//GEN-END:variables
}
