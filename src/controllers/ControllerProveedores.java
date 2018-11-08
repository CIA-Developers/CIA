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
import models.ModelProveedores;
import views.ViewProveedores;

/**
 *
 * @author Octaviano
 */
public class ControllerProveedores {

    public ModelProveedores modelProveedores;
    public ViewProveedores viewProveedores;
    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewProveedores.jt_vista) {
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

    
    public ControllerProveedores(ModelProveedores modelProveedores, ViewProveedores viewProveedores) {
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
        this.viewProveedores.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener
        ConexionBD();
    }
   public void ConexionBD(){
        modelProveedores.Conectar();
        modelProveedores.mostrar();
        viewProveedores.jt_vista.setModel(modelProveedores.getModelo_Proveedores()); //asignar a la tabla los valores correspondientes
    }
 public void jt_vista_MouseClicked(){
        modelProveedores.setRec(viewProveedores.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewProveedores.jtf_id.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 0).toString());
        viewProveedores.jtf_nombre.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 1).toString());
        viewProveedores.jtf_ap_pat.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 2).toString());
        viewProveedores.jtf_apt_mat.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 3).toString());
        viewProveedores.jtf_telefono.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 4).toString());
        viewProveedores.jtf_municipio.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 5).toString());
        viewProveedores.jtf_colonia.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 6).toString());
        viewProveedores.jtf_numero.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 7).toString());
        viewProveedores.jtf_provincia.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 8).toString());
        viewProveedores.jtf_correo.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 9).toString());  
    }
    
}
