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
import org.jfree.chart.plot.PiePlot3D; 
import org.jfree.chart.JFreeChart;
import static org.jfree.chart.demo.PieChartDemo1.createDemoPanel;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.io.*; 
import org.jfree.chart.ChartUtilities;


/**
 *
 * @author BoudigouRomain
 */
public class reporting3 extends ApplicationFrame{
    
     private String DB ="hopital";
     private String serverAddress="jdbc:mysql://localhost/"; 
    
    public reporting3(String title) {
        super(title);
         setContentPane(createDemoPanel( ));
        
    }
    
    
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
     
     
   
   private static JFreeChart createChart( PieDataset dataset ) {
       
        JFreeChart chart = ChartFactory.createPieChart3D( 
         "Repartion des Docteurs par spécialité " ,  // chart title                   
         dataset ,         // data 
         true ,            // include legend                   
         true, 
         false);
        
        
        final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );             
         plot.setStartAngle( 270 );             
             plot.setForegroundAlpha( 0.60f );             
         plot.setInteriorGap( 0.02 );             
      int width = 640;   /* Width of the image */             
      int height = 480;  /* Height of the image */          
      return chart;
   }
   
   public JPanel createDemoPanel() {
  
       
      JFreeChart chart = createChart(createDataset() );  
      return new ChartPanel( chart ); 
      
   }
    
    
}
