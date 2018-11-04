/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import views.ViewClientes;
import models.ModelClientes;
import controllers.ControllerClientes;

import views.ViewEmpleadosCompras;
import models.ModelEmpleadosCompras;
import controllers.ControllerEmpleadosCompras;

import views.ViewEmpleadosVentas;
import models.ModelEmpleadosVentas;
import controllers.ControllerEmpleadosVentas;

import views.ViewMenuAdmin;
import models.ModelMenuAdmin;
import controllers.ControllerMenuAdmin;

import views.ViewProductos;
import models.ModelProductos;
import controllers.ControllerProductos;

import views.ViewProveedores;
import models.ModelProveedores;
import controllers.ControllerProveedores;

import views.ViewSucursales;
import models.ModelSucursales;
import controllers.ControllerSucursales;
/**
 *
 * @author Salvador Hernández Mendoza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ModelClientes modelClientes = new ModelClientes();
        ViewClientes viewClientes= new ViewClientes();
        ControllerClientes controllerClientes = new ControllerClientes(modelClientes, viewClientes);
        
         Object[] controllers = new Object[6];
         controllers[0] = controllerClientes;
        
        ModelMenuAdmin modelMenuAdmin = new ModelMenuAdmin();
        ViewMenuAdmin viewMenuAdmin = new ViewMenuAdmin();
        ControllerMenuAdmin controllerMenuAdmin = new ControllerMenuAdmin(modelMenuAdmin, viewMenuAdmin, controllers); 
    }
    
}
