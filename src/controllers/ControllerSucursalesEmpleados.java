/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import models.ModelSucursalesEmpleados;
import views.ViewSucursalesEmpleados;
/**
 *
 * @author Octaviano
 */
public class ControllerSucursalesEmpleados {
    ModelSucursalesEmpleados modelSucursalesEmpleados;
    ViewSucursalesEmpleados viewSucursalesEmpleados;
 ActionListener list = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         
        }

    };

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewSucursalesEmpleados.jt_vista) {
            
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
            if (e.getSource() == viewSucursalesEmpleados.jtf_buscar) {
                modelSucursalesEmpleados.setTrsFiltro(new TableRowSorter(viewSucursalesEmpleados.jt_vista.getModel()));
                viewSucursalesEmpleados.jt_vista.setRowSorter(modelSucursalesEmpleados.getTrsFiltro());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            modelSucursalesEmpleados.setCadena(viewSucursalesEmpleados.jtf_buscar.getText());
            viewSucursalesEmpleados.jtf_buscar.setText(modelSucursalesEmpleados.getCadena());
            modelSucursalesEmpleados.getTrsFiltro().setRowFilter(RowFilter.regexFilter(viewSucursalesEmpleados.jtf_buscar.getText(), modelSucursalesEmpleados.getColumnaABuscar()));
        }
    };

    
    
    
    
    public ControllerSucursalesEmpleados(ModelSucursalesEmpleados modelSucursalesEmpleados, ViewSucursalesEmpleados viewSucursalesEmpleados) {
        this.modelSucursalesEmpleados = modelSucursalesEmpleados;
        this.viewSucursalesEmpleados = viewSucursalesEmpleados;
    
   this.viewSucursalesEmpleados.jtf_buscar.addKeyListener(key); //agregar elevento de keylistener en la caja e texto buscar
        this.viewSucursalesEmpleados.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener
        ConexionBD();
    }

    public void ConexionBD() {
        modelSucursalesEmpleados.Conectar();
        modelSucursalesEmpleados.mostrar();
        viewSucursalesEmpleados.jt_vista.setModel(modelSucursalesEmpleados.getModelo_sucursal()); //asignar a la tabla los valores correspondientes
    }

    public void jt_vista_MouseClicked() {
        modelSucursalesEmpleados.setRec(viewSucursalesEmpleados.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
    }
}
    
    

