/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            }
            else if (e.getSource() == viewCOMPRAS.jcb_rfc){
                modelCOMPRAS.setRFC_empleado((String) viewCOMPRAS.jcb_rfc.getSelectedItem());
                modelCOMPRAS.llenarTextFieldsEmpleados();
                viewCOMPRAS.jtf_nombre_empleado.setText(modelCOMPRAS.getNombre_empleado()+"  "+modelCOMPRAS.getApellido_pat_empleado()+"  "+modelCOMPRAS.getApellido_mat_empleado());
            }
        }
        
    };

    public ControllerCOMPRAS(ModelCOMPRAS modelCOMPRAS, ViewCOMPRAS viewCOMPRAS) {
        this.modelCOMPRAS = modelCOMPRAS;
        this.viewCOMPRAS = viewCOMPRAS;
        modelCOMPRAS.Conectar();// conexion a la BD
        initComponents();
        llenadoCombos();
        setActionListener();      
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
   
    
}
