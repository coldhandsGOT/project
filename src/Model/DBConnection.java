/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.SSHTunnel;
import javax.swing.JOptionPane;


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
   static private Statement st;
    static private  ResultSet rs;
    static private ResultSetMetaData rsetMeta;
 static private String sal=null;
 

    /**
     * Constructeur avec 4 paramètres : username et password ECE, login et
     * password de la BDD à distance sur le serveur de l'ECE
     * @param usernameECE
     * @param passwordECE
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    
     /*  not working, due to the ECE servers being down, tried connecting to the servers using MySQL workbench, there's an issue with the port 22 being saturated
    
    
    public DBConnection(String usernameECE, String passwordECE, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // Connexion via le tunnel SSH avec le username et le password ECE
        SSHTunnel ssh = new SSHTunnel(usernameECE, passwordECE);

        if (ssh.connect()) {
            System.out.println("Connexion reussie");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3305/" + usernameECE;

            //création d'une connexion JDBC à la base
            con = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

          
        }
    }
*/

  
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
    
     
    
    // calcultaes the number of beds

    /**
     *
     * @param query
     * @return
     */
  public static String getNbLits(String query)
    {           
        con =  DBConnection.getDBConnection();

        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            System.out.println("avg lits is ");
            
             
            while (rs.next()) {
                     sal  = rs.getString("AVG(c.nb_lits)");
                    System.out.println(sal);

                    }
            }           
           
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display salaire");
        } 
            return sal;
     }
 
  
  
  
  
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


 public static ArrayList getBatimentList(String query) 
     {        
        ArrayList<Batiment> batimentList = null;
                
        batimentList = new ArrayList<Batiment>();

        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Batiment batiment;
            
            while(rs.next())
            {
          
                batiment = new Batiment(rs.getString("s.batiment"), rs.getString("s.nom"), rs.getInt("h.no_chambre"), rs.getInt("h.lit"), rs.getInt("m.numero") ,rs.getString("m.nom"), rs.getString("m.prenom"), rs.getString("m.mutuelle"));
              System.out.println("bug");
                batimentList.add(batiment);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        }
        
            return batimentList;
   }  


}