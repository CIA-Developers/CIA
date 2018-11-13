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
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import models.ModelProveedores;
import views.ViewProveedores;

/**
 *
 * @author Octaviano
 */
public class ControllerProveedores {

    public ModelProveedores modelProveedores;
    public ViewProveedores viewProveedores;
    ActionListener list = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProveedores.jb_nuevo) {
                nuevo_proveedores();
            } else if (e.getSource() == viewProveedores.jb_modificar) {
                modificar_proveedores();
            } else if (e.getSource() == viewProveedores.jb_guardar) {
                Guardar();
            }
        }

    };

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewProveedores.jt_vista) {
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

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

      /**
   * Busar solo con un compo, no es necesario el metodo de filtro 
   * toda la accion de buscar esta dentro del evento keyListener 
   */
    
  KeyListener key = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getSource() == viewProveedores.jtf_buscar) {
                modelProveedores.setTrsFiltro(new TableRowSorter(viewProveedores.jt_vista.getModel()));
                viewProveedores.jt_vista.setRowSorter(modelProveedores.getTrsFiltro());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
        modelProveedores.setCadena(viewProveedores.jtf_buscar.getText());
        viewProveedores.jtf_buscar.setText(modelProveedores.getCadena());    
        modelProveedores.getTrsFiltro().setRowFilter(RowFilter.regexFilter(viewProveedores.jtf_buscar.getText(), modelProveedores.getColumnaABuscar()));   
        }    
    };
  
  
    
    
    
    
    
    
    
    public ControllerProveedores(ModelProveedores modelProveedores, ViewProveedores viewProveedores) {
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
        this.viewProveedores.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener

        viewProveedores.jb_guardar.setEnabled(false);
//El boton guardar aparecera inhabilitado
        viewProveedores.jb_eliminar.setEnabled(false);
//El boton guardar aparecera inhabilitado

        cajas_deshabilitadas();
        setActionListener();
        ConexionBD();
    }

    /**
     * Método para agregar el actionListener a cada boton
     */
    private void setActionListener() {

        viewProveedores.jb_nuevo.addActionListener(list);
        viewProveedores.jb_modificar.addActionListener(list);
        viewProveedores.jb_guardar.addActionListener(list);

    }

    public void ConexionBD() {
        modelProveedores.Conectar();
        modelProveedores.mostrar();
        viewProveedores.jt_vista.setModel(modelProveedores.getModelo_Proveedores()); //asignar a la tabla los valores correspondientes
    }

    public void jt_vista_MouseClicked() {
        viewProveedores.jb_guardar.setEnabled(false);
        viewProveedores.jb_modificar.setEnabled(true);//El boton modificar aparecera habilitado
        viewProveedores.jb_nuevo.setEnabled(true);//El boton nuevo aparecera habilitado
        cajas_deshabilitadas(); // cuando se haga clic en la tabla, las cajas se volveran a deshabilitar 
        modelProveedores.setRec(viewProveedores.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewProveedores.jtf_id.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 0).toString());
        viewProveedores.jtf_nombre.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 1).toString());
        viewProveedores.jtf_ap_pat.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 2).toString());
        viewProveedores.jtf_apt_mat.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 3).toString());
        viewProveedores.jtf_telefono.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 4).toString());
        viewProveedores.jtf_municipio.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 5).toString());
        viewProveedores.jtf_colonia.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 6).toString());
        viewProveedores.jtf_numero.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 7).toString());
        viewProveedores.jtf_provincia.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 8).toString());
        viewProveedores.jtf_correo.setText(viewProveedores.jt_vista.getValueAt(modelProveedores.getRec(), 9).toString());
    }

    private void cajas_deshabilitadas() {
        viewProveedores.jtf_id.setEditable(false);
        viewProveedores.jtf_nombre.setEditable(false);
        viewProveedores.jtf_ap_pat.setEditable(false);
        viewProveedores.jtf_apt_mat.setEditable(false);
        viewProveedores.jtf_telefono.setEditable(false);
        viewProveedores.jtf_municipio.setEditable(false);
        viewProveedores.jtf_colonia.setEditable(false);
        viewProveedores.jtf_numero.setEditable(false);
        viewProveedores.jtf_provincia.setEditable(false);
        viewProveedores.jtf_correo.setEditable(false);

    }

    private void cajas_habilitadas() {
        viewProveedores.jtf_id.setEditable(true);
        viewProveedores.jtf_nombre.setEditable(true);
        viewProveedores.jtf_ap_pat.setEditable(true);
        viewProveedores.jtf_apt_mat.setEditable(true);
        viewProveedores.jtf_telefono.setEditable(true);
        viewProveedores.jtf_municipio.setEditable(true);
        viewProveedores.jtf_colonia.setEditable(true);
        viewProveedores.jtf_numero.setEditable(true);
        viewProveedores.jtf_provincia.setEditable(true);
        viewProveedores.jtf_correo.setEditable(true);

    }
    //***************** BOTONES Nuevo, Borrar, Guardar y Modificar**************************

    /**
     * Metodo que limpiara las cajas de texto para ingresar nuevo datos.
     */
    public void nuevo_proveedores() {
        viewProveedores.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewProveedores.jb_modificar.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
        modelProveedores.setVerificar(1);// le da el valor a verificar de cero para identificar un nuevo registroç
        viewProveedores.jtf_id.setText(modelProveedores.getLimpiar());
        viewProveedores.jtf_nombre.setText(modelProveedores.getLimpiar());
        viewProveedores.jtf_ap_pat.setText(modelProveedores.getLimpiar());
        viewProveedores.jtf_apt_mat.setText(modelProveedores.getLimpiar());
        viewProveedores.jtf_telefono.setText(modelProveedores.getLimpiar());
        viewProveedores.jtf_municipio.setText(modelProveedores.getLimpiar());
        viewProveedores.jtf_colonia.setText(modelProveedores.getLimpiar());
        viewProveedores.jtf_numero.setText(modelProveedores.getLimpiar());
        viewProveedores.jtf_provincia.setText(modelProveedores.getLimpiar());
        viewProveedores.jtf_correo.setText(modelProveedores.getLimpiar());
        cajas_habilitadas();//llamar al metodo de cajas habilitadas para proceder a escribir un nuevo registro 
    }

    public void modificar_proveedores() {
        viewProveedores.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewProveedores.jb_modificar.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
        modelProveedores.setVerificar(2);// le da el valor a verificar de uno para identificar Modifiar registro
        viewProveedores.jtf_id.setEditable(false); // el codigo no se puede modificar
        viewProveedores.jtf_nombre.setEditable(true);
        viewProveedores.jtf_ap_pat.setEditable(true);
        viewProveedores.jtf_apt_mat.setEditable(true);
        viewProveedores.jtf_telefono.setEditable(true);
        viewProveedores.jtf_municipio.setEditable(true);
        viewProveedores.jtf_colonia.setEditable(true);
        viewProveedores.jtf_numero.setEditable(true);
        viewProveedores.jtf_provincia.setEditable(true);
        viewProveedores.jtf_correo.setEditable(true);
    }

    public void Guardar() {
        // si la variable verificar es igual a 0 se llama al metodo de guardar Nuevo
        if (modelProveedores.getVerificar() == 1) {
            // darle el valor a las variables
            modelProveedores.setId(viewProveedores.jtf_id.getText());
            modelProveedores.setNombre(viewProveedores.jtf_nombre.getText());
            modelProveedores.setAp_pat(viewProveedores.jtf_ap_pat.getText());
            modelProveedores.setAp_mat(viewProveedores.jtf_apt_mat.getText());
            modelProveedores.setTelefono(viewProveedores.jtf_telefono.getText());
            modelProveedores.setCalle(viewProveedores.jtf_municipio.getText());
            modelProveedores.setColonia(viewProveedores.jtf_colonia.getText());
            modelProveedores.setNumero(viewProveedores.jtf_numero.getText());
            modelProveedores.setProvincia(viewProveedores.jtf_provincia.getText());
            modelProveedores.setCorreo(viewProveedores.jtf_correo.getText());
            modelProveedores.Guardar_Nuevo(); // metodo de  insertar nuevo registro           
        } else {
            // darle el valor a las variables
            modelProveedores.setId(viewProveedores.jtf_id.getText());
            modelProveedores.setNombre(viewProveedores.jtf_nombre.getText());
            modelProveedores.setAp_pat(viewProveedores.jtf_ap_pat.getText());
            modelProveedores.setAp_mat(viewProveedores.jtf_apt_mat.getText());
            modelProveedores.setTelefono(viewProveedores.jtf_telefono.getText());
            modelProveedores.setCalle(viewProveedores.jtf_municipio.getText());
            modelProveedores.setColonia(viewProveedores.jtf_colonia.getText());
            modelProveedores.setNumero(viewProveedores.jtf_numero.getText());
            modelProveedores.setProvincia(viewProveedores.jtf_provincia.getText());
            modelProveedores.setCorreo(viewProveedores.jtf_correo.getText());
            modelProveedores.Guardar_Modificado();// metodo de  Modificar el registro
        }
        //LIMPIAR TABLA 
        for (int i = 0; i < viewProveedores.jt_vista.getRowCount(); i++) {
            modelProveedores.getModelo_Proveedores().removeRow(i);
            i -= 1;
        }
        //mostrar los nuevos datos 
        modelProveedores.mostrar();
    }
}
