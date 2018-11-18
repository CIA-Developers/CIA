/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import models.ModelDetalleCompras;
import java.awt.Container;
import views.ViewDetalleCompra;

/**
 *
 * @author Ami
 */
public class ControllerDetalleCompra {

    public ModelDetalleCompras modelDetalleCompra;
    public ViewDetalleCompra viewDetalleCompra;
    
    public ControllerDetalleCompra(ModelDetalleCompras modelDetalleCompra, ViewDetalleCompra viewDetalleCompra) {
        this.modelDetalleCompra = modelDetalleCompra;
        this.viewDetalleCompra = viewDetalleCompra;
    }
    
     /**
     * este metodo hace la conexion a la base de datos 
     * llama a los metodos conectar, mostrar  dentro del modelo 
     * muestra en la tabla los datos que contiene la variable de modelo_sucursal
     */
    public void ConexionBD(){
        modelDetalleCompra.Conectar();
        modelDetalleCompra.mostrar();
        viewDetalleCompra.jT_detalle_compra.setModel(modelDetalleCompra.getModelo_detalle_compra()); //asignar a la tabla los valores correspondientes
    }
}
