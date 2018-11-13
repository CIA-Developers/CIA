/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import main.*; //agregar las interfaces base 
import models.*; // todos los modelos
import views.*; //todas las vistas 
/**
 *
 * @author Octaviano
 */
public class ControllerLOGIN {
    private final ModelLOGIN modelLogin = new ModelLOGIN();
    private final ViewLOGIN viewLogin = new ViewLOGIN();
    
    /**
     * Esta variable almacena las Vistas base 
     * para poder utilizarlos dentro del mismo JFrame.
     */
    private Object controllers[];
    
    private ControllerMenuAdmin controllerMenuAdmin;
    private ControllerEmpleadosCompras controllerEmpleadosCompras;
    private ControllerEmpleadosVentas controllerEmpleadosventas;
    
    
   
}
