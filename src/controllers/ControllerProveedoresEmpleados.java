/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelProveedoresEmpleados;
import views.ViewProveedoresEmpleados;
import views.ViewProveedoresEmpleados;
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
public class ControllerProveedoresEmpleados {
     ModelProveedoresEmpleados modelProveedoresEmpleados;
     ViewProveedoresEmpleados viewProveedoresEmpleados;
    ActionListener list = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         
        }

    };

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewProveedoresEmpleados.jt_vista) {
            
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
            if (e.getSource() == viewProveedoresEmpleados.jtf_buscar) {
                modelProveedoresEmpleados.setTrsFiltro(new TableRowSorter(viewProveedoresEmpleados.jt_vista.getModel()));
                viewProveedoresEmpleados.jt_vista.setRowSorter(modelProveedoresEmpleados.getTrsFiltro());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            modelProveedoresEmpleados.setCadena(viewProveedoresEmpleados.jtf_buscar.getText());
            viewProveedoresEmpleados.jtf_buscar.setText(modelProveedoresEmpleados.getCadena());
            modelProveedoresEmpleados.getTrsFiltro().setRowFilter(RowFilter.regexFilter(viewProveedoresEmpleados.jtf_buscar.getText(), modelProveedoresEmpleados.getColumnaABuscar()));
        }
    };

    public ControllerProveedoresEmpleados(ModelProveedoresEmpleados modelProveedoresEmpleados, ViewProveedoresEmpleados viewProveedoresEmpleados) {
        this.modelProveedoresEmpleados = modelProveedoresEmpleados;
        this.viewProveedoresEmpleados = viewProveedoresEmpleados;
    


   this.viewProveedoresEmpleados.jtf_buscar.addKeyListener(key); //agregar elevento de keylistener en la caja e texto buscar
        this.viewProveedoresEmpleados.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener

       

        
        setActionListener();
        ConexionBD();
    }

    /**
     * Método para agregar el actionListener a cada boton
     */
    private void setActionListener() {

     
    }

    public void ConexionBD() {
        modelProveedoresEmpleados.Conectar();
        modelProveedoresEmpleados.mostrar();
        viewProveedoresEmpleados.jt_vista.setModel(modelProveedoresEmpleados.getModelo_Proveedores()); //asignar a la tabla los valores correspondientes
    }

    public void jt_vista_MouseClicked() {

      
        modelProveedoresEmpleados.setRec(viewProveedoresEmpleados.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
    }
}

   

    
