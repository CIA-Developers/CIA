/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.ModelEmpleadosCompras;
import views.ViewEmpleadosCompras;
/**
 *
 * @author Octaviano
 */
public class ControllerEmpleadosCompras {
    public ModelEmpleadosCompras modelEmpleadosCompras;
    public ViewEmpleadosCompras viewEmpleadosCompras;
    
    MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
          if (e.getSource() == viewEmpleadosCompras.jt_vista) {
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
    
        
    public ControllerEmpleadosCompras(ModelEmpleadosCompras modelEmpleadosCompras, ViewEmpleadosCompras viewEmpleadosCompras) {
        this.modelEmpleadosCompras = modelEmpleadosCompras;
        this.viewEmpleadosCompras = viewEmpleadosCompras;
        this.viewEmpleadosCompras.jt_vista.addMouseListener(ml);
        ConexionBD();
       
    }
    
    /**
     * este metodo hace la conexion a la base de datos 
     * llama a los metodos conectar, mostrar  dentro del modelo 
     * muestra en la tabla los datos que contiene la variable de modelo_EmpleadosCompras
     */
    public void ConexionBD(){
         modelEmpleadosCompras.Conectar();
        modelEmpleadosCompras.mostrar();
        viewEmpleadosCompras.jt_vista.setModel(modelEmpleadosCompras.getModelo_EmCompras()); //asignar a la tabla los valores correspondientes
    }
    
    private void jt_vista_MouseClicked() {
 modelEmpleadosCompras.setRec(viewEmpleadosCompras.jt_vista.getSelectedRow());
    //variable que se le asigna el elemento seleccionado en la tabla
        viewEmpleadosCompras.jtf_rfc.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 0).toString());
        viewEmpleadosCompras.jtf_nombre.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 1).toString());
        viewEmpleadosCompras.jtf_ap_pat.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 2).toString());
        viewEmpleadosCompras.jtf_apt_mat.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 3).toString());
        viewEmpleadosCompras.jtf_sexo.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 4).toString());
        viewEmpleadosCompras.jtf_estado_civil.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 5).toString());
        viewEmpleadosCompras.jtf_Telefono.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 6).toString());
        viewEmpleadosCompras.jtf_correo.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 7).toString());
        viewEmpleadosCompras.jtf_usuario.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 8).toString());
    }        
    
    
}
