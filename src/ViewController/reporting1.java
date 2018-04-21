/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;
import Model.Malade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import static org.jfree.chart.demo.PieChartDemo1.createDemoPanel;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author RomainBoudigou
 */
public class reporting1 extends ApplicationFrame {
    
   
      private String DB ="hopital";
      private String serverAddress="jdbc:mysql://localhost/"; 
     
      
    
    public reporting1(String title) {
        super(title);
         setContentPane(createDemoPanel( ));
       
    }
    
      // Coonection to DB
   public Connection getConnection()
    {
        Connection con = null;
        
        try {
            
            con = DriverManager.getConnection(""+serverAddress+ DB+"","root", "root");
            
            return con;
        } 
        
        catch (SQLException ex) {
           
                  JOptionPane.showMessageDialog(null, "Failed to connect to DB");
                   return con;
        }
    }
   
  
    
     private  PieDataset createDataset( ) {
         
         DefaultPieDataset dataset = new DefaultPieDataset( );
         
         
          try {
            
              
              Connection con = getConnection();
              
              
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
     
     
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "nombre d’hospitalisés par type de service",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public JPanel createDemoPanel() {
  
       
      JFreeChart chart = createChart(createDataset() );  
      return new ChartPanel( chart ); 
      
   }
    
    
    
    
    
    
    
    
}
