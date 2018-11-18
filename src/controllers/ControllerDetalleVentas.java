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
public class ControllerDetalleVentas {

    public ModelDetalleVentas modelDetalleVentas;
    public ViewDetalleVentas viewDetalleVentas;
    
    MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
          if (e.getSource() == viewDetalleVentas.jT_detalle_venta) {
                jt_detalle_venta_MouseClicked();
            }  
        }
         @Override
        public void mousePressed(MouseEvent e) {
           
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
           
        }    
       
    };
    
    KeyListener key = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getSource() == viewDetalleVentas.jTF_busqueda) {
                modelDetalleVentas.setTrsFiltro(new TableRowSorter(viewDetalleVentas.jT_detalle_venta.getModel()));
                viewDetalleVentas.jT_detalle_venta.setRowSorter(modelDetalleVentas.getTrsFiltro());
            } 
        }
        @Override
        public void keyPressed(KeyEvent e) {
 
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getSource() == viewDetalleVentas.jTF_busqueda) {
                modelDetalleVentas.setCadena(viewDetalleVentas.jTF_busqueda.getText());
                viewDetalleVentas.jTF_busqueda.setText(modelDetalleVentas.getCadena());
                filtro();
            }    
        }  
    };
    
    
    
    public ControllerDetalleVentas(ModelDetalleVentas modelDetalleVentas, ViewDetalleVentas viewDetalleVentas) {
        this.modelDetalleVentas = modelDetalleVentas;
        this.viewDetalleVentas = viewDetalleVentas;
        this.viewDetalleVentas.jT_detalle_venta.addMouseListener(ml);//agregar a la table el evento de MouseListener
        this.viewDetalleVentas.jTF_busqueda.addKeyListener(key); //agregar elevento de keylistener en la tabla
        
       
        ConexionBD();
        cajas_deshabilitadas();
    }
    
     private void jt_detalle_venta_MouseClicked() {
        }
      
      /**
     * este metodo hace la conexion a la base de datos 
     * llama a los metodos conectar, mostrar  dentro del modelo 
     * muestra en la tabla los datos que contiene la variable de modelo_sucursal
     */
    public void ConexionBD(){
        modelDetalleVentas.Conectar();
        modelDetalleVentas.mostrar();
        viewDetalleVentas.jT_detalle_venta.setModel(modelDetalleVentas.getModelo_detalle_compra()); //asignar a la tabla los valores correspondientes
    }
    
     // ********************************* M E T O D O   D E   B U S Q U E D A    *******************************************
    /***
     * Metodo para filtar los datos de la busqueda
     */
    public void filtro() {
        //depende del numero de items en el jcb
                
        if (viewDetalleVentas.jCB_buscar.getSelectedItem() == "RFC empleado") {
            modelDetalleVentas.setColumnaABuscar(2); //numero de columna en la tabla donde se encuentra el registro
        }
        else if (viewDetalleVentas.jCB_buscar.getSelectedItem() == "Codigo producto") {
            modelDetalleVentas.setColumnaABuscar(4); //numero de columna en la tabla donde se encuentra el registro
        }
        modelDetalleVentas.getTrsFiltro().setRowFilter(RowFilter.regexFilter(viewDetalleVentas.jTF_busqueda.getText(), modelDetalleVentas.getColumnaABuscar()));
    }
    
     private void cajas_deshabilitadas() {
    }
    
    //***************** BOTONES Ver, nuevo y Imprimir**************************
    /**
     * Metodo que limpiara las cajas de texto para ingresar nuevo datos. 
     */

    
    
}
