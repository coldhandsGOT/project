/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.Docteur;
import Model.Malade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author idris
 */
public class requete11_GUI extends javax.swing.JFrame {
    private String query = "select    e.nom, e.prenom, count(h.no_malade) as countHS\n" +
                            "from      employe e, soigne s left outer join hospitalisation h using (no_malade)\n" +
                            "where     e.numero = s.no_docteur\n" +
                            "group by  e.nom, e.prenom ;";
            
            
            
    private String DB ="hopital";
    private String serverAddress="jdbc:mysql://localhost/"; 
    /**
     * Creates new form requete7_GUI
     */
    public requete11_GUI() {
        initComponents();
        ShowDocteurSwing();
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
    
    public void ShowDocteurSwing()
     {        
        ArrayList<Docteur> list = getDocteurList(query);
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        
        Object[] row = new Object[3];
        
        for(int i=0; i<list.size(); i++)
        {
           
            row[0]=list.get(i).getName();
            row[1]=list.get(i).getLastname();        
            row[2]=list.get(i).getnbHS();
       
           
         
            model.addRow(row);       
        }    
     }
     
    
    public ArrayList <Docteur> getDocteurList(String query)
    {        
        ArrayList<Docteur> docteurList = null;
                
        docteurList = new ArrayList<Docteur>();
        Connection con = getConnection();
  
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Docteur docteur;
         
            while(rs.next())
            {
           
                docteur = new Docteur(rs.getString("e.nom"),rs.getString("e.prenom"), rs.getInt("countHS"));   System.out.println("bug");
                docteurList.add(docteur);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        } 
            return docteurList;
     }
     
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prenom", "Nombre de Patients hospitalisés"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
