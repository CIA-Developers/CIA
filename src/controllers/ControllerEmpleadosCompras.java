/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelEmpleadosCompras;
import views.ViewEmpleadosCompras;
/**
 *
 * @author Octaviano
 */
public class ControllerEmpleadosCompras {
    public ModelEmpleadosCompras modelEmpleadosCompras;
    public ViewEmpleadosCompras viewEmpleadosCompras;
    
    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }    
    };

    public ControllerEmpleadosCompras(ModelEmpleadosCompras modelEmpleadosCompras, ViewEmpleadosCompras viewEmpleadosCompras) {
        this.modelEmpleadosCompras = modelEmpleadosCompras;
        this.viewEmpleadosCompras = viewEmpleadosCompras;
    }
    
    /**
     * este metodo hace la conexion a la base de datos 
     * llama a los metodos conectar, mostrar  dentro del modelo 
     * muestra en la tabla los datos que contiene la variable de modelo_EmpleadosCompras
     */
    public void ConexionBD(){
        modelEmpleadosCompras.Conectar();
        modelEmpleadosCompras.mostrar();
        viewEmpleadosCompras.jt_vista.setModel(viewEmpleadosCompras()); //asignar a la tabla los valores correspondientes
    }
    
    
}
