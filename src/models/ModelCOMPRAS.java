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
    public String nombre_empleado;// solo se obtendra este dato, no se almacenara
    public String apellido_pat_empleado;// solo se obtendra este dato, no se almacenara
    public String apellido_mat_empleado;// solo se obtendra este dato, no se almacenara
    public int num_sucursal;
    public int id_proveedor;
    public String num_proveedor;
    public ArrayList producto; // la variable almacenara una lista para llenar comboBox
    public ArrayList numero_empleado; // la variable almacenara una lista para llenar comboBox
    public ArrayList numero_sucursal; // la variable almacenara una lista para llenar comboBox
    public ArrayList numero_proveedor; // la variable almacenara una lista para llenar comboBox
    public String nombre_proveedor; // solo se obtendra este dato, no se almacenara
    public String telefono_proveedor; // solo se obtendra este dato, no se almacenara
    public String apell_pat_proveedor; // solo se obtendra este dato, no se almacenara
    public String apell_mat_proveedor; // solo se obtendra este dato, no se almacenara
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

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_pat_empleado() {
        return apellido_pat_empleado;
    }

    public void setApellido_pat_empleado(String apellido_pat_empleado) {
        this.apellido_pat_empleado = apellido_pat_empleado;
    }

    public String getApellido_mat_empleado() {
        return apellido_mat_empleado;
    }

    public void setApellido_mat_empleado(String apellido_mat_empleado) {
        this.apellido_mat_empleado = apellido_mat_empleado;
    }
    
    public int getNum_sucursal() {
        return num_sucursal;
    }

    public void setNum_sucursal(int num_sucursal) {
        this.num_sucursal = num_sucursal;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    

    public String getNum_proveedor() {
        return num_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }
    
    public void setNum_proveedor(String num_proveedor) {
        this.num_proveedor = num_proveedor;
    }

    public String getApell_pat_proveedor() {
        return apell_pat_proveedor;
    }

    public void setApell_pat_proveedor(String apell_pat_proveedor) {
        this.apell_pat_proveedor = apell_pat_proveedor;
    }

    public String getApell_mat_proveedor() {
        return apell_mat_proveedor;
    }

    public void setApell_mat_proveedor(String apell_mat_proveedor) {
        this.apell_mat_proveedor = apell_mat_proveedor;
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

    public ArrayList getProducto() {
        return producto;
    }

    public void setProducto(ArrayList producto) {
        this.producto = producto;
    }

    public ArrayList getNumero_empleado() {
        return numero_empleado;
    }

    public void setNumero_empleado(ArrayList numero_empleado) {
        this.numero_empleado = numero_empleado;
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
      //llenar comboBox de RFC empleados 
      ArrayList rfc = new ArrayList();
      try{
          rs = st.executeQuery("SELECT * FROM empleados_compras;");
      }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"error1 al llenar comboBox"+e);
      }
      try{
          while(rs.next()){
              String sucursal=rs.getString("RFC_empl_comp");
              rfc.add(sucursal);//agregar los datos a la lista        
          }this.setNumero_empleado(rfc);// almacena la lista con los numeros de proveedores obetenidos de la BD      
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,"error3 al llenar comboBox"+e);
      }
      //llenar comboBox de codigo de productos
      ArrayList codigo = new ArrayList();
      try{
          rs = st.executeQuery("SELECT * FROM productos;");
      }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"error4 al llenar comboBox"+e);
      }
      try{
          while(rs.next()){
              String sucursal=rs.getString("codigo_producto");
              codigo.add(sucursal);//agregar los datos a la lista        
          }this.setProducto(codigo);// almacena la lista con los numeros de proveedores obetenidos de la BD      
      }catch(Exception e){
          JOptionPane.showMessageDialog(null,"error5 al llenar comboBox"+e);
      }
    }
    public void llenarTextFieldsProveedor(){
        try{
            id_proveedor=this.getId_proveedor();      
            rs = st.executeQuery("SELECT * FROM proveedores WHERE id_proveedor='" + id_proveedor+ "';");//consulta a proveedores
            rs.next();
            nombre_proveedor=rs.getString("nombre_prov");
            telefono_proveedor=rs.getString("telefono_prov"); 
            apell_pat_proveedor=rs.getString("ap_pat_prov");
            apell_mat_proveedor=rs.getString("ap_mat_prov");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error6 al llenarTextFields"+e);
        }
    }
    public void llenarTextFieldsEmpleados(){
        try{
            RFC_empleado=this.getRFC_empleado();
            rs = st.executeQuery("SELECT * FROM empleados_compras WHERE RFC_empl_comp='" +RFC_empleado+ "';");//consulta a empleaddos compras
                rs.next();
                nombre_empleado = rs.getString("nombre_empl_comp");
                apellido_pat_empleado = rs.getString("ap_pat_comp");
                apellido_mat_empleado = rs.getString("ap_mat_comp");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error7 al llenarTextFields"+e);
        }   
    }
}
