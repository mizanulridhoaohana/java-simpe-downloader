/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package base;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

/**
 *
 * @author mizanul
 */
public class downloadFrame extends javax.swing.JFrame {
    private volatile boolean isPaused = false;
    private JFrame frame;
    private DefaultListModel<String> recentDownloadsListModel;

    /**
     * Creates new form downloadFrame
     */
    public downloadFrame() {
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

        pauseButton = new javax.swing.JButton();
        downloadButton = new javax.swing.JButton();
        resumeButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        urlField = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        recentDownloadsListModel = new DefaultListModel<>();
        recentDownloadsList = new javax.swing.JList<>(recentDownloadsListModel);
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pauseButton.setContentAreaFilled(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pauseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, 170, 80));

        downloadButton.setBackground(new java.awt.Color(148, 0, 255));
        downloadButton.setContentAreaFilled(false);
        downloadButton.setText(" ");
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });
        getContentPane().add(downloadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 640, 180, 70));

        resumeButton.setText(" ");
        resumeButton.setContentAreaFilled(false);
        resumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resumeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 630, 180, 70));

        progressBar.setStringPainted(true);
        progressBar.setVisible(false);
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 580, 90));

        urlField.setBackground(new java.awt.Color(229, 184, 228));
        urlField.setBorder(null);
        urlField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlFieldActionPerformed(evt);
            }
        });
        getContentPane().add(urlField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 560, 40));
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 360, 60));

        recentDownloadsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(recentDownloadsList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_component/revisi_download.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadButtonActionPerformed
        // TODO add your handling code here:
//        JOptionPane.showMessageDialog(null,"");
        String url = urlField.getText();
        downloadFile(url);
    }//GEN-LAST:event_downloadButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        // TODO add your handling code here:
        isPaused = true;
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void resumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumeButtonActionPerformed
        // TODO add your handling code here:
        isPaused = false;
    }//GEN-LAST:event_resumeButtonActionPerformed

    private void urlFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urlFieldActionPerformed
    
    
    private void downloadFile(String fileUrl) {
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    URL remoteFile = new URL(fileUrl);
                    URLConnection fileStream = remoteFile.openConnection();

                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Save File");
                    int userSelection = fileChooser.showSaveDialog(frame);

                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File saveFile = fileChooser.getSelectedFile();
                        FileOutputStream fOut = new FileOutputStream(saveFile);

                        String fileName = saveFile.getName();

                        InputStream in = fileStream.getInputStream();
                        long fileSize = fileStream.getContentLengthLong();

                        int data;
                        long bytesRead = 0;
                        while ((data = in.read()) != -1) {
                            if (isPaused) {
                                // Pause the download if the flag is set
                                Thread.sleep(10000); // Sleep to reduce CPU usage while paused
                                continue;
                            }

                            fOut.write(data);
                            bytesRead++;

                            int progress = (int) ((bytesRead * 100) / fileSize);
                            publish(progress);
                        }
                        recentDownloadsListModel.addElement(fileName);

                        fOut.close();
                        in.close();

                        JOptionPane.showMessageDialog(frame, "File has been successfully downloaded and saved.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error downloading the file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                if (!isCancelled()) {
                    int latestProgress = chunks.get(chunks.size() - 1);
                    progressBar.setValue(latestProgress);
                }
            }

            @Override
            protected void done() {
                progressBar.setVisible(false);
            }
        };

        progressBar.setValue(0);
        progressBar.setVisible(true);
        worker.execute();
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
            java.util.logging.Logger.getLogger(downloadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(downloadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(downloadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(downloadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new downloadFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton downloadButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton pauseButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JList<String> recentDownloadsList;
    private javax.swing.JButton resumeButton;
    private javax.swing.JTextField urlField;
    // End of variables declaration//GEN-END:variables
}