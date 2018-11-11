/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Octaviano
 */

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

public class ModelEmpleadosVentas {
    
    DefaultTableModel modelo_EmVentas= new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

    public DefaultTableModel getModelo_EmVentas() {
        return modelo_EmVentas;
    }

    public void setModelo_EmVentas(DefaultTableModel modelo_EmVentas) {
        this.modelo_EmVentas = modelo_EmVentas;
    }

    //Variable que tomara el valor seleccionado en la tabla
    public int rec;
     

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }
    
     //Variables que corresponden a cada caja de texto
     public int verificar; // variable que nos ayudara a ver si se inserto un nuevo registro o se midificara
    public String rfc;
    public String nombre;
    public String apellido_pat;
    public String apellido_mat;
    public String sexo;
    public String estado_civil;
    public String telefono;
    public String correo;
    public String usuario;

    public int getVerificar() {
        return verificar;
    }

    public void setVerificar(int verificar) {
        this.verificar = verificar;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_pat() {
        return apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
                rs=st.executeQuery("SELECT RFC_empl_vent, nombre_empl_vent, ap_pat_vent, ap_mat_vent, sexo_vent, estado_civil_vent, telefono_vent, correo_vent, usuario_vent FROM empleados_ventas ;");
                        
                rs.first();
                
            }catch(SQLException err){ 
                JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
            } 
    }
     
     public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT RFC_empl_vent, nombre_empl_vent, ap_pat_vent, ap_mat_vent, sexo_vent, estado_civil_vent, telefono_vent, correo_vent, usuario_vent FROM empleados_ventas;");
        modelo_EmVentas.setColumnIdentifiers(new Object[]{"RFC", "Nombre", "Apellido Paterno", "Apellido Materno","Sexo", "Estado Civil", "Telefono", "Correo", "Usuario"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_EmVentas.addRow(new Object[]{
                    rs.getString("RFC_empl_vent"), 
                    rs.getString("nombre_empl_vent"), 
                    rs.getString("ap_pat_vent"), 
                    rs.getString("ap_mat_vent"),
                    rs.getString("sexo_vent"),
                    rs.getString("estado_civil_vent"),
                    rs.getString("telefono_vent"),
                    rs.getString("correo_vent"),
                    rs.getString("usuario_vent")});                                    
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
}
