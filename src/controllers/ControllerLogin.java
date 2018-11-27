/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*; // todos los modelos
import views.*; //todas las vistas 
import main.*; //importamos todas la clases main
/**
 *
 * @author Octaviano
 */
public class ControllerLogin {
     
    ViewMenuAdmin viewMenuAdmin;
    
   private final ModelLogin modelLogin;
   private final ViewLogin viewLogin;

   MenuAdmin admin;
   
   ViewMenuAdmin viewmenuAdmin;
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
    public ControllerLogin(ModelLogin modelLogin, ViewLogin viewLogin /*, ViewMenuAdmin viewmenuAdmin*//*, viewMenuEmpleadoCompras viewMenuEmpleadoCompras, viewMenuEmpleadoVentas viewMenuEmpleadoVentas*/){
        this.modelLogin = modelLogin;
        this.viewLogin = viewLogin;
        viewLogin.jb_aceptar.addActionListener(actionListener); //agrega el evento ActionListener 
        viewLogin.jb_cancelar.addActionListener(actionListener); //agrega el evento ActionListener 
        //this.controllers = controllers;
        initComponets();
    }
    
    private void initComponets() {
        viewLogin.setTitle("LOGIN");
        viewLogin.setLocationRelativeTo(null);
        viewLogin.setVisible(true);
    }
    
        private final ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           if (e.getSource() == viewLogin.jb_aceptar) {
               opciones();
           }else if (e.getSource() == viewLogin.jb_cancelar) {
               viewLogin.setVisible(false);
               System.exit(0);
           }
        }    
    };
    
    public void opciones(){
        if (viewLogin.jcb_tipo_admin.getSelectedItem() == "Administrador"){
            modelLogin.muenuAdmin();
            viewLogin.setVisible(false); //ocultar el login          
        }
        else if (viewLogin.jcb_tipo_admin.getSelectedItem() == "Empleado Ventas"){
            modelLogin.empleadosVentas();
            viewLogin.setVisible(false); //ocultar el login 
        }
        else if (viewLogin.jcb_tipo_admin.getSelectedItem() == "Empleado Compras"){ 
            modelLogin.EmpleadosCompras();
            viewLogin.setVisible(false); //ocultar el login 
        }
    }
    
}
