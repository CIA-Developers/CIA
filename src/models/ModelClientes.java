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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Familia Hernández
 */
public class ModelClientes {

    DefaultTableModel modelo_clientes = new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

    public DefaultTableModel getModelo_Proveedores() {
        return modelo_clientes;
    }

    public void setModelo_Proveedores(DefaultTableModel modelo_EmCompras) {
        this.modelo_clientes = modelo_clientes;
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
    public String[] titulos = {"RFC", "Nombre", "Apellido Paterno", "Apellido Materno", "Telefono", "Municipio", "calle", "Colonia", "Numero", "Correo"}; //columnas de la tabla

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
    public int verificar;
    public String puntos;
    public String rfc;
    public String nombre;
    public String ap_pat;
    public String ap_mat;
    public String Telefono;
    public String calle;
    public String colonia;
    public String numero;
    public String municipio;
    public String correo;

    public DefaultTableModel getModelo_clientes() {
        return modelo_clientes;
    }

    public void setModelo_clientes(DefaultTableModel modelo_proveedores) {
        this.modelo_clientes = modelo_proveedores;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String rfc) {
        this.puntos = puntos;
    }

    public int getVerificar() {
        return verificar;
    }

    public void setVerificar(int verificar) {
        this.verificar = verificar;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
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

    private DefaultTableModel model_clientes = new DefaultTableModel(); // variable que usa para el metodo de buscar

    public DefaultTableModel getModel_prov() {
        return model_clientes;
    }

    public void setModel_prov(DefaultTableModel model_prov) {
        this.model_clientes = model_prov;
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
            rs = st.executeQuery("SELECT * FROM clientes ;");

            rs.first();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }

    }
    // Mostar datos de Tabla

    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT * FROM clientes ;");;
        modelo_clientes.setColumnIdentifiers(new Object[]{"RFC", "Nombre", "Apellido Paterno", "Apellido Materno", "Telefono", "Municipio", "Calle", "Colonio", "Numero", "Correo", "Puntos"});
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
                    rs.getString("correo_client"),
                    rs.getString("puntos")});
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void Guardar_Nuevo() {
        //cada variable obtendra el valor actual de las cajas de texto 
        rfc = this.getRfc();
        nombre = this.getNombre();
        ap_pat = this.getAp_pat();
        ap_mat = this.getAp_mat();
        Telefono = this.getTelefono();
        calle = this.getCalle();
        colonia = this.getColonia();
        numero = this.getNumero();
        municipio = this.getMunicipio();
        correo = this.getCorreo();
      

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Guardar el NUEVO registro?");

        if (JOptionPane.OK_OPTION == confirmar) {
            try {
                st.executeUpdate("insert into clientes (RFC_cliente,nombre_client,ap_pat_client,ap_mat_client,telefono_client,municipio_client,calle_client,colonia_client,numero_client,correo_client) values"
                        + "('" + rfc + "','" + nombre + "','" + ap_pat + "','" + ap_mat + "','" + Telefono + "','" + municipio + "','" + calle + "','" + colonia + "','" + numero + "','" + correo + "');");
                JOptionPane.showMessageDialog(null, "Guardado con exito ");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Error Nuevo no se puede guardar " + err.getMessage());
            }
        }
    }

    public void Guardar_Modificado() {
        //cada variable obtendra el valor actual de las cajas de texto 
        rfc = this.getRfc();
        nombre = this.getNombre();
        ap_pat = this.getAp_pat();
        ap_mat = this.getAp_mat();
        Telefono = this.getTelefono();
        calle = this.getCalle();
        colonia = this.getColonia();
        numero = this.getNumero();
        municipio = this.getMunicipio();
        correo = this.getCorreo();
    

        
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de MODIFICAR registro?");
        
        if(JOptionPane.OK_OPTION==confirmar) {
            try{
               st.executeUpdate("UPDATE clientes SET nombre_client='"+nombre+"',ap_pat_client='"+ap_pat+"',ap_mat_client='"+ap_mat+"',telefono_client='"+Telefono+"',municipio_client='"+municipio+"',calle_client='"+calle+"',colonia_client='"+colonia+"' ,numero_client='"+numero+"',correo_client='"+correo+"'WHERE RFC_cliente='"+rfc+"';");
               JOptionPane.showMessageDialog(null,"El registro se modifico correctamente");
            } catch(Exception err) 
            { 
                JOptionPane.showMessageDialog(null,"Error Nuevo no se puede guardar "+err.getMessage()); 
            }
        }
    }  
}
