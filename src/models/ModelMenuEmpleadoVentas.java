/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.ControllerLogin;
import views.ViewLogin;

/**
 *
 * @author Octaviano
 */
public class ModelMenuEmpleadoVentas {
    public void VentanaLogin(){
        ModelLogin modelLogin = new ModelLogin();
        ViewLogin viewLogin = new ViewLogin();
        ControllerLogin controllerLogin = new ControllerLogin(modelLogin,viewLogin/*,viewMenuAdmin*/ /*,controllersLogin*/);
    }
}
