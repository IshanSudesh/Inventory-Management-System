/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.draculatheme.jetbrains.DraculaMeta;
import com.formdev.flatlaf.IntelliJTheme;
import controller.WarehouseController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DBConnection;
import model.DBSearch;

/**
 *
 * @author Pavan Fernando
 */
public class Issuing_Raw_materials extends javax.swing.JFrame {

    /**
     * Creates new form Issuing_Raw_materials
     */
    private String material[][] = new String[100][3];
    private int count = 0;
    private boolean available = true;
    private double availableStock[] = new double[10];
    private boolean issued = true;
    private boolean availablityBTN_Checker = false;
    private String order_id = "";
    
    public Issuing_Raw_materials() {
        initComponents();
        loadingOrderIDs();
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
        orderIdCMB = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailsTable = new javax.swing.JTable();
        issue = new javax.swing.JButton();
        availabilityBTN = new javax.swing.JButton();
        backBTN = new javax.swing.JButton();
        cancelBTN2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setText("Issuing Row Materials");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Order ID");

        orderIdCMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderIdCMBActionPerformed(evt);
            }
        });

        detailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Material ID", "Name", "Quntity"
            }
        ));
        jScrollPane1.setViewportView(detailsTable);

        issue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        issue.setText("Issue");
        issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueActionPerformed(evt);
            }
        });

        availabilityBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        availabilityBTN.setText("Check Availability");
        availabilityBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availabilityBTNActionPerformed(evt);
            }
        });

        backBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backBTN.setText("Back");
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });

        cancelBTN2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBTN2.setText("Cancel");
        cancelBTN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBTN2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(orderIdCMB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backBTN)
                        .addGap(37, 37, 37)
                        .addComponent(cancelBTN2)
                        .addGap(37, 37, 37)
                        .addComponent(issue))
                    .addComponent(availabilityBTN, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(orderIdCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(availabilityBTN)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issue)
                    .addComponent(cancelBTN2)
                    .addComponent(backBTN))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderIdCMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderIdCMBActionPerformed
        count = 0;
        try {
            order_id = this.orderIdCMB.getSelectedItem().toString();
            ResultSet result = new DBSearch().get_Material_id_And_Material_Name(order_id);
            DefaultTableModel tableModel = (DefaultTableModel)this.detailsTable.getModel();
            
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }
            
            while(result.next()){
                String data[] = {result.getString(1), result.getString(3), result.getString(2)};
                material[count][0] = result.getString(1);
                material[count][1] = result.getString(2);
                material[count][2] = result.getString(4);
                tableModel.addRow(data);
                count++;
                
            }
            System.out.println("count" + count);
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_orderIdCMBActionPerformed

    private void availabilityBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availabilityBTNActionPerformed
        try {
            
            for(int a=0; a<count; a++){
                ResultSet result = new DBSearch().check_Availability_Material_Stock(material[a][0]);
                
                while(result.next()){
                    String mName = result.getString(2);
                    if(material[a][2].equals("false")){
                        if(Double.parseDouble(material[a][1]) <= Double.parseDouble(result.getString(3))){
                            JOptionPane.showMessageDialog(null, "Material (" + mName + ") is available", "Sucessfull", JOptionPane.INFORMATION_MESSAGE);
                            availableStock[a] = Double.parseDouble(result.getString(3)) - Double.parseDouble(material[a][1]);
//                            available = true;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Material (" + mName + ") is not available", "Error", JOptionPane.INFORMATION_MESSAGE);
                            available = false;
                        }
                        issued = false;
                    }
                    else{
                        issued = true;
                        break;
                    }
                }
            }
//            if(available == true){
//                JOptionPane.showMessageDialog(null, "Materials are available", "Sucessfull", JOptionPane.INFORMATION_MESSAGE);
//            }
            if(issued == true){
                    JOptionPane.showMessageDialog(null, "This Order was already Issued!", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            availablityBTN_Checker = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_availabilityBTNActionPerformed

    private void issueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueActionPerformed
        
        if(availablityBTN_Checker == true){
            if(issued == false){
                if(available == true){
                     for(int a=0; a<count; a++){
                         new WarehouseController().changing_Material_Stock(material[a][0], availableStock[a]);
                         new WarehouseController().changing_Order_material_issue(order_id, material[a][0]);
//                         System.out.println((a+1) + " " + material[a][0] + " " + availableStock[a]);
                     }
                     JOptionPane.showMessageDialog(null, "Stock has been Changed!!", "Sucessfull", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Materials are not available", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "This Order was already Issued!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please check the material availablity firstly", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
        availablityBTN_Checker = false;
        count = 0;
    }//GEN-LAST:event_issueActionPerformed

    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
        this.toBack();
        setVisible(false);
        new Warehouse_Home().toFront();
        new Warehouse_Home().setState(java.awt.Frame.NORMAL);
    }//GEN-LAST:event_backBTNActionPerformed

    private void cancelBTN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBTN2ActionPerformed

        if (JOptionPane.showConfirmDialog( new JFrame("Exit"),"Confirm if you Want to Exit","Inventory Management System",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
             System.exit(0);
    }//GEN-LAST:event_cancelBTN2ActionPerformed

    private void loadingOrderIDs(){
        try {
            ResultSet result = new DBSearch().getOrderIDs();
            while(result.next()){
                String nextOrderID = result.getString(1);
                this.orderIdCMB.addItem(nextOrderID);
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        try {
            IntelliJTheme.setup(DraculaMeta.class.getResourceAsStream("/themes/Dracula.theme.json"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Issuing_Raw_materials().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton availabilityBTN;
    private javax.swing.JButton backBTN;
    private javax.swing.JButton cancelBTN2;
    private javax.swing.JTable detailsTable;
    private javax.swing.JButton issue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> orderIdCMB;
    // End of variables declaration//GEN-END:variables
}