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
import models.ModelDetalleVentas;
import java.awt.Container;
import views.ViewDetalleVentas;

/**
 *
 * @author Ami
 */
public class ControllerDetalleVenta {
  public ModelDetalleVentas modelDetalleVentas;
    public ViewDetalleVentas viewDetalleVentas;
    

       public ControllerDetalleVenta (ModelDetalleVentas modelDetalleVenta, ViewDetalleVentas viewDetalleVenta) {
        this.modelDetalleVentas = modelDetalleVentas;
        this.viewDetalleVentas = viewDetalleVentas;
}
}