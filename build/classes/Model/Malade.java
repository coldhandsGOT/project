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
public class Malade {
    private int id;
    private String name;
    private String lastname;
    private String mutuelle;
    private String tel;
    private String adresse;
    private int count;
    private int count2;

    public int getCount() {
        return count;
    }

    public int getCount2() {
        return count2;
    }
    
 
         
      public Malade(String name, String lastname, int count, int count2) {
      
        this.name = name;
        this.lastname = lastname;
        this.count = count;
        this.count2 = count2;
       
    }
         
         
    public Malade(int id, String name, String lastname, String mutuelle, String tel, String adresse) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.mutuelle = mutuelle;
        this.tel = tel;
        this.adresse = adresse;
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

    public String getMutuelle() {
        return mutuelle;
    }
    
    public String getTel() {
        return tel;
    }
    
    public String getAdresse() {
        return adresse;
    }
}
