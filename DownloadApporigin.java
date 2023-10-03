import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class DownloadApporigin {
    private JFrame frame;
    private JTextField urlField;
    private JButton downloadButton;
    private JProgressBar progressBar;
    private JLabel titleLabel;
    private ImageIcon logoImage;
    private JButton resumeButton;
    private JButton pauseButton;

    private volatile boolean isPaused = false;


    public DownloadApporigin() {
        initializeTitleLogo();
        initializeUI();
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

    private void initializeUI() {
        // frame = new JFrame("Download App");
        // frame.setBounds(100, 100, 400, 200);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.getContentPane().setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        JPanel downloadJPanel = new JPanel();
        downloadJPanel.setLayout(new BorderLayout());

        JPanel progresBarJPanel = new JPanel();
        progresBarJPanel.setLayout(new BorderLayout());

        urlField = new JTextField();
        inputPanel.add(urlField, BorderLayout.CENTER);

        downloadButton = new JButton("Download");
        downloadJPanel.add(downloadButton, BorderLayout.EAST);

        pauseButton = new JButton("Pause");
        downloadJPanel.add(pauseButton, BorderLayout.CENTER);

        resumeButton = new JButton("Resume");
        downloadJPanel.add(resumeButton, BorderLayout.WEST);

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);

        progresBarJPanel.add(progressBar, BorderLayout.CENTER);

        frame.getContentPane().add(inputPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(downloadJPanel, BorderLayout.EAST);
        frame.getContentPane().add(progressBar, BorderLayout.CENTER);

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
                DownloadApporigin app = new DownloadApporigin();
                app.display();
            }
        });
    }
}
