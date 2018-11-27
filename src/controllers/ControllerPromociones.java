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

    }

    public void ConexionBD() {
        modelPromociones.Conectar();
        modelPromociones.mostrar();
        viewPromociones.jt_vista.setModel(modelPromociones.getModelo_promocion()); //asignar a la tabla los valores correspondientes
    }

    public void jt_vista_MouseClicked() {
        modelPromociones.setRec(viewPromociones.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewPromociones.jtf_no_promocion.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 0).toString());
        viewPromociones.jtf_calle1.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 1).toString());
        viewPromociones.jtf_colonia1.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 2).toString());
        viewPromociones.jtf_numero1.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 3).toString());
        viewPromociones.jtf_telefono1.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 4).toString());
        viewPromociones.jtf_no_sucursal.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 5).toString());
        viewPromociones.jtf_calle.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 6).toString());
        viewPromociones.jtf_colonia.setText(viewPromociones.jt_vista.getValueAt(modelPromociones.getRec(), 7).toString());

    }
}
