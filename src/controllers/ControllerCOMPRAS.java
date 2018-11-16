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

    public ControllerCOMPRAS(ModelCOMPRAS modelCOMPRAS, ViewCOMPRAS viewCOMPRAS) {
        this.modelCOMPRAS = modelCOMPRAS;
        this.viewCOMPRAS = viewCOMPRAS;
        modelCOMPRAS.Conectar();// conexion a la BD 
        initComponents();
        llenadoCombos();
    }

    public void initComponents(){
        viewCOMPRAS.jcb_numero_proveedor.removeAllItems();//eliminar los items del comboBbx
        viewCOMPRAS.jcb_numero_sucursal.removeAllItems();
        viewCOMPRAS.jcb_rfc.removeAllItems();
        viewCOMPRAS.jcb_codigo_producto.removeAllItems();
        
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
