/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelProveedoresEmpleados;
import views.ViewProveedoresEmpleados;
import views.ViewProveedoresEmpleados;
/**
 *
 * @author Octaviano
 */
public class ControllerProveedoresEmpleados {
     ModelProveedoresEmpleados modelProveedoresEmpleados;
     ViewProveedoresEmpleados viewProveedoresEmpleados;

    public ControllerProveedoresEmpleados(ModelProveedoresEmpleados modelProveedoresEmpleados, ViewProveedoresEmpleados viewProveedoresEmpleados) {
        this.modelProveedoresEmpleados = modelProveedoresEmpleados;
        this.viewProveedoresEmpleados = viewProveedoresEmpleados;
    }

    
}
