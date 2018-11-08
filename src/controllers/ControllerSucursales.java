/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.ModelSucursales;
import views.ViewSucursales;

/**
 *
 * @author Octaviano
 */
public class ControllerSucursales {
    public ModelSucursales modelSucursales;
    public ViewSucursales viewSucursales;
    
    MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
          if (e.getSource() == viewSucursales.jt_vista) {
                jt_vista_MouseClicked();
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

    public ControllerSucursales(ModelSucursales modelSucursales, ViewSucursales viewSucursales) {
        this.modelSucursales = modelSucursales;
        this.viewSucursales = viewSucursales;
        this.viewSucursales.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener
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
    public void jt_vista_MouseClicked(){
        modelSucursales.setRec(viewSucursales.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewSucursales.jtf_no_sucursal.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 0).toString());
        viewSucursales.jtf_calle.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 1).toString());
        viewSucursales.jtf_colonia.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 2).toString());
        viewSucursales.jtf_numero.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 3).toString());
        viewSucursales.jtf_telefono.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 4).toString());
        viewSucursales.jtf_colonia.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(),5 ).toString());
        viewSucursales.jtf_codigo_prod.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 6).toString());
        viewSucursales.jtf_nom_prod.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 7).toString());
        viewSucursales.jtf_stock.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 8).toString());
        viewSucursales.jtf_stock_max.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 9).toString());
        viewSucursales.jtf_stock_min.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 10).toString());  
    }
    
}
