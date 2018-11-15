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
 * @author Octaviano
 */
public class ModelCOMPRAS {
    //******************************VARIABLES NECESARIAS PARA COMPRAS **********************
    
    //********Variables para compra *********
    public String RFC_empleado;
    public int numero_sucursal;
    public int numero_proveedor;
    public String nombre_proveedor; // solo se obtendra este dato, no se almacenara
    public float subtotal;
    public float iva;
    public float importe;
    //******Variables para detalle_compra********
    public int numero_compra;
    public String codigo_producto;
    public String nombre_producto;// solo se obtendra este dato, no se almacenara
    public String tipo_producto;// solo se obtendra este dato, no se almacenara
    public String marca_producto;// solo se obtendra este dato, no se almacenara
    public int cantidad_compra;
    public float precio_compra;
    public float total_por_producto;

    public String getRFC_empleado() {
        return RFC_empleado;
    }

    public void setRFC_empleado(String RFC_empleado) {
        this.RFC_empleado = RFC_empleado;
    }

    public int getNumero_sucursal() {
        return numero_sucursal;
    }

    public void setNumero_sucursal(int numero_sucursal) {
        this.numero_sucursal = numero_sucursal;
    }

    public int getNumero_proveedor() {
        return numero_proveedor;
    }

    public void setNumero_proveedor(int numero_proveedor) {
        this.numero_proveedor = numero_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public int getNumero_compra() {
        return numero_compra;
    }

    public void setNumero_compra(int numero_compra) {
        this.numero_compra = numero_compra;
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

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public int getCantidad_compra() {
        return cantidad_compra;
    }

    public void setCantidad_compra(int cantidad_compra) {
        this.cantidad_compra = cantidad_compra;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getTotal_por_producto() {
        return total_por_producto;
    }

    public void setTotal_por_producto(float total_por_producto) {
        this.total_por_producto = total_por_producto;
    }
    
    
    
}
