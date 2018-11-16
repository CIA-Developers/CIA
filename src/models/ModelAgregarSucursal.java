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
 *
 * @author Octaviano
 */
public class ModelAgregarSucursal {
        DefaultTableModel AgregarSucursal = new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

    public DefaultTableModel getModelo_Proveedores() {
        return AgregarSucursal;
    }

    public void setModelo_Proveedores(DefaultTableModel modelo_EmCompras) {
        this.AgregarSucursal = AgregarSucursal;
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
    public String[] titulos = {"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Telefono", "Municipio", "calle", "Colonia", "Numero", "Correo"}; //columnas de la tabla

    public String[] getTitulos() {
        return titulos;
    }

    public void setTitulos(String[] titulos) {
        this.titulos = titulos;
    }

    public String[] registros = new String[50];

    public String[] getRegistros() {
        return registros;
    }

    public void setRegistros(String[] registros) {
        this.registros = registros;
    }

    public String sql;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    
}
