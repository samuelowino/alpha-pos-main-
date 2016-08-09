/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package BusinessIntelligence;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author user
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;

/**
 *
 * @author Timothy
 */
public class RightSideCompanySnapshotPanel extends JPanel {
    
    private static JLabel panelTitleLabel;
    private static JLabel statementOneLabel;
    private static JLabel statementTwoLabel;
    private static JLabel statementThreeLabel;
    private static JLabel statementFourLabel;
    private static JLabel statementFiveLabel;
    private static JLabel statementSixLabel;
    private static JLabel employeesValueLabel;
    private static JLabel payrollRunsLabels;
    private static JLabel payrollRunValueLabels;
    private static JLabel paidEmployeesLabel;
    private static JLabel paidEmloyeeValueLabel;
    private static JLabel paidInTaxesLabel;
    private static JLabel paidInTaxesValueLabel;
    private static JLabel bottomStatementOneLabel;
    private static JLabel bottomStatementTwoLabel;
    private static JButton sendANoteButton;
    
    public RightSideCompanySnapshotPanel(int x,int y){
       
        setSize(250,345);
        setLocation(x,y);
        setLayout(null);
        setBackground(Color.decode("#f5f5f5"));
        
        panelTitleLabel = new JLabel("Your Pharamacy  is delightfull!");
        statementOneLabel = new JLabel("Thank you for being an Alpha customer.");
        statementTwoLabel = new JLabel("Below are some quick pharmacy-sales stats about");
        statementThreeLabel = new JLabel("your company for this year.");
        statementFourLabel = new JLabel("Customer since");
        statementFiveLabel = new JLabel("01/12/2016");
        
        statementSixLabel = new JLabel("Total number of employees");
        employeesValueLabel = new JLabel("7");
        payrollRunsLabels = new JLabel("Total sales made");
        payrollRunValueLabels = new JLabel("2");
        paidEmployeesLabel = new JLabel("Total net earned as profit");
        paidEmloyeeValueLabel = new JLabel("$0.00");
        paidInTaxesLabel = new JLabel("Total paid in taxes");
        paidInTaxesValueLabel = new JLabel("$0.00");
        
        bottomStatementOneLabel = new JLabel("If you have any question or feedback,");
        bottomStatementTwoLabel = new JLabel("please");
        sendANoteButton = new JButton("send us a note.");
        
        List<JLabel> statementLabels = Arrays.asList(
                statementFiveLabel,statementFourLabel,statementOneLabel,statementSixLabel
                ,statementThreeLabel,statementTwoLabel,employeesValueLabel,
                payrollRunValueLabels,payrollRunsLabels,paidEmloyeeValueLabel,
                paidEmployeesLabel,paidInTaxesLabel,paidInTaxesValueLabel,
                bottomStatementOneLabel,bottomStatementTwoLabel
        );
        
        setStatementLabelsProperties(statementLabels);
        sendANoteButton.setBackground(Color.decode("#F5F5F5"));
        sendANoteButton.setBorder( new LineBorder(Color.decode("#F5F5F5")));
        sendANoteButton.setForeground(Color.decode("#1E90FF"));
        panelTitleLabel.setForeground(Color.decode("#a9a9a9"));
        
        panelTitleLabel.setBounds(20,10,300,25);
        statementOneLabel.setBounds(20,40,300,25);
        statementTwoLabel.setBounds(20,55,300,25);
        statementThreeLabel.setBounds(20,70,300,25);
        statementFourLabel.setBounds(20,85,300,25);
        statementFiveLabel.setBounds(20,100,300,25);
        statementSixLabel.setBounds(20,125,300,25);
        employeesValueLabel.setBounds(20,145,300,25);
        payrollRunsLabels.setBounds(20,170,300,25);
        payrollRunValueLabels.setBounds(20,190,300,25);
        paidEmployeesLabel.setBounds(20,210,300,25);
        paidEmloyeeValueLabel.setBounds(20,230,300,25);
        bottomStatementOneLabel.setBounds(20,295,300,25);
        bottomStatementTwoLabel.setBounds(20,315,100,25);
        sendANoteButton.setBounds(55,315,120,25);
        paidInTaxesLabel.setBounds(20,255,300,25);
        paidInTaxesValueLabel.setBounds(20,275,300,25);
        
        
        add(panelTitleLabel);
        add(sendANoteButton);
  
    }
    public final  void setStatementLabelsProperties(List<JLabel> statementLabels){
        statementLabels.stream()
                .forEach( e -> {
                    e.setForeground(Color.decode("#696969"));
                    e.setFont( new Font("Calibri",Font.BOLD,13));
                    add(e);
                });
    }
}

