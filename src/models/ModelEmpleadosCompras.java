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

public class ModelEmpleadosCompras {
    
     DefaultTableModel modelo_EmCompras= new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

    public DefaultTableModel getModelo_EmCompras() {
        return modelo_EmCompras;
    }

    public void setModelo_EmCompras(DefaultTableModel modelo_EmCompras) {
        this.modelo_EmCompras = modelo_EmCompras;
    }
    
     public int rec;
    //Variable que tomara el valor seleccionado en la tabla 

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }
    
    //Nombre de las columnas de las tablas
    public String[] titulos = 
    {"RFC", "Nombre", "Apellido Paterno", "Apellido Materno","Sexo", "Estado civil", "Telefono", "Correo", "Usuario"};
    
  
    //Variables que corresponden a cada caja de texto
     // variable que nos ayudara a ver si se inserto un nuevo registro o se midificara
    public int verificar;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
    
    
      //-------------------Variables para los BOTONES
    
    public String Limpiar=" ";
    public int codigo=0;

    public String getLimpiar() {
        return Limpiar;
    }

    public void setLimpiar(String Limpiar) {
        this.Limpiar = Limpiar;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        modelo_EmCompras.setColumnIdentifiers(new Object[]{"RFC", "Nombre", "Apellido Paterno", "Apellido Materno","Sexo", "Estado Civil", "Telefono", "Correo", "Usuario"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_EmCompras.addRow(new Object[]{
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
     
     //---------------METODOS DE BOTONES Nuevo, Borrar, Guardar y Modificar-----------------
      public void Guardar_Nuevo(){
        //cada variable obtendra el valor actual de las cajas de texto 
        rfc=this.getRfc();
        nombre=this.getNombre();
        apellido_pat=this.getApellido_pat();
        apellido_mat=this.getApellido_mat();
        sexo=this.getSexo();
        estado_civil=this.getEstado_civil();
        telefono=this.getTelefono();
        correo=this.getCorreo();
        usuario=this.getUsuario();
        
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Guardar el NUEVO registro?");
        
        if(JOptionPane.OK_OPTION==confirmar) {
            try{
            st.executeUpdate("insert into empleados_compras (RFC_empl_vent,nombre_empl_vent,ap_pat_vent,ap_mat_vent,sexo_vent,estado_civil_vent,telefono_vent,correo_vent,usuario_vent) values"
                    + "('"+rfc+"','"+nombre+"','"+apellido_pat+"','"+apellido_mat+"','"+sexo+"','"+estado_civil+"','"+telefono+"','"+correo+"','"+usuario+"');"); 
                JOptionPane.showMessageDialog(null,"Guardado con exito ");
            } catch(Exception err) 
            { 
                JOptionPane.showMessageDialog(null,"Error Nuevo no se puede guardar "+err.getMessage()); 
            }
        }
    }
      
      public void Guardar_Modificado(){
        //cada variable obtendra el valor actual de las cajas de texto 
        rfc=this.getRfc();
        nombre=this.getNombre();
        apellido_pat=this.getApellido_pat();
        apellido_mat=this.getApellido_mat();
        sexo=this.getSexo();
        estado_civil=this.getEstado_civil();
        telefono=this.getTelefono();
        correo=this.getCorreo();
        usuario=this.getUsuario();
        
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de MODIFICAR registro?");
        
        if(JOptionPane.OK_OPTION==confirmar) {
            try{
               st.executeUpdate("UPDATE empleados_compras SET nombre_empl_comp='"+nombre+"',ap_pat_comp='"+apellido_pat+"',ap_mat_comp='"+apellido_mat+"',sexo_comp='"+sexo+"',estado_civil_comp='"+estado_civil+"',telefono_comp='"+telefono+"', correo_comp='"+correo+"',usuario_comp='"+usuario+"' WHERE RFC_empl_comp='"+rfc+"';");
               JOptionPane.showMessageDialog(null,"El registro se modifico correctamente");
            } catch(Exception err) 
            { 
                JOptionPane.showMessageDialog(null,"Error Nuevo no se puede guardar "+err.getMessage()); 
            }
        }
    }    
}