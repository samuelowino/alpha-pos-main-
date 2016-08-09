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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author samuel owino
 */
public class BIHomeDirectory extends JPanel {

    private static JPanel dashBoardTitlePanel;
    private static JPanel categorySelectionPanel;
    private static JPanel categoriesPanel;
    private static JLabel dashBoardTitleLabel;
    private static JLabel statementOneLabel;
    private static JLabel statementTwoLabel;
    private static JLabel statementThreeLabel;
    private static JLabel selectCategoryLabel;
    private static JButton greyLineButton;
    private static JButton customersButton;
    private static JButton salesButton;
    private static JButton inventoryButton;
    private static JButton suppliersButton;
    private static JButton employeesButton;
    private static JButton systemLogsButton;
    private static JButton secondGreyLineButton;
    private static CustomersDashBoardOptionPanel customersDashBoardOptionPanel;
    private static RightSideCompanySnapshotPanel rightSideCompanySnapshotPanel;

    public BIHomeDirectory() {

        setSize(1200, 800);
        setLocation(0, 0);
        setLayout(null);
        setBackground(Color.WHITE);

        rightSideCompanySnapshotPanel = new RightSideCompanySnapshotPanel(950, 60);
        customersDashBoardOptionPanel = new CustomersDashBoardOptionPanel(50, 40);
        dashBoardTitlePanel = new JPanel(null);
        categorySelectionPanel = new JPanel(null);
        categoriesPanel = new JPanel(null);
        dashBoardTitleLabel = new JLabel("Dashboard");
        statementOneLabel = new JLabel("Alpha DashBoard offers you a friendly easy way to");
        statementTwoLabel = new JLabel("Access and use quick snapshot of your Hospital Pharmacy's State state.");
        statementThreeLabel = new JLabel("Select a Category to view analysis");
        selectCategoryLabel = new JLabel("Select category: Click to view");
        greyLineButton = new JButton();
        secondGreyLineButton = new JButton();

        customersButton = new JButton("Customers");
        salesButton = new JButton("Sales");
        inventoryButton = new JButton("Inventory");
        suppliersButton = new JButton("Suppliers");
        employeesButton = new JButton("Employees");
        systemLogsButton = new JButton("System Logs");

        dashBoardTitleLabel.setFont(new Font("Calibri Light", Font.BOLD, 22));
        dashBoardTitleLabel.setBounds(20, 15, 300, 30);
        greyLineButton.setBackground(Color.decode("#f5f5f5"));
        greyLineButton.setBounds(20, 50, 909, 2);
        greyLineButton.setEnabled(false);
        secondGreyLineButton.setBackground(Color.decode("#1E90FF"));
        secondGreyLineButton.setEnabled(false);
        secondGreyLineButton.setBounds(10, 30, 880, 2);

        statementOneLabel.setBounds(20, 100, 909, 25);
        statementTwoLabel.setBounds(20, 130, 909, 25);
        statementThreeLabel.setBounds(20, 160, 909, 25);
        categoriesPanel.setBounds(20, 200, 909, 550);
        selectCategoryLabel.setBounds(10, 2, 400, 25);
        selectCategoryLabel.setFont(new Font("Calibri Light", Font.BOLD, 16));

        categoriesPanel.setBorder(new LineBorder(Color.black));
        categoriesPanel.setBackground(Color.WHITE);
        categoriesPanel.add(selectCategoryLabel);
        categoriesPanel.add(secondGreyLineButton);
        categoriesPanel.add(customersDashBoardOptionPanel);
        categoriesPanel.add(new SalesDashBoardViewDir(330, 40));
        categoriesPanel.add(new inventoryDashBoardViewDir(610, 40));
        categoriesPanel.add(new suppliersDashBoardViewDir(50, 280));
        categoriesPanel.add(new EmployeesDashBoardViewDir(330, 280));
        categoriesPanel.add(new SystemLogsDashBoardViewDir(610, 280));

        List<JButton> navigationButtons = Arrays.asList(
                customersButton, salesButton, inventoryButton, suppliersButton, employeesButton, systemLogsButton
        );

        List<JLabel> statementLabels = Arrays.asList(
                statementOneLabel, statementTwoLabel, statementThreeLabel
        );

        setTextProperties(statementLabels);

        setButtonProperties(navigationButtons);

        add(categoriesPanel);
        add(dashBoardTitleLabel);
        add(greyLineButton);
        add(rightSideCompanySnapshotPanel);

    }

    public final void setButtonProperties(List<JButton> navigationButtons) {
        navigationButtons.stream()
                .forEach(e -> {
                    e.setBackground(Color.decode("#1E90FF"));
                    e.setBorder(new LineBorder(Color.decode("#1e90ff")));
                    e.setForeground(Color.WHITE);
                    e.setFont(new Font("Calibri Light", Font.BOLD, 14));
                    add(e);
                });
    }

    public final void setTextProperties(List<JLabel> statementLabels) {
        statementLabels.stream()
                .forEach(e -> {
                    e.setForeground(Color.decode("#808080"));
                    e.setFont(new Font("Calibri Light", Font.PLAIN, 16));
                    add(e);

                });
    }

  
}
