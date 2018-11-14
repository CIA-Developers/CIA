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
/**
 *
 * @author Octaviano
 */
public class ControllerClientesEmpleados {
    ModelClientesEmpleados menuClientesEmpleados;
    ViewClientesEmpleados viewClientesEmpleados;

    public ControllerClientesEmpleados(ModelClientesEmpleados menuClientesEmpleados, ViewClientesEmpleados viewClientesEmpleados) {
        this.menuClientesEmpleados = menuClientesEmpleados;
        this.viewClientesEmpleados = viewClientesEmpleados;
    }
    
    
}
