/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelMenuEmpleadoCompras;
import views.viewMenuEmpleadoCompras;
/**
 *
 * @author Octaviano
 */
public class ControllerMenuEmpleadoCompras {
    private final ModelMenuEmpleadoCompras modelMenuEmpleadosCompras;
    private final viewMenuEmpleadoCompras viewMenuEmpleadosCompras;
    
     /**
     * Esta variable almacena los controladores de cada vista de catalogos
     * para poder utilizarlos dentro del mismo JFrame.
     */
    private Object controllers[];
    private ControllerClientesEmpleados controllerClientesEmpleados;
    private ControllerProductosEmpleados controllerProductosEmpleados;
    private ControllerProveedoresEmpleados controllerProveedoresEmpleados;
    private ControllerSucursalesEmpleados controllerSucursalesEmpleados;
    private ControllerCOMPRAS controllerCOMPRAS;

    /**
     * Controlador principal donde se un el modelo y controlador del MenuEmpleadosCompras
     * Recibe cada controlador de las vistas de los catalogos 
     * dentro de este controlador se tiene el accesso a la programacion 
     * en el controlador de cada JpanelCatalogo
     * @param modelMenuEmpleadosCompras
     * @param viewMenuWmpleadosCompras
     * @param controllers 
     */
    public ControllerMenuEmpleadoCompras(ModelMenuEmpleadoCompras modelMenuEmpleadosCompras, viewMenuEmpleadoCompras viewMenuWmpleadosCompras, Object[] controllers) {
        this.modelMenuEmpleadosCompras = modelMenuEmpleadosCompras;
        this.viewMenuEmpleadosCompras = viewMenuWmpleadosCompras;
        this.controllers = controllers;
        setControllers();
        setActionListener();
        initComponets();
    }
    /**
     * Separa cada uno de los controlladores almacendados en controllers, de
     * esta forma se puede acceder a todas las variables y métodos publicos
     * de cada uno.
     */
    public void setControllers() {
        controllerClientesEmpleados = (ControllerClientesEmpleados) controllers[0];
        controllerProductosEmpleados = (ControllerProductosEmpleados) controllers[1];
        controllerProveedoresEmpleados = (ControllerProveedoresEmpleados) controllers[2];
        controllerSucursalesEmpleados = (ControllerSucursalesEmpleados) controllers[3];
        controllerCOMPRAS = (ControllerCOMPRAS) controllers[4];
    }
        /**
     * mustra la ventana principal del menuEmpleadosCompras
     */
    private void initComponets(){
        viewMenuEmpleadosCompras.setTitle("Menu Empleados Compras ");
        viewMenuEmpleadosCompras.setLocationRelativeTo(null);
        viewMenuEmpleadosCompras.setVisible(true);
    }
    /**
     * Asigna el actionListener a cada uno de los JMenuItems de la vista 
     * ViewMenuAdmin.
     */
    private void setActionListener() {
        viewMenuEmpleadosCompras.jmi_clientes.addActionListener(actionListener);;
        viewMenuEmpleadosCompras.jmi_productos.addActionListener(actionListener);
        viewMenuEmpleadosCompras.jmi_proveedores.addActionListener(actionListener);
        viewMenuEmpleadosCompras.jmi_sucursales.addActionListener(actionListener);
        viewMenuEmpleadosCompras.jmi_compras.addActionListener(actionListener);
    }
    private final ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           if (e.getSource() == viewMenuEmpleadosCompras.jmi_clientes) {
                jmi_clientes_actionPerformed();
           }else if (e.getSource() == viewMenuEmpleadosCompras.jmi_productos) {
                jmi_productos_actionPerformed();
           }else if (e.getSource() == viewMenuEmpleadosCompras.jmi_proveedores) {
                jmi_proveedores_actionPerformed();
           }else if (e.getSource() == viewMenuEmpleadosCompras.jmi_sucursales) {
                jmi_sucursales_actionPerformed();
           }
           else if (e.getSource() == viewMenuEmpleadosCompras.jmi_compras) {
                jmi_compras_actionPerformed();
           }
        }
    };
    /**
    * Muestra el JPanel ViewClientes dentro del JFrame ViewMenuEmpleadosCompras, (incluido todo
    * el funcionamiendo programado).
    */
    private void jmi_clientes_actionPerformed(){
        viewMenuEmpleadosCompras.setContentPane(controllerClientesEmpleados.viewClientesEmpleados);
        viewMenuEmpleadosCompras.revalidate();
        viewMenuEmpleadosCompras.repaint();     
    }
    private void jmi_productos_actionPerformed(){
        viewMenuEmpleadosCompras.setContentPane(controllerProductosEmpleados.viewProductosEmpleados);
        viewMenuEmpleadosCompras.revalidate();
        viewMenuEmpleadosCompras.repaint();     
    }
    private void jmi_proveedores_actionPerformed(){
        viewMenuEmpleadosCompras.setContentPane(controllerProveedoresEmpleados.viewProveedoresEmpleados);
        viewMenuEmpleadosCompras.revalidate();
        viewMenuEmpleadosCompras.repaint();     
    }
    private void jmi_sucursales_actionPerformed(){
        viewMenuEmpleadosCompras.setContentPane(controllerSucursalesEmpleados.viewSucursalesEmpleados);
        viewMenuEmpleadosCompras.revalidate();
        viewMenuEmpleadosCompras.repaint();     
    }
     private void jmi_compras_actionPerformed(){
        viewMenuEmpleadosCompras.setContentPane(controllerCOMPRAS.viewCOMPRAS);
        viewMenuEmpleadosCompras.revalidate();
        viewMenuEmpleadosCompras.repaint();     
    }
    
}
