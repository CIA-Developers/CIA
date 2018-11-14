/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelClientesEmpleados;
import views.ViewClientesEmpleados;
import views.ViewClientesEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import models.ModelProveedoresEmpleados;
import views.ViewProveedoresEmpleados;

/**
 *
 * @author Octaviano
 */
public class ControllerClientesEmpleados {
    ModelClientesEmpleados modelClientesEmpleados;
    ViewClientesEmpleados viewClientesEmpleados;
    ActionListener list = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         
        }

    };

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewClientesEmpleados.jt_vista) {
            
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
            if (e.getSource() == viewClientesEmpleados.jtf_buscar) {
                modelClientesEmpleados.setTrsFiltro(new TableRowSorter(viewClientesEmpleados.jt_vista.getModel()));
                viewClientesEmpleados.jt_vista.setRowSorter(modelClientesEmpleados.getTrsFiltro());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            modelClientesEmpleados.setCadena(viewClientesEmpleados.jtf_buscar.getText());
            viewClientesEmpleados.jtf_buscar.setText(modelClientesEmpleados.getCadena());
            modelClientesEmpleados.getTrsFiltro().setRowFilter(RowFilter.regexFilter(viewClientesEmpleados.jtf_buscar.getText(), modelClientesEmpleados.getColumnaABuscar()));
        }
    };

    
    
    
    
    public ControllerClientesEmpleados(ModelClientesEmpleados menuClientesEmpleados, ViewClientesEmpleados viewClientesEmpleados) {
        this.modelClientesEmpleados = menuClientesEmpleados;
        this.viewClientesEmpleados = viewClientesEmpleados;
    

   this.viewClientesEmpleados.jtf_buscar.addKeyListener(key); //agregar elevento de keylistener en la caja e texto buscar
        this.viewClientesEmpleados.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener
        ConexionBD();
    }

    public void ConexionBD() {
        modelClientesEmpleados.Conectar();
        modelClientesEmpleados.mostrar();
        viewClientesEmpleados.jt_vista.setModel(modelClientesEmpleados.getModelo_Proveedores()); //asignar a la tabla los valores correspondientes
    }

    public void jt_vista_MouseClicked() {
        modelClientesEmpleados.setRec(viewClientesEmpleados.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
    }
}

   

    

