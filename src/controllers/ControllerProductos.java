/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelProductos;
import views.ViewProductos;

/**
 *
 * @author Octaviano
 */
public class ControllerProductos {
    public ModelProductos modelProductos;
    public ViewProductos viewProductos;
    
    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }     
    }; 

    public ControllerProductos(ModelProductos modelProductos, ViewProductos viewProductos) {
        this.modelProductos = modelProductos;
        this.viewProductos = viewProductos;
        ConexionBD(); //se llama a este metodo para obtener los datos en la tabla
    }
    
    /**
     * este metodo hace la conexion a la base de datos 
     * llama a los metodos conectar, mostrar  dentro del modelo 
     * muestra en la tabla los datos que contiene la variable de modelo_productos
     */
    public void ConexionBD(){
        modelProductos.Conectar();
        modelProductos.mostrar();
        viewProductos.jt_vista.setModel(modelProductos.getModelo_productos()); //asignar a la tabla los valores correspondientes
    }
    
}
