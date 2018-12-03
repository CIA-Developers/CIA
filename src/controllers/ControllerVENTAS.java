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
import javax.swing.JOptionPane;
import models.modelVENTAS;
import views.ViewVENTAS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Octaviano
 */
public class ControllerVENTAS {
    modelVENTAS modelVENTAS;
    ViewVENTAS viewVENTAS;

    ActionListener list = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewVENTAS.jcb_rfc){
                modelVENTAS.setRFC_empleado((String) viewVENTAS.jcb_rfc.getSelectedItem());
                modelVENTAS.llenarTextFieldsEmpleados();
                viewVENTAS.jtf_nombre_empleado.setText(modelVENTAS.getNombre_empleado()+"  "+modelVENTAS.getApellido_pat_empleado()+"  "+modelVENTAS.getApellido_mat_empleado());
                viewVENTAS.jcb_numero_sucursal.setEnabled(true);//habilitando jcb numero sucursal
            }else if (e.getSource() == viewVENTAS.jcb_numero_sucursal){
                viewVENTAS.jcb_rfc_cliente.setEnabled(true);//habilitando jcb numero sucursal
            }else if (e.getSource() == viewVENTAS.jcb_rfc_cliente){
                modelVENTAS.setRFC_cliente((String) viewVENTAS.jcb_rfc_cliente.getSelectedItem());
                modelVENTAS.llenarTextFieldsClientes();
                viewVENTAS.jtf_nombre_cliente.setText(modelVENTAS.getNombre_cliente()+"  "+modelVENTAS.getApell_pat_cliente()+"  "+modelVENTAS.getApell_mat_cliente());
                viewVENTAS.jtf_puntos_acumulados.setText(Integer.toString(modelVENTAS.getPuntos_acumulados()));
                viewVENTAS.jcb_codigo_producto.setEnabled(true);
            }else if (e.getSource() == viewVENTAS.jcb_codigo_producto){
                Productos();
                viewVENTAS.jb_agregar.setEnabled(true);
            }else if (e.getSource() == viewVENTAS.jcb_codigo_descuento){
                modelVENTAS.setCodigo_descuento(Integer.parseInt((String) viewVENTAS.jcb_codigo_descuento.getSelectedItem()));
                modelVENTAS.llenarTextFieldsDescuentos();
                viewVENTAS.jtf_puntos_requeridos.setText(Integer.toString(modelVENTAS.getCantidad_puntos()));
                viewVENTAS.jtf_porcentaje.setText(Integer.toString(modelVENTAS.getPorcentaje()));
                viewVENTAS.jb_aplicar_descuento.setEnabled(true);
            }else if (e.getSource() == viewVENTAS.jb_agregar){
                jtf_agregar();
            }else if(e.getSource() == viewVENTAS.jb_aplicar_descuento){
                descuento();
            }else if(e.getSource() == viewVENTAS.jb_nuevo){
                nuevo();
                viewVENTAS.jb_nuevo.setEnabled(false);
            }
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
           if (e.getSource() == viewVENTAS.jtf_cantidad){
               totalProducto();
            }
        }
        
    };
    
    public ControllerVENTAS(modelVENTAS modelVENTAS, ViewVENTAS viewVENTAS) {
        this.modelVENTAS = modelVENTAS;
        this.viewVENTAS = viewVENTAS;
        
        viewVENTAS.jtf_cantidad.addKeyListener(key);
        viewVENTAS.jtf_precio.addKeyListener(key);
        
        modelVENTAS.Conectar();//Llamar a la conexion a la Base de datos 
        LimpiarCombox();
        LlenarCombox();
        setActionListener(); 
        deshabiltarObjetos();
        
        // obetner el numero de venta y mostrarlo
        modelVENTAS.numeroVentas();
        viewVENTAS.jtf_numero_venta.setText(Integer.toString(modelVENTAS.getNumero_venta()));
        viewVENTAS.jt_vista.setModel(modelVENTAS.getModel_ventas());//agrenado modelo a la tabla
        
    }
    /**
     * agregar el evento de ActionListener a los ComboBox y a los botones de la vista Ventas
     */
    public void setActionListener(){
       viewVENTAS.jcb_codigo_producto.addActionListener(list);
       viewVENTAS.jcb_numero_sucursal.addActionListener(list);
       viewVENTAS.jcb_rfc.addActionListener(list);
       viewVENTAS.jcb_rfc_cliente.addActionListener(list);
       viewVENTAS.jcb_codigo_descuento.addActionListener(list);
       //Botones 
       viewVENTAS.jb_agregar.addActionListener(list);
       viewVENTAS.jb_nuevo.addActionListener(list);
       viewVENTAS.jb_eliminar.addActionListener(list);
       viewVENTAS.jb_modificar.addActionListener(list);
       viewVENTAS.jb_aplicar_descuento.addActionListener(list);
       viewVENTAS.jb_realizar_venta.addActionListener(list);
    }
     public void deshabiltarObjetos(){
        viewVENTAS.jcb_numero_sucursal.setEnabled(false);
        viewVENTAS.jcb_rfc_cliente.setEnabled(false);
        viewVENTAS.jcb_codigo_producto.setEnabled(false);
        viewVENTAS.jcb_codigo_descuento.setEnabled(false);
        //Deshabilitar cajas de texto
        viewVENTAS.jtf_cantidad.setEditable(false);
        viewVENTAS.jtf_precio.setEditable(false);
        //Deshablitar botones
        viewVENTAS.jb_agregar.setEnabled(false);
        viewVENTAS.jb_modificar.setEnabled(false);
        viewVENTAS.jb_nuevo.setEnabled(false);
        viewVENTAS.jb_realizar_venta.setEnabled(false);
        viewVENTAS.jb_eliminar.setEnabled(false);
        viewVENTAS.jb_aplicar_descuento.setEnabled(false);
        //Deshabilitando la tabla de compras 
        viewVENTAS.jt_vista.setEnabled(false);
    }
     //************************************ BOTONES DE NUEVO, AGREGAR, Eliminar ***********************************************
    public void nuevo(){
        viewVENTAS.jtf_nombre_producto.setText("  ");
        viewVENTAS.jtf_tipo_producto.setText(" ");
        viewVENTAS.jtf_marca_producto.setText(" ");
        viewVENTAS.jtf_cantidad.setText("0");
        viewVENTAS.jtf_precio.setText("0.0");
        viewVENTAS.jtf_total.setText("0.0");
        viewVENTAS.jb_agregar.setEnabled(false);
        viewVENTAS.jb_modificar.setEnabled(false);
        viewVENTAS.jb_eliminar.setEnabled(false);
        viewVENTAS.jtf_cantidad.setEditable(true);
    }
    /**
     * Metodo que limpiara los ComboBox de la vista VENTAS
     */
    public void LimpiarCombox(){
       viewVENTAS.jcb_codigo_producto.removeAllItems();
       viewVENTAS.jcb_numero_sucursal.removeAllItems();
       viewVENTAS.jcb_rfc.removeAllItems();
       viewVENTAS.jcb_rfc_cliente.removeAllItems();
       viewVENTAS.jcb_codigo_descuento.removeAllItems();
    }
    /**
     * Metodo que realizara el llenado de los ComboBox con los datos corespondientes 
     * obtenidos de la base de datos 
     */
    public void LlenarCombox(){
        modelVENTAS.llenarCombo();//metodo en el modelo para llenar los comboBox
        for (int p = 0; p < modelVENTAS.getNumero_empleado().size(); p++) {
            viewVENTAS.jcb_rfc.addItem((String) modelVENTAS.getNumero_empleado().get(p));
        }
        for (int p = 0; p < modelVENTAS.getNumero_sucursal().size(); p++) {
            viewVENTAS.jcb_numero_sucursal.addItem((String) modelVENTAS.getNumero_sucursal().get(p));
        }
        for (int p = 0; p < modelVENTAS.getProducto().size(); p++) {
            viewVENTAS.jcb_codigo_producto.addItem((String) modelVENTAS.getProducto().get(p));
        }
        for (int p = 0; p < modelVENTAS.getNumero_cliente().size(); p++) {
            viewVENTAS.jcb_rfc_cliente.addItem((String) modelVENTAS.getNumero_cliente().get(p));
        }
        for (int p = 0; p < modelVENTAS.getDescuento_combo().size(); p++) {
            viewVENTAS.jcb_codigo_descuento.addItem((String) modelVENTAS.getDescuento_combo().get(p));
        }
    }
    /**
     * este metodo realizara  las siguientes acciones 
     * 1. llenara los textFields con los datos que le correspondan segun el item seleccionado en el ComboBox
     * 2. identificara si el producto seleccionado esta en venta 
     * 3. si el producto no esta en venta notificara que el producto no se puede vender 
     * 4. identificara si el producto seleccionado esta en promociones
     * 5. si el producto esta en promociones aplicara el descuento que le corresponda 
     * 6. verificar con la fecha final de la promocion, para verificar si todavia es aplicable
     */
    public void Productos(){
        viewVENTAS.jcb_numero_sucursal.setEnabled(false);
        viewVENTAS.jcb_rfc_cliente.setEnabled(false);
        viewVENTAS.jcb_rfc.setEnabled(false);
        viewVENTAS.jb_agregar.setEnabled(false);
        viewVENTAS.jt_vista.setEnabled(true);
        viewVENTAS.jtf_cantidad.setEditable(true);
        modelVENTAS.setCodigo_producto((String) viewVENTAS.jcb_codigo_producto.getSelectedItem());
        modelVENTAS.setCodigo_producto_Promo((String) viewVENTAS.jcb_codigo_producto.getSelectedItem());
        modelVENTAS.llenarTextFieldsProductos();
        viewVENTAS.jtf_cantidad.setText("1");
        viewVENTAS.jtf_nombre_producto.setText(modelVENTAS.getNombre_producto());
        viewVENTAS.jtf_tipo_producto.setText(modelVENTAS.getTipo_producto());
        viewVENTAS.jtf_marca_producto.setText(modelVENTAS.getMarca_producto());
        viewVENTAS.jl_status_producto.setText(modelVENTAS.getStatus_vista());
        viewVENTAS.jtf_precio.setText(Float.toString(modelVENTAS.getPrecio_venta()));
        totalProducto();
        
    }
    /***
     * el siguiente metodo mandara a las variables dentro del modelo el valor de la cajas de precio y cantidad
     * de la venta
     * y recibira el total por producto para mandarlo a la caja que mostrara el total por producto
     */
    public void totalProducto(){
       try{
        modelVENTAS.setCantidad_venta(Integer.parseInt(viewVENTAS.jtf_cantidad.getText()));
        modelVENTAS.setPrecio_venta(Float.parseFloat(viewVENTAS.jtf_precio.getText()));
        modelVENTAS.TotalProductoVendido();
        viewVENTAS.jtf_total.setText(Float.toString(modelVENTAS.getTotal_por_producto()));
        }catch(Exception e){
            System.out.println("error ignorado Total Producto");
        } 
    }
    /**
     * metodo que llenara la tabla con cada producto vendido e ira calculando el importe
     */
    public void AgregarDatosVenta(){
        modelVENTAS.setNumero_venta(Integer.parseInt(viewVENTAS.jtf_numero_venta.getText()));
        modelVENTAS.setCodigo_producto((String) viewVENTAS.jcb_codigo_producto.getSelectedItem());
        modelVENTAS.setNombre_producto(viewVENTAS.jtf_nombre_producto.getText());
        modelVENTAS.setMarca_producto(viewVENTAS.jtf_marca_producto.getText());
        modelVENTAS.setPrecio_venta(Float.parseFloat(viewVENTAS.jtf_precio.getText()));
        modelVENTAS.setCantidad_venta(Integer.parseInt(viewVENTAS.jtf_cantidad.getText()));
        modelVENTAS.setTotal_por_producto(Float.parseFloat(viewVENTAS.jtf_total.getText()));
        modelVENTAS.AgregarDatosVenta();
        
        // ****************************** Calculando el importe ************************* 
        //haciendo la suma de toda la columna de total por producto
        float fila=0f;
        float total=0f;
        for (int i = 0; i < viewVENTAS.jt_vista.getRowCount(); i++){
            fila = Float.parseFloat(viewVENTAS.jt_vista.getValueAt(i,6).toString());
            total += fila;    
        }
        modelVENTAS.setImporte(total);
        modelVENTAS.setRFC_cliente((String) viewVENTAS.jcb_rfc_cliente.getSelectedItem());
        modelVENTAS.importe();
        viewVENTAS.jtf_importe.setText(Float.toString(modelVENTAS.getImporte()));
        viewVENTAS.jtf_iva.setText(Float.toString(modelVENTAS.getIva()));
        viewVENTAS.jtf_subtotal.setText(Float.toString(modelVENTAS.getSubtotal())); 
        viewVENTAS.jtf_puntos_ganados.setText(Integer.toString(modelVENTAS.getPuntos_ganados()));
        
        viewVENTAS.jb_agregar.setEnabled(false);
        viewVENTAS.jb_nuevo.setEnabled(true);
    }
    /**
     * metodo que evalua si el producto esta en venta, o no 
     * si el producto ya no esta en venta, no dejara que se agrege a la venta
     */
    public void jtf_agregar(){
        switch (modelVENTAS.getStatus_producto()) {
            case "en venta":
               AgregarDatosVenta();
                break;
            case "ya no se maneja":
                JOptionPane.showMessageDialog(null,"no se puede vender este producto");
                break;
            case "Producto en **Promocion**":
                AgregarDatosVenta();
                break;
        }
        viewVENTAS.jtf_cantidad.setEditable(false);
        viewVENTAS.jcb_codigo_descuento.setEnabled(true);
        viewVENTAS.jb_realizar_venta.setEnabled(true);
    }
    /**
     * Metodo que manda a llamar el metodo para aplicar el descuento si el cliente
     * cumple con los puntos requeridos de lo contrario, no se aplicara el descuento deseado
     */
    public void descuento(){
        modelVENTAS.setPorcentaje(Integer.parseInt(viewVENTAS.jtf_porcentaje.getText()));
        modelVENTAS.setImporte(Float.parseFloat(viewVENTAS.jtf_importe.getText()));
        modelVENTAS.DescuentoImporte();
        viewVENTAS.jtf_descuento.setText(Float.toString(modelVENTAS.getDescuento()));
        viewVENTAS.jtf_importe.setText(Float.toString(modelVENTAS.getDescuento_prod()));
        //calculando de nuevo el iva y el subtotal
        viewVENTAS.jtf_iva.setText(Float.toString(modelVENTAS.getIva()));
        viewVENTAS.jtf_subtotal.setText(Float.toString(modelVENTAS.getSubtotal()));
        if ("deshabilitado".equals(modelVENTAS.getActivo())){
            viewVENTAS.jcb_codigo_descuento.setEnabled(false);
            viewVENTAS.jtf_puntos_requeridos.setText("0.0");
            viewVENTAS.jtf_porcentaje.setText("0.0");
            viewVENTAS.jb_aplicar_descuento.setEnabled(false);
        }else{
            viewVENTAS.jb_aplicar_descuento.setEnabled(false);
            viewVENTAS.jtf_puntos_requeridos.setText("0.0");
            viewVENTAS.jtf_porcentaje.setText("0.0");
        }
    }
}
