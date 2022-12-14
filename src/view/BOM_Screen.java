/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import com.draculatheme.jetbrains.DraculaMeta;
import com.formdev.flatlaf.IntelliJTheme;
import java.sql.*;
import model.DBConnection;
import model.DBSearch;
import javax.swing.JOptionPane;
import controller.MRPController;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class BOM_Screen extends javax.swing.JFrame {

    /**
     * Creates new form BOM_Screen
     */
    public BOM_Screen() {
        initComponents();
        loadingOrderIDs();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }
    
    String nextOrderID = "";
    String selectedProductName = "";
    String produtData[][] = new String[9][4];
    int x = 0;
    String currentDate = "";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
        private void loadingOrderIDs() {
        try {
            ResultSet result = new DBSearch().getOrderIDs();
            while (result.next()) {
                String nextOrderID = result.getString(1);
                this.orderID.addItem(nextOrderID);
            }
            DBConnection.closeCon();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        BOM_table = new javax.swing.JTable();
        orderID = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        saveBTN = new javax.swing.JButton();
        backBTN = new javax.swing.JButton();
        cancelBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BOM_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Material ID", "Material Name", "Quantity for the Order (Kg)", "Price for the Order (Rs)"
            }
        ));
        jScrollPane1.setViewportView(BOM_table);

        orderID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        orderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderIDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setText("Bill of Material");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Order ID    :");

        saveBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveBTN.setText("Save");
        saveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTNActionPerformed(evt);
            }
        });

        backBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backBTN.setText("Back");
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });

        cancelBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBTN.setText("Cancel");
        cancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(orderID, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1)))
                .addGap(229, 229, 229))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBTN)
                        .addGap(29, 29, 29)
                        .addComponent(cancelBTN)
                        .addGap(30, 30, 30)
                        .addComponent(saveBTN))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backBTN)
                        .addComponent(cancelBTN))
                    .addComponent(saveBTN))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void orderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderIDActionPerformed
 
        setMaterialDetails(this.orderID.getSelectedItem().toString());
    }//GEN-LAST:event_orderIDActionPerformed

    private void saveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTNActionPerformed

        try {
            
            ResultSet result = new DBSearch().get_Material_and_price_Details_According_to_OrderId(this.orderID.getSelectedItem().toString());

            while (result.next()) {
                MRPController.update_price_to_Order_row_material(this.orderID.getSelectedItem().toString(), result.getString(2), result.getString(6),result.getString(7) );
            }
            
            JOptionPane.showMessageDialog(null, "Order total price is updated", "Sucessfull", JOptionPane.INFORMATION_MESSAGE); 
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }//GEN-LAST:event_saveBTNActionPerformed

    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
        this.toBack();
        setVisible(false);
        new Finance_Home().toFront();
        new Finance_Home().setState(java.awt.Frame.NORMAL);
    }//GEN-LAST:event_backBTNActionPerformed

    private void cancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBTNActionPerformed

        if (JOptionPane.showConfirmDialog( new JFrame("Exit"),"Confirm if you Want to Exit","Inventory Management System",
            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_cancelBTNActionPerformed

        private void setMaterialDetails(String order_id) {
        try {
            ResultSet result = new DBSearch().get_Material_and_price_Details_According_to_OrderId(order_id);
            DefaultTableModel model = (DefaultTableModel) BOM_table.getModel();
            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }
            
            while (result.next()) {
                String data[] = {result.getString(2), result.getString(3), result.getString(6),result.getString(7)};
                model.addRow(data);
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
                new BOM_Screen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BOM_table;
    private javax.swing.JButton backBTN;
    private javax.swing.JButton cancelBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> orderID;
    private javax.swing.JButton saveBTN;
    // End of variables declaration//GEN-END:variables
}
