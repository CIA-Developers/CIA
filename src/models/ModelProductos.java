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
 * @author Octaviano
 */
public class ModelProductos {
    DefaultTableModel modelo_productos= new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

    public DefaultTableModel getModelo_productos() {
        return modelo_productos;
    }

    public void setModelo_productos(DefaultTableModel modelo_productos) {
        this.modelo_productos = modelo_productos;
    }
    
    public int rec;//Variable que tomara el valor seleccionado en la tabla 

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    } 
    
    //*************************Variables que corresponden a los BOTONES*************************************
    
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
     * se hace la conexion a la Base de datos y se hace la consulta hacia la tabla de sucursales 
     * que tiene una union con la tabla de productos 
     * y finalmente con la tabla de produtos para obtener el nombre del producto
     * que se tiene en cada sucursal 
     */
    public void Conectar(){
             try{ 
                conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/stockcia","root","");                     
                st=conexion.createStatement(); 
                rs=st.executeQuery("SELECT * From productos;");
                        
                rs.first();
                
            }catch(SQLException err){ 
                JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
            } 
    }
    
    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT * From productos;");
        modelo_productos.setColumnIdentifiers(new Object[]{"Codigo Producto", "Nombre Producto", "Tipo Producto", "Marca","Precio Unitario", "Unidad de medida", "Status", "Stock Total", "Descripcion"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_productos.addRow(new Object[]{rs.getString("codigo_producto"), 
                    rs.getString("nom_producto"),
                    rs.getString("tipo_producto"), 
                    rs.getString("marca"), 
                    rs.getString("precio_unitario_venta"), 
                    rs.getString("unidad"),
                    rs.getString("status_prod"),
                    rs.getString("existencia_total"),
                    rs.getString("descripcion")});                                    
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
