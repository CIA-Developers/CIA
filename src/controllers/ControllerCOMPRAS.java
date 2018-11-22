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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
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
            }else if (e.getSource() == viewCOMPRAS.jcb_rfc){
                modelCOMPRAS.setRFC_empleado((String) viewCOMPRAS.jcb_rfc.getSelectedItem());
                modelCOMPRAS.llenarTextFieldsEmpleados();
                viewCOMPRAS.jtf_nombre_empleado.setText(modelCOMPRAS.getNombre_empleado()+"  "+modelCOMPRAS.getApellido_pat_empleado()+"  "+modelCOMPRAS.getApellido_mat_empleado());
                viewCOMPRAS.jcb_numero_sucursal.setEnabled(true);//habilitando jcb numero sucursal
            }else if (e.getSource() == viewCOMPRAS.jcb_codigo_producto){
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
                viewCOMPRAS.jb_nuevo.setEnabled(false);
            }else if (e.getSource() == viewCOMPRAS.jcb_numero_sucursal){
                viewCOMPRAS.jcb_numero_proveedor.setEnabled(true);//habilitando jcb numero de proveedor
                viewCOMPRAS.jb_nuevo.setEnabled(false);
            }else if (e.getSource() == viewCOMPRAS.jb_agregar){
               llenadoTabla();
            }else if (e.getSource() == viewCOMPRAS.jb_nuevo){
               nuevo();
            }else if (e.getSource() == viewCOMPRAS.jb_eliminar){
               eliminar();
               limpiarSinTabla();
            }else if (e.getSource() == viewCOMPRAS.jb_modificar){
               modificar();
               limpiarSinTabla();
            }
            else if (e.getSource() == viewCOMPRAS.jb_realizar_compra){
               realizarCompra();
            }
        }
        
    };
    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewCOMPRAS.jt_vista) {
                jt_vista_MouseClicked();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    };
    
    KeyListener key = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {
      
        }

        @Override
        public void keyPressed(KeyEvent e) {
           
        }

        @Override
        public void keyReleased(KeyEvent e) {
           if (e.getSource() == viewCOMPRAS.jtf_cantidad || e.getSource() == viewCOMPRAS.jtf_precio){
               TotalProducto();
            }
        }
        
    };

    public ControllerCOMPRAS(ModelCOMPRAS modelCOMPRAS, ViewCOMPRAS viewCOMPRAS) {
        this.modelCOMPRAS = modelCOMPRAS;
        this.viewCOMPRAS = viewCOMPRAS;
        
        viewCOMPRAS.jtf_cantidad.addKeyListener(key);
        viewCOMPRAS.jtf_precio.addKeyListener(key);
        this.viewCOMPRAS.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener
        
        modelCOMPRAS.Conectar();// conexion a la BD
        initComponents();
        llenadoCombos();
        setActionListener(); 
        deshabiltarObjetos();
        
        modelCOMPRAS.numeroCompras();
        viewCOMPRAS.jtf_numero_compra.setText(Integer.toString(modelCOMPRAS.getNumero_compra()));
        viewCOMPRAS.jt_vista.setModel(modelCOMPRAS.getModel_compras());//agrenado modelo a la tabla
               
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
        //botones
        viewCOMPRAS.jb_agregar.addActionListener(list);
        viewCOMPRAS.jb_modificar.addActionListener(list);
        viewCOMPRAS.jb_nuevo.addActionListener(list);
        viewCOMPRAS.jb_realizar_compra.addActionListener(list);
        viewCOMPRAS.jb_eliminar.addActionListener(list);
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
     * metodo que al haer clic en una fila de la tabla, pasara cada dato en sus Jtf correspondientes 
     * para poder modificar o eliminar la fila seleccionada
     */
    public void jt_vista_MouseClicked(){
        modelCOMPRAS.setRec(viewCOMPRAS.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewCOMPRAS.jcb_codigo_producto.setSelectedItem(viewCOMPRAS.jt_vista.getValueAt(modelCOMPRAS.getRec(), 1).toString());
        viewCOMPRAS.jtf_nombre_producto.setText(viewCOMPRAS.jt_vista.getValueAt(modelCOMPRAS.getRec(), 2).toString());
        viewCOMPRAS.jtf_marca_producto.setText(viewCOMPRAS.jt_vista.getValueAt(modelCOMPRAS.getRec(), 3).toString());
        viewCOMPRAS.jtf_precio.setText(viewCOMPRAS.jt_vista.getValueAt(modelCOMPRAS.getRec(), 4).toString());
        viewCOMPRAS.jtf_cantidad.setText(viewCOMPRAS.jt_vista.getValueAt(modelCOMPRAS.getRec(), 5).toString());
        viewCOMPRAS.jtf_total.setText(viewCOMPRAS.jt_vista.getValueAt(modelCOMPRAS.getRec(), 6).toString());
        viewCOMPRAS.jb_modificar.setEnabled(true);
        viewCOMPRAS.jb_eliminar.setEnabled(true);
        viewCOMPRAS.jb_agregar.setEnabled(false);
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
        viewCOMPRAS.jb_eliminar.setEnabled(false);
        //Deshabilitando la tabla de compras 
        viewCOMPRAS.jt_vista.setEnabled(false);
    }
    public void TotalProducto(){
        modelCOMPRAS.setCantidad_compra(Float.parseFloat(viewCOMPRAS.jtf_cantidad.getText()));
        modelCOMPRAS.setPrecio_compra(Float.parseFloat(viewCOMPRAS.jtf_precio.getText()));
        modelCOMPRAS.TotalCompraProducto();
        viewCOMPRAS.jtf_total.setText(Float.toString(modelCOMPRAS.getTotal_por_producto()));
    }
    public void llenadoTabla(){
        try{
            viewCOMPRAS.jb_modificar.setEnabled(false);
            viewCOMPRAS.jb_nuevo.setEnabled(true);
            viewCOMPRAS.jb_eliminar.setEnabled(false);
            viewCOMPRAS.jb_realizar_compra.setEnabled(true);
            viewCOMPRAS.jcb_numero_sucursal.setEnabled(false);
            viewCOMPRAS.jcb_numero_proveedor.setEnabled(false);
            viewCOMPRAS.jcb_rfc.setEnabled(false);
            viewCOMPRAS.jb_agregar.setEnabled(false);
            viewCOMPRAS.jt_vista.setEnabled(true);
            modelCOMPRAS.setNumero_compra(Integer.parseInt(viewCOMPRAS.jtf_numero_compra.getText()));
            modelCOMPRAS.setCodigo_producto((String) viewCOMPRAS.jcb_codigo_producto.getSelectedItem());
            modelCOMPRAS.setNombre_producto(viewCOMPRAS.jtf_nombre_producto.getText());
            modelCOMPRAS.setMarca_producto(viewCOMPRAS.jtf_marca_producto.getText());
            modelCOMPRAS.setPrecio_compra(Float.parseFloat(viewCOMPRAS.jtf_precio.getText()));
            modelCOMPRAS.setCantidad_compra(Float.parseFloat(viewCOMPRAS.jtf_cantidad.getText()));
            modelCOMPRAS.setTotal_por_producto(Float.parseFloat(viewCOMPRAS.jtf_total.getText()));
            modelCOMPRAS.AgregarDatosCompra();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error11 AgregarDatosCompras "+ e);
        }
        //haciendo la suma de toda la columna de total por producto
        float fila=0;
        float total=0;
        for (int i = 0; i < viewCOMPRAS.jt_vista.getRowCount(); i++){
            fila = Float.parseFloat(viewCOMPRAS.jt_vista.getValueAt(i,6).toString());
            total += fila;    
        }
        modelCOMPRAS.setImporte(total);
        modelCOMPRAS.importe();
        viewCOMPRAS.jtf_importe.setText(Float.toString(modelCOMPRAS.getImporte()));
        viewCOMPRAS.jtf_iva.setText(Float.toString(modelCOMPRAS.getIva()));
        viewCOMPRAS.jtf_subtotal.setText(Float.toString(modelCOMPRAS.getSubtotal()));    
    }
    /**
     * metodo para agregar un nuevo producto a compras
     * limpiara las cajas para poder agregar un nuevo producto
     */
    public void limpiar(){
        viewCOMPRAS.jtf_nombre_proveedor.setText(" ");
        viewCOMPRAS.jtf_telefono_proveedor.setText("  ");
        viewCOMPRAS.jtf_nombre_producto.setText("  ");
        viewCOMPRAS.jtf_tipo_producto.setText(" ");
        viewCOMPRAS.jtf_marca_producto.setText(" ");
        viewCOMPRAS.jtf_cantidad.setText("0");
        viewCOMPRAS.jtf_precio.setText("0.0");
        viewCOMPRAS.jtf_total.setText("0.0");
        //LIMPIAR TABLA 
        for (int i = 0; i <  viewCOMPRAS.jt_vista.getRowCount(); i++) {
           modelCOMPRAS.getModel_compras().removeRow(i);
            i-=1;
        }
    }
    public void limpiarSinTabla(){
        viewCOMPRAS.jtf_nombre_proveedor.setText(" ");
        viewCOMPRAS.jtf_telefono_proveedor.setText("  ");
        viewCOMPRAS.jtf_nombre_producto.setText("  ");
        viewCOMPRAS.jtf_tipo_producto.setText(" ");
        viewCOMPRAS.jtf_marca_producto.setText(" ");
        viewCOMPRAS.jtf_cantidad.setText("0");
        viewCOMPRAS.jtf_precio.setText("0.0");
        viewCOMPRAS.jtf_total.setText("0.0");
    }
    public void nuevo(){
        viewCOMPRAS.jtf_nombre_proveedor.setText(" ");
        viewCOMPRAS.jtf_telefono_proveedor.setText("  ");
        viewCOMPRAS.jtf_nombre_producto.setText("  ");
        viewCOMPRAS.jtf_tipo_producto.setText(" ");
        viewCOMPRAS.jtf_marca_producto.setText(" ");
        viewCOMPRAS.jtf_cantidad.setText("0");
        viewCOMPRAS.jtf_precio.setText("0.0");
        viewCOMPRAS.jtf_total.setText("0.0");
        viewCOMPRAS.jb_agregar.setEnabled(false);
        viewCOMPRAS.jb_modificar.setEnabled(false);
        viewCOMPRAS.jb_eliminar.setEnabled(false);
    }
    /**
     * metodo que sirve para eliminar una fila seleccionda dentro de la tabla
     */
    public void eliminar(){
        modelCOMPRAS.getModel_compras().removeRow(viewCOMPRAS.jt_vista.getSelectedRow()); //eliina la fila seleccionada en la jtable
        //volviando a calcular el importe
        float fila=0;
        float total=0;
        for (int i = 0; i < viewCOMPRAS.jt_vista.getRowCount(); i++){
            fila = Float.parseFloat(viewCOMPRAS.jt_vista.getValueAt(i,6).toString());
            total += fila;    
        }
        modelCOMPRAS.setImporte(total);
        modelCOMPRAS.importe();
        viewCOMPRAS.jtf_importe.setText(Float.toString(modelCOMPRAS.getImporte()));
        viewCOMPRAS.jtf_iva.setText(Float.toString(modelCOMPRAS.getIva()));
        viewCOMPRAS.jtf_subtotal.setText(Float.toString(modelCOMPRAS.getSubtotal())); 
    }
    /**
     * metodo que agregara  el registro modificado 
     * eliminara el dato que fue modificado
     */
    public void modificar(){
        eliminar();
        llenadoTabla();
    }
    /**
     * metodon  que guardara cada dato de la compra en su respectiva tabla
     * en detalle compra, se agudaran los datos dentro de la jtable
     * en compra, se llenara con los datos de jos jtf que le corresponden a la tabla
     * este meodo finalizara toda la compra de la tabla
     */
    public void realizarCompra(){
        try{
        // se guarda en Compras **agregando datos para guardar
        modelCOMPRAS.setId_proveedor(Integer.parseInt((String) viewCOMPRAS.jcb_numero_proveedor.getSelectedItem()));
        modelCOMPRAS.setImporte(Float.parseFloat(viewCOMPRAS.jtf_importe.getText()));
        modelCOMPRAS.setIva(Float.parseFloat(viewCOMPRAS.jtf_iva.getText()));
        modelCOMPRAS.setSubtotal(Float.parseFloat(viewCOMPRAS.jtf_subtotal.getText()));
        modelCOMPRAS.setNum_sucursal(Integer.parseInt((String) viewCOMPRAS.jcb_numero_sucursal.getSelectedItem()));
        modelCOMPRAS.finalizarCompratablaCompra();//llamamos al metodo de guardar en compra 
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"error14 FinalizarCompras "+ e);
          } 
        //se guardara en detalle_compras ***agregando datos
        try{
        for (int i = 0; i < viewCOMPRAS.jt_vista.getRowCount(); i++){
            modelCOMPRAS.setNumero_compra(Integer.parseInt((String) viewCOMPRAS.jt_vista.getValueAt(i,0)));
            modelCOMPRAS.setCodigo_producto(viewCOMPRAS.jt_vista.getValueAt(i,1).toString());
            modelCOMPRAS.setCantidad_compra(Float.parseFloat((String) viewCOMPRAS.jt_vista.getValueAt(i,5)));
            modelCOMPRAS.setPrecio_compra(Float.parseFloat((String) viewCOMPRAS.jt_vista.getValueAt(i,4)));
            modelCOMPRAS.setTotal_por_producto(Float.parseFloat((String)viewCOMPRAS.jt_vista.getValueAt(i,6)));
            modelCOMPRAS.finalizarCompratablaDetalleCompra(); //llamamos el metodo de guardar en detalle_compra
               
        }
        JOptionPane.showMessageDialog(null,"Se realizo la compra con exito");  
        deshabiltarObjetos();
        limpiar();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"error15 FinalizarCompras "+ e);
        } 
    }
}
