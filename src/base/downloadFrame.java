/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package base;
import javax.swing.*;
import java.io.*;
import java.net.*;
import javax.swing.table.DefaultTableModel;

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

        tabbedPaneCustom1 = new raven.tabbed.TabbedPaneCustom();
        jPanel1 = new javax.swing.JPanel();
        pauseButton = new javax.swing.JButton();
        downloadButton = new javax.swing.JButton();
        resumeButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        urlField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableContent = new javax.swing.JTable();
        javax.swing.JButton deleteButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DownloadAppJava");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(665, 470));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPaneCustom1.setUnselectedColor(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pauseButton.setContentAreaFilled(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });
        jPanel1.add(pauseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 130, 50));

        downloadButton.setBackground(new java.awt.Color(148, 0, 255));
        downloadButton.setContentAreaFilled(false);
        downloadButton.setText(" ");
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });
        jPanel1.add(downloadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 130, 50));

        resumeButton.setText(" ");
        resumeButton.setContentAreaFilled(false);
        resumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(resumeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 130, 50));

        progressBar.setStringPainted(true);
        progressBar.setVisible(false);
        progressBar.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 340, 40));

        urlField.setBackground(new java.awt.Color(229, 184, 228));
        urlField.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        urlField.setBorder(null);
        urlField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlFieldActionPerformed(evt);
            }
        });
        jPanel1.add(urlField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 400, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_component/downloadTab.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 430));

        tabbedPaneCustom1.addTab("Download", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableContent.setFont(new java.awt.Font("Dyuthi", 0, 15)); // NOI18N
        tableContent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Link Address", "Directory"
            }
        ));
        tableContent.setGridColor(new java.awt.Color(255, 255, 255));
        tableContent.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tableContent);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 130, 490, 210));

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel2.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui_component/recentTab.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, -1));

        tabbedPaneCustom1.addTab("Recent Download", jPanel2);

        getContentPane().add(tabbedPaneCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 770));

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

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableContent.getModel();
        model.setRowCount(0); // Remove all rows from the table model
        model.fireTableDataChanged(); // Update the JTable's view
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    
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

                        String downloadDirectory = saveFile.getParent(); 
                        String fileName = saveFile.getName();
                        String url = urlField.getText();

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
//                        recentDownloadsListModel.addElement(fileName);
                        
                        DefaultTableModel model = (DefaultTableModel) tableContent.getModel();
                        model.addRow(new Object[]{fileName, url, downloadDirectory});

                        // Add this line to update the table's view
                        model.fireTableDataChanged();


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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pauseButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton resumeButton;
    private raven.tabbed.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTable tableContent;
    private javax.swing.JTextField urlField;
    // End of variables declaration//GEN-END:variables
}
