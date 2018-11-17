/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelMenuEmpleadoVentas;
import views.viewMenuEmpleadoVentas;
/**
 *
 * @author Octaviano
 */
public class ControllerMenuEmpleadoVentas {
    private final ModelMenuEmpleadoVentas modelMenuEmpleadosVentas;
    private final viewMenuEmpleadoVentas viewMenuEmpleadosVentas;
    
     /**
     * Esta variable almacena los controladores de cada vista de catalogos
     * para poder utilizarlos dentro del mismo JFrame.
     */
    private Object controllers[];
    private ControllerClientesEmpleados controllerClientesEmpleados;
    private ControllerProductosEmpleados controllerProductosEmpleados;
    private ControllerProveedoresEmpleados controllerProveedoresEmpleados;
    private ControllerSucursalesEmpleados controllerSucursalesEmpleados;
    private ControllerVENTAS controllerVENTAS;

    /**
     * Controlador principal donde se un el modelo y controlador del MenuEmpleadosVentas
     * Recibe cada controlador de las vistas de los catalogos 
     * dentro de este controlador se tiene el accesso a la programacion 
     * en el controlador de cada JpanelCatalogo
     * @param modelMenuEmpleadosVentas
     * @param viewMenuWmpleadosVentas 
     */
    public ControllerMenuEmpleadoVentas(ModelMenuEmpleadoVentas modelMenuEmpleadosVentas, viewMenuEmpleadoVentas viewMenuEmpleadosVentas, Object[] controllers) {    
        this.modelMenuEmpleadosVentas = modelMenuEmpleadosVentas;
        this.viewMenuEmpleadosVentas = viewMenuEmpleadosVentas;
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
        controllerVENTAS= (ControllerVENTAS) controllers[4];
    }
    /**
     * mustra la ventana principal del menuEmpleadosCompras
     */
    private void initComponets(){
        viewMenuEmpleadosVentas.setTitle("Menu Empleados Ventas ");
        viewMenuEmpleadosVentas.setLocationRelativeTo(null);
        viewMenuEmpleadosVentas.setVisible(true);
    }
    
    /**
     * Asigna el actionListener a cada uno de los JMenuItems de la vista 
     * ViewMenuAdmin.
     */
    private void setActionListener() {
        viewMenuEmpleadosVentas.jmi_clientes.addActionListener(actionListener);;
        viewMenuEmpleadosVentas.jmi_productos.addActionListener(actionListener);
        viewMenuEmpleadosVentas.jmi_proveedores.addActionListener(actionListener);
        viewMenuEmpleadosVentas.jmi_sucursales.addActionListener(actionListener);
        viewMenuEmpleadosVentas.jmi_ventas.addActionListener(actionListener);
    }
    
    private final ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           if (e.getSource() == viewMenuEmpleadosVentas.jmi_clientes) {
                jmi_clientes_actionPerformed();
           }else if (e.getSource() == viewMenuEmpleadosVentas.jmi_productos) {
                jmi_productos_actionPerformed();
           }else if (e.getSource() == viewMenuEmpleadosVentas.jmi_proveedores) {
                jmi_proveedores_actionPerformed();
           }else if (e.getSource() == viewMenuEmpleadosVentas.jmi_sucursales) {
                jmi_sucursales_actionPerformed();
           }
           else if (e.getSource() == viewMenuEmpleadosVentas.jmi_ventas) {
                jmi_ventas_actionPerformed();
           }
        }
          /**
    * Muestra el JPanel ViewClientes dentro del JFrame ViewMenuEmpleadosCompras, (incluido todo
    * el funcionamiendo programado).
    */
    private void jmi_clientes_actionPerformed(){
        viewMenuEmpleadosVentas.setContentPane(controllerClientesEmpleados.viewClientesEmpleados);
        viewMenuEmpleadosVentas.revalidate();
        viewMenuEmpleadosVentas.repaint();     
    }
    private void jmi_productos_actionPerformed(){
        viewMenuEmpleadosVentas.setContentPane(controllerProductosEmpleados.viewProductosEmpleados);
        viewMenuEmpleadosVentas.revalidate();
        viewMenuEmpleadosVentas.repaint();     
    }
    private void jmi_proveedores_actionPerformed(){
        viewMenuEmpleadosVentas.setContentPane(controllerProveedoresEmpleados.viewProveedoresEmpleados);
        viewMenuEmpleadosVentas.revalidate();
        viewMenuEmpleadosVentas.repaint();     
    }
    private void jmi_sucursales_actionPerformed(){
        viewMenuEmpleadosVentas.setContentPane(controllerSucursalesEmpleados.viewSucursalesEmpleados);
        viewMenuEmpleadosVentas.revalidate();
        viewMenuEmpleadosVentas.repaint();     
    }
     private void jmi_ventas_actionPerformed(){
        viewMenuEmpleadosVentas.setContentPane(controllerVENTAS.viewVENTAS);
        viewMenuEmpleadosVentas.revalidate();
        viewMenuEmpleadosVentas.repaint();     
    } 
    };
}
    
