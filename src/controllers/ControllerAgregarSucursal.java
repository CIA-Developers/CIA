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
            if (e.getSource() == viewProveedores.jb_nuevo) {
                nuevo_proveedores();
            } else if (e.getSource() == viewProveedores.jb_modificar) {
                modificar_proveedores();
            } else if (e.getSource() == viewProveedores.jb_guardar) {
                Guardar();
            }
        }

    };
    public ControllerAgregarSucursal(ModelAgregarSucursal modelAgregarSucursal, ViewAgregarSucursal viewAgregarSucursal) {
        this.modelAgregarSucursal = modelAgregarSucursal;
        this.viewAgregarSucursal = viewAgregarSucursal;
    }

     
}
