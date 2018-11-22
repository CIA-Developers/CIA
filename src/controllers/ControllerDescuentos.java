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

    public ControllerDescuentos(ModelDescuentos modelDescuentos, ViewDescuentos viewDescuentos) {

        this.modelDescuentos = modelDescuentos;
        this.viewDescuentos = viewDescuentos;

    }

}
