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
public final class ControllerMenuAdmin {

    private final ModelMenuAdmin ModelMenuAdmin;
    private final ViewMenuAdmin viewMenuAdmin;

    /**
     * Esta variable almacena los controladores de cada vista de catalogos para
     * poder utilizarlos dentro del mismo JFrame.
     */
    private Object controllers[];

    private ControllerClientes controllerClientes;
    private ControllerEmpleadosCompras controllerEmpleadosCompras;
    private ControllerEmpleadosVentas controllerEmpleadosVentas;
    private ControllerProductos controllerProductos;
    private ControllerProveedores controllerProveedores;
    private ControllerSucursales controllerSucursales;
    private ControllerAgregarSucursal controllerAgregarSucursal;
    private ControllerDetalleCompra controllerDetalleCompra;
    private ControllerDetalleVentas controllerDetalleVentas;
    private ControllerPromociones controllerPromociones;
    private ControllerDescuentos controllerDescuentos;

    /**
     * Controlador principal donde se un el modelo y controlador del MenuAdmin
     * Recibe cada controlador de las vistas de los catalogos dentro de este
     * controlador se tiene el accesso a la programacion en el controlador de
     * cada JpanelCatalogo
     *
     * @param modelMenuAdmin
     * @param ViewMenuAdmin
     * @param controllers
     */
    public ControllerMenuAdmin(ModelMenuAdmin ModelMenuAdmin, ViewMenuAdmin viewMenuAdmin, Object[] controllers) {
        this.ModelMenuAdmin = ModelMenuAdmin;
        this.viewMenuAdmin = viewMenuAdmin;
        this.controllers = controllers;
        setControllers();
        setActionListener();
        initComponets();
    }

    /**
     * Separa cada uno de los controlladores almacendados en controllers, de
     * esta forma se puede acceder a todas las variables y métodos publicos de
     * cada uno.
     */
    public void setControllers() {
        controllerClientes = (ControllerClientes) controllers[0];
        controllerEmpleadosCompras = (ControllerEmpleadosCompras) controllers[1];
        controllerEmpleadosVentas = (ControllerEmpleadosVentas) controllers[2];
        controllerProductos = (ControllerProductos) controllers[3];
        controllerProveedores = (ControllerProveedores) controllers[4];
        controllerSucursales = (ControllerSucursales) controllers[5];
        controllerAgregarSucursal = (ControllerAgregarSucursal) controllers[6];
        controllerDetalleCompra = (ControllerDetalleCompra) controllers[7];
        controllerDetalleVentas = (ControllerDetalleVentas) controllers[8];
        controllerPromociones = (ControllerPromociones) controllers[9];
        controllerDescuentos = (ControllerDescuentos) controllers[10];
    }

    /**
     * mustra la ventana principal del menuAdmin
     */
    private void initComponets() {
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
        viewMenuAdmin.jmi_agregar_Sucursal.addActionListener(actionListener);
        viewMenuAdmin.jmi_detallecompra.addActionListener(actionListener);
        viewMenuAdmin.jmi_detalleventa.addActionListener(actionListener);
        viewMenuAdmin.jmi_promociones.addActionListener(actionListener);
        viewMenuAdmin.jmi_descuentos.addActionListener(actionListener);
        viewMenuAdmin.jmi_salir.addActionListener(actionListener);
    }
    /**
     * Evalua el componente que genero el evento y llama a un método en
     * particular.
     */
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewMenuAdmin.jmi_clientes) {
                jmi_clientes_actionPerformed();
            } else if (e.getSource() == viewMenuAdmin.jmi_empleados_compras) {
                jmi_Empleados_compras_actionPerformed();
            } else if (e.getSource() == viewMenuAdmin.jmi_empleados_ventas) {
                jmi_Empleados_ventas_actionPerformed();
            } else if (e.getSource() == viewMenuAdmin.jmi_productos) {
                jmi_productos_actionPerformed();
            } else if (e.getSource() == viewMenuAdmin.jmi_proveedores) {
                jmi_proveedores_actionPerformed();
            } else if (e.getSource() == viewMenuAdmin.jmi_sucursales) {
                jmi_sucursales_actionPerformed();
            } else if (e.getSource() == viewMenuAdmin.jmi_agregar_Sucursal) {
                jm_AgregarSucursales_actionPerformed();
            } else if (e.getSource() == viewMenuAdmin.jmi_detallecompra) {
                jmi_detallecompra_actionPerformed();
            } else if (e.getSource() == viewMenuAdmin.jmi_detalleventa) {
                jmi_detalleventa_actionPerformed();
            } else if (e.getSource() == viewMenuAdmin.jmi_promociones) {
                jmi_promociones_actionPerformed();
            } else if (e.getSource() == viewMenuAdmin.jmi_descuentos) {
                jmi_descuentos_actionPerformed();
            }else if (e.getSource() == viewMenuAdmin.jmi_salir) {
                ModelMenuAdmin.VentanaLogin();
                viewMenuAdmin.setVisible(false);
            }

        }

    };

    /**
     * Muestra el JPanel ViewClientes dentro del JFrame ViewMenuAdmin, (incluido
     * todo el funcionamiendo programado).
     */
    private void jmi_clientes_actionPerformed() {
        viewMenuAdmin.setContentPane(controllerClientes.viewClientes);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();
    }

    private void jmi_Empleados_compras_actionPerformed() {
        viewMenuAdmin.setContentPane(controllerEmpleadosCompras.viewEmpleadosCompras);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();
    }

    private void jmi_Empleados_ventas_actionPerformed() {
        viewMenuAdmin.setContentPane(controllerEmpleadosVentas.viewsEmpleadosVentas);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();
    }

    private void jmi_productos_actionPerformed() {
        viewMenuAdmin.setContentPane(controllerProductos.viewProductos);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();
    }

    private void jmi_proveedores_actionPerformed() {
        viewMenuAdmin.setContentPane(controllerProveedores.viewProveedores);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();
    }

    private void jmi_sucursales_actionPerformed() {
        viewMenuAdmin.setContentPane(controllerSucursales.viewSucursales);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();
    }

    private void jm_AgregarSucursales_actionPerformed() {
        viewMenuAdmin.setContentPane(controllerAgregarSucursal.viewAgregarSucursal);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();
    }

    private void jmi_detallecompra_actionPerformed() {
        viewMenuAdmin.setContentPane(controllerDetalleCompra.viewDetalleCompra);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();
    }

    private void jmi_detalleventa_actionPerformed() {
        viewMenuAdmin.setContentPane(controllerDetalleVentas.viewDetalleVentas);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();
    }

    private void jmi_promociones_actionPerformed() {
        viewMenuAdmin.setContentPane(controllerPromociones.viewPromociones);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();
    }

    private void jmi_descuentos_actionPerformed() {
        viewMenuAdmin.setContentPane(controllerDescuentos.viewDescuentos);
        viewMenuAdmin.revalidate();
        viewMenuAdmin.repaint();
    }
}
