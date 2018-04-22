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
public class Docteur {
    
    //déclaration des variables
    private int id;
    private String name;
    private String lastname;
    private String speciality;
    private String Tel;
    private String Adresse;
    private int nbHS;
    
    
    static private  Connection con;
    
  
    
    //premier constructeur initialisant les variables id, name, lastname, speciality, Tel, Adresse
    public Docteur(int id, String name, String lastname, String speciality, String Tel, String Adresse) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.speciality = speciality;
        this.Tel = Tel;
        this.Adresse = Adresse;
     
    }
    
    //second constructeur en surcharge initialisant les variables name, lastname, nbHS
    public Docteur(String name, String lastname, int nbHS) 
    {    
        this.name = name;
        this.lastname = lastname;
        this.nbHS = nbHS; 
    }
    
    //troisième constructeur en surcharge initialisant les variables name, lastname
    public Docteur(String name, String lastname) 
    {   
        this.name = name;
        this.lastname = lastname;
    }
      
    //accesseur de la variable privée nbHS
    public int getnbHS() {
        return nbHS;
    }
    
    //accesseur de la variable privée id
    public int getId() {
        return id;
    }
    
    //accesseur de la variable privée name
    public String getName() {
        return name;
    }  
    
    //accesseur de la variable privée lastname
    public String getLastname() {
        return lastname;
    }
    
    //accesseur de la variable privée speciality
    public String getSpeciality() {
        return speciality;
    }
    
    //accesseur de la variable privée Tel
    public String getTel() {
        return Tel;
    }
    
    //accesseur de la variable privée Adresse
    public String getAdresse() {
        return Adresse;
    }
    
    
    
    
    
    
    
     //méthode retournant la liste des docteurs
     public static ArrayList <Docteur> getDocteurList(String query)
     {        
        if(con==null)
         con =  DBConnection.getDBConnection();
         
        ArrayList<Docteur> docteurList = null;
                
        docteurList = new ArrayList<Docteur>();
        
            
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Docteur docteur;
            
            while(rs.next())
            {
                docteur = new Docteur(rs.getInt("e.numero"), rs.getString("e.nom"),rs.getString("e.prenom"),rs.getString("d.specialite"), rs.getString("e.tel"), rs.getString("e.adresse"));
                docteurList.add(docteur);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        }
        
            return docteurList;
     }
     
    //méthode retournant une liste des docteurs suivant la requête sql 11 
     public static ArrayList <Docteur> getDocteurlistRequ11()
    {        
        String query = "select    e.nom, e.prenom, count(h.no_malade) as countHS\n" +
                            "from      employe e, soigne s left outer join hospitalisation h using (no_malade)\n" +
                            "where     e.numero = s.no_docteur\n" +
                            "group by  e.nom, e.prenom ;";
        ArrayList<Docteur> docteurList = null;
                
        docteurList = new ArrayList<Docteur>();
        if(con==null)
         con =  DBConnection.getDBConnection();
  
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Docteur docteur;
         
            while(rs.next())
            {
           
                docteur = new Docteur(rs.getString("e.nom"),rs.getString("e.prenom"), rs.getInt("countHS"));   
                docteurList.add(docteur);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        } 
            return docteurList;
     }
     
     
    //méthode retournant une liste des docteurs suivant la requête sql 15 et 16
     public static ArrayList <Docteur> getDocteurListReq15_16(String query)
    {     
        
        if(con==null)
        con =  DBConnection.getDBConnection();
        
       
        
        ArrayList<Docteur> docteurList = null;
                
        docteurList = new ArrayList<Docteur>();
       
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Docteur docteur;
         
            while(rs.next())
            {
           
                docteur = new Docteur(rs.getString("e.nom"),rs.getString("e.prenom"));   System.out.println("bug");
                docteurList.add(docteur);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        } 
            return docteurList;
     }
     
     
     
}
