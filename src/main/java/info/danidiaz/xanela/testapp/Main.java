package info.danidiaz.xanela.testapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
        final JFrame frame = new JFrame();
        frame.setTitle("foo frame");
        frame.getContentPane().setLayout(new BorderLayout());        
        frame.getContentPane().add(new JTextArea(18, 28),BorderLayout.CENTER);
        JButton fooButton = new JButton("foo");
        fooButton.setToolTipText("foo tooltip");
        fooButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                createAndShowDialog(frame);
            }
        });
        frame.getContentPane().add(fooButton,BorderLayout.SOUTH);
        
        JPanel westPanel = new JPanel(new GridLayout(6,1));
        westPanel.add(new JComboBox(new Object [] { "aaa","bbb","cccc"}));
        westPanel.add(new JCheckBox("This is a checkbox"));
        westPanel.add(new JLabel("This is a label"));
        
                
        JMenu menu = new JMenu("Menu1");
        JMenuItem item1 = new JMenuItem("item1"); 
        JMenuItem item2 = new JMenuItem("item2");        
        menu.add(item1);
        menu.add(item2);
        JMenu subMenu = new JMenu("SubMenu1");        
        subMenu.add(new JMenuItem("submenuitem1"));
        subMenu.add(new JCheckBoxMenuItem("submenuitem2"));
        menu.add(subMenu);         
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
  
        frame.getContentPane().add(westPanel,BorderLayout.EAST);
        frame.getContentPane().add(new JTextField(18),BorderLayout.NORTH);
        frame.setJMenuBar(menuBar);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static void createAndShowDialog(JFrame frame) {
        final JDialog dialog = new JDialog(frame,true);
        dialog.setTitle("foo dialog");
        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add(new JTextArea(18, 10),BorderLayout.CENTER);
        JButton dialogButton = new JButton("dialog button");
        dialogButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                
            }
        });
        dialog.getContentPane().add(dialogButton,BorderLayout.NORTH);
        //Display the window.
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);        
    }
}
