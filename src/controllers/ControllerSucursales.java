/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelSucursales;
import views.ViewSucursales;

/**
 *
 * @author Octaviano
 */
public class ControllerSucursales {
    public ModelSucursales modelSucursales;
    public ViewSucursales viewSucursales; 
    
    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
        
    };

    public ControllerSucursales(ModelSucursales modelSucursales, ViewSucursales viewSucursales) {
        this.modelSucursales = modelSucursales;
        this.viewSucursales = viewSucursales;
        ConexionBD();
    }
    /**
     * este metodo hace la conexion a la base de datos 
     * llama a los metodos conectar, mostrar  dentro del modelo 
     * muestra en la tabla los datos que contiene la variable de modelo_sucursal
     */
    public void ConexionBD(){
        modelSucursales.Conectar();
        modelSucursales.mostrar();
        viewSucursales.jt_vista.setModel(modelSucursales.getModelo_sucursal()); //asignar a la tabla los valores correspondientes
    }
}
