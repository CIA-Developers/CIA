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
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import views.ViewDetalleCompra;

/**
 *
 * @author Ami
 */
public class ControllerDetalleCompra {

    public ModelDetalleCompras modelDetalleCompra;
    public ViewDetalleCompra viewDetalleCompra;
    
    MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
          if (e.getSource() == viewDetalleCompra.jT_detalle_compra) {
                jt_detalle_compra_MouseClicked();
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
            if (e.getSource() == viewDetalleCompra.jTF_busqueda) {
                modelDetalleCompra.setTrsFiltro(new TableRowSorter(viewDetalleCompra.jT_detalle_compra.getModel()));
                viewDetalleCompra.jT_detalle_compra.setRowSorter(modelDetalleCompra.getTrsFiltro());
            } 
        }
        @Override
        public void keyPressed(KeyEvent e) {
 
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getSource() == viewDetalleCompra.jTF_busqueda) {
                modelDetalleCompra.setCadena(viewDetalleCompra.jTF_busqueda.getText());
                viewDetalleCompra.jTF_busqueda.setText(modelDetalleCompra.getCadena());
                filtro();
            }    
        }    
    };
    
    public ControllerDetalleCompra(ModelDetalleCompras modelDetalleCompra, ViewDetalleCompra viewDetalleCompra) {
        this.modelDetalleCompra = modelDetalleCompra;
        this.viewDetalleCompra = viewDetalleCompra;
        this.viewDetalleCompra.jT_detalle_compra.addMouseListener(ml);//agregar a la table el evento de MouseListener
        this.viewDetalleCompra.jTF_busqueda.addKeyListener(key); //agregar elevento de keylistener en la tabla
        
       
        ConexionBD();
        cajas_deshabilitadas();
    }
    
     private void jt_detalle_compra_MouseClicked() {
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
    
     // ********************************* M E T O D O   D E   B U S Q U E D A    *******************************************
    /***
     * Metodo para filtar los datos de la busqueda
     */
    public void filtro() {
        //depende del numero de items en el jcb
                
        if (viewDetalleCompra.jCB_buscar.getSelectedItem() == "RFC empleado") {
            modelDetalleCompra.setColumnaABuscar(2); //numero de columna en la tabla donde se encuentra el registro
        }
        else if (viewDetalleCompra.jCB_buscar.getSelectedItem() == "Codigo producto") {
            modelDetalleCompra.setColumnaABuscar(4); //numero de columna en la tabla donde se encuentra el registro
        }
        modelDetalleCompra.getTrsFiltro().setRowFilter(RowFilter.regexFilter(viewDetalleCompra.jTF_busqueda.getText(), modelDetalleCompra.getColumnaABuscar()));
    }

    private void cajas_deshabilitadas() {
        viewDetalleCompra.jTF_mejor_comprador.setEditable(false);
        viewDetalleCompra.jTF_prod_mas_comprado.setEditable(false);
        viewDetalleCompra.jTF_prod_menos_comprado.setEditable(false);
    }
    
    private void cajas_habilitadas() {
        viewDetalleCompra.jTF_mejor_comprador.setEditable(true);
        viewDetalleCompra.jTF_prod_mas_comprado.setEditable(true);
        viewDetalleCompra.jTF_prod_menos_comprado.setEditable(true);
        
    }
    
    //***************** BOTONES Ver, nuevo y Imprimir**************************
    /**
     * Metodo que limpiara las cajas de texto para ingresar nuevo datos. 
     */
    
    public void nuevo_DetalleVenta(){
       
        //limpiar cada caja de la Interfaz 
        viewDetalleCompra.jDC_fe_inicio.setCalendar(null);
        viewDetalleCompra.jTF_mejor_comprador.setText(modelDetalleCompra.getLimpiar());
        viewDetalleCompra.jTF_prod_mas_comprado.setText(modelDetalleCompra.getLimpiar());
        viewDetalleCompra.jTF_prod_menos_comprado.setText(modelDetalleCompra.getLimpiar());
        cajas_habilitadas();//llamar al metodo de cajas habilitadas para proceder a escribir un nuevo registro 
    }

    
}
