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

public class HashPanel extends JPanel{
    private JTextArea inputText; 
    private JTextArea outputText;
    private String[] hashes = {"MD5", "SHA-256"};
    
    HashPanel(){
        this.setLayout(new BorderLayout());

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
                        outputText.setText(MD5.getMd5(inputText.getText()));
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
            }
        });
        
        JButton decrypt = new JButton("Brute Force Decrypt");
        decrypt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(schema.getSelectedIndex() == 0){
                    if(schema.getSelectedIndex() == 0){
                        try {
                            
                            
                        } catch (Exception ex) {
                            outputText.setText("Error:" + ex);
                        }
                    }
                }
                if(schema.getSelectedIndex() == 1){
                    try {
                        
                        
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
}
