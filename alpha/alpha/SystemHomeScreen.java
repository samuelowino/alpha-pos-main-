/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package alpha;

/**
 *
 * @author samuel owino
 *
 */
import BusinessIntelligence.BIHomeDirectory;
import static alpha.MainPOSInterface.drugInventoryTransactions;
import static alpha.MainPOSInterface.processPayMentsViewPanel;
import static alpha.MainPOSInterface.splitPane;
import static alpha.MainPOSInterface.suppliersModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import salesinventory.DrugInventoryTransactions;

public class SystemHomeScreen extends JPanel {

    private static JPanel topPanel;
    private static JPanel middlePanel;
    private static JPanel bottomPanel;
    private static JLabel backgroundImageLabel;
    private static JLabel firstStatementLabel;
    private static JLabel secondStatementLabel;
    private static JButton makeNewSaleButton;
    private static JButton expandYourStockButton;
    private static JButton inventoryControlButton;
    private static JButton salesTrackingButton;
    private static JButton suppliersScanningButton;
    private static JButton dashBoardButton;
    private static JButton inventoryTrackingIconLabel;
    private static JButton salesIconTrackingLabel;
    private static JButton suppliersIconScanningLabel;
    private static JButton dashBoardIconLabel;
    private static JLabel easyas123Label;
    private static JButton makeNewPurchaseButton;
    private static JButton sellButton;
    private static JButton joyButton;
    private static JLabel makeNewPurchasesLabel;
    private static JLabel sellProductsLabel;
    private static JLabel getJoyLabel;
    private static JLabel oneLabel;
    private static JLabel twoLabel;
    private static JLabel threeLabel;

