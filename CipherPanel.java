import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class CipherPanel extends JPanel{
    private JTextArea inputText; 
    private JTextArea outputText;
    private JTextField alphabetInput;
    private JTextField keyInput;
    private String[] ciphers = {"Caesar", "ROT-13", "ROT-47", "Vigenere"};
    
    CipherPanel(){
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
        optionPanel.setLayout(new GridLayout(7,1));

        JComboBox<String> schema = new JComboBox<String>(ciphers);
        schema.setMaximumSize(schema.getPreferredSize());

        alphabetInput = new JTextField(30);
        alphabetInput.setMaximumSize(alphabetInput.getPreferredSize());
        alphabetInput.setToolTipText("Custom Alphabet");

        keyInput = new JTextField(10);
        keyInput.setMaximumSize(keyInput.getPreferredSize());
        keyInput.setToolTipText("Key");
        
        // TODO: Set up separate action listener classes because this is too much
        JButton encode = new JButton("Encode");
        encode.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(schema.getSelectedIndex() == 0){
                    try {
                        int key = Integer.parseInt(keyInput.getText());
                        CaesarCipher cracker = new CaesarCipher(key, alphabetInput.getText());
                        outputText.setText(cracker.encode(inputText.getText()));
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                }
                if(schema.getSelectedIndex() == 1){
                    try {
                        CaesarCipher cracker = new CaesarCipher(13, alphabetInput.getText());
                        outputText.setText(cracker.encode(inputText.getText()));
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                    
                }
                if(schema.getSelectedIndex() == 2){
                    try {
                        ROT47 cracker = new ROT47();
                        outputText.setText(cracker.encode(inputText.getText()));
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                    
                }
                if(schema.getSelectedIndex() == 3){
                    try {
                        String key = String.valueOf(keyInput.getText());
                        VigenereCipher cracker = new VigenereCipher(key, alphabetInput.getText());
                        outputText.setText(cracker.encode(inputText.getText()));
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                    
                }
            }
        });
        
        JButton decode = new JButton("Decode");
        decode.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    if(schema.getSelectedIndex() == 0){
                        try {
                            int key = Integer.parseInt(keyInput.getText());
                            CaesarCipher cracker = new CaesarCipher(key, alphabetInput.getText());
                            outputText.setText(cracker.decode(inputText.getText()));
                        } catch (Exception ex) {
                            outputText.setText("Error:" + ex);
                        }
                    }
                if(schema.getSelectedIndex() == 1){
                    try {
                        CaesarCipher cracker = new CaesarCipher(13);
                        outputText.setText(cracker.decode(inputText.getText()));
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                }
                if(schema.getSelectedIndex() == 2){
                    try {
                        ROT47 cracker = new ROT47();
                        outputText.setText(cracker.decode(inputText.getText()));
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                }
                if(schema.getSelectedIndex() == 3){
                    try {
                        String key = String.valueOf(keyInput.getText());
                        VigenereCipher cracker = new VigenereCipher(key, alphabetInput.getText());
                        outputText.setText(cracker.decode(inputText.getText()));
                    } catch (Exception ex) {
                        outputText.setText("Error:" + ex);
                    }
                }
            }
        });

        /**
         * Putting it all together
         */
        
        optionPanel.add(schema);
        optionPanel.add(encode);
        optionPanel.add(decode);
        optionPanel.add(new JLabel("Custom Alphabet"));
        optionPanel.add(alphabetInput);
        optionPanel.add(new JLabel("Key"));
        optionPanel.add(keyInput);

        encode.setAlignmentX(CENTER_ALIGNMENT);
        encode.setAlignmentY(CENTER_ALIGNMENT);
        decode.setAlignmentX(CENTER_ALIGNMENT);
        decode.setAlignmentY(CENTER_ALIGNMENT);
        alphabetInput.setAlignmentX(CENTER_ALIGNMENT);
        alphabetInput.setAlignmentY(CENTER_ALIGNMENT);
        keyInput.setAlignmentX(CENTER_ALIGNMENT);
        keyInput.setAlignmentY(CENTER_ALIGNMENT);
        
        optionPanel.setAlignmentX(CENTER_ALIGNMENT);
        optionPanel.setAlignmentY(CENTER_ALIGNMENT);

        add(new JPanel(), BorderLayout.NORTH);
        add(inputScroll, BorderLayout.WEST);
        add(outputScroll, BorderLayout.EAST);
        add(optionPanel, BorderLayout.CENTER);
    }
}
