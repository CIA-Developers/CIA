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
                nuevo_AgregarSucursal();
            } else if (e.getSource() == viewAgregarSucursal.jb_modificar) {
                modificar_AgregarSucursal();
            } else if (e.getSource() == viewAgregarSucursal.jb_guardar) {
                GuardarAgregarSucursal();
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
        this.viewAgregarSucursal.jtf_buscar.addKeyListener(key); //agregar elevento de keylistener en la caja e texto buscar
        this.viewAgregarSucursal.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener

        viewAgregarSucursal.jb_guardar.setEnabled(false);
//El boton guardar aparecera inhabilitado
        viewAgregarSucursal.jb_eliminar.setEnabled(false);
//El boton guardar aparecera inhabilitado

        cajas_deshabilitadas();
        setActionListener();
        ConexionBD();
    }

    private void setActionListener() {

        viewAgregarSucursal.jb_nuevo.addActionListener(list);
        viewAgregarSucursal.jb_modificar.addActionListener(list);
        viewAgregarSucursal.jb_guardar.addActionListener(list);
    }

    public void ConexionBD() {
        modelAgregarSucursal.Conectar();
        modelAgregarSucursal.mostrar();
        viewAgregarSucursal.jt_vista.setModel(modelAgregarSucursal.getModelo_Proveedores()); //asignar a la tabla los valores correspondientes

    }

    public void jt_vista_MouseClicked() {
        viewAgregarSucursal.jb_guardar.setEnabled(false);
        viewAgregarSucursal.jb_modificar.setEnabled(true);//El boton modificar aparecera habilitado
        viewAgregarSucursal.jb_nuevo.setEnabled(true);//El boton nuevo aparecera habilitado
        cajas_deshabilitadas(); // cuando se haga clic en la tabla, las cajas se volveran a deshabilitar 
        modelAgregarSucursal.setRec(viewAgregarSucursal.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewAgregarSucursal.jtf_no_sucursal.setText(viewAgregarSucursal.jt_vista.getValueAt(modelAgregarSucursal.getRec(), 0).toString());
        viewAgregarSucursal.jtf_calle.setText(viewAgregarSucursal.jt_vista.getValueAt(modelAgregarSucursal.getRec(), 1).toString());
        viewAgregarSucursal.jtf_colonia.setText(viewAgregarSucursal.jt_vista.getValueAt(modelAgregarSucursal.getRec(), 2).toString());
        viewAgregarSucursal.jtf_numero.setText(viewAgregarSucursal.jt_vista.getValueAt(modelAgregarSucursal.getRec(), 3).toString());
        viewAgregarSucursal.jtf_telefono.setText(viewAgregarSucursal.jt_vista.getValueAt(modelAgregarSucursal.getRec(), 4).toString());
    }

    private void cajas_deshabilitadas() {
    }

    private void cajas_habilitadas() {
    }

    public void nuevo_AgregarSucursal() {
    }

    public void modificar_AgregarSucursal() {
    }

    public void GuardarAgregarSucursal() {
    }

}
