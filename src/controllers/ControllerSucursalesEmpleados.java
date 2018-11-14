/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelSucursalesEmpleados;
import views.ViewSucursalesEmpleados;
/**
 *
 * @author Octaviano
 */
public class ControllerSucursalesEmpleados {
    ModelSucursalesEmpleados modelSucursalesEmpleados;
    ViewSucursalesEmpleados viewSucursalesEmpleados;

    public ControllerSucursalesEmpleados(ModelSucursalesEmpleados modelSucursalesEmpleados, ViewSucursalesEmpleados viewSucursalesEmpleados) {
        this.modelSucursalesEmpleados = modelSucursalesEmpleados;
        this.viewSucursalesEmpleados = viewSucursalesEmpleados;
    }
    
    
}
