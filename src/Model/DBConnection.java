/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.*;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;



/**
 * 
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le tunnel SSH
 * 
 * @author segado
 */
public class DBConnection {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
   static private Connection con;
  static int lport;
    static String rhost;
    static int rport;
   
    
    public static void SSHDBConnection()
    {
        String user = "if175656";       //username of ECE
        String password = "SHOA39zf67.";    //Password of ECE
        String host = "gandalf.ece.fr";     //FQDN of ECE SERVER
        int port=22;                        //SSH PORT
        try
            {
            JSch jsch = new JSch();     //New object of type SSH
            Session session = jsch.getSession(user, host, port);        //NEW SSH SESSION
            lport = 3305;               //leftport
            rhost = "localhost";        //LOCALHOST AKA:127.0.0.1
            rport = 3305;               //forwarding port
          
            session.setConfig("StrictHostKeyChecking", "no");  // bypass secure certifactes (man in the middle)
            
            session.setPassword(password);  //SESSION PASSWORD SET
       
            System.out.println("Establishing Connection...");
         
            session.connect();      //ATTEMPTING LOGIN VIA SSH
          
            int assinged_port = session.setPortForwardingL(lport, rhost, rport);  //setting forwarding port
            
            System.out.println("SSH connection established \nForwarding port = " +assinged_port);
            }
        catch(Exception e)
            { 
                System.out.println("can't establish SSH");
            }
         
          con = null;
         
          String url = "jdbc:mysql://localhost:3305/if175656";     
    
          try{
           Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, "if175656-rw", "vgNvl9bk");
         
          }
          catch (ClassNotFoundException | SQLException e){
          System.out.println("can't connect to DB");
          }
    }
     
 
 
// returns con of type connection to our controllers in order to use the DB hopital on local with root username and root pw, 
   //if connection fails, returns to console log message
     public static Connection getDBConnection()
    {
        Connection con = null;
        try {
            
            
            if (con==null)
            {
            Class.forName("com.mysql.jdbc.Driver");             // finds and loads the JDBC driver
            con = DriverManager.getConnection("jdbc:mysql://localhost/hopital","root", "root");     //loads the DB paramaters
            System.out.println("connection successful");        //logs on console
            }
        }
        catch (Exception e) {
               System.out.println("Can't connect to DB");
        }
         return con;
    }
    
   
    
    


}