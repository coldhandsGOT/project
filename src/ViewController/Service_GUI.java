/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;


import Model.Malade;
import Model.Service;
import java.awt.HeadlessException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author idris
 */
public class Service_GUI extends javax.swing.JFrame {
            private String query = "SELECT s.code, s.nom, s.batiment, e.nom, e.prenom, d.specialite, d.numero\n" +
                "FROM service s, employe e, docteur d \n" +
                "where s.directeur = d.numero AND d.numero = e.numero";
            
            private String DB ="hopital";
            private String serverAddress="jdbc:mysql://localhost/";
    /**
     * Creates new form Service_GUI
     */
    public Service_GUI() {
        initComponents();
        getConnection();
        
        txt_rapCard.setText(Float.toString(getRappIm("select ((SELECT  count(*) from infirmier i   WHERE  i.code_service = s.code ) / ( SELECT count(*)  FROM   hospitalisation h  WHERE   h.code_service = s.code )) AS rappIm FROM  service s WHERE s.nom='Cardiologie';")));
        txt_rappChir.setText(Float.toString(getRappIm("select ((SELECT  count(*) from infirmier i   WHERE  i.code_service = s.code ) / ( SELECT count(*)  FROM   hospitalisation h  WHERE   h.code_service = s.code )) AS rappIm FROM  service s WHERE s.nom='Chirurgie generale';")));
          txt_rappRean.setText(Float.toString(getRappIm("select ((SELECT  count(*) from infirmier i   WHERE  i.code_service = s.code ) / ( SELECT count(*)  FROM   hospitalisation h  WHERE   h.code_service = s.code )) AS rappIm FROM  service s WHERE s.nom='Reanimation et Traumatologie';")));
       }
    
    
     public float getRappIm(String query)
    {        
        
        
        Connection con = getConnection();
        float rapp= 0 ;
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            
            
             
            while (rs.next()) {
                     rapp  = rs.getFloat("rappIm");
                    System.out.println("erreur");

                    }
            }           
           
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display rapport Card");
        } 
            return rapp;
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
   
   
   
   public boolean checkInputs()
     {
        return !(txt_Id.getText() == null || txt_idResp.getText() == null); 
     }
   
   
    public ArrayList <Service> getServiceList(String query)
    {        
        ArrayList<Service> serviceList = null;
                
        serviceList = new ArrayList<Service>();
        Connection con = getConnection();
  
        Statement st;
        ResultSet rs;
     
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Service service;
            
            while(rs.next())
            {
              
                service = new Service(rs.getString("s.code"), rs.getString("s.nom"),rs.getString("s.batiment"),rs.getString("e.nom"),rs.getString("e.prenom"),rs.getString("d.specialite"), rs.getInt("d.numero")); 
                serviceList.add(service); 
                
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        } 
            return serviceList;
     }
    
    
    
   
    
    
   public void ShowServiceSwing()
     {     
        
        ArrayList<Service> list = getServiceList(query);
        DefaultTableModel model = (DefaultTableModel) JTable_Products.getModel();
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        
        Object[] row = new Object[7];
       
        for(int i=0; i<list.size(); i++)
        {
            
           row[0]=list.get(i).getId();
           row[1]=list.get(i).getNomSrv();
           row[2]=list.get(i).getBatiment();
           row[3]=list.get(i).getIdResp();
           row[4]=list.get(i).getNomResp();
           row[5]=list.get(i).getPrenomResp();
           row[6]=list.get(i).getSpecResp();
           
        
            model.addRow(row);       
        } 
        
        
     }
     
    
   
     
    
    
    
     public void ShowItem(int index)
    {       
        txt_Id.setText(getServiceList(query).get(index).getId());
        txt_nomServ.setText(getServiceList(query).get(index).getNomSrv());
        txt_Bat.setText(getServiceList(query).get(index).getBatiment());
        txt_idResp.setText(Integer.toString(getServiceList(query).get(index).getIdResp()));
    }
    
   
   
   
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_nomServ = new javax.swing.JTextField();
        txt_Id = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Btn_Insert = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Btn_Update = new javax.swing.JButton();
        Btn_Previous = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();
        Btn_ShowAll = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_rapCard = new javax.swing.JTextField();
        txt_rappChir = new javax.swing.JTextField();
        txt_rappRean = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable_Products = new javax.swing.JTable();
        txt_Bat = new javax.swing.JTextField();
        txt_idResp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_nomServ.setBackground(new java.awt.Color(255, 255, 255));
        txt_nomServ.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_nomServ.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_nomServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomServActionPerformed(evt);
            }
        });

        txt_Id.setBackground(new java.awt.Color(255, 255, 255));
        txt_Id.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Id.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IdActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Nom Service");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Code Service:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Batiment:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("ID responsable:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(191, 191, 191))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        Btn_Insert.setBackground(new java.awt.Color(51, 51, 51));
        Btn_Insert.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Btn_Insert.setForeground(new java.awt.Color(51, 204, 255));
        Btn_Insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        Btn_Insert.setText("Insert");
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });

        Btn_Delete.setBackground(new java.awt.Color(51, 51, 51));
        Btn_Delete.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Btn_Delete.setForeground(new java.awt.Color(51, 204, 255));
        Btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        Btn_Delete.setText("Delete");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });

        Btn_Update.setBackground(new java.awt.Color(51, 51, 51));
        Btn_Update.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Btn_Update.setForeground(new java.awt.Color(51, 204, 255));
        Btn_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        Btn_Update.setText("Update");
        Btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UpdateActionPerformed(evt);
            }
        });

        Btn_Previous.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Previous.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Btn_Previous.setForeground(new java.awt.Color(0, 51, 51));
        Btn_Previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/previous.png"))); // NOI18N
        Btn_Previous.setText("Previous");
        Btn_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PreviousActionPerformed(evt);
            }
        });

        Btn_Next.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Next.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Btn_Next.setForeground(new java.awt.Color(0, 51, 51));
        Btn_Next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next.png"))); // NOI18N
        Btn_Next.setText("    Next");
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });

        Btn_Last.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Last.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Btn_Last.setForeground(new java.awt.Color(0, 51, 51));
        Btn_Last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/last.png"))); // NOI18N
        Btn_Last.setText("Last");
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });

        Btn_First.setBackground(new java.awt.Color(255, 255, 255));
        Btn_First.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        Btn_First.setForeground(new java.awt.Color(0, 51, 51));
        Btn_First.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/first.png"))); // NOI18N
        Btn_First.setText("First");
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });

        Btn_ShowAll.setText("Show all");
        Btn_ShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ShowAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Btn_ShowAll)
                .addGap(77, 77, 77)
                .addComponent(Btn_Insert)
                .addGap(27, 27, 27)
                .addComponent(Btn_Update)
                .addGap(111, 111, 111)
                .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(Btn_Delete)
                .addGap(306, 306, 306)
                .addComponent(Btn_Previous)
                .addGap(44, 44, 44)
                .addComponent(Btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Insert)
                    .addComponent(Btn_Update)
                    .addComponent(Btn_First)
                    .addComponent(Btn_Last)
                    .addComponent(Btn_ShowAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Next)
                    .addComponent(Btn_Previous)
                    .addComponent(Btn_Delete))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cardiologie");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Chirurgie generale ");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Reanimation et Traumatologie ");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("rapport infirmier/medecin");

        txt_rapCard.setEditable(false);
        txt_rapCard.setBackground(new java.awt.Color(0, 204, 255));
        txt_rapCard.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_rapCard.setBorder(null);
        txt_rapCard.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_rapCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rapCardActionPerformed(evt);
            }
        });

        txt_rappChir.setEditable(false);
        txt_rappChir.setBackground(new java.awt.Color(0, 204, 255));
        txt_rappChir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_rappChir.setBorder(null);
        txt_rappChir.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_rappChir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rappChirActionPerformed(evt);
            }
        });

        txt_rappRean.setEditable(false);
        txt_rappRean.setBackground(new java.awt.Color(0, 204, 255));
        txt_rappRean.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_rappRean.setBorder(null);
        txt_rappRean.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_rappRean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rappReanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_rappChir, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rappRean, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_rapCard, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_rapCard, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_rappChir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_rappRean, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        JTable_Products.setBackground(new java.awt.Color(255, 255, 255));
        JTable_Products.setForeground(new java.awt.Color(0, 0, 0));
        JTable_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code Service", "Nom Service", "Batiment", "Numero Responsable", "Nom Responsable", "Prenom Responsable", "Specialite Responsable"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_ProductsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTable_Products);

        txt_Bat.setBackground(new java.awt.Color(255, 255, 255));
        txt_Bat.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Bat.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_idResp.setBackground(new java.awt.Color(255, 255, 255));
        txt_idResp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_idResp.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_idResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idRespActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nomServ, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Bat, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(txt_nomServ, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Bat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_idResp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(188, 188, 188)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IdActionPerformed

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed

        if(checkInputs())
        {
            try{
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO service (code, nom, batiment, directeur) VALUES (?,?,?,?);");
              
                ps.setString(1, txt_Id.getText());
                ps.setString(2, txt_nomServ.getText());
                ps.setString(3, txt_Bat.getText());
                ps.setString(4, txt_idResp.getText());

                ps.executeUpdate();
             
                
                ShowServiceSwing();
                JOptionPane.showMessageDialog(null, "Data inserted Successfully");

            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Can't Insert New Data");
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
        }
    }//GEN-LAST:event_Btn_InsertActionPerformed

    int pos =0;
    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed

        if(!txt_Id.getText().equals(""))
        {
            try
            {
                Connection con = getConnection();

                PreparedStatement ps = con.prepareStatement("DELETE FROM service where code = ?");

                

                ps.setString(1, txt_Id.getText());
                ps.executeUpdate();

                ShowServiceSwing();

                JOptionPane.showMessageDialog(null, "Entry Deleted");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Can't delete entry");
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Enter proper ID to delete Entry");
        }
    }//GEN-LAST:event_Btn_DeleteActionPerformed

    private void Btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UpdateActionPerformed
       String updateQuery = null;
        PreparedStatement ps = null;
        Connection con = getConnection();

        if(checkInputs())
        {
            try
            {

                updateQuery = "UPDATE service SET nom = ?, batiment= ?,directeur= ? where code = ?";

                ps = con.prepareStatement(updateQuery);

                
                ps.setString(1, txt_nomServ.getText());
                ps.setString(2, txt_Bat.getText());
                ps.setString(3, txt_idResp.getText());
                ps.setString(4, txt_Id.getText());
                
                ps.executeUpdate();

                ShowServiceSwing();
                JOptionPane.showMessageDialog(null, "File updated");

            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Erreur, soit l'ID rentré n'est pas celui d'un docteur, soit un champ n'a pas était remplis ");
            }
        }
 
    }//GEN-LAST:event_Btn_UpdateActionPerformed

    private void Btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PreviousActionPerformed
        try{
            pos--;
            ShowItem(pos);
            System.out.println(pos);
        }
        catch(Exception e)
        {
            pos=0;
            System.out.println(pos);
        }
    }//GEN-LAST:event_Btn_PreviousActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed
        try{
            pos++;
            ShowItem(pos);
            System.out.println(pos);
        }

        catch(Exception e)
        {
            pos=getServiceList(query).size()-1;
            System.out.println(pos);
        }
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
        pos = getServiceList(query).size()-1;
        ShowItem(pos);
        System.out.println(pos);
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        pos = 0;
        ShowItem(pos);
        System.out.println(pos);
    }//GEN-LAST:event_Btn_FirstActionPerformed

    
    
    
    
    private void Btn_ShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ShowAllActionPerformed
        query = "SELECT s.code, s.nom, s.batiment, e.nom, e.prenom, d.specialite, d.numero\n" +
                "FROM service s, employe e, docteur d \n" +
                "where s.directeur = d.numero AND d.numero = e.numero";

        ShowServiceSwing();
    }//GEN-LAST:event_Btn_ShowAllActionPerformed

    private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_ProductsMouseClicked
        int index = JTable_Products.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_JTable_ProductsMouseClicked

    
    
    
    private void txt_idRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idRespActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idRespActionPerformed

    private void txt_nomServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomServActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomServActionPerformed

    private void txt_rapCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rapCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rapCardActionPerformed

    private void txt_rappChirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rappChirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rappChirActionPerformed

    private void txt_rappReanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rappReanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rappReanActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Previous;
    private javax.swing.JButton Btn_ShowAll;
    private javax.swing.JButton Btn_Update;
    private javax.swing.JTable JTable_Products;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_Bat;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_idResp;
    private javax.swing.JTextField txt_nomServ;
    private javax.swing.JTextField txt_rapCard;
    private javax.swing.JTextField txt_rappChir;
    private javax.swing.JTextField txt_rappRean;
    // End of variables declaration//GEN-END:variables
}
