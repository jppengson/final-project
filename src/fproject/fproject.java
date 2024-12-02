/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fproject;


import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class fproject extends javax.swing.JFrame {


    public fproject() {
        initComponents();
        Connect();
        LoadProductNo();
        Fetch();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud","root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(fproject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(fproject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadProductNo(){
        
        try {
            pst = con.prepareStatement("SELECT id FROM product_tbl");
            rs = pst.executeQuery();
            txtpid.removeAllItems();
            while(rs.next()){
            txtpid.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(fproject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM product_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)table1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("pname"));
                    v2.add(rs.getString("price"));
                    v2.add(rs.getString("qty"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(fproject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        txtPname = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        txtpid = new javax.swing.JComboBox<>();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        btnsearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 102, 51));
        label1.setText("PRODUCT  NAME:");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 84, -1, -1));

        label2.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        label2.setForeground(new java.awt.Color(0, 102, 51));
        label2.setText("PRODUCT   PRICE:");
        getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 124, -1, -1));

        label3.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(0, 102, 51));
        label3.setText("PRODUCT    QTY:");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 164, -1, -1));

        txtPname.setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().add(txtPname, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 80, 200, -1));

        txtPrice.setBackground(new java.awt.Color(204, 255, 204));
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 120, 200, -1));

        txtQty.setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().add(txtQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 160, 200, -1));

        label4.setFont(new java.awt.Font("Viner Hand ITC", 1, 12)); // NOI18N
        label4.setForeground(new java.awt.Color(0, 102, 51));
        label4.setText("PRODUCT   ID:");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 231, -1, -1));

        txtpid.setBackground(new java.awt.Color(204, 255, 204));
        txtpid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtpid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpidActionPerformed(evt);
            }
        });
        getContentPane().add(txtpid, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 227, 200, -1));

        btnadd.setBackground(new java.awt.Color(0, 102, 51));
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        getContentPane().add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 100, -1));

        btnupdate.setBackground(new java.awt.Color(0, 102, 51));
        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 100, -1));

        btndelete.setBackground(new java.awt.Color(0, 102, 51));
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 100, -1));

        table1.setBackground(new java.awt.Color(204, 255, 204));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product ID", "Product NAME", "Price", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 115, 460, 280));

        btnsearch.setBackground(new java.awt.Color(0, 102, 51));
        btnsearch.setText("SEARCH");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 100, -1));

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("HEALING GALING LISTER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 11, 589, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grrp5/rrrr.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        try {
            String pname = txtPname.getText();
            String price = txtPrice.getText();
            String qty = txtQty.getText();
            
            pst = con.prepareStatement("INSERT INTO product_tbl (pname,price,qty)VALUES(?,?,?)");
            pst.setString(1,pname);
            pst.setString(2,price);
            pst.setString(3,qty);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record Added!! succesfully");
                txtPname.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                Fetch();
                LoadProductNo();
            }else{
                JOptionPane.showMessageDialog(this,"Record failed to saved!!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(fproject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        
        try {
            String pid = txtpid.getSelectedItem().toString();
            
            pst = con.prepareStatement("SELECT * FROM product_tbl WHERE id=?");
            pst.setString(1,pid);
            rs=pst.executeQuery();
            
            if(rs.next()==true){
                    txtPname.setText(rs.getString(2));
                    txtPrice.setText(rs.getString(3));
                    txtQty.setText(rs.getString(4));
                    
            }else {
                JOptionPane.showMessageDialog(this,"No record found!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(fproject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void txtpidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpidActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        
        try {
            String pname = txtPname.getText();
            String price = txtPrice.getText();
            String qty = txtQty.getText();
            String pid = txtpid.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE product_tbl SET pname=?,price=?,qty=? WHERE id=?");
            
            pst.setString(1, pname);
            pst.setString(2, price);
            pst.setString(3, qty);
            pst.setString(4, pid);
            
            int k=pst.executeUpdate();
            if (k==1){
                JOptionPane.showMessageDialog(this,"Record has been succesfully update!!");
                txtPname.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                txtPname.requestFocus();
                Fetch();
                LoadProductNo();
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(fproject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        
        try {
            String pid = txtpid.getSelectedItem().toString();
            pst=con.prepareStatement("DELETE FROM product_tbl WHERE id=?");
            pst.setString(1, pid);
            
            int k = pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record has been succesfully Deleted!!!");
                txtPname.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                txtPname.requestFocus();
                Fetch();
                LoadProductNo();
            }else{
                JOptionPane.showMessageDialog(this,"Record failed to Delete!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(fproject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btndeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Grrrp5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grrrp5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grrrp5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grrrp5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fproject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txtPname;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JComboBox<String> txtpid;
    // End of variables declaration//GEN-END:variables
}
