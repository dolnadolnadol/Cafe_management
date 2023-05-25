/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author cld
 */
public class customer extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     * @throws SQLException
     */
    public customer(){
        setTitle("Customer : หมีภู คาเฟ่");
        try
        {
            setUIFont(new javax.swing.plaf.FontUIResource("Tahoma", Font.PLAIN,14));
        }
        catch(Exception e){}
        connect();
        initComponents();
        Fetch();
        setVisible(true);
    }

    PreparedStatement statement;
    ResultSet rs;
    ConnectDB con;
    public void connect(){
        con = new ConnectDB();
    }
    private void Fetch(){
        try{
            int q;
            con.connect();
            statement = con.getConnection().prepareStatement("Select * from customer");
            rs = statement.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel)showTable.getModel();
            TableColumnModel columnModel = showTable.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(50); // Id column width
            columnModel.getColumn(1).setPreferredWidth(150); // Name column width
            showTable.setRowHeight(30);
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int a=1; a<q; a++){
                    v2.add(rs.getString("C_id"));
                    v2.add(rs.getString("C_name"));

                }
                df.addRow(v2);
            }
        }catch (SQLException e){
            System.out.println("error");
        }
    }
    public static void setUIFont(javax.swing.plaf.FontUIResource f)
    {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while(keys.hasMoreElements())
        {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, f);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showTable = new javax.swing.JTable();
        newBtn = new javax.swing.JButton();
        modifyBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        B_id_field = new javax.swing.JTextField();
        B_name_field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 336, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("หมีภู คาเฟ่");

        showTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "Id", "Name"
                })
        {
            boolean[] canEdit = new boolean [] {
                    true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        showTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(showTable);

        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        modifyBtn.setText("Modify");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        backBtn.setText("back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("id");

        jLabel3.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(45, 45, 45)
                                                                .addComponent(newBtn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(modifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(74, 74, 74)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(9, 9, 9)
                                                                                .addComponent(jLabel2)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(B_id_field, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addGap(15, 15, 15)
                                                                                .addComponent(B_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(B_id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(B_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addGap(265, 265, 265)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(modifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(95, 95, 95))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>

    private void newBtnActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        String id = B_id_field.getText();
        String name = B_name_field.getText();
        try {
            con.connect();
            statement = con.getConnection().prepareStatement("Insert into customer(C_id,C_name) Values (?,?)");
            statement.setString(1, id);
            statement.setString(2, name);

            int i = statement.executeUpdate();
            if(i==1){
                JOptionPane.showMessageDialog(this, "Complete");
                B_id_field.setText("");
                B_name_field.setText("");
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "error");
            }
        } catch (SQLException e) {
            System.out.println("IN ERROR");
            e.printStackTrace();
        }

    }
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String id = B_id_field.getText();
        try {
            con.connect();
            statement = con.getConnection().prepareStatement("Delete from customer where C_id=?");
            statement.setString(1, id);

            int i = statement.executeUpdate();
            if(i==1){
                JOptionPane.showMessageDialog(this, "Complete");
                B_id_field.setText("");
                B_name_field.setText("");
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "error");
            }
        } catch (SQLException e) {
            System.out.println("IN ERROR");
            e.printStackTrace();
        }
    }
    private void showTableMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        DefaultTableModel tb = (DefaultTableModel) showTable.getModel();

        String tbId = tb.getValueAt(showTable.getSelectedRow(),0).toString();
        String tbName = tb.getValueAt(showTable.getSelectedRow(),1).toString();

        B_id_field.setText(tbId);
        B_name_field.setText(tbName);
    }
    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String id = B_id_field.getText();
        String name = B_name_field.getText();
        System.out.println(name);
        // statement = con.connect().prepareStatement("Insert into beverage(B_id,B_name,Price,B_qty) Values (?,?,?,?)");
        try {
            con.connect();
            statement = con.getConnection().prepareStatement("Update customer set C_id=?, C_name=? where B_id=?");
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, id);

            int i = statement.executeUpdate();

            if(i==1){
                JOptionPane.showMessageDialog(this, "Complete");
                Fetch();
            }else{
                JOptionPane.showMessageDialog(this, "error");
            }
        } catch (SQLException e) {
            System.out.println("IN ERROR");
            e.printStackTrace();
        }
    }
    private void backBtnBtnActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
    }
    /**
     * @param args the command line arguments
     */
//    private void start(){
    public static void main(String[] args) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//        new test().setVisible(true);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customer();
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField B_id_field;
    private javax.swing.JTextField B_name_field;
//    private javax.swing.JTextField B_qty_field;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JButton newBtn;
//    private javax.swing.JTextField price_field;
    private javax.swing.JTable showTable;
    // End of variables declaration
}
