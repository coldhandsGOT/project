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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author idris
 */
public class ReportModel {
    static private  Connection con;
    
    
    
    
    
     public static  PieDataset createDatasetReport1( ) 
     {    
         DefaultPieDataset dataset = new DefaultPieDataset( );

          try {   
              con =  DBConnection.getDBConnection();
              
              Statement st1,st2,st3;
              ResultSet rs1,rs2,rs3;
              
              
              String query1 = "SELECT COUNT(*) as CAR FROM hospitalisation WHERE `code_service` LIKE '%CAR%';";
              String query2 = "SELECT COUNT(*) as CHG FROM hospitalisation WHERE `code_service` LIKE '%CHG%';";
              String query3 = "SELECT COUNT(*) as REA FROM hospitalisation WHERE `code_service` LIKE '%REA%';";
              
              st1= con.createStatement();
              st2= con.createStatement();
              st3= con.createStatement();
              
              rs1 = st1.executeQuery(query1);
              rs2 = st2.executeQuery(query2);
              rs3 = st3.executeQuery(query3);
              
              rs1.next();
              rs2.next();
              rs3.next();
                   
                
      dataset.setValue( "Cardiologie" ,rs1.getDouble(1) );  
      dataset.setValue( "Chirurgie generale" , rs2.getDouble(1)  );   
      dataset.setValue( "Reanimation et Traumatologie" , rs3.getDouble(1) );    
      
      return dataset;         
      
          } catch (SQLException ex) {
              Logger.getLogger(reporting1.class.getName()).log(Level.SEVERE, null, ex);
          }
         
              
        // recup_donnee();
          return dataset;
    
   }
     
     
     public static PieDataset createDatasetReport2( ) {
         
         DefaultPieDataset dataset = new DefaultPieDataset( );
         
         
         
          try {
            
              
              con =  DBConnection.getDBConnection();
              
              
              Statement st1,st2;
              ResultSet rs1,rs2;

              
              String query1 = " SELECT COUNT(*) as NUIT FROM infirmier WHERE `rotation` LIKE '%NUIT%';";
              String query2 = "SELECT COUNT(*) as JOUR FROM infirmier WHERE `rotation` LIKE '%JOUR%';";
           
              st1= con.createStatement();
              st2= con.createStatement();
            
              
              rs1 = st1.executeQuery(query1);
              rs2 = st2.executeQuery(query2);
              
              
              rs1.next();
              rs2.next();
                   
                
      dataset.setValue( "Nombre d'Infirmiers de Nuit" ,rs1.getDouble(1) );  
      dataset.setValue( "Nombre d'Infirmiers de Jour" , rs2.getDouble(1)  );   
       
      
      return dataset;         
      
          } catch (SQLException ex) {
              Logger.getLogger(reporting1.class.getName()).log(Level.SEVERE, null, ex);
          }
         
              
    
          return dataset;
    
   }
     
     
     
      public static PieDataset createDatasetReport3( ) {
         
         DefaultPieDataset dataset = new DefaultPieDataset( );
         
         
         
          try {
            
              
              con =  DBConnection.getDBConnection();
              
              
              Statement st1,st2,st3,st4,st5,st6;
              ResultSet rs1,rs2,rs3,rs4,rs5,rs6;

              
              String query1 = " SELECT COUNT(*) as PNEU FROM docteur WHERE `specialite` LIKE '%PNEUMOLOGUE%';";
              String query2 = "SELECT COUNT(*) as ORTH FROM docteur WHERE `specialite` LIKE '%orthopediste%';";
              String query3 = "SELECT COUNT(*) as CAR FROM docteur WHERE `specialite` LIKE '%Cardiologue%';";
              String query4 = "SELECT COUNT(*) as TRAU FROM docteur WHERE `specialite` LIKE '%Traumatologue%';";
              String query5 = "SELECT COUNT(*) as ANE FROM docteur WHERE `specialite` LIKE '%Anesthesiste%';";
              String query6 = "SELECT COUNT(*) as RAD FROM docteur WHERE `specialite` LIKE '%Radiologue%';";
              
           
              st1= con.createStatement();
              st2= con.createStatement();
              st3= con.createStatement();
              st4= con.createStatement();
              st5= con.createStatement();
              st6= con.createStatement();
            
              
              rs1 = st1.executeQuery(query1);
              rs2 = st2.executeQuery(query2);
              rs3 = st3.executeQuery(query3);
              rs4 = st4.executeQuery(query4);
              rs5 = st5.executeQuery(query5);
              rs6 = st6.executeQuery(query6);
              
              
              rs1.next();
              rs2.next();
              rs3.next();
              rs4.next();
              rs5.next();
              rs6.next();
                   
                
      dataset.setValue( "Pneumologue" ,rs1.getDouble(1) );  
      dataset.setValue( "Orthopédiste" , rs2.getDouble(1)  );   
      dataset.setValue( "Cardiologue" , rs3.getDouble(1)  ); 
      dataset.setValue( "Traumatologue" , rs4.getDouble(1)  ); 
      dataset.setValue( "Anesthesiste" , rs5.getDouble(1)  ); 
      dataset.setValue( "Radiologue" , rs6.getDouble(1)  ); 
       
      
      return dataset;         
      
          } catch (SQLException ex) {
              Logger.getLogger(reporting1.class.getName()).log(Level.SEVERE, null, ex);
          }
         
              
    
          return dataset;
    
   }
}
