/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelClientes;
import views.ViewClientes;

/**
 *
 * @author Octaviano
 */
public class ControllerClientes {
   public ModelClientes modelClientes; 
   public ViewClientes viewClientes; 
   
   ActionListener actionListener = new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent e) {
           
       }
       
   };

    public ControllerClientes(ModelClientes modelClientes, ViewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;
        
    }
   
   
}
