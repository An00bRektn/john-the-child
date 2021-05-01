import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Container;
import java.awt.BorderLayout;
/**
 * This class handles the GUI for John the Child
 */
public class JohnnyFrame extends JFrame{
    
    public JohnnyFrame(){
        // enables menus in the form of tabbing
        JTabbedPane tabbedPane = new JTabbedPane(); 
        Image icon = Toolkit.getDefaultToolkit().getImage("./imgs/johnTheChild.jpg");

        setBounds(200,0,800,450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // See respective .java files for detailed look
        tabbedPane.addTab("Encode/Decode", new CipherPanel());
        tabbedPane.addTab("Hashing", new HashPanel());

        JPanel infoPanel = new JPanel(); // holds help and info buttons

        JButton helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame();
                JLabel l = new JLabel(Help.displayHelp());
                JDialog d = new JDialog(f, "Help");
                d.setIconImage(icon);
                d.add(l);
                d.setSize(600, 450);
                d.setVisible(true);  
            }           
        });

        JButton infoButton = new JButton("About this Project");
        infoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame();
                JLabel l = new JLabel(Help.displayInfo());
                JDialog d = new JDialog(f, "About");
                Container content = d.getContentPane();
                d.setIconImage(icon);
                content.add(l);
                d.setSize(600, 250);
                d.setVisible(true);
            }
        });

        setIconImage(icon);

        infoPanel.add(helpButton);
        infoPanel.add(infoButton);

        contentPane.add(tabbedPane, BorderLayout.CENTER);
        contentPane.add(infoPanel, BorderLayout.SOUTH);
    }
}
