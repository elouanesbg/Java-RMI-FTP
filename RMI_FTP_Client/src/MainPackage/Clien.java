/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ELouanes
 */
public class Clien extends javax.swing.JFrame {

    private int Port;
    private String IP;
    private String user;
    private String fileName;
    private Vector Files;
    private DefaultTableModel FileModel;
    private ServeurInt InterfaceRemot;
    private boolean Recev;
    private String RecevMSG;
    Thre T;

    public ServeurInt getInterfaceRemot() {
        return InterfaceRemot;
    }
    
    
    public Clien() {
        initComponents();
    }
    
    private boolean ConnectClient(int port,String IP,String user){
        try {
            // fire to localhost port 1099
            Registry myRegistry = LocateRegistry.getRegistry(IP,port);
             
            // search for myMessage service
            InterfaceRemot = (ServeurInt) myRegistry.lookup("myMessage");
            InterfaceRemot.login(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }       
    }
    private boolean Deconnect(){
        return true;
    }

    public byte[] FileByte(String fileName) {
        
        try {
                
                File file = new File(fileName);
                byte buffer[] = new byte[(int)file.length()];
                BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));
                input.read(buffer,0,buffer.length);
                input.close();
                
                return(buffer);
                } catch(Exception e){
                e.printStackTrace();
                return(null);
                }
    }
    
    public void RecvMSG(String M){
        jTextAreaChat.append("Serveur >> "+M+"\n");        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldIP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPort = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jButtonConnect = new javax.swing.JButton();
        jButtonDeconnect = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonFilesList = new javax.swing.JButton();
        jButtonDownload = new javax.swing.JButton();
        jButtonUpload = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextArea();
        jTextFieldSend = new javax.swing.JTextField();
        jButtonSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Connect"));

        jLabel1.setText("Serveur IP:");

        jTextFieldIP.setText("127.0.0.1");

        jLabel2.setText("Serveur Port:");

        jTextFieldPort.setText("1099");

        jLabel3.setText("Utilisateur:");

        jTextFieldUser.setText("Client");

        jButtonConnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/network_16x16.png"))); // NOI18N
        jButtonConnect.setText("Connect");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        jButtonDeconnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eject_16x16.png"))); // NOI18N
        jButtonDeconnect.setText("Deconnect");
        jButtonDeconnect.setEnabled(false);
        jButtonDeconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeconnectActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/round-question_16x16.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonConnect)
                        .addGap(241, 241, 241)
                        .addComponent(jButtonDeconnect)))
                .addGap(10, 10, 10)
                .addComponent(jLabel4))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConnect)
                    .addComponent(jButtonDeconnect))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Files"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Files Names"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonFilesList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/repeat_16x16.png"))); // NOI18N
        jButtonFilesList.setText("Refrech Files Listes");
        jButtonFilesList.setEnabled(false);
        jButtonFilesList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilesListActionPerformed(evt);
            }
        });

        jButtonDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/download_16x16.png"))); // NOI18N
        jButtonDownload.setText("Download File");
        jButtonDownload.setEnabled(false);
        jButtonDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDownloadActionPerformed(evt);
            }
        });

        jButtonUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cloud-upload_16x16.png"))); // NOI18N
        jButtonUpload.setText("Upload File");
        jButtonUpload.setEnabled(false);
        jButtonUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUploadActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/folder_16x16.png"))); // NOI18N
        jButton1.setText("Open Files Folder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButtonFilesList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDownload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonUpload))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFilesList)
                    .addComponent(jButtonDownload)
                    .addComponent(jButtonUpload)
                    .addComponent(jButton1)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("FTP          .", new javax.swing.ImageIcon(getClass().getResource("/icon/folder_16x16.png")), jPanel1); // NOI18N

        jTextAreaChat.setColumns(20);
        jTextAreaChat.setRows(5);
        jScrollPane2.setViewportView(jTextAreaChat);

        jButtonSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/letter-opened_16x16.png"))); // NOI18N
        jButtonSend.setText("Send");
        jButtonSend.setEnabled(false);
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldSend, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSend, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSend))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Chat          .", new javax.swing.ImageIcon(getClass().getResource("/icon/letter_16x16.png")), jPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         Recev=true;
         FileModel=new DefaultTableModel();
         FileModel.addColumn("Files Names");
         jTable1.setModel(FileModel);
         try {  
                ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "mkdir \"C:\\ClientRMI");
                builder.redirectErrorStream(true);
                builder.start(); 
        } catch (Exception e) { JOptionPane.showMessageDialog(null, e); }
         
    }//GEN-LAST:event_formWindowOpened

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        Port=Integer.valueOf(jTextFieldPort.getText());
        IP=jTextFieldIP.getText();
        user=jTextFieldUser.getText();
        if(ConnectClient(Port, IP, user)){
            jButtonConnect.setEnabled(false);
            jButtonDeconnect.setEnabled(true);
            jButtonFilesList.setEnabled(true);
            jButtonDownload.setEnabled(true);
            jButtonUpload.setEnabled(true);
            jButtonSend.setEnabled(true);
            jButtonFilesList.doClick();
            T = new Thre(this,InterfaceRemot);
            T.start();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Connect Erure chack ip or port");
        }
    }//GEN-LAST:event_jButtonConnectActionPerformed

    private void jButtonDeconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeconnectActionPerformed
        
        if(Deconnect()){
            try {
                InterfaceRemot.logOut(user);
                jButtonConnect.setEnabled(true);
                jButtonDeconnect.setEnabled(false);
                jButtonFilesList.setEnabled(false);
                jButtonDownload.setEnabled(false);
                jButtonUpload.setEnabled(false);
                jButtonSend.setEnabled(false);
                T.stop();
            } catch (RemoteException ex) {
                Logger.getLogger(Clien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonDeconnectActionPerformed

    private void jButtonDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDownloadActionPerformed

        if(jTable1.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(rootPane, "Select File First");
        }else{
            fileName=FileModel.getValueAt(jTable1.getSelectedRow(),0).toString();
        try {
                
                byte[] filedata=InterfaceRemot.SendFile(fileName,user);
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("C:\\ClientRMI\\"+fileName));
                output.write(filedata,0,filedata.length);
                output.flush();
                output.close();
                JOptionPane.showMessageDialog(rootPane, fileName+"  has bin download avec sucsse");
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(rootPane, "un errure se produit leur de la telechargement de "+fileName);
                   ex.printStackTrace();
                 }
        }
    }//GEN-LAST:event_jButtonDownloadActionPerformed

    private void jButtonFilesListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilesListActionPerformed
        try {
            
            FileModel.setRowCount(0);
            Files=InterfaceRemot.GetListFiles();
            Iterator it =Files.iterator();
            while(it.hasNext()){
                String f = (String)it.next();
                FileModel.addRow(new Object[]{f});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Un errure se produir leur de Get Files");
            Logger.getLogger(Clien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFilesListActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        try {  
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\ClientRMI"); 
        } catch (Exception e) { JOptionPane.showMessageDialog(null, e); }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUploadActionPerformed

        try {
                File selectfile = null;
                javax.swing.JFileChooser file = new JFileChooser();
                int val= file.showOpenDialog(null);
                if(val==JFileChooser.APPROVE_OPTION){
                    selectfile = file.getSelectedFile();
                }
                String SendfileName=selectfile.getName();
                
                byte buffer[] = FileByte(selectfile.getAbsolutePath());//new byte[(int)selectfile.length()];
                
                //
                InterfaceRemot.RecivFile(buffer, SendfileName, user);
                JOptionPane.showMessageDialog(rootPane, SendfileName+" Has ben Transmite");
                } catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "un erure se produit leu de envoi");
                }
        
    }//GEN-LAST:event_jButtonUploadActionPerformed

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        try {
            String MSG=jTextFieldSend.getText();
            InterfaceRemot.RecivMSG(user, MSG);
            jTextAreaChat.append("Moi >> "+MSG+"\n");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "MSG not Transmite");
            Logger.getLogger(Clien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSendActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        JOptionPane.showMessageDialog(rootPane, "Bouguerra Elouanes \nMenacer Abderaouf \nBenrekia Mamoune"
                + "\nAbdellah Khater Esam \nBourabia Ahmed \nEncadré par :  Mr.Rahim  \nUniv Medea");
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(Clien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonDeconnect;
    private javax.swing.JButton jButtonDownload;
    private javax.swing.JButton jButtonFilesList;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JButton jButtonUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaChat;
    private javax.swing.JTextField jTextFieldIP;
    private javax.swing.JTextField jTextFieldPort;
    private javax.swing.JTextField jTextFieldSend;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}
