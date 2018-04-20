/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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

    
    
    public Batiment(String batiment,String nomServ, int noChambre, int lit,  int idPatient, String nom, String prenom, String mutuelle) {
        this.batiment=batiment;
        this.nomServ = nomServ;
        
        this.noChambre = noChambre;
        this.lit = lit;
        
        this.nom = nom;
        this.prenom = prenom;
        this.mutuelle = mutuelle;
        this.idPatient = idPatient;
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
    
}
