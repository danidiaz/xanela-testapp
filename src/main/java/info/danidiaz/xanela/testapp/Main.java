package info.danidiaz.xanela.testapp;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame();
        frame.setTitle("foo frame");
        frame.getContentPane().setLayout(new BorderLayout());        
        frame.getContentPane().add(new JTextArea(18, 28),BorderLayout.CENTER);
        frame.getContentPane().add(new JButton("foo"),BorderLayout.SOUTH);
        
        JPanel westPanel = new JPanel(new BorderLayout());
        westPanel.add(new JComboBox(new Object [] { "aaa","bbb","cccc"}), BorderLayout.NORTH);
        
        frame.getContentPane().add(westPanel,BorderLayout.EAST);
        frame.getContentPane().add(new JTextField(18),BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
