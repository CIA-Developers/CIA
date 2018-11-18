/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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
    
    /**
     * Variables para el metodo de busqueda
     */
    private TableRowSorter trsFiltro; // sirve para filtar los datos dentro de la tabla


    
}
