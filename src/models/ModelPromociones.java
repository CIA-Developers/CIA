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
import java.util.ArrayList;
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

    public DefaultTableModel getModelo_promocion() {
        return modelo_promocion;
    }

    public void setModelo_promocion(DefaultTableModel modelo_promocion) {
        this.modelo_promocion = modelo_promocion;
    }

    public int rec;//Variable que tomara el valor seleccionado en la tabla 

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }
    public String[] titulos = {"No promocion", "Causa", "Descuento", "precio_descuento", "unidad de medida", "codigo del producto", "fecha_inicio", "fecha_final"}; //columnas de la tabla

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
    private ArrayList producto;
    private String no_promocion;
    private String causa;
    private String descuento;
    private String precion_descuento;
    private String unidad_medida;
    private String codigo_producto;
    private String fecha_inicio;
    private String fecha_final;
    private String nombre_producto;// solo se obtendra este dato, no se almacenara
    private String precio_unitario_venta;// solo se obtendra este dato, no se almacenara
    private String marca_producto;// solo se obtendra este dato, no se almacenara

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

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getPrecio_unitario_venta() {
        return precio_unitario_venta;
    }

    public void setPrecio_unitario_venta(String precio_unitario_venta) {
        this.precio_unitario_venta = precio_unitario_venta;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public ArrayList getProducto() {
        return producto;
    }

    public void setProducto(ArrayList producto) {
        this.producto = producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
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
            rs = st.executeQuery("SELECT promociones.id_promociones,causa_promocion, desc_promocion,precio_descuento, promociones.unidad_medida, promocion_prod.codigo_producto, promocion_prod.fecha_inicio, promocion_prod.fecha_final from promociones inner join promocion_prod on promociones.id_promociones = promocion_prod.id_promociones;");
            rs.first();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }

    }
///////////////////////////////////////////////////////////////

    public void llenarCombo() {
        ArrayList codigo = new ArrayList();
        try {
            rs = st.executeQuery("SELECT * FROM productos;");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error4 al llenar comboBox" + e);
        }
        try {
            while (rs.next()) {
                String sucursal = rs.getString("codigo_producto");
                codigo.add(sucursal);//agregar los datos a la lista        
            }
            this.setProducto(codigo);// almacena la lista con los numeros de proveedores obetenidos de la BD      
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error5 al llenar comboBox" + e);
        }
    }

    public void llenarTextFieldsProductos() {
        try {
            codigo_producto = this.getCodigo_producto();
            rs = st.executeQuery("SELECT * FROM productos WHERE codigo_producto='" + codigo_producto + "';");//consulta a empleaddos compras
            rs.next();
            nombre_producto = rs.getString("nom_producto");
            marca_producto = rs.getString("marca");
            precio_unitario_venta = rs.getString("precio_unitario_venta");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error8 al llenarTextFields" + e);
        }
    }

    ////////////////////////////////////////////
    public void mostrar() {
        ResultSet rs = Database.getTabla("SELECT promociones.id_promociones,causa_promocion, desc_promocion,precio_descuento, promociones.unidad_medida, promocion_prod.codigo_producto, promocion_prod.fecha_inicio, promocion_prod.fecha_final from promociones inner join promocion_prod on promociones.id_promociones = promocion_prod.id_promociones;");
        modelo_promocion.setColumnIdentifiers(new Object[]{"No promocion", "Causa", "Descuento", "precio_descuento", "unidad de medida", "codigo del producto", "fecha_inicio", "fecha_final"});
        try {
            while (rs.next()) {
                // añade los resultado a al modelo de tabla 
                modelo_promocion.addRow(new Object[]{rs.getString("promociones.id_promociones"),
                    rs.getString("causa_promocion"),
                    rs.getString("desc_promocion"),
                    rs.getString("precio_descuento"),
                    rs.getString("unidad_medida"),
                    rs.getString("codigo_producto"),
                    rs.getString("fecha_inicio"),
                    rs.getString("fecha_final")});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
