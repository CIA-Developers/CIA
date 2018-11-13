/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.ModelEmpleadosCompras;
import views.ViewEmpleadosCompras;
/**
 *
 * @author Octaviano
 */
public class ControllerEmpleadosCompras {
    public ModelEmpleadosCompras modelEmpleadosCompras;
    public ViewEmpleadosCompras viewEmpleadosCompras;
    
    ActionListener list = new ActionListener(){
        @Override
       public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewEmpleadosCompras.jb_nuevo) {
                nuevo_empleado();
            }else if (e.getSource() == viewEmpleadosCompras.jb_modificar) {
                modificar_empleado();
            }else if (e.getSource() == viewEmpleadosCompras.jb_guardar) {
                Guardar();
            }              
        }
    };
    
    MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
          if (e.getSource() == viewEmpleadosCompras.jt_vista) {
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
    
        
    public ControllerEmpleadosCompras(ModelEmpleadosCompras modelEmpleadosCompras, ViewEmpleadosCompras viewEmpleadosCompras) {
        this.modelEmpleadosCompras = modelEmpleadosCompras;
        this.viewEmpleadosCompras = viewEmpleadosCompras;
          this.viewEmpleadosCompras.jtf_buscar.addKeyListener(key); 
//agregar elevento de keylistener en la caja e texto buscar
        //agregar a la table el evento de MouseListener
        this.viewEmpleadosCompras.jt_vista.addMouseListener(ml);
        
        //Boton Guardar inhabilitado
         viewEmpleadosCompras.jb_guardar.setEnabled(false);
         //Boton Eliminar inhabilitado
        viewEmpleadosCompras.jb_eliminar.setEnabled(false);
        
        ConexionBD();
        setActionListener();
        cajas_deshabilitadas();
        
    }
    
    /**
     * Método para agregar el actionListener a cada boton
     */
     private void setActionListener() {
          viewEmpleadosCompras.jb_nuevo.addActionListener(list);
          viewEmpleadosCompras.jb_modificar.addActionListener(list);
          viewEmpleadosCompras.jb_guardar.addActionListener(list);
    }
    
    /**
     * este metodo hace la conexion a la base de datos 
     * llama a los metodos conectar, mostrar  dentro del modelo 
     * muestra en la tabla los datos que contiene la variable de modelo_EmpleadosCompras
     */
    public void ConexionBD(){
         modelEmpleadosCompras.Conectar();
        modelEmpleadosCompras.mostrar();
        viewEmpleadosCompras.jt_vista.setModel(modelEmpleadosCompras.getModelo_EmCompras()); //asignar a la tabla los valores correspondientes
    }
    
    private void jt_vista_MouseClicked() {
 modelEmpleadosCompras.setRec(viewEmpleadosCompras.jt_vista.getSelectedRow());
    //variable que se le asigna el elemento seleccionado en la tabla
        viewEmpleadosCompras.jtf_rfc.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 0).toString());
        viewEmpleadosCompras.jtf_nombre.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 1).toString());
        viewEmpleadosCompras.jtf_ap_pat.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 2).toString());
        viewEmpleadosCompras.jtf_apt_mat.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 3).toString());
        viewEmpleadosCompras.jCB_sexo.setSelectedItem(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 4).toString());
        viewEmpleadosCompras.jtf_estado_civil.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 5).toString());
        viewEmpleadosCompras.jtf_Telefono.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 6).toString());
        viewEmpleadosCompras.jtf_correo.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 7).toString());
        viewEmpleadosCompras.jtf_usuario.setText(viewEmpleadosCompras.jt_vista.getValueAt(modelEmpleadosCompras.getRec(), 8).toString());
    }        

   /***
     * Metodos Habilitar y deshabilitar cajas 
     */
     public void cajas_deshabilitadas(){
        viewEmpleadosCompras.jtf_rfc.setEditable(false);
        viewEmpleadosCompras.jtf_nombre.setEditable(false);
        viewEmpleadosCompras.jtf_ap_pat.setEditable(false);
        viewEmpleadosCompras.jtf_apt_mat.setEditable(false);
        viewEmpleadosCompras.jCB_sexo.setEditable(false);
        viewEmpleadosCompras.jtf_estado_civil.setEditable(false);
        viewEmpleadosCompras.jtf_Telefono.setEditable(false);
        viewEmpleadosCompras.jtf_correo.setEditable(false);
        viewEmpleadosCompras.jtf_usuario.setEditable(false);
    }
        public void cajas_habilitadas(){
        viewEmpleadosCompras.jtf_rfc.setEditable(true);
        viewEmpleadosCompras.jtf_nombre.setEditable(true);
        viewEmpleadosCompras.jtf_ap_pat.setEditable(true);
        viewEmpleadosCompras.jtf_apt_mat.setEditable(true);
        viewEmpleadosCompras.jCB_sexo.setEditable(true);
        viewEmpleadosCompras.jtf_estado_civil.setEditable(true);
        viewEmpleadosCompras.jtf_Telefono.setEditable(true);
        viewEmpleadosCompras.jtf_correo.setEditable(true);
        viewEmpleadosCompras.jtf_usuario.setEditable(true);
    }
    
    
     //***************** BOTONES Nuevo, Borrar, Guardar y Modificar**************************
    /**
     * Metodo para limpiar las cajas de texto para ingresar nuevos datos. 
     */
        
        private void nuevo_empleado() {
        viewEmpleadosCompras.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewEmpleadosCompras.jb_modificar.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
        modelEmpleadosCompras.setVerificar(1);// le da el valor a verificar de cero para identificar un nuevo registro
        viewEmpleadosCompras.jtf_rfc.setText(modelEmpleadosCompras.getLimpiar());
        viewEmpleadosCompras.jtf_nombre.setText(modelEmpleadosCompras.getLimpiar());
        viewEmpleadosCompras.jtf_ap_pat.setText(modelEmpleadosCompras.getLimpiar());
        viewEmpleadosCompras.jtf_apt_mat.setText(modelEmpleadosCompras.getLimpiar());
        viewEmpleadosCompras.jtf_estado_civil.setText(modelEmpleadosCompras.getLimpiar());
        viewEmpleadosCompras.jtf_Telefono.setText(modelEmpleadosCompras.getLimpiar());
        viewEmpleadosCompras.jtf_correo.setText(modelEmpleadosCompras.getLimpiar()); 
        viewEmpleadosCompras.jtf_usuario.setText(modelEmpleadosCompras.getLimpiar()); 
        cajas_habilitadas();//llamar al metodo de cajas habilitadas para proceder a escribir un nuevo registro 
        }

        private void modificar_empleado() {
        viewEmpleadosCompras.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewEmpleadosCompras.jb_nuevo.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
         modelEmpleadosCompras.setVerificar(2);// le da el valor a verificar de uno para identificar Modifiar registro
        viewEmpleadosCompras.jtf_rfc.setEditable(false); // el codigo no se puede modificar
        viewEmpleadosCompras.jtf_nombre.setEditable(true);
        viewEmpleadosCompras.jtf_ap_pat.setEditable(true);
        viewEmpleadosCompras.jtf_apt_mat.setEditable(true);
        viewEmpleadosCompras.jCB_sexo.setEditable(true);
        viewEmpleadosCompras.jtf_estado_civil.setEditable(true);
        viewEmpleadosCompras.jtf_Telefono.setEditable(true);
        viewEmpleadosCompras.jtf_correo.setEditable(true);
        viewEmpleadosCompras.jtf_usuario.setEditable(true);
        }

        private void Guardar() {
             // si la variable verificar es igual a 0 se llama al metodo de guardar Nuevo
        if (modelEmpleadosCompras.getVerificar() == 1) {
            // darle el valor a las variables
            modelEmpleadosCompras.setRfc(viewEmpleadosCompras.jtf_rfc.getText());
            modelEmpleadosCompras.setNombre(viewEmpleadosCompras.jtf_nombre.getText());
            modelEmpleadosCompras.setApellido_pat(viewEmpleadosCompras.jtf_ap_pat.getText());
            modelEmpleadosCompras.setApellido_mat(viewEmpleadosCompras.jtf_apt_mat.getText());
            modelEmpleadosCompras.setSexo((String)viewEmpleadosCompras.jCB_sexo.getSelectedItem());
            modelEmpleadosCompras.setEstado_civil(viewEmpleadosCompras.jtf_estado_civil.getText());
            modelEmpleadosCompras.setTelefono(viewEmpleadosCompras.jtf_Telefono.getText());
            modelEmpleadosCompras.setCorreo(viewEmpleadosCompras.jtf_correo.getText());
            modelEmpleadosCompras.setUsuario(viewEmpleadosCompras.jtf_usuario.getText()); 
            
            modelEmpleadosCompras.Guardar_Nuevo(); // metodo de  insertar nuevo registro           
        }
        else{
            // darle el valor a las variables
            modelEmpleadosCompras.setRfc(viewEmpleadosCompras.jtf_rfc.getText());
            modelEmpleadosCompras.setNombre(viewEmpleadosCompras.jtf_nombre.getText());
            modelEmpleadosCompras.setApellido_pat(viewEmpleadosCompras.jtf_ap_pat.getText());
            modelEmpleadosCompras.setApellido_mat(viewEmpleadosCompras.jtf_apt_mat.getText());
            modelEmpleadosCompras.setSexo((String)viewEmpleadosCompras.jCB_sexo.getSelectedItem());
            modelEmpleadosCompras.setEstado_civil(viewEmpleadosCompras.jtf_estado_civil.getText());
            modelEmpleadosCompras.setTelefono(viewEmpleadosCompras.jtf_Telefono.getText());
            modelEmpleadosCompras.setCorreo((String) viewEmpleadosCompras.jtf_correo.getText());
            modelEmpleadosCompras.setUsuario(viewEmpleadosCompras.jtf_usuario.getText());
            modelEmpleadosCompras.Guardar_Modificado();// metodo de  Modificar el registro
        }
        //LIMPIAR TABLA 
        for (int i = 0; i <  viewEmpleadosCompras.jt_vista.getRowCount(); i++) {
           modelEmpleadosCompras.getModelo_EmCompras().removeRow(i);
            i-=1;
        }
        //mostrar los nuevos datos 
        modelEmpleadosCompras.mostrar();
        } 
    
    
}
