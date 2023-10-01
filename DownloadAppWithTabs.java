import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class DownloadAppWithTabs {
    private JFrame frame;
    private JTextField urlField;
    private JButton downloadButton;
    private JProgressBar progressBar;
    private JLabel titleLabel;
    private ImageIcon logoImage;
    private JButton resumeButton;
    private JButton pauseButton;
    private JList<String> recentDownloadsList;
    private DefaultListModel<String> recentDownloadsListModel;
    private JTabbedPane tabbedPane;
    private JPanel downloadPanel;
    private JPanel recentDownloadsPanel;
    private JButton showRecentButton;

    private volatile boolean isPaused = false;


    public DownloadAppWithTabs() {
        initializeTitleLogo();
        tabOption();
    }

    private void initializeTitleLogo() {
        frame = new JFrame("Download App");
        frame.setBounds(100, 100, 400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        // Load the logo image
        logoImage = new ImageIcon("./image.jpg"); // Replace with the path to your logo image

        // Create a label for the logo
        JLabel logoLabel = new JLabel(logoImage);

        // Create a label for the title
        titleLabel = new JLabel("Download App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        frame.getContentPane().add(logoLabel, BorderLayout.NORTH);
        frame.getContentPane().add(titleLabel, BorderLayout.NORTH);
    }

    private void tabOption(){
        tabbedPane = new JTabbedPane();

        downloadPanel = new JPanel();
        downloadPanel.setLayout(new BorderLayout());

        urlField = new JTextField();
        // downloadButton = new JButton("Download");

        downloadButton = new JButton("Download");
        downloadPanel.add(downloadButton, BorderLayout.EAST);

        // pause-resume
        pauseButton = new JButton("Pause");
        downloadPanel.add(pauseButton, BorderLayout.EAST);

        resumeButton = new JButton("Resume");
        downloadPanel.add(resumeButton, BorderLayout.WEST);

        // Download button
        downloadPanel.add(urlField, BorderLayout.NORTH);
        downloadPanel.add(downloadButton, BorderLayout.SOUTH);

        // JPanel progresBarJPanel = new JPanel();
        // progresBarJPanel.setLayout(new BorderLayout());

        // progress bar
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);

        downloadPanel.add(progressBar, BorderLayout.CENTER);

        // tab option download
        tabbedPane.addTab("Download", downloadPanel);

        recentDownloadsPanel = new JPanel();
        recentDownloadsPanel.setLayout(new BorderLayout());

        recentDownloadsListModel = new DefaultListModel<>();
        recentDownloadsList = new JList<>(recentDownloadsListModel);

        showRecentButton = new JButton("Show Recent Downloads");
        recentDownloadsPanel.add(showRecentButton, BorderLayout.NORTH);
        recentDownloadsPanel.add(new JScrollPane(recentDownloadsList), BorderLayout.CENTER);

        tabbedPane.addTab("Recent Downloads", recentDownloadsPanel);

        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        showRecentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(1); // Switch to the "Recent Downloads" tab
            }
        });

        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = urlField.getText();
                downloadFile(url);
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPaused = true;
            }
        });

        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPaused = false;
            }
        });
    }

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

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DownloadAppWithTabs app = new DownloadAppWithTabs();
                app.display();
            }
        });
    }
}
