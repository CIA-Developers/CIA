/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.modelVENTAS;
import views.ViewVENTAS;
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
            }else if (e.getSource() == viewVENTAS.jcb_codigo_producto){
                
            }else if (e.getSource() == viewVENTAS.jcb_codigo_descuento){
                modelVENTAS.setCodigo_descuento(Integer.parseInt((String) viewVENTAS.jcb_codigo_descuento.getSelectedItem()));
                modelVENTAS.llenarTextFieldsDescuentos();
                viewVENTAS.jtf_puntos_requeridos.setText(Integer.toString(modelVENTAS.getCantidad_puntos()));
                viewVENTAS.jtf_porcentaje.setText(Integer.toString(modelVENTAS.getPorcentaje()));
                
            }
        }
        
    };
    
    public ControllerVENTAS(modelVENTAS modelVENTAS, ViewVENTAS viewVENTAS) {
        this.modelVENTAS = modelVENTAS;
        this.viewVENTAS = viewVENTAS;
        
        modelVENTAS.Conectar();//Llamar a la conexion a la Base de datos 
        LimpiarCombox();
        LlenarCombox();
        setActionListener(); 
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
     * 6. verificar con la fecha final de la promocion, ara verificar si todavia es aplicable
     */
    public void Productos(){
        
    }
}
