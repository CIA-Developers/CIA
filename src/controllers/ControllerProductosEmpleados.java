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
import models.ModelProductosEmpleados;
import views.ViewProductosEmpleados;
/**
 *
 * @author Octaviano
 */
public class ControllerProductosEmpleados {
    ModelProductosEmpleados modelProductosEmpleados;
    ViewProductosEmpleados viewProductosEmpleados;
 ActionListener list = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         
        }

    };

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewProductosEmpleados.jt_vista) {
            
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
            if (e.getSource() == viewProductosEmpleados.jtf_buscar) {
                modelProductosEmpleados.setTrsFiltro(new TableRowSorter(viewProductosEmpleados.jt_vista.getModel()));
                viewProductosEmpleados.jt_vista.setRowSorter(modelProductosEmpleados.getTrsFiltro());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            modelProductosEmpleados.setCadena(viewProductosEmpleados.jtf_buscar.getText());
            viewProductosEmpleados.jtf_buscar.setText(modelProductosEmpleados.getCadena());
            modelProductosEmpleados.getTrsFiltro().setRowFilter(RowFilter.regexFilter(viewProductosEmpleados.jtf_buscar.getText(), modelProductosEmpleados.getColumnaABuscar()));
        }
    };

    public ControllerProductosEmpleados(ModelProductosEmpleados modelProductosEmpleados, ViewProductosEmpleados viewProductosEmpleados) {
        this.modelProductosEmpleados = modelProductosEmpleados;
        this.viewProductosEmpleados = viewProductosEmpleados;
    
   this.viewProductosEmpleados.jtf_buscar.addKeyListener(key); //agregar elevento de keylistener en la caja e texto buscar
        this.viewProductosEmpleados.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener
        ConexionBD();
    }

    public void ConexionBD() {
        modelProductosEmpleados.Conectar();
        modelProductosEmpleados.mostrar();
        viewProductosEmpleados.jt_vista.setModel(modelProductosEmpleados.getModelo_productos()); //asignar a la tabla los valores correspondientes
    }

    public void jt_vista_MouseClicked() {
        modelProductosEmpleados.setRec(viewProductosEmpleados.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
    }
}
    
