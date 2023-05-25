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
public class Order extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     * @throws SQLException
     */
    public Order(){
        setTitle("Order : หมีภู คาเฟ่");
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
            statement = con.getConnection().prepareStatement("Select * from cafe.order");
            rs = statement.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel)showTable.getModel();
            TableColumnModel columnModel = showTable.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(50); // Id column width
            columnModel.getColumn(1).setPreferredWidth(150); // Name column width
            columnModel.getColumn(2).setPreferredWidth(80); // Price column width
            columnModel.getColumn(3).setPreferredWidth(80);
            showTable.setRowHeight(30);
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int a=1; a<q; a++){
                    v2.add(rs.getString("Order_id"));
                    v2.add(rs.getString("B_id"));
                    v2.add(rs.getString("Total"));
                    v2.add(rs.getString("Order_qty"));
                    v2.add(rs.getString("C_id"));
                    v2.add(rs.getString("R_id"));
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
        R_id_field = new javax.swing.JTextField();
        R_date_field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

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
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "Id", "Beverage id", "Total", "Quantity", "Customer id", "Receipt id"
                })
        {
            boolean[] canEdit = new boolean [] {
                    false, true, true, true, true, true
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

        jLabel3.setText("Beverage id");

        jLabel4.setText("Total");

        jLabel5.setText("Quantity");

        jLabel6.setText("Customer id");

        jLabel7.setText("Receipt id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(139, 139, 139)
                                                .addComponent(jLabel8))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
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
                                                                .addGap(67, 67, 67)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel7))
                                                                .addGap(25, 25, 25)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(78, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(R_date_field, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(R_id_field, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                                                .addComponent(jTextField3)
                                                                .addComponent(jTextField2)))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel8))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(R_id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(R_date_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(132, 132, 132)
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
        String id = R_id_field.getText();
        String B_id = R_date_field.getText();
        String Total = jTextField1.getText();
        String quantity = jTextField2.getText();
        String customer_id = jTextField3.getText();
        String receipt = jTextField4.getText();
        try {
            con.connect();
            statement = con.getConnection().prepareStatement("Insert into cafe.Order(Order_id,B_id,Total,Order_qty,C_id,R_id) Values (?,?,?,?,?,?)");
            statement.setString(1, id);
            statement.setString(2, B_id);
            statement.setString(3, Total);
            statement.setString(4, quantity);
            statement.setString(5, customer_id);
            statement.setString(6, receipt);

            int i = statement.executeUpdate();
            if(i==1){
                JOptionPane.showMessageDialog(this, "Complete");
                R_id_field.setText("");
                R_date_field.setText("");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
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
        String id = R_id_field.getText();
        try {
            con.connect();
            statement = con.getConnection().prepareStatement("Delete from cafe.Order where Order_id=?");
            statement.setString(1, id);

            int i = statement.executeUpdate();
            if(i==1){
                JOptionPane.showMessageDialog(this, "Complete");
                R_id_field.setText("");
                R_date_field.setText("");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
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
        String tbPrice = tb.getValueAt(showTable.getSelectedRow(),2).toString();
        String tbqty = tb.getValueAt(showTable.getSelectedRow(),3).toString();
        String tbqty1 = tb.getValueAt(showTable.getSelectedRow(),4).toString();
        String tbqty2 = tb.getValueAt(showTable.getSelectedRow(),5).toString();

        R_id_field.setText(tbId);
        R_date_field.setText(tbName);
        jTextField1.setText(tbPrice);
        jTextField2.setText(tbqty);
        jTextField3.setText(tbqty1);
        jTextField4.setText(tbqty2);
    }
    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String id = R_id_field.getText();
        String B_id = R_date_field.getText();
        String Total = jTextField1.getText();
        String quantity = jTextField2.getText();
        String customer_id = jTextField3.getText();
        String receipt = jTextField4.getText();
        try {
            con.connect();
            statement = con.getConnection().prepareStatement("Update cafe.Order set Order_id=?, B_id=?, Total =?, Order_qty=?, C_id=?, R_id=? where Order_id=?");
            statement.setString(1, id);
            statement.setString(2, B_id);
            statement.setString(3, Total);
            statement.setString(4, quantity);
            statement.setString(5, customer_id);
            statement.setString(6, receipt);
            statement.setString(7, id);

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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order();
            }
        });
    }

    private javax.swing.JTextField R_date_field;
    private javax.swing.JTextField R_id_field;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JButton newBtn;
    private javax.swing.JTable showTable;
    // End of variables declaration
}
