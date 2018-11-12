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
    
    ActionListener list = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewsEmpleadosVentas.jb_nuevo) {
                nuevo_ventas();
            }else if (e.getSource() == viewsEmpleadosVentas.jb_modificar) {
                modificar_ventas();
            }else if (e.getSource() == viewsEmpleadosVentas.jb_guardar) {
                Guardar();
            }              
        }
        
    };
    
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
        //agregar a la table el evento de MouseListener
        this.viewsEmpleadosVentas.jt_vista.addMouseListener(ml);
        
        viewsEmpleadosVentas.jb_guardar.setEnabled(false);//El boton guardar aparecera inhabilitado
        viewsEmpleadosVentas.jb_eliminar.setEnabled(false);//El boton guardar aparecera inhabilitado
        
        ConexionBD();
        cajas_deshabilitadas();
        setActionListener();
    }
    
     /***
     * agregar eventos de actionlistener a botones 
     */
    private void setActionListener(){
        viewsEmpleadosVentas.jb_nuevo.addActionListener(list);
        viewsEmpleadosVentas.jb_modificar.addActionListener(list);
        viewsEmpleadosVentas.jb_guardar.addActionListener(list);
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
        viewsEmpleadosVentas.jb_guardar.setEnabled(false);
        viewsEmpleadosVentas.jb_modificar.setEnabled(true);//El boton modificar aparecera habilitado
        viewsEmpleadosVentas.jb_nuevo.setEnabled(true);//El boton nuevo aparecera habilitado
        cajas_deshabilitadas();
        modelEmpleadosVentas.setRec(viewsEmpleadosVentas.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
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

    /***
     * Metodos Habilitar y deshabilitar cajas 
     */
    private void cajas_deshabilitadas() {
        viewsEmpleadosVentas.jtf_rfc.setEditable(false);
        viewsEmpleadosVentas.jtf_nombre.setEditable(false);
        viewsEmpleadosVentas.jtf_ap_pat.setEditable(false);
        viewsEmpleadosVentas.jtf_apt_mat.setEditable(false);
        viewsEmpleadosVentas.jtf_sexo.setEditable(false);
        viewsEmpleadosVentas.jtf_estado_civil.setEditable(false);
        viewsEmpleadosVentas.jtf_telefono.setEditable(false);
        viewsEmpleadosVentas.jtf_correo.setEditable(false);
        viewsEmpleadosVentas.jtf_usuario.setEditable(false);
    }
}
