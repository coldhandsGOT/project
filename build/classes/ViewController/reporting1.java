/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;
import Model.ReportModel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author RomainBoudigou
 */
public class reporting1 extends ApplicationFrame {
    
   
     
    
    
    public reporting1(String title) {
        super(title);
         setContentPane(createDemoPanel( ));
       
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
  
       
      JFreeChart chart ;  
      chart = createChart(ReportModel.createDatasetReport1());
      return new ChartPanel( chart ); 
      
   }
    
    
    
    
    
    
    
    
}
