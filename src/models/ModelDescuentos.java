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
public class ModelDescuentos {

    DefaultTableModel modelo_Descuentos = new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

    public DefaultTableModel getModelo_Descuentos() {
        return modelo_Descuentos;
    }

    public void setModelo_Descuentos(DefaultTableModel modelo_Descuentos) {
        this.modelo_Descuentos = modelo_Descuentos;
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
    public String[] titulos = {"Codigo Descuento", "Porcentaje", "Cantidad de Puntos"}; //columnas de la tabla

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

    //Variables que corresponden a cada caja de texto
    private int verificar;
    private String Codigo_descuento;
    private String Porcentaje;
    private String Cantidad_puntos;

    public int getVerificar() {
        return verificar;
    }

    public void setVerificar(int verificar) {
        this.verificar = verificar;
    }

    public String getCodigo_descuento() {
        return Codigo_descuento;
    }

    public void setCodigo_descuento(String Codigo_descuento) {
        this.Codigo_descuento = Codigo_descuento;
    }

    public String getPorcentaje() {
        return Porcentaje;
    }

    public void setPorcentaje(String Porcentaje) {
        this.Porcentaje = Porcentaje;
    }

    public String getCantidad_puntos() {
        return Cantidad_puntos;
    }

    public void setCantidad_puntos(String cantidad_descuentos) {
        this.Cantidad_puntos = cantidad_descuentos;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    DefaultTableModel model; // variable que usa para el metodo de buscar

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public String Limpiar = " "; // variables para boton limpiar
    public int codigo = 0;
    public int cantidad = 0;

    public int getCantidad() {
        return cantidad;
    }

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

    private DefaultTableModel model_prov = new DefaultTableModel(); // variable que usa para el metodo de buscar

    public DefaultTableModel getModel_Descuentos() {
        return model_prov;
    }

    public void setModel_Descuentos(DefaultTableModel model_prov) {
        this.model_prov = model_prov;
    }

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
            rs = st.executeQuery("SELECT * FROM descuentos;");

            rs.first();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    public void Guardar_Nuevo() {
        //cada variable obtendra el valor actual de las cajas de texto 
        Codigo_descuento = this.getCodigo_descuento();
        Porcentaje = this.getPorcentaje();
        Cantidad_puntos = this.getCantidad_puntos();
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Guardar el NUEVO registro?");

        if (JOptionPane.OK_OPTION == confirmar) {
            try {
                st.executeUpdate("insert into descuentos (codigo_descuento,porcentaje,cantidad_puntos) values"
                        + "('" + Codigo_descuento + "','" + Porcentaje + "','" + Cantidad_puntos + "');");
                JOptionPane.showMessageDialog(null, "Guardado con exito ");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Error Nuevo no se puede guardar " + err.getMessage());
            }
        }
    }
//nuevo

    public void Guardar_Modificado() {
        //cada variable obtendra el valor actual de las cajas de texto 
        Codigo_descuento = this.getCodigo_descuento();
        Porcentaje = this.getPorcentaje();
        Cantidad_puntos = this.getCantidad_puntos();

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de MODIFICAR registro?");

        if (JOptionPane.OK_OPTION == confirmar) {
            try {
                st.executeUpdate("UPDATE descuentos SET porcentaje='" + Porcentaje + "',cantidad_puntos='" + Cantidad_puntos + "'WHERE codigo_descuento='" + Codigo_descuento + "';");
                JOptionPane.showMessageDialog(null, "El registro se modifico correctamente");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Error Nuevo no se puede guardar " + err.getMessage());
            }
        }
    }
    
    //Metodo mostar

    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT * FROM descuentos;");
        modelo_Descuentos.setColumnIdentifiers(new Object[]{"Codigo Descuento", "Porcentaje", "Cantidad de Puntos"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_Descuentos.addRow(new Object[]{
                    rs.getString("codigo_descuento"),
                    rs.getString("porcentaje"),
                    rs.getString("cantidad_puntos")});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
