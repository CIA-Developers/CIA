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
public class ModelPromociones {

    DefaultTableModel modelo_promocion = new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

    public DefaultTableModel getModelo_sucursal() {
        return modelo_promocion;
    }

    public void setModelo_sucursal(DefaultTableModel modelo_sucursal) {
        this.modelo_promocion = modelo_sucursal;
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

    public int columnaABuscar;
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
    private int verificar;
    private String no_promocion;
    private String causa;
    private String descuento;
    private String precion_descuento;
    private String unidad_medida;
    private String fecha_inicio;
    private String fecha_final;

    public int getVerificar() {
        return verificar;
    }

    public void setVerificar(int verificar) {
        this.verificar = verificar;
    }

    public String getNo_promocion() {
        return no_promocion;
    }

    public void setNo_promocion(String no_promocion) {
        this.no_promocion = no_promocion;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getPrecion_descuento() {
        return precion_descuento;
    }

    public void setPrecion_descuento(String precion_descuento) {
        this.precion_descuento = precion_descuento;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }
    public String Limpiar = " ";
    public int codigo = 0;

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

    public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/stockcia", "root", "");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * from promociones;");

            rs.first();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }

    }

    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT * FROM promociones;");
        modelo_promocion.setColumnIdentifiers(new Object[]{"No promocion", "Causa_promocion", "Descuento_promocion", "precio_descuento", "unidad_medida"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_promocion.addRow(new Object[]{rs.getString("no_promocion"),
                    rs.getString("causa"),
                    rs.getString("descuento"),
                    rs.getString("precio_descuento"),
                    rs.getString("unidad_medida")});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //*****************METODOS DE BOTONES Nuevo, Borrar, Guardar y Modificar**************************
    public void Guardar_Nuevo() {
        //cada variable obtendra el valor actual de las cajas de texto 
        no_promocion = this.getNo_promocion();
        causa = this.getCausa();
        descuento = this.getDescuento();
        precion_descuento = this.getPrecion_descuento();
        unidad_medida = this.getUnidad_medida();
        fecha_inicio = this.getFecha_inicio();
        fecha_final = this.getFecha_final();
        
    int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Guardar el NUEVO registro?");

    if (JOptionPane.OK_OPTION == confirmar

        ) {
            try {
            st.executeUpdate("insert into prociones(id_promociones,causa_promocion,des_promocion,precio_descuento,unidad_medida) values"
                    + "('" + no_promocion + "','" + causa + "','" + descuento + "','" + precion_descuento + "','" + unidad_medida + "');");

            JOptionPane.showMessageDialog(null, "Guardado con exito ");
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error Nuevo no se puede guardar " + err.getMessage());
        }
    }
    }   public void Guardar_Modificado() {
        //cada variable obtendra el valor actual de las cajas de texto 
        no_promocion = this.getNo_promocion();
        causa = this.getCausa();
        descuento = this.getDescuento();
        precion_descuento = this.getPrecion_descuento();
        unidad_medida = this.getUnidad_medida();
        fecha_inicio = this.getFecha_inicio();
        fecha_final = this.getFecha_final();

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de MODIFICAR registro?");

        if (JOptionPane.OK_OPTION == confirmar) {
            try {
                st.executeUpdate("UPDATE sucursal SET causa='" + causa + "',descuento='" + descuento+ "',precion_descuento='" + precion_descuento + "',unidad_medida='" + unidad_medida +  "'WHERE id_promociones='" + no_promocion + "';");
                JOptionPane.showMessageDialog(null, "El registro se modifico correctamente");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Error Nuevo no se puede guardar " + err.getMessage());
            }
        }
    }
}
//nuevo
