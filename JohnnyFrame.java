import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
/**
 * This class handles the GUI for John the Child
 */
public class JohnnyFrame extends JFrame{
    private JTextArea inputText; 
    private JTextArea outputText;

    public JohnnyFrame(){
        setBounds(200,0,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        inputText = new JTextArea(5, 30);
        inputText.setLineWrap(true);

        outputText = new JTextArea(5, 30);
        outputText.setLineWrap(true);
        outputText.setEditable(false);

        JScrollPane inputScroll = new JScrollPane(inputText);
        inputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        inputScroll.setPreferredSize(new Dimension(200, 100));

        JScrollPane outputScroll = new JScrollPane(outputText);
        outputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        outputScroll.setPreferredSize(new Dimension(200, 100));

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
        
        JButton encode = new JButton("Encode");
        JButton decode = new JButton("Decode");

        optionPanel.add(encode, CENTER_ALIGNMENT);
        optionPanel.add(decode, CENTER_ALIGNMENT);

        contentPane.add(new JPanel(), BorderLayout.NORTH);
        contentPane.add(inputScroll, BorderLayout.LINE_START);
        contentPane.add(outputScroll, BorderLayout.LINE_END);
        contentPane.add(optionPanel, BorderLayout.CENTER);
        contentPane.add(new JPanel(), BorderLayout.SOUTH);

    }
}

