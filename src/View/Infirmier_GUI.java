/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Infirmier;
import Model.Malade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class Infirmier_GUI extends javax.swing.JFrame {
            
            private String query = "";
            
            private String DB ="hopital";
            private String serverAddress="jdbc:mysql://localhost/";
    /**
     * Creates new form Infirmier_GUI
     */
    public Infirmier_GUI() {
        initComponents();
        getConnection(); 

         txt_REA.setText(getSalaireMoyenREA("SELECT AVG(salaire) FROM infirmier WHERE code_service  ='REA'"));
         txt_CAR.setText(getSalaireMoyenREA("SELECT AVG(salaire) FROM infirmier WHERE code_service  ='CAR'"));
         txt_CHG.setText(getSalaireMoyenREA("SELECT AVG(salaire) FROM infirmier WHERE code_service  ='CHG'"));
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
        return !(txt_Name.getText() == null || txt_Lastname.getText() == null ); 
     }
    
    
     
     
     
     
     
     
     public ArrayList <Infirmier> getInfirmierList(String query)
    {        
        ArrayList<Infirmier> infirmierList = null;
                
        infirmierList = new ArrayList<Infirmier>();
        Connection con = getConnection();
  
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            Infirmier infirmier;
            
            while(rs.next())
            {
               
                infirmier = new Infirmier(rs.getInt("e.numero"), rs.getString("e.nom"),rs.getString("e.prenom"),rs.getString("e.tel"),rs.getString("e.adresse"),rs.getString("i.code_service"),rs.getString("i.rotation"), rs.getFloat("i.salaire"));
                infirmierList.add(infirmier);           
            }           
        }   
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display the requested view, error x93");
        } 
            return infirmierList;
     }
     
     
     
      public String getSalaireMoyenREA(String query)
    {        
        Connection con = getConnection();
        String sal=null;
        Statement st;
        ResultSet rs;
    
        try 
        { 
            st= con.createStatement();
            rs = st.executeQuery(query);
            System.out.println("avg sal is ");
            
             
            while (rs.next()) {
                     sal  = rs.getString("AVG(salaire)");
                    System.out.println(sal);

                    }
            }           
           
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Can't display salaire");
        } 
            return sal;
     }
     
    
     
     
     
     
     
     
   
        public void ShowItem(int index)
    {       
        txt_Id.setText(Integer.toString(getInfirmierList(query).get(index).getId()));
        txt_Name.setText(getInfirmierList(query).get(index).getName());
        txt_Lastname.setText(getInfirmierList(query).get(index).getLastname());
        txt_Service.setText(getInfirmierList(query).get(index).getCodeService());
        txt_Rotation.setText(getInfirmierList(query).get(index).getRotation());
        txt_Adresse.setText(getInfirmierList(query).get(index).getAdresse());        
        txt_Tel.setText(getInfirmierList(query).get(index).getTel());
        txt_Salaire.setText(Float.toString(getInfirmierList(query).get(index).getSalaire()));
        
          
    }
   
    
    
        
        
        
        
     public void ShowInfirmierSwing()
     {        
        ArrayList<Infirmier> list = getInfirmierList(query);
        DefaultTableModel model = (DefaultTableModel) JTable_Products.getModel();
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged(); 
        
        Object[] row = new Object[8];
        
        for(int i=0; i<list.size(); i++)
        {
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getLastname();
            row[3]=list.get(i).getCodeService();
            row[4]=list.get(i).getRotation();
            row[5]=list.get(i).getTel();
            row[6]=list.get(i).getAdresse();
            row[7]=list.get(i).getSalaire();
         
            model.addRow(row);       
        }
        
        
        
        
         
     }
     
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Btn_9 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable_Products = new javax.swing.JTable();
        txt_Rotation = new javax.swing.JTextField();
        txt_Salaire = new javax.swing.JTextField();
        txt_Service = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_Name = new javax.swing.JTextField();
        txt_Id = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Btn_Insert = new javax.swing.JButton();
        Btn_Delete = new javax.swing.JButton();
        Btn_Update = new javax.swing.JButton();
        Btn_Previous = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();
        Btn_ShowAll = new javax.swing.JButton();
        txt_CHG = new javax.swing.JTextField();
        txt_CAR = new javax.swing.JTextField();
        txt_REA = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_Lastname = new javax.swing.JTextField();
        txt_Tel = new javax.swing.JTextField();
        txt_Adresse = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        Btn_9.setText("Rotation Nuit");
        Btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_9)
                .addGap(269, 269, 269))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 111, Short.MAX_VALUE)
                .addComponent(Btn_9))
        );

        JTable_Products.setBackground(new java.awt.Color(255, 255, 255));
        JTable_Products.setForeground(new java.awt.Color(0, 0, 0));
        JTable_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No_Infirmier", "Nom", "Prenom", "Code_Service", "Rotation", "Tel", "adresse", "Salaire"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        txt_Rotation.setBackground(new java.awt.Color(255, 255, 255));
        txt_Rotation.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Rotation.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_Salaire.setBackground(new java.awt.Color(255, 255, 255));
        txt_Salaire.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Salaire.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_Service.setBackground(new java.awt.Color(255, 255, 255));
        txt_Service.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Service.setPreferredSize(new java.awt.Dimension(55, 50));

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("No Infirmier");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nom:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Prenom:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Salaire:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Rotation:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Code_Service:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Adresse");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Tel:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        txt_Name.setBackground(new java.awt.Color(255, 255, 255));
        txt_Name.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Name.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_Id.setBackground(new java.awt.Color(255, 255, 255));
        txt_Id.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Id.setPreferredSize(new java.awt.Dimension(55, 50));
        txt_Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IdActionPerformed(evt);
            }
        });

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

        txt_CHG.setBackground(new java.awt.Color(255, 255, 255));
        txt_CHG.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_CHG.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_CAR.setBackground(new java.awt.Color(255, 255, 255));
        txt_CAR.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_CAR.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_REA.setBackground(new java.awt.Color(255, 255, 255));
        txt_REA.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_REA.setPreferredSize(new java.awt.Dimension(55, 50));

        jLabel9.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Salaire moyen REA:");

        jLabel10.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Salaire moyen CAR :");

        jLabel11.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Salaire moyen CHG:");

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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_CAR, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_CHG, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_REA, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_CAR, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_CHG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_REA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        txt_Lastname.setBackground(new java.awt.Color(255, 255, 255));
        txt_Lastname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Lastname.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_Tel.setBackground(new java.awt.Color(255, 255, 255));
        txt_Tel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Tel.setPreferredSize(new java.awt.Dimension(55, 50));

        txt_Adresse.setBackground(new java.awt.Color(255, 255, 255));
        txt_Adresse.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_Adresse.setPreferredSize(new java.awt.Dimension(55, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Rotation, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Service, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Salaire, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Tel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGap(29, 29, 29)
                        .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Service, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Rotation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Tel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txt_Adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_Salaire, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_ProductsMouseClicked
        int index = JTable_Products.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_JTable_ProductsMouseClicked

    private void txt_IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IdActionPerformed

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed

        if(checkInputs())
        {
            try{
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO employe (numero, nom, prenom, adresse, tel) VALUES (?,?,?,?,?);");
                PreparedStatement ps1 = con.prepareStatement("INSERT INTO infirmier (numero, code_service, rotation, salaire) VALUES (?,?,?,?);");      
                
           

                ps.setInt(1, Integer.parseInt(txt_Id.getText()));
                ps.setString(2, txt_Name.getText());
                ps.setString(3, txt_Lastname.getText());
                ps.setString(4, txt_Adresse.getText());
                ps.setString(5, txt_Tel.getText());
               
                ps1.setInt(1, Integer.parseInt(txt_Id.getText()));
                ps1.setString(2, txt_Service.getText());
                ps1.setString(3, txt_Rotation.getText());
                ps1.setString(4, txt_Salaire.getText());
               

                ps.executeUpdate();
                ps1.executeUpdate();
                System.out.println(query);
                ShowInfirmierSwing();
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

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed

        if(!txt_Id.getText().equals(""))
        {
            try
            {
                Connection con = getConnection();

                PreparedStatement ps = con.prepareStatement("DELETE FROM employe where numero = ?");

                int id = Integer.parseInt(txt_Id.getText());

                ps.setInt(1, id);
                ps.executeUpdate();

                ShowInfirmierSwing();

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

        if(checkInputs() && txt_Id.getText() != null)
        {
            try
            {

                updateQuery = "UPDATE infirmier SET nom = ?, prenom = ?, mutuelle= ?,adresse= ? ,tel= ? WHERE numero = ?";

                ps = con.prepareStatement(updateQuery);

                ps.setString(1,txt_Name.getText());
                ps.setString(2,txt_Lastname.getText());
                ps.setString(3,txt_Service.getText());
                ps.setString(4,txt_Salaire.getText());
                ps.setString(5,txt_Rotation.getText());

                ps.setInt(6, Integer.parseInt(txt_Id.getText()));

                ps.executeUpdate();
               
                ShowInfirmierSwing();
                JOptionPane.showMessageDialog(null, "File updated");

            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, "A Field Is Missing ");
            }

            //    }

        }
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
            pos=getInfirmierList(query).size()-1;
            System.out.println(pos);
        }
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
        pos = getInfirmierList(query).size()-1;
        ShowItem(pos);
        System.out.println(pos);
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        pos = 0;
       ShowItem(pos);
        System.out.println(pos);
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_9ActionPerformed
        query = "SELECT e.numero, e.nom, e.prenom, e.adresse, e.tel, i.code_service, i.rotation, i.salaire"
                + " FROM employe e\n" +
                "\n" +
                "join infirmier i\n" +
                "on i.numero = e.numero\n" +
                "\n" +
                "WHERE rotation = 'nuit'";

        ShowInfirmierSwing();
    }//GEN-LAST:event_Btn_9ActionPerformed

    private void Btn_ShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ShowAllActionPerformed
        query = "SELECT DISTINCT e.numero, e.nom, e.prenom, e.adresse, e.tel, i.code_service, i.rotation, i.salaire \n" +
        "FROM employe e\n" +
        "JOIN infirmier i\n" +
        "ON e.numero = i.numero";
	




        ShowInfirmierSwing();
    }//GEN-LAST:event_Btn_ShowAllActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_9;
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
    private javax.swing.JTextField txt_Adresse;
    private javax.swing.JTextField txt_CAR;
    private javax.swing.JTextField txt_CHG;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_Lastname;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JTextField txt_REA;
    private javax.swing.JTextField txt_Rotation;
    private javax.swing.JTextField txt_Salaire;
    private javax.swing.JTextField txt_Service;
    private javax.swing.JTextField txt_Tel;
    // End of variables declaration//GEN-END:variables
}
