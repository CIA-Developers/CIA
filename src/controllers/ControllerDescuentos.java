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
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import models.ModelDescuentos;
import views.ViewDescuentos;

/**
 *
 * @author Octaviano
 */
public class ControllerDescuentos {

    ModelDescuentos modelDescuentos;
    ViewDescuentos viewDescuentos;
     ActionListener list = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewDescuentos.jb_nuevo) {
                nuevo_Descuentos();
            } else if (e.getSource() == viewDescuentos.jb_modificar) {
                modificar_Descuentos();
            } else if (e.getSource() == viewDescuentos.jb_guardar) {
                Guardar();
            }
        }

    };
       MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewDescuentos.jt_vista) {
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

    
    
    
    
    
    
    
    
    
    
    

    public ControllerDescuentos(ModelDescuentos modelDescuentos, ViewDescuentos viewDescuentos) {

        this.modelDescuentos = modelDescuentos;
        this.viewDescuentos = viewDescuentos;

    }

}
