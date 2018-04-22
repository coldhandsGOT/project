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
    
    //déclaration des variables
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
    
    //premier constructeur initialisant les variables batiment, noChambre
     public Batiment(String batiment,int noChambre)//test commit 
    {
        this.batiment=batiment;   
        this.noChambre = noChambre; 
     
    }
    
    //second constructeur en surcharge initialisant les variables batiment, noChambre, nomServ
    public Batiment(String batiment,int noChambre, String nomServ) 
    {
        this.batiment=batiment;   
        this.noChambre = noChambre; 
        this.nomServ = nomServ;
    }
    
    
    
    
    //troisième constructeur en surcharge initialisant les variables batiment, nomServ, noChambre, lit, nom, prenom, mutuelle, idPatient
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
    
    //quatrième constructeur en surcharge initialisant les variables batiment, noChambre, lit, litOcc
    public Batiment(String batiment, int noChambre, int lit, int litOcc) {
        this.batiment=batiment;   
        this.noChambre = noChambre;   
        this.lit = lit;   
        this.litOcc = litOcc;     
    }

    
    //accesseur de la variable litOcc
    public int getLitOcc() {
        return litOcc;
    }

   

    //accesseur de la variable batiment
    public String getBatiment() {
        return batiment;
    }
    
    //accesseur de la variable noChambre
    public int getNoChambre() {
        return noChambre;
    }
    
    //accesseur de la variable lit
    public int getLit() {
        return lit;
    }  
    
    //accesseur de la variable nomServ
    public String getNomServ() {
        return nomServ;
    }
    
    //accesseur de la variable nom
    public String getNom() {
        return nom;
    }
    
    //accesseur de la variable prenom
    public String getPrenom() {
        return prenom;
    }
    
    //accesseur de la variable mutuelle
    public String getMutuelle() {
        return mutuelle;
    }
    
    //accesseur de la variable idPatient
     public int getIdPatient() {
        return idPatient;
    }

     //méthode retournant une liste des batiments suivant la requête sql 12
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


     //méthode retournant une liste des batiments suivant la requête sql 11
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
  
  
     //méthode retournant une liste des batiments suivant la requête sql 14
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
