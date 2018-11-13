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

    /**
     * Controlador principal donde se un el modelo y controlador de cada menu prinipal
     * Recibe cada controlador de las vistas de los menus
     * dentro de este controlador se tiene el accesso a la programacion 
     * en el controlador de cada menu
     * @param modelLogin
     * @param viewLogin
     * @param controllers 
     */
    public ControllerLogin(ModelLogin modelLogin, ViewLogin viewLogin, Object[] controllers) {
        this.modelLogin = modelLogin;
        this.viewLogin = viewLogin;
        this.controllers = controllers;
        initComponets();
        setControllers();
    }
    
    /**
     * Separa cada uno de los controlladores almacendados en controllers, de
     * esta forma se puede acceder a todas las variables y métodos publicos
     * de cada uno.
     */
    public void setControllers() {
        controllerMenuAdmin = (ControllerMenuAdmin) controllers[0];
    }
    /**
     * mustra la ventana principal del menuAdmin
     */
    private void initComponets(){
        viewLogin.setTitle("LOGIN");
        viewLogin.setLocationRelativeTo(null);
        viewLogin.setVisible(true);
    }

}
