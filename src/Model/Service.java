/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import ViewController.reporting1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author idris
 */
public class Service {
    private String code;
    private String nomSrv;
    private String Batiment;
    private String nomResp;
    private String prenomResp;
    private String specResp;
    private int idResp;
    static private  Connection con;
   
    
    
    public Service(String code, String nomSrv, String Batiment, String nomResp, String prenomResp, String specResp, int idResp) {
        this.code = code;
        this.nomSrv = nomSrv;
        this.Batiment = Batiment;
        this.nomResp = nomResp;
        this.prenomResp = prenomResp;
        this.specResp = specResp;
         this.idResp = idResp;
    }

    
    
    public String getId() {
        return code;
    }

    public String getNomSrv() {
        return nomSrv;
    }

    public String getBatiment() {
        return Batiment;
    }

    public String getNomResp() {
        return nomResp;
    }

    public String getPrenomResp() {
        return prenomResp;
    }

    public String getSpecResp() {
        return specResp;
    }
  public int getIdResp ()
          {
              return idResp;
          }
  
  
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
