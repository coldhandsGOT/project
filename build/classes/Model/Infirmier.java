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
public class Infirmier {
    
    //déclaration des variables
    private int id;
    private String name;
    private String lastname;
    private String tel;
    private String adresse;
    private String codeservice;
    private String rotation;
    private float salaire;
    
    static private  Connection con;
        
    
  
    //constructeur initialisant toutes les variables
    public Infirmier(int id, String name, String lastname, String tel, String adresse, String codeservice, String rotation, float salaire)
    {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.tel = tel;
        this.adresse = adresse;
        this.codeservice = codeservice;
        this.rotation = rotation;
        this.salaire = salaire; 
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
    
    ////accesseur de la variable tel
     public String getTel() {
        return tel;
    }
     
    //accesseur de la variable adresse
    public String getAdresse() {
        return adresse;
    }
    
    //accesseur de la variable codeservice
    public String getCodeService() {
        return codeservice;
    }  
    
    //accesseur de la variable rotation
    public String getRotation() {
        return rotation;
    }
    
    //accesseur de la variable salaire
    public float getSalaire() {
        return salaire;
    }
 
    //méthode retournant la liste des infirmier
     public static ArrayList <Infirmier> getInfirmierList(String query)
    {        
        con =  DBConnection.getDBConnection();
        ArrayList<Infirmier> infirmierList = null;
                
        infirmierList = new ArrayList<Infirmier>();
     
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Infirmier infirmier;
            
            while(rs.next())
            {
               
                infirmier = new Infirmier(rs.getInt("e.numero"), rs.getString("e.nom"),rs.getString("e.prenom"),rs.getString("e.tel"),rs.getString("e.adresse"),rs.getString("i.code_service"),rs.getString("i.rotation"), rs.getFloat("i.salaire"));
                infirmierList.add(infirmier);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view, error x93");
        } 
            return infirmierList;
     }
    
    
    //accesseur du salaire moyen     
    public static String getSalaireMoyen(String query)
    {        
         con =  DBConnection.getDBConnection();
        String sal=null;
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            System.out.println("avg sal is ");
            
             
            while (rs.next()) {
                     sal  = rs.getString("AVG(salaire)");
                    System.out.println(sal);

                    }
            }           
           
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display salaire");
        } 
            return sal;
     }
    
    
    
}
