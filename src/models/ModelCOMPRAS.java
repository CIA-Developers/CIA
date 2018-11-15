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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Octaviano
 */
public class ModelCOMPRAS {
    //******************************VARIABLES NECESARIAS PARA COMPRAS **********************
    
    //********Variables para compra *********
    public String RFC_empleado;
    public int num_sucursal;
    public int num_proveedor;
    public ArrayList numero_sucursal; // la variable almacenara una lista para llenar comboBox
    public ArrayList numero_proveedor; // la variable almacenara una lista para llenar comboBox
    public String nombre_proveedor; // solo se obtendra este dato, no se almacenara
    public float subtotal;
    public float iva;
    public float importe;
    //******Variables para detalle_compra********
    public int numero_compra;
    public String codigo_producto;
    public String nombre_producto;// solo se obtendra este dato, no se almacenara
    public String tipo_producto;// solo se obtendra este dato, no se almacenara
    public String marca_producto;// solo se obtendra este dato, no se almacenara
    public int cantidad_compra;
    public float precio_compra;
    public float total_por_producto;

    public String getRFC_empleado() {
        return RFC_empleado;
    }

    public void setRFC_empleado(String RFC_empleado) {
        this.RFC_empleado = RFC_empleado;
    }

    public int getNum_sucursal() {
        return num_sucursal;
    }

    public void setNum_sucursal(int num_sucursal) {
        this.num_sucursal = num_sucursal;
    }

    public int getNum_proveedor() {
        return num_proveedor;
    }

    public void setNum_proveedor(int num_proveedor) {
        this.num_proveedor = num_proveedor;
    }

    public ArrayList getNumero_sucursal() {
        return numero_sucursal;
    }

    public void setNumero_sucursal(ArrayList numero_sucursal) {
        this.numero_sucursal = numero_sucursal;
    }

    public ArrayList getNumero_proveedor() {
        return numero_proveedor;
    }

    public void setNumero_proveedor(ArrayList numero_proveedor) {
        this.numero_proveedor = numero_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public int getNumero_compra() {
        return numero_compra;
    }

    public void setNumero_compra(int numero_compra) {
        this.numero_compra = numero_compra;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public int getCantidad_compra() {
        return cantidad_compra;
    }

    public void setCantidad_compra(int cantidad_compra) {
        this.cantidad_compra = cantidad_compra;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getTotal_por_producto() {
        return total_por_producto;
    }

    public void setTotal_por_producto(float total_por_producto) {
        this.total_por_producto = total_por_producto;
    }


    /***
     *  variables necesarias para la conexion
     */
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private DefaultTableModel model_compras = new DefaultTableModel();

    public DefaultTableModel getModel_prov() {
        return model_compras;
    }

    public void setModel_prov(DefaultTableModel model_prov) {
        this.model_compras = model_prov;
    }
    
    /**
     * se hace la conexion a la Base de datos y se hace la consulta hacia la
     * tabla de detalle_compra y compras que tiene una union con la tabla de compra
     *
     */
    public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/stockcia", "root", "");
            st = conexion.createStatement(); 

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    /***
     * el metodo que llenara los comboBox con los registros necesarios de la base de datos
     */
    public void llenarCombo(){
        ArrayList num_prov = new ArrayList(); // lista para proveedores
      //llenar comboBox de Proveedores
      try{
          
          rs = st.executeQuery("SELECT * FROM proveedores;");
      }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"error1 al llenar comboBox"+e);
      }
      try{
          while(rs.next()){
              String proveedor=rs.getString("id_proveedor");
              num_prov.add(proveedor);//agregar los datos a la lista        
          }this.setNumero_proveedor(num_prov);// almacena la lista con los numeros de proveedores obetenidos de la BD      
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,"error2 al llenar comboBox"+e);
      }
      ArrayList num_suc = new ArrayList(); // lista para sucursales
      //llenar comboBox de Sucursales
      try{
          
          rs = st.executeQuery("SELECT * FROM sucursal;");
      }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"error1 al llenar comboBox"+e);
      }
      try{
          while(rs.next()){
              String sucursal=rs.getString("no_sucursal");
              num_suc.add(sucursal);//agregar los datos a la lista        
          }this.setNumero_sucursal(num_suc);// almacena la lista con los numeros de proveedores obetenidos de la BD      
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,"error2 al llenar comboBox"+e);
      }
    }
    
}
