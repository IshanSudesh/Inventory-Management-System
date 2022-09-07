/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.draculatheme.jetbrains.DraculaMeta;
import com.formdev.flatlaf.IntelliJTheme;
import controller.OrderController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import model.DBConnection;
import model.DBSearch;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Pavan Fernando
 */
public class OrderPlaning extends javax.swing.JFrame {

    /**
     * Creates new form OrderPlaning
     */
    
    private String nextOrderID ="";
    private String selectedProductName = "";
    private String produtData[][] = new String[100][3];
    private int count = 0;
    private String currentDate = "";
    
    public OrderPlaning() {
        initComponents();
        loadingOrderID();
        loadingCustomerID();
        loadingProductID();
        getCurrentDate();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectedProductTable = new javax.swing.JTable();
        orderID = new javax.swing.JLabel();
        customerIdCombo = new javax.swing.JComboBox<>();
        producIdCombo = new javax.swing.JComboBox<>();
        date = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        backBTN = new javax.swing.JButton();
        addBTN = new javax.swing.JButton();
        saveBTN = new javax.swing.JButton();
        productName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        custName = new javax.swing.JLabel();
        cancelBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setText("Order Placing");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Order ID        :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Customer ID :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Date              :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Product ID    :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Quantity       :");

        selectedProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(selectedProductTable);

        orderID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        orderID.setText(".");

        customerIdCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customerIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerIdComboActionPerformed(evt);
            }
        });

        producIdCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        producIdCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                producIdComboActionPerformed(evt);
            }
        });

        date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        date.setText(".");

        qty.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        backBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backBTN.setText("Back");
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });

        addBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBTN.setText("Add");
        addBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTNActionPerformed(evt);
            }
        });

        saveBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveBTN.setText("Save");
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        productName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productName.setText(".");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Product Name   :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Customer Name :");

        custName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        custName.setText(".");

        cancelBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBTN.setText("Cancel");
        cancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(customerIdCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 127, Short.MAX_VALUE)
                            .addComponent(producIdCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(custName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addBTN))
                            .addComponent(orderID, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(132, 132, 132))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(backBTN)
                .addGap(79, 79, 79)
                .addComponent(cancelBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBTN)
                .addGap(213, 213, 213))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(orderID))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(customerIdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(custName))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(producIdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productName)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(date))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBTN))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBTN)
                    .addComponent(saveBTN)
                    .addComponent(cancelBTN))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void producIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_producIdComboActionPerformed
       try {
            ResultSet result = new DBSearch().searchSelectedProductID(this.producIdCombo.getSelectedItem());
            while(result.next()){
                selectedProductName = result.getString(2);
                this.productName.setText(selectedProductName);
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_producIdComboActionPerformed

    private void addBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBTNActionPerformed
        if(this.qty.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter the Quantity");
        }
        else{
            String Data[] = {this.producIdCombo.getSelectedItem().toString(), selectedProductName, this.qty.getText()};
            produtData[count][0] = this.producIdCombo.getSelectedItem().toString();
            produtData[count][1] = selectedProductName;
            produtData[count][2] = this.qty.getText();
            DefaultTableModel tableModel = (DefaultTableModel)this.selectedProductTable.getModel();
            tableModel.addRow(Data);
            count++;
            clearFields();    
        }
    }//GEN-LAST:event_addBTNActionPerformed

    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
       this.toBack();
        setVisible(false);
        new SalesManagement().toFront();
        new SalesManagement().setState(java.awt.Frame.NORMAL);
    }//GEN-LAST:event_backBTNActionPerformed

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed
     
        try {
            boolean  isSuccess = OrderController.insertOrderDetails(currentDate, this.customerIdCombo.getSelectedItem().toString());
            boolean isSu = false;
            for(int a=0; a<count; a++){
                for(int b=0; b<1; b++){
                  isSu = OrderController.insertOrder_productDetails(nextOrderID, produtData[a][b], produtData[a][b+2]);
                }  
            }
            if(isSuccess && isSu == true){
                JOptionPane.showMessageDialog(null, "Order is Placed!!!", "Sucessfull", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
                loadingOrderID();

            }else{
                JOptionPane.showMessageDialog(null, "Order is Failed to  Placed!!!!", "Failed", JOptionPane.INFORMATION_MESSAGE);
            }
            DefaultTableModel tableModel = (DefaultTableModel)this.selectedProductTable.getModel();
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }
            count = 0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_saveBTNActionPerformed

    private void customerIdComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerIdComboActionPerformed
        try {
            ResultSet result = new DBSearch().searchSelectedCustomerID(this.customerIdCombo.getSelectedItem());
            while(result.next()){
                this.custName.setText(result.getString(2));
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_customerIdComboActionPerformed

    private void cancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBTNActionPerformed
       
        if (JOptionPane.showConfirmDialog( new JFrame("Exit"),"Confirm if you Want to Exit","Inventory Management System",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_cancelBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private void loadingOrderID(){
        try {
            ResultSet result = new DBSearch().getOrderID();
            int a = 0;
            while(result.next()){
//                nextOrderID = result.getString(1) + 1;
                a = result.getInt(1) + 1;
                nextOrderID = String.valueOf(a);
                this.orderID.setText(nextOrderID);
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private void loadingCustomerID(){
        try {
            ResultSet result = new DBSearch().getCustomerDetails();
            while(result.next()){
                String nextOrderID = result.getString(1);
                this.customerIdCombo.addItem(nextOrderID);
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private void loadingProductID() {
         try {
            ResultSet result = new DBSearch().getProductDetails();
            while(result.next()){
                String nextOrderID = result.getString(1);
                this.producIdCombo.addItem(nextOrderID);
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private void getCurrentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        currentDate = dateFormat.format(date);
        this.date.setText(currentDate);
    }
    
    private void clearFields(){
        this.qty.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(OrderPlaning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderPlaning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderPlaning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderPlaning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
            IntelliJTheme.setup(DraculaMeta.class.getResourceAsStream("/themes/Dracula.theme.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderPlaning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBTN;
    private javax.swing.JButton backBTN;
    private javax.swing.JButton cancelBTN;
    private javax.swing.JLabel custName;
    private javax.swing.JComboBox<String> customerIdCombo;
    private javax.swing.JLabel date;
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
    private javax.swing.JLabel orderID;
    private javax.swing.JComboBox<String> producIdCombo;
    private javax.swing.JLabel productName;
    private javax.swing.JTextField qty;
    private javax.swing.JButton saveBTN;
    private javax.swing.JTable selectedProductTable;
    // End of variables declaration//GEN-END:variables
}
