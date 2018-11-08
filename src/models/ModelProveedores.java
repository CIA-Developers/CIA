/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import conectar_tablas.Database; //llamamos la conexion a la BD para almacen
import static conectar_tablas.Database.getConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author Familia Hernández
 */
public class ModelProveedores {
    
     DefaultTableModel modelo_proveedores= new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

    public DefaultTableModel getModelo_Proveedores() {
        return modelo_proveedores;
    }

    public void setModelo_Proveedores(DefaultTableModel modelo_EmCompras) {
        this.modelo_proveedores = modelo_proveedores;
    }
    
       public int rec;//Variable que tomara el valor seleccionado en la tabla 

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }
    
  
  
    DefaultTableModel model;
    private Connection conexion;     
    private Statement st;     
    private ResultSet rs;
    PreparedStatement ps;
    
    /**
     * se hace la conexion a la Base de datos y se hace la consulta hacia la tabla de EmpleadosCompras 
     * que tiene una union con la tabla de compra 
     * 
     */
     public void Conectar(){
            try{ 
                conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/stockcia","root","");                     
                st=conexion.createStatement(); 
                rs=st.executeQuery("SELECT RFC_empl_comp, nombre_empl_comp, ap_pat_comp, ap_mat_comp, sexo_comp, estado_civil_comp, telefono_comp, correo_comp, usuario_comp FROM empleados_compras ;");
                        
                rs.first();
                
            }catch(SQLException err){ 
                JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
            } 
    }
    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT RFC_empl_comp, nombre_empl_comp, ap_pat_comp, ap_mat_comp, sexo_comp, estado_civil_comp, telefono_comp, correo_comp, usuario_comp FROM empleados_compras;");
        modelo_proveedores.setColumnIdentifiers(new Object[]{"RFC", "Nombre", "Apellido Paterno", "Apellido Materno","Sexo", "Estado Civil", "Telefono", "Correo", "Usuario"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_proveedores.addRow(new Object[]{
                    rs.getString("RFC_empl_comp"), 
                    rs.getString("nombre_empl_comp"), 
                    rs.getString("ap_pat_comp"), 
                    rs.getString("ap_mat_comp"),
                    rs.getString("sexo_comp"),
                    rs.getString("estado_civil_comp"),
                    rs.getString("telefono_comp"),
                    rs.getString("correo_comp"),
                    rs.getString("usuario_comp")});                                    
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}


    
