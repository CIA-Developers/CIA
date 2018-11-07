/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelEmpleadosVentas;
import views.ViewEmpleadosVentas;
/**
 *
 * @author Octaviano
 */
public class ControllerEmpleadosVentas {
    public ModelEmpleadosVentas modelEmpleadosVentas;
    public ViewEmpleadosVentas viewsEmpleadosVentas;
    
    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    };

    public ControllerEmpleadosVentas(ModelEmpleadosVentas modelEmpleadosVentas, ViewEmpleadosVentas viewsEmpleadosVentas) {
        this.modelEmpleadosVentas = modelEmpleadosVentas;
        this.viewsEmpleadosVentas = viewsEmpleadosVentas;
        ConexionBD();
       
    }
    
     /**
     * este metodo hace la conexion a la base de datos 
     * llama a los metodos conectar, mostrar  dentro del modelo 
     * muestra en la tabla los datos que contiene la variable de modelo_EmpleadosCompras
     */
    public void ConexionBD(){
         modelEmpleadosVentas.Conectar();
        modelEmpleadosVentas.mostrar();
        viewsEmpleadosVentas.jt_vista.setModel(modelEmpleadosVentas.getModelo_EmVentas()); //asignar a la tabla los valores correspondientes
    }
    
}
