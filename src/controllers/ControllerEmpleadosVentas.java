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
import models.ModelEmpleadosVentas;
import views.ViewEmpleadosVentas;
/**
 *
 * @author Octaviano
 */
public class ControllerEmpleadosVentas {
    public ModelEmpleadosVentas modelEmpleadosVentas;
    public ViewEmpleadosVentas viewsEmpleadosVentas;
    
   MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
          if (e.getSource() == viewsEmpleadosVentas.jt_vista) {
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

    public ControllerEmpleadosVentas(ModelEmpleadosVentas modelEmpleadosVentas, ViewEmpleadosVentas viewsEmpleadosVentas) {
        this.modelEmpleadosVentas = modelEmpleadosVentas;
        this.viewsEmpleadosVentas = viewsEmpleadosVentas;
        this.viewsEmpleadosVentas.jt_vista.addMouseListener(ml);
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
        //asignar a la tabla los valores correspondientes
        viewsEmpleadosVentas.jt_vista.setModel(modelEmpleadosVentas.getModelo_EmVentas()); 
    }
    
    //variable que se le asigna el elemento seleccionado en la tabla
    private void jt_vista_MouseClicked() {
            modelEmpleadosVentas.setRec(viewsEmpleadosVentas.jt_vista.getSelectedRow());
        viewsEmpleadosVentas.jtf_rfc.setText(viewsEmpleadosVentas.jt_vista.getValueAt(modelEmpleadosVentas.getRec(), 0).toString());
        viewsEmpleadosVentas.jtf_nombre.setText(viewsEmpleadosVentas.jt_vista.getValueAt(modelEmpleadosVentas.getRec(), 1).toString());
        viewsEmpleadosVentas.jtf_ap_pat.setText(viewsEmpleadosVentas.jt_vista.getValueAt(modelEmpleadosVentas.getRec(), 2).toString());
        viewsEmpleadosVentas.jtf_apt_mat.setText(viewsEmpleadosVentas.jt_vista.getValueAt(modelEmpleadosVentas.getRec(), 3).toString());
        viewsEmpleadosVentas.jtf_sexo.setText(viewsEmpleadosVentas.jt_vista.getValueAt(modelEmpleadosVentas.getRec(), 4).toString());
        viewsEmpleadosVentas.jtf_estado_civil.setText(viewsEmpleadosVentas.jt_vista.getValueAt(modelEmpleadosVentas.getRec(), 5).toString());
        viewsEmpleadosVentas.jtf_telefono.setText(viewsEmpleadosVentas.jt_vista.getValueAt(modelEmpleadosVentas.getRec(), 6).toString());
        viewsEmpleadosVentas.jtf_correo.setText(viewsEmpleadosVentas.jt_vista.getValueAt(modelEmpleadosVentas.getRec(), 7).toString());
        viewsEmpleadosVentas.jtf_usuario.setText(viewsEmpleadosVentas.jt_vista.getValueAt(modelEmpleadosVentas.getRec(), 8).toString());
    }       
    
}
