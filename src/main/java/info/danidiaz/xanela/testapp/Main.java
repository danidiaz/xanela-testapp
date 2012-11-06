package info.danidiaz.xanela.testapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Hello world!
 *
 */
public class Main 
{
    private final JTextField tf = new JTextField(18);   
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main().createAndShowGUI();
            }
        });
    }
        
    private JPanel createTabOne(final JFrame parentFrame) {
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        mainPanel.add(new JTextArea(18, 28),BorderLayout.CENTER);
        JButton fooButton = new JButton("foo");
        fooButton.setToolTipText("foo tooltip");
        fooButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new Main().createAndShowDialog(parentFrame);
            }
        });
        mainPanel.add(fooButton,BorderLayout.SOUTH);
        
        JPanel westPanel = new JPanel(new GridLayout(6,1));
        westPanel.add(new JComboBox(new Object [] { "aaa","bbb","ccc",
                "ddd",
                "eee",
                "fff",
                "ggg",
                "hhh",
                "iii",
                "111",
                "222",
                "333"                
            }));
        westPanel.add(new JCheckBox("This is a checkbox"));
        
        
        JLabel label = new JLabel("This is a label");
        
        final JPopupMenu popup = new JPopupMenu();
        JMenuItem popupitem1 = new JMenuItem("popupitem1"); 
        JMenuItem popupitem2 = new JMenuItem("popupitem2");
        popup.add(popupitem1);
        popup.add(popupitem2);
        label.addMouseListener(new  MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e){
                if (e.isPopupTrigger())
                    doPop(e);
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if (e.isPopupTrigger())
                    doPop(e);
            }

            private void doPop(MouseEvent e){                
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
             
        });
      
        westPanel.add(label);  
  
        mainPanel.add(westPanel,BorderLayout.EAST);
        mainPanel.add(tf,BorderLayout.NORTH); 
        
        return mainPanel;
    }
    
    private JPanel createTabTwo(final JFrame parentFrame) {
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        JTable table = new JTable(new DefaultTableModel(               
                    new Object[][] {
                            new Object[] { "row1", 2, 3  },
                            new Object[] { "row2", 4 , 6 },
                            new Object[] { "row3", 6 , 7 },
                    },                
                    
                    new Object[] { "col1", "col2", "col3" }                              
                ));
        mainPanel.add(table,BorderLayout.CENTER);
        return mainPanel;
    }

    
    private void createAndShowGUI() {
        //Create and set up the window.
        final JFrame frame = new JFrame();
        frame.setTitle("foo frame");
        
        frame.getContentPane().setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("tab one", createTabOne(frame));
        tabbedPane.setToolTipTextAt(0, "tooltip for tab one");
        tabbedPane.addTab("tab two", createTabTwo(frame));
        tabbedPane.setToolTipTextAt(1, "tooltip for tab two");

        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
                     
        
        JMenu menu = new JMenu("Menu1");
        JMenuItem item1 = new JMenuItem("item1"); 
        JMenuItem item2 = new JMenuItem("item2");        
        menu.add(item1);
        menu.add(item2);
        JMenu subMenu = new JMenu("SubMenu1");     
        JMenuItem menuitem1 = new JMenuItem("submenuitem1");
        menuitem1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tf.setText("nananiero nananiero nananiero");
                
            }
        });
        subMenu.add(menuitem1);
        subMenu.add(new JCheckBoxMenuItem("submenuitem2"));
        menu.add(subMenu);         
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
        
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void createAndShowDialog(JFrame frame) {
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
