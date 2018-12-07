/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.ControllerLogin;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import views.ViewLogin;

/**
 *
 * @author Octaviano
 */
public class ModelMenuAdmin {
    public void VentanaLogin(){
        ModelLogin modelLogin = new ModelLogin();
        ViewLogin viewLogin = new ViewLogin();
        ControllerLogin controllerLogin = new ControllerLogin(modelLogin,viewLogin/*,viewMenuAdmin*/ /*,controllersLogin*/);
    }
    private Connection conexion;     
    private Statement st;     
    private ResultSet rs;
    PreparedStatement ps;
    Runtime rt = Runtime.getRuntime();
    /**
     * Conexion a la Base de Datos
     */
    public void Conectar(){
             try{ 
                conexion=DriverManager.getConnection("jdbc:mysql://raspberry-tic41.zapto.org:3306/StockCia", "tic41", "tic41");                     
                st=conexion.createStatement(); 
                
            }catch(SQLException err){ 
                JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
            } 
    }
    public void respaldosDBLocal(){
        try{
            Process p = Runtime.getRuntime().exec("C:/xampp/mysql/bin/mysqldump --host=raspberry-tic41.zapto.org "
                    + "-utic41 -ptic41 -B StockCia");
            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream("C:\\archivos\\StockCia.sql");
            byte[] buffer = new byte[1000];

            int leido = is.read(buffer);
            while (leido > 0) { //escribir las lineas que crean el respaldo de la base de datos
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);
            }
            JOptionPane.showMessageDialog(null, "La base de datos ha sido respaldada");
            fos.close();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,"error al realizar el respaldo");
        }
    }
}
