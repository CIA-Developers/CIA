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
 * @author Octaviano
 */
public class ModelSucursalesEmpleados {
        DefaultTableModel modelo_sucursal = new DefaultTableModel(); //la variable modelo almacenara los tados de la tabla

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

    //Variables que corresponden a cada caja de texto
    public int verificar;
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

    public int getVerificar() {
        return verificar;
    }

    public void setVerificar(int verificar) {
        this.verificar = verificar;
    }

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

    /**
     * se hace la conexion a la Base de datos y se hace la consulta hacia la
     * tabla de sucursales que tiene una union con la tabla de
     * sucursales_productos y finalmente con la tabla de produtos para obtener
     * el nombre del producto que se tiene en cada sucursal
     */
    public void Conectar() {
        try {
            conexion =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/stockcia","root","");
            //conexion = DriverManager.getConnection("jdbc:mysql://raspberry-tic41.zapto.org:3306/StockCia", "tic41", "tic41");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT sucursal.no_sucursal,productos.nom_producto, calle, colonia, numero, telefono,sucursal_productos.codigo_producto, existencias, limite_maximo, limite_minimo from sucursal inner join sucursal_productos on sucursal.no_sucursal = sucursal_productos.no_sucursal inner join productos on productos.codigo_producto = sucursal_productos.codigo_producto;");

            rs.first();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }

    }

    public void Guardar_Nuevo() {
        //cada variable obtendra el valor actual de las cajas de texto 
        sucursal = this.getSucursal();
        calle = this.getCalle();
        colonia = this.getColonia();
        numero = this.getTelefono();
        codigo_producto = this.getCodigo_producto();
        nombre_producto = this.getNombre_producto();
        stock = this.getStock();
        stock_maximo = this.getStock_maximo();
        Strock_minimo = this.getStrock_minimo();

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de Guardar el NUEVO registro?");

        if (JOptionPane.OK_OPTION == confirmar) {
            try {
                st.executeUpdate("insert into sucursal(no_sucursal,calle,colonia,numero,telefono) values"
                        + "('" + sucursal + "','" + calle + "','" + colonia + "','" + numero + "','" + Telefono + "');");
                
                
                
                
                JOptionPane.showMessageDialog(null, "Guardado con exito ");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Error Nuevo no se puede guardar " + err.getMessage());
            }
        }
    }
//nuevo

    public void Guardar_Modificado() {
        //cada variable obtendra el valor actual de las cajas de texto 
        sucursal = this.getSucursal();
        calle = this.getCalle();
        colonia = this.getColonia();
        numero = this.getTelefono();
        codigo_producto = this.getCodigo_producto();
        nombre_producto = this.getNombre_producto();
        stock = this.getStock();
        stock_maximo = this.getStock_maximo();
        Strock_minimo = this.getStrock_minimo();

        int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de MODIFICAR registro?");

        if (JOptionPane.OK_OPTION == confirmar) {
            try {
                st.executeUpdate("UPDATE sucursal SET calle='" + calle + "',colonia='" + colonia + "',numero='" + numero + "',telefono='" + Telefono + "',colonia='" + colonia + "',numero='" + numero + "'WHERE no_sucursal='" + sucursal + "';");
                JOptionPane.showMessageDialog(null, "El registro se modifico correctamente");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Error Nuevo no se puede guardar " + err.getMessage());
            }
        }
    }

    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT sucursal.no_sucursal,productos.nom_producto, calle, colonia, numero, telefono,sucursal_productos.codigo_producto, existencias, limite_maximo, limite_minimo from sucursal inner join sucursal_productos on sucursal.no_sucursal = sucursal_productos.no_sucursal inner join productos on productos.codigo_producto = sucursal_productos.codigo_producto;");
        modelo_sucursal.setColumnIdentifiers(new Object[]{"No sucursal", "Calle", "Colonia", "Numero", "Telefono", "Codigo_producto", "Nombre Producto", "Stock", "Stok maximo", "Stock minimo"});
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

    //*****************METODOS DE BOTONES Nuevo, Borrar, Guardar y Modificar**************************
}


