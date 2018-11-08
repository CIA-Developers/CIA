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
    
    
        private void jt_vista_MouseClicked() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        
    public ControllerEmpleadosCompras(ModelEmpleadosCompras modelEmpleadosCompras, ViewEmpleadosCompras viewEmpleadosCompras) {
        this.modelEmpleadosCompras = modelEmpleadosCompras;
        this.viewEmpleadosCompras = viewEmpleadosCompras;
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
    
    
}
