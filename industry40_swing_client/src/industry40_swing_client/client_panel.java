/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package industry40_swing_client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 *
 * @author Ale
 */


public class client_panel extends javax.swing.JFrame {
    
    ArrayList<String> clientCronology = new ArrayList<String>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime time = LocalTime.now();
    
    Socket connessione = null;
    String server;
    int port;
    InputStreamReader input, in;
    BufferedReader sIN, inTastiera;
    OutputStream out;
    PrintWriter sOUT;
    
    Handler command;

    /**
     * Creates new form serverpanel_new
     */
    public client_panel() {
        command = new Handler();

        initComponents();
        btn_disconnectServer.setEnabled( false );
        
        
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
        jLabel1 = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_serverAddress = new javax.swing.JLabel();
        txtField_serverAddress = new javax.swing.JTextField();
        lbl_serverPort = new javax.swing.JLabel();
        txtField_serverPort = new javax.swing.JTextField();
        btn_connectServer = new javax.swing.JButton();
        btn_disconnectServer = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lbl_connectionStatus = new javax.swing.JLabel();
        progressBar_connectionStatus = new javax.swing.JProgressBar();
        lbl_tempoDiConnessione = new javax.swing.JLabel();
        lblOutput_lastConnection = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea_consoleLog = new javax.swing.JTextArea();
        txtArea_sendCommand = new javax.swing.JTextField();
        btn_sendCommand = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(433, 513));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("PROPRIETA'"));

        lbl_serverAddress.setText("INDIRIZZO SERVER:");

        txtField_serverAddress.setText("localhost");
        txtField_serverAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtField_serverAddressActionPerformed(evt);
            }
        });

        lbl_serverPort.setText("PORTA SERVER:");

        txtField_serverPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtField_serverPortActionPerformed(evt);
            }
        });

        btn_connectServer.setText("CONNETTITI");
        btn_connectServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectServerActionPerformed(evt);
            }
        });

        btn_disconnectServer.setText("DISCONNETTITI");
        btn_disconnectServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_disconnectServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_disconnectServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_connectServer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_serverPort, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_serverAddress, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtField_serverPort)
                            .addComponent(txtField_serverAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_serverAddress)
                    .addComponent(txtField_serverAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_serverPort)
                    .addComponent(txtField_serverPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btn_connectServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_disconnectServer)
                .addGap(56, 56, 56))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("STATUS"));

        lbl_connectionStatus.setText("STATO CONNESSIONE:");

        progressBar_connectionStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_tempoDiConnessione.setText("ULTIMA CONNESSIONE:");

        lblOutput_lastConnection.setText(" ");
        lblOutput_lastConnection.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tempoDiConnessione, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_connectionStatus, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(progressBar_connectionStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblOutput_lastConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_connectionStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressBar_connectionStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tempoDiConnessione)
                    .addComponent(lblOutput_lastConnection))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("CONSOLE LOG"));

        txtArea_consoleLog.setEditable(false);
        txtArea_consoleLog.setBackground(new java.awt.Color(0, 0, 0));
        txtArea_consoleLog.setColumns(20);
        txtArea_consoleLog.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        txtArea_consoleLog.setForeground(new java.awt.Color(255, 255, 255));
        txtArea_consoleLog.setRows(5);
        jScrollPane2.setViewportView(txtArea_consoleLog);

        txtArea_sendCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArea_sendCommandActionPerformed(evt);
            }
        });

        btn_sendCommand.setText("INVIA");
        btn_sendCommand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendCommandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtArea_sendCommand, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btn_sendCommand, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArea_sendCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sendCommand))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("SERVER SETTINGS", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sendCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendCommandActionPerformed
        /*
        String tmpString;

        if (txtArea_sendCommand.getText().indexOf("ADD") == 0) {
            System.out.println("@dicaprioale | AZIONE: Il client ha eseguito il comando ADD" );

            String nomePdv = txtArea_sendCommand.getText().substring("ADD".length() + 1);                         // ACQUISIZIONE DEL NOME DEL NUOVO PUNTO DI VERIFICA DA GGIUNGERE
            tabHandler.addNewTab(tabbedPane, nomePdv);
            
        } */
        clientCronology.add( time.format(formatter) + " > " + command.sendCommand( txtArea_sendCommand.getText() ) );
        txtArea_consoleLog.setText( clientCronology.toString().replace(",", "\n").replace("]", "").replace("[", "") );
    }//GEN-LAST:event_btn_sendCommandActionPerformed

    private void txtArea_sendCommandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArea_sendCommandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArea_sendCommandActionPerformed

    private void btn_disconnectServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disconnectServerActionPerformed
        try {
            connessione.close();
            System.out.println("Disconnesso!");
            System.out.println("QUIT");

            btn_disconnectServer.setEnabled( false );
            btn_connectServer.setEnabled( true );
            txtField_serverAddress.setEnabled( true );
            txtField_serverPort.setEnabled( true );
            progressBar_connectionStatus.setValue(0);
            time = LocalTime.now();
            lblOutput_lastConnection.setText( time.format(formatter).toString() );
            clientCronology.add( time.format(formatter) + " > Disconnesso dal server " + server + ":" + port );
            txtArea_consoleLog.setText( clientCronology.toString().replace(",", "\n").replace("]", "").replace("[", "") );

        } catch (IOException ex) {
            Logger.getLogger(client_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_disconnectServerActionPerformed

    private void btn_connectServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectServerActionPerformed
        System.out.println( "Server port:" + txtField_serverPort.getText() );
        if( txtField_serverPort.getText().equals("") ) {
            JOptionPane.showMessageDialog( this, "Specificare la porta\n", "Errore porta", JOptionPane.ERROR_MESSAGE );
        } else {
            server = txtField_serverAddress.getText();
            port = Integer.parseInt(txtField_serverPort.getText() );
            try {
                connessione = new Socket( server, port );

                //checkConnection_variable.checkConnection(connessione);

                System.out.println( "@dicaprioale | CLIENT: Connesso al server" );
                System.out.println("Indirizzo: " + server + ":" + port );
                System.out.println("Connessione: " + connessione + "\n" );
                btn_disconnectServer.setEnabled( true );
                btn_connectServer.setEnabled( false );
                txtField_serverAddress.setEnabled( false );
                txtField_serverPort.setEnabled( false );
                progressBar_connectionStatus.setValue(100);
                clientCronology.add(time.format(formatter) + " > Connesso al server " + server + ":" + port );
                txtArea_consoleLog.setText( clientCronology.toString().replace(",", "\n").replace("]", "").replace("[", "") );

                try {
                    in = new InputStreamReader( connessione.getInputStream() );
                    sIN = new BufferedReader( in );

                    out = connessione.getOutputStream();
                    sOUT = new PrintWriter( out );

                    input = new InputStreamReader( System.in );
                    //inTastiera = new BufferedReader( input );

                    command.commandHandle( sIN, sOUT );

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch( IOException e ) {
                JOptionPane.showMessageDialog( this, "Non sono riuscito a connettermi al server indicato.\nVerificare che la porta e l'indirizzo inserito, siano corretti \n", "Server non trovato", JOptionPane.ERROR_MESSAGE );
            }

        }
    }//GEN-LAST:event_btn_connectServerActionPerformed

    private void txtField_serverPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtField_serverPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtField_serverPortActionPerformed

    private void txtField_serverAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtField_serverAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtField_serverAddressActionPerformed

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
            java.util.logging.Logger.getLogger(client_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client_panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connectServer;
    private javax.swing.JButton btn_disconnectServer;
    private javax.swing.JButton btn_sendCommand;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblOutput_lastConnection;
    private javax.swing.JLabel lbl_connectionStatus;
    private javax.swing.JLabel lbl_serverAddress;
    private javax.swing.JLabel lbl_serverPort;
    private javax.swing.JLabel lbl_tempoDiConnessione;
    private javax.swing.JProgressBar progressBar_connectionStatus;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTextArea txtArea_consoleLog;
    private javax.swing.JTextField txtArea_sendCommand;
    private javax.swing.JTextField txtField_serverAddress;
    private javax.swing.JTextField txtField_serverPort;
    // End of variables declaration//GEN-END:variables
}


