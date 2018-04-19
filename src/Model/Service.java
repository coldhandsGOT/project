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
public class Service {
    private String code;
    private String nomSrv;
    private String Batiment;
    private String nomResp;
    private String prenomResp;
    private String specResp;
    private int idResp;
    
   
    
    
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
}
