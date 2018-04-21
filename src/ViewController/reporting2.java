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
 * @author RomainBoudigou
 */
public class reporting2 extends ApplicationFrame{
    
    
      private String DB ="hopital";
      private String serverAddress="jdbc:mysql://localhost/"; 
    
    public reporting2(String title) {
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
     
     
   
   private static JFreeChart createChart( PieDataset dataset ) {
       
        JFreeChart chart = ChartFactory.createPieChart3D( 
         "Rotation des infirmiers " ,  // chart title                   
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
