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
public class Batiment {
    private String batiment;
    private int noChambre;
    private int lit;
    private String nomServ;
     private int idPatient;
    private String nom;
    private String prenom;
    private String mutuelle;
    private int litOcc;
    
    private static Connection con;
    
    
     public Batiment(String batiment,int noChambre) 
    {
        this.batiment=batiment;   
        this.noChambre = noChambre; 
     
    }
    
    
    public Batiment(String batiment,int noChambre, String nomServ) 
    {
        this.batiment=batiment;   
        this.noChambre = noChambre; 
        this.nomServ = nomServ;
    }
    
    
    
    
    
    public Batiment(String batiment,String nomServ, int noChambre, int lit,  int idPatient, String nom, String prenom, String mutuelle) 
    {
        this.batiment=batiment;
        this.nomServ = nomServ;
        
        this.noChambre = noChambre;
        this.lit = lit;
        
        this.nom = nom;
        this.prenom = prenom;
        this.mutuelle = mutuelle;
        this.idPatient = idPatient;
    }

    public Batiment(String batiment, int noChambre, int lit, int litOcc) {
        this.batiment=batiment;   
        this.noChambre = noChambre;   
        this.lit = lit;   
        this.litOcc = litOcc;     
    }

    

    public int getLitOcc() {
        return litOcc;
    }

   


    public String getBatiment() {
        return batiment;
    }

    public int getNoChambre() {
        return noChambre;
    }

    public int getLit() {
        return lit;
    }  

    public String getNomServ() {
        return nomServ;
    }

    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public String getMutuelle() {
        return mutuelle;
    }
     public int getIdPatient() {
        return idPatient;
    }
    
public static ArrayList <Batiment> getBatimentListRequete12()
    {        
        String query = "select    distinct s.batiment, h.no_chambre\n" +
                            "from      service s, hospitalisation h\n" +
                            "where     s.code = h.code_service ;";
        
        ArrayList<Batiment> batimentList = null;
                
        batimentList = new ArrayList<Batiment>();
        if (con ==null)
         con =  DBConnection.getDBConnection();
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Batiment batiment;
         
            while(rs.next())
            {
         
                batiment = new Batiment(rs.getString("s.batiment"),rs.getInt("h.no_chambre"));   
                batimentList.add(batiment);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        } 
            return batimentList;
     }



  public static ArrayList <Batiment> getBatimentListRequete13()
    {        
        String query = "select    s.batiment, c.no_chambre, s.nom\n" +
                            "from      service s, chambre c\n" +
                            "where     s.code = c.code_service\n" +
                            "and       (c.code_service, c.no_chambre) not in ( select    code_service, no_chambre  from hospitalisation ) ;";
        ArrayList<Batiment> batimentList = null;
                
        batimentList = new ArrayList<Batiment>();
        if (con ==null)
         con =  DBConnection.getDBConnection();
  
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Batiment batiment;
         
            while(rs.next())
            {
         
                batiment = new Batiment(rs.getString("s.batiment"),rs.getInt("c.no_chambre"),rs.getString("s.nom")); 
                batimentList.add(batiment);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        } 
            return batimentList;
     }
  
  
  
  public static ArrayList <Batiment> getBatimentListRequete14()
    {        
        String query = "select    s.batiment, c.no_chambre, c.nb_lits,  count(h.lit) as nb_lits_occupes\n" +
                            "from      service s, chambre c left outer join hospitalisation h using (code_service, no_chambre)\n" +
                            "where     s.code = c.code_service\n" +
                            "group by  s.batiment, c.no_chambre, c.nb_lits ;";
        
        ArrayList<Batiment> batimentList = null;
                
        batimentList = new ArrayList<Batiment>();
        
        if (con ==null)
         con =  DBConnection.getDBConnection();
    
  
  
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Batiment batiment;
         
            while(rs.next())
            {
    
                batiment = new Batiment(rs.getString("s.batiment"),rs.getInt("c.no_chambre"), rs.getInt("c.nb_lits"), rs.getInt("nb_lits_occupes"));
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
