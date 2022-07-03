package main;

import java.util.*;
import javax.swing.table.*;
import java.awt.Color;
import java.awt.Font;

public class Receipt extends javax.swing.JFrame
{
    public Receipt(String custID, String custIC, String custName, double totalAmount, double paidAmount, double balance, Queue listItem) 
    {
        initComponents();
        pack();
        setLocationRelativeTo(null);

        //Displaying all data
        custNamelabel.setText(custName);
        custIDlabel.setText(custID);
        custIClabel.setText(custIC);
        paymenttitle.setText("Receipt " + custID);
        totalAmountlabel.setText("Total: RM " + totalAmount);
        paidlabel.setText("Paid: RM " + paidAmount);
        balancelabel.setText("Balance: RM " + balance);

        //Displaying item into table
        DefaultTableModel receiptTableModel = (DefaultTableModel) itemReceiptTable.getModel();
        for (Iterator iterator = listItem.iterator(); iterator.hasNext();) 
        {
            CustomerInformation customeritemdata = (CustomerInformation) iterator.next();
            receiptTableModel.addRow(new Object[]{customeritemdata.getItemName(), "RM " + customeritemdata.getitemPrice(), customeritemdata.getDatePurchase()});
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

        jPanel1 = new javax.swing.JPanel();
        custNamelabel = new javax.swing.JLabel();
        custIClabel = new javax.swing.JLabel();
        custIDlabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        paymenttitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemReceiptTable = new javax.swing.JTable();
        totalAmountlabel = new javax.swing.JLabel();
        paidlabel = new javax.swing.JLabel();
        balancelabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RECEIPT");

        custNamelabel.setFont(new Font("Arial", Font.PLAIN, 16)); // NOI18N
        custNamelabel.setText("CUSTOMER NAME");

        custIClabel.setFont(new Font("Arial", Font.PLAIN, 16)); // NOI18N
        custIClabel.setText("CUSTOMER IC");

        custIDlabel.setFont(new Font("Arial", Font.PLAIN, 16)); // NOI18N
        custIDlabel.setText("CUSTOMER ID");

        jPanel2.setBackground(new Color(230, 230, 250));

        paymenttitle.setFont(new Font("Arial", Font.PLAIN, 20)); // NOI18N
        paymenttitle.setForeground(new java.awt.Color(51, 51, 51));
        paymenttitle.setText("Receipt - Customer");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymenttitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paymenttitle)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        itemReceiptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Item Price", "Date Purchased"
            }
        ));
        jScrollPane1.setViewportView(itemReceiptTable);

        totalAmountlabel.setFont(new Font("Arial", Font.PLAIN, 18)); // NOI18N
        totalAmountlabel.setText("Total: RM 0");

        paidlabel.setFont(new Font("Arial", Font.PLAIN, 16)); // NOI18N
        paidlabel.setText("Paid: RM 0");

        balancelabel.setFont(new Font("Arial", Font.PLAIN, 16)); // NOI18N
        balancelabel.setText("Balance: RM 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(custNamelabel)
                    .addComponent(custIClabel)
                    .addComponent(custIDlabel)
                    .addComponent(totalAmountlabel)
                    .addComponent(paidlabel)
                    .addComponent(balancelabel))
                .addContainerGap(515, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(custNamelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(custIClabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(custIDlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalAmountlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paidlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balancelabel)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balancelabel;
    private javax.swing.JLabel custIClabel;
    private javax.swing.JLabel custIDlabel;
    private javax.swing.JLabel custNamelabel;
    private javax.swing.JTable itemReceiptTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel paidlabel;
    private javax.swing.JLabel paymenttitle;
    private javax.swing.JLabel totalAmountlabel;
    // End of variables declaration//GEN-END:variables
}