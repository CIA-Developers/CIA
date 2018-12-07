/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectar_tablas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LAB 4
 */
public class Database {
    /**
     *esta clase sirve para que sea posible realizar la conexion a la Base de datos de cada tabla que se tenga en el sistema. 
     * @return 
     */
        public static  Connection getConexion() {
        Connection cn=null;
        try{
            /**
             * conexion a la Base de datos
             */
            
            cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/stockcia","root","");
            //cn=DriverManager.getConnection("jdbc:mysql://raspberry-tic41.zapto.org:3306/StockCia", "tic41", "tic41");//conexion local     
        }
        catch(Exception e){
         System.out.println(String.valueOf(e));}
        return cn;
    }
    public static ResultSet getTabla(String Consulta){
        Connection cn=getConexion();
        Statement st;
        ResultSet datos=null;
        try{
            st=cn.createStatement();
            datos=st.executeQuery(Consulta);            
        }
        catch(Exception e){ System.out.print(e.toString());}
        return datos;
    }  
    
}
