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
public class Infirmier {
    
    private int id;
    private String name;
    private String lastname;
    private String tel;
    private String adresse;
    private String codeservice;
    private String rotation;
    private float salaire;

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }  

    public String getLastname() {
        return lastname;
    }
     public String getTel() {
        return tel;
    }
    public String getAdresse() {
        return adresse;
    }
   
    public String getCodeService() {
        return codeservice;
    }  

    public String getRotation() {
        return rotation;
    }

    public float getSalaire() {
        return salaire;
    }
    
}
