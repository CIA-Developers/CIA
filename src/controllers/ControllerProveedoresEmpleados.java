/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelProveedoresEmpleados;
import views.ViewSucursalesEmpleados;
/**
 *
 * @author Octaviano
 */
public class ControllerProveedoresEmpleados {
     ModelProveedoresEmpleados modelProveedoresEmpleados;
     ViewSucursalesEmpleados viewSucursalesEmpleados;

    public ControllerProveedoresEmpleados(ModelProveedoresEmpleados modelProveedoresEmpleados, ViewSucursalesEmpleados viewSucursalesEmpleados) {
        this.modelProveedoresEmpleados = modelProveedoresEmpleados;
        this.viewSucursalesEmpleados = viewSucursalesEmpleados;
    }
     
     
}
