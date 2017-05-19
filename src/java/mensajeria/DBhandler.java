/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rperez
 */
public class DBhandler {

    private static Connection connection;

    public DBhandler() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/mensajeria", "root", "");

        } catch (Exception e) {
            e.printStackTrace();
             System.out.println("Error Creando DBhandler");
        }
    }

    public static void storeMessage(Mensaje mensaje) {
        try {
            System.out.println("Store Menssages");
            Statement statement = connection.createStatement();
            String de = mensaje.getDe();
            String para = mensaje.getPara();
            String contenido = mensaje.getContenido();
            String query = "insert into mensajes (de, para, contenido) values ('" + de + "','" + para + "','" + contenido + "')";
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBhandler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en Store Messages");
        }

    }
    public static boolean verifyUser(String user, String password){
        try {
            System.out.println("verify user");
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT user, password, password FROM users where user='"+user+"'");
            if(results.next()){
                //System.out.println("Usuario existente y pass valida");
                String pass=results.getString(2);
                if(pass.equals(password))
                    return true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBhandler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en confirmar User y pass");
        }
        
        
        
        return false;
    }

    public static ArrayList getMessages(String para) {
        ArrayList list = new ArrayList();
        try {            
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT de, contenido, contenido FROM mensajes where para='"+para+"'");
            while (results.next()) {
                String de=results.getString(1);
                String contenido=results.getString(2);
                Mensaje mensaje = new Mensaje(de, para, contenido);
                list.add(mensaje);
            }
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBhandler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en Get Messages");
        }
        return list;
    }
    
   

}
