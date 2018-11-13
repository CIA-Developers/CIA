/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelLogin; // todos los modelos
import views.ViewLogin; //todas las vistas 
/**
 *
 * @author Octaviano
 */
public class ControllerLogin {
      
   private final ModelLogin modelLogin;
   private final ViewLogin viewLogin;

   /**
     * Esta variable almacena las Vistas base 
     * para poder utilizarlos dentro del mismo JFrame.
     */
    private Object controllers[];
    
    private ControllerMenuAdmin controllerMenuAdmin;
    private ControllerEmpleadosCompras controllerEmpleadosCompras;
    private ControllerEmpleadosVentas controllerEmpleados;

    public ControllerLogin(ModelLogin modelLogin, ViewLogin viewLogin, Object[] controllers) {
        this.modelLogin = modelLogin;
        this.viewLogin = viewLogin;
        this.controllers = controllers;
    }

}
