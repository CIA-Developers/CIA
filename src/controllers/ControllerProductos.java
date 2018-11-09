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
import models.ModelProductos;
import views.ViewProductos;

/**
 *
 * @author Octaviano
 */
public class ControllerProductos {
    public ModelProductos modelProductos;
    public ViewProductos viewProductos;
    
    ActionListener list = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProductos.jb_nuevo) {
                //jbtn_nuevo_actionPerformed();
            }       
        }
        
    };
    
  MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewProductos.jt_vista) {
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

    public ControllerProductos(ModelProductos modelProductos, ViewProductos viewProductos) {
        this.modelProductos = modelProductos;
        this.viewProductos = viewProductos;
        this.viewProductos.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener
        ConexionBD(); //se llama a este metodo para obtener los datos en la tabla
        cajas_deshabilitadas();
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
    
    public void jt_vista_MouseClicked(){
        modelProductos.setRec(viewProductos.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewProductos.jtf_codigo_prod.setText(viewProductos.jt_vista.getValueAt(modelProductos.getRec(), 0).toString());
        viewProductos.jtf_nom_prod.setText(viewProductos.jt_vista.getValueAt(modelProductos.getRec(), 1).toString());
        viewProductos.jtf_tipo_prod.setText(viewProductos.jt_vista.getValueAt(modelProductos.getRec(), 2).toString());
        viewProductos.jtf_marca.setText(viewProductos.jt_vista.getValueAt(modelProductos.getRec(), 3).toString());
        viewProductos.jtf_precio_unitario.setText(viewProductos.jt_vista.getValueAt(modelProductos.getRec(), 4).toString());
        viewProductos.jtf_unidad_medida.setText(viewProductos.jt_vista.getValueAt(modelProductos.getRec(), 5).toString());
        viewProductos.jcb_status.setSelectedItem(viewProductos.jt_vista.getValueAt(modelProductos.getRec(), 6).toString());
        viewProductos.jl_existencia_total.setText(viewProductos.jt_vista.getValueAt(modelProductos.getRec(), 7).toString());
        viewProductos.jta_descripcion.setText(viewProductos.jt_vista.getValueAt(modelProductos.getRec(), 8).toString());
    }
    
    /***
     * Metodos Habilitar y deshabilitar cajas 
     */
    public void cajas_deshabilitadas(){
        viewProductos.jtf_codigo_prod.setEnabled(false);
        viewProductos.jtf_nom_prod.setEnabled(false);
        viewProductos.jtf_tipo_prod.setEnabled(false);
        viewProductos.jtf_marca.setEnabled(false);
        viewProductos.jtf_precio_unitario.setEnabled(false);
        viewProductos.jtf_nom_prod.setEnabled(false);
        viewProductos.jtf_unidad_medida.setEnabled(false);
        viewProductos.jcb_status.setEnabled(false);
        viewProductos.jta_descripcion.setEnabled(false);
    }
        public void cajas_habilitadas(){
        viewProductos.jtf_codigo_prod.setEnabled(true);
        viewProductos.jtf_nom_prod.setEnabled(true);
        viewProductos.jtf_tipo_prod.setEnabled(true);
        viewProductos.jtf_marca.setEnabled(true);
        viewProductos.jtf_precio_unitario.setEnabled(true);
        viewProductos.jtf_nom_prod.setEnabled(true);
        viewProductos.jtf_unidad_medida.setEnabled(true);
        viewProductos.jcb_status.setEnabled(true);
        viewProductos.jta_descripcion.setEnabled(true);
    }
    
    //***************** BOTONES Nuevo, Borrar, Guardar y Modificar**************************
    /**
     * Metodo que limpiara las cajas de texto para ingresar nuevo datos. 
     */
}
