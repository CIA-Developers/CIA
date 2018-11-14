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
public class ViewEmpleadosCompras extends javax.swing.JPanel {

    /**
     * Creates new form Clientes
     */
    public ViewEmpleadosCompras() {
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

        jp_barra = new javax.swing.JPanel();
        jl_titulo = new javax.swing.JLabel();
        jl_imagen = new javax.swing.JLabel();
        jl_icon_buscar = new javax.swing.JLabel();
        jtf_buscar = new javax.swing.JTextField();
        jp_datos = new javax.swing.JPanel();
        jl_telefono = new javax.swing.JLabel();
        jtf_apt_mat = new javax.swing.JTextField();
        jl_ap_pat = new javax.swing.JLabel();
        jl_rfc = new javax.swing.JLabel();
        jtf_rfc = new javax.swing.JTextField();
        jl_ap_mat = new javax.swing.JLabel();
        jtf_ap_pat = new javax.swing.JTextField();
        jl_nombre = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jl_Provincia = new javax.swing.JLabel();
        jl_calle = new javax.swing.JLabel();
        jtf_Telefono = new javax.swing.JTextField();
        jtf_estado_civil = new javax.swing.JTextField();
        jl_numero = new javax.swing.JLabel();
        jtf_correo = new javax.swing.JTextField();
        jtf_usuario = new javax.swing.JTextField();
        jl_colonia = new javax.swing.JLabel();
        jCB_sexo = new javax.swing.JComboBox<>();
        jl_Provincia1 = new javax.swing.JLabel();
        jl_fecha = new javax.swing.JLabel();
        jp_botones = new javax.swing.JPanel();
        jb_nuevo = new javax.swing.JButton();
        jl_nuevo = new javax.swing.JLabel();
        jb_modificar = new javax.swing.JButton();
        jl_modificar = new javax.swing.JLabel();
        jb_eliminar = new javax.swing.JButton();
        jl_eliminar = new javax.swing.JLabel();
        jb_guardar = new javax.swing.JButton();
        jl_guadar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_vista = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jp_barra.setBackground(new java.awt.Color(153, 204, 255));

        jl_titulo.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        jl_titulo.setForeground(new java.awt.Color(102, 102, 102));
        jl_titulo.setText("Empleados Compras");

        jl_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Empleados.png"))); // NOI18N

        javax.swing.GroupLayout jp_barraLayout = new javax.swing.GroupLayout(jp_barra);
        jp_barra.setLayout(jp_barraLayout);
        jp_barraLayout.setHorizontalGroup(
            jp_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_barraLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jl_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jl_imagen)
                .addGap(61, 61, 61))
        );
        jp_barraLayout.setVerticalGroup(
            jp_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_barraLayout.createSequentialGroup()
                .addGroup(jp_barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_imagen)
                    .addComponent(jl_titulo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_icon_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscar .png"))); // NOI18N

        jp_datos.setBackground(new java.awt.Color(255, 255, 255));
        jp_datos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 153, 255))); // NOI18N

        jl_telefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_telefono.setForeground(new java.awt.Color(51, 51, 51));
        jl_telefono.setText("Sexo:");

        jl_ap_pat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_ap_pat.setForeground(new java.awt.Color(51, 51, 51));
        jl_ap_pat.setText("Apellido Paterno:");

        jl_rfc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_rfc.setForeground(new java.awt.Color(51, 51, 51));
        jl_rfc.setText("RFC:");

        jtf_rfc.setBackground(new java.awt.Color(240, 240, 240));

        jl_ap_mat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_ap_mat.setForeground(new java.awt.Color(51, 51, 51));
        jl_ap_mat.setText("Apellido Materno:");

        jl_nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_nombre.setForeground(new java.awt.Color(51, 51, 51));
        jl_nombre.setText("Nombre:");

        jl_Provincia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_Provincia.setForeground(new java.awt.Color(51, 51, 51));
        jl_Provincia.setText("Usuario:");

        jl_calle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_calle.setForeground(new java.awt.Color(51, 51, 51));
        jl_calle.setText("Estado Civil:");

        jl_numero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_numero.setForeground(new java.awt.Color(51, 51, 51));
        jl_numero.setText("Correo:");

        jl_colonia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_colonia.setForeground(new java.awt.Color(51, 51, 51));
        jl_colonia.setText("Telefono:");

        jCB_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione uno", "Femenino", "Masculino" }));

        jl_Provincia1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_Provincia1.setForeground(new java.awt.Color(51, 51, 51));
        jl_Provincia1.setText("Hora:");

        jl_fecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_fecha.setForeground(new java.awt.Color(51, 51, 51));
        jl_fecha.setText("Fecha:");

        javax.swing.GroupLayout jp_datosLayout = new javax.swing.GroupLayout(jp_datos);
        jp_datos.setLayout(jp_datosLayout);
        jp_datosLayout.setHorizontalGroup(
            jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_datosLayout.createSequentialGroup()
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_datosLayout.createSequentialGroup()
                        .addComponent(jl_ap_mat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_apt_mat, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_datosLayout.createSequentialGroup()
                        .addComponent(jl_ap_pat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_ap_pat, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_telefono)
                    .addComponent(jl_calle)
                    .addComponent(jl_colonia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_estado_civil, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jp_datosLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_nombre)
                    .addComponent(jl_rfc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_datosLayout.createSequentialGroup()
                        .addComponent(jtf_rfc, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_datosLayout.createSequentialGroup()
                        .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(jCB_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jp_datosLayout.createSequentialGroup()
                                .addComponent(jl_numero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jp_datosLayout.createSequentialGroup()
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jl_fecha)
                                    .addComponent(jl_Provincia))
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_datosLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_datosLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jl_Provincia1)))))
                        .addContainerGap(176, Short.MAX_VALUE))))
        );
        jp_datosLayout.setVerticalGroup(
            jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_datosLayout.createSequentialGroup()
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_rfc)
                    .addComponent(jtf_rfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_datosLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_nombre)
                            .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_ap_pat)
                            .addComponent(jtf_ap_pat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_ap_mat)
                            .addComponent(jtf_apt_mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jp_datosLayout.createSequentialGroup()
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_datosLayout.createSequentialGroup()
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_telefono)
                                    .addComponent(jCB_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtf_estado_civil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jl_calle)))
                            .addGroup(jp_datosLayout.createSequentialGroup()
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jl_numero))
                                .addGap(18, 18, 18)
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jl_Provincia))))
                        .addGap(18, 18, 18)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Provincia1)
                            .addComponent(jl_fecha)))
                    .addGroup(jp_datosLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_colonia))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jp_botones.setBackground(new java.awt.Color(255, 255, 51));

        jb_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nuevo.png"))); // NOI18N

        jl_nuevo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jl_nuevo.setForeground(new java.awt.Color(51, 51, 51));
        jl_nuevo.setText("Nuevo");

        jb_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Modificar.png"))); // NOI18N

        jl_modificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jl_modificar.setForeground(new java.awt.Color(51, 51, 51));
        jl_modificar.setText("Modificar");

        jb_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eliminar.png"))); // NOI18N

        jl_eliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jl_eliminar.setForeground(new java.awt.Color(51, 51, 51));
        jl_eliminar.setText("Eliminar");

        jb_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Guardar.png"))); // NOI18N

        jl_guadar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jl_guadar.setForeground(new java.awt.Color(51, 51, 51));
        jl_guadar.setText("Guardar");

        javax.swing.GroupLayout jp_botonesLayout = new javax.swing.GroupLayout(jp_botones);
        jp_botones.setLayout(jp_botonesLayout);
        jp_botonesLayout.setHorizontalGroup(
            jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_botonesLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jl_nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_modificar))
                .addGap(28, 28, 28)
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_eliminar))
                .addGap(34, 34, 34)
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_guadar))
                .addGap(88, 88, 88))
        );
        jp_botonesLayout.setVerticalGroup(
            jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_botonesLayout.createSequentialGroup()
                        .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jp_botonesLayout.createSequentialGroup()
                        .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_nuevo)
                            .addComponent(jl_modificar)
                            .addComponent(jl_eliminar)
                            .addComponent(jl_guadar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jt_vista.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jt_vista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RFC", "Nombre", "Apellido Paterno", "Apellido Materno", "Sexo", "Estado Civil", "Telefono", "Correo", "Usuario"
            }
        ));
        jScrollPane1.setViewportView(jt_vista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jl_icon_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jp_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jp_barra, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_icon_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_datos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jp_botones, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> jCB_sexo;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jb_eliminar;
    public javax.swing.JButton jb_guardar;
    public javax.swing.JButton jb_modificar;
    public javax.swing.JButton jb_nuevo;
    public javax.swing.JLabel jl_Provincia;
    public javax.swing.JLabel jl_Provincia1;
    public javax.swing.JLabel jl_ap_mat;
    public javax.swing.JLabel jl_ap_pat;
    public javax.swing.JLabel jl_calle;
    public javax.swing.JLabel jl_colonia;
    public javax.swing.JLabel jl_eliminar;
    public javax.swing.JLabel jl_fecha;
    public javax.swing.JLabel jl_guadar;
    public javax.swing.JLabel jl_icon_buscar;
    public javax.swing.JLabel jl_imagen;
    public javax.swing.JLabel jl_modificar;
    public javax.swing.JLabel jl_nombre;
    public javax.swing.JLabel jl_nuevo;
    public javax.swing.JLabel jl_numero;
    public javax.swing.JLabel jl_rfc;
    public javax.swing.JLabel jl_telefono;
    public javax.swing.JLabel jl_titulo;
    public javax.swing.JPanel jp_barra;
    public javax.swing.JPanel jp_botones;
    public javax.swing.JPanel jp_datos;
    public javax.swing.JTable jt_vista;
    public javax.swing.JTextField jtf_Telefono;
    public javax.swing.JTextField jtf_ap_pat;
    public javax.swing.JTextField jtf_apt_mat;
    public javax.swing.JTextField jtf_buscar;
    public javax.swing.JTextField jtf_correo;
    public javax.swing.JTextField jtf_estado_civil;
    public javax.swing.JTextField jtf_nombre;
    public javax.swing.JTextField jtf_rfc;
    public javax.swing.JTextField jtf_usuario;
    // End of variables declaration//GEN-END:variables
}
