import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Container;
import java.awt.BorderLayout;
/**
 * This class handles the GUI for John the Child
 */
public class JohnnyFrame extends JFrame{
    
    public JohnnyFrame(){
        JTabbedPane tabbedPane = new JTabbedPane();

        setBounds(200,0,800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        tabbedPane.addTab("Encoding Panel", new EncodingPanel());
        tabbedPane.addTab("Hashes Panel", new JPanel());

        JPanel infoPanel = new JPanel();

        JButton helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame();
                JLabel l = new JLabel(Help.displayHelp());
                JDialog d = new JDialog(f, "Help");
                d.add(l);
                d.setSize(400, 400);
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
                d.add(l);
                d.setSize(400, 400);
                d.setVisible(true);
            }
        });

        infoPanel.add(helpButton);
        infoPanel.add(infoButton);

        contentPane.add(tabbedPane, BorderLayout.CENTER);
        contentPane.add(infoPanel, BorderLayout.SOUTH);
    }
}
