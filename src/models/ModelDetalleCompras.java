/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ami
 */
public class ModelDetalleCompras {
     //la variable modelo almacenara los tados de la tabla
        DefaultTableModel modelo_sucursal = new DefaultTableModel();

    public DefaultTableModel getModelo_sucursal() {
        return modelo_sucursal;
    }

    public void setModelo_sucursal(DefaultTableModel modelo_sucursal) {
        this.modelo_sucursal = modelo_sucursal;
    }

    
}
