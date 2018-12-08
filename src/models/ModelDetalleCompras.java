/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import conectar_tablas.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Ami
 */
public class ModelDetalleCompras {
    public String nombre_producto;
    public String producto_menor;
    public String nombre_empleado;
    public String apellido_paterno;
    public String apellido_materno;

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getProducto_menor() {
        return producto_menor;
    }

    public void setProducto_menor(String producto_menor) {
        this.producto_menor = producto_menor;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }
    
     //la variable modelo almacenara los tados de la tabla
    DefaultTableModel modelo_detalle_compra = new DefaultTableModel();

    public DefaultTableModel getModelo_detalle_compra() {
        return modelo_detalle_compra;
    }

    public void setModelo_detalle_compra(DefaultTableModel modelo_detalle_compra) {
        this.modelo_detalle_compra = modelo_detalle_compra;
    }

     public int rec;//Variable que tomara el valor seleccionado en la tabla 

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }
    
    public String Limpiar = " ";

    public String getLimpiar() {
        return Limpiar;
    }

    public void setLimpiar(String Limpiar) {
        this.Limpiar = Limpiar;
    }
    
     public int date;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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
    
    public int columnaABuscar;
    public String cadena;

    public int getColumnaABuscar() {
        return columnaABuscar;
    }

    public void setColumnaABuscar(int columnaABuscar) {
        this.columnaABuscar = columnaABuscar;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    DefaultTableModel model = new DefaultTableModel(); // variable que usa para el metodo de buscar

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
    
    //Metodos para buscar por rango de fecha
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    PreparedStatement ps;


 /**
     * se hace la conexion a la Base de datos y se hace la consulta hacia la
     * tabla de compras que tiene una union con la tabla de
     * detalle compras y que a su ves esta conectada con la tabla de productos
     */
    public void Conectar() {
        try {
            conexion =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/stockcia","root","");
            //conexion = DriverManager.getConnection("jdbc:mysql://raspberry-tic41.zapto.org:3306/StockCia", "tic41", "tic41");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT compra.id_compra, fecha_compra, RFC_empleado_comp, detalle_compra.id_detalle_compra, codigo_producto_comp, cantidad_comp, precio_comp, total_producto_comp FROM compra INNER JOIN detalle_compra ON compra.id_compra = detalle_compra.id_compra;");

            rs.first();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }

    }
    
    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT compra.id_compra, fecha_compra, RFC_empleado_comp, detalle_compra.id_detalle_compra, codigo_producto_comp, cantidad_comp, precio_comp, total_producto_comp FROM compra INNER JOIN detalle_compra ON compra.id_compra = detalle_compra.id_compra");
        modelo_detalle_compra.setColumnIdentifiers(new Object[]{"Id compra", "Fecha compra","RFC empleado", "Id detalle compra", "Codigo producto", "Cantidad", "Precio individual", "Total"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_detalle_compra.addRow(new Object[]{
                    rs.getString("compra.id_compra"),
                    rs.getString("fecha_compra"),
                    rs.getString("RFC_empleado_comp"),
                    rs.getString("detalle_compra.id_detalle_compra"),
                    rs.getString("detalle_compra.codigo_producto_comp"),
                    rs.getString("detalle_compra.cantidad_comp"),
                    rs.getString("detalle_compra.precio_comp"),
                    rs.getString("detalle_compra.total_producto_comp")});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void mostrarProducto(){
        try{
        rs = st.executeQuery("select codigo_producto_comp,nom_producto, count(codigo_producto_comp) as cantidad from detalle_compra inner join productos on detalle_compra.codigo_producto_comp = productos.codigo_producto group by codigo_producto order by cantidad desc");//consulta a descuentos
        rs.first();
        nombre_producto = rs.getString("nom_producto"); 
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void mostrarProductoMenor(){
        try{
            rs = st.executeQuery("select codigo_producto_comp,nom_producto, count(codigo_producto_comp) as cantidad from detalle_compra inner join productos on detalle_compra.codigo_producto_comp = productos.codigo_producto group by codigo_producto order by cantidad desc");//consulta a descuentos
            rs.last();
            producto_menor = rs.getString("nom_producto"); 
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void mostrarComprador(){
        try{
           rs = st.executeQuery("select RFC_empleado_comp,nombre_empl_comp,ap_pat_comp,ap_mat_comp, count(RFC_empleado_comp) as cantidad from compra inner join empleados_compras on compra.RFC_empleado_comp = empleados_compras.RFC_empl_comp group by RFC_empleado_comp order by cantidad desc");//consulta a descuentos
            rs.first();
            nombre_empleado = rs.getString("nombre_empl_comp");
            apellido_paterno = rs.getString("ap_pat_comp");
            apellido_materno = rs.getString("ap_mat_comp");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
