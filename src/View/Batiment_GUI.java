/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Batiment;
import Model.Docteur;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author idris
 */
public class Batiment_GUI extends javax.swing.JFrame {

        private String query = "select    s.batiment, h.no_chambre, h.lit, s.nom, m.numero, m.prenom, m.nom, m.mutuelle\n" +
                                "from   service s, hospitalisation h, malade m \n" +
                                "where   s.code = h.code_service\n" +
                                "and h.no_malade = m.numero;";
        
        
        private String DB ="hopital";
        private String serverAddress="jdbc:mysql://localhost/";
    

    public Batiment_GUI() {
      
        initComponents();
        getConnection();
        txt_nbLitsCHG.setText(getNbLitsREA("SELECT AVG(c.nb_lits) FROM chambre c, service s WHERE s.batiment LIKE '%A%' AND s.code = c.code_service And s.code='CHG'"));
        txt_nbLitsREA.setText(getNbLitsREA("SELECT AVG(c.nb_lits) FROM chambre c, service s WHERE s.batiment LIKE '%A%' AND s.code = c.code_service And s.code='REA'"));
 
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
            Logger.getLogger(Docteur_GUI.class.getName()).log(Level.SEVERE, null, ex);
                   //JOptionPane.showMessageDialog(null, "Failed to connect to DB");
                   return con;
        }
    }
        public String getNbLitsREA(String query)
    {        
        Connection con = getConnection();
        String sal=null;
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            System.out.println("avg lits is ");
            
             
            while (rs.next()) {
                     sal  = rs.getString("AVG(c.nb_lits)");
                    System.out.println(sal);

                    }
            }           
           
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display salaire");
        } 
            return sal;
     }
    
    
    
        
 

       
    
    // Check input fields
    //txt_Speciality
  /*   public boolean checkInputs()
     {
    return !(txt_Name.getText() == null || txt_Lastname.getText() == null ); 
     }
     */
    
    // display data in Jtable

    // 1 - remplir ArrayList avec les données
    
     
     
     public ArrayList <Batiment> getBatimentList(String query)
     {        
        ArrayList<Batiment> batimentList = null;
                
        batimentList = new ArrayList<Batiment>();
        Connection con = getConnection();
        
            
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Batiment batiment;
            
            while(rs.next())
            {
          
                batiment = new Batiment(rs.getString("s.batiment"), rs.getString("s.nom"), rs.getInt("h.no_chambre"), rs.getInt("h.lit"), rs.getInt("m.numero") ,rs.getString("m.nom"), rs.getString("m.prenom"), rs.getString("m.mutuelle"));
              System.out.println("bug");
                batimentList.add(batiment);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view");
        }
        
            return batimentList;
     }
     
     
     // 2 - remplire la JTable avec le arrayList
    
    public void ShowBatimentSwing()
     {        
       

        ArrayList<Batiment> list = getBatimentList(query);
        DefaultTableModel model = (DefaultTableModel) JTable_Products.getModel();
    
        //the following two lines of code refreshes the JTable by deleting all rows
        //then, replaced by new rows after insert/delete/update
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        
        Object[] row = new Object[8];
        
        for(int i=0; i<list.size(); i++)
        {
            row[0]=list.get(i).getBatiment();
             row[1]=list.get(i).getNomServ();
            row[2]=list.get(i).getNoChambre();
            row[3]=list.get(i).getLit();         
            row[4]=list.get(i).getIdPatient();
            
            row[5]=list.get(i).getNom();
            row[6]=list.get(i).getPrenom();
            row[7]=list.get(i).getMutuelle();
            
            
            model.addRow(row);
             
        }   
        
      
     }
    
    //afficher les elements de la JTable sur l'interface
    public void ShowItem(int index)
    {       
        txt_Batiment.setText(getBatimentList(query).get(index).getBatiment());
        txt_nomServ.setText(getBatimentList(query).get(index).getNomServ());
        txt_numChambre.setText(Integer.toString(getBatimentList(query).get(index).getNoChambre()));
        txt_numLit.setText(Integer.toString(getBatimentList(query).get(index).getLit()));     
        txt_nomMalade.setText(getBatimentList(query).get(index).getNom());
        txt_prenomMalade.setText(getBatimentList(query).get(index).getPrenom());
        txt_mutMalade.setText(getBatimentList(query).get(index).getMutuelle()); 
        txt_numMalade.setText(Integer.toString(getBatimentList(query).get(index).getIdPatient()));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_numMalade = new javax.swing.JTextField();
        txt_prenomMalade = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable_Products = new javax.swing.JTable();
        txt_mutMalade = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Btn_Insert = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Btn_Update = new javax.swing.JButton();
        Btn_Previous = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();
        Btn_MN = new javax.swing.JButton();
        Btn_showAll = new javax.swing.JButton();
        txt_nbLitsCHG = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_nbLitsREA = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_numLit = new javax.swing.JTextField();
        txt_Batiment = new javax.swing.JTextField();
        txt_numChambre = new javax.swing.JTextField();
        txt_nomServ = new javax.swing.JTextField();
        txt_nomMalade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_numMalade.setBackground(new java.awt.Color(255, 255, 255));
        txt_numMalade.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_numMalade.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_prenomMalade.setBackground(new java.awt.Color(255, 255, 255));
        txt_prenomMalade.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_prenomMalade.setPreferredSize(new java.awt.Dimension(55, 50));

        JTable_Products.setBackground(new java.awt.Color(255, 255, 255));
        JTable_Products.setForeground(new java.awt.Color(0, 0, 0));
        JTable_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Batiment", "Nom Service", "Numero Chambre", "Numero lit", "N° Patient", "Nom Patient", "Prenom Patient", "Mutuelle Patient"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false
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

        txt_mutMalade.setBackground(new java.awt.Color(255, 255, 255));
        txt_mutMalade.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_mutMalade.setPreferredSize(new java.awt.Dimension(55, 50));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
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

        Btn_MN.setText("Mutuell \"MN..\"");
        Btn_MN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MNActionPerformed(evt);
            }
        });

        Btn_showAll.setText("Show all");
        Btn_showAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_showAllActionPerformed(evt);
            }
        });

        txt_nbLitsCHG.setBackground(new java.awt.Color(255, 255, 255));
        txt_nbLitsCHG.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_nbLitsCHG.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_nbLitsCHG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nbLitsCHGActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Moyenne du nb de lits, pour bat A:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("CHG");

        txt_nbLitsREA.setBackground(new java.awt.Color(255, 255, 255));
        txt_nbLitsREA.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_nbLitsREA.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_nbLitsREA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nbLitsREAActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("REA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Btn_showAll)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(Btn_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_Update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(Btn_Delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_Previous)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(188, 188, 188))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Btn_MN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nbLitsCHG, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(txt_nbLitsREA, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(306, 306, 306)
                                .addComponent(jLabel10)
                                .addGap(138, 138, 138)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Insert)
                            .addComponent(Btn_Update)
                            .addComponent(Btn_First)
                            .addComponent(Btn_Last))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Next)
                            .addComponent(Btn_Previous)
                            .addComponent(Btn_Delete)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Btn_showAll)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Btn_MN)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nbLitsCHG, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txt_nbLitsREA, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("N° Malade:");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nom Service:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("N° Chambre:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("N° Lit:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Nom Malade");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Mutuelle Malade:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Prenom Malade:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Batiment:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        txt_numLit.setBackground(new java.awt.Color(255, 255, 255));
        txt_numLit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_numLit.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_Batiment.setBackground(new java.awt.Color(255, 255, 255));
        txt_Batiment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Batiment.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_Batiment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BatimentActionPerformed(evt);
            }
        });

        txt_numChambre.setBackground(new java.awt.Color(255, 255, 255));
        txt_numChambre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_numChambre.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_nomServ.setBackground(new java.awt.Color(255, 255, 255));
        txt_nomServ.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_nomServ.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_nomMalade.setBackground(new java.awt.Color(255, 255, 255));
        txt_nomMalade.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_nomMalade.setPreferredSize(new java.awt.Dimension(55, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_numLit, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Batiment, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_prenomMalade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mutMalade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numMalade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_numChambre, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nomServ, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nomMalade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(txt_Batiment, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nomServ, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_numChambre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_numLit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txt_numMalade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nomMalade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txt_prenomMalade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_mutMalade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_ProductsMouseClicked
        int index = JTable_Products.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_JTable_ProductsMouseClicked

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed
/*
        //    if(checkInputs())
        //  {
            try{
                Connection con = getConnection();
                
                select s.batiment, h.no_chambre, h.lit, s.nom, m.numero, m.prenom, m.nom, m.mutuelle\n" +
                        "from   service s, hospitalisation h, malade m \n" +
                        "where   s.code = h.code_service\n" +
                        "and h.no_malade = m.numero;"
                        
                PreparedStatement ps = con.prepareStatement("INSERT INTO hospitalisation (numero, nom, prenom, adresse, tel) VALUES (?,?,?,?,?);");
                PreparedStatement ps1 =con.prepareStatement("INSERT INTO docteur (numero,specialite) VALUES (?,?);");

                int id = Integer.parseInt(txt_Batiment.getText());

                ps.setInt(1, Integer.parseInt(txt_Batiment.getText()));
                ps.setString(2, txt_numLit.getText());
                ps.setString(3, txt_numMalade.getText());
                ps.setString(4,txt_mutMalade.getText());
                ps.setString(5,txt_prenomMalade.getText());

                ps1.setInt(1, Integer.parseInt(txt_Batiment.getText()));

               

                ps.executeUpdate();
                ps1.executeUpdate();

                ShowBatimentSwing();
                JOptionPane.showMessageDialog(null, "Data inserted Successfully");

            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Can't Insert New Data");
            }

            //    }
        //      else
        //    {
            //    JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty");
            //  }
        System.out.println("ID =>"+txt_Batiment.getText());
        System.out.println("Name =>"+txt_numLit.getText());
        System.out.println("Lasname =>"+txt_numMalade.getText());
        System.out.println("Adresse =>"+txt_mutMalade.getText());

        System.out.println("Tel =>"+txt_prenomMalade.getText());

*/
    }//GEN-LAST:event_Btn_InsertActionPerformed

    private void Btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UpdateActionPerformed
   /*     String updateQuery = null;
        PreparedStatement ps = null;
        Connection con = getConnection();

        try
        {
            updateQuery = "update employe e\n" +
            "inner join docteur d on\n" +
            "e.numero = d.numero\n" +
            "set nom = ?, prenom = ?, adresse= ?, tel= ? WHERE d.numero = ?";

            ps = con.prepareStatement(updateQuery);

            ps.setString(1,txt_numLit.getText());
            ps.setString(2,txt_numMalade.getText());
            ps.setString(3,txt_mutMalade.getText());
            ps.setString(4,txt_prenomMalade.getText());

            ps.setInt(5, Integer.parseInt(txt_Batiment.getText()));

            ps.executeUpdate();
            ShowBatimentSwing();
            JOptionPane.showMessageDialog(null, "File updated");

        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "A Field Is Missing ");
        }
*/
    }//GEN-LAST:event_Btn_UpdateActionPerformed
 int pos=0;
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
            pos=getBatimentList(query).size()-1;
            System.out.println(pos);
        }
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
        pos = getBatimentList(query).size()-1;
        ShowItem(pos);
        System.out.println(pos);
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        pos = 0;
        ShowItem(pos);
        System.out.println(pos);
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_MNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MNActionPerformed
        query = "select s.batiment, h.no_chambre, h.lit, s.nom, m.numero, m.prenom, m.nom, m.mutuelle \n" +
                                "from   service s, hospitalisation h, malade m \n" +
                                "where  s.batiment = 'B' \n" +
                                "and  s.code = h.code_service\n" +
                                "and h.no_malade = m.numero \n" +
                                "and  m.mutuelle like 'MN%'";

        ShowBatimentSwing();
    }//GEN-LAST:event_Btn_MNActionPerformed

    private void txt_BatimentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BatimentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BatimentActionPerformed

    private void Btn_showAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_showAllActionPerformed
      query ="select s.batiment, h.no_chambre, h.lit, s.nom, m.numero, m.prenom, m.nom, m.mutuelle\n" +
                        "from   service s, hospitalisation h, malade m \n" +
                        "where   s.code = h.code_service\n" +
                        "and h.no_malade = m.numero;";
      
       ShowBatimentSwing();
    }//GEN-LAST:event_Btn_showAllActionPerformed

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed

        if(!txt_Batiment.getText().equals(""))
        {
            try
            {
                Connection con = getConnection();

                PreparedStatement ps = con.prepareStatement("DELETE FROM hospitalisation WHERE no_malade = ?");

                ps.setInt(1, Integer.parseInt(txt_numMalade.getText()));

                ps.executeUpdate();

                ShowBatimentSwing();
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

    private void txt_nbLitsCHGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nbLitsCHGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nbLitsCHGActionPerformed

    private void txt_nbLitsREAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nbLitsREAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nbLitsREAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Batiment_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Batiment_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Batiment_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Batiment_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Batiment_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_MN;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Previous;
    private javax.swing.JButton Btn_Update;
    private javax.swing.JButton Btn_showAll;
    private javax.swing.JTable JTable_Products;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_Batiment;
    private javax.swing.JTextField txt_mutMalade;
    private javax.swing.JTextField txt_nbLitsCHG;
    private javax.swing.JTextField txt_nbLitsREA;
    private javax.swing.JTextField txt_nomMalade;
    private javax.swing.JTextField txt_nomServ;
    private javax.swing.JTextField txt_numChambre;
    private javax.swing.JTextField txt_numLit;
    private javax.swing.JTextField txt_numMalade;
    private javax.swing.JTextField txt_prenomMalade;
    // End of variables declaration//GEN-END:variables
}
