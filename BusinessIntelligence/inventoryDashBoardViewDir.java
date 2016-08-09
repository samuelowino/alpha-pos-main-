/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package BusinessIntelligence;


/**
 *
 * @author samuel owino
 */
/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;

/**
 *
 * @author samuel owino
 */


public class inventoryDashBoardViewDir extends JPanel {
    
    private static JButton viewItemButton;
    private static JLabel imageIconLabel;
    private static JLabel inventoryLlabel;
    
    public inventoryDashBoardViewDir(int x,int y){
        setSize(240,205);
        setLocation(x,y);
        setBackground(Color.WHITE);
        setLayout(null);
        setBorder( new LineBorder(Color.decode("#696969")));
        
        viewItemButton = new JButton("View");
        imageIconLabel = new JLabel( new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\Users-icon.png"));
        imageIconLabel.setBackground(Color.red);
        inventoryLlabel = new JLabel("Inventory DashBoard");
        
        
        viewItemButton.setBounds(0,160,80,45);
        inventoryLlabel.setBounds(50,130,150,25);
        imageIconLabel.setBounds(50,25,150,100);
        
        viewItemButton.setBackground(Color.decode("#32CD32"));
        viewItemButton.setForeground(Color.WHITE);
        viewItemButton.setFont( new Font("Calibri",Font.BOLD,16));
        viewItemButton.setBorder( new LineBorder(Color.decode("#32cd32")));
        inventoryLlabel.setFont( new Font("Calibri",Font.BOLD,16));
        
        add(viewItemButton);
        add(inventoryLlabel);
        add(imageIconLabel);
        
        repaint();
        setVisible(true);
    }
  
}
