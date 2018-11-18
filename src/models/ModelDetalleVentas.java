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
public class ModelDetalleVentas {
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
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/stockcia", "root", "");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT ventas.id_ventas, fecha_venta, RFC_cliente, RFC_empleado, no_sucursal, codigo_descuento, puntos_ganados, detalle_ventas.Id_detalle_venta, codigo_producto, cantidad, precio_venta, total_producto FROM ventas INNER JOIN detalle_ventas ON ventas.id_ventas = detalle_ventas.id_ventas");

            rs.first();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }

    }
    
    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT ventas.id_ventas, fecha_venta, RFC_cliente, RFC_empleado, no_sucursal, codigo_descuento, puntos_ganados, detalle_ventas.Id_detalle_venta, codigo_producto, cantidad, precio_venta, total_producto FROM ventas INNER JOIN detalle_ventas ON ventas.id_ventas = detalle_ventas.id_ventas");
        modelo_detalle_compra.setColumnIdentifiers(new Object[]{"Id venta", "Fecha venta","RFC cliente","RFC empleado", "No sucursal", "Codigo descuento", "Puntos ganados", "Id detalle venta", "Cantidad", "Precio venta", "Total"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_detalle_compra.addRow(new Object[]{
                    rs.getString("ventas.id_ventas"),
                    rs.getString("fecha_venta"),
                    rs.getString("RFC_cliente"),
                    rs.getString("RFC_empleado"),
                    rs.getString("no_sucursal"),
                    rs.getString("codigo_descuento"),
                    rs.getString("puntos_ganados"),
                    rs.getString("detalle_venta.Id_detalle_venta"),
                    rs.getString("codigo_producto"),
                    rs.getString("cantidad"),
                    rs.getString("precio_venta"),
                    rs.getString("total_producto")});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}