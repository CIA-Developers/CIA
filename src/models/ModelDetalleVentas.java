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
    
}