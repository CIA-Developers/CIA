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
import models.ModelDescuentos;
import views.ViewDescuentos;

/**
 *
 * @author Octaviano
 */
public class ControllerDescuentos {

    ModelDescuentos modelDescuentos;
    ViewDescuentos viewDescuentos;
     ActionListener list = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewDescuentos.jb_nuevo) {
                nuevo_Descuentos();
            } else if (e.getSource() == viewDescuentos.jb_modificar) {
                modificar_Descuentos();
            } else if (e.getSource() == viewDescuentos.jb_guardar) {
                Guardar();
            }
        }

    };
       MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewDescuentos.jt_vista) {
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
            if (e.getSource() == viewDescuentos.jtf_buscar) {
                modelDescuentos.setTrsFiltro(new TableRowSorter(viewDescuentos.jt_vista.getModel()));
                viewDescuentos.jt_vista.setRowSorter(modelDescuentos.getTrsFiltro());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            modelDescuentos.setCadena(viewDescuentos.jtf_buscar.getText());
            viewDescuentos.jtf_buscar.setText(modelDescuentos.getCadena());
            modelDescuentos.getTrsFiltro().setRowFilter(RowFilter.regexFilter(viewDescuentos.jtf_buscar.getText(), modelDescuentos.getColumnaABuscar()));
        }
    };
    

    public ControllerDescuentos(ModelDescuentos modelDescuentos, ViewDescuentos viewDescuentos) {

        this.modelDescuentos = modelDescuentos;
        this.viewDescuentos = viewDescuentos;
            this.viewDescuentos.jtf_buscar.addKeyListener(key); //agregar elevento de keylistener en la caja e texto buscar
        this.viewDescuentos.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener

        viewDescuentos.jb_guardar.setEnabled(false);
//El boton guardar aparecera inhabilitado
        viewDescuentos.jb_eliminar.setEnabled(false);
//El boton guardar aparecera inhabilitado

        cajas_deshabilitadas();
        setActionListener();
        ConexionBD();
    }
     /**
     * Método para agregar el actionListener a cada boton
     */
    private void setActionListener() {

        viewDescuentos.jb_nuevo.addActionListener(list);
        viewDescuentos.jb_modificar.addActionListener(list);
        viewDescuentos.jb_guardar.addActionListener(list);

    }

    public void ConexionBD() {
        modelDescuentos.Conectar();
        modelDescuentos.mostrar();
        viewDescuentos.jt_vista.setModel(modelDescuentos.getModelo_Descuentos()); //asignar a la tabla los valores correspondientes
    }

    public void jt_vista_MouseClicked() {
        viewDescuentos.jb_guardar.setEnabled(false);
        viewDescuentos.jb_modificar.setEnabled(true);//El boton modificar aparecera habilitado
        viewDescuentos.jb_nuevo.setEnabled(true);//El boton nuevo aparecera habilitado
        cajas_deshabilitadas(); // cuando se haga clic en la tabla, las cajas se volveran a deshabilitar 
        modelDescuentos.setRec(viewDescuentos.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewDescuentos.jtf_codigo_descuento.setText(viewDescuentos.jt_vista.getValueAt(modelDescuentos.getRec(), 0).toString());
        viewDescuentos.jtf_porcentaje.setText(viewDescuentos.jt_vista.getValueAt(modelDescuentos.getRec(), 1).toString());
        viewDescuentos.jtf_cantidad_puntos.setText(viewDescuentos.jt_vista.getValueAt(modelDescuentos.getRec(), 2).toString());
  
    }

    private void cajas_deshabilitadas() {
        viewDescuentos.jtf_codigo_descuento.setEditable(false);
        viewDescuentos.jtf_porcentaje.setEditable(false);
        viewDescuentos.jtf_cantidad_puntos.setEditable(false);
    }

    private void cajas_habilitadas() {
        viewDescuentos.jtf_codigo_descuento.setEditable(true);
        viewDescuentos.jtf_porcentaje.setEditable(true);
        viewDescuentos.jtf_cantidad_puntos.setEditable(true);

    }
    //***************** BOTONES Nuevo, Borrar, Guardar y Modificar**************************

    /**
     * Metodo que limpiara las cajas de texto para ingresar nuevo datos.
     */
    public void nuevo_proveedores() {
        viewDescuentos.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewDescuentos.jb_modificar.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
        modelDescuentos.setVerificar(1);// le da el valor a verificar de cero para identificar un nuevo registroç
        viewDescuentos.jtf_codigo_descuento.setText(modelDescuentos.getLimpiar());
        viewDescuentos.jtf_porcentaje.setText(modelDescuentos.getLimpiar());
        viewDescuentos.jtf_cantidad_puntos.setText(modelDescuentos.getLimpiar());
        cajas_habilitadas();//llamar al metodo de cajas habilitadas para proceder a escribir un nuevo registro 
    }

    public void modificar_proveedores() {
        viewDescuentos.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewDescuentos.jb_modificar.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
        modelDescuentos.setVerificar(2);// le da el valor a verificar de uno para identificar Modifiar registro
        viewDescuentos.jtf_codigo_descuento.setEditable(false); // el codigo no se puede modificar
        viewDescuentos.jtf_porcentaje.setEditable(true);
        viewDescuentos.jtf_cantidad_puntos.setEditable(true);
       
    }

    public void Guardar() {
        // si la variable verificar es igual a 0 se llama al metodo de guardar Nuevo
        if (modelDescuentos.getVerificar() == 1) {
            // darle el valor a las variables
            modelDescuentos.setId(viewDescuentos.jtf_codigo_descuento.getText());
            modelDescuentos.setNombre(viewDescuentos.jtf_porcentaje.getText());
            modelDescuentos.setAp_pat(viewDescuentos.jtf_cantidad_puntos.getText());
            modelDescuentos.Guardar_Nuevo(); // metodo de  insertar nuevo registro           
        } else {
            // darle el valor a las variables
            modelDescuentos.setId(viewDescuentos.jtf_codigo_descuento.getText());
            modelDescuentos.setNombre(viewDescuentos.jtf_porcentaje.getText());
            modelDescuentos.setAp_pat(viewDescuentos.jtf_cantidad_puntos.getText());
            modelDescuentos.Guardar_Modificado();// metodo de  Modificar el registro
        }
        //LIMPIAR TABLA 
        for (int i = 0; i < viewDescuentos.jt_vista.getRowCount(); i++) {
            modelDescuentos.getModelo_Descuentos().removeRow(i);
            i -= 1;
        }
        //mostrar los nuevos datos 
        modelDescuentos.mostrar();
    }
}


    }

}
