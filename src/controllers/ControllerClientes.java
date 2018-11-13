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
import models.ModelClientes;
import views.ViewClientes;

/**
 *
 * @author Octaviano
 */
public class ControllerClientes {

    public ModelClientes modelClientes;
    public ViewClientes viewClientes;
    ActionListener list = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewClientes.jb_nuevo) {
                nuevo_clientes();
            } else if (e.getSource() == viewClientes.jb_modificar) {
                modificar_clientes();
            } else if (e.getSource() == viewClientes.jb_guardar) {
                Guardar();
            }
        }

    };
    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewClientes.jt_vista) {
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
     * Busar solo con un compo, no es necesario el metodo de filtro toda la
     * accion de buscar esta dentro del evento keyListener
     */
    KeyListener key = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getSource() == viewClientes.jtf_buscar) {
                modelClientes.setTrsFiltro(new TableRowSorter(viewClientes.jt_vista.getModel()));
                viewClientes.jt_vista.setRowSorter(modelClientes.getTrsFiltro());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            modelClientes.setCadena(viewClientes.jtf_buscar.getText());
            viewClientes.jtf_buscar.setText(modelClientes.getCadena());
            modelClientes.getTrsFiltro().setRowFilter(RowFilter.regexFilter(viewClientes.jtf_buscar.getText(), modelClientes.getColumnaABuscar()));
        }
    };

    public ControllerClientes(ModelClientes modelClientes, ViewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;
        this.viewClientes.jtf_buscar.addKeyListener(key); //agregar elevento de keylistener en la caja e texto buscar
        this.viewClientes.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener

        viewClientes.jb_guardar.setEnabled(false);
//El boton guardar aparecera inhabilitado
        viewClientes.jb_eliminar.setEnabled(false);
//El boton guardar aparecera inhabilitado

        ConexionBD();
        cajas_deshabilitadas();
        setActionListener();
    }

    /**
     * Método para agregar el actionListener a cada boton
     */
    private void setActionListener() {

        viewClientes.jb_nuevo.addActionListener(list);
        viewClientes.jb_modificar.addActionListener(list);
        viewClientes.jb_guardar.addActionListener(list);

    }

    public void ConexionBD() {
        modelClientes.Conectar();
        modelClientes.mostrar();
        viewClientes.jt_vista.setModel(modelClientes.getModelo_clientes()); //asignar a la tabla los valores correspondientes
    }

    public void jt_vista_MouseClicked() {
        viewClientes.jb_guardar.setEnabled(false);
        viewClientes.jb_modificar.setEnabled(true);//El boton modificar aparecera habilitado
        viewClientes.jb_nuevo.setEnabled(true);//El boton nuevo aparecera habilitado
        cajas_deshabilitadas(); // cuando se haga clic en la tabla, las cajas se volveran a deshabilitar 
        modelClientes.setRec(viewClientes.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewClientes.jtf_rfc.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 0).toString());
        viewClientes.jtf_nombre.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 1).toString());
        viewClientes.jtf_ap_pat.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 2).toString());
        viewClientes.jtf_apt_mat.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 3).toString());
        viewClientes.jtf_telefono.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 4).toString());
        viewClientes.jtf_municipio.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 5).toString());
        viewClientes.jtf_calle.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 6).toString());
        viewClientes.jtf_colonia.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 7).toString());
        viewClientes.jtf_numero.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 8).toString());
        viewClientes.jtf_correo.setText(viewClientes.jt_vista.getValueAt(modelClientes.getRec(), 9).toString());

    }

    private void cajas_deshabilitadas() {
        viewClientes.jtf_rfc.setEditable(false);
        viewClientes.jtf_nombre.setEditable(false);
        viewClientes.jtf_ap_pat.setEditable(false);
        viewClientes.jtf_apt_mat.setEditable(false);
        viewClientes.jtf_telefono.setEditable(false);
        viewClientes.jtf_municipio.setEditable(false);
        viewClientes.jtf_colonia.setEditable(false);
        viewClientes.jtf_calle.setEditable(false);
        viewClientes.jtf_numero.setEditable(false);
        viewClientes.jtf_correo.setEditable(false);

    }

    private void cajas_habilitadas() {
        viewClientes.jtf_rfc.setEditable(true);
        viewClientes.jtf_nombre.setEditable(true);
        viewClientes.jtf_ap_pat.setEditable(true);
        viewClientes.jtf_apt_mat.setEditable(true);
        viewClientes.jtf_telefono.setEditable(true);
        viewClientes.jtf_municipio.setEditable(true);
        viewClientes.jtf_colonia.setEditable(true);
        viewClientes.jtf_calle.setEditable(true);
        viewClientes.jtf_numero.setEditable(true);
        viewClientes.jtf_correo.setEditable(true);
    }

    //***************** BOTONES Nuevo, Borrar, Guardar y Modificar**************************
    /**
     * Metodo que limpiara las cajas de texto para ingresar nuevo datos.
     */
    public void nuevo_clientes() {
        viewClientes.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewClientes.jb_modificar.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
        modelClientes.setVerificar(1);// le da el valor a verificar de cero para identificar un nuevo registro
        viewClientes.jtf_rfc.setText(modelClientes.getLimpiar());
        viewClientes.jtf_nombre.setText(modelClientes.getLimpiar());
        viewClientes.jtf_ap_pat.setText(modelClientes.getLimpiar());
        viewClientes.jtf_apt_mat.setText(modelClientes.getLimpiar());
        viewClientes.jtf_telefono.setText(modelClientes.getLimpiar());
        viewClientes.jtf_municipio.setText(modelClientes.getLimpiar());
        viewClientes.jtf_calle.setText(modelClientes.getLimpiar());
        viewClientes.jtf_colonia.setText(modelClientes.getLimpiar());
        viewClientes.jtf_numero.setText(modelClientes.getLimpiar());
        viewClientes.jtf_correo.setText(modelClientes.getLimpiar());
        cajas_habilitadas();//llamar al metodo de cajas habilitadas para proceder a escribir un nuevo registro 
    }

    public void modificar_clientes() {
        viewClientes.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewClientes.jb_modificar.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
        modelClientes.setVerificar(2);// le da el valor a verificar de uno para identificar Modifiar registro
        viewClientes.jtf_rfc.setEditable(false); // el codigo no se puede modificar
        viewClientes.jtf_nombre.setEditable(true);
        viewClientes.jtf_ap_pat.setEditable(true);
        viewClientes.jtf_apt_mat.setEditable(true);
        viewClientes.jtf_telefono.setEditable(true);
        viewClientes.jtf_municipio.setEditable(true);
        viewClientes.jtf_calle.setEditable(true);
        viewClientes.jtf_colonia.setEditable(true);
        viewClientes.jtf_numero.setEditable(true);
        viewClientes.jtf_correo.setEditable(true);
    }

    public void Guardar() {
        // si la variable verificar es igual a 0 se llama al metodo de guardar Nuevo
        if (modelClientes.getVerificar() == 1) {
            // darle el valor a las variables
            modelClientes.setRfc(viewClientes.jtf_rfc.getText());
            modelClientes.setNombre(viewClientes.jtf_nombre.getText());
            modelClientes.setAp_pat(viewClientes.jtf_ap_pat.getText());
            modelClientes.setAp_mat(viewClientes.jtf_apt_mat.getText());
            modelClientes.setTelefono(viewClientes.jtf_telefono.getText());
            modelClientes.setMunicipio(viewClientes.jtf_municipio.getText());
            modelClientes.setColonia(viewClientes.jtf_calle.getText());
            modelClientes.setColonia(viewClientes.jtf_colonia.getText());
            modelClientes.setNumero(viewClientes.jtf_numero.getText());
            modelClientes.setCorreo(viewClientes.jtf_correo.getText());

            modelClientes.Guardar_Nuevo(); // metodo de  insertar nuevo registro           
        } else {
            // darle el valor a las variables
            modelClientes.setRfc(viewClientes.jtf_rfc.getText());
            modelClientes.setNombre(viewClientes.jtf_nombre.getText());
            modelClientes.setAp_pat(viewClientes.jtf_ap_pat.getText());
            modelClientes.setAp_mat(viewClientes.jtf_apt_mat.getText());
            modelClientes.setTelefono(viewClientes.jtf_telefono.getText());
            modelClientes.setMunicipio(viewClientes.jtf_municipio.getText());
            modelClientes.setColonia(viewClientes.jtf_calle.getText());
            modelClientes.setColonia(viewClientes.jtf_colonia.getText());
            modelClientes.setNumero(viewClientes.jtf_numero.getText());
            modelClientes.setCorreo(viewClientes.jtf_correo.getText());
            modelClientes.Guardar_Modificado();// metodo de  Modificar el registro
        }
        //LIMPIAR TABLA 
        for (int i = 0; i < viewClientes.jt_vista.getRowCount(); i++) {
            modelClientes.getModelo_Proveedores().removeRow(i);
            i -= 1;
        }
        //mostrar los nuevos datos 
        modelClientes.mostrar();
    }
}
