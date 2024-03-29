/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clientapplication;

import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hassa
 */
public class MainScreen extends javax.swing.JFrame {
    
    SubmitProposalScreen submitProposalGUI = new SubmitProposalScreen();
    SubmitIntentScreen submitIntentGUI = new SubmitIntentScreen();

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        genIDButton = new javax.swing.JButton();
        submitProposalButton = new javax.swing.JButton();
        queryProposalButton = new javax.swing.JButton();
        sendIntentButton = new javax.swing.JButton();
        checkIntentButton = new javax.swing.JButton();
        IDTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        errorText = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        genIDButton.setText("Generate ID");
        genIDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genIDButtonActionPerformed(evt);
            }
        });

        submitProposalButton.setText("Submit Proposal");
        submitProposalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitProposalButtonActionPerformed(evt);
            }
        });

        queryProposalButton.setText("Query Proposal");
        queryProposalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryProposalButtonActionPerformed(evt);
            }
        });

        sendIntentButton.setText("Send Intent");
        sendIntentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendIntentButtonActionPerformed(evt);
            }
        });

        checkIntentButton.setText("Check Intent");
        checkIntentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkIntentButtonActionPerformed(evt);
            }
        });

        IDTextField.setEditable(false);

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setLineWrap(true);
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        errorText.setForeground(new java.awt.Color(222, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(genIDButton, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addComponent(errorText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(queryProposalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(submitProposalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkIntentButton, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(sendIntentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(genIDButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IDTextField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkIntentButton)
                    .addComponent(submitProposalButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(queryProposalButton)
                    .addComponent(sendIntentButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorText, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void genIDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genIDButtonActionPerformed
        try {
            if ("".equals(ClientApplication.userID)){
                String id = ClientApplication.generateID();
                ClientApplication.userID = id;
                
                IDTextField.setText("User ID: " + id);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_genIDButtonActionPerformed

    private void submitProposalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitProposalButtonActionPerformed
        if (!"".equals(ClientApplication.userID)){
            submitProposalGUI.setVisible(true);
            errorText.setText("");
        } else {
            errorText.setText("Error, please generate ID first!");
        }
        
    }//GEN-LAST:event_submitProposalButtonActionPerformed

    private void queryProposalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryProposalButtonActionPerformed
        try {
            List<TravelDetails> travelDetails = ClientApplication.getProposals();            
            String fullData = "";
            
            for (int i = 0; i < travelDetails.size(); i++) {
                TravelDetails trip = travelDetails.get(i);
                
                String data = String.format("%s:"
                        + "%nUser ID: %s"
                        + "%nMessage ID: %s"
                        + "%nDate: %s"
                        + "%nLocation: %s"
                        + "%nLatitude: %s"
                        + "%nLongitude: %s"
                        + "%nTemperature: %s C"
                        + "%nWindspeed: %s Km/h"
                        + "%nChance of Rain: %s%%"
                        + "%nChance of Snow: %s%%"
                        + "%nDescription: %s"
                        + "%n%n", i, 
                        trip.userID, trip.messageID, trip.date, 
                        trip.locationData.get("location"), 
                        trip.locationData.get("latitude"), 
                        trip.locationData.get("longitude"), 
                        trip.weatherData.get("tempC"), 
                        trip.weatherData.get("windspeedKmh"), 
                        trip.weatherData.get("chanceOfRain"), 
                        trip.weatherData.get("chanceOfSnow"), 
                        trip.weatherData.get("description"));
                
                fullData += data;
            }
            
            
            textArea.setText(fullData);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_queryProposalButtonActionPerformed

    private void sendIntentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendIntentButtonActionPerformed
        if (!"".equals(ClientApplication.userID)){
            submitIntentGUI.setVisible(true);
            submitIntentGUI.fillSelections(ClientApplication.allTravelDetails);
        } else {
            errorText.setText("Error, please generate ID first!");
        }
        
        
    }//GEN-LAST:event_sendIntentButtonActionPerformed

    private void checkIntentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkIntentButtonActionPerformed
        if (!"".equals(ClientApplication.userID)){
            try {
                List<IntentDetails> intentDetails = ClientApplication.getIntents();
                String fullData = "";
                
                for (int i = 0; i < intentDetails.size(); i++) {
                    IntentDetails intent = intentDetails.get(i);
                    
                    if (intent.userID.equals(ClientApplication.userID)) {
                        String data = String.format("%s:"
                                + "%nUserID: %s"
                                + "%nMessageID: %s"
                                + "%nResponderID: %s"
                                + "%n%n", i,
                                intent.userID,
                                intent.messageID,
                                intent.responderID);
                        
                        fullData += data;
                    }
                }
                
                textArea.setText(fullData);
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }//GEN-LAST:event_checkIntentButtonActionPerformed
    
    public static void setProposalDetails(String location, String date, String lat, String lon) {
        try {
            String messageID = ClientApplication.generateID();
            ClientApplication.submitProposal(messageID, location, lat, lon, date);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setIntentDetails(String json) throws MalformedURLException {
        ClientApplication.sendIntent(json);
    }
    
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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDTextField;
    private javax.swing.JButton checkIntentButton;
    private javax.swing.JLabel errorText;
    private javax.swing.JButton genIDButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton queryProposalButton;
    private javax.swing.JButton sendIntentButton;
    private javax.swing.JButton submitProposalButton;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
