/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelAgregarSucursal;
import views.ViewAgregarSucursal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Octaviano
 */
public class ControllerAgregarSucursal {
    ModelAgregarSucursal modelAgregarSucursal;
    ViewAgregarSucursal viewAgregarSucursal;
    ActionListener list = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgregarSucursal.jb_nuevo) {
                nuevo_proveedores();
            } else if (e.getSource() == viewAgregarSucursal.jb_modificar) {
                modificar_proveedores();
            } else if (e.getSource() == viewAgregarSucursal.jb_guardar) {
                Guardar();
            }
        }

    };
     MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewAgregarSucursal.jt_vista) {
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
      ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    /**
     * Busar solo con un compo, no es necesario el metodo de filtro toda la
     * accion de buscar esta dentro del evento keyListener
     */
    KeyListener key = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getSource() == viewAgregarSucursal.jtf_buscar) {
                modelAgregarSucursal.setTrsFiltro(new TableRowSorter(viewAgregarSucursal.jt_vista.getModel()));
                viewAgregarSucursal.jt_vista.setRowSorter(modelAgregarSucursal.getTrsFiltro());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            modelAgregarSucursal.setCadena(viewAgregarSucursal.jtf_buscar.getText());
            viewAgregarSucursal.jtf_buscar.setText(modelAgregarSucursal.getCadena());
            modelAgregarSucursal.getTrsFiltro().setRowFilter(RowFilter.regexFilter(viewAgregarSucursal.jtf_buscar.getText(), modelAgregarSucursal.getColumnaABuscar()));
        }
    };

     
    public ControllerAgregarSucursal(ModelAgregarSucursal modelAgregarSucursal, ViewAgregarSucursal viewAgregarSucursal) {
        this.modelAgregarSucursal = modelAgregarSucursal;
        this.viewAgregarSucursal = viewAgregarSucursal;
    }

     
}
