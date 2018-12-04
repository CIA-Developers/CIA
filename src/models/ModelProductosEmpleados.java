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
import javax.swing.table.TableRowSorter;
/**
/**
 *
 * @author Octaviano
 */
public class ModelProductosEmpleados {
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
    
    
    
    
     /**
     * Variables para el metodo de busqueda
     */   
    private TableRowSorter trsFiltro; // sirve para filtar los datos dentro de la tabla

    public TableRowSorter getTrsFiltro() {
        return trsFiltro;
    }

    public void setTrsFiltro(TableRowSorter trsFiltro) {
        this.trsFiltro = trsFiltro;
    }
    
    public int columnaABuscar = 0; //solo buscara en la primer columa que pertenece al codigo de producto
    public String cadena;

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    public int getColumnaABuscar() {
        return columnaABuscar;
    }

    public void setColumnaABuscar(int columnaABuscar) {
        this.columnaABuscar = columnaABuscar;
    }
    
    
    
    
    //************************Variables que pertenecen a las cajas de Texto********************************
    public int verificar; // variable que nos ayudara a ver si se inserto un nuevo registro o se midificara
    public String codigo_producto;
    public String nombre_producto;
    public String tipo_producto;
    public String marca;
    public float precio_unitario;
    public int stock_total=0;
    public String unidad_medida;
    public String status;
    public String descripcion;

    public int getStock_total() {
        return stock_total;
    }

    public void setStock_total(int stock_total) {
        this.stock_total = stock_total;
    }
    
    

    public int getVerificar() {
        return verificar;
    }

    public void setVerificar(int verificar) {
        this.verificar = verificar;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    
    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    //*************************Variables que corresponden a los BOTONES*************************************
    
    public String Limpiar=" ";
    public int cantidad =0;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getLimpiar() {
        return Limpiar;
    }

    public void setLimpiar(String Limpiar) {
        this.Limpiar = Limpiar;
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
                conexion=DriverManager.getConnection("jdbc:mysql://raspberry-tic41.zapto.org:3306/StockCia", "tic41", "tic41");                     
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
   //*****************METODOS DE BOTONES Nuevo, Borrar, Guardar y Modificar**************************
    public void Guardar_Nuevo(){
        //cada variable obtendra el valor actual de las cajas de texto 
        codigo_producto=this.getCodigo_producto();
        nombre_producto=this.getNombre_producto();
        tipo_producto=this.getTipo_producto();
        marca=this.getMarca();
        precio_unitario=this.getPrecio_unitario();
        unidad_medida=this.getUnidad_medida();
        status=this.getStatus();
        descripcion=this.getDescripcion();
        
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Guardar el NUEVO registro?");
        
        if(JOptionPane.OK_OPTION==confirmar) {
            try{
            st.executeUpdate("insert into productos (codigo_producto,nom_producto,tipo_producto,marca,precio_unitario_venta,unidad,descripcion,	existencia_total,status_prod) values"
                    + "('"+codigo_producto+"','"+nombre_producto+"','"+tipo_producto+"','"+marca+"','"+precio_unitario+"','"+unidad_medida+"','"+descripcion+"','"+stock_total+"','"+status+"');"); 
                JOptionPane.showMessageDialog(null,"Guardado con exito ");
            } catch(Exception err) 
            { 
                JOptionPane.showMessageDialog(null,"Error Nuevo no se puede guardar "+err.getMessage()); 
            }
        }
    }
    
    public void Guardar_Modificado(){
        //cada variable obtendra el valor actual de las cajas de texto 
        codigo_producto=this.getCodigo_producto();
        nombre_producto=this.getNombre_producto();
        tipo_producto=this.getTipo_producto();
        marca=this.getMarca();
        precio_unitario=this.getPrecio_unitario();
        unidad_medida=this.getUnidad_medida();
        status=this.status;
        descripcion=this.getDescripcion();
        
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de MODIFICAR registro?");
        
        if(JOptionPane.OK_OPTION==confirmar) {
            try{
               st.executeUpdate("UPDATE productos SET nom_producto='"+nombre_producto+"',tipo_producto='"+tipo_producto+"',marca='"+marca+"',precio_unitario_venta='"+precio_unitario+"',unidad='"+unidad_medida+"',status_prod='"+status+"',descripcion='"+descripcion+"' WHERE codigo_producto='"+codigo_producto+"';");
               JOptionPane.showMessageDialog(null,"El registro se modifico correctamente");
            } catch(Exception err) 
            { 
                JOptionPane.showMessageDialog(null,"Error Nuevo no se puede guardar "+err.getMessage()); 
            }
        }
    }   
}