    public SystemHomeScreen() {
        super();
        setSize(getMaximumSize().width, getMaximumSize().height);
        setLocation(0, 0);
        setBackground(Color.WHITE);
        setLayout(null);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        backgroundImageLabel = new JLabel(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\Wallpapers 1280x800_2.jpg"));
        backgroundImageLabel.setBounds(0, 0, 1400, 380);
        topPanel = new JPanel(null);
        topPanel.setBounds(0, 0, 1400, 380);

        middlePanel = new JPanel(null);
        middlePanel.setBounds(0, 380, 1400, 100);
        middlePanel.setBackground(Color.decode("#F5F5F5"));
        middlePanel.setBorder(new LineBorder(Color.decode("#C0C0C0")));

        bottomPanel = new JPanel(null);
        bottomPanel.setBounds(0, 480, 1400, 300);
        bottomPanel.setBackground(Color.decode("#66CDAA"));

        firstStatementLabel = new JLabel("Trusted,Affordable and Convenient");
        secondStatementLabel = new JLabel("Pharmacy Point of Sale & Management System");
        makeNewSaleButton = new JButton("MAKE A NEW SALE");
        expandYourStockButton = new JButton("SEE ALL SERVICES");

        firstStatementLabel.setBounds(500, 50, 500, 35);
        secondStatementLabel.setBounds(430, 95, 900, 35);
        makeNewSaleButton.setBounds(565, 185, 210, 50);
        expandYourStockButton.setBounds(565, 260, 210, 50);

        firstStatementLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
        secondStatementLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        makeNewSaleButton.setForeground(Color.WHITE);
        makeNewSaleButton.setBackground(Color.decode("#66CDAA"));
        expandYourStockButton.setBackground(Color.decode("#66CDAA"));
        expandYourStockButton.setForeground(Color.WHITE);
        expandYourStockButton.setBorder(new LineBorder(Color.decode("#66CDAA"), 1, true));
        makeNewSaleButton.setBorder(new LineBorder(Color.decode("#66CDAA"), 1, true));
        makeNewSaleButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        expandYourStockButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

        inventoryControlButton = new JButton("Inventory Control");
        salesTrackingButton = new JButton("Sales Tracking");
        suppliersScanningButton = new JButton("Suppliers Scanning");
        dashBoardButton = new JButton("DashBoard");
        dashBoardIconLabel = new JButton(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\invt.PNG"));
        suppliersIconScanningLabel = new JButton(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\invt.PNG"));
        salesIconTrackingLabel = new JButton(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\invt.PNG"));
        inventoryTrackingIconLabel = new JButton(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\invt.PNG"));

        List<JButton> buttons = Arrays.asList(
                dashBoardButton, suppliersScanningButton, inventoryControlButton, salesTrackingButton
        );
        getGreyBackgroundOnClick(buttons);

        easyas123Label = new JLabel("It's as easy as 1 - 2 - 3");
        easyas123Label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        easyas123Label.setForeground(Color.WHITE);
        easyas123Label.setBounds(550, 50, 400, 30);
        bottomPanel.add(easyas123Label);
        oneLabel = new JLabel("1");
        twoLabel = new JLabel("2");
        threeLabel = new JLabel("3");
        oneLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        twoLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        threeLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        oneLabel.setBounds(400, 110, 20, 20);
        twoLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        twoLabel.setBounds(700, 110, 20, 20);
        threeLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        threeLabel.setBounds(1000, 110, 20, 20);
        oneLabel.setForeground(Color.decode("#2E8B57"));
        twoLabel.setForeground(Color.decode("#2E8B57"));
        threeLabel.setForeground(Color.decode("#2E8B57"));
        makeNewPurchaseButton = new JButton(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\invt.PNG"));
        sellButton = new JButton(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\invt.PNG"));
        joyButton = new JButton(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\joy.PNG"));
        sellButton.setBorder(new LineBorder(Color.decode("#66CDAA")));
        joyButton.setBorder(new LineBorder(Color.decode("#66CDAA")));
        makeNewPurchaseButton.setBorder(new LineBorder(Color.decode("#66CDAA")));
        makeNewPurchasesLabel = new JLabel("Re-Stock");
        sellProductsLabel = new JLabel("Sell");
        getJoyLabel = new JLabel("Joy");
        makeNewPurchasesLabel.setFont(new Font("New Times Roman", Font.BOLD, 16));
        sellProductsLabel.setFont(new Font("New Times Roman", Font.BOLD, 16));
        getJoyLabel.setFont(new Font("New Times Roman", Font.BOLD, 16));
        makeNewPurchasesLabel.setForeground(Color.WHITE);
        sellProductsLabel.setForeground(Color.WHITE);
        getJoyLabel.setForeground(Color.WHITE);

        makeNewPurchaseButton.setBounds(380, 150, 50, 50);
        sellButton.setBounds(680, 150, 50, 50);
        joyButton.setBounds(980, 150, 50, 50);
        makeNewPurchasesLabel.setBounds(370, 200, 150, 30);
        sellProductsLabel.setBounds(690, 200, 100, 30);
        getJoyLabel.setBounds(995, 200, 100, 30);

        bottomPanel.add(oneLabel);
        bottomPanel.add(twoLabel);
        bottomPanel.add(threeLabel);
        bottomPanel.add(makeNewPurchaseButton);
        bottomPanel.add(sellButton);
        bottomPanel.add(joyButton);
        bottomPanel.add(makeNewPurchasesLabel);
        bottomPanel.add(sellProductsLabel);
        bottomPanel.add(getJoyLabel);

        inventoryTrackingIconLabel.setBounds(140, 20, 50, 50);
        inventoryControlButton.setBounds(190, 20, 200, 50);
        salesIconTrackingLabel.setBounds(400, 20, 50, 50);
        salesTrackingButton.setBounds(450, 20, 200, 50);
        suppliersIconScanningLabel.setBounds(670, 20, 50, 50);
        suppliersScanningButton.setBounds(720, 20, 200, 50);
        dashBoardIconLabel.setBounds(950, 20, 50, 50);
        dashBoardButton.setBounds(1000, 20, 200, 50);

        middlePanel.add(inventoryTrackingIconLabel);
        middlePanel.add(inventoryControlButton);
        middlePanel.add(salesTrackingButton);
        middlePanel.add(salesIconTrackingLabel);
        middlePanel.add(suppliersIconScanningLabel);
        middlePanel.add(suppliersScanningButton);
        middlePanel.add(dashBoardButton);
        middlePanel.add(dashBoardIconLabel);

        topPanel.add(firstStatementLabel);
        topPanel.add(secondStatementLabel);
        topPanel.add(makeNewSaleButton);
        topPanel.add(expandYourStockButton);

        topPanel.add(backgroundImageLabel);
        add(bottomPanel);
        add(middlePanel);
        add(topPanel);
        repaint();
        setVisible(true);
        
        dashBoardButton.addActionListener( e -> {
            JOptionPane.showMessageDialog(null,"Under Consruction Preview");
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            splitPane.setRightComponent( new BIHomeDirectory());
            splitPane.setDividerLocation(1);
            
        });
        
         dashBoardIconLabel.addActionListener( e -> {
            JOptionPane.showMessageDialog(null,"Under Consruction Preview");
        });
        
        suppliersScanningButton.addActionListener( e -> {
        
            MainPOSInterface.retrieveTableData("SELECT * FROM suppliers;", suppliersModel, "Suppliers Table", "suppliers");
            MainPOSInterface.suppliersPatientTotalLabel.setText("Total: " + suppliersModel.getRowCount() + "  Records Found");
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            MainPOSInterface.suppliersInfoViewPanel.setBackground(Color.WHITE);
            MainPOSInterface.suppliersInfoViewPanel.add(MainPOSInterface.backgroundImageLabel);
            splitPane.setRightComponent(MainPOSInterface.suppliersInfoViewPanel);
            splitPane.setDividerLocation(1);
        
        });

        suppliersIconScanningLabel.addActionListener(e -> {
            MainPOSInterface.retrieveTableData("SELECT * FROM suppliers;", suppliersModel, "Suppliers Table", "suppliers");
            MainPOSInterface.suppliersPatientTotalLabel.setText("Total: " + suppliersModel.getRowCount() + "  Records Found");
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            MainPOSInterface.suppliersInfoViewPanel.setBackground(Color.WHITE);
            MainPOSInterface.suppliersInfoViewPanel.add(MainPOSInterface.backgroundImageLabel);
            splitPane.setRightComponent(MainPOSInterface.suppliersInfoViewPanel);
            splitPane.setDividerLocation(1);
            
        });

        inventoryTrackingIconLabel.addActionListener(e -> {
           
            MainPOSInterface.retrieveTableData("SELECT ID,name,purchasePrice,qty,sellPrice,Category,timeRemaining,Status,Details FROM drugs;", MainPOSInterface.stockTabelModel, "stocks Table", "drugs");
            MainPOSInterface.inventoryViewPanel.add(MainPOSInterface.backgroundImageLabel);
            replaceRightComponentOnSplitPane(MainPOSInterface.inventoryViewPanel);
            DrugInventoryTransactions.removeZeroQtyItemsFromStock();
            MainPOSInterface.inventoryTotalLabel.setText("Total:" + MainPOSInterface.stockTabelModel.getRowCount() + "  Records Found");
            splitPane.setRightComponent(MainPOSInterface.inventoryViewPanel);
            splitPane.setDividerLocation(1);
            repaint();
        });

        inventoryControlButton.addActionListener(event -> {
            MainPOSInterface.retrieveTableData("SELECT ID,name,purchasePrice,qty,sellPrice,Category,timeRemaining,Status,Details FROM drugs;", MainPOSInterface.stockTabelModel, "stocks Table", "drugs");
            MainPOSInterface.inventoryViewPanel.add(MainPOSInterface.backgroundImageLabel);
            replaceRightComponentOnSplitPane(MainPOSInterface.inventoryViewPanel);
            DrugInventoryTransactions.removeZeroQtyItemsFromStock();
            MainPOSInterface.inventoryTotalLabel.setText("Total:" + MainPOSInterface.stockTabelModel.getRowCount() + "  Records Found");
            splitPane.setRightComponent(MainPOSInterface.inventoryViewPanel);
            repaint();

        });
        salesTrackingButton.addActionListener(event -> {
           
            MainPOSInterface.retrieveTableData("SELECT * FROM salesInvoice;", MainPOSInterface.invoiceTableModel, "Inventory Table", "salesinvoice");
            MainPOSInterface.statementLineOneLabel.setText("Total: " + MainPOSInterface.invoiceTableModel.getRowCount() + "  Records  Found");
            MainPOSInterface.statementLineFourLabel.setText("Total Profit =" + MainPOSInterface.drugInventoryTransactions.getTotalprofitFromSales());
            MainPOSInterface.statementLineTwoLabel.setText("Total Sales = " + MainPOSInterface.drugInventoryTransactions.getTotalSales());
            MainPOSInterface.statementLineOneLabel.setText("Total: " + MainPOSInterface.invoiceTableModel.getRowCount() + "  Records  Found");
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            MainPOSInterface.inveicePanel.setBackground(Color.WHITE);
            MainPOSInterface.inveicePanel.add(MainPOSInterface.backgroundImageLabel);
            splitPane.setRightComponent(MainPOSInterface.inveicePanel);
            splitPane.setDividerLocation(1);

        });

        salesIconTrackingLabel.addActionListener(e -> {
            MainPOSInterface.retrieveTableData("SELECT * FROM salesInvoice;", MainPOSInterface.invoiceTableModel, "Inventory Table", "salesinvoice");
            MainPOSInterface.statementLineOneLabel.setText("Total: " + MainPOSInterface.invoiceTableModel.getRowCount() + "  Records  Found");
            MainPOSInterface.statementLineFourLabel.setText("Total Profit =" + MainPOSInterface.drugInventoryTransactions.getTotalprofitFromSales());
            MainPOSInterface.statementLineTwoLabel.setText("Total Sales = " + MainPOSInterface.drugInventoryTransactions.getTotalSales());
            MainPOSInterface.statementLineOneLabel.setText("Total: " + MainPOSInterface.invoiceTableModel.getRowCount() + "  Records  Found");
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            MainPOSInterface.inveicePanel.setBackground(Color.WHITE);
            MainPOSInterface.inveicePanel.add(MainPOSInterface.backgroundImageLabel);
            splitPane.setRightComponent(MainPOSInterface.inveicePanel);
            splitPane.setDividerLocation(1);
        });

        makeNewSaleButton.addActionListener((ActionEvent event) -> {
           
            MainPOSInterface.selectCategoryCombo = new JComboBox<>(drugInventoryTransactions.getCategories());
            MainPOSInterface.selectCategoryCombo.setBounds(510, 25, 200, 40);
            MainPOSInterface.processPayMentsViewPanel.add(MainPOSInterface.selectCategoryCombo);
            MainPOSInterface.selectCategoryCombo.setSelectedItem("Painkiller");
            MainPOSInterface.selectItemsCombo = new JComboBox<>(drugInventoryTransactions.getDrugNamesList(MainPOSInterface.selectCategoryCombo.getSelectedItem().toString()));
            MainPOSInterface.selectItemsCombo.setBounds(720, 25, 200, 40);
            MainPOSInterface.categoriesComboBoxEvents();
            MainPOSInterface.processPayMentsViewPanel.add(MainPOSInterface.backgroundImageLabel);
            MainPOSInterface.processPayMentsViewPanel.add(MainPOSInterface.selectItemsCombo);
            repaint();
            
            replaceRightComponentOnSplitPane(MainPOSInterface.processPayMentsViewPanel);
            splitPane.setDividerLocation(1);
        });

        makeNewSaleButton.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent event) {
                        makeNewSaleButton.setBackground(Color.white);
                        makeNewSaleButton.setForeground(Color.decode("#66CDAA"));
                    }

                    @Override
                    public void mouseExited(MouseEvent event) {
                        makeNewSaleButton.setForeground(Color.WHITE);
                        makeNewSaleButton.setBackground(Color.decode("#66CDAA"));
                    }
                }
        );

        expandYourStockButton.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent event) {
                        expandYourStockButton.setBackground(Color.white);
                        expandYourStockButton.setForeground(Color.decode("#66CDAA"));
                    }

                    @Override
                    public void mouseExited(MouseEvent event) {
                        expandYourStockButton.setForeground(Color.WHITE);
                        expandYourStockButton.setBackground(Color.decode("#66CDAA"));
                    }
                }
        );

    }

    public final void getGreyBackgroundOnClick(List<JButton> buttons) {
        buttons.stream()
                .forEach(e -> {
                    e.setBorder(new LineBorder(Color.decode("#F5F5F5")));
                    e.setForeground(Color.decode("#808080"));
                    e.setBackground(Color.decode("#F5F5F5"));
                    e.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
                    e.addMouseListener(
                            new MouseAdapter() {
                                @Override
                                public void mouseEntered(MouseEvent event) {
                                    e.setBackground(Color.decode("#F5F5F5"));
                                    e.setForeground(Color.decode("#1E90FF"));
                                }

                                @Override
                                public void mouseExited(MouseEvent event) {
                                    e.setBackground(Color.decode("#F5F5F5"));
                                    e.setForeground(Color.decode("#808080"));
                                }

                                @Override
                                public void mouseClicked(MouseEvent event) {
                                    e.setBackground(Color.decode("#F5F5F5"));
                                }
                            }
                    );
                });
    }

    public final void replaceRightComponentOnSplitPane(JPanel newReplaceablePanel) {

        splitPane.remove(splitPane.getRightComponent());
        repaint();
        newReplaceablePanel.setBackground(Color.WHITE);
        splitPane.setRightComponent(newReplaceablePanel);
        splitPane.setDividerLocation(1);
        repaint();
    }
}
