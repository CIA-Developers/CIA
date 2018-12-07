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

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    java.util.Properties config = new java.util.Properties(); 
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
            JOptionPane.showMessageDialog(null, "La base de datos ha sido respaldada en \n"+"C:\\archivos\\StockCia.sql");
            fos.close();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,"error al realizar el respaldo");
        }
    }
    /****
     *             ********************** CONECION SSH ****************************
     */
    /**
     * Constante que representa un enter.
     */
    private static final String ENTER_KEY = "n";
    /**
     * Sesión SSH establecida.
     */
    public Session session;

    public void connect(String username,String password,String host,int port)
        throws JSchException, IllegalAccessException {
        if (this.session == null || !this.session.isConnected()) {
            JSch jsch = new JSch();
 
            this.session = jsch.getSession(username, host, port);
            this.session.setPassword(password);
 
            // Parametro para no validar key de conexion.
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            this.session.connect();
        } else {
            throw new IllegalAccessException("Sesion SSH ya iniciada.");
        }
    }

    public final String executeCommand(String command)
        throws IllegalAccessException, JSchException, IOException {
        if (this.session != null && this.session.isConnected()) {
 
            // Abrimos un canal SSH. Es como abrir una consola.
            ChannelExec channelExec = (ChannelExec) this.session.
                openChannel("exec");
 
            InputStream in = channelExec.getInputStream();
 
            // Ejecutamos el comando.
            channelExec.setCommand(command);
            channelExec.connect();
 
            // Obtenemos el texto impreso en la consola.
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder builder = new StringBuilder();
            String linea;
 
            while ((linea = reader.readLine()) != null) {
                builder.append(linea);
                builder.append(ENTER_KEY);
            }
 
            // Cerramos el canal SSH.
            channelExec.disconnect();
 
            // Retornamos el texto impreso en la consola.
            return builder.toString();
        } else {
            throw new IllegalAccessException("No existe sesion SSH iniciada.");
        }
    }
 
    /**
     * Cierra la sesión SSH.
     */
    public final void disconnect() {
        this.session.disconnect();
    }
}
