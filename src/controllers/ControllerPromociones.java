package controllers;

import models.ModelPromociones;
import views.ViewPromociones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author LAB-1
 */
public class ControllerPromociones {

    ModelPromociones modelPromociones;
    ViewPromociones viewPromociones;
    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewPromociones.jt_vista) {
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
    KeyListener key = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getSource() == viewPromociones.jtf_buscar) {
                modelPromociones.setTrsFiltro(new TableRowSorter(viewPromociones.jt_vista.getModel()));
                viewPromociones.jt_vista.setRowSorter(modelPromociones.getTrsFiltro());
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getSource() == viewPromociones.jtf_buscar) {
                modelPromociones.setCadena(viewPromociones.jtf_buscar.getText());
                viewPromociones.jtf_buscar.setText(modelPromociones.getCadena());
         
            }
        }
    };

    public ControllerPromociones(ModelPromociones modelPromociones, ViewPromociones viewPromociones) {

        this.modelPromociones = modelPromociones;
        this.viewPromociones = viewPromociones;
        this.viewPromociones.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener
        this.viewPromociones.jtf_buscar.addKeyListener(key); //agregar elevento de keylistener en la tabla

        ConexionBD();
        cajas_deshabilitadas();
    }

    public void ConexionBD() {
        modelPromociones.Conectar();
        modelPromociones.mostrar();
        viewPromociones.jt_vista.setModel(modelPromociones.getModelo_sucursal()); //asignar a la tabla los valores correspondientes
    }

    public void jt_vista_MouseClicked() {
        cajas_deshabilitadas(); // cuando se haga clic en la tabla, las cajas se volveran a deshabilitar 
        modelPromociones.setRec(viewPromociones.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewPromociones.jtf_no_promocion.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 0).toString());
        viewPromociones.jtf_calle1.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 1).toString());
        viewPromociones.jtf_colonia1.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 2).toString());
        viewPromociones.jtf_numero1.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 3).toString());
        viewPromociones.jtf_telefono1.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 4).toString());
    
    }

    public void cajas_deshabilitadas() {
        viewPromociones.jtf_no_promocion.setEditable(false);
        viewPromociones.jtf_calle1.setEditable(false);
        viewPromociones.jtf_colonia1.setEditable(false);
        viewPromociones.jtf_telefono1.setEditable(false);
    }

    public void cajas_habilitadas() {
        viewPromociones.jtf_no_promocion.setEditable(false);
        viewPromociones.jtf_calle1.setEditable(false);
        viewPromociones.jtf_colonia1.setEditable(false);
        viewPromociones.jtf_telefono1.setEditable(false);
    }

    //***************** BOTONES Nuevo, Borrar, Guardar y Modificar**************************
    /**
     * Metodo que limpiara las cajas de texto para ingresar nuevo datos.
     */
    public void nuevo_sucursales() {

        //limpiar cada caja de la Interfaz 
        viewPromociones.jtf_no_promocion.setText(Integer.toString(modelPromociones.getCodigo()));// la caja de texto CODIGO_PRODUCTO recibe el valor de cero
        viewPromociones.jtf_calle1.setText(modelPromociones.getLimpiar());
        viewPromociones.jtf_colonia1.setText(modelPromociones.getLimpiar());
        viewPromociones.jtf_numero1.setText(modelPromociones.getLimpiar());
        viewPromociones.jtf_telefono1.setText(modelPromociones.getLimpiar());

        cajas_habilitadas();//llamar al metodo de cajas habilitadas para proceder a escribir un nuevo registro 
    }

    public void modificar_sucursales() {

        viewPromociones.jtf_calle1.setEditable(true);
        viewPromociones.jtf_colonia1.setEditable(true);
        viewPromociones.jtf_telefono1.setEditable(true);
    }

    public void Guardar() {
        // si la variable verificar es igual a 0 se llama al metodo de guardar Nuevo
        if (modelPromociones.getVerificar() == 1) {
            // darle el valor a las variables
            modelPromociones.setNo_promocion(viewPromociones.jtf_no_promocion.getText());
            modelPromociones.setCausa(viewPromociones.jtf_calle1.getText());
            modelPromociones.setDescuento(viewPromociones.jtf_colonia1.getText());
            modelPromociones.setPrecion_descuento(viewPromociones.jtf_numero1.getText());
            modelPromociones.setUnidad_medida(viewPromociones.jtf_telefono1.getText());
            modelPromociones.Guardar_Nuevo(); // metodo de  insertar nuevo registro           
        } else {
            // darle el valor a las variables
            modelPromociones.setNo_promocion(viewPromociones.jtf_no_promocion.getText());
            modelPromociones.setCausa(viewPromociones.jtf_calle1.getText());
            modelPromociones.setDescuento(viewPromociones.jtf_colonia1.getText());
            modelPromociones.setPrecion_descuento(viewPromociones.jtf_numero1.getText());
            modelPromociones.setUnidad_medida(viewPromociones.jtf_telefono1.getText());

            modelPromociones.Guardar_Modificado();// metodo de  Modificar el registro
        }
        //LIMPIAR TABLA 
        for (int i = 0; i < viewPromociones.jt_vista.getRowCount(); i++) {
            modelPromociones.getModelo_sucursal().removeRow(i);
            i -= 1;
        }
        //mostrar los nuevos datos 
        modelPromociones.mostrar();
    }
}


    
