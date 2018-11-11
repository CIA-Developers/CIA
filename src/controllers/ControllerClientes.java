/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.ModelClientes;
import views.ViewClientes;

/**
 *
 * @author Octaviano
 */
public class ControllerClientes {

    public ModelClientes modelClientes;
    public ViewClientes viewClientes;
    ActionListener list = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewClientes.jb_nuevo) {
                jbtn_nuevo_actionPerformed();
            }
        }
    };
    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewClientes.jt_vista) {
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

    public ControllerClientes(ModelClientes modelClientes, ViewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;
        this.viewClientes.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener

        viewClientes.jb_guardar.setEnabled(false);
//El boton guardar aparecera inhabilitado
        viewClientes.jb_eliminar.setEnabled(false);
//El boton guardar aparecera inhabilitado

        ConexionBD();
        cajas_deshabilitadas();
        setActionListener();
    }

    /**
     * Método para agregar el actionListener a cada boton
     */
    private void setActionListener() {

        viewClientes.jb_nuevo.addActionListener(list);
    }

    public void ConexionBD() {
        modelClientes.Conectar();
        modelClientes.mostrar();
        viewClientes.jt_vista.setModel(modelClientes.getModelo_Clientes()); //asignar a la tabla los valores correspondientes
    }

    public void jt_vista_MouseClicked() {
        viewClientes.jb_guardar.setEnabled(false);
        viewClientes.jb_modificar.setEnabled(true);//El boton modificar aparecera habilitado
        viewClientes.jb_nuevo.setEnabled(true);//El boton nuevo aparecera habilitado
        cajas_deshabilitadas(); // cuando se haga clic en la tabla, las cajas se volveran a deshabilitar 
        modelClientes.setRec(viewClientes.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewClientes.jtf_rfc.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 0).toString());
        viewClientes.jtf_nombre.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 1).toString());
        viewClientes.jtf_ap_pat.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 2).toString());
        viewClientes.jtf_apt_mat.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 3).toString());
        viewClientes.jtf_telefono.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 4).toString());
        viewClientes.jtf_municipio.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 5).toString());
        viewClientes.jtf_calle.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 6).toString());
        viewClientes.jtf_colonia.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 7).toString());
        viewClientes.jtf_numero.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 8).toString());
        viewClientes.jtf_correo.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 9).toString());
        viewClientes.jl_puntos.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 10).toString());

    }
    
    private void cajas_deshabilitadas() {
        viewClientes.jtf_rfc.setEditable(false);
        viewClientes.jtf_nombre.setEditable(false);
        viewClientes.jtf_ap_pat.setEditable(false);
        viewClientes.jtf_apt_mat.setEditable(false);
        viewClientes.jtf_telefono.setEditable(false);
        viewClientes.jtf_municipio.setEditable(false);
        viewClientes.jtf_colonia.setEditable(false);
        viewClientes.jtf_numero.setEditable(false);
        viewClientes.jtf_correo.setEditable(false);
    }
        private void cajas_habilitadas() {
        viewProveedores.jtf_id.setEditable(false);
        viewProveedores.jtf_nombre.setEditable(false);
        viewProveedores.jtf_ap_pat.setEditable(false);
        viewProveedores.jtf_apt_mat.setEditable(false);
        viewProveedores.jtf_telefono.setEditable(false);
        viewProveedores.jtf_municipio.setEditable(false);
        viewProveedores.jtf_colonia.setEditable(false);
        viewProveedores.jtf_numero.setEditable(false);
        viewProveedores.jtf_provincia.setEditable(false);
        viewProveedores.jtf_correo.setEditable(false);

    }


}
