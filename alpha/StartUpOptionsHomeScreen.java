/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package alpha;

/**
 *
 * @author user
 */

import javax.swing.*;
import java.awt.*;

public class StartUpOptionsHomeScreen extends JFrame{
    
    private static JLabel topPanelBackgroundImage;
    private static JPanel topRightPanel;
    private static JPanel topLeftPanel;
    private static JPanel middlePanel;
    private static JPanel bottomPanel;
    
    public StartUpOptionsHomeScreen(){
        super();
        setSize(getMaximumSize().width,getMaximumSize().height);
        setLocation(0,0);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topRightPanel = new JPanel(null);
        topLeftPanel = new JPanel(null);
        middlePanel = new JPanel(null);
        bottomPanel = new JPanel(null);
        topPanelBackgroundImage = new JLabel( new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\Wallpapers 1280x800.jpg"));
        topPanelBackgroundImage.setBounds(0,0,1300,300);
        topRightPanel.setBounds(0,0,1300,300);
       // topLeftPanel.setBounds(700,0,800,300);
        middlePanel.setBounds(0,300,1300,100);
        bottomPanel.setBounds(0,400,1300,360);
        topLeftPanel.setBackground(Color.red);
        middlePanel.setBackground(Color.decode("#F5F5F5"));
        bottomPanel.setBackground(Color.decode("#32CD32"));
       // topRightPanel.setBackground(Color.decode("#1E90FF"));
        add(bottomPanel);   
        add(topRightPanel);
        add(middlePanel);
       // add(topLeftPanel);
        topRightPanel.add(topPanelBackgroundImage);
        
        
        
        
        repaint();
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new StartUpOptionsHomeScreen();
    }
    
}
