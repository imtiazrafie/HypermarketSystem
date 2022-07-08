package main;

import java.io.*;
import java.util.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ImporttxtUI extends javax.swing.JFrame 
{

    /**
     * Creates new form HomeUI
     */
    public ImporttxtUI() 
    {
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private CounterChoose counterchoose;

    //Temporary list without counter number, will assign to counter list queue
    private ArrayList<CustomerInformation> customerList = new ArrayList();
    private ArrayList<String> listCustID = new ArrayList<String>();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jButton1 = new javax.swing.JButton();
        jButton1.setFont(new Font("Arial", Font.PLAIN, 16));
        jButton1.setForeground(new Color(0, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MAIN");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new Color(230, 230, 250));

        jLabel1.setFont(new Font("Arial", Font.PLAIN, 20)); // NOI18N
        jLabel1.setText("Hypermarket Cashier System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(637, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel7.setFont(new Font("Arial", Font.PLAIN, 18)); // NOI18N
        jLabel7.setText("Click here to read txt file");

        jButton1.setBackground(new Color(230, 230, 250));
        jButton1.setText("START");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(356)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(407, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(282)
        			.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(341, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(140)
        			.addComponent(jLabel7)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(177, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    //Get only selected item by customer ID to add to counter
    public List filterItemDataCust(String custID) 
    {
        Predicate<CustomerInformation> itemSelectCondition = itemsCond -> itemsCond.getCustID().equalsIgnoreCase(custID);
        List itemsCustomer = customerList.stream().filter(itemSelectCondition).collect(Collectors.toList());
        return itemsCustomer;
    }
    
    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        jButton1.setEnabled(false);
        
        //1. Read textfile and add to temporary array
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("cashierapp.txt"));
            String line = br.readLine();

            String customerID = "";
            String customerIC = "";
            String customerName = "";
            String currentCustID = "";

            while (line != null) 
            {
                //Read data each line
                StringTokenizer st = new StringTokenizer(line, ",");
                customerID = st.nextToken();
                customerIC = st.nextToken();
                customerName = st.nextToken();
                String itemID = st.nextToken();
                String itemName = st.nextToken();
                double itemPrice = Double.parseDouble(st.nextToken());
                String datePurchase = st.nextToken();
                if (!customerID.equalsIgnoreCase(currentCustID))
                {
                    listCustID.add(customerID);
                    currentCustID = customerID;
                }

                customerList.add(new CustomerInformation(customerID, customerIC, customerName, null, 
                		                                itemID, itemName, itemPrice, datePurchase));

                line = br.readLine();
            }
            br.close();

            //Add to new queue
            int stateCounterNumber = 1;
            for (int i = 0; i < listCustID.size(); i++) 
            {
                List filteredItemCustomer = filterItemDataCust(listCustID.get(i));

                if (filteredItemCustomer.size() <= 5) 
                {
                    if (stateCounterNumber == 1) 
                    {
                        for (int j = 0; j < filteredItemCustomer.size(); j++) 
                        {
                            CustomerInformation itemdata = (CustomerInformation) filteredItemCustomer.get(j);
                            String custID = itemdata.getCustID();
                            String custIC = itemdata.getCustIC();
                            String custName = itemdata.getCustName();
                            String itemID = itemdata.getItemID();
                            String itemName = itemdata.getItemName();
                            Double itemPrice = itemdata.getitemPrice();
                            String datePurchased = itemdata.getDatePurchase();

                            main.Main.getCounter1().add(new CustomerInformation(custID, custIC, custName, "counter1", itemID, itemName, itemPrice, datePurchased));
                        }
                        stateCounterNumber = 2;
                    }
                    else if (stateCounterNumber == 2) 
                    {
                        for (int j = 0; j < filteredItemCustomer.size(); j++) 
                        {
                            CustomerInformation itemdata = (CustomerInformation) filteredItemCustomer.get(j);
                            String custID = itemdata.getCustID();
                            String custIC = itemdata.getCustIC();
                            String custName = itemdata.getCustName();
                            String itemID = itemdata.getItemID();
                            String itemName = itemdata.getItemName();
                            Double itemPrice = itemdata.getitemPrice();
                            String datePurchased = itemdata.getDatePurchase();

                            main.Main.getCounter2().add(new CustomerInformation(custID, custIC, custName, "counter2", itemID, itemName, itemPrice, datePurchased));

                        }
                        stateCounterNumber = 1;
                    }
                } 
                else 
                {
                    for (int j = 0; j < filteredItemCustomer.size(); j++)
                    {
                        CustomerInformation itemdata = (CustomerInformation) filteredItemCustomer.get(j);
                        String custID = itemdata.getCustID();
                        String custIC = itemdata.getCustIC();
                        String custName = itemdata.getCustName();
                        String itemID = itemdata.getItemID();
                        String itemName = itemdata.getItemName();
                        Double itemPrice = itemdata.getitemPrice();
                        String datePurchased = itemdata.getDatePurchase();

                        main.Main.getCounter3().add(new CustomerInformation(custID, custIC, custName, "counter3", itemID, itemName, itemPrice, datePurchased));

                    }
                }
            }

            counterchoose = new CounterChoose();
            counterchoose.setVisible(true);
        } 
        catch (Exception e) 
        {
            System.out.println("error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1MouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}