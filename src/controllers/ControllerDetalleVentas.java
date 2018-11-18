/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import models.ModelDetalleVentas;
import java.awt.Container;
import views.ViewDetalleVentas;

/**
 *
 * @author Ami
 */
public class ControllerDetalleVentas {

    public ModelDetalleVentas modelDetalleVentas;
    public ViewDetalleVentas viewDetalleVentas;
    
    MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
          if (e.getSource() == viewDetalleVentas.jT_detalle_venta) {
                jt_detalle_venta_MouseClicked();
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

        private void jt_detalle_venta_MouseClicked() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

       
    };
    
    
    public ControllerDetalleVentas(ModelDetalleVentas modelDetalleVentas, ViewDetalleVentas viewDetalleVentas) {
        this.modelDetalleVentas = modelDetalleVentas;
        this.viewDetalleVentas = viewDetalleVentas;
    }
}
