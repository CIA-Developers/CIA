/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import models.ModelCOMPRAS;
import views.ViewCOMPRAS;
/**
 *
 * @author Octaviano
 */
public class ControllerCOMPRAS {
    ModelCOMPRAS modelCOMPRAS;
    ViewCOMPRAS viewCOMPRAS;
    
    ActionListener list = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewCOMPRAS.jcb_numero_proveedor){
               modelCOMPRAS.setId_proveedor(Integer.parseInt((String)viewCOMPRAS.jcb_numero_proveedor.getSelectedItem()));
               modelCOMPRAS.llenarTextFieldsProveedor();
               viewCOMPRAS.jtf_nombre_proveedor.setText(modelCOMPRAS.getNombre_proveedor()+"  "+modelCOMPRAS.getApell_pat_proveedor()+"  "+modelCOMPRAS.getApell_mat_proveedor());
               viewCOMPRAS.jtf_telefono_proveedor.setText(modelCOMPRAS.getTelefono_proveedor());
               viewCOMPRAS.jcb_codigo_producto.setEnabled(true);//habilitando jcb productos
            }
            else if (e.getSource() == viewCOMPRAS.jcb_rfc){
                modelCOMPRAS.setRFC_empleado((String) viewCOMPRAS.jcb_rfc.getSelectedItem());
                modelCOMPRAS.llenarTextFieldsEmpleados();
                viewCOMPRAS.jtf_nombre_empleado.setText(modelCOMPRAS.getNombre_empleado()+"  "+modelCOMPRAS.getApellido_pat_empleado()+"  "+modelCOMPRAS.getApellido_mat_empleado());
                viewCOMPRAS.jcb_numero_sucursal.setEnabled(true);//habilitando jcb numero sucursal
            }
            else if (e.getSource() == viewCOMPRAS.jcb_codigo_producto){
                modelCOMPRAS.setCodigo_producto((String) viewCOMPRAS.jcb_codigo_producto.getSelectedItem());
                modelCOMPRAS.llenarTextFieldsProductos();
                viewCOMPRAS.jtf_nombre_producto.setText(modelCOMPRAS.getNombre_producto());
                viewCOMPRAS.jtf_tipo_producto.setText(modelCOMPRAS.getTipo_producto());
                viewCOMPRAS.jtf_marca_producto.setText(modelCOMPRAS.getMarca_producto());
                //habilitar cajas de texto
                viewCOMPRAS.jtf_cantidad.setEditable(true);
                viewCOMPRAS.jtf_precio.setEditable(true);
                //hablitar botones
                viewCOMPRAS.jb_agregar.setEnabled(true);
            }
            else if (e.getSource() == viewCOMPRAS.jcb_numero_sucursal){
                viewCOMPRAS.jcb_numero_proveedor.setEnabled(true);//habilitando jcb numero de proveedor
            }
        }
        
    };
    
    KeyListener key = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getSource() == viewCOMPRAS.jtf_cantidad || e.getSource() == viewCOMPRAS.jtf_precio){
               TotalProducto();
            }
           
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
        
    };

    public ControllerCOMPRAS(ModelCOMPRAS modelCOMPRAS, ViewCOMPRAS viewCOMPRAS) {
        this.modelCOMPRAS = modelCOMPRAS;
        this.viewCOMPRAS = viewCOMPRAS;
        
        viewCOMPRAS.jtf_cantidad.addKeyListener(key);
        viewCOMPRAS.jtf_precio.addKeyListener(key);
        
        modelCOMPRAS.Conectar();// conexion a la BD
        initComponents();
        llenadoCombos();
        setActionListener(); 
        deshabiltarObjetos();
        
    }

    public void initComponents(){
        viewCOMPRAS.jcb_numero_proveedor.removeAllItems();//eliminar los items del comboBbx
        viewCOMPRAS.jcb_numero_sucursal.removeAllItems();
        viewCOMPRAS.jcb_rfc.removeAllItems();
        viewCOMPRAS.jcb_codigo_producto.removeAllItems();
        
    }
    public void setActionListener(){
        viewCOMPRAS.jcb_numero_proveedor.addActionListener(list);
        viewCOMPRAS.jcb_rfc.addActionListener(list);
        viewCOMPRAS.jcb_codigo_producto.addActionListener(list);
        viewCOMPRAS.jcb_numero_sucursal.addActionListener(list);      
    }
    public void llenadoCombos(){
        modelCOMPRAS.llenarCombo();
        for (int p = 0; p < modelCOMPRAS.getNumero_proveedor().size(); p++) {
            viewCOMPRAS.jcb_numero_proveedor.addItem((String) modelCOMPRAS.getNumero_proveedor().get(p));
        }
        for (int s = 0; s < modelCOMPRAS.getNumero_sucursal().size(); s++) {
            viewCOMPRAS.jcb_numero_sucursal.addItem((String) modelCOMPRAS.getNumero_sucursal().get(s));
        }
        for (int e = 0; e < modelCOMPRAS.getNumero_empleado().size(); e++) {
            viewCOMPRAS.jcb_rfc.addItem((String) modelCOMPRAS.getNumero_empleado().get(e));
        }
        for (int c = 0; c < modelCOMPRAS.getProducto().size(); c++) {
            viewCOMPRAS.jcb_codigo_producto.addItem((String) modelCOMPRAS.getProducto().get(c));
        }
    }
    /**
     * metodo que deshabilitara los combobox
     * para que no se pueda realizar otra accion, si no se ha registrado
     * quien va a hacer la compra (empleado)
     */
    public void deshabiltarObjetos(){
        viewCOMPRAS.jcb_numero_sucursal.setEnabled(false);
        viewCOMPRAS.jcb_numero_proveedor.setEnabled(false);
        viewCOMPRAS.jcb_codigo_producto.setEnabled(false);
        //Deshabilitar cajas de texto
        viewCOMPRAS.jtf_cantidad.setEditable(false);
        viewCOMPRAS.jtf_precio.setEditable(false);
        //Deshablitar botones
        viewCOMPRAS.jb_agregar.setEnabled(false);
        viewCOMPRAS.jb_modificar.setEnabled(false);
        viewCOMPRAS.jb_nuevo.setEnabled(false);
        viewCOMPRAS.jb_realizar_compra.setEnabled(false);
        //Deshabilitando la tabla de compras 
        viewCOMPRAS.jt_vista.setEnabled(false);
    }
    public void TotalProducto(){
        modelCOMPRAS.setCantidad_compra(Integer.parseInt(viewCOMPRAS.jtf_cantidad.getText()));
        modelCOMPRAS.setPrecio_compra(Float.parseFloat(viewCOMPRAS.jtf_precio.getText()));
        modelCOMPRAS.TotalCompraProducto();
        viewCOMPRAS.jtf_total.setText(Float.toString(modelCOMPRAS.getTotal_por_producto()));
    }
}
