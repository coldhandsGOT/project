/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author idris
 */
public class Malade {
    
    //déclaration des variables
    private int id;
    private String name;
    private String lastname;
    private String mutuelle;
    private String tel;
    private String adresse;
    private int count;
    private int count2;
    
    static private  Connection con;
    
    //premier constructeur initialisant les variables name, lastname
    public Malade(String name, String lastname) 
    {
      this.name = name;
      this.lastname = lastname;
    }

  
 
    //second constructeur en surcharge initialisant les variables name, lastname, count, count2     
      public Malade(String name, String lastname, int count, int count2) {
      
        this.name = name;
        this.lastname = lastname;
        this.count = count;
        this.count2 = count2;
       
    }
         
    //troisième constructeur en surcharge initialisant les variables name, lastname, mutuelle, tel, adresse   
    public Malade(int id, String name, String lastname, String mutuelle, String tel, String adresse) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.mutuelle = mutuelle;
        this.tel = tel;
        this.adresse = adresse;
    }
    
    //accesseur de la variable id
    public int getId() {
        return id;
    }
    
    //accesseur de la variable name
    public String getName() {
        return name;
    }  
    
    //accesseur de la variable lastname
    public String getLastname() {
        return lastname;
    }
    
    //accesseur de la variable mutuelle
    public String getMutuelle() {
        return mutuelle;
    }
    
    //accesseur de la variable tel
    public String getTel() {
        return tel;
    }
    
    //accesseur de la variable adresse
    public String getAdresse() {
        return adresse;
    }
    
    //accesseur de la variable count
      public int getCount() {
        return count;
    }
      
     //accesseur de la variable count2
    public int getCount2() {
        return count2;
    }
    
    
    //méthode retournant la liste des malades
    public static ArrayList <Malade> getMaladeList(String query)
    {       
        con =  DBConnection.getDBConnection();
        ArrayList<Malade> maladeList = null;
                
        maladeList = new ArrayList<Malade>();
        
        if(con==null)
           con =  DBConnection.getDBConnection();
  
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Malade malade;
            
            while(rs.next())
            {
                malade = new Malade(rs.getInt("m.numero"), rs.getString("m.nom"),rs.getString("m.prenom"),rs.getString("m.mutuelle"),rs.getString("m.tel"),rs.getString("m.adresse"));
                maladeList.add(malade);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        } 
            return maladeList;
     }
    
    
    //méthode retournant une liste des malades suivant la requête sql 7
     public static ArrayList <Malade> getMaladeListReq7()
    {        
        
        
        String query = "select m.nom, m.prenom, count(*) ,count(distinct d.specialite) from  docteur d, soigne so, malade m where d.numero = so.no_docteur and so.no_malade = m.numero group by  m.nom, m.prenom having    count(*) > 3";
           
        ArrayList<Malade> maladeList = null;
                
        maladeList = new ArrayList<Malade>();
        
         if(con==null)
           con =  DBConnection.getDBConnection();
         
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Malade malade;
            
            while(rs.next())
            {
            
                malade = new Malade(rs.getString("m.nom"),rs.getString("m.prenom"),rs.getInt("count(*)"),rs.getInt("count(distinct d.specialite)"));
                maladeList.add(malade);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        } 
            return maladeList;
     }
    
    
    //méthode retournant une liste des malades suivant la requête sql 17
   public static ArrayList <Malade> getMaladeListReq17()
    {        
        
        String query = "select    m.nom, m.prenom\n" +
                                    "from      malade m\n" +
                                    "where     numero in (select    h.no_malade         \n" +
                                    "from      hospitalisation h, service s, soigne so         \n" +
                                    "where     h.code_service = s.code        \n" +
                                    "and       s.directeur = so.no_docteur         \n" +
                                    "and       so.no_malade = h.no_malade ) ;";
        
        ArrayList<Malade> maladeList = null;
                
        maladeList = new ArrayList<Malade>();
       if(con==null)
           con =  DBConnection.getDBConnection();
  
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Malade malade;
            
            while(rs.next())
            {
            
                malade = new Malade(rs.getString("m.nom"),rs.getString("m.prenom"));
                maladeList.add(malade);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        } 
            return maladeList;
     }  
    
}
