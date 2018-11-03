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
public class ViewProveedores extends javax.swing.JPanel {

    /**
     * Creates new form Clientes
     */
    public ViewProveedores() {
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
        jtf_telefono = new javax.swing.JTextField();
        jl_id = new javax.swing.JLabel();
        jtf_id = new javax.swing.JTextField();
        jl_ap_mat = new javax.swing.JLabel();
        jtf_ap_pat = new javax.swing.JTextField();
        jl_nombre = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jl_Provincia = new javax.swing.JLabel();
        jl_calle = new javax.swing.JLabel();
        jtf_calle = new javax.swing.JTextField();
        jtf_municipio = new javax.swing.JTextField();
        jl_correo = new javax.swing.JLabel();
        jl_numero = new javax.swing.JLabel();
        jtf_correo = new javax.swing.JTextField();
        jtf_colonia = new javax.swing.JTextField();
        jtf_provincia = new javax.swing.JTextField();
        jl_colonia = new javax.swing.JLabel();
        jp_vista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_vista = new javax.swing.JTable();
        jp_botones = new javax.swing.JPanel();
        jb_nuevo = new javax.swing.JButton();
        jl_nuevo = new javax.swing.JLabel();
        jb_modificar = new javax.swing.JButton();
        jl_modificar = new javax.swing.JLabel();
        jb_eliminar = new javax.swing.JButton();
        jl_eliminar = new javax.swing.JLabel();
        jb_guardar = new javax.swing.JButton();
        jl_guadar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jp_barra.setBackground(new java.awt.Color(153, 204, 255));

        jl_titulo.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        jl_titulo.setForeground(new java.awt.Color(102, 102, 102));
        jl_titulo.setText("Proveedores");

        jl_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/proveedores.png"))); // NOI18N

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
        jl_telefono.setText("Telefono:");

        jl_ap_pat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_ap_pat.setForeground(new java.awt.Color(51, 51, 51));
        jl_ap_pat.setText("Apellido Paterno:");

        jl_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_id.setForeground(new java.awt.Color(51, 51, 51));
        jl_id.setText("ID:");

        jl_ap_mat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_ap_mat.setForeground(new java.awt.Color(51, 51, 51));
        jl_ap_mat.setText("Apellido Materno:");

        jl_nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_nombre.setForeground(new java.awt.Color(51, 51, 51));
        jl_nombre.setText("Nombre:");

        jl_Provincia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_Provincia.setForeground(new java.awt.Color(51, 51, 51));
        jl_Provincia.setText("Provincia:");

        jl_calle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_calle.setForeground(new java.awt.Color(51, 51, 51));
        jl_calle.setText("Calle:");

        jl_correo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_correo.setForeground(new java.awt.Color(51, 51, 51));
        jl_correo.setText("Correo:");

        jl_numero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_numero.setForeground(new java.awt.Color(51, 51, 51));
        jl_numero.setText("Numero:");

        jl_colonia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jl_colonia.setForeground(new java.awt.Color(51, 51, 51));
        jl_colonia.setText("Colonia:");

        javax.swing.GroupLayout jp_datosLayout = new javax.swing.GroupLayout(jp_datos);
        jp_datos.setLayout(jp_datosLayout);
        jp_datosLayout.setHorizontalGroup(
            jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_datosLayout.createSequentialGroup()
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jp_datosLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_nombre)
                            .addComponent(jl_id))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_datosLayout.createSequentialGroup()
                                .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jl_numero))
                            .addGroup(jp_datosLayout.createSequentialGroup()
                                .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
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
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_datosLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jl_telefono)
                                    .addComponent(jl_calle))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jp_datosLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jl_colonia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_calle, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_correo)
                            .addComponent(jl_Provincia))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_colonia, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jp_datosLayout.setVerticalGroup(
            jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_datosLayout.createSequentialGroup()
                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_id)
                    .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(78, 78, 78)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_colonia)))
                    .addGroup(jp_datosLayout.createSequentialGroup()
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_datosLayout.createSequentialGroup()
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jl_telefono))
                                .addGap(16, 16, 16)
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtf_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jl_calle)))
                            .addGroup(jp_datosLayout.createSequentialGroup()
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtf_colonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jl_numero))
                                .addGap(18, 18, 18)
                                .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtf_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jl_Provincia))))
                        .addGap(18, 18, 18)
                        .addGroup(jp_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_correo)
                            .addComponent(jtf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jp_vista.setBackground(new java.awt.Color(255, 255, 255));
        jp_vista.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vista", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(0, 153, 255))); // NOI18N

        jt_vista.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jt_vista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Telefono", "Calle", "Colonia", "Numero", "Provincia", "Correo"
            }
        ));
        jScrollPane1.setViewportView(jt_vista);

        javax.swing.GroupLayout jp_vistaLayout = new javax.swing.GroupLayout(jp_vista);
        jp_vista.setLayout(jp_vistaLayout);
        jp_vistaLayout.setHorizontalGroup(
            jp_vistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jp_vistaLayout.setVerticalGroup(
            jp_vistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_vistaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_nuevo))
                .addGap(60, 60, 60)
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_modificar)
                    .addComponent(jb_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_botonesLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jl_eliminar))
                    .addGroup(jp_botonesLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jb_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_guadar))
                .addGap(50, 50, 50))
        );
        jp_botonesLayout.setVerticalGroup(
            jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jb_guardar)
                    .addComponent(jb_nuevo)
                    .addComponent(jb_modificar)
                    .addComponent(jb_eliminar))
                .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_botonesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jl_guadar))
                    .addGroup(jp_botonesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jl_nuevo)
                                .addComponent(jl_modificar))
                            .addComponent(jl_eliminar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jp_vista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jl_icon_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jp_vista, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jp_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jb_eliminar;
    public javax.swing.JButton jb_guardar;
    public javax.swing.JButton jb_modificar;
    public javax.swing.JButton jb_nuevo;
    public javax.swing.JLabel jl_Provincia;
    public javax.swing.JLabel jl_ap_mat;
    public javax.swing.JLabel jl_ap_pat;
    public javax.swing.JLabel jl_calle;
    public javax.swing.JLabel jl_colonia;
    public javax.swing.JLabel jl_correo;
    public javax.swing.JLabel jl_eliminar;
    public javax.swing.JLabel jl_guadar;
    public javax.swing.JLabel jl_icon_buscar;
    public javax.swing.JLabel jl_id;
    public javax.swing.JLabel jl_imagen;
    public javax.swing.JLabel jl_modificar;
    public javax.swing.JLabel jl_nombre;
    public javax.swing.JLabel jl_nuevo;
    public javax.swing.JLabel jl_numero;
    public javax.swing.JLabel jl_telefono;
    public javax.swing.JLabel jl_titulo;
    public javax.swing.JPanel jp_barra;
    public javax.swing.JPanel jp_botones;
    public javax.swing.JPanel jp_datos;
    public javax.swing.JPanel jp_vista;
    public javax.swing.JTable jt_vista;
    public javax.swing.JTextField jtf_ap_pat;
    public javax.swing.JTextField jtf_apt_mat;
    public javax.swing.JTextField jtf_buscar;
    public javax.swing.JTextField jtf_calle;
    public javax.swing.JTextField jtf_colonia;
    public javax.swing.JTextField jtf_correo;
    public javax.swing.JTextField jtf_id;
    public javax.swing.JTextField jtf_municipio;
    public javax.swing.JTextField jtf_nombre;
    public javax.swing.JTextField jtf_provincia;
    public javax.swing.JTextField jtf_telefono;
    // End of variables declaration//GEN-END:variables
}
