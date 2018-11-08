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
 * @author Familia Hernández
 */
public class ModelClientes {

    DefaultTableModel modelo_clientes = new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

    public DefaultTableModel getModelo_Clientes() {
        return modelo_clientes;
    }

    public void setModelo_Clientes(DefaultTableModel modelo_EmCompras) {
        this.modelo_clientes = modelo_EmCompras;
    }
    public int rec;//Variable que tomara el valor seleccionado en la tabla 

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }

    DefaultTableModel model;
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    PreparedStatement ps;

    /**
     * se hace la conexion a la Base de datos y se hace la consulta hacia la
     * tabla de EmpleadosCompras que tiene una union con la tabla de compra
     *
     */
    public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/stockcia", "root", "");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT RFC_cliente, nombre_client, ap_pat_client, ap_mat_client, telefono_client, municipio_client, calle_client, colonia_client, numero_client, correo_client FROM clientes ;");

            rs.first();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }

    }

    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT RFC_cliente, nombre_client, ap_pat_client, ap_mat_client, telefono_client, municipio_client, calle_client, colonia_client, numero_client, correo_client FROM clientes ;");
        modelo_clientes.setColumnIdentifiers(new Object[]{"RFC", "Nombre", "Apellido Paterno", "Apellido Materno", "Telefono", "Municipio", "Calle", "Colonio", "Numero", "Correo"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_clientes.addRow(new Object[]{
                    rs.getString("RFC_cliente"),
                    rs.getString("nombre_client"),
                    rs.getString("ap_pat_client"),
                    rs.getString("ap_mat_client"),
                    rs.getString("telefono_client"),
                    rs.getString("municipio_client"),
                    rs.getString("calle_client"),
                    rs.getString("colonia_client"),
                    rs.getString("numero_client"),
                    rs.getString("correo_client")});
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
