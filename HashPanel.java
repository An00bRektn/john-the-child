import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Dimension;
import java.awt.BorderLayout;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

// TODO: Allow the hashing of files on the users system. Make sure the original file is not changed
// But a new file is made instead
public class HashPanel extends JPanel{
    private JTextArea inputText; 
    private JTextArea outputText;

    private ArrayList<String> wordlist = new ArrayList<String>();
    private ArrayList<HashCrackerThread> crackers = new ArrayList<HashCrackerThread>();
    private ArrayList<Thread> crackerThreads = new ArrayList<Thread>();
    // TODO: Figure out if using 2 * cores is actually the optimal number of threads for a
    //       system or not
    private int cores = Runtime.getRuntime().availableProcessors();
    private final int LINES = 84195;

    // TODO: Implement 2 more hashes
    private String[] hashes = {"MD5", "SHA-256", "SHA-1"};
    
    HashPanel(){
        this.setLayout(new BorderLayout());
        try {
            loadWordlist();
        } catch (Exception e) {
            System.out.println("File not found.");
        }
        // TEXT FIELD SETUP
        inputText = new JTextArea(5, 30);
        inputText.setToolTipText("Input Text Here");
        inputText.setLineWrap(true);

        outputText = new JTextArea(5, 30);
        inputText.setToolTipText("Output Text");
        outputText.setLineWrap(true);
        outputText.setEditable(false);

        JScrollPane inputScroll = new JScrollPane(inputText);
        inputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        inputScroll.setPreferredSize(new Dimension(300, 100));

        JScrollPane outputScroll = new JScrollPane(outputText);
        outputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        outputScroll.setPreferredSize(new Dimension(300, 100));

        // SETTING UP OPTIONS IN CENTER
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
        optionPanel.setAlignmentX(CENTER_ALIGNMENT);
        optionPanel.setAlignmentY(CENTER_ALIGNMENT);

        JComboBox<String> schema = new JComboBox<String>(hashes);
        schema.setMaximumSize(schema.getPreferredSize());
        
        // TODO: Set up separate action listener classes because this is too much
        JButton encrypt = new JButton("Hash");
        encrypt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(schema.getSelectedIndex() == 0){
                    try {
                        String hash = MD5.getMD5(inputText.getText());
                        outputText.setText(hash);
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                }
                if(schema.getSelectedIndex() == 1){
                    try {
                        byte[] hash = SHA256.getSHA(inputText.getText());
                        outputText.setText(SHA256.toHexString(hash));
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                    
                }
                if(schema.getSelectedIndex() == 2){
                    try {
                        String hash = SHA1.getSHA1(inputText.getText());
                        outputText.setText(hash);
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                    
                }
            }
        });
        
        JButton decrypt = new JButton("Brute Force Decrypt");
        decrypt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String hash = inputText.getText();
                if(schema.getSelectedIndex() == 0){
                    try {
                        for (int i = 0; i < cores * 2; i++) {
                            crackers.add(new HashCrackerThread((LINES*i)/(cores*2), (LINES*(i+1)/(cores*2)), 0, hash, wordlist));
                        }
                        for (HashCrackerThread c : crackers) {
                            crackerThreads.add(new Thread(c));
                        }
                        for (Thread t : crackerThreads) {
                            t.start();
                        }
                        for (Thread t : crackerThreads){
                            t.join();
                        }
                        for (HashCrackerThread c : crackers) {
                            if(c.getCracked() != null){outputText.setText(c.getCracked());}
                        }
                    } catch (Exception ex) {
                        System.out.println("Error:" + ex);
                    }
                }
                if(schema.getSelectedIndex() == 1){
                    try {
                        outputText.setText("Not currently implemented.");
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                }
                if(schema.getSelectedIndex() == 2){
                    try {
                        outputText.setText("Not currently implemented.");
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                }
            }
        });

        /**
         * Putting it all together
         */
        encrypt.setAlignmentX(CENTER_ALIGNMENT);
        encrypt.setAlignmentY(CENTER_ALIGNMENT);

        decrypt.setAlignmentX(CENTER_ALIGNMENT);
        encrypt.setAlignmentY(CENTER_ALIGNMENT);

        optionPanel.add(schema);
        optionPanel.add(encrypt);
        optionPanel.add(decrypt);

        add(new JPanel(), BorderLayout.NORTH);
        add(inputScroll, BorderLayout.WEST);
        add(outputScroll, BorderLayout.EAST);
        add(optionPanel, BorderLayout.CENTER);
    }


    // TODO: Using JFileChooser, implement a generalized way to use wordlists from
    //       the user's device. Also add some default wordlists to go with the program,
    //       with an option to choose from them as well.
    private void loadWordlist() throws IOException{
        Scanner fileScan = new Scanner(new File("./dict.txt"));
        while(fileScan.hasNext()){
            wordlist.add(fileScan.nextLine());
        }
    }
}
