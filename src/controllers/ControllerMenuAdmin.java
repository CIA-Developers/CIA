/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelMenuAdmin;
import views.ViewMenuAdmin;
/**
 *
 * @author Octaviano
 */
public class ControllerMenuAdmin {
    
    private final ViewMenuAdmin  viewMenuAdmin;
    private final ControllerMenuAdmin controllerMenuAdmin;
    
     /**
     * Esta variable almacena los controladores de cada vista de catalogos
     * para poder utilizarlos dentro del mismo JFrame.
     */
    private Object controllers[];
    
    private ControllerClientes controllerClientes;
    private ControllerEmpleadosCompras controllerEmpleadosCompras; 
    private ControllerEmpleadosVentas controllerEmpleadosVentas;
    private ControllerProductos controllerProductos;
    private ControllerProveedores controllerProveedores;
    private ControllerSucursales controllerSucursales;

    /**
     * Controlador principal donde se un el modelo y controlador del MenuAdmin
     * Recibe cada controlador de las vistas de los catalogos 
     * dentro de este controlador se tiene el accesso a la programacion 
     * en el controlador de cada JpanelCatalogo
     * @param modelMenuAdmin
     * @param controllerMenuAdmin
     * @param controllers 
     */
    public ControllerMenuAdmin(ViewMenuAdmin viewMenuAdmin, ControllerMenuAdmin controllerMenuAdmin, Object[] controllers){
        this.viewMenuAdmin = viewMenuAdmin;
        this.controllerMenuAdmin = controllerMenuAdmin;
        this.controllers = controllers;
    }
    /**
     * Separa cada uno de los controlladores almacendados en controllers, de
     * esta forma se puede acceder a todas las variables y métodos publicos
     * de cada uno.
     */
    public void setControllers() {
        controllerClientes = (ControllerClientes) controllers[0];
        controllerEmpleadosCompras = (ControllerEmpleadosCompras) controllers[1];
        controllerEmpleadosVentas = (ControllerEmpleadosVentas) controllers[2];
        controllerProductos = (ControllerProductos) controllers[3];
        controllerProveedores = (ControllerProveedores) controllers[4];
        controllerSucursales = (ControllerSucursales) controllers[5];
    }
    /**
     * mustra la ventana principal del menuAdmin
     */
    private void initComponets(){
        viewMenuAdmin.setTitle("Menu Administrador");
        viewMenuAdmin.setLocationRelativeTo(null);
        viewMenuAdmin.setVisible(true);
    }
    /**
     * Asigna el actionListener a cada uno de los JMenuItems de la vista 
     * ViewMenuAdmin.
     */
    private void setActionListener() {
        viewMenuAdmin.jmi_clientes.addActionListener(actionListener);
        viewMenuAdmin.jmi_empleados_compras.addActionListener(actionListener);
        viewMenuAdmin.jmi_empleados_ventas.addActionListener(actionListener);
        viewMenuAdmin.jmi_productos.addActionListener(actionListener);
        viewMenuAdmin.jmi_proveedores.addActionListener(actionListener);
        viewMenuAdmin.jmi_sucursales.addActionListener(actionListener);
    }
    /**
    * Evalua el componente que genero el evento y llama a un método en particular.
    */
    private final ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    /**
    * Muestra el JPanel ViewClientes dentro del JFrame ViewMenuAdmin, (incluido todo
    * el funcionamiendo programado).
    */
    private void jmi_clientes_actionPerformed(){
       // viewMenuAdmin.setContentPane(controllerClientes.ViewClientes);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();     
    }
        
    };

}
