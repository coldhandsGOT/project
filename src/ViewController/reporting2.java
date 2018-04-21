/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PiePlot3D; 
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import Model.ReportModel;

/**
 *
 * @author RomainBoudigou
 */
public class reporting2 extends ApplicationFrame{
    
    
     
    public reporting2(String title) {
        super(title);
        setContentPane(createDemoPanel( ));
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
  
       
      JFreeChart chart = createChart(ReportModel.createDatasetReport2() );  
      return new ChartPanel( chart ); 
      
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
