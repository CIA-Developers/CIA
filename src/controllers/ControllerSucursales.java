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
import models.ModelSucursales;
import views.ViewSucursales;

/**
 *
 * @author Octaviano
 */
public class ControllerSucursales {
    public ModelSucursales modelSucursales;
    public ViewSucursales viewSucursales;
     
    ActionListener list = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewSucursales.jb_nuevo) {
                jbtn_nuevo_actionPerformed();
            }else if (e.getSource() == viewSucursales.jb_modificar) {
                modificar_sucursales();
            }       
        }
        
    };
    
    MouseListener ml = new MouseListener(){
        @Override
        public void mouseClicked(MouseEvent e) {
          if (e.getSource() == viewSucursales.jt_vista) {
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
   
    KeyListener key = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
           if (e.getSource() == viewSucursales.jtf_buscar) {
                jtf_buscar_KeyPressed();
            }  
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }    
    };
    
    public ControllerSucursales(ModelSucursales modelSucursales, ViewSucursales viewSucursales) {
        this.modelSucursales = modelSucursales;
        this.viewSucursales = viewSucursales;
        this.viewSucursales.jt_vista.addMouseListener(ml);//agregar a la table el evento de MouseListener
        this.viewSucursales.jtf_buscar.addKeyListener(key);
        
        viewSucursales.jb_guardar.setEnabled(false);//El boton guardar aparecera inhabilitado
        viewSucursales.jb_eliminar.setEnabled(false);//El boton guardar aparecera inhabilitado
       
        ConexionBD();
        setActionListener();
        cajas_deshabilitadas();
    }
    
    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    private void setActionListener(){
        viewSucursales.jb_nuevo.addActionListener(list);
        viewSucursales.jb_modificar.addActionListener(list);
        viewSucursales.jb_guardar.addActionListener(list);
    }
    /**
     * este metodo hace la conexion a la base de datos 
     * llama a los metodos conectar, mostrar  dentro del modelo 
     * muestra en la tabla los datos que contiene la variable de modelo_sucursal
     */
    public void ConexionBD(){
        modelSucursales.Conectar();
        modelSucursales.mostrar();
        viewSucursales.jt_vista.setModel(modelSucursales.getModelo_sucursal()); //asignar a la tabla los valores correspondientes
    }
    public void jt_vista_MouseClicked(){
        viewSucursales.jb_guardar.setEnabled(false);
        viewSucursales.jb_modificar.setEnabled(true);//El boton modificar aparecera habilitado
        viewSucursales.jb_nuevo.setEnabled(true);//El boton nuevo aparecera habilitado
        cajas_deshabilitadas(); // cuando se haga clic en la tabla, las cajas se volveran a deshabilitar 
        modelSucursales.setRec(viewSucursales.jt_vista.getSelectedRow());//a la variable se le asigna el elemento seleccionado en la tabla
        viewSucursales.jtf_no_sucursal.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 0).toString());
        viewSucursales.jtf_calle.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 1).toString());
        viewSucursales.jtf_colonia.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 2).toString());
        viewSucursales.jtf_numero.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 3).toString());
        viewSucursales.jtf_telefono.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 4).toString());
        viewSucursales.jtf_codigo_prod.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 5).toString());
        viewSucursales.jtf_nom_prod.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 6).toString());
        viewSucursales.jtf_stock.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 7).toString());
        viewSucursales.jtf_stock_max.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 8).toString());
        viewSucursales.jtf_stock_min.setText(viewSucursales.jt_vista.getValueAt(modelSucursales.getRec(), 9).toString());  
    }
    
    
    public void jtf_buscar_KeyPressed(){
        modelSucursales.Conectar(); //llamar al metodo de conectar
        modelSucursales.busqueda(); //llamar al metodo de busqueda
        // asignar a cada variable el Valor de la caja de texto Buscar para realizar la busqueda 
        modelSucursales.setSucursal(viewSucursales.jtf_buscar.getText());
        modelSucursales.setCalle(viewSucursales.jtf_buscar.getText());
        modelSucursales.setColonia(viewSucursales.jtf_buscar.getText());
        modelSucursales.setNumero(viewSucursales.jtf_buscar.getText());
        modelSucursales.setTelefono(viewSucursales.jtf_buscar.getText());
        modelSucursales.setCodigo_producto(viewSucursales.jtf_buscar.getText());
        modelSucursales.setNombre_producto(viewSucursales.jtf_buscar.getText());
        modelSucursales.setStock(viewSucursales.jtf_buscar.getText());
        modelSucursales.setStock_maximo(viewSucursales.jtf_buscar.getText());
        modelSucursales.setStrock_minimo(viewSucursales.jtf_buscar.getText());
        
        viewSucursales.jt_vista.setModel(modelSucursales.getModel()); //Realizar la busqueda        
    }
    
    public void cajas_deshabilitadas(){
        viewSucursales.jtf_calle.setEditable(false);
        viewSucursales.jtf_colonia.setEditable(false);
        viewSucursales.jtf_numero.setEditable(false);
        viewSucursales.jtf_telefono.setEditable(false);
        viewSucursales.jtf_codigo_prod.setEditable(false);
        viewSucursales.jtf_nom_prod.setEditable(false);
        viewSucursales.jtf_stock.setEditable(false);
        viewSucursales.jtf_stock_max.setEditable(false);
        viewSucursales.jtf_stock_min.setEditable(false);
    }
    public void cajas_habilitadas(){
        viewSucursales.jtf_calle.setEditable(true);
        viewSucursales.jtf_colonia.setEditable(true);
        viewSucursales.jtf_numero.setEditable(true);
        viewSucursales.jtf_telefono.setEditable(true);
        viewSucursales.jtf_codigo_prod.setEditable(true);
        viewSucursales.jtf_nom_prod.setEditable(true);
        viewSucursales.jtf_stock.setEditable(true);
        viewSucursales.jtf_stock_max.setEditable(true);
        viewSucursales.jtf_stock_min.setEditable(true);
    }
    //***************** BOTONES Nuevo, Borrar, Guardar y Modificar**************************
    /**
     * Metodo que limpiara las cajas de texto para ingresar nuevo datos. 
     */
    public void jbtn_nuevo_actionPerformed(){
        viewSucursales.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewSucursales.jb_modificar.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
        viewSucursales.jtf_no_sucursal.setText(Integer.toString(modelSucursales.getCodigo()));// la caja de texto CODIGO_PRODUCTO recibe el valor de cero
        viewSucursales.jtf_calle.setText(modelSucursales.getLimpiar());
        viewSucursales.jtf_colonia.setText(modelSucursales.getLimpiar());
        viewSucursales.jtf_numero.setText(modelSucursales.getLimpiar());
        viewSucursales.jtf_telefono.setText(modelSucursales.getLimpiar());
        viewSucursales.jtf_codigo_prod.setText(modelSucursales.getLimpiar());
        viewSucursales.jtf_nom_prod.setText(modelSucursales.getLimpiar());
        viewSucursales.jtf_stock.setText(modelSucursales.getLimpiar());
        viewSucursales.jtf_stock_max.setText(modelSucursales.getLimpiar());
        viewSucursales.jtf_stock_min.setText(modelSucursales.getLimpiar());    
        cajas_habilitadas();//llamar al metodo de cajas habilitadas para proceder a escribir un nuevo registro 
    }
    
    public void modificar_sucursales(){
        viewSucursales.jb_guardar.setEnabled(true);//El boton guardar aparecera habilitado
        viewSucursales.jb_nuevo.setEnabled(false);//El boton modificar aparecera inhabilitado
        //limpiar cada caja de la Interfaz 
        viewSucursales.jtf_calle.setEditable(true);
        viewSucursales.jtf_colonia.setEditable(true);
        viewSucursales.jtf_numero.setEditable(true);
        viewSucursales.jtf_telefono.setEditable(true);
        viewSucursales.jtf_codigo_prod.setEditable(true);
        viewSucursales.jtf_nom_prod.setEditable(true);
        viewSucursales.jtf_stock.setEditable(true);
        viewSucursales.jtf_stock_max.setEditable(true);
        viewSucursales.jtf_stock_min.setEditable(true);  
    }
}
