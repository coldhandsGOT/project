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
public class Service {
    
    //déclaration des variables
    private String code;
    private String nomSrv;
    private String Batiment;
    private String nomResp;
    private String prenomResp;
    private String specResp;
    private int idResp;
    static private  Connection con;
   
    
    //constructeur initiamisant toutes les variables
    public Service(String code, String nomSrv, String Batiment, String nomResp, String prenomResp, String specResp, int idResp) {
        this.code = code;
        this.nomSrv = nomSrv;
        this.Batiment = Batiment;
        this.nomResp = nomResp;
        this.prenomResp = prenomResp;
        this.specResp = specResp;
         this.idResp = idResp;
    }

    
    //accesseur de la variable id
    public String getId() {
        return code;
    }
    
    //accesseur de la variable nomSrv
    public String getNomSrv() {
        return nomSrv;
    }
    
    //accesseur de la variable Batiment
    public String getBatiment() {
        return Batiment;
    }
    
    //accesseur de la variable nomResp
    public String getNomResp() {
        return nomResp;
    }
    
    //accesseur de la variable prenomResp
    public String getPrenomResp() {
        return prenomResp;
    }
    
    //accesseur de la variable specResp
    public String getSpecResp() {
        return specResp;
    }
    
    //accesseur de la variable idResp
    public int getIdResp () {
        return idResp;
    }
  
  //méthode renvoyant le graphe des medecins par rapport aux infirmiers
  public static float getRappIm(String query)
    {        
        
     con =  DBConnection.getDBConnection();
       
        float rapp= 0 ;
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            
            
             
            while (rs.next()) {
                     rapp  = rs.getFloat("rappIm");
                    System.out.println("erreur");

                    }
            }           
           
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display rapport Card");
        } 
            return rapp;
     }
  
     //méthode retournant la liste des services
   public static ArrayList <Service> getServiceList(String query)
    {        
        ArrayList<Service> serviceList = null;
                
        serviceList = new ArrayList<Service>();
        con =  DBConnection.getDBConnection();
  
        Statement st;
        ResultSet rs;
     
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Service service;
            
            while(rs.next())
            {
              
                service = new Service(rs.getString("s.code"), rs.getString("s.nom"),rs.getString("s.batiment"),rs.getString("e.nom"),rs.getString("e.prenom"),rs.getString("d.specialite"), rs.getInt("d.numero")); 
                serviceList.add(service); 
                
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        } 
            return serviceList;
     }
  
  
  

 
  
}
