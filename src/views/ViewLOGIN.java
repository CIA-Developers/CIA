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
public class ViewLOGIN extends javax.swing.JFrame {

    /**
     * Creates new form LOGIN
     */
    public ViewLOGIN() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.setOpacity(0.95f);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_passwd = new javax.swing.JLabel();
        jcb_tipo_admin = new javax.swing.JComboBox<>();
        jl_tipo = new javax.swing.JLabel();
        jl_usuario = new javax.swing.JLabel();
        jpf_passwd = new javax.swing.JPasswordField();
        jtf_usuario = new javax.swing.JTextField();
        jb_aceptar = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(364, 523));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jl_passwd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_passwd.setText("Contraseña:");
        getContentPane().add(jl_passwd);
        jl_passwd.setBounds(40, 330, 80, 25);

        jcb_tipo_admin.setBackground(new java.awt.Color(204, 204, 204));
        jcb_tipo_admin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado Ventas ", "Empleado Compras " }));
        jcb_tipo_admin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(jcb_tipo_admin);
        jcb_tipo_admin.setBounds(150, 220, 140, 30);

        jl_tipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_tipo.setText("TIPO:");
        getContentPane().add(jl_tipo);
        jl_tipo.setBounds(110, 220, 40, 25);

        jl_usuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_usuario.setText("Usuario:");
        getContentPane().add(jl_usuario);
        jl_usuario.setBounds(60, 280, 60, 25);

        jpf_passwd.setText("jPasswordField1");
        getContentPane().add(jpf_passwd);
        jpf_passwd.setBounds(120, 330, 180, 30);
        getContentPane().add(jtf_usuario);
        jtf_usuario.setBounds(120, 280, 180, 30);

        jb_aceptar.setBackground(new java.awt.Color(204, 204, 204));
        jb_aceptar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jb_aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/aceptar.png"))); // NOI18N
        jb_aceptar.setText("Aceptar");
        getContentPane().add(jb_aceptar);
        jb_aceptar.setBounds(60, 400, 120, 39);

        jb_cancelar.setBackground(new java.awt.Color(204, 204, 204));
        jb_cancelar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cerrar.png"))); // NOI18N
        jb_cancelar.setText("cancelar");
        getContentPane().add(jb_cancelar);
        jb_cancelar.setBounds(190, 400, 120, 39);

        jl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fondo_login2.png"))); // NOI18N
        getContentPane().add(jl_fondo);
        jl_fondo.setBounds(0, 0, 370, 523);

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
            java.util.logging.Logger.getLogger(ViewLOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jb_aceptar;
    public javax.swing.JButton jb_cancelar;
    public javax.swing.JComboBox<String> jcb_tipo_admin;
    public javax.swing.JLabel jl_fondo;
    public javax.swing.JLabel jl_passwd;
    public javax.swing.JLabel jl_tipo;
    public javax.swing.JLabel jl_usuario;
    public javax.swing.JPasswordField jpf_passwd;
    public javax.swing.JTextField jtf_usuario;
    // End of variables declaration//GEN-END:variables
}
