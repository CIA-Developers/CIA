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
public class modelVENTAS {
    //************************* Variables necesarias para compras *****************************
    
    public String RFC_empleado;
    public String nombre_empleado;// solo se obtendra este dato, no se almacenara
    public String apellido_pat_empleado;// solo se obtendra este dato, no se almacenara
    public String apellido_mat_empleado;// solo se obtendra este dato, no se almacenara
    public int num_sucursal; //solo se obtendra este dato, no se almacenara. 
    public String RFC_cliente;
    public String nombre_cliente;
    public String apell_pat_cliente; // solo se obtendra este dato, no se almacenara
    public String apell_mat_cliente; // solo se obtendra este dato, no se almacenara
    public int puntos_acumulados;
    public float subtotal;
    public float iva;
    public float importe;
    
    public int numero_venta;
    public String codigo_producto;
    public String nombre_producto;// solo se obtendra este dato, no se almacenara
    public String tipo_producto;// solo se obtendra este dato, no se almacenara
    public String marca_producto;// solo se obtendra este dato, no se almacenara
    public int cantidad_venta = 0;
    public float precio_venta;
    public float total_por_producto=0.0f;
    
    public ArrayList producto; // la variable almacenara una lista para llenar comboBox
    public ArrayList numero_empleado; // la variable almacenara una lista para llenar comboBox
    public ArrayList numero_sucursal; // la variable almacenara una lista para llenar comboBox
    public ArrayList numero_cliente; // la variable almacenara una lista para llenar comboBox
    public ArrayList descuento_combo; // la variable almacenara una lista para llenar comboBox
    
    public int codigo_descuento;
    public int puntos_requeridos;
    public int porcentaje;
    public float descuento;
    
    public float efectivo;
    public float cambio;
    
    public int puntos_ganados;

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

    public String getRFC_cliente() {
        return RFC_cliente;
    }

    public void setRFC_cliente(String RFC_cliente) {
        this.RFC_cliente = RFC_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApell_pat_cliente() {
        return apell_pat_cliente;
    }

    public void setApell_pat_cliente(String apell_pat_cliente) {
        this.apell_pat_cliente = apell_pat_cliente;
    }

    public String getApell_mat_cliente() {
        return apell_mat_cliente;
    }

    public void setApell_mat_cliente(String apell_mat_cliente) {
        this.apell_mat_cliente = apell_mat_cliente;
    }

    public int getPuntos_acumulados() {
        return puntos_acumulados;
    }

    public void setPuntos_acumulados(int puntos_acumulados) {
        this.puntos_acumulados = puntos_acumulados;
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

    public int getNumero_venta() {
        return numero_venta;
    }

    public void setNumero_venta(int numero_venta) {
        this.numero_venta = numero_venta;
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

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getTotal_por_producto() {
        return total_por_producto;
    }

    public void setTotal_por_producto(float total_por_producto) {
        this.total_por_producto = total_por_producto;
    }

    public int getCodigo_descuento() {
        return codigo_descuento;
    }

    public void setCodigo_descuento(int codigo_descuento) {
        this.codigo_descuento = codigo_descuento;
    }

    public int getPuntos_requeridos() {
        return puntos_requeridos;
    }

    public void setPuntos_requeridos(int puntos_requeridos) {
        this.puntos_requeridos = puntos_requeridos;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(float efectivo) {
        this.efectivo = efectivo;
    }

    public float getCambio() {
        return cambio;
    }

    public void setCambio(float cambio) {
        this.cambio = cambio;
    }

    public int getPuntos_ganados() {
        return puntos_ganados;
    }

    public void setPuntos_ganados(int puntos_ganados) {
        this.puntos_ganados = puntos_ganados;
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

    public ArrayList getNumero_sucursal() {
        return numero_sucursal;
    }

    public void setNumero_sucursal(ArrayList numero_sucursal) {
        this.numero_sucursal = numero_sucursal;
    }

    public ArrayList getNumero_cliente() {
        return numero_cliente;
    }

    public void setNumero_cliente(ArrayList numero_cliente) {
        this.numero_cliente = numero_cliente;
    }

    public ArrayList getDescuento_combo() {
        return descuento_combo;
    }

    public void setDescuento_combo(ArrayList descuento_combo) {
        this.descuento_combo = descuento_combo;
    }
    
    
    //**************Variables para conexion 
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    PreparedStatement ps;
    
    public DefaultTableModel model_compras = new DefaultTableModel();
    public int rec;//Variable que tomara el valor seleccionado en la tabla 

    public DefaultTableModel getModel_compras() {
        return model_compras;
    }

    public void setModel_compras(DefaultTableModel model_compras) {
        this.model_compras = model_compras;
    }

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }
    
    //**********************ACTUALIZANDO STOCK*****************************
   public int stock_productos;
   public int stock_productos_sucursales;
   public int existencias_sucursal;
   public int existencia_general;

    public int getStock_productos() {
        return stock_productos;
    }

    public void setStock_productos(int stock_productos) {
        this.stock_productos = stock_productos;
    }

    public int getStock_productos_sucursales() {
        return stock_productos_sucursales;
    }

    public void setStock_productos_sucursales(int stock_productos_sucursales) {
        this.stock_productos_sucursales = stock_productos_sucursales;
    }

    public int getExistencias_sucursal() {
        return existencias_sucursal;
    }

    public void setExistencias_sucursal(int existencias_sucursal) {
        this.existencias_sucursal = existencias_sucursal;
    }

    public int getExistencia_general() {
        return existencia_general;
    }

    public void setExistencia_general(int existencia_general) {
        this.existencia_general = existencia_general;
    }

    
    /**
     * Conexion a la Base de datos
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
    }
    /**
     * llenado de los TextFields con los datos que le correspondan 
     * segun sea seleccionado en el comboBox
     */
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
