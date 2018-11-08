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
import models.ModelSucursales;
import views.ViewSucursales;

import models.ModelProveedores;
import views.ViewProveedores;
/**
 *
 * @author Octaviano
 */
public class ControllerProveedores {
    public ModelProveedores modelProveedores;
    public ViewProveedores viewProveedores; 
    
    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {

        }     
    };

    public ControllerProveedores(ModelProveedores modelProveedores, ViewProveedores viewProveedores) {
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
    }
      
}
