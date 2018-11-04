/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelEmpleadosVentas;
import views.ViewEmpleadosVentas;
/**
 *
 * @author Octaviano
 */
public class ControllerEmpleadosVentas {
    public ModelEmpleadosVentas modelEmpleadosVentas;
    public ViewEmpleadosVentas viewsEmpleadosVentas;
    
    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    };

    public ControllerEmpleadosVentas(ModelEmpleadosVentas modelEmpleadosVentas, ViewEmpleadosVentas viewsEmpleadosVentas) {
        this.modelEmpleadosVentas = modelEmpleadosVentas;
        this.viewsEmpleadosVentas = viewsEmpleadosVentas;
    }
    
    
}
