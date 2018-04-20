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
public class Docteur {
    private int id;
    private String name;
    private String lastname;
    private String speciality;
    private String Tel;
    private String Adresse;
    public Docteur(int id, String name, String lastname, String speciality, String Tel, String Adresse) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.speciality = speciality;
        this.Tel = Tel;
        this.Adresse = Adresse;
     
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
}
