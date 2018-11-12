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
public class ModelProveedores {

    DefaultTableModel modelo_proveedores = new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

    public DefaultTableModel getModelo_Proveedores() {
        return modelo_proveedores;
    }

    public void setModelo_Proveedores(DefaultTableModel modelo_EmCompras) {
        this.modelo_proveedores = modelo_proveedores;
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
    //Variables que corresponden a cada caja de texto
    public String id;
    public String nombre;
    public String ap_pat;
    public String ap_mat;
    public String Telefono;
    public String calle;
    public String colonia;
    public String numero;
    public String provincia;
    public String correo;

    public DefaultTableModel getModelo_proveedores() {
        return modelo_proveedores;
    }

    public void setModelo_proveedores(DefaultTableModel modelo_proveedores) {
        this.modelo_proveedores = modelo_proveedores;
    }

    public String getId() {
        return id;
    }

    public void setRfc(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_pat() {
        return ap_pat;
    }

    public void setAp_pat(String ap_pat) {
        this.ap_pat = ap_pat;
    }

    public String getAp_mat() {
        return ap_mat;
    }

    public void setAp_mat(String ap_mat) {
        this.ap_mat = ap_mat;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getprovincia() {
        return provincia;
    }

    public void setprovincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public DefaultTableModel getModel_prov() {
        return model_prov;
    }

    public void setModel_prov(DefaultTableModel model_prov) {
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
            rs = st.executeQuery("SELECT id_proveedor, nombre_prov, ap_pat_prov, ap_mat_prov, telefono_prov, calle_prov,colonia_prov, numero_prov, provincia_prov, correo_prov FROM proveedores;");

            rs.first();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    public void Guardar_Nuevo() {
        //cada variable obtendra el valor actual de las cajas de texto 
        id = this.getId();
        nombre = this.getNombre();
        ap_pat = this.getAp_pat();
        ap_mat = this.getAp_mat();
        Telefono = this.getTelefono();
        calle = this.getCalle();
        colonia = this.getColonia();
        numero = this.getNumero();
        provincia = this.getprovincia();
        correo = this.getCorreo();

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Guardar el NUEVO registro?");

        if (JOptionPane.OK_OPTION == confirmar) {
            try {
                st.executeUpdate("insert into productos (id_proveedor,nombre_prov,ap_pat_prov,ap_mat_prov,telefono_prov,calle_prov,colonia_prov,numero_prov,provincia_prov) values"
                        + "('" + id + "','" + nombre + "','" + ap_pat + "','" + ap_mat + "','" + Telefono + "','" + calle + "','" + colonia + "','" + numero + "','" + provincia + "','" + correo+"');"); 
                JOptionPane.showMessageDialog(null, "Guardado con exito ");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Error Nuevo no se puede guardar " + err.getMessage());
            }
        }
    }

    
    
    
//Metodo Buscar 
    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT id_proveedor, nombre_prov, ap_pat_prov, ap_mat_prov, telefono_prov, calle_prov, colonia_prov, numero_prov, provincia_prov, correo_prov FROM proveedores;");
        modelo_proveedores.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellido Paterno", "Apellido Materno", "telefono", "calle", "Colonia", "Numero", "Provincia", "Correo"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_proveedores.addRow(new Object[]{
                    rs.getString("id_proveedor"),
                    rs.getString("nombre_prov"),
                    rs.getString("ap_pat_prov"),
                    rs.getString("ap_mat_prov"),
                    rs.getString("telefono_prov"),
                    rs.getString("calle_prov"),
                    rs.getString("colonia_prov"),
                    rs.getString("numero_prov"),
                    rs.getString("provincia_prov"),
                    rs.getString("correo_prov")});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//Meotod de Busqueda 

    public void busqueda() {
        // consulta de la Base de datos 
        sql = "SELECT id_proveedor, nombre_prov, ap_pat_prov, ap_mat_prov, telefono_prov, calle_prov, colonia_prov, numero_prov, provincia_prov, correo_prov FROM proveedores;"
                + "WHERE id_proveedor'%" + id + "%' "
                + "OR nombre_prov LIKE '%" + nombre + "%'"
                + "OR ap_pat_prov LIKE '%" + ap_pat + "%'"
                + "OR ap_mat_prov LIKE '%" + ap_mat + "%'"
                + "OR telefono_prov LIKE '%" + Telefono + "%'"
                + "OR calle_prov LIKE '%" + calle + "%'"
                + "OR colonia_prov LIKE '%" + colonia + "%'"
                + "OR numero_prov LIKE '%" + numero + "%'"
                + "OR provincia_prov LIKE '%" + provincia + "%'"
                + "OR correo_prov LIKE '%" + correo + "%'";
        model = new DefaultTableModel(null, titulos);
        Database cc = new Database();
        Connection cn = getConexion();
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) { //Registros sobre a los que se les realizara una busqueda 
                registros[0] = rs.getString("id_proveedor");
                registros[1] = rs.getString("nombre_prov");
                registros[2] = rs.getString("ap_pat");
                registros[3] = rs.getString("ap_mat");
                registros[4] = rs.getString("telefono_prov");
                registros[5] = rs.getString("calle_prov");
                registros[6] = rs.getString("colonia_prov");
                registros[7] = rs.getString("numero_prov");
                registros[8] = rs.getString("provincia_prov");
                registros[9] = rs.getString("correo_prov");
                model.addRow(registros);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error00" + ex);
        }
    }
    //*****************METODOS DE BOTONES Nuevo, Borrar, Guardar y Modificar**************************

}
