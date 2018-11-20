
package controllers;


import models.ModelPromociones;
import views.ViewPromociones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author LAB-1
 */
public class ControllerPromociones {

    ModelPromociones modelPromociones;
    ViewPromociones viewPromociones;

    public ControllerPromociones(ModelPromociones modelPromociones, ViewPromociones viewPromociones) {

        this.modelPromociones = modelPromociones;
        this.viewPromociones = viewPromociones;

    }

}
