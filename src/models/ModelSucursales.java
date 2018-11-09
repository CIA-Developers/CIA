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
 * @author Octaviano
 */
public class ModelSucursales {
    DefaultTableModel modelo_sucursal= new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

    public DefaultTableModel getModelo_sucursal() {
        return modelo_sucursal;
    }

    public void setModelo_sucursal(DefaultTableModel modelo_sucursal) {
        this.modelo_sucursal = modelo_sucursal;
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
    public String[] titulos = {"No sucursal", "Calle", "Colonia", "Numero","Telefono", "Codigo_producto", "Nombre Producto", "Stock", "Stok maximo", "Stock minimo"}; //columnas de la tabla

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
    
    public String sql; //conexion a la Base de datos para la busqueda 

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    //Variables que corresponden a cada caja de texto
    public String sucursal;
    public String calle;
    public String colonia;
    public String numero;
    public String Telefono;
    public String codigo_producto;
    public String nombre_producto;
    public String stock;
    public String stock_maximo;
    public String Strock_minimo;

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
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

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getStock_maximo() {
        return stock_maximo;
    }

    public void setStock_maximo(String stock_maximo) {
        this.stock_maximo = stock_maximo;
    }

    public String getStrock_minimo() {
        return Strock_minimo;
    }

    public void setStrock_minimo(String Strock_minimo) {
        this.Strock_minimo = Strock_minimo;
    }
    
    //*************************Variables que corresponden a los BOTONES*************************************
    
    
      
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
     * se hace la conexion a la Base de datos y se hace la consulta hacia la tabla de sucursales 
     * que tiene una union con la tabla de sucursales_productos 
     * y finalmente con la tabla de produtos para obtener el nombre del producto
     * que se tiene en cada sucursal 
     */
    public void Conectar(){
             try{ 
                conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/stockcia","root","");                     
                st=conexion.createStatement(); 
                rs=st.executeQuery("SELECT sucursal.no_sucursal,productos.nom_producto, calle, colonia, numero, telefono,sucursal_productos.codigo_producto, existencias, limite_maximo, limite_minimo from sucursal inner join sucursal_productos on sucursal.no_sucursal = sucursal_productos.no_sucursal inner join productos on productos.codigo_producto = sucursal_productos.codigo_producto;");
                        
                rs.first();
                
            }catch(SQLException err){ 
                JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
            } 

    } 
    
    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT sucursal.no_sucursal,productos.nom_producto, calle, colonia, numero, telefono,sucursal_productos.codigo_producto, existencias, limite_maximo, limite_minimo from sucursal inner join sucursal_productos on sucursal.no_sucursal = sucursal_productos.no_sucursal inner join productos on productos.codigo_producto = sucursal_productos.codigo_producto;");
        modelo_sucursal.setColumnIdentifiers(new Object[]{"No sucursal", "Calle", "Colonia", "Numero","Telefono", "Codigo_producto", "Nombre Producto", "Stock", "Stok maximo", "Stock minimo"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_sucursal.addRow(new Object[]{rs.getString("sucursal.no_sucursal"), 
                    rs.getString("calle"),
                    rs.getString("colonia"), 
                    rs.getString("numero"), 
                    rs.getString("telefono"), 
                    rs.getString("sucursal_productos.codigo_producto"),
                    rs.getString("productos.nom_producto"),
                    rs.getString("existencias"),
                    rs.getString("limite_maximo"),
                    rs.getString("limite_minimo")});                                    
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void busqueda(){
        // consulta de la Base de datos 
        sql= "SELECT sucursal.no_sucursal,productos.nom_producto, calle, colonia, numero, telefono,sucursal_productos.codigo_producto, existencias, limite_maximo, limite_minimo from sucursal inner join sucursal_productos on sucursal.no_sucursal = sucursal_productos.no_sucursal inner join productos on productos.codigo_producto = sucursal_productos.codigo_producto "
                + "WHERE sucursal.no_sucursal'%" + sucursal + "%' "
                + "OR productos.nom_producto LIKE '%" + nombre_producto+ "%'"
                + "OR calle LIKE '%" + calle + "%'"
                + "OR colonia LIKE '%" + colonia + "%'"
                + "OR calle LIKE '%" + calle + "%'"
                + "OR telefono LIKE '%" + colonia + "%'"
                + "OR numero LIKE '%" + numero + "%'"
                + "OR telefono LIKE '%" + Telefono + "%'"
                + "OR sucursal_productos.codigo_producto LIKE '%" + codigo_producto + "%'"
                + "OR existencias LIKE '%" + stock + "%'"
                + "OR limite_maximo LIKE '%" + stock_maximo + "%'"
                + "OR limite_minimo LIKE '%" + Strock_minimo + "%'";
        model = new DefaultTableModel(null, titulos);
        Database cc = new Database();
        Connection cn = getConexion();
        try {
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) { //Registros sobre a los que se les realizara una busqueda 
                registros[0] = rs.getString("sucursal.no_sucursal");
                registros[1] = rs.getString("calle");
                registros[2] = rs.getString("colonia");
                registros[3] = rs.getString("numero"); 
                registros[4] = rs.getString("telefono");
                registros[5] = rs.getString("sucursal_productos.codigo_producto");
                registros[6] = rs.getString("productos.nom_producto");
                registros[7] = rs.getString("existencias");
                registros[8] = rs.getString("limite_maximo");
                registros[9] = rs.getString("limite_minimo");
                model.addRow(registros);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error00"+ ex);
        }         
    }
    //*****************METODOS DE BOTONES Nuevo, Borrar, Guardar y Modificar**************************
    
}
