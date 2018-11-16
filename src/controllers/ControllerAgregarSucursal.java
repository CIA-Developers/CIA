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
        viewAgregarSucursal.jt_vista.setModel(modelAgregarSucursal.getModelo_AgregarSucursal()); //asignar a la tabla los valores correspondientes

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
        viewAgregarSucursal.jtf_no_sucursal.setEditable(false);
        viewAgregarSucursal.jtf_calle.setEditable(false);
        viewAgregarSucursal.jtf_colonia.setEditable(false);
        viewAgregarSucursal.jtf_numero.setEditable(false);
        viewAgregarSucursal.jtf_telefono.setEditable(false);

    }

    private void cajas_habilitadas() {
        viewAgregarSucursal.jtf_no_sucursal.setEditable(true);
        viewAgregarSucursal.jtf_calle.setEditable(true);
        viewAgregarSucursal.jtf_colonia.setEditable(true);
        viewAgregarSucursal.jtf_numero.setEditable(true);
        viewAgregarSucursal.jtf_telefono.setEditable(true);

    }

    public void nuevo_AgregarSucursal() {
        viewAgregarSucursal.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewAgregarSucursal.jb_modificar.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
        modelAgregarSucursal.setVerificar(1);// le da el valor a verificar de cero para identificar un nuevo registro
        viewAgregarSucursal.jtf_no_sucursal.setText(modelAgregarSucursal.getLimpiar());
        viewAgregarSucursal.jtf_calle.setText(modelAgregarSucursal.getLimpiar());
        viewAgregarSucursal.jtf_colonia.setText(modelAgregarSucursal.getLimpiar());
        viewAgregarSucursal.jtf_numero.setText(modelAgregarSucursal.getLimpiar());
        viewAgregarSucursal.jtf_telefono.setText(modelAgregarSucursal.getLimpiar());
        cajas_habilitadas();//llamar al metodo de cajas habilitadas para proceder a escribir un nuevo registro 

    }

    public void modificar_AgregarSucursal() {
        viewAgregarSucursal.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewAgregarSucursal.jb_modificar.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
        modelAgregarSucursal.setVerificar(2);// le da el valor a verificar de uno para identificar Modifiar registro
        viewAgregarSucursal.jtf_no_sucursal.setEditable(false); // el codigo no se puede modificar
        viewAgregarSucursal.jtf_calle.setEditable(true);
        viewAgregarSucursal.jtf_colonia.setEditable(true);
        viewAgregarSucursal.jtf_numero.setEditable(true);
        viewAgregarSucursal.jtf_telefono.setEditable(true);

    }

    public void GuardarAgregarSucursal() {
        // si la variable verificar es igual a 0 se llama al metodo de guardar Nuevo
        if (modelAgregarSucursal.getVerificar() == 1) {
            // darle el valor a las variables
            modelAgregarSucursal.setNo_sucursal(viewAgregarSucursal.jtf_no_sucursal.getText());
            modelAgregarSucursal.setCalle(viewAgregarSucursal.jtf_calle.getText());
            modelAgregarSucursal.setColonia(viewAgregarSucursal.jtf_colonia.getText());
            modelAgregarSucursal.setNumero(viewAgregarSucursal.jtf_numero.getText());
            modelAgregarSucursal.setTelefono(viewAgregarSucursal.jtf_telefono.getText());
            modelAgregarSucursal.Guardar_Nuevo(); // metodo de  insertar nuevo registro 
        } else {
            // darle el valor a las variables
            modelAgregarSucursal.setNo_sucursal(viewAgregarSucursal.jtf_no_sucursal.getText());
            modelAgregarSucursal.setCalle(viewAgregarSucursal.jtf_calle.getText());
            modelAgregarSucursal.setColonia(viewAgregarSucursal.jtf_colonia.getText());
            modelAgregarSucursal.setNumero(viewAgregarSucursal.jtf_numero.getText());
            modelAgregarSucursal.setTelefono(viewAgregarSucursal.jtf_telefono.getText());

        }
                //LIMPIAR TABLA 
        for (int i = 0; i < viewAgregarSucursal.jt_vista.getRowCount(); i++) {
            modelAgregarSucursal.getModelo_AgregarSucursal().removeRow(i);
            i -= 1;
        }
        //mostrar los nuevos datos 
        modelAgregarSucursal.mostrar();

    }
}
