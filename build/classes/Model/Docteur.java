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
    private int id;
    private String name;
    private String lastname;
    private String speciality;
    private String Tel;
    private String Adresse;
    private int nbHS;
    
    
    static private  Connection con;
    
  
    
    
    public Docteur(int id, String name, String lastname, String speciality, String Tel, String Adresse) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.speciality = speciality;
        this.Tel = Tel;
        this.Adresse = Adresse;
     
    }
    
    public Docteur(String name, String lastname, int nbHS) 
    {    
        this.name = name;
        this.lastname = lastname;
        this.nbHS = nbHS; 
    }

    public Docteur(String name, String lastname) 
    {   
        this.name = name;
        this.lastname = lastname;
    }
    
    

    public int getnbHS() {
        return nbHS;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }  

    public String getLastname() {
        return lastname;
    }

    public String getSpeciality() {
        return speciality;
    }
   
    public String getTel() {
        return Tel;
    }
    public String getAdresse() {
        return Adresse;
    }
    
    
    
    
    
    
    
     
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
