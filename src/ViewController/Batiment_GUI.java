/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.Batiment;  //import de la classe Batiment
import static Model.Batiment.*; //import des methodes static de La classe batiment dans le package model


import Model.DBConnection;      //import de la classe DBConenction pour la connexion


import java.sql.Connection;     //import de la classe SQL.Connectionpour la connexion msql

import java.sql.PreparedStatement;      //package pour les requetes sql

import java.util.ArrayList;     //package arraylist

import javax.swing.table.DefaultTableModel;     //package swing

/**
 *
 * @author idris
 */


public class Batiment_GUI extends javax.swing.JFrame {      // hérite de JFRAME

        // Default sql statement to be used for display
        private String query = "select    s.batiment, h.no_chambre, h.lit, s.nom, m.numero, m.prenom, m.nom, m.mutuelle\n" +
                                "from   service s, hospitalisation h, malade m \n" +
                                "where   s.code = h.code_service\n" +
                                "and h.no_malade = m.numero;";

     
      private   ArrayList<Batiment> list = new ArrayList<Batiment>();   //declaration of ArrayList for filling the data that needs to be displayed
      private PreparedStatement ps;         //declaration of the prepared statement
      
    //1 - default constructor of the class, works as a controller, initiliazes the components of the swing interface
    //starts the DB connection
   //displays the number of beds on each service on start
    public Batiment_GUI() 
    {
       initComponents();        //initialisation of the view components of the WYSIWYG
       txt_nbLitsCHG.setText(getNbLits("SELECT AVG(c.nb_lits) FROM chambre c, service s WHERE s.batiment LIKE '%A%' AND s.code = c.code_service And s.code='CHG'")); //displaying on the swing interface 
       txt_nbLitsREA.setText(getNbLits("SELECT AVG(c.nb_lits) FROM chambre c, service s WHERE s.batiment LIKE '%A%' AND s.code = c.code_service And s.code='REA'")); //displaying on the swing interface 
       }

    
     //start of the controller part:
    //  Display of DATA on the Swing GUI 
    public void ShowBatimentSwing()
     {        
        list = getBatimentList(query);      //uses the getBatimentList with the query passed as a paramater, query modified on the events
        DefaultTableModel model = (DefaultTableModel) JTable_Bats.getModel();   //init model that fills Jtable_bats
    
         //the following two lines of code refreshes the JTable by deleting all rows
        //then, replaced by new rows after insert/delete/update  
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();    
        
        Object[] row = new Object[8];       //Fills the Jtable with the columns, until List.size()-1
        
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
    
    
    
    //Displays selected Jtable data on the swing text areas accordingly
    public void ShowItem(int index)
    {       
      txt_Batiment.setText(list.get(index).getBatiment());
       txt_nomServ.setText(list.get(index).getNomServ());
       txt_numChambre.setText(Integer.toString(list.get(index).getNoChambre()));
      txt_numLit.setText(Integer.toString(list.get(index).getLit()));     
      txt_nomMalade.setText(list.get(index).getNom());
      txt_prenomMalade.setText(list.get(index).getPrenom());
      txt_mutMalade.setText(list.get(index).getMutuelle()); 
       txt_numMalade.setText(Integer.toString(list.get(index).getIdPatient()));
    }
    
    
    
 int pos=0;
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
        JTable_Bats = new javax.swing.JTable();
        txt_mutMalade = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Btn_listChambreOcc = new javax.swing.JButton();
        Btn_listChambreVides = new javax.swing.JButton();
        Btn_LitsOccup = new javax.swing.JButton();
        Btn_menu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
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
        setBackground(new java.awt.Color(255, 255, 255));

        txt_numMalade.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_numMalade.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_prenomMalade.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_prenomMalade.setPreferredSize(new java.awt.Dimension(55, 50));

        JTable_Bats.setModel(new javax.swing.table.DefaultTableModel(
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
        JTable_Bats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_BatsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTable_Bats);

        txt_mutMalade.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_mutMalade.setPreferredSize(new java.awt.Dimension(55, 50));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        Btn_listChambreOcc.setText("Liste des chambres occupées par au moin un patient");
        Btn_listChambreOcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_listChambreOccActionPerformed(evt);
            }
        });

        Btn_listChambreVides.setText("Liste des chambres vides");
        Btn_listChambreVides.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_listChambreVidesActionPerformed(evt);
            }
        });

        Btn_LitsOccup.setText("Lits occupés");
        Btn_LitsOccup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LitsOccupActionPerformed(evt);
            }
        });

        Btn_menu.setText("Menu");
        Btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Btn_menu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Btn_listChambreVides)
                        .addGap(26, 26, 26)
                        .addComponent(Btn_LitsOccup, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Btn_listChambreOcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_menu)
                    .addComponent(Btn_listChambreOcc))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_listChambreVides)
                    .addComponent(Btn_LitsOccup))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

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

        txt_nbLitsCHG.setEditable(false);
        txt_nbLitsCHG.setBackground(new java.awt.Color(0, 204, 255));
        txt_nbLitsCHG.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_nbLitsCHG.setBorder(null);
        txt_nbLitsCHG.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_nbLitsCHG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nbLitsCHGActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Moyenne du nb de lits, pour bat A:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setText("CHG");

        txt_nbLitsREA.setEditable(false);
        txt_nbLitsREA.setBackground(new java.awt.Color(0, 204, 255));
        txt_nbLitsREA.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_nbLitsREA.setBorder(null);
        txt_nbLitsREA.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_nbLitsREA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nbLitsREAActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Btn_First, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(308, 308, 308)
                                .addComponent(Btn_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Btn_Previous)
                                .addGap(49, 49, 49)
                                .addComponent(Btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(245, 245, 245))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Btn_MN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel9)
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txt_nbLitsCHG, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nbLitsREA, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addContainerGap(477, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_First)
                            .addComponent(Btn_Last))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Next)
                            .addComponent(Btn_Previous)))
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
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
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

        txt_numLit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_numLit.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_Batiment.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Batiment.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_Batiment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BatimentActionPerformed(evt);
            }
        });

        txt_numChambre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_numChambre.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_nomServ.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_nomServ.setPreferredSize(new java.awt.Dimension(55, 50));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    
    
    //Listener events
    
    private void JTable_BatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_BatsMouseClicked
        int index = JTable_Bats.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_JTable_BatsMouseClicked

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

    private void txt_nbLitsCHGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nbLitsCHGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nbLitsCHGActionPerformed

    private void txt_nbLitsREAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nbLitsREAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nbLitsREAActionPerformed

    private void Btn_listChambreOccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_listChambreOccActionPerformed

        requete12_GUI rs= new requete12_GUI();
        rs.setVisible(true);
    }//GEN-LAST:event_Btn_listChambreOccActionPerformed

    private void Btn_listChambreVidesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_listChambreVidesActionPerformed
        requete13_18_GUI rs= new requete13_18_GUI();
        rs.setVisible(true);
    }//GEN-LAST:event_Btn_listChambreVidesActionPerformed

    private void Btn_LitsOccupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LitsOccupActionPerformed
        requete14_GUI rs= new requete14_GUI();
        rs.setVisible(true);
    }//GEN-LAST:event_Btn_LitsOccupActionPerformed

    private void Btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_menuActionPerformed
        this.hide();            //cache le Jframe actuelle
        new home().setVisible(true);           //crée une nouvelle instance du jframe Home
    }//GEN-LAST:event_Btn_menuActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_LitsOccup;
    private javax.swing.JButton Btn_MN;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Previous;
    private javax.swing.JButton Btn_listChambreOcc;
    private javax.swing.JButton Btn_listChambreVides;
    private javax.swing.JButton Btn_menu;
    private javax.swing.JButton Btn_showAll;
    private javax.swing.JTable JTable_Bats;
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
