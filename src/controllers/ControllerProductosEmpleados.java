/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelProductosEmpleados;
import views.ViewProductosEmpleados;
/**
 *
 * @author Octaviano
 */
public class ControllerProductosEmpleados {
    ModelProductosEmpleados modelProductosEmpleados;
    ViewProductosEmpleados viewProductosEmpleados;

    public ControllerProductosEmpleados(ModelProductosEmpleados modelProductosEmpleados, ViewProductosEmpleados viewProductosEmpleados) {
        this.modelProductosEmpleados = modelProductosEmpleados;
        this.viewProductosEmpleados = viewProductosEmpleados;
    }
    
    
}
