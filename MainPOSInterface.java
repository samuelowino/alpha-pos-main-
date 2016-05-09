package alpha;

import com.toedter.calendar.JDateChooser;
import customerTracking.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import java.util.List;
import java.util.logging.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import salesinventory.*;
import staffandEmployeeManagement.*;

public class MainPOSInterface extends JFrame {

    private static CustomerTransaction customerTransactions;
    private static DrugInventoryTransactions drugInventoryTransactions;
    private static JButton generateSaleReportsByDateButton;
    private static Connection con;
    private static Statement st;
    private static JLabel drugInventoryLabel;
    private static JMenu suppliers;
    private static DefaultTableModel suppliersModel;
    private static JLabel suppliersInformationLabel;
    private static addCustomerInformation suppliersPatientsEditScreen;
    public static JPanel suppliersPatientsTopPanel;
    public static JPanel suppliersTableComponentsPanel;
    public static JPanel viewsuppliersTableOnlypanel;
    private static JButton addNewsuppliersCustomerButton;
    private static JButton suppliersPrintButton;
    private static JButton suppliersPatientSearchButton;
    private static JButton suppliersSortByButton;
    private static JTextField suppliersPatiientsSearchField;
    private static JComboBox<String> suppliersPatientSortMethodCombo;
    private static JTable suppliersPatientTable;
    private static JScrollPane suppliersPatientTableScrollPane;
    private static JLabel suppliersPatientTotalLabel;

    private static JPanel suppliersInfoViewPanel;
    //------------------------------------------------------------------------------------------------------------------
    private static DefaultTableModel customerModel;
    private static DefaultTableModel invoiceTableModel;
    private static DefaultTableModel stockTabelModel;
    private static JMenu salesReportsMenu;
    private static JMenu salesMenu;
    private static JMenu stockMenu;
    private static JMenu reportsMenu;
    private static JMenuItem salesReportsByCategory;
    private static JMenuItem salesReportsByID;
    private static JMenuItem salesReportsBySalesRep;
    private static JMenuItem salesReportsByDate;
    private static salesinventory.SalesTableModel saleTableModel;
    private static Double itemsPrices;
    private static JPanel addNewEmplyeeViewPanel;
    private static JPanel processPayMentsViewPanel;
    //--------------------------------------------------------------------------------------------------------------------------
    private static JButton addItemToSalesButton;
    private static JPanel addNewPatientCustomerViewPanel;
    private static JButton patientsAddPrescriptionDetailsButton;
    private static JPanel patientsTopAddUserPanel;
    private static JPanel patientsEditProfilePanel;
    private static JButton patientsUpdateInfoButton;
    private static JButton patientsAdminButton;
    private static JLabel patientsCustomerInformationLabel;
    private static JLabel patientsFirstNameLabel;
    private static JTextField patientsFirstNameField;
    private static JLabel patientsLastNameLabel;
    private static JTextField patientsLastNameField;
    private static JLabel patientsPhoneLabel;
    private static JTextField patientsPhoneField;
    private static JLabel patientsEmailLabel;
    private static JTextField patientsEmailField;
    private static JLabel patientsPrescriptionDetails;
    private static JTextField patientsPrescriptionDetailsField;
    private static JLabel patientsLastVisitLabel;
    private static JDateChooser patientsLastVisitField;
    private static JLabel patientsNextVistLabel;
    private static JDateChooser patientsNextVistField;
    private static JLabel patientsDiagnosisDetailsLlabel;
    private static JTextArea patientsPatientsDiagnosisField;
    private static JButton patientsUpdateUserDetailsButton;

    //------------------------------------------------------------------------------------------------------------
    private static JPanel viewCustomerInformationDetailsView;
    private static JLabel customerInformationLabel;
    public static JPanel customersPatientsTopPanel;
    public static JPanel customerPatientTableComponentsPanel;
    public static JPanel customerpatientTableOnlypanel;
    private static JButton addNewPatientCustomerButton;
    private static JButton patientCustomerPrintButton;
    private static JButton customerPatientSearchButton;
    private static JButton customerPatientSortByButton;
    private static JTextField customerPatiientsSearchField;
    private static JComboBox<String> customerPatientSortMethodCombo;
    private static JTable customerPatientTable;
    private static JScrollPane customerPatientTableScrollPane;
    private static JLabel customerPatientTotalLabel;

    //-------------------------------------------------------------------------------------------------------------
    private static JLabel selectItemLabel;
    private static JLabel selectQtyLabel;
    private static JLabel selectCategoryLabel;
    private static JComboBox<String> selectItemsCombo;
    private static JComboBox<String> selectCategoryCombo;
    private static JSpinner selectQtySpinner;
    private static double processPayChange;
    private static JPanel processPayZeroCancelpanel;
    private static JPanel processPayTopPayPanel;
    private static JPanel payNumberButtonsPanel;
    private static JPanel payModePanel;
    private static JPanel payTabelPanel;
    private static JPanel reverseStatusPanel;
    private static JLabel payModeLabel;
    private static JLabel amountPaidLabel;
    private static JLabel amountDueLabel;
    private static JLabel changeLabel;
    private static JLabel totalNetLabel;
    private static JComboBox<Object> payModeComboBox;
    private static JTextField amountPaidField;
    private static JTextField amountDueField;
    private static JTextField changeField;
    private static JTextField totalNetField;
    private static JTextArea amountReceivedWindow;
    private static JButton addMoreCashButton;
    private static JButton payOneButton;
    private static JButton payTwoButton;
    private static JButton payThreeButton;
    private static JButton fourButtonPay;
    private static JButton fiveButtonPay;
    private static JButton sixButtonPay;
    private static JButton sevenButtonPay;
    private static JButton eightButtonPay;
    private static JButton nineButtonPay;
    private static JButton zeroButtonPay;
    private static JButton clearFieldButtonPay;
    private static JTable itemsPaymentTablePay;
    private static JScrollPane tableScrollPanePay;
    private static JButton closeButtonPay;
    private static JButton deleteButtonPay;
    private static JButton printButtonPay;
    //------------------------------------------------------------------------------------------------------------
    private static JButton newEmployeebrowseForImageButton;
    private static JLabel newEmployeeprofileImageLabel;
    private static JPanel newEmployeetopAddUserPanel;
    private static JPanel newEmployeeeditProfilePanel;
    private static JButton newEmployeeupdateInfoButton;
    private static JButton newEmployeeadminButton;
    private static JLabel newEmployeeAddNewEmplyeeLabel;
    private static JLabel newEmployeefirstNameLabel;
    private static JTextField newEmployeefirstNameField;
    private static JLabel newEmployeelastNameLabel;
    private static JTextField newEmployeelastNameField;
    private static JLabel newEmployeephoneLabel;
    private static JTextField newEmployeephoneField;
    private static JLabel newEmployeeemailLabel;
    private static JTextField newEmployeeemailField;
    private static JLabel newEmployeesupervisorLabel;
    private static JTextField newEmployeeSupervisorField;
    private static JLabel newEmployeeEmployeeIDoLabel;
    private static JTextField newEmployeeemployeeIDField;
    private static JLabel newEmployeepasswordLabel;
    private static JPasswordField newEmployeepassword;
    private static JLabel newEmployeeconfirmPasswordlabel;
    private static JPasswordField newEmployeeconfirmPasswordField;
    private static JButton newEmployeeupdateUserDetailsButton;
    private static JFileChooser newEmployeeNewEmpfileChooser;

    //------------------------------------------------------------------------------------------------------------
    private static JPanel inventoryViewPanel;
    private static JPanel inventroyViewTopPanel;
    private static JPanel inventoryViewTableComponentsPanel;
    private static JPanel inventoryViewTableOnlypanel;
    private static JButton inventoryViewsaddNewItemButton;
    private static JButton inventoryPrintButton;
    private static JButton inventorySearchButton;
    private static JButton inventorySortByButton;
    private static JTextField inventroySearchField;
    private static JComboBox<String> inventorySortMethodCombo;
    public JTable inventoryItemsTable;
    private static JScrollPane inventoryTableScrollPane;
    private static JLabel inventoryTotalLabel;

    //-------------------------------------------------------------------------------------------------------------
    private static Image image;
    private static File file;
    //-----------------------------------------------------------------------------------------------------------
    private static JPanel orderDetailsMainViewPanel;
    private static JPanel ordersViewTopPanel;
    private static JPanel ordersViewLabelPanel;
    private static JPanel ordersViewTablePanel;
    private static JButton ordersViewsaddCustomerButton;
    private static JButton ordersViewPrintButton;
    private static JLabel ordersViewLabel;
    private static JLabel ordersViewsIconLabel;
    private static JLabel ordersViewNumberOfRecordsLabel;
    private static JButton ordersViewFilterButton;
    private static JTextField ordersViewSearchField;
    private static JButton ordersViewSortByButton;
    private static JComboBox<String> ordersViewSortByCombo;
    private static JTable ordersDetailsViewTabel;
    private static JScrollPane ordersDetailsViewTableScrollPane;

    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    private static JPanel settingsPanel;
    private static JPanel settingsTopPanel;
    private static JButton posSettingsButton;
    private static JLabel pleaseUpdateLabel;
    private static JLabel companyNameLabel;
    private static JTextField companyField;
    private static JLabel companyAddressLabel;
    private static JTextArea companyAddressArea;
    private static JLabel settingsPhoneLabel;
    private static JTextField phoneNumberField;
    private static JLabel emailAddressLabel;
    private static JTextField settingsEmailField;
    private static JLabel webAddresslabel;
    private static JTextField webAddressField;
    private static JLabel vatLabel;
    private static JTextField vatField;
    private static JLabel vatRegistrationNumberLabel;
    private static JTextField vatRegNumberField;
    private static JLabel footerMessageLabel;
    private static JTextArea footerTextArea;
    private static JButton updateSettingButton;

    //--------------------------------------------------------------------------------------------------------------------------------------------------------
    //Reports
    private static JMenuItem salesMenuItem;
    private static JMenuItem taxesMenuItem;
    private static JMenuItem inventoryMenuItem;
    private static JMenuItem invoiceMenuItem;
    private static JMenuItem advancedViewMenuItem;
    //--------------------------------------------------------------------------------------------------------------------------------------------------------
    private static JPanel loansPanelView;
    private static JPanel loanTopPanel;
    private static JPanel loanTableComponentsPanel;
    private static JPanel loanTableOnlypanel;
    private static JButton addNewLoanItemButton;
    private static JButton printLoanButton;
    private static JButton searchLoanButton;
    private static JButton sortLoanByButton;
    private static JTextField searchLoanField;
    private static JComboBox<String> sortLoanMethodCombo;
    private static JTable LoansTable;
    private static JScrollPane loanTableScrollPane;
    private static JLabel loanTotalLabel;
    //-----------------------------------------------------------------------------------------------------
    private static JPanel customersViewPanel;
    private static JPanel shiftsViewPanel;
    private static JPanel topShiftsPanel;
    private static JPanel shiftsLabelPanel;
    private static JPanel shiftsTablePanel;
    private static JButton addCustomerButton;
    private static JButton printShiftsButton;
    private static JLabel customerLabel;
    private static JLabel shiftsIconLabel;
    private static JLabel numberOShiftsfRecordsLabel;
    private static JButton ShiftsfilterButton;
    private static JTextField ShiftsSearchField;
    private static JButton sortAllShiftsButton;
    private static JComboBox<String> sortShiftsByCombo;
    private static JTable customersTabel;
    private static JScrollPane shiftsTableScrollPane;

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    private static JPanel customerTopPanel;
    private static JPanel customersLabelPanel;
    private static JPanel cutomersTablePanel;
    private static JButton addCustomersButton;
    private static JButton printCustomerInfoButton;
    private static JLabel customersLabel;
    private static JLabel customersIconLabel;
    private static JLabel numberOfCustomerRecordsLabel;
    private static JButton filterCustomersButton;
    private static JTextField searchCustomersField;
    private static JButton sortCustomersByButton;
    private static JComboBox<String> sorCustomestByCombo;
    private static JTable customersTabelCustome;
    private static JScrollPane CustomeTableScrollPane;
    //-------------------------------------------------------------------------------------------------------------------------------------------------------
    private static JPanel addNewUserPanelView;
    private static JPanel topAddUserPanel;
    private static JPanel editProfilePanel;
    private static JButton updateInfooButton;
    private static JButton adminButton;
    private static JLabel userProfilelabel;
    private static JLabel firstNameLabel;
    private static JTextField firstNameField;
    private static JLabel lastNameLabel;
    private static JTextField lastNameField;
    private static JLabel phoneLabel;
    private static JTextField phoneField;
    private static JLabel emailLabel;
    private static JTextField emailField;
    private static JLabel supervisorLabel;
    private static JTextField supervisorField;
    private static JLabel oldPasswordLabel;
    private static JPasswordField oldPasswordField;
    private static JLabel passwordLabel;
    private static JPasswordField password;
    private static JLabel confirmPasswordlabel;
    private static JPasswordField confirmPasswordField;
    private static JButton updateUserDetailsButton;
    //Users panel items
    private static JPanel viewUserPanel;
    private static JPanel UserstopPanel;
    private static JPanel userListLabelPanel;
    private static JPanel UsersTablePanel;
    private static JButton addNewUserButton;
    private static JButton addNewTaskButton;
    private static JLabel usersListLabel;
    private static JLabel userListIconLabel;
    private static JLabel numberOfUserRecordsLabel;
    private static JScrollPane userTableScrollPane;
    private static JTable usersTable;

    //------------------------------------------------------------------------------------------------------------------------------------------------
    //EMPLOYEE task VIEW PANEL
    private static JPanel taskListViewPanel;
    private static JPanel topEmployeesPanel;
    private static JPanel tableMainPanel;
    private static JPanel tablePanel;
    private static JButton addTaskButton;
    private static JButton employeeDataPrintButton;
    private static JLabel TaskListLabel;
    private static JLabel customerIconLabel;
    private static JLabel numberOfRecordsLabel;
    private static JButton filterButton;
    private static JTextField EmployeeSearchField;
    private static JButton empSortByButton;
    private static JComboBox sortByCombo;
    private static JTable taskListTable;
    private static JScrollPane employeeTableScrollPane;

    //---------------------------------------------------------------------------------------------------------------------------------------------
    private static JButton sortButton;

    //---------------------------------------------------------------------------------------------------------------------------------------------
    //Clock in/out panels
    private static JPanel clockInAndOutViewPanel;
    private static JComboBox selectCategory;
    private static JLabel restaurantNameLabel;
    private static JButton clockInButton;
    private static JButton clockOutButton;
    private static JButton enterButton;
    private static JPanel enterButtonPanel;
    private static JPanel passwordorIdPanel;
    private static JPanel errorPanel;
    private static JPanel clockInOutPanel;
    private static JButton bottomButton;
    private static JPanel zeroToTenButtonsPanel;
    private static JButton oneButton;
    private static JButton twoButton;
    private static JButton threeButton;
    private static JButton fourButton;
    private static JButton fiveButton;
    private static JButton sixButton;
    private static JButton sevenButton;
    private static JButton eightButton;
    private static JButton nineButton;
    private static JTextArea passwordorIdField;
    private static clockInClockOutTransactions DAO;

    //-------------------------------------------------------------------------------------------------------------------------------------------
    private static JPanel inveicePanel;

    //------------------------------------------------------------------------------------------------------------------------------------------
    private static JPanel topInvoicePanel;
    private static JPanel reportPanel;
    private static JScrollPane reportPanelScrollPane;
    private static JButton todaysSalesButton;
    private static JButton last30DaysReportsButton;
    private static JLabel productIconLabel;
    private static JButton printReportButton;
    private static JLabel searchCategLabel;
    private static JTextField InvoicesearchField;
    private static JDateChooser startDateField;
    private static JDateChooser endDateField;
    private static JTable inventoryTable;
    private static JLabel statementLineOneLabel;
    private static JLabel statementLineTwoLabel;
    private static JLabel statementLineThreeLabel;
    private static JLabel statementLineFourLabel;
    private static JLabel statementLineFiveLabel;
    private static JLabel statementLineSixLabel;
    private static JLabel statementLineSevenLabel;
    private static JLabel statementLineEightLabel;
    private static JLabel statementLineNineLabel;
    private static JLabel statementLineTenLabel;

    //--------------------------------------------------------------------------------------------------------------------------------------------
    private static EditItemsDetailsFrame editScreen;
    public static JPanel topPanel;
    public static JPanel tableComponentsPanel;
    public static JPanel tableOnlypanel;
    private static JButton addNewItemButton;
    private static JButton printButton;
    private static JButton searchButton;
    private static JTextField searchField2;
    private static JComboBox<String> sortMethodCombo;
    private static JTable itemsTable;
    private static JScrollPane tableScrollPane;
    private static JLabel totalLabel;

    private static JPanel itemsManagementPanel;
    //Add Task Fields
    private static JPanel ontopPanel;
    private static JPanel addtaskPanel;
    private static JLabel addtaskLabel;
    private static JLabel taskListInfoLabel;
    private static JLabel titleLabel;
    private static JLabel descriptionLabel;
    private static JTextField titleField;
    private static JTextArea descriptionArea;
    private static JLabel taskLabel;
    private static JComboBox taskField;
    private static JButton addtaskButton;

    private static JPanel ordersViewPanel;
    private static JPanel leftPanel;
    private static JPanel rightPanel;
    private static JPanel foodItemsPanel;
    private static JButton deletLastButton;
    private static JPanel productDetailsPanel;
    private static JScrollPane rightPanelScrollPane;
    private static JScrollPane leftPanelScrollPane;
    private static JTable salesTable;
    private static JButton paymentButton;
    private static JButton searcByCategoryButton;
    private static JComboBox searcByCategoryComboBox;
    private static JLabel subTotalLabel;
    private static JLabel VATLabel;
    private static JLabel totalAmountToBePaidLabel;
    private static JLabel totalItemsNoLabel;
    // private static JMenuBar menuBar;
    private static JMenu salesRegister;
    //private static JMenu itemsMenu;
    private static JLabel searchByCategoryLabel;
    private static JMenu customers;
    private static JMenu PointofSaleLabel;
    private static JMenu users;
    private static JMenu reports;
    private static JMenu currentLoggedEmail;
    private static JMenu titleOfLocggedUser;
    private static JPanel tempPanel;
    //SplitPane
    private static JSplitPane splitPane;
    //PopUPMenu
    private static JPopupMenu popUpmenu;
    private static JMenuBar menuBar;
    //Menues
    private static JMenu personalisationMenu;
    private static JMenu fileMenu;
    private static JMenu displaySettingsMenu;
    private static JMenu editMenu;
    private static JMenu actionMenu;
    private static JMenu viewMenu;
    private static JMenu purchasingMenu;
    private static JMenu configurationMenu;
    private static JMenu helpMenu;
    private static JMenu salesRegisterMenu;
    private static JMenu usersMenu;
    private static JMenu itemsMenu;
    private static JMenu customersMenu;
    private static JMenu adminMenu;
    private static JMenu emailAddressMenu;
    //menuItems --> FileMenue
    private static JMenuItem newOrderMenuItem;
    private static JMenuItem newNoticeMenuItem;
    private static JMenuItem newUserMenuItem;
    private static JMenuItem newEmployeeMenuItem;
    private static JMenuItem exitMenuItem2;
    //menuItems --> editMenu
    private static JMenuItem undoMenuItem;
    private static JMenuItem redoMenuItem;
    private static JMenuItem cutMenuItem;
    private static JMenuItem copyMenuItem;
    private static JMenuItem pasteMenuItem;
    private static JMenuItem pastFormatedmenuItem;
    private static JMenuItem pastFromMenuItem;
    private static JMenuItem deleteMenuItem;
    private static JMenuItem selectAllMenuItem;
    private static JMenuItem selectIdentifierMenuItem;
    private static JMenuItem findSelectionMenuItem;
    private static JMenuItem findNextMenuItem;
    private static JMenuItem findPreviouseMenuItem;
    private static JMenuItem findMenuItem;
    private static JMenuItem replaceMenuItem;
    private static JMenuItem findUsageMenuItem;
    //menuItems --> ActionMenu
    private static JMenuItem barCodeViewMenuItem;
    private static JMenuItem newOrderMenu;
    private static JMenuItem printNotificationMenuItem;
    private static JMenuItem printBillMenuItem;
    private static JMenuItem closeOrderMenuItem;
    private static JMenuItem transferOrdermenuItem;
    private static JMenuItem splitManuItem;
    private static JMenuItem divideOrderMenuItem;
    private static JMenuItem logOffMenuItem;
    private static JMenuItem enterBeginCashMenuItem;
    private static JMenuItem reconcileCashDrawerMenuItem;
    private static JMenuItem endOfDayMenuItem;
    private static JMenuItem exitmenuItem;
    private static JMenuItem clockInClockOutMenuItem;
    private static JMenuItem purchaseMenuOrders;
    private static JMenuItem purchaseVoucherMenuItem;
    private static JMenuItem returnVoucherManuItem;
    private static JMenuItem vendorsMenuItem;
    //menuItems --> viewmenu
    private static JMenuItem loansViewMenuItem;
    private static JMenuItem taskListViewMenuItem;
    private static JMenuItem ordersMenuItem;
    private static JMenuItem clientsMenuItem;
    private static JMenuItem shiftMenuItem;
    private static JMenuItem reportsMenuItem;
    private static JMenuItem emailSenderManuitem;
    private static JMenu toolBarsMenuItem;
    private static JMenuItem standardSubMenItem;
    private static JMenuItem hearderSubMenuItem;
    private static JMenu languageMenuITem;
    private static JMenu themeMenuItem;
    private static JMenuItem englishSubMenuItem;
    private static JMenuItem frenchSubMenuItem;
    private static JMenuItem germanSubMenuItem;
    private static JMenuItem abcreThemeMenuItem;
    private static JMenuItem abcre2ThemeMenuItem;
    private static JMenuItem aquaMenuItem;
    private static JMenuItem barcieMenuItem;
    private static JMenuItem classsicThemeMenuItem;
    private static JMenuItem silverManueItem;
    //menuItems --> configurationMenu
    private static JMenuItem propertiesSettingsMenu;
    private static JMenuItem preferenceMenuItem;
    private static JMenuItem workersMenuItem;
    private static JMenuItem menuItemMenuItem;
    private static JMenuItem menuMenuItem;
    private static JMenuItem menuItemCategoriesMenuItem;
    private static JMenuItem menuItemModifiersMenuItem;
    private static JMenuItem tablesmenuItem;
    private static JMenuItem tablesPlanMenuItem;
    private static JMenuItem billConfigurationMenuItem;
    private static JMenuItem paymentMethodsMenuItem;
    private static JMenuItem notificationPrintersMenuItem;
    private static JMenuItem discountsMeuItem;
    //menuItems --> HelpMenu
    private static JMenuItem contentsMenuItem;
    private static JMenuItem feedBackmenuItem;
    private static JMenuItem deactivateMenuItem;
    private static JMenuItem aboutMenuItem;
    //menuItems --> itemsMenu
    private static JMenuItem addnewItemMenuItem;
    private static JMenuItem manageItemMenuItem;
    private static JMenuItem itemsListMenuItem;
    private static JMenuItem categoriesMenuItem;
    //menuItems --> customersMenu
    private static JMenuItem addCustomerMenuItem;
    private static JMenuItem manageCustomersMenuItem;
    //menuItems --> adminMenu
    private static JMenuItem taskMenuItem;
    private static JMenuItem settingsMenuitem;
    private static JMenuItem logOutMenuItem;
    //menuItems --> usersMenu
    private static JMenuItem addUsersmenuitem;
    private static JMenuItem manageUserMenuItem;
    private static JPanel addNewTaskPanel;
    private static JMenuItem viewSuppliers;
    private static LocalDate printDate;
    private static ProductSalesTransactions productSalesTransactions;

    public MainPOSInterface(Boolean visible) {
        super("Apha Pharmacy POS");
        setSize(getMaximumSize().width, getMaximumSize().height);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        customerTransactions = new CustomerTransaction();
        productSalesTransactions = new ProductSalesTransactions();
        drugInventoryTransactions = new DrugInventoryTransactions();
        printDate = LocalDate.now();
        generateSaleReportsByDateButton = new JButton("Generate");
        drugInventoryLabel = new JLabel("Drugs Inventory");
        drugInventoryLabel.setForeground(Color.WHITE);
        drugInventoryLabel.setFont(new Font("New Times Roman", Font.BOLD, 26));
        stockTabelModel = new DefaultTableModel();
        suppliers = new JMenu("Suppliers");
        viewSuppliers = new JMenuItem("View Suppliers");
        suppliersInfoViewPanel = new JPanel(null);
        addNewUserPanelView = new JPanel(null);
        saleTableModel = new SalesTableModel();
        addItemToSalesButton = new JButton("ADD");
        reportsMenu = new JMenu("Reports");
        stockMenu = new JMenu("Stock");
        salesMenu = new JMenu("Sales");
        salesReportsMenu = new JMenu("Sales Reports");
        salesReportsBySalesRep = new JMenuItem("By Sales Rep");
        salesReportsByCategory = new JMenuItem("By Category");
        salesReportsByDate = new JMenuItem("By Date");
        salesReportsByID = new JMenuItem("By Category");
        salesReportsMenu.add(Box.createHorizontalStrut(200));
        salesReportsMenu.add(salesReportsByCategory);
        salesReportsMenu.add(salesReportsByID);
        salesReportsMenu.add(salesReportsBySalesRep);
        salesReportsMenu.add(salesReportsByDate);
        viewCustomerInformationDetailsView = new JPanel(null);
        addNewPatientCustomerViewPanel = new JPanel(null);
        addNewEmplyeeViewPanel = new JPanel(null);
        processPayMentsViewPanel = new JPanel(null);
        inventoryViewPanel = new JPanel(null);
        orderDetailsMainViewPanel = new JPanel(null);
        //Prepare the reports menuItems
        barCodeViewMenuItem = new JMenuItem("Generate Bar codes");
        salesMenuItem = new JMenuItem("Sales");
        taxesMenuItem = new JMenuItem("Taxes");
        inventoryMenuItem = new JMenuItem("Inventory");
        invoiceMenuItem = new JMenuItem("Invoice");
        advancedViewMenuItem = new JMenuItem("Advanced View");
        customerModel = new DefaultTableModel();
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        suppliersModel = new DefaultTableModel();
        String[] customerInformationSortOptions = {"Suppliers Name", "Region", "Contact", "Email", "Contact Persons"};
        addNewsuppliersCustomerButton = new JButton("Add Supplier");
        suppliersInformationLabel = new JLabel("Suppliers Information");
        suppliersInformationLabel.setFont(new Font("New Times Roman", Font.BOLD, 18));
        suppliersInformationLabel.setForeground(Color.WHITE);
        suppliersPatientsEditScreen = new addCustomerInformation();
        suppliersPrintButton = new JButton("Print");
        suppliersPatientSearchButton = new JButton("");
        suppliersPatientTotalLabel = new JLabel();
        suppliersPatientSearchButton.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\searchIcon.jpg"));
        suppliersSortByButton = new JButton("Sort By:");
        suppliersPatiientsSearchField = new JTextField("Search...");
        suppliersPatientSortMethodCombo = new JComboBox<>(customerInformationSortOptions);
        suppliersPatientTable = new JTable(suppliersModel);
        List<String> suppliersTableColumnNames = Arrays.asList("Suppliers Name", "Contact Person", "Region", "Contact", "Email", "Amount Due", "Paid", "Balance");
        setTableColumnHeaders(suppliersTableColumnNames, suppliersModel);
        suppliersPatientTableScrollPane = new JScrollPane(suppliersPatientTable);
        suppliersPatientTableScrollPane.getViewport().setBackground(Color.WHITE);
        suppliersSortByButton.setForeground(Color.WHITE);
        addNewsuppliersCustomerButton.setBounds(400, 20, 150, 30);
        suppliersInformationLabel.setBounds(50, 20, 250, 40);
        suppliersPrintButton.setBounds(570, 20, 100, 30);
        suppliersPatientSearchButton.setBounds(25, 5, 30, 30);
        suppliersPatiientsSearchField.setBounds(55, 5, 300, 30);
        suppliersSortByButton.setBounds(365, 5, 100, 30);
        suppliersPatientSortMethodCombo.setBounds(475, 5, 200, 30);
        suppliersPatientTableScrollPane.setBounds(5, 25, 990, 415);
        suppliersPatientsTopPanel = new JPanel(null);
        suppliersTableComponentsPanel = new JPanel(null);
        viewsuppliersTableOnlypanel = new JPanel(null);
        suppliersPatientsTopPanel.setBackground(Color.decode("#1E90FF"));
        suppliersTableComponentsPanel.setBackground(Color.LIGHT_GRAY);
        viewsuppliersTableOnlypanel.setBackground(Color.WHITE);
        suppliersPatientSortMethodCombo.setBackground(Color.WHITE);
        suppliersPatientsTopPanel.setBounds(100, 0, 1000, 70);
        suppliersTableComponentsPanel.setBounds(100, 100, 1000, 90);
        viewsuppliersTableOnlypanel.setBounds(100, 190, 1000, 450);
        suppliersPatientTotalLabel.setBounds(450, 2, 200, 30);
        suppliersTableComponentsPanel.setBorder(new LineBorder(Color.BLUE));
        viewsuppliersTableOnlypanel.setBorder(new LineBorder(Color.BLUE));
        suppliersPatientsTopPanel.setBorder(new LineBorder(Color.BLUE));
        addNewsuppliersCustomerButton.setBackground(Color.ORANGE);
        suppliersPrintButton.setBackground(Color.decode("#B22222"));
        suppliersPrintButton.setForeground(Color.WHITE);
        addNewsuppliersCustomerButton.setForeground(Color.white);
        suppliersSortByButton.setBackground(Color.BLUE);
        suppliersPatientSearchButton.setBackground(Color.blue);
        suppliersPatientsTopPanel.add(suppliersPrintButton);
        suppliersPatientsTopPanel.add(suppliersInformationLabel);
        suppliersTableComponentsPanel.add(suppliersPatientSearchButton);
        suppliersTableComponentsPanel.add(suppliersPatiientsSearchField);
        suppliersTableComponentsPanel.add(suppliersSortByButton);
        suppliersTableComponentsPanel.add(suppliersPatientSortMethodCombo);
        viewsuppliersTableOnlypanel.add(suppliersPatientTotalLabel);
        viewsuppliersTableOnlypanel.add(suppliersPatientTableScrollPane);
        addFieldsFocusListener(suppliersPatientSortMethodCombo);
        addFieldsFocusListener(suppliersPatiientsSearchField);
        suppliersInfoViewPanel.add(suppliersPatientsTopPanel);
        suppliersInfoViewPanel.add(suppliersTableComponentsPanel);
        suppliersInfoViewPanel.add(viewsuppliersTableOnlypanel);
        // animateGreypanels(suppliersTableComponentsPanel);
        searchTextFieldMouseListener(suppliersPatiientsSearchField);
        addNewsuppliersCustomerButton.addActionListener(e -> suppliersPatientsEditScreen.setVisible(true));
        suppliersPrintButton.addActionListener(event -> {
            try {
                suppliersPatientTable.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("Suppliers Records"), new MessageFormat(printDate + "   " + new managedocuments.CompanyInfoTransactions().getCompanyInformation().get("name")));
                JOptionPane.showMessageDialog(null, "Print succefull!");
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, "Unable To print:" + e.getMessage());
            }
        });
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        patientsTopAddUserPanel = new JPanel(null);
        patientsEditProfilePanel = new JPanel(null);
        patientsAddPrescriptionDetailsButton = new JButton("Add Drugs/Prescription");
        patientsUpdateInfoButton = new JButton("Update Info");
        patientsUpdateUserDetailsButton = new JButton("Update");
        patientsAdminButton = new JButton("Admin");
        patientsCustomerInformationLabel = new JLabel("Customer Information");
        patientsFirstNameLabel = new JLabel("First Name");
        patientsFirstNameField = new JTextField();
        patientsLastNameLabel = new JLabel("Last Name");
        patientsLastNameField = new JTextField();
        patientsPhoneLabel = new JLabel("Phone");
        patientsPhoneField = new JTextField();
        patientsEmailLabel = new JLabel("Email");
        patientsEmailField = new JTextField();
        patientsPrescriptionDetails = new JLabel("Prescription Details Overview");
        patientsPrescriptionDetailsField = new JTextField();
        patientsLastVisitLabel = new JLabel("Last Visit");
        patientsLastVisitField = new JDateChooser();
        patientsNextVistLabel = new JLabel("Next  Appointment");
        patientsNextVistField = new JDateChooser();
        patientsDiagnosisDetailsLlabel = new JLabel("Patients Diagnosis Details");
        patientsPatientsDiagnosisField = new JTextArea();
        patientsTopAddUserPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        patientsEditProfilePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        patientsCustomerInformationLabel.setFont(new Font("New Times Roman", Font.BOLD, 22));
        patientsPatientsDiagnosisField.setBorder(new LineBorder(Color.decode("#1E90FF")));
        patientsEditProfilePanel.setBackground(Color.WHITE);
        patientsUpdateInfoButton.setBackground(Color.red);
        patientsAdminButton.setBackground(Color.red);
        patientsUpdateInfoButton.setForeground(Color.WHITE);
        patientsAdminButton.setForeground(Color.WHITE);
        patientsUpdateUserDetailsButton.setBackground(Color.decode("#1E90FF"));
        patientsUpdateUserDetailsButton.setForeground(Color.WHITE);
        patientsCustomerInformationLabel.setForeground(Color.WHITE);
        patientsAddPrescriptionDetailsButton.setForeground(Color.WHITE);
        patientsAddPrescriptionDetailsButton.setBackground(Color.decode("#1E90FF"));
        patientsAddPrescriptionDetailsButton.setBounds(610, 410, 190, 40);
        patientsTopAddUserPanel.setBounds(100, 0, 1000, 100);
        patientsEditProfilePanel.setBounds(100, 150, 1000, 550);
        patientsCustomerInformationLabel.setBounds(400, 20, 1000, 40);
        patientsUpdateInfoButton.setBounds(130, 15, 100, 30);
        patientsAdminButton.setBounds(240, 15, 70, 30);
        patientsFirstNameLabel.setBounds(130, 60, 200, 30);
        patientsFirstNameField.setBounds(130, 100, 300, 40);
        patientsLastNameLabel.setBounds(130, 150, 300, 30);
        patientsLastNameField.setBounds(130, 180, 300, 40);
        patientsPhoneLabel.setBounds(130, 220, 300, 30);
        patientsPhoneField.setBounds(130, 260, 300, 40);
        patientsEmailLabel.setBounds(130, 300, 300, 30);
        patientsEmailField.setBounds(130, 330, 300, 40);
        patientsPrescriptionDetails.setBounds(130, 385, 300, 30);
        patientsPrescriptionDetailsField.setBounds(130, 410, 300, 40);
        patientsLastVisitLabel.setBounds(500, 60, 300, 30);
        patientsLastVisitField.setBounds(500, 100, 300, 40);
        patientsNextVistLabel.setBounds(500, 140, 300, 30);
        patientsNextVistField.setBounds(500, 170, 300, 30);
        patientsNextVistField.setBounds(500, 180, 300, 40);
        patientsDiagnosisDetailsLlabel.setBounds(500, 220, 300, 30);
        patientsPatientsDiagnosisField.setBounds(500, 260, 300, 140);
        patientsUpdateUserDetailsButton.setBounds(500, 410, 100, 40);
        patientsTopAddUserPanel.add(patientsCustomerInformationLabel);
        patientsEditProfilePanel.add(patientsUpdateInfoButton);
        patientsEditProfilePanel.add(patientsAdminButton);
        patientsEditProfilePanel.add(patientsFirstNameLabel);
        patientsEditProfilePanel.add(patientsFirstNameField);
        patientsEditProfilePanel.add(patientsLastNameLabel);
        patientsEditProfilePanel.add(patientsLastNameField);
        patientsEditProfilePanel.add(patientsPhoneLabel);
        patientsEditProfilePanel.add(patientsPhoneField);
        patientsEditProfilePanel.add(patientsEmailLabel);
        patientsEditProfilePanel.add(patientsEmailField);
        patientsEditProfilePanel.add(patientsPrescriptionDetails);
        patientsEditProfilePanel.add(patientsPrescriptionDetailsField);
        patientsEditProfilePanel.add(patientsLastVisitLabel);
        patientsEditProfilePanel.add(patientsLastVisitField);
        patientsEditProfilePanel.add(patientsNextVistLabel);
        patientsEditProfilePanel.add(patientsNextVistField);
        patientsEditProfilePanel.add(patientsDiagnosisDetailsLlabel);
        patientsEditProfilePanel.add(patientsPatientsDiagnosisField);
        patientsEditProfilePanel.add(patientsUpdateUserDetailsButton);
        patientsEditProfilePanel.add(patientsAddPrescriptionDetailsButton);
        patientsTopAddUserPanel.setBackground(Color.decode("#1E90FF"));
        addNewPatientCustomerViewPanel.add(patientsTopAddUserPanel);
        addNewPatientCustomerViewPanel.add(patientsEditProfilePanel);
        addFieldsFocusListener(patientsFirstNameField);
        addFieldsFocusListener(patientsLastNameField);
        addFieldsFocusListener(patientsPhoneField);
        addFieldsFocusListener(patientsEmailField);
        addFieldsFocusListener(patientsPrescriptionDetailsField);
        addFieldsFocusListener(patientsLastVisitField);
        addFieldsFocusListener(patientsNextVistField);
        addFieldsFocusListener(patientsPatientsDiagnosisField);
        patientsAddPrescriptionDetailsButton.addActionListener(e -> new systemsandmanagementrinterface.patientsDiagnosedDrugsDetails().setVisible(true));
        patientsUpdateUserDetailsButton.addActionListener((ActionEvent event) -> {
            patientsLastVisitField.getDate();
            customerTransactions.insertCustomerDataToDb(patientsFirstNameField.getText(), patientsLastNameField.getText(), patientsPhoneField.getText(), patientsEmailField.getText(), patientsPrescriptionDetailsField.getText(), patientsLastVisitField.getDate().toString(), patientsNextVistField.getDate().toString(), patientsPatientsDiagnosisField.getText());
        });

        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String[] suppliersInformationSortOptions = {"First Name", "Last Name", "Phone", "Email", "Prescription Details", "Last Visit", "Next Appointment", "Diagnosis"};
        addNewPatientCustomerButton = new JButton("Add Customer");
        customerInformationLabel = new JLabel("Customers Information");
        customerInformationLabel.setFont(new Font("New Times Roman", Font.BOLD, 18));
        customerInformationLabel.setForeground(Color.WHITE);
        patientCustomerPrintButton = new JButton("Print");
        customerPatientSearchButton = new JButton("");
        
        customerPatientSearchButton.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\searchIcon.jpg"));
        customerPatientSortByButton = new JButton("Sort By:");
        customerPatiientsSearchField = new JTextField("Search...");
        customerPatientSortMethodCombo = new JComboBox<>(suppliersInformationSortOptions);
        customerPatientTable = new JTable(customerModel);
        customerPatientTable.setEnabled(false);
        List<String> customerTableColumnHeaders = Arrays.asList("First Name", "Last Name", "Phone", "Email", "Prescription", "Last Visit", "Next Appointment", "Diagnosis");
        setTableColumnHeaders(customerTableColumnHeaders, customerModel);
        connectToDatabase();
        customerPatientTableScrollPane = new JScrollPane(customerPatientTable);
        customerPatientTableScrollPane.getViewport().setBackground(Color.WHITE);
        customerPatientSortByButton.setForeground(Color.WHITE);
        addNewPatientCustomerButton.setBounds(400, 20, 150, 30);
        customerInformationLabel.setBounds(50, 20, 250, 40);
        patientCustomerPrintButton.setBounds(570, 20, 100, 30);
        customerPatientSearchButton.setBounds(25, 5, 30, 30);
        customerPatiientsSearchField.setBounds(55, 5, 300, 30);
        customerPatientSortByButton.setBounds(365, 5, 100, 30);
        customerPatientSortMethodCombo.setBounds(475, 5, 200, 30);
        customerPatientTableScrollPane.setBounds(5, 25, 990, 415);
        customersPatientsTopPanel = new JPanel(null);
        customerPatientTableComponentsPanel = new JPanel(null);
        customerpatientTableOnlypanel = new JPanel(null);
        customersPatientsTopPanel.setBackground(Color.decode("#1E90FF"));
        customerPatientTableComponentsPanel.setBackground(Color.LIGHT_GRAY);
        customerpatientTableOnlypanel.setBackground(Color.WHITE);
        customerPatientSortMethodCombo.setBackground(Color.WHITE);
        customersPatientsTopPanel.setBounds(100, 0, 1000, 70);
        customerPatientTableComponentsPanel.setBounds(100, 100, 1000, 90);
        customerpatientTableOnlypanel.setBounds(100, 190, 1000, 450);
        
        customerPatientTableComponentsPanel.setBorder(new LineBorder(Color.BLUE));
        customerpatientTableOnlypanel.setBorder(new LineBorder(Color.BLUE));
        customersPatientsTopPanel.setBorder(new LineBorder(Color.BLUE));
        addNewPatientCustomerButton.setBackground(Color.ORANGE);
        patientCustomerPrintButton.setBackground(Color.decode("#B22222"));
        patientCustomerPrintButton.setForeground(Color.WHITE);
        addNewPatientCustomerButton.setForeground(Color.white);
        customerPatientSortByButton.setBackground(Color.BLUE);
        customerPatientSearchButton.setBackground(Color.blue);
        customersPatientsTopPanel.add(patientCustomerPrintButton);
        customersPatientsTopPanel.add(addNewPatientCustomerButton);
        customersPatientsTopPanel.add(customerInformationLabel);
        customerPatientTableComponentsPanel.add(customerPatientSearchButton);
        customerPatientTableComponentsPanel.add(customerPatiientsSearchField);
        customerPatientTableComponentsPanel.add(customerPatientSortByButton);
        customerPatientTableComponentsPanel.add(customerPatientSortMethodCombo);
        
        customerpatientTableOnlypanel.add(customerPatientTableScrollPane);
        addFieldsFocusListener(customerPatientSortMethodCombo);
        addFieldsFocusListener(customerPatiientsSearchField);
        viewCustomerInformationDetailsView.add(customersPatientsTopPanel);
        viewCustomerInformationDetailsView.add(customerPatientTableComponentsPanel);
        viewCustomerInformationDetailsView.add(customerpatientTableOnlypanel);
        // animateGreypanels(customerPatientTableComponentsPanel);
        searchTextFieldMouseListener(customerPatiientsSearchField);
        addNewPatientCustomerButton.addActionListener(e -> {
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            addNewPatientCustomerViewPanel.setBackground(Color.WHITE);
            splitPane.setRightComponent(addNewPatientCustomerViewPanel);
            repaint();
        });
        patientCustomerPrintButton.addActionListener(e -> printJTable(customerPatientTable, "Customer Records"));
        //New Order Screen
        //---------------------------------------------------------------------------------------------------------------------------------------------------------
        selectCategoryLabel = new JLabel("Select category");
        selectItemLabel = new JLabel("Select item");
        selectQtyLabel = new JLabel("Select Quantity");

//        String[][] samplePaymtData = {{amountPaidField.getText(), changeField.getText(), totalNetField.getText(), payModeComboBox.getSelectedItem().toString()},};
        selectCategoryCombo = new JComboBox<>(drugInventoryTransactions.getCategories());
        selectQtySpinner = new JSpinner();
        amountReceivedWindow = new JTextArea();
        addMoreCashButton = new JButton("ADD");
        payOneButton = new JButton("1");
        payTwoButton = new JButton("2");
        payThreeButton = new JButton("3");
        fourButtonPay = new JButton("4");
        fiveButtonPay = new JButton("5");
        sixButtonPay = new JButton("6");
        sevenButtonPay = new JButton("7");
        eightButtonPay = new JButton("8");
        nineButtonPay = new JButton("9");
        zeroButtonPay = new JButton("0");

        closeButtonPay = new JButton("CLOSE");
        deleteButtonPay = new JButton("DELETE");
        printButtonPay = new JButton("PRINT");
        clearFieldButtonPay = new JButton("C");
        processPayZeroCancelpanel = new JPanel(null);
        payModeLabel = new JLabel("Payment Mode");
        amountPaidLabel = new JLabel("Amount Paid");
        amountDueLabel = new JLabel("Amount Due");
        changeLabel = new JLabel("Change");
        totalNetLabel = new JLabel("Total Net");
        payModeLabel.setForeground(Color.WHITE);
        deleteButtonPay.setForeground(Color.white);
        closeButtonPay.setForeground(Color.white);
        printButtonPay.setForeground(Color.WHITE);
        amountPaidLabel.setForeground(Color.WHITE);
        amountDueLabel.setForeground(Color.WHITE);
        changeLabel.setForeground(Color.WHITE);
        totalNetLabel.setForeground(Color.WHITE);
        String[] paymentModes = {"Cash", "Check", "Visa", "Master Card/EuroCard", "Voucher"};
        payModeComboBox = new JComboBox<>(paymentModes);
        amountDueField = new JTextField();
        amountPaidField = new JTextField();
        changeField = new JTextField();
        totalNetField = new JTextField();
        processPayTopPayPanel = new JPanel(null);
        payNumberButtonsPanel = new JPanel(new GridLayout(3, 3, 1, 1));
        payModePanel = new JPanel(null);
        payTabelPanel = new JPanel(null);
        reverseStatusPanel = new JPanel(null);
        itemsPaymentTablePay = new JTable(saleTableModel);
        itemsPaymentTablePay.setRowHeight(50);
        tableScrollPanePay = new JScrollPane(itemsPaymentTablePay);
        tableScrollPanePay.getViewport().setBackground(Color.WHITE);
        tableScrollPanePay.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScrollPanePay.setBounds(5, 5, 490, 390);
        payTabelPanel.add(tableScrollPanePay);
        closeButtonPay.setBounds(20, 10, 200, 100);
        printButtonPay.setBounds(280, 10, 200, 100);
        deleteButtonPay.setBounds(530, 10, 200, 100);
        clearFieldButtonPay.setBounds(502, 2, 245, 135);
        zeroButtonPay.setBounds(1, 2, 500, 135);
        amountReceivedWindow.setBounds(5, 5, 520, 70);
        addMoreCashButton.setBounds(525, 5, 200, 70);
        processPayZeroCancelpanel.setBounds(510, 495, 750, 140);
        payModeComboBox.setBounds(240, 15, 250, 30);
        amountDueField.setBounds(240, 130, 250, 30);
        amountPaidField.setBounds(240, 70, 250, 30);
        changeField.setBounds(240, 190, 250, 30);
        totalNetField.setBounds(240, 250, 250, 30);
        payModeLabel.setBounds(5, 5, 200, 50);
        amountDueLabel.setBounds(5, 120, 200, 50);
        changeLabel.setBounds(5, 180, 200, 50);
        totalNetLabel.setBounds(5, 240, 200, 50);
        selectCategoryLabel.setBounds(510, 0, 200, 20);
        selectCategoryCombo.setBounds(510, 25, 200, 40);
        addItemToSalesButton.setBounds(1160, 25, 80, 50);
        selectItemLabel.setBounds(720, 0, 200, 20);
        selectQtyLabel.setBounds(930, 0, 200, 20);
        selectQtySpinner.setBounds(930, 25, 200, 40);
        processPayTopPayPanel.setBounds(510, 105, 750, 80);
        payNumberButtonsPanel.setBounds(510, 190, 750, 300);
        payModePanel.setBounds(5, 5, 500, 345);
        payTabelPanel.setBounds(5, 355, 500, 400);
        reverseStatusPanel.setBounds(510, 636, 750, 120);
        amountPaidLabel.setBounds(5, 60, 200, 50);
        payModeLabel.setFont(new Font("New Times Roman", Font.BOLD, 16));
        amountPaidLabel.setFont(new Font("New Times Roman", Font.BOLD, 16));
        amountDueLabel.setFont(new Font("New Times Roman", Font.BOLD, 16));
        changeLabel.setFont(new Font("New Times Roman", Font.BOLD, 16));
        totalNetLabel.setFont(new Font("New Times Roman", Font.BOLD, 16));
        processPayZeroCancelpanel.setBackground(Color.decode("#00BFFF"));
        processPayTopPayPanel.setBackground(Color.decode("#FF0FF"));
        payNumberButtonsPanel.setBackground(Color.decode("#9932CC"));
        processPayTopPayPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
        payNumberButtonsPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
        payModePanel.setBorder(new LineBorder(Color.BLACK, 2, true));
        payTabelPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
        processPayZeroCancelpanel.setBorder(new LineBorder(Color.BLACK, 2, true));
        reverseStatusPanel.setBorder(new LineBorder(Color.BLACK, 2, true));
        payModePanel.setBackground(Color.decode("#193688"));
        payTabelPanel.add(new JScrollPane(new JTable()));
        payTabelPanel.setBackground(Color.decode("#193688"));
        reverseStatusPanel.setBackground(Color.decode("#193688"));
        processPayTopPayPanel.setBackground(Color.decode("#193688"));
        processPayZeroCancelpanel.setBackground(Color.decode("#193688"));
        payNumberButtonsPanel.setBackground(Color.decode("#193688"));
        payOneButton.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        payTwoButton.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        payThreeButton.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        fourButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        fiveButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        sixButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        sevenButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        eightButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        nineButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        zeroButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        clearFieldButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        addMoreCashButton.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        closeButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        deleteButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        printButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        clearFieldButtonPay.setFont(new Font("STENCIL", Font.BOLD, 45));
        payOneButton.setFont(new Font("STENCIL", Font.BOLD, 40));
        payTwoButton.setFont(new Font("STENCIL", Font.BOLD, 40));
        payThreeButton.setFont(new Font("STENCIL", Font.BOLD, 40));
        fourButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        fiveButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        sixButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        sevenButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        eightButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        nineButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        addMoreCashButton.setFont(new Font("STENCIL", Font.BOLD, 40));
        closeButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        deleteButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        printButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        zeroButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        amountReceivedWindow.setFont(new Font("STENCIL", Font.BOLD, 40));
        payOneButton.setBackground(Color.decode("#1E90FF"));
        payTwoButton.setBackground(Color.decode("#1E90FF"));
        payThreeButton.setBackground(Color.decode("#1E90FF"));
        fourButtonPay.setBackground(Color.decode("#1E90FF"));
        fiveButtonPay.setBackground(Color.decode("#1E90FF"));
        sixButtonPay.setBackground(Color.decode("#1E90FF"));
        sevenButtonPay.setBackground(Color.decode("#1E90FF"));
        eightButtonPay.setBackground(Color.decode("#1E90FF"));
        nineButtonPay.setBackground(Color.decode("#1E90FF"));
        zeroButtonPay.setBackground(Color.decode("#1E90FF"));
        amountReceivedWindow.setEditable(false);
        amountDueField.setFont(new Font("STENCIL", Font.BOLD, 30));
        amountPaidField.setFont(new Font("STENCIL", Font.BOLD, 30));
        changeField.setFont(new Font("STENCIL", Font.BOLD, 30));
        totalNetField.setFont(new Font("STENCIL", Font.BOLD, 30));
        amountPaidLabel.setFont(new Font("STENCIL", Font.BOLD, 22));
        payModeLabel.setFont(new Font("STENCIL", Font.BOLD, 22));
        amountDueLabel.setFont(new Font("STENCIL", Font.BOLD, 22));
        changeLabel.setFont(new Font("STENCIL", Font.BOLD, 22));
        totalNetLabel.setFont(new Font("STENCIL", Font.BOLD, 22));
        payModeComboBox.setFont(new Font("STENCIL", Font.BOLD, 22));
        amountDueField.setText("0.00");
        payModeComboBox.setForeground(Color.BLUE);
        payOneButton.setForeground(Color.WHITE);
        payOneButton.setForeground(Color.WHITE);
        payTwoButton.setForeground(Color.WHITE);
        payThreeButton.setForeground(Color.WHITE);
        fourButtonPay.setForeground(Color.WHITE);
        fiveButtonPay.setForeground(Color.WHITE);
        sixButtonPay.setForeground(Color.WHITE);
        sevenButtonPay.setForeground(Color.WHITE);
        eightButtonPay.setForeground(Color.WHITE);
        nineButtonPay.setForeground(Color.WHITE);
        zeroButtonPay.setForeground(Color.WHITE);
        addMoreCashButton.setForeground(Color.WHITE);
        addMoreCashButton.setBackground(Color.decode("#00BFFF"));
        clearFieldButtonPay.setBackground(Color.RED);
        closeButtonPay.setBackground(Color.red);
        printButtonPay.setBackground(Color.decode("#1E90FF"));
        deleteButtonPay.setBackground(Color.red);
        deleteButtonPay.setForeground(Color.WHITE);
        amountPaidField.setEditable(false);
        amountDueField.setEditable(false);
        changeField.setEditable(false);
        totalNetField.setEditable(false);
        //nineButton.setBackground(Color.decode("#1E90FF"));
        reverseStatusPanel.add(closeButtonPay);
        reverseStatusPanel.add(deleteButtonPay);
        reverseStatusPanel.add(printButtonPay);
        processPayZeroCancelpanel.add(zeroButtonPay);
        processPayZeroCancelpanel.add(clearFieldButtonPay);
        processPayTopPayPanel.add(addMoreCashButton);
        processPayTopPayPanel.add(amountReceivedWindow);
        payNumberButtonsPanel.add(nineButtonPay);
        payNumberButtonsPanel.add(eightButtonPay);
        payNumberButtonsPanel.add(sevenButtonPay);
        payNumberButtonsPanel.add(sixButtonPay);
        payNumberButtonsPanel.add(fiveButtonPay);
        payNumberButtonsPanel.add(fourButtonPay);
        payNumberButtonsPanel.add(payThreeButton);
        payNumberButtonsPanel.add(payTwoButton);
        payNumberButtonsPanel.add(payOneButton);
        payModePanel.add(payModeLabel);
        payModePanel.add(amountPaidLabel);
        payModePanel.add(amountDueLabel);
        payModePanel.add(changeLabel);
        payModePanel.add(totalNetLabel);
        payModePanel.add(payModeComboBox);
        payModePanel.add(amountPaidField);
        payModePanel.add(amountDueField);
        payModePanel.add(changeField);
        payModePanel.add(totalNetField);
        processPayMentsViewPanel.add(selectCategoryLabel);
        processPayMentsViewPanel.add(selectItemLabel);
        processPayMentsViewPanel.add(selectQtyLabel);
        processPayMentsViewPanel.add(selectQtySpinner);
        processPayMentsViewPanel.add(selectCategoryCombo);
        processPayMentsViewPanel.add(addItemToSalesButton);
        processPayMentsViewPanel.add(processPayTopPayPanel);
        processPayMentsViewPanel.add(payNumberButtonsPanel);
        processPayMentsViewPanel.add(payModePanel);
        processPayMentsViewPanel.add(payTabelPanel);
        processPayMentsViewPanel.add(reverseStatusPanel);
        processPayMentsViewPanel.add(processPayZeroCancelpanel);
        updatePayTextArea(payOneButton);
        updatePayTextArea(payTwoButton);
        updatePayTextArea(payThreeButton);
        updatePayTextArea(fourButtonPay);
        updatePayTextArea(fiveButtonPay);
        updatePayTextArea(sixButtonPay);
        updatePayTextArea(sevenButtonPay);
        updatePayTextArea(eightButtonPay);
        updatePayTextArea(nineButtonPay);
        updatePayTextArea(zeroButtonPay);

        deleteButtonPay.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel this transaction?");
            if (option == JOptionPane.NO_OPTION || option == JOptionPane.CANCEL_OPTION) {
            } else if (option == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Transaction Cancelled!");
                amountReceivedWindow.setText("");
                changeField.setText("0.00");
                totalNetField.setText("0.00");
                amountPaidField.setText("0.00");
                amountDueField.setText("0.00");
            }
        });
        printButtonPay.addActionListener(e -> {
            try {
                itemsPaymentTablePay.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("Goodnew Pharmacy Recpt:"), new MessageFormat(printDate + "   " + new managedocuments.CompanyInfoTransactions().getCompanyInformation().get("name")));
                productSalesTransactions.deleteTransactionData();
                amountReceivedWindow.setText("");
                amountPaidField.setText("0.00");
                changeField.setText("0.00");
                amountDueField.setText("0.00");
                totalNetField.setText("0.00");
                saleTableModel.fireTableDataChanged();
            } catch (PrinterException ex) {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        closeButtonPay.addActionListener(e -> {
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            clockInAndOutViewPanel.setBackground(Color.white);
            splitPane.setRightComponent(clockInAndOutViewPanel);
        });
        selectCategoryCombo.addActionListener(e -> {
            if (selectItemsCombo != null) {
                processPayMentsViewPanel.remove(selectItemsCombo);
                repaint();
            }
            //   String[] drugNames = new salesinventory.DrugsInventoryTransactions().getDrugNamesList(selectCategoryCombo.getSelectedItem().toString());
            selectItemsCombo = new JComboBox<>(drugInventoryTransactions.getDrugNamesList(selectCategoryCombo.getSelectedItem().toString()));
            //selectItemsCombo = new JComboBox<>(new salesinventory.DrugsInventoryTransactions().getDrugNamesList("painkillers"));
            selectItemsCombo.setBounds(720, 25, 200, 40);
            processPayMentsViewPanel.add(selectItemsCombo);
            repaint();
        });
        clearFieldButtonPay.addActionListener(e -> {
            amountReceivedWindow.setText("");
            amountPaidField.setText("0.00");
            changeField.setText("0.00");
            amountDueField.setText("0.00");
            totalNetField.setText("0.00");
        });
        addMoreCashButton.addActionListener(e -> {

            amountPaidField.setText(amountReceivedWindow.getText() + ".00");
            changeField.setText("" + getChange(new Double(amountReceivedWindow.getText() + ".00"), new Double(amountDueField.getText())));
            totalNetField.setText("" + getNetAmount(getChange(new Double(amountReceivedWindow.getText() + ".00"), new Double(amountDueField.getText())), new Double(amountDueField.getText())));
            amountReceivedWindow.setText("");

            repaint();
        });
        //---------------------------------------------------------------------------------------------------------------------------------------------
        //Add task view properties code
        settingsPanel = new JPanel(null);
        loansPanelView = new JPanel(null);
        customersViewPanel = new JPanel(null);
        shiftsViewPanel = new JPanel(null);
        // 
        viewUserPanel = new JPanel(null);
        taskListViewPanel = new JPanel(null);
        clockInAndOutViewPanel = new JPanel(null);
        clockInClockOutMenuItem = new JMenuItem("Clock In/Clock Out");
        inveicePanel = new JPanel(null);
        itemsManagementPanel = new JPanel(null);
        addNewTaskPanel = new JPanel(null);
        ontopPanel = new JPanel(null);
        addtaskLabel = new JLabel("Add Task");
        addtaskPanel = new JPanel(null);
        taskListInfoLabel = new JLabel("Task list provides all information,notices from a system admin or Manager");
        titleLabel = new JLabel("Title");
        titleField = new JTextField();
        descriptionLabel = new JLabel("Description");
        descriptionArea = new JTextArea();
        taskLabel = new JLabel("Task For:");
        String[] taskFroSample = {"All", "Waitress", "Supervisor", "manager", "System admin", "HR", "Securoty"};
        taskField = new JComboBox<>(taskFroSample);
        addtaskButton = new JButton("Send");
        taskField.setBorder(new LineBorder(Color.decode("#1E90FF")));
        descriptionArea.setBorder(new LineBorder(Color.decode("#1E90FF")));
        titleField.setBorder(new LineBorder(Color.decode("#1E90FF")));
        addtaskButton.setForeground(Color.WHITE);
        taskField.setBackground(Color.WHITE);
        ontopPanel.setBackground(Color.decode("#1E90FF"));
        addtaskPanel.setBackground(Color.WHITE);
        addtaskButton.setBackground(Color.decode("#1E90FF"));
        ontopPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        addtaskPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        addtaskLabel.setFont(new Font("New Times Roman", Font.BOLD, 22));
        addtaskLabel.setForeground(Color.WHITE);
        taskListInfoLabel.setFont(new Font("New Times Roman", Font.BOLD, 16));
        taskListInfoLabel.setForeground(Color.WHITE);
        ontopPanel.setBounds(200, 0, 800, 100);
        addtaskPanel.setBounds(200, 150, 800, 500);
        addtaskLabel.setBounds(350, 5, 200, 40);
        taskListInfoLabel.setBounds(150, 50, 900, 20);
        titleLabel.setBounds(50, 35, 200, 20);
        titleField.setBounds(50, 60, 700, 50);
        descriptionLabel.setBounds(50, 120, 200, 25);
        descriptionArea.setBounds(50, 150, 700, 150);
        taskLabel.setBounds(50, 300, 200, 30);
        taskField.setBounds(50, 340, 700, 50);
        addtaskButton.setBounds(50, 420, 95, 35);
        ontopPanel.add(addtaskLabel);
        ontopPanel.add(taskListInfoLabel);
        addtaskPanel.add(titleLabel);
        addtaskPanel.add(titleField);
        addtaskPanel.add(descriptionLabel);
        addtaskPanel.add(descriptionArea);
        addtaskPanel.add(taskLabel);
        addtaskPanel.add(taskField);
        addtaskPanel.add(addtaskButton);

        addNewTaskPanel.add(ontopPanel);
        addNewTaskPanel.add(addtaskPanel);
        addFieldsFocusListener(ontopPanel);
        addFieldsFocusListener(addtaskPanel);
        addFieldsFocusListener(titleField);
        addFieldsFocusListener(descriptionArea);
        addFieldsFocusListener(taskField);
        //animateGreypanels(ontopPanel);
        //-------------------------------------------------------------------------------------------------------------------------------------------

        settingsTopPanel = new JPanel(null);
        posSettingsButton = new JButton("POS Settings");
        pleaseUpdateLabel = new JLabel("Please update the information below");
        companyNameLabel = new JLabel("Company Name");
        companyField = new JTextField();
        companyAddressLabel = new JLabel("Company Address");
        companyAddressArea = new JTextArea();
        settingsPhoneLabel = new JLabel("Phone");
        phoneNumberField = new JTextField();
        emailAddressLabel = new JLabel("Email ");
        settingsEmailField = new JTextField();
        webAddresslabel = new JLabel("Web Address");
        webAddressField = new JTextField();
        vatLabel = new JLabel("VAT %");
        vatField = new JTextField();
        vatRegistrationNumberLabel = new JLabel("VAT Registration Number");
        vatRegNumberField = new JTextField();
        footerMessageLabel = new JLabel("Footer Message");
        footerTextArea = new JTextArea();
        updateSettingButton = new JButton("Update Settings");
        settingsTopPanel.setBackground(Color.decode("#1E90FF"));
        settingsTopPanel.setBounds(150, 35, 880, 550);
        posSettingsButton.setBounds(20, 20, 200, 30);
        pleaseUpdateLabel.setBounds(225, 20, 300, 20);
        companyNameLabel.setBounds(20, 75, 300, 20);
        companyField.setBounds(20, 100, 400, 45);
        companyAddressLabel.setBounds(20, 150, 300, 20);
        companyAddressArea.setBounds(20, 180, 400, 150);
        settingsPhoneLabel.setBounds(20, 335, 300, 20);
        phoneNumberField.setBounds(20, 355, 400, 40);
        emailAddressLabel.setBounds(20, 405, 300, 20);
        settingsEmailField.setBounds(20, 440, 400, 40);
        webAddresslabel.setBounds(465, 75, 300, 20);
        webAddressField.setBounds(465, 100, 400, 40);
        vatLabel.setBounds(465, 160, 300, 20);
        vatField.setBounds(465, 180, 400, 40);
        vatRegistrationNumberLabel.setBounds(465, 230, 400, 20);
        vatRegNumberField.setBounds(465, 250, 400, 100);
        footerMessageLabel.setBounds(465, 355, 400, 20);
        footerTextArea.setBounds(465, 385, 325, 100);
        updateSettingButton.setBounds(465, 500, 150, 30);
        settingsTopPanel.setBackground(Color.white);
        posSettingsButton.setBackground(Color.red);
        companyAddressArea.setBackground(Color.CYAN);
        vatRegNumberField.setBackground(Color.CYAN);
        updateSettingButton.setBackground(Color.decode("#1E90FF"));
        updateSettingButton.setForeground(Color.WHITE);
        settingsTopPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        settingsTopPanel.add(posSettingsButton);
        settingsTopPanel.add(pleaseUpdateLabel);
        settingsTopPanel.add(companyNameLabel);
        settingsTopPanel.add(companyField);
        settingsTopPanel.add(companyAddressLabel);
        settingsTopPanel.add(companyAddressArea);
        settingsTopPanel.add(settingsPhoneLabel);
        settingsTopPanel.add(phoneNumberField);
        settingsTopPanel.add(settingsEmailField);
        settingsTopPanel.add(emailAddressLabel);
        settingsTopPanel.add(webAddresslabel);
        settingsTopPanel.add(webAddressField);
        settingsTopPanel.add(vatLabel);
        settingsTopPanel.add(vatField);
        settingsTopPanel.add(vatRegistrationNumberLabel);
        settingsTopPanel.add(vatRegNumberField);
        settingsTopPanel.add(footerMessageLabel);
        settingsTopPanel.add(footerTextArea);
        settingsTopPanel.add(updateSettingButton);
        settingsPanel.add(settingsTopPanel);
        companyField.setBorder(new LineBorder(Color.decode("#1E90FF")));
        companyAddressArea.setBorder(new LineBorder(Color.decode("#1E90FF")));
        phoneNumberField.setBorder(new LineBorder(Color.decode("#1E90FF")));
        settingsEmailField.setBorder(new LineBorder(Color.decode("#1E90FF")));
        vatField.setBorder(new LineBorder(Color.decode("#1E90FF")));
        vatRegNumberField.setBorder(new LineBorder(Color.decode("#1E90FF")));
        footerTextArea.setBorder(new LineBorder(Color.decode("#1E90FF")));
        webAddressField.setBorder(new LineBorder(Color.decode("#1E90FF")));
        onClickBlueBorder(companyField);
        onClickBlueBorder(companyAddressArea);
        onClickBlueBorder(phoneNumberField);
        onClickBlueBorder(settingsEmailField);
        onClickBlueBorder(vatField);
        onClickBlueBorder(vatRegNumberField);
        onClickBlueBorder(footerTextArea);
        onClickBlueBorder(webAddressField);
        companyField.setText(new managedocuments.CompanyInfoTransactions().getCompanyInformation().get("name"));
        companyAddressArea.setText(new managedocuments.CompanyInfoTransactions().getCompanyInformation().get("address"));
        phoneNumberField.setText(new managedocuments.CompanyInfoTransactions().getCompanyInformation().get("phone"));
        settingsEmailField.setText(new managedocuments.CompanyInfoTransactions().getCompanyInformation().get("email"));
        vatField.setText(new managedocuments.CompanyInfoTransactions().getCompanyInformation().get("VAT"));
        vatRegNumberField.setText(new managedocuments.CompanyInfoTransactions().getCompanyInformation().get("VATRegNo"));
        footerTextArea.setText(new managedocuments.CompanyInfoTransactions().getCompanyInformation().get("footer"));
        webAddressField.setText(new managedocuments.CompanyInfoTransactions().getCompanyInformation().get("webAddress"));
        updateSettingButton.addActionListener(e -> {
            new managedocuments.CompanyInfoTransactions().addCompanyInformationToDB(companyField.getText(), companyAddressArea.getText(), phoneNumberField.getText(), settingsEmailField.getText(), webAddressField.getText(), vatField.getText(), vatRegNumberField.getText(), footerTextArea.getText());
        });
        //---------------------------------------------------------------------------------------------------------------------------------------
        newEmployeeNewEmpfileChooser = new JFileChooser();
        newEmployeebrowseForImageButton = new JButton("Browse");
        newEmployeeprofileImageLabel = new JLabel("Add Profile Image here...");
        newEmployeetopAddUserPanel = new JPanel(null);
        newEmployeeeditProfilePanel = new JPanel(null);
        newEmployeeupdateInfoButton = new JButton("Update Info");
        newEmployeeupdateUserDetailsButton = new JButton("Update");
        newEmployeeadminButton = new JButton("Admin");
        newEmployeeAddNewEmplyeeLabel = new JLabel("New Employee");
        newEmployeefirstNameLabel = new JLabel("First Name");
        newEmployeefirstNameField = new JTextField();
        newEmployeelastNameLabel = new JLabel("Last Name");
        newEmployeelastNameField = new JTextField();
        newEmployeephoneLabel = new JLabel("Phone");
        newEmployeephoneField = new JTextField();
        newEmployeeemailLabel = new JLabel("Email");
        newEmployeeemailField = new JTextField();
        newEmployeesupervisorLabel = new JLabel("Supervisor");
        newEmployeeSupervisorField = new JTextField();
        newEmployeeEmployeeIDoLabel = new JLabel("Employee ID");
        newEmployeeemployeeIDField = new JTextField();
        newEmployeepasswordLabel = new JLabel("Password");
        newEmployeepassword = new JPasswordField();
        newEmployeeconfirmPasswordlabel = new JLabel("Confirm Password");
        newEmployeeconfirmPasswordField = new JPasswordField();
        newEmployeetopAddUserPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        newEmployeeeditProfilePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        newEmployeeAddNewEmplyeeLabel.setFont(new Font("New Times Roman", Font.BOLD, 16));
        newEmployeeAddNewEmplyeeLabel.setForeground(Color.WHITE);
        newEmployeeeditProfilePanel.setBackground(Color.WHITE);
        newEmployeeupdateInfoButton.setBackground(Color.red);
        newEmployeeadminButton.setBackground(Color.red);
        newEmployeeupdateInfoButton.setForeground(Color.WHITE);
        newEmployeeadminButton.setForeground(Color.WHITE);
        newEmployeeupdateUserDetailsButton.setBackground(Color.decode("#1E90FF"));
        newEmployeeupdateUserDetailsButton.setForeground(Color.WHITE);
        newEmployeeprofileImageLabel.setBackground(Color.decode("#1E90FF"));
        newEmployeeprofileImageLabel.setBorder(new LineBorder(Color.decode("#1E90FF"), 5, true));
        newEmployeebrowseForImageButton.setBackground(Color.decode("#1E90FF"));
        newEmployeebrowseForImageButton.setForeground(Color.WHITE);
        newEmployeebrowseForImageButton.setBounds(500, 100, 120, 35);
        newEmployeetopAddUserPanel.setBounds(100, 0, 1000, 100);
        newEmployeeeditProfilePanel.setBounds(100, 150, 1000, 550);
        newEmployeeAddNewEmplyeeLabel.setBounds(450, 20, 1000, 40);
        newEmployeeupdateInfoButton.setBounds(130, 15, 100, 30);
        newEmployeeadminButton.setBounds(240, 15, 70, 30);
        newEmployeefirstNameLabel.setBounds(130, 60, 200, 30);
        newEmployeefirstNameField.setBounds(130, 100, 300, 40);
        newEmployeelastNameLabel.setBounds(130, 150, 300, 30);
        newEmployeeprofileImageLabel.setBounds(730, 15, 250, 140);
        newEmployeelastNameField.setBounds(130, 180, 300, 40);
        newEmployeephoneLabel.setBounds(130, 220, 300, 30);
        newEmployeephoneField.setBounds(130, 260, 300, 40);
        newEmployeeemailLabel.setBounds(130, 300, 300, 30);
        newEmployeeemailField.setBounds(130, 330, 300, 40);
        newEmployeesupervisorLabel.setBounds(130, 385, 300, 30);
        newEmployeeSupervisorField.setBounds(130, 410, 300, 40);
        newEmployeeEmployeeIDoLabel.setBounds(500, 150, 300, 30);
        newEmployeeemployeeIDField.setBounds(500, 180, 300, 40);
        newEmployeepasswordLabel.setBounds(500, 220, 300, 30);
        newEmployeepassword.setBounds(500, 260, 300, 30);
        newEmployeepassword.setBounds(500, 260, 300, 40);
        newEmployeeconfirmPasswordlabel.setBounds(500, 300, 300, 30);
        newEmployeeconfirmPasswordField.setBounds(500, 330, 300, 40);
        newEmployeeupdateUserDetailsButton.setBounds(500, 410, 100, 40);
        newEmployeetopAddUserPanel.add(newEmployeeAddNewEmplyeeLabel);
        newEmployeeeditProfilePanel.add(newEmployeeprofileImageLabel);
        newEmployeeeditProfilePanel.add(newEmployeebrowseForImageButton);
        newEmployeeeditProfilePanel.add(newEmployeeupdateInfoButton);
        newEmployeeeditProfilePanel.add(newEmployeeadminButton);
        newEmployeeeditProfilePanel.add(newEmployeefirstNameLabel);
        newEmployeeeditProfilePanel.add(newEmployeefirstNameField);
        newEmployeeeditProfilePanel.add(newEmployeelastNameLabel);
        newEmployeeeditProfilePanel.add(newEmployeelastNameField);
        newEmployeeeditProfilePanel.add(newEmployeephoneLabel);
        newEmployeeeditProfilePanel.add(newEmployeephoneField);
        newEmployeeeditProfilePanel.add(newEmployeeemailLabel);
        newEmployeeeditProfilePanel.add(newEmployeeemailField);
        newEmployeeeditProfilePanel.add(newEmployeesupervisorLabel);
        newEmployeeeditProfilePanel.add(newEmployeeSupervisorField);
        newEmployeeeditProfilePanel.add(newEmployeeEmployeeIDoLabel);
        newEmployeeeditProfilePanel.add(newEmployeeemployeeIDField);
        newEmployeeeditProfilePanel.add(newEmployeepasswordLabel);
        newEmployeeeditProfilePanel.add(newEmployeepassword);
        newEmployeeeditProfilePanel.add(newEmployeeconfirmPasswordlabel);
        newEmployeeeditProfilePanel.add(newEmployeeconfirmPasswordField);
        newEmployeeeditProfilePanel.add(newEmployeeupdateUserDetailsButton);
        newEmployeetopAddUserPanel.setBackground(Color.decode("#1E90FF"));
        addNewEmplyeeViewPanel.add(newEmployeetopAddUserPanel);
        addNewEmplyeeViewPanel.add(newEmployeeeditProfilePanel);
        addFieldsFocusListener(newEmployeefirstNameField);
        addFieldsFocusListener(newEmployeelastNameField);
        addFieldsFocusListener(newEmployeephoneField);
        addFieldsFocusListener(newEmployeeemailField);
        addFieldsFocusListener(newEmployeeSupervisorField);
        addFieldsFocusListener(newEmployeeemployeeIDField);
        addFieldsFocusListener(newEmployeepassword);
        addFieldsFocusListener(newEmployeeconfirmPasswordField);
        newEmployeebrowseForImageButton.addActionListener(event -> {
            newEmployeeprofileImageLabel.setText("");
            try {
                newEmployeeNewEmpfileChooser.showSaveDialog(null);
                newEmployeeNewEmpfileChooser.getSelectedFile();
                Image imagee;
                File filee = new File(newEmployeeNewEmpfileChooser.getSelectedFile().getPath());
                imagee = ImageIO.read(file);
                newEmployeeprofileImageLabel.setIcon(new ImageIcon(image));

            } catch (IOException ex) {
                Logger.getLogger(AddNewEmployee.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "No File Selected...");
            }
        });
        //---------------------------------------------------------------------------------------------------------------------------------------
        topAddUserPanel = new JPanel(null);
        editProfilePanel = new JPanel(null);
        updateInfooButton = new JButton("Update Info");
        updateUserDetailsButton = new JButton("Update");
        adminButton = new JButton("Admin");
        userProfilelabel = new JLabel("Users Managment");
        firstNameLabel = new JLabel("First Name");
        firstNameField = new JTextField();
        lastNameLabel = new JLabel("Last Name");
        lastNameField = new JTextField();
        phoneLabel = new JLabel("Phone");
        phoneField = new JTextField();
        emailLabel = new JLabel("Email");
        emailField = new JTextField();
        supervisorLabel = new JLabel("Supervisor");
        supervisorField = new JTextField();
        oldPasswordLabel = new JLabel("Old Password");
        oldPasswordField = new JPasswordField();
        passwordLabel = new JLabel("Password");
        password = new JPasswordField();
        confirmPasswordlabel = new JLabel("Confirm Password");
        confirmPasswordField = new JPasswordField();
        topAddUserPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        editProfilePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        userProfilelabel.setFont(new Font("New Times Roman", Font.BOLD, 16));
        editProfilePanel.setBackground(Color.WHITE);
        updateInfooButton.setBackground(Color.red);
        adminButton.setBackground(Color.red);
        updateInfooButton.setForeground(Color.WHITE);
        adminButton.setForeground(Color.WHITE);
        updateUserDetailsButton.setBackground(Color.decode("#1E90FF"));
        updateUserDetailsButton.setForeground(Color.WHITE);
        topAddUserPanel.setBounds(100, 0, 1000, 100);
        editProfilePanel.setBounds(100, 150, 1000, 550);
        userProfilelabel.setBounds(450, 20, 1000, 40);
        updateInfooButton.setBounds(130, 15, 100, 30);
        adminButton.setBounds(240, 15, 70, 30);
        firstNameLabel.setBounds(130, 60, 200, 30);
        firstNameField.setBounds(130, 100, 300, 40);
        lastNameLabel.setBounds(130, 150, 300, 30);
        lastNameField.setBounds(130, 180, 300, 40);
        phoneLabel.setBounds(130, 220, 300, 30);
        phoneField.setBounds(130, 260, 300, 40);
        emailLabel.setBounds(130, 300, 300, 30);
        emailField.setBounds(130, 330, 300, 40);
        supervisorLabel.setBounds(130, 385, 300, 30);
        supervisorField.setBounds(130, 410, 300, 40);
        oldPasswordLabel.setBounds(500, 60, 300, 30);
        oldPasswordField.setBounds(500, 100, 300, 40);
        passwordLabel.setBounds(500, 140, 300, 30);
        password.setBounds(500, 170, 300, 30);
        password.setBounds(500, 180, 300, 40);
        confirmPasswordlabel.setBounds(500, 220, 300, 30);
        confirmPasswordField.setBounds(500, 260, 300, 40);
        updateUserDetailsButton.setBounds(500, 340, 100, 40);
        topAddUserPanel.add(userProfilelabel);
        editProfilePanel.add(updateInfooButton);
        editProfilePanel.add(adminButton);
        editProfilePanel.add(firstNameLabel);
        editProfilePanel.add(firstNameField);
        editProfilePanel.add(lastNameLabel);
        editProfilePanel.add(lastNameField);
        editProfilePanel.add(phoneLabel);
        editProfilePanel.add(phoneField);
        editProfilePanel.add(emailLabel);
        editProfilePanel.add(emailField);
        editProfilePanel.add(supervisorLabel);
        editProfilePanel.add(supervisorField);
        editProfilePanel.add(oldPasswordLabel);
        editProfilePanel.add(oldPasswordField);
        editProfilePanel.add(passwordLabel);
        editProfilePanel.add(password);
        editProfilePanel.add(confirmPasswordlabel);
        editProfilePanel.add(confirmPasswordField);
        editProfilePanel.add(updateUserDetailsButton);
        topAddUserPanel.setBackground(Color.decode("#1E90FF"));
        addNewUserPanelView.add(topAddUserPanel);
        addNewUserPanelView.add(editProfilePanel);
        addFieldsFocusListener(firstNameField);
        addFieldsFocusListener(lastNameField);
        addFieldsFocusListener(phoneField);
        addFieldsFocusListener(emailField);
        addFieldsFocusListener(supervisorField);
        addFieldsFocusListener(oldPasswordField);
        addFieldsFocusListener(password);
        addFieldsFocusListener(confirmPasswordField);
        //--------------------------------------------------------------------------------------------------------------------------------------
        UserstopPanel = new JPanel(null);
        userListLabelPanel = new JPanel(null);
        UsersTablePanel = new JPanel(null);
        usersTable = new JTable();
        userListIconLabel = new JLabel();
        addNewUserButton = new JButton("Add New User");
        addNewTaskButton = new JButton("Add Task");
        usersListLabel = new JLabel("Users List");
        numberOfUserRecordsLabel = new JLabel("Total: 9 Records");
        userTableScrollPane = new JScrollPane(usersTable);
        userTableScrollPane.getViewport().setBackground(Color.WHITE);
        userTableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        UserstopPanel.setBounds(100, 0, 1050, 100);
        userListLabelPanel.setBounds(100, 150, 1050, 50);
        UsersTablePanel.setBounds(100, 200, 1050, 450);
        addNewUserButton.setBounds(350, 10, 150, 30);
        addNewTaskButton.setBounds(510, 10, 100, 30);
        userListIconLabel.setBounds(410, 19, 50, 30);
        usersListLabel.setBounds(460, 19, 100, 30);
        numberOfUserRecordsLabel.setBounds(410, 0, 100, 30);
        userTableScrollPane.setBounds(5, 36, 1043, 412);
        userListIconLabel.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\customerListIcon.png"));
        UserstopPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        UsersTablePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        userListLabelPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        UsersTablePanel.setBackground(Color.WHITE);
        UserstopPanel.setBackground(Color.decode("#F5F5F5"));
        addNewUserButton.setBackground(Color.ORANGE);
        addNewTaskButton.setBackground(Color.decode("#1E90FF"));
        addNewTaskButton.setForeground(Color.WHITE);
        userListLabelPanel.setBackground(Color.decode("#1E90FF"));
        usersListLabel.setForeground(Color.white);
        UserstopPanel.add(addNewUserButton);
        UserstopPanel.add(addNewTaskButton);
        userListLabelPanel.add(userListIconLabel);
        userListLabelPanel.add(usersListLabel);
        UsersTablePanel.add(numberOfUserRecordsLabel);
        UsersTablePanel.add(userTableScrollPane);
        viewUserPanel.add(UserstopPanel);
        viewUserPanel.add(userListLabelPanel);
        viewUserPanel.add(UsersTablePanel);
        //---------------------------------------------------------------------------------------------------------------------------------------
        customerTopPanel = new JPanel(null);
        customersLabelPanel = new JPanel(null);
        cutomersTablePanel = new JPanel(null);
        addCustomersButton = new JButton("Add New Customer");
        printCustomerInfoButton = new JButton("Print");
        customersIconLabel = new JLabel();
        customersLabel = new JLabel("Customer List");
        numberOfCustomerRecordsLabel = new JLabel("Total: 12 Records Found");
        filterCustomersButton = new JButton("Filter");
        searchCustomersField = new JTextField("Search...");
        sortCustomersByButton = new JButton("Sort By:");
        String[] customersSortCategories = {"ID", "First Name", "Last Name", "Contact", "Email", "Customer Type", "Discount %", "Status"};
        sorCustomestByCombo = new JComboBox<>(customersSortCategories);
        customersTabelCustome = new JTable();
        CustomeTableScrollPane = new JScrollPane(customersTabelCustome);
        CustomeTableScrollPane.getViewport().setBackground(Color.WHITE);
        addCustomersButton.setBounds(300, 40, 150, 30);
        addCustomersButton.setBackground(Color.RED);
        sortCustomersByButton.setBackground(Color.decode("#1E90FF"));
        filterCustomersButton.setBackground(Color.decode("#1E90FF"));
        sorCustomestByCombo.setBackground(Color.WHITE);
        printCustomerInfoButton.setBackground(Color.ORANGE);
        printCustomerInfoButton.setBounds(460, 40, 150, 30);
        customersIconLabel.setBounds(380, 5, 200, 50);
        customersIconLabel.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\Screenshot (898).png"));
        customersLabel.setBounds(450, 5, 100, 50);
        numberOfCustomerRecordsLabel.setBounds(350, 5, 150, 30);
        filterCustomersButton.setBounds(20, 40, 100, 35);
        searchCustomersField.setBounds(125, 40, 200, 35);
        sortCustomersByButton.setBounds(330, 40, 100, 35);
        sorCustomestByCombo.setBounds(435, 40, 250, 35);
        CustomeTableScrollPane.setBounds(20, 80, 950, 450);
        customerTopPanel.setBounds(100, 0, 1000, 75);
        customersLabelPanel.setBounds(100, 110, 1000, 50);
        cutomersTablePanel.setBounds(100, 160, 1000, 550);
        customerTopPanel.setBackground(Color.decode("#1E90FF"));
        customersLabelPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        customersLabelPanel.setBackground(Color.decode("#193688"));
        cutomersTablePanel.setBackground(Color.WHITE);
        cutomersTablePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        CustomeTableScrollPane.setBorder(new LineBorder(Color.decode("#1E90FF")));
        cutomersTablePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        customerTopPanel.add(addCustomersButton);
        customerTopPanel.add(printCustomerInfoButton);
        customersLabelPanel.add(customersIconLabel);
        cutomersTablePanel.add(numberOfCustomerRecordsLabel);
        cutomersTablePanel.add(filterCustomersButton);
        cutomersTablePanel.add(searchCustomersField);
        cutomersTablePanel.add(sortCustomersByButton);
        cutomersTablePanel.add(sorCustomestByCombo);
        cutomersTablePanel.add(CustomeTableScrollPane);
        customersViewPanel.add(customerTopPanel);
        customersViewPanel.add(customersLabelPanel);
        customersViewPanel.add(cutomersTablePanel);
        addFieldsFocusListener(sorCustomestByCombo);
        addFieldsFocusListener(searchCustomersField);
        searchTextFieldMouseListener(searchCustomersField);
        //---------------------------------------------------------------------------------------------------------------------------------------------
        ordersViewTopPanel = new JPanel(null);
        ordersViewLabelPanel = new JPanel(null);
        ordersViewTablePanel = new JPanel(null);
        ordersViewsaddCustomerButton = new JButton("Edit Orders  Details");
        ordersViewPrintButton = new JButton("Print");
        ordersViewsIconLabel = new JLabel();
        ordersViewLabel = new JLabel("Orders  Report View");
        ordersViewNumberOfRecordsLabel = new JLabel("Total: 12 Records Found");
        ordersViewFilterButton = new JButton("Filter");
        ordersViewSearchField = new JTextField("Search...");
        ordersViewSortByButton = new JButton("Sort By:");
        String[] sortCategories = {"Order Name", "table Code", "Number of Persons", "Date/Time", "Status", "Total Amt", "Client", "Cashier's Name"};
        ordersViewSortByCombo = new JComboBox<>(sortCategories);
        ordersDetailsViewTabel = new JTable();
        ordersDetailsViewTableScrollPane = new JScrollPane(ordersDetailsViewTabel);
        ordersDetailsViewTableScrollPane.getViewport().setBackground(Color.WHITE);
        ordersViewsaddCustomerButton.setBounds(300, 40, 150, 30);
        ordersViewsaddCustomerButton.setBackground(Color.RED);
        ordersViewSortByButton.setBackground(Color.decode("#1E90FF"));
        ordersViewFilterButton.setBackground(Color.decode("#1E90FF"));
        ordersViewSortByCombo.setBackground(Color.WHITE);
        ordersViewPrintButton.setBackground(Color.ORANGE);
        ordersViewPrintButton.setForeground(Color.WHITE);
        ordersViewsaddCustomerButton.setForeground(Color.WHITE);
        ordersViewPrintButton.setBounds(460, 40, 150, 30);
        ordersViewsIconLabel.setBounds(380, 5, 50, 50);
        ordersViewsIconLabel.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\customerListIcon.png"));
        ordersViewLabel.setBounds(450, 5, 250, 50);
        ordersViewNumberOfRecordsLabel.setBounds(350, 5, 150, 30);
        ordersViewFilterButton.setBounds(20, 40, 100, 35);
        ordersViewSearchField.setBounds(125, 40, 200, 35);
        ordersViewSortByButton.setBounds(330, 40, 100, 35);
        ordersViewSortByCombo.setBounds(435, 40, 250, 35);
        ordersDetailsViewTableScrollPane.setBounds(20, 80, 950, 450);
        ordersViewTopPanel.setBounds(100, 0, 1000, 75);
        ordersViewLabelPanel.setBounds(100, 110, 1000, 50);
        ordersViewTablePanel.setBounds(100, 160, 1000, 550);
        ordersViewTopPanel.setBackground(Color.decode("#1E90FF"));
        ordersViewLabelPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        ordersViewLabelPanel.setBackground(Color.decode("#1E90FF"));
        ordersViewTablePanel.setBackground(Color.WHITE);
        ordersViewTablePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        ordersDetailsViewTableScrollPane.setBorder(new LineBorder(Color.decode("#1E90FF")));
        ordersViewTablePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        ordersViewTopPanel.add(ordersViewsaddCustomerButton);
        ordersViewTopPanel.add(ordersViewPrintButton);
        ordersViewLabelPanel.add(ordersViewsIconLabel);
        ordersViewLabelPanel.add(ordersViewLabel);
        ordersViewTablePanel.add(ordersViewNumberOfRecordsLabel);
        ordersViewTablePanel.add(ordersViewFilterButton);
        ordersViewTablePanel.add(ordersViewSearchField);
        ordersViewTablePanel.add(ordersViewSortByButton);
        ordersViewTablePanel.add(ordersViewSortByCombo);
        ordersViewTablePanel.add(ordersDetailsViewTableScrollPane);
        orderDetailsMainViewPanel.add(ordersViewTopPanel);
        orderDetailsMainViewPanel.add(ordersViewLabelPanel);
        orderDetailsMainViewPanel.add(ordersViewTablePanel);
        addFieldsFocusListener(ordersViewSortByCombo);
        addFieldsFocusListener(ordersViewSearchField);
        searchTextFieldMouseListener(ordersViewSearchField);
        ordersViewPrintButton.addActionListener(e -> printJTable(ordersDetailsViewTabel, "Orders Records"));
        topShiftsPanel = new JPanel(null);
        shiftsLabelPanel = new JPanel(null);
        shiftsTablePanel = new JPanel(null);
        addCustomerButton = new JButton("Edit Shift Details");
        printShiftsButton = new JButton("Print");
        shiftsIconLabel = new JLabel();
        customerLabel = new JLabel("Employee Shift Tracer");
        numberOShiftsfRecordsLabel = new JLabel("Total: 12 Records Found");
        ShiftsfilterButton = new JButton("Filter");
        ShiftsSearchField = new JTextField("Search...");
        sortAllShiftsButton = new JButton("Sort By:");
        String[] ShiftsSortCategories = {"Shift ID", "Start Time", "Finish Time", "Start Date", "Finish Date", "Employee ID", "First name", "Last Name"};
        sortShiftsByCombo = new JComboBox<>(ShiftsSortCategories);
        customersTabel = new JTable();
        shiftsTableScrollPane = new JScrollPane(customersTabel);
        shiftsTableScrollPane.getViewport().setBackground(Color.WHITE);
        addCustomerButton.setBounds(300, 40, 150, 30);
        addCustomerButton.setBackground(Color.RED);
        sortAllShiftsButton.setBackground(Color.decode("#1E90FF"));
        ShiftsfilterButton.setBackground(Color.decode("#1E90FF"));
        sortShiftsByCombo.setBackground(Color.WHITE);
        printShiftsButton.setBackground(Color.ORANGE);
        printShiftsButton.setBounds(460, 40, 150, 30);
        shiftsIconLabel.setBounds(380, 5, 50, 50);
        shiftsIconLabel.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\customerListIcon.png"));
        customerLabel.setBounds(450, 5, 250, 50);
        numberOShiftsfRecordsLabel.setBounds(350, 5, 150, 30);
        ShiftsfilterButton.setBounds(20, 40, 100, 35);
        ShiftsSearchField.setBounds(125, 40, 200, 35);
        sortAllShiftsButton.setBounds(330, 40, 100, 35);
        sortShiftsByCombo.setBounds(435, 40, 250, 35);
        shiftsTableScrollPane.setBounds(20, 80, 950, 450);
        topShiftsPanel.setBounds(100, 0, 1000, 75);
        shiftsLabelPanel.setBounds(100, 110, 1000, 50);
        shiftsTablePanel.setBounds(100, 160, 1000, 550);
        topShiftsPanel.setBackground(Color.decode("#1E90FF"));
        shiftsLabelPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        shiftsLabelPanel.setBackground(Color.decode("#00BFFF"));
        shiftsTablePanel.setBackground(Color.WHITE);
        shiftsTablePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        shiftsTableScrollPane.setBorder(new LineBorder(Color.decode("#1E90FF")));
        shiftsTablePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        topShiftsPanel.add(addCustomerButton);
        topShiftsPanel.add(printShiftsButton);
        shiftsLabelPanel.add(shiftsIconLabel);
        shiftsLabelPanel.add(customerLabel);
        shiftsTablePanel.add(numberOShiftsfRecordsLabel);
        shiftsTablePanel.add(ShiftsfilterButton);
        shiftsTablePanel.add(ShiftsSearchField);
        shiftsTablePanel.add(sortAllShiftsButton);
        shiftsTablePanel.add(sortShiftsByCombo);
        shiftsTablePanel.add(shiftsTableScrollPane);
        shiftsViewPanel.add(topShiftsPanel);
        shiftsViewPanel.add(shiftsLabelPanel);
        shiftsViewPanel.add(shiftsTablePanel);
        addFieldsFocusListener(sortShiftsByCombo);
        addFieldsFocusListener(ShiftsSearchField);
        searchTextFieldMouseListener(ShiftsSearchField);
        printShiftsButton.addActionListener(e -> printJTable(customersTabel, "Employee Shifts"));
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String[] loanSortMethods = {"Action", "ID", "Aquisition Date", "Balance", "Decrease", "Description", "Increase", "isCleared", "Tel:", "Loan ID", "Original Amount"};
        addNewLoanItemButton = new JButton("Add New Loan Record");
        printLoanButton = new JButton("Print");
        searchLoanButton = new JButton("");
        loanTotalLabel = new JLabel("Total: 15 Records Found");

        searchLoanButton.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\searchIcon.jpg"));
        sortLoanByButton = new JButton("Sort By:");
        searchLoanField = new JTextField("Search...");
        sortLoanMethodCombo = new JComboBox<>(loanSortMethods);
        LoansTable = new JTable();
        loanTableScrollPane = new JScrollPane(LoansTable);
        loanTableScrollPane.getViewport().setBackground(Color.WHITE);
        addNewLoanItemButton.setBounds(400, 20, 150, 30);
        printLoanButton.setBounds(570, 20, 100, 30);
        searchLoanButton.setBounds(25, 5, 30, 30);
        searchLoanField.setBounds(55, 5, 300, 30);
        sortLoanByButton.setBounds(365, 5, 100, 30);
        sortLoanMethodCombo.setBounds(475, 5, 200, 30);
        loanTableScrollPane.setBounds(5, 25, 990, 415);
        loanTopPanel = new JPanel(null);
        loanTableComponentsPanel = new JPanel(null);
        loanTableOnlypanel = new JPanel(null);

        loanTopPanel.setBackground(Color.decode("#1E90FF"));
        loanTableComponentsPanel.setBackground(Color.decode("#F5F5F5"));
        loanTableOnlypanel.setBackground(Color.WHITE);

        loanTopPanel.setBounds(100, 0, 1000, 70);
        loanTableComponentsPanel.setBounds(100, 100, 1000, 90);
        loanTableOnlypanel.setBounds(100, 190, 1000, 450);
        loanTotalLabel.setBounds(450, 2, 200, 30);
        loanTableComponentsPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        loanTableOnlypanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        loanTopPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        addNewLoanItemButton.setBackground(Color.ORANGE);

        printLoanButton.setBackground(Color.decode("#1E90FF"));
        sortLoanByButton.setBackground(Color.decode("#1E90FF"));
        searchLoanButton.setBackground(Color.decode("#1E90FF"));
        loanTopPanel.add(printLoanButton);
        loanTopPanel.add(addNewLoanItemButton);
        loanTableComponentsPanel.add(searchLoanButton);
        loanTableComponentsPanel.add(searchLoanField);
        loanTableComponentsPanel.add(sortLoanByButton);
        loanTableComponentsPanel.add(sortLoanMethodCombo);
        loanTableOnlypanel.add(loanTotalLabel);
        loanTableOnlypanel.add(loanTableScrollPane);
        addFieldsFocusListener(sortLoanMethodCombo);
        addFieldsFocusListener(searchLoanField);
        loansPanelView.add(loanTopPanel);
        loansPanelView.add(loanTableComponentsPanel);
        loansPanelView.add(loanTableOnlypanel);
        searchTextFieldMouseListener(searchLoanField);
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String[] inventoryViewSortMethods = {"ID", "Name", "Qty per piece", "BarCode", "Price/unit", "On Hand Quantity", "Difference", "Expiry Date", "Age Range", "Details", "Time Remaining"};
        //888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
        inventoryViewsaddNewItemButton = new JButton("Add New Drugs");
        inventoryPrintButton = new JButton("Print");
        inventorySearchButton = new JButton("");
        inventoryTotalLabel = new JLabel("Total:" + stockTabelModel.getRowCount() + "  Records Found");

        inventorySearchButton.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\searchIcon.jpg"));
        inventorySortByButton = new JButton("Sort By:");
        inventroySearchField = new JTextField("Search...");
        inventorySortMethodCombo = new JComboBox<>(inventoryViewSortMethods);
        inventoryItemsTable = new JTable(stockTabelModel);
        customerPatientTable.setEnabled(false);
        getInventoryColumnNames();
        inventoryTableScrollPane = new JScrollPane(inventoryItemsTable);
        inventoryTableScrollPane.getViewport().setBackground(Color.WHITE);
        inventoryViewsaddNewItemButton.setBounds(400, 20, 150, 30);
        drugInventoryLabel.setBounds(30, 15, 250, 40);
        inventoryPrintButton.setBounds(570, 20, 100, 30);
        inventorySearchButton.setBounds(25, 5, 30, 30);
        inventroySearchField.setBounds(55, 5, 300, 30);
        inventorySortByButton.setBounds(365, 5, 100, 30);
        inventorySortMethodCombo.setBounds(475, 5, 200, 30);
        inventoryTableScrollPane.setBounds(5, 25, 990, 415);
        inventroyViewTopPanel = new JPanel(null);
        inventoryViewTableComponentsPanel = new JPanel(null);
        inventoryViewTableOnlypanel = new JPanel(null);
        inventroyViewTopPanel.setBackground(Color.decode("#1E90FF"));
        inventoryViewTableComponentsPanel.setBackground(Color.LIGHT_GRAY);
        inventoryViewTableOnlypanel.setBackground(Color.WHITE);
        inventorySortMethodCombo.setBackground(Color.WHITE);
        inventroyViewTopPanel.setBounds(100, 0, 1000, 70);
        inventoryViewTableComponentsPanel.setBounds(100, 100, 1000, 90);
        inventoryViewTableOnlypanel.setBounds(100, 190, 1000, 450);
        inventoryTotalLabel.setBounds(450, 2, 200, 30);
        inventoryViewTableComponentsPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        inventoryViewTableOnlypanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        inventroyViewTopPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        inventoryViewsaddNewItemButton.setBackground(Color.decode("#B22222"));
        inventoryViewsaddNewItemButton.setForeground(Color.WHITE);
        inventoryPrintButton.setBackground(Color.decode("#FF0000"));
        inventorySortByButton.setBackground(Color.decode("#1E90FF"));
        inventorySearchButton.setBackground(Color.blue);
        inventoryPrintButton.setForeground(Color.WHITE);
        inventorySortByButton.setForeground(Color.WHITE);

        inventroyViewTopPanel.add(inventoryPrintButton);
        inventroyViewTopPanel.add(drugInventoryLabel);
        inventroyViewTopPanel.add(inventoryViewsaddNewItemButton);
        inventoryViewTableComponentsPanel.add(inventorySearchButton);
        inventoryViewTableComponentsPanel.add(inventroySearchField);
        inventoryViewTableComponentsPanel.add(inventorySortByButton);
        inventoryViewTableComponentsPanel.add(inventorySortMethodCombo);
        inventoryViewTableOnlypanel.add(inventoryTotalLabel);
        inventoryViewTableOnlypanel.add(inventoryTableScrollPane);
        addFieldsFocusListener(inventorySortMethodCombo);
        addFieldsFocusListener(inventroySearchField);
        inventoryViewPanel.add(inventroyViewTopPanel);
        inventoryViewPanel.add(inventoryViewTableComponentsPanel);
        inventoryViewPanel.add(inventoryViewTableOnlypanel);
        searchTextFieldMouseListener(inventroySearchField);
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String[] sortMethods = {"Price", "Category", "ID", "Name", "Discount", "Code", "Qty"};
        addNewItemButton = new JButton("Add New Item");
        editScreen = new EditItemsDetailsFrame();
        printButton = new JButton("Print");
        searchButton = new JButton("");
        totalLabel = new JLabel("Total:" + " Records Found");
        searchButton.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\searchIcon.jpg"));
        sortButton = new JButton("Sort By:");
        searchField2 = new JTextField("Search...");
        sortMethodCombo = new JComboBox<>(sortMethods);
        itemsTable = new JTable();
        tableScrollPane = new JScrollPane(itemsTable);
        tableScrollPane.getViewport().setBackground(Color.WHITE);
        addNewItemButton.setBounds(400, 20, 150, 30);
        printButton.setBounds(570, 20, 100, 30);
        searchButton.setBounds(25, 5, 30, 30);
        searchField2.setBounds(55, 5, 300, 30);
        sortButton.setBounds(365, 5, 100, 30);
        sortMethodCombo.setBounds(475, 5, 200, 30);
        tableScrollPane.setBounds(5, 25, 990, 415);
        topPanel = new JPanel(null);
        tableComponentsPanel = new JPanel(null);
        tableOnlypanel = new JPanel(null);
        topPanel.setBackground(Color.decode("#F5F5F5"));
        tableComponentsPanel.setBackground(Color.decode("#F5F5F5"));
        tableOnlypanel.setBackground(Color.WHITE);
        topPanel.setBounds(100, 0, 1000, 70);
        tableComponentsPanel.setBounds(100, 100, 1000, 90);
        tableOnlypanel.setBounds(100, 190, 1000, 450);
        totalLabel.setBounds(450, 2, 200, 30);
        tableComponentsPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        tableOnlypanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        topPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        addNewItemButton.setBackground(Color.decode("#FF4500"));
        printButton.setBackground(Color.decode("#193688"));
        printButton.setForeground(Color.WHITE);
        addNewItemButton.setForeground(Color.WHITE);
        sortButton.setBackground(Color.decode("#1E90FF"));
        searchButton.setBackground(Color.decode("#1E90FF"));
        topPanel.add(printButton);
        topPanel.add(addNewItemButton);
        tableComponentsPanel.add(searchButton);
        tableComponentsPanel.add(searchField2);
        tableComponentsPanel.add(sortButton);
        tableComponentsPanel.add(sortMethodCombo);
        tableOnlypanel.add(totalLabel);
        tableOnlypanel.add(tableScrollPane);
        addFieldsFocusListener(sortMethodCombo);
        addFieldsFocusListener(searchField2);
        itemsManagementPanel.add(topPanel);
        itemsManagementPanel.add(tableComponentsPanel);
        itemsManagementPanel.add(tableOnlypanel);
        searchTextFieldMouseListener(searchField2);
        addNewItemButton.addActionListener(e -> editScreen.setVisible(true));
        printButton.addActionListener(e -> printJTable(itemsTable, "Items Report"));
        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String staffCatogories[] = {"Genitor", "Cashier", "Sales "};
        DAO = new clockInClockOutTransactions();
        selectCategory = new JComboBox<>(staffCatogories);
        restaurantNameLabel = new JLabel("Name of Pharmacy");
        restaurantNameLabel.setFont(new Font("STENCIL", Font.BOLD, 36));
        enterButton = new JButton("C\nL\nE\nA\nR");
        clockInButton = new JButton("Clock In");
        clockOutButton = new JButton("Clock Out");
        clockInButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        clockOutButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        clockInButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        clockOutButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        clockInButton.setBackground(Color.decode("#00BFFF"));
        clockOutButton.setBackground(Color.RED);
        clockInButton.setForeground(Color.WHITE);
        clockOutButton.setForeground(Color.WHITE);
        enterButtonPanel = new JPanel();
        passwordorIdField = new JTextArea(1, 20);
        passwordorIdPanel = new JPanel();
        zeroToTenButtonsPanel = new JPanel();
        oneButton = new JButton("1");
        twoButton = new JButton("2");
        threeButton = new JButton("3");
        fourButton = new JButton("4");
        fiveButton = new JButton("5");
        sixButton = new JButton("6");
        sevenButton = new JButton("7");
        eightButton = new JButton("8");
        nineButton = new JButton("9");
        bottomButton = new JButton("0");
        oneButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        twoButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        threeButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        fourButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        fiveButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        sixButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        sevenButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        eightButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        nineButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        bottomButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        enterButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        enterButton.setFont(new Font("STENCIL", Font.BOLD, 30));
        oneButton.setFont(new Font("STENCIL", Font.BOLD, 30));
        twoButton.setFont(new Font("STENCIL", Font.BOLD, 30));
        threeButton.setFont(new Font("STENCIL", Font.BOLD, 30));
        fourButton.setFont(new Font("STENCIL", Font.BOLD, 30));
        fiveButton.setFont(new Font("STENCIL", Font.BOLD, 30));
        sixButton.setFont(new Font("STENCIL", Font.BOLD, 30));
        sevenButton.setFont(new Font("STENCIL", Font.BOLD, 30));
        eightButton.setFont(new Font("STENCIL", Font.BOLD, 30));
        nineButton.setFont(new Font("STENCIL", Font.BOLD, 30));
        enterButton.setBackground(Color.white);

        bottomButton.setBackground(Color.decode("#1E90FF"));
        oneButton.setBackground(Color.decode("#1E90FF"));
        twoButton.setBackground(Color.decode("#1E90FF"));
        threeButton.setBackground(Color.decode("#1E90FF"));
        fourButton.setBackground(Color.decode("#1E90FF"));
        fiveButton.setBackground(Color.decode("#1E90FF"));
        sixButton.setBackground(Color.decode("#1E90FF"));
        sevenButton.setBackground(Color.decode("#1E90FF"));
        eightButton.setBackground(Color.decode("#1E90FF"));
        nineButton.setBackground(Color.decode("#1E90FF"));
        enterButton.setForeground(Color.decode("#1E90FF"));
        errorPanel = new JPanel();
        clockInOutPanel = new JPanel();
        clockInOutPanel = new JPanel();
        passwordorIdPanel.setLayout(null);
        enterButtonPanel.setLayout(null);
        zeroToTenButtonsPanel.setLayout(new GridLayout(3, 3));
        clockInOutPanel.setLayout(null);
        errorPanel.setLayout(new BorderLayout());
        bottomButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        enterButtonPanel.setBackground(Color.YELLOW);
        zeroToTenButtonsPanel.setBackground(Color.decode("#F5F5F5"));
        passwordorIdPanel.setBackground(Color.decode("#F5F5F5"));
        clockInOutPanel.setBackground(Color.decode("#F5F5F5"));
        errorPanel.setBackground(Color.WHITE);
        passwordorIdField.setEditable(true);
        passwordorIdField.setFont(new Font("Times New Roman", Font.BOLD, 14));
        passwordorIdField.setForeground(Color.decode("#1E90FF"));
        passwordorIdField.setText("");
        clockInButton.setBounds(400, 15, 100, 80);
        clockOutButton.setBounds(520, 15, 100, 80);
        enterButton.setBounds(0, 0, 160, 280);
        selectCategory.setBounds(15, 28, 280, 50);
        enterButtonPanel.setBounds(455, 205, 160, 280);
        passwordorIdField.setBounds(10, 20, 585, 60);
        passwordorIdPanel.setBounds(15, 100, 605, 100);
        passwordorIdPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Enter Staff ID", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", Font.BOLD, 12)));
        clockInOutPanel.setBounds(620, 100, 630, 500);
        clockInOutPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Clock In/ Clock Out", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", Font.BOLD, 14)));
        zeroToTenButtonsPanel.setBounds(15, 205, 380, 200);
        errorPanel.setBounds(10, 200, 600, 400);
        bottomButton.setBounds(15, 405, 380, 80);
        passwordorIdPanel.add(passwordorIdField);
        clockInOutPanel.add(selectCategory);
        clockInOutPanel.add(clockInButton);
        clockInOutPanel.add(clockOutButton);
        zeroToTenButtonsPanel.add(oneButton);
        zeroToTenButtonsPanel.add(twoButton);
        zeroToTenButtonsPanel.add(threeButton);
        zeroToTenButtonsPanel.add(fourButton);
        zeroToTenButtonsPanel.add(fiveButton);
        zeroToTenButtonsPanel.add(sixButton);
        zeroToTenButtonsPanel.add(sevenButton);
        zeroToTenButtonsPanel.add(eightButton);
        zeroToTenButtonsPanel.add(nineButton);
        enterButtonPanel.add(enterButton);
        clockInOutPanel.add(enterButtonPanel);
        clockInOutPanel.add(passwordorIdPanel);
        clockInOutPanel.add(bottomButton);
        clockInOutPanel.add(zeroToTenButtonsPanel);
        errorPanel.add(restaurantNameLabel, BorderLayout.CENTER);
        clockInAndOutViewPanel.add(errorPanel);
        clockInAndOutViewPanel.add(clockInOutPanel);
        updateTextArea(oneButton);
        updateTextArea(twoButton);
        updateTextArea(threeButton);
        updateTextArea(fourButton);
        updateTextArea(fiveButton);
        updateTextArea(sixButton);
        updateTextArea(sevenButton);
        updateTextArea(eightButton);
        updateTextArea(nineButton);
        updateTextArea(bottomButton);
        clockOutButton.addActionListener(e -> {
            int employeePin = new Integer(passwordorIdField.getText());
            //JOptionPane.showMessageDialog(null, "The Empployee pin picked is" + employeePin, "iPOS", JOptionPane.INFORMATION_MESSAGE);
            DAO.clockOut(employeePin);
        });
        clockInButton.addActionListener(event -> {
            try {

                int employeePin = new Integer(passwordorIdField.getText());
                // JOptionPane.showMessageDialog(null, "The Empployee pin picked is" + employeePin, "iPOS", JOptionPane.INFORMATION_MESSAGE);
                DAO.clockIn(employeePin);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Employee Number");
            }
        });
        enterButton.addActionListener(e -> passwordorIdField.setText(""));
        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        topEmployeesPanel = new JPanel(null);
        tableMainPanel = new JPanel(null);
        tablePanel = new JPanel(null);
        addTaskButton = new JButton("Add Task");
        employeeDataPrintButton = new JButton("Print");
        customerIconLabel = new JLabel();
        TaskListLabel = new JLabel("Task List Management");
        numberOfRecordsLabel = new JLabel("Total: 12 Records Found");
        filterButton = new JButton("Filter");
        EmployeeSearchField = new JTextField("Search...");
        empSortByButton = new JButton("Sort By:");
        String[] shiftsSortCategories = {"ID", "From", "To", "Title", "Description", "Date"};
        sortByCombo = new JComboBox<>(shiftsSortCategories);
        taskListTable = new JTable();
        employeeTableScrollPane = new JScrollPane(taskListTable);
        employeeTableScrollPane.getViewport().setBackground(Color.WHITE);
        addTaskButton.setBounds(300, 40, 150, 30);
        addTaskButton.setBackground(Color.decode("#1E90FF"));
        empSortByButton.setBackground(Color.decode("#1E90FF"));
        filterButton.setBackground(Color.decode("#1E90FF"));
        sortByCombo.setBackground(Color.WHITE);
        employeeDataPrintButton.setBackground(Color.ORANGE);
        employeeDataPrintButton.setBounds(460, 40, 150, 30);
        customerIconLabel.setBounds(380, 5, 50, 50);
        customerIconLabel.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\customerListIcon.png"));
        TaskListLabel.setBounds(450, 5, 250, 50);
        numberOfRecordsLabel.setBounds(350, 5, 150, 30);
        filterButton.setBounds(20, 40, 100, 35);
        EmployeeSearchField.setBounds(125, 40, 200, 35);
        empSortByButton.setBounds(330, 40, 100, 35);
        sortByCombo.setBounds(435, 40, 250, 35);
        employeeTableScrollPane.setBounds(20, 80, 950, 450);
        topEmployeesPanel.setBounds(100, 0, 1000, 75);
        tableMainPanel.setBounds(100, 110, 1000, 50);
        tablePanel.setBounds(100, 160, 1000, 550);
        topEmployeesPanel.setBackground(Color.decode("#1E90FF"));
        tableMainPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        tableMainPanel.setBackground(Color.decode("#00BFFF"));
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        employeeTableScrollPane.setBorder(new LineBorder(Color.decode("#1E90FF")));
        tablePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        topEmployeesPanel.add(addTaskButton);
        topEmployeesPanel.add(employeeDataPrintButton);
        tableMainPanel.add(customerIconLabel);
        tableMainPanel.add(TaskListLabel);
        tablePanel.add(numberOfRecordsLabel);
        tablePanel.add(filterButton);
        tablePanel.add(EmployeeSearchField);
        tablePanel.add(empSortByButton);
        tablePanel.add(sortByCombo);
        tablePanel.add(employeeTableScrollPane);
        taskListViewPanel.add(topEmployeesPanel);
        taskListViewPanel.add(tableMainPanel);
        taskListViewPanel.add(tablePanel);
        addFieldsFocusListener(sortByCombo);
        addFieldsFocusListener(EmployeeSearchField);
        searchTextFieldMouseListener(EmployeeSearchField);
        //invoice reports
        topInvoicePanel = new JPanel(null);
        reportPanel = new JPanel(null);
        invoiceTableModel = new DefaultTableModel();
        inventoryTable = new JTable(invoiceTableModel);
        //Set invoice table column headers
        List<String> salesTableColumnHeaders = Arrays.asList("Invoice ID", "Sale Date", "Sold Item", "Qty", "Total", "Profit", "Pay Mode", "Served By");
        setTableColumnHeaders(salesTableColumnHeaders, invoiceTableModel);
        reportPanelScrollPane = new JScrollPane(inventoryTable);
        reportPanelScrollPane.getViewport().setBackground(Color.WHITE);
        reportPanelScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        todaysSalesButton = new JButton("Today's Sales");
        last30DaysReportsButton = new JButton("This Month");
        productIconLabel = new JLabel();
        printReportButton = new JButton();
        searchCategLabel = new JLabel("Search by Invoice ID,Served By,Customer ID,Shop ID,Pay Type or: Date to Date");
        InvoicesearchField = new JTextField("Search...");
        //  startDateField = new JTextField("Start Date");
        startDateField = new JDateChooser();
        endDateField = new JDateChooser();
        statementLineOneLabel = new JLabel("Total: " + invoiceTableModel.getRowCount() + "  Records  Found");
        statementLineTwoLabel = new JLabel("Total Sales = " + drugInventoryTransactions.getTotalSales());
        statementLineThreeLabel = new JLabel("Total Vat = 93.96");
        statementLineFourLabel = new JLabel("Total Profit =" + drugInventoryTransactions.getTotalprofitFromSales());
        statementLineFiveLabel = new JLabel("Pharmacy  Co. L.t.d");
        statementLineSixLabel = new JLabel("Pharmacy Name.com Customer Service 850 Kakamega");
        statementLineSevenLabel = new JLabel("Kakamega-Mumias Road ,CA, 94066");
        statementLineEightLabel = new JLabel("www.pharmacyName.com");
        LocalDate t2oday = LocalDate.now();
        LocalTime thisTime = LocalTime.now();
        statementLineTenLabel = new JLabel(t2oday.toString() + "  :: " + thisTime.toString());
        statementLineEightLabel = new JLabel("www.pharmacyname.com");
        statementLineNineLabel = new JLabel("Phone +8807327533098747");
        topInvoicePanel.setBounds(100, 0, 1100, 150);
        reportPanel.setBounds(100, 170, 1100, 222);
        reportPanelScrollPane.setBounds(100, 390, 1100, 300);
        todaysSalesButton.setBounds(250, 10, 200, 30);
        last30DaysReportsButton.setBounds(455, 10, 200, 30);
        searchCategLabel.setBounds(250, 45, 900, 30);
        productIconLabel.setBounds(660, 10, 50, 30);
        printReportButton.setBounds(715, 10, 50, 30);
        printReportButton.setBackground(Color.decode("#F5F5F5"));
        InvoicesearchField.setBounds(120, 80, 240, 25);
        startDateField.setBounds(370, 80, 150, 25);
        endDateField.setBounds(530, 80, 200, 25);
        generateSaleReportsByDateButton.setBounds(760, 80, 200, 25);
        statementLineOneLabel.setBounds(450, 10, 200, 20);
        statementLineTwoLabel.setBounds(220, 34, 200, 30);
        statementLineThreeLabel.setBounds(465, 34, 200, 30);
        statementLineFourLabel.setBounds(750, 34, 200, 30);
        statementLineFiveLabel.setBounds(450, 51, 200, 30);
        statementLineSixLabel.setBounds(390, 85, 300, 30);
        statementLineSevenLabel.setBounds(440, 120, 200, 30);
        statementLineEightLabel.setBounds(450, 155, 200, 30);
        statementLineNineLabel.setBounds(440, 190, 200, 30);
        statementLineTenLabel.setBounds(880, 190, 200, 30);
        inventoryTable.setBounds(0, 0, 950, 400);
        generateSaleReportsByDateButton.setForeground(Color.WHITE);
        generateSaleReportsByDateButton.setBackground(Color.decode("#1E90FF"));
        printReportButton.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\printerIcon.png"));
        productIconLabel.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\companyLogo.png"));
        todaysSalesButton.setBackground(Color.decode("#00BFFF"));
        last30DaysReportsButton.setBackground(Color.decode("#1E90FF"));
        todaysSalesButton.setForeground(Color.WHITE);
        last30DaysReportsButton.setForeground(Color.WHITE);
        topInvoicePanel.setBackground(Color.decode("#F5F5F5"));
        reportPanel.setBackground(Color.WHITE);
        topInvoicePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        reportPanel.setBorder(new LineBorder(Color.decode("#1E90FF"), 2));
        reportPanelScrollPane.setBorder(new LineBorder(Color.decode("#1E90FF"), 2));
        reportPanelScrollPane.setBackground(Color.white);
        topInvoicePanel.add(todaysSalesButton);
        topInvoicePanel.add(last30DaysReportsButton);
        topInvoicePanel.add(productIconLabel);
        topInvoicePanel.add(printReportButton);
        topInvoicePanel.add(searchCategLabel);
        topInvoicePanel.add(InvoicesearchField);
        topInvoicePanel.add(startDateField);
        topInvoicePanel.add(endDateField);
        topInvoicePanel.add(generateSaleReportsByDateButton);
        reportPanel.add(statementLineOneLabel);
        reportPanel.add(statementLineTwoLabel);
        reportPanel.add(statementLineThreeLabel);
        reportPanel.add(statementLineFourLabel);
        reportPanel.add(statementLineFiveLabel);
        reportPanel.add(statementLineSixLabel);
        reportPanel.add(statementLineSevenLabel);
        reportPanel.add(statementLineEightLabel);
        reportPanel.add(statementLineNineLabel);
        reportPanel.add(statementLineTenLabel);
        inveicePanel.add(topInvoicePanel);
        inveicePanel.add(reportPanel);
        inveicePanel.add(reportPanelScrollPane);
        onClickBlueBorder(InvoicesearchField);
        onClickBlueBorder(startDateField);
        onClickBlueBorder(endDateField);
        searchTextFieldMouseListener(InvoicesearchField);
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        ordersViewPanel = new JPanel(null);
        printReportButton.addActionListener(e -> printJTable(inventoryTable, "Inventory Report"));
        ordersViewPanel.setBackground(Color.white);
        PointofSaleLabel = new JMenu("Point of Sale");
        foodItemsPanel = new JPanel();
        deletLastButton = new JButton("Delete Last");
        productDetailsPanel = new JPanel();
        titleOfLocggedUser = new JMenu("Admin:");
        currentLoggedEmail = new JMenu("samuelowino43@gmail.com");
        reports = new JMenu("Reports");
        users = new JMenu("Users");
        customers = new JMenu("Customer");
        itemsMenu = new JMenu("Items");
        salesRegister = new JMenu("Sales");
        totalItemsNoLabel = new JLabel("Items:  2");
        totalAmountToBePaidLabel = new JLabel("Total:  123.00");
        VATLabel = new JLabel("VAT:  78.00%");
        subTotalLabel = new JLabel("Sub Total:  456.00");
        paymentButton = new JButton("Payment");
        searchField2 = new JTextField();
        tempPanel = new JPanel();

        tempPanel.setBackground(Color.RED);
        popUpmenu = new JPopupMenu();
        newOrderMenu = new JMenuItem("Sale");
        printNotificationMenuItem = new JMenuItem("Print Notification");
        printBillMenuItem = new JMenuItem("Print Bill");
        closeOrderMenuItem = new JMenuItem("Close Order");
        transferOrdermenuItem = new JMenuItem("Transfer Order");
        splitManuItem = new JMenuItem("Split Menue");
        divideOrderMenuItem = new JMenuItem("Divide Order");
        logOffMenuItem = new JMenuItem("Log OFF");
        enterBeginCashMenuItem = new JMenuItem("Enter Begin Cash");
        reconcileCashDrawerMenuItem = new JMenuItem("Reconcile Cash Drawer");
        endOfDayMenuItem = new JMenuItem("End OF Day");
        exitmenuItem = new JMenuItem("Exit");
        newOrderMenuItem = new JMenuItem("New Sale");
        newNoticeMenuItem = new JMenuItem("New Notice");
        newUserMenuItem = new JMenuItem("New User");
        newEmployeeMenuItem = new JMenuItem("New Employee");
        exitMenuItem2 = new JMenuItem("Exit");
        purchaseVoucherMenuItem = new JMenuItem("Purchase Voucher");
        returnVoucherManuItem = new JMenuItem("Return Voucher");
        vendorsMenuItem = new JMenuItem("Vendors");
        purchaseMenuOrders = new JMenuItem("Purchase Menu Orders");
        ordersMenuItem = new JMenuItem("Orders");
        taskListViewMenuItem = new JMenuItem("Task List");
        loansViewMenuItem = new JMenuItem("Loans");
        clientsMenuItem = new JMenuItem("Clients");
        shiftMenuItem = new JMenuItem("Shifts");
        reportsMenuItem = new JMenuItem("Invoice Reports");
        emailSenderManuitem = new JMenuItem("Email Sender");
        toolBarsMenuItem = new JMenu("ToolBars");
        standardSubMenItem = new JMenuItem("Standard");
        hearderSubMenuItem = new JMenuItem("Headers");
        languageMenuITem = new JMenu("Language");
        themeMenuItem = new JMenu("Theme");
        englishSubMenuItem = new JMenuItem("English");
        frenchSubMenuItem = new JMenuItem("French");
        germanSubMenuItem = new JMenuItem("German");
        abcreThemeMenuItem = new JMenuItem("Abcre");
        abcre2ThemeMenuItem = new JMenuItem("Abcre2");
        aquaMenuItem = new JMenuItem("Aqua");
        barcieMenuItem = new JMenuItem("Barcie");
        classsicThemeMenuItem = new JMenuItem("Classic");
        silverManueItem = new JMenuItem("Silver");
        preferenceMenuItem = new JMenuItem("Preference");
        propertiesSettingsMenu = new JMenuItem("Properties Settings");
        workersMenuItem = new JMenuItem("Workers");
        menuItemMenuItem = new JMenuItem("Menu Items");
        menuMenuItem = new JMenuItem("Menu");
        menuItemCategoriesMenuItem = new JMenuItem("Menu Item Categories");
        menuItemModifiersMenuItem = new JMenuItem("Menu Item Modifier");
        tablesmenuItem = new JMenuItem("Tables");
        tablesPlanMenuItem = new JMenuItem("Tables Plan");
        billConfigurationMenuItem = new JMenuItem("Bill Configuration");
        paymentMethodsMenuItem = new JMenuItem("Payment Methods");
        notificationPrintersMenuItem = new JMenuItem("Notification Printers");
        discountsMeuItem = new JMenuItem("Discounts");
        personalisationMenu = new JMenu("Personalisation");
        taskMenuItem = new JMenuItem("Task ");
        settingsMenuitem = new JMenuItem("Company");
        logOutMenuItem = new JMenuItem("Log Out");
        fileMenu = new JMenu("File");
        displaySettingsMenu = new JMenu("Display Settings");
        editMenu = new JMenu("Edit");
        actionMenu = new JMenu("Action");
        viewMenu = new JMenu("View");
        purchasingMenu = new JMenu("Purchasing");
        configurationMenu = new JMenu("Configuration");
        helpMenu = new JMenu("Help");
        salesRegisterMenu = new JMenu("Sales Register");
        reportsMenu = new JMenu("Reports");
        usersMenu = new JMenu("users");
        itemsMenu = new JMenu("Items");
        customersMenu = new JMenu("Customer");
        adminMenu = new JMenu("Admin");
        emailAddressMenu = new JMenu("samueladmin@gmail.com");
        //PrepareMenuItems --> itemsMenu
        addnewItemMenuItem = new JMenuItem("Add New Item");
        manageItemMenuItem = new JMenuItem("Manage Items");
        itemsListMenuItem = new JMenuItem("Items List");
        categoriesMenuItem = new JMenuItem("Categories");
        //PrepareMenuItems --> customerMenu
        addCustomerMenuItem = new JMenuItem("Add Customer");
        manageCustomersMenuItem = new JMenuItem("Manage Customers");
        //PrepareMenuItems --> usersMenu
        addUsersmenuitem = new JMenuItem("Add Users");
        manageUserMenuItem = new JMenuItem("Manage Users");
        //PrepareMenuItems --> editMenu
        undoMenuItem = new JMenuItem("Undo");
        redoMenuItem = new JMenuItem("Redo");
        cutMenuItem = new JMenuItem("Cut");
        copyMenuItem = new JMenuItem("Copy");
        pasteMenuItem = new JMenuItem("Past");
        pastFormatedmenuItem = new JMenuItem("Past Formated");
        pastFromMenuItem = new JMenuItem("Past From Past History");
        deleteMenuItem = new JMenuItem("Delete");
        selectAllMenuItem = new JMenuItem("Select All");
        findSelectionMenuItem = new JMenuItem("Find Selection");
        findUsageMenuItem = new JMenuItem("Find Usage");
        findPreviouseMenuItem = new JMenuItem("Find Previouse");
        findMenuItem = new JMenuItem("Find");
        selectIdentifierMenuItem = new JMenuItem("Select Identifier");
        replaceMenuItem = new JMenuItem("Replace");
        findUsageMenuItem = new JMenuItem("Find Usage");
        findNextMenuItem = new JMenuItem("Find Next");
        reportsMenu.add(Box.createHorizontalStrut(200));
        reportsMenu.add(salesMenuItem);
        reportsMenu.add(taxesMenuItem);
        reportsMenu.add(inventoryMenuItem);
        reportsMenu.add(invoiceMenuItem);
        reportsMenu.add(advancedViewMenuItem);
        reportsMenu.addSeparator();
        menuBar = new JMenuBar();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
        splitPane.setDividerLocation(5);
        splitPane.setEnabled(false);
        splitPane.setDividerSize(5);
        //splitPane.setRightComponent (new JPanel());
        splitPane.setLeftComponent(new JPanel());
        splitPane.setBackground(Color.WHITE);
        PointofSaleLabel = new JMenu("Point of Sale");
        foodItemsPanel = new JPanel();
        deletLastButton = new JButton("Delete Last");
        productDetailsPanel = new JPanel();
        titleOfLocggedUser = new JMenu("Admin:");
        currentLoggedEmail = new JMenu("samuelowino43@gmail.com");
        reports = new JMenu("Reports");
        users = new JMenu("Users");
        customers = new JMenu("Customer");
        itemsMenu = new JMenu("Items");
        salesRegister = new JMenu("Sales");
        totalItemsNoLabel = new JLabel("Items:  2");
        totalAmountToBePaidLabel = new JLabel("Total:  123.00");
        VATLabel = new JLabel("VAT:  78.00%");
        subTotalLabel = new JLabel("Sub Total:  456.00");
        paymentButton = new JButton("Payment");
        searchField2 = new JTextField();
        String[] searchCategoryItems = {"All", "Code", "Item Name", "Qty", "Price", "Total"};
        searcByCategoryComboBox = new JComboBox<>(searchCategoryItems);
        salesTable = new JTable();
        salesTable.setEnabled(false);
        salesTable.setEnabled(false);
        leftPanelScrollPane = new JScrollPane(salesTable);
        leftPanelScrollPane.getViewport().setBackground(Color.WHITE);
        rightPanelScrollPane = new JScrollPane(foodItemsPanel);
        rightPanelScrollPane.getViewport().setBackground(Color.WHITE);
        searcByCategoryButton = new JButton();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        /*8
         @RESEARCH
         FIND OUT HOW TO MAKE THE ENDS OF A PANEL BE CURVED
         HOW TO CURVE BUTTON WITHOUT LEAVING RESIDUE IN SWING
         CONSTRUCTION OF A TABLE MODEL FRO A JTABLE
         */
        leftPanel.setBackground(Color.decode("#F5F5F5"));
        String[] items = {"", "Ugali", "Fish", "", "", "", "", "", "", "", "", "Ugali", "Fish", "", "", "", "", "", "", "", "", "Ugali", "Fish", "", "", "", "", "", "", "", "", "Ugali", "Fish", "", "", "", "", "", "", "", "", "Ugali", "Fish", "", "", "", "", "", "", ""};
        searchByCategoryLabel = new JLabel("Search By Category:");
        foodItemsPanel.setLayout(new GridLayout((items.length - 5) / 4, 0, 5, 5));
        foodItemsPanel.setBackground(Color.WHITE);
        searcByCategoryComboBox.setBounds(670, 670, 220, 30);
        searchByCategoryLabel.setBounds(550, 655, 120, 50);
        foodItemsPanel.setSize(395, 1000);
        productDetailsPanel.setBackground(Color.WHITE);
        deletLastButton.setBounds(70, 655, 100, 50);
        users.setSize(50, 50);
        PointofSaleLabel.setEnabled(false);
        currentLoggedEmail.setForeground(Color.WHITE);
        salesRegister.setForeground(Color.WHITE);
        customers.setForeground(Color.WHITE);
        titleOfLocggedUser.setForeground(Color.WHITE);
        reports.setForeground(Color.WHITE);
        PointofSaleLabel.setForeground(Color.WHITE);
//        menuBar.setForeground(Color.WHITE);
        itemsMenu.setForeground(Color.WHITE);
        personalisationMenu.setForeground(Color.WHITE);
        fileMenu.setForeground(Color.WHITE);
        suppliers.setForeground(Color.WHITE);
        salesMenu.setForeground(Color.WHITE);
        stockMenu.setForeground(Color.WHITE);
        reportsMenu.setForeground(Color.WHITE);
        displaySettingsMenu.setForeground(Color.WHITE);
        editMenu.setForeground(Color.WHITE);
        actionMenu.setForeground(Color.WHITE);
        viewMenu.setForeground(Color.WHITE);
        purchasingMenu.setForeground(Color.WHITE);
        configurationMenu.setForeground(Color.WHITE);
        helpMenu.setForeground(Color.WHITE);
        salesRegisterMenu.setForeground(Color.WHITE);
        reportsMenu.setForeground(Color.WHITE);
        usersMenu.setForeground(Color.WHITE);
        itemsMenu.setForeground(Color.WHITE);
        customersMenu.setForeground(Color.WHITE);
        adminMenu.setForeground(Color.WHITE);
        emailAddressMenu.setForeground(Color.WHITE);
//        menuBar.add(Box.createVerticalGlue());
        editMenu.setFont(new Font("New Times Roman", Font.BOLD, 20));
        itemsMenu.setFont(new Font("New Times Roman", Font.BOLD, 20));
        users.setFont(new Font("New Times Roman", Font.BOLD, 20));
        PointofSaleLabel.setFont(new Font("New Times Roman", Font.BOLD, 20));
        titleOfLocggedUser.setFont(new Font("New Times Roman", Font.BOLD, 20));
        reports.setFont(new Font("New Times Roman", Font.BOLD, 20));
        customers.setFont(new Font("New Times Roman", Font.BOLD, 20));
        salesRegister.setFont(new Font("New Times Roman", Font.BOLD, 20));
        fileMenu.setFont(new Font("New Times Roman", Font.BOLD, 20));
        suppliers.setFont(new Font("New Times Roman", Font.BOLD, 20));
        salesMenu.setFont(new Font("New Times Roman", Font.BOLD, 20));
        stockMenu.setFont(new Font("New Times Roman", Font.BOLD, 20));
        helpMenu.setFont(new Font("New Times Roman", Font.BOLD, 20));
        reportsMenu.setFont(new Font("New Times Roman", Font.BOLD, 20));
        customersMenu.setFont(new Font("New Times Roman", Font.BOLD, 20));
        reports.setForeground(Color.WHITE);
        users.setForeground(Color.WHITE);
        leftPanel.setLayout(null);
        rightPanel.setLayout(null);
        leftPanelScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        rightPanelScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        leftPanelScrollPane.setBackground(Color.WHITE);
        rightPanelScrollPane.setBackground(Color.WHITE);
        userProfilelabel.setForeground(Color.WHITE);
        paymentButton.setBounds(210, 655, 100, 50);
        rightPanelScrollPane.setBounds(1, 0, 800, 600);
        totalItemsNoLabel.setBounds(200, 520, 200, 30);
        totalAmountToBePaidLabel.setBounds(200, 500, 200, 30);
        VATLabel.setBounds(200, 480, 200, 30);
        subTotalLabel.setBounds(200, 450, 200, 30);
        leftPanelScrollPane.setBounds(2, 40, 395, 400);
        leftPanel.setBounds(20, 45, 400, 600);
        rightPanel.setBounds(430, 45, 800, 600);
        searcByCategoryButton.setBounds(5, 5, 30, 30);
        searchField2.setBounds(40, 5, 320, 30);
        leftPanel.add(leftPanelScrollPane);
        rightPanel.setBackground(Color.MAGENTA);
        searcByCategoryButton.setBackground(Color.GRAY);
        deletLastButton.setBackground(Color.decode("#DC143C"));
        paymentButton.setBackground(Color.decode("#32CD32"));
        searcByCategoryButton.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\serachIcon.jpg"));
        leftPanel.add(subTotalLabel);
        leftPanel.add(searchField2);
        leftPanel.add(VATLabel);
        leftPanel.add(totalAmountToBePaidLabel);
        leftPanel.add(totalItemsNoLabel);
        rightPanel.add(rightPanelScrollPane);
        ordersViewPanel.add(leftPanel);
        ordersViewPanel.add(rightPanel);
        ordersViewPanel.add(deletLastButton);
        ordersViewPanel.add(paymentButton);
        ordersViewPanel.add(searchByCategoryLabel);
        ordersViewPanel.add(searcByCategoryComboBox);
        leftPanel.add(searcByCategoryButton);
        menuBar.setBorder(new LineBorder(Color.WHITE, 5));
        //CREATE MOUSE LISTNERS FOR THE MENUBAR 
        menuBar.addMouseListener(
                new MouseListener() {
            @Override
            public void mousePressed(MouseEvent event) {
                //DON NOTHING 
            }

            @Override
            public void mouseClicked(MouseEvent event) {
                //DON NOTHING 
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                //DON NOTHING
            }

            @Override
            public void mouseExited(MouseEvent event) {

                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseEntered(MouseEvent event) {
                //menuBar.setBorder(new LineBorder(Color.decode("#F5F5F5"), 5));\
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

        }
        );

        adminMenu.add(Box.createHorizontalStrut(200));
        // adminMenu.add(profileMenuItem);

        adminMenu.add(taskMenuItem);
        adminMenu.add(settingsMenuitem);
        adminMenu.add(logOutMenuItem);
        adminMenu.add(usersMenu);
        usersMenu.add(Box.createHorizontalStrut(200));
        usersMenu.add(addUsersmenuitem);
        usersMenu.addSeparator();
        usersMenu.add(manageUserMenuItem);
        usersMenu.add(adminMenu);
        customersMenu.add(Box.createHorizontalStrut(200));
        customersMenu.add(addCustomerMenuItem);
        customersMenu.addSeparator();
        customersMenu.add(manageCustomersMenuItem);
        stockMenu.add(Box.createHorizontalStrut(200));
        stockMenu.add(addnewItemMenuItem);
        itemsMenu.add(Box.createHorizontalStrut(200));
        itemsMenu.add(addnewItemMenuItem);
        itemsMenu.add(manageItemMenuItem);
        itemsMenu.add(itemsListMenuItem);
        itemsMenu.addSeparator();
        itemsMenu.add(categoriesMenuItem);
        //PrepareMenuItems --> HelpMenu
        contentsMenuItem = new JMenuItem("Contents");
        feedBackmenuItem = new JMenuItem("FeedBack");
        deactivateMenuItem = new JMenuItem("Deactivate");
        aboutMenuItem = new JMenuItem("About");
        helpMenu.add(Box.createHorizontalStrut(200));
        helpMenu.add(contentsMenuItem);
        helpMenu.add(feedBackmenuItem);
        helpMenu.add(deactivateMenuItem);
        helpMenu.add(aboutMenuItem);
        configurationMenu.add(Box.createHorizontalStrut(200));
        configurationMenu.add(propertiesSettingsMenu);
        configurationMenu.add(preferenceMenuItem);
        configurationMenu.add(workersMenuItem);
        configurationMenu.add(menuItemMenuItem);
        configurationMenu.add(menuMenuItem);
        configurationMenu.add(menuItemCategoriesMenuItem);
        configurationMenu.add(menuItemModifiersMenuItem);
        configurationMenu.add(tablesmenuItem);
        configurationMenu.add(tablesPlanMenuItem);
        configurationMenu.add(billConfigurationMenuItem);
        configurationMenu.add(paymentMethodsMenuItem);
        configurationMenu.add(notificationPrintersMenuItem);
        configurationMenu.add(discountsMeuItem);
        languageMenuITem.add(Box.createHorizontalStrut(200));
        languageMenuITem.add(englishSubMenuItem);
        languageMenuITem.addSeparator();
        languageMenuITem.add(frenchSubMenuItem);
        languageMenuITem.add(germanSubMenuItem);
        themeMenuItem.add(Box.createHorizontalStrut(200));
        themeMenuItem.add(abcreThemeMenuItem);
        themeMenuItem.add(abcre2ThemeMenuItem);
        themeMenuItem.add(aquaMenuItem);
        themeMenuItem.add(barcieMenuItem);
        themeMenuItem.add(classsicThemeMenuItem);
        themeMenuItem.add(silverManueItem);
        toolBarsMenuItem.add(Box.createHorizontalStrut(200));
        toolBarsMenuItem.add(standardSubMenItem);
        toolBarsMenuItem.addSeparator();
        toolBarsMenuItem.add(hearderSubMenuItem);
        //add menu Items to  ViewMenu
        viewMenu.add(Box.createHorizontalStrut(200));
        viewMenu.add(ordersMenuItem);
        viewMenu.add(clientsMenuItem);
        viewMenu.add(shiftMenuItem);
        viewMenu.add(taskListViewMenuItem);
        viewMenu.add(reportsMenuItem);
        viewMenu.add(loansViewMenuItem);
        viewMenu.add(emailSenderManuitem);
        viewMenu.add(toolBarsMenuItem);
        viewMenu.add(languageMenuITem);
        viewMenu.add(themeMenuItem);
        //add menu Items to  purchaseMenu
        purchasingMenu.add(Box.createHorizontalStrut(200));
        purchasingMenu.add(purchaseMenuOrders);
        purchasingMenu.add(Box.createVerticalStrut(20));
        purchasingMenu.add(purchaseVoucherMenuItem);
        purchasingMenu.add(Box.createVerticalStrut(20));
        purchasingMenu.add(returnVoucherManuItem);
        purchasingMenu.add(Box.createVerticalStrut(20));
        purchasingMenu.add(vendorsMenuItem);
        //add menu Items to File Menu

        fileMenu.add(Box.createHorizontalStrut(200));
        fileMenu.add(newOrderMenuItem);
        fileMenu.add(settingsMenuitem);
        fileMenu.add(addUsersmenuitem);
        fileMenu.add(newNoticeMenuItem);
        fileMenu.add(newEmployeeMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(Box.createVerticalStrut(30));
        fileMenu.add(exitMenuItem2);
        newOrderMenuItem.setBackground(Color.WHITE);
        settingsMenuitem.setBackground(Color.WHITE);
        addUsersmenuitem.setBackground(Color.WHITE);
        newNoticeMenuItem.setBackground(Color.WHITE);
        newEmployeeMenuItem.setBackground(Color.WHITE);
        exitMenuItem2.setBackground(Color.WHITE);
        //salesMenu -->items
        salesMenu.add(Box.createHorizontalStrut(200));
        salesMenu.add(newOrderMenu);
        salesMenu.add(salesReportsMenu);
        newOrderMenu.setBackground(Color.WHITE);
        salesReportsMenu.setBackground(Color.WHITE);
        //PrepareMenuItems --> InventoryMenu
        stockMenu.add(addnewItemMenuItem);
        stockMenu.add(manageItemMenuItem);
        addnewItemMenuItem.setBackground(Color.WHITE);
        manageItemMenuItem.setBackground(Color.WHITE);
        //add menu Items to Inventory Menu
        //Set Accelerators for Action Menu MenuItems
        newOrderMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        printNotificationMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        printBillMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        logOffMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        exitmenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        exitMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        //add menu Items to Action Menu 
        actionMenu.add(Box.createHorizontalStrut(200));
        actionMenu.add(newOrderMenu);
        actionMenu.add(printBillMenuItem);
        actionMenu.add(printNotificationMenuItem);
        actionMenu.add(closeOrderMenuItem);
        actionMenu.add(transferOrdermenuItem);
        actionMenu.add(splitManuItem);
        actionMenu.add(divideOrderMenuItem);
        actionMenu.add(logOffMenuItem);
        actionMenu.add(barCodeViewMenuItem);
        actionMenu.addSeparator();
        actionMenu.add(clockInClockOutMenuItem);
        actionMenu.addSeparator();
        actionMenu.add(enterBeginCashMenuItem);
        actionMenu.add(reconcileCashDrawerMenuItem);
        actionMenu.add(endOfDayMenuItem);
        actionMenu.addSeparator();
        actionMenu.add(exitmenuItem);
        addCustomerMenuItem.setBackground(Color.WHITE);
        manageCustomersMenuItem.setBackground(Color.WHITE);
        addnewItemMenuItem.setBackground(Color.WHITE);
        manageItemMenuItem.setBackground(Color.WHITE);
        itemsListMenuItem.setBackground(Color.WHITE);
        categoriesMenuItem.setBackground(Color.WHITE);
        feedBackmenuItem.setBackground(Color.WHITE);
        deactivateMenuItem.setBackground(Color.WHITE);
        aboutMenuItem.setBackground(Color.WHITE);
        //Set Accelerators for Edit Menu MenuItems
        undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        redoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        pastFromMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.SHIFT_MASK));
        pastFormatedmenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.SHIFT_MASK));
        deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.SHIFT_MASK));
        selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        selectIdentifierMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
        findSelectionMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.CTRL_MASK));
        findNextMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        findPreviouseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.SHIFT_MASK));
        findMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        replaceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        replaceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        findUsageMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, ActionEvent.ALT_MASK));
        //add menu Items to editMenu
        editMenu.add(Box.createHorizontalStrut(200));
        editMenu.add(undoMenuItem);
        editMenu.add(redoMenuItem);
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.add(pastFormatedmenuItem);
        editMenu.add(pastFromMenuItem);
        editMenu.add(deleteMenuItem);
        editMenu.add(selectAllMenuItem);
        editMenu.add(selectIdentifierMenuItem);
        editMenu.addSeparator();
        editMenu.add(findSelectionMenuItem);
        editMenu.add(findNextMenuItem);
        editMenu.add(findPreviouseMenuItem);
        editMenu.addSeparator();
        editMenu.add(findMenuItem);
        editMenu.add(replaceMenuItem);
        editMenu.add(findUsageMenuItem);
        salesMenu.add(newOrderMenuItem);
        //add menues to Menu bar
        changeCursorTypesForMenues(suppliers);
        changeCursorTypesForMenues(helpMenu);
        changeCursorTypesForMenues(stockMenu);
        changeCursorTypesForMenues(fileMenu);
        changeCursorTypesForMenues(editMenu);
        changeCursorTypesForMenues(salesMenu);
        changeCursorTypesForMenues(stockMenu);
        changeCursorTypesForMenues(customersMenu);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(salesMenu);
        menuBar.add(stockMenu);
        menuBar.add(customersMenu);
        suppliers.add(Box.createHorizontalStrut(200));
        suppliers.add(Box.createVerticalStrut(20));
        suppliers.add(viewSuppliers);
        menuBar.add(suppliers);
        menuBar.add(helpMenu);
        menuBar.add(helpMenu);
        inventoryViewPanel.setBackground(Color.WHITE);
        menuBar.add(Box.createVerticalStrut(50));
        menuBar.setBackground(Color.decode("#1E90FF"));
        popUpmenu.addSeparator();
        popUpmenu.add(personalisationMenu);
        popUpmenu.add(displaySettingsMenu);
        ordersViewPanel.setBackground(Color.WHITE);
        clockInAndOutViewPanel.setBackground(Color.WHITE);
        splitPane.setRightComponent(clockInAndOutViewPanel);
        splitPane.getLeftComponent().setBackground(Color.WHITE);
        logOutMenuItem.addActionListener((ActionEvent event) -> {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to Log Out ?", "Alpha POS", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (option) {
                case JOptionPane.YES_OPTION:
                    //display log in
                    //  setVisible(false);
                    new LogInAndAuthentication().setVisible(true);
                    break;
                case JOptionPane.NO_OPTION:
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
                default:
                    break;
            }
        });
        manageItemMenuItem.addActionListener(e -> {
            retrieveInventoryData();
            inventoryTotalLabel.setText("Total:" + stockTabelModel.getRowCount() + "  Records Found");
            splitPane.remove(splitPane.getRightComponent());
            splitPane.setRightComponent(inventoryViewPanel);
            repaint();
        });
        addnewItemMenuItem.addActionListener(e -> {
            editScreen.setVisible(true);
            editScreen.saveButton.addActionListener(event -> {
            });

        });
        viewSuppliers.addActionListener(e -> {
            getSuppliersData();
            suppliersPatientTotalLabel.setText("Total: " + suppliersModel.getRowCount() + "  Records Found");
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            suppliersInfoViewPanel.setBackground(Color.WHITE);
            splitPane.setRightComponent(suppliersInfoViewPanel);
        });
        // inveicePanel
        salesReportsByCategory.addActionListener(e -> {
            getsalesInvoice();
            LocalDate today = LocalDate.now();
            int month = today.getMonth().getValue() - 1;
            LocalDate lastMonth = LocalDate.of(today.getYear(), month, today.getDayOfMonth());
            LocalDate llastMonth = LocalDate.of(today.getYear(), month, lastMonth.getMonth().minLength());
            statementLineOneLabel.setText("Total: " + invoiceTableModel.getRowCount() + "  Records  Found");
            statementLineFourLabel.setText("Total Profit =" + drugInventoryTransactions.getTotalprofitFromSales());
            statementLineTwoLabel.setText("Total Sales = " + drugInventoryTransactions.getTotalSales());
            statementLineOneLabel.setText("Total: " + invoiceTableModel.getRowCount() + "  Records  Found");
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            inveicePanel.setBackground(Color.WHITE);
            splitPane.setRightComponent(inveicePanel);
        });
        //Replce Right split pane views
        newNoticeMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(addNewTaskPanel));
        taskMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(addNewTaskPanel));
        newOrderMenu.addActionListener(event -> replaceRightComponentOnSplitPane(processPayMentsViewPanel));
        newOrderMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(processPayMentsViewPanel));
        itemsListMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(itemsManagementPanel));
        clockInClockOutMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(clockInAndOutViewPanel));
        taskListViewMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(taskListViewPanel));
        manageUserMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(viewUserPanel));
        newUserMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(addNewUserPanelView));
        addUsersmenuitem.addActionListener(event -> replaceRightComponentOnSplitPane(addNewUserPanelView));
        shiftMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(shiftsViewPanel));
        manageCustomersMenuItem.addActionListener(event -> {
            retrieveCustomerData();
            customerPatientTotalLabel = new JLabel("Total:" + customerModel.getRowCount() + " Records Found");
            customerPatientTotalLabel.setBounds(450, 2, 200, 30);
            customerpatientTableOnlypanel.add(customerPatientTotalLabel);
            replaceRightComponentOnSplitPane(viewCustomerInformationDetailsView);
        });
        clientsMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(customersViewPanel));
        loansViewMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(loansPanelView));
        settingsMenuitem.addActionListener(event -> replaceRightComponentOnSplitPane(settingsPanel));
        ordersMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(orderDetailsMainViewPanel));
        inventoryMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(inventoryViewPanel));
        printNotificationMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(addNewTaskPanel));
        paymentButton.addActionListener(event -> replaceRightComponentOnSplitPane(processPayMentsViewPanel));
        newEmployeeMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(addNewEmplyeeViewPanel));
        closeOrderMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(processPayMentsViewPanel));
        invoiceMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(inveicePanel));
        addCustomerMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(addNewPatientCustomerViewPanel));
        addNewLoanItemButton.addActionListener(event -> editScreen.setVisible(true));
        //print reports
        printLoanButton.addActionListener(event -> printJTable(LoansTable, "Loans Report"));
        inventoryViewsaddNewItemButton.addActionListener(event -> editScreen.setVisible(true));
        inventoryPrintButton.addActionListener(event -> printJTable(inventoryItemsTable, "Inventory Report"));

        addItemToSalesButton.addActionListener(e -> {

            if (drugInventoryTransactions.reduceDrugQtyFromStock(drugInventoryTransactions.getAvailabelDrugQty(selectItemsCombo.getSelectedItem().toString()), new Integer(selectQtySpinner.getValue().toString()), selectItemsCombo.getSelectedItem().toString()) == true) {
                Double price = new Double(productSalesTransactions.getItemPrice(selectItemsCombo.getSelectedItem().toString()));
                int qty = new Integer(selectQtySpinner.getValue().toString());
                Double total = price * qty;
                productSalesTransactions.addParticularSaleData(selectItemsCombo.getSelectedItem().toString(), selectQtySpinner.getValue().toString(), productSalesTransactions.getItemPrice("23"), total.toString());
                itemsPrices = new Double(drugInventoryTransactions.getItemPrice(selectItemsCombo.getSelectedItem().toString()));
                Double quty = new Double(selectQtySpinner.getValue().toString());
                itemsPrices *= quty;
                itemsPrices += new Double(amountDueField.getText());
                amountDueField.setText(itemsPrices.toString());
                Double profit = itemsPrices - 34;
                drugInventoryTransactions.insertTransactionIntoInvoiceTable("3456", selectItemsCombo.getSelectedItem().toString(), selectQtySpinner.getValue().toString(), total.toString(), profit.toString(), payModeComboBox.getSelectedItem().toString(), amountReceivedWindow.getText(), changeField.getText(), "Admin");
            }
        });
        todaysSalesButton.addActionListener(e -> {
            getTodaySales();
            LocalDate today = LocalDate.now();
            int month = today.getMonth().getValue() - 1;
            LocalDate lastMonth = LocalDate.of(today.getYear(), month, today.getDayOfMonth());
            LocalDate llastMonth = LocalDate.of(today.getYear(), month, lastMonth.getMonth().minLength());
            statementLineOneLabel.setText("Total: " + invoiceTableModel.getRowCount() + "  Records  Found");
            statementLineFourLabel.setText("Total Profit =" + drugInventoryTransactions.getTodaysProfit());
            statementLineTwoLabel.setText("Total Sales = " + drugInventoryTransactions.getTodaysSales());

        });
        last30DaysReportsButton.addActionListener(e -> {
            LocalDate today = LocalDate.now();
            int month = today.getMonth().getValue() - 1;
            LocalDate lastMonth = LocalDate.of(today.getYear(), month, today.getDayOfMonth());
            LocalDate llastMonth = LocalDate.of(today.getYear(), month, lastMonth.getMonth().minLength());
            getThisMonthsSales();
            statementLineFourLabel.setText("Total Profit =" + drugInventoryTransactions.getTotalProfitFromSalesByDate(llastMonth, LocalDate.now()));
            statementLineTwoLabel.setText("Total Sales = " + drugInventoryTransactions.getTotalSalesByDate(llastMonth, LocalDate.now()));
            statementLineOneLabel.setText("Total: " + invoiceTableModel.getRowCount() + "  Records  Found");
        }
        );
        generateSaleReportsByDateButton.addActionListener(event -> {
            Calendar calendarInstance = Calendar.getInstance();
            calendarInstance.setTime(endDateField.getDate());
            LocalDate endDate = LocalDate.of(calendarInstance.get(Calendar.YEAR), calendarInstance.get(Calendar.MONTH) + 1, calendarInstance.get(Calendar.DAY_OF_MONTH));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDateField.getDate());
            LocalDate startDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
            getSalesByDate(startDate, endDate);
            statementLineFourLabel.setText("Total Profit =" + drugInventoryTransactions.getTotalProfitFromSalesByDate(startDate, endDate));
            statementLineTwoLabel.setText("Total Sales = " + drugInventoryTransactions.getTotalSalesByDate(startDate, endDate));
            statementLineOneLabel.setText("Total: " + invoiceTableModel.getRowCount() + "  Records  Found");

        });
        getContentPane().add(splitPane);
        setJMenuBar(menuBar);
        repaint();
        setVisible(visible);
    }

    //add Fileds Focus Listeners
    public final void addFieldsFocusListener(final JComponent componentObject) {
        componentObject.addFocusListener(
                new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent event) {
                componentObject.setBorder(new LineBorder(Color.decode("#1E90FF"), 2));
            }

            @Override
            public void focusLost(FocusEvent event) {
                componentObject.setBorder(new LineBorder(Color.black, 1));
            }
        }
        );
    }

    public final void connectToDatabase() {
        try {
            String dsn = "Medi";
            //Load Driver
            Class.forName("com.mysql.jdbc.Driver");
            //make connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppos", "root", "");
            //create statement
            st = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public final void retrieveCustomerData() {
        try {
            int row = customerModel.getRowCount();
            while (row > 0) {
                row--;
                customerModel.removeRow(row);
            }

            //execute query
            ResultSet resultSet = st.executeQuery("select * from customers;");

            // get metadata
            ResultSetMetaData md = resultSet.getMetaData();
            int colcount = md.getColumnCount();

            Object[] data = new Object[colcount];
            //extracting data
            while (resultSet.next()) {
                for (int i = 1; i <= colcount; i++) {
                    data[i - 1] = resultSet.getString(i);
                }
                customerModel.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public final void onClickBlueBorder(final JComponent componentObject) {
        //Mouse Listener
        componentObject.addMouseListener(
                new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent event) {
                componentObject.setBorder(new LineBorder(Color.decode("#1E90FF"), 2));
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                componentObject.setBorder(new LineBorder(Color.decode("#1E90FF"), 2));
            }

            @Override
            public void mousePressed(MouseEvent event) {
                componentObject.setBorder(new LineBorder(Color.decode("#1E90FF"), 2));
            }

            @Override
            public void mouseEntered(MouseEvent event) {
                componentObject.setBorder(new LineBorder(Color.decode("#1E90FF")));
            }

            @Override
            public void mouseExited(MouseEvent event) {
            }
        }
        );
    }

    public final void updatePayTextArea(final JButton ValueButton) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ValueButton.addActionListener((ActionEvent event) -> {
                amountReceivedWindow.append(ValueButton.getText());
            });
        });

    }

    //Process processPayChange
    public final double getChange(double amounPaid, double amountDue) {

        processPayChange = amounPaid - amountDue;
        return processPayChange;
    }

    //Process Net amt
    public final double getNetAmount(final double change, double amountDue) {
        double net = 0.0;
        if (change < 0) {
            net = 0.0;
            JOptionPane.showMessageDialog(null, "Payment incomplete!!");
            changeField.setText("0.00");
        } else if (change > 0) {
            net = amountDue;
        }
        return net;
    }

    //Search TextField mouseListener
    public final void searchTextFieldMouseListener(final JTextField textFieldObject) {
        textFieldObject.addMouseListener(
                new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent event) {
                if (textFieldObject.getText().equals("Search...")) {
                    textFieldObject.setText("");
                    textFieldObject.setBackground(Color.BLUE);
                }

            }

            @Override
            public void mouseExited(MouseEvent event) {
                if (textFieldObject.getText().equals("")) {
                    textFieldObject.setText("Search...");
                    textFieldObject.setForeground(Color.BLACK);
                }
            }

            @Override
            public void mouseEntered(MouseEvent event) {
                if (textFieldObject.getText().equals("Search...")) {
                    textFieldObject.setText("");
                    textFieldObject.setForeground(Color.BLUE);
                }
            }

            @Override
            public void mousePressed(MouseEvent event) {
                if (textFieldObject.getText().equals("Search...")) {
                    textFieldObject.setText("");
                    textFieldObject.setForeground(Color.BLUE);
                }
            }

            @Override
            public void mouseReleased(MouseEvent event) {

            }
        }
        );
    }

    public final void updateTextArea(final JButton ValueButton) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ValueButton.addActionListener(event -> {
                passwordorIdField.append(ValueButton.getText());
            });
        });

    }

    public final void retrieveInventoryData() {
        try {

            int row = stockTabelModel.getRowCount();
            while (row > 0) {
                row--;
                stockTabelModel.removeRow(row);

            }
            //Execute query
            ResultSet ineventoryResults = st.executeQuery("SELECT * FROM drugs");

            //get metadata
            ResultSetMetaData resultSetMetaData = ineventoryResults.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            Object[] data = new Object[columnCount];
            while (ineventoryResults.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    data[i - 1] = ineventoryResults.getString(i);
                }
                stockTabelModel.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to Retrieve Stocks Information");
        }
    }

    public final void getInventoryColumnNames() {

        stockTabelModel.addColumn("ID");
        stockTabelModel.addColumn("Name");
        stockTabelModel.addColumn("Purchase Price");
        stockTabelModel.addColumn("Qty");
        stockTabelModel.addColumn("Sell Price");
        stockTabelModel.addColumn("Category");
        stockTabelModel.addColumn("Expiry Date");
        stockTabelModel.addColumn("Age Range");
        stockTabelModel.addColumn("Details");
        stockTabelModel.addColumn("Time Remaining");
        stockTabelModel.addColumn("Reorder Level");
        stockTabelModel.addColumn("Status");

    }

    public final void getSuppliersData() {

        try {

            int row = suppliersModel.getRowCount();
            while (row > 0) {

                row--;
                suppliersModel.removeRow(row);
            }
            ResultSet resultSet = st.executeQuery("SELECT * FROM suppliers;");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            Object[] data = new Object[columnCount];
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    data[i - 1] = resultSet.getString(i);
                }
                suppliersModel.addRow(data);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to Obtain Suppliers Data:\n [" + e.getMessage() + "]");
        }
    }

    public void getSalesByDate(LocalDate startDate, LocalDate endDate) {

        try {
            int row = invoiceTableModel.getRowCount();
            while (row > 0) {
                row--;
                invoiceTableModel.removeRow(row);
            }

            ResultSet resultSet = st.executeQuery("SELECT * FROM salesInvoice WHERE saleDate BETWEEN('" + startDate.toString() + "') AND ('" + endDate.toString() + "')");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            Object[] data = new Object[columnCount];
            while (resultSet.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    data[i - 1] = resultSet.getObject(i);
                }
                invoiceTableModel.addRow(data);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to Obtain Sales Invoice Data:[" + e.getMessage() + "]");
        }
    }

    public void getsalesInvoice() {
        try {
            int row = invoiceTableModel.getRowCount();
            while (row > 0) {
                row--;
                invoiceTableModel.removeRow(row);
            }

            ResultSet resultSet = st.executeQuery("SELECT * FROM salesInvoice ;");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            Object[] data = new Object[columnCount];
            while (resultSet.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    data[i - 1] = resultSet.getObject(i);
                }
                invoiceTableModel.addRow(data);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to Obtain Sales Invoice Data:[" + e.getMessage() + "]");
        }
    }

    public void getTodaySales() {
        try {
            int row = invoiceTableModel.getRowCount();
            while (row > 0) {
                row--;
                invoiceTableModel.removeRow(row);
            }

            ResultSet resultSet = st.executeQuery("SELECT * FROM salesInvoice WHERE saleDate IN('" + LocalDate.now() + "');");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            Object[] data = new Object[columnCount];
            while (resultSet.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    data[i - 1] = resultSet.getObject(i);
                }
                invoiceTableModel.addRow(data);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to Obtain Sales Invoice Data:[" + e.getMessage() + "]");
        }
    }

    public void replaceRightComponentOnSplitPane(JPanel newReplaceablePanel) {

        splitPane.remove(splitPane.getRightComponent());
        repaint();
        newReplaceablePanel.setBackground(Color.WHITE);
        splitPane.setRightComponent(newReplaceablePanel);
        repaint();
    }

    public void getThisMonthsSales() {

        try {
            int row = invoiceTableModel.getRowCount();
            while (row > 0) {
                row--;
                invoiceTableModel.removeRow(row);
            }
            LocalDate today = LocalDate.now();
            int month = today.getMonth().getValue() - 1;
            LocalDate lastMonth = LocalDate.of(today.getYear(), month, today.getDayOfMonth());
            LocalDate llastMonth = LocalDate.of(today.getYear(), month, lastMonth.getMonth().minLength());
            ResultSet resultSet = st.executeQuery("SELECT * FROM salesInvoice WHERE saleDate BETWEEN('" + llastMonth + "') AND ('" + LocalDate.now().toString() + "');");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            Object[] data = new Object[columnCount];
            while (resultSet.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    data[i - 1] = resultSet.getObject(i);
                }
                invoiceTableModel.addRow(data);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to Obtain Sales Invoice Data:[" + e.getMessage() + "]");
        }
    }

    public void printJTable(JTable currentTableObject, String tableHeader) {

        try {
            currentTableObject.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat(tableHeader), new MessageFormat(printDate + "  " + new managedocuments.CompanyInfoTransactions().getCompanyInformation().get("name")));
            JOptionPane.showMessageDialog(null, "Print succefull!");
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(null, "Unable To print:" + e.getMessage());
        }
    }

    public final void changeCursorTypesForMenues(final JMenu menueObject) {
        menueObject.addMouseListener(
                new MouseListener() {
            @Override
            public void mousePressed(MouseEvent event) {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));
                //DON NOTHING 
            }

            @Override
            public void mouseClicked(MouseEvent event) {
                //DON NOTHING 
            }

            @Override
            public void mouseReleased(MouseEvent event) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                //DON NOTHING
            }

            @Override
            public void mouseExited(MouseEvent event) {

                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseEntered(MouseEvent event) {
                //menuBar.setBorder(new LineBorder(Color.decode("#F5F5F5"), 5));\
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

        }
        );
    }

    public final void retrieveTableData(DefaultTableModel tableModel, String tableName, String dbTableName) {
        try {

            int row = tableModel.getRowCount();
            while (row > 0) {
                row--;
                tableModel.removeRow(row);

            }
            //Execute query
            ResultSet ineventoryResults = st.executeQuery("SELECT * FROM " + dbTableName + ";");

            //get metadata
            ResultSetMetaData resultSetMetaData = ineventoryResults.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            Object[] data = new Object[columnCount];
            while (ineventoryResults.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    data[i - 1] = ineventoryResults.getString(i);
                }
                tableModel.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to Retrieve " + tableName + " Information \n[" + e.getMessage());
        }
    }

    /**
     *
     * @param columnNames
     * @param defaultTableModel This method sets the tables column headers using
     * the list of string passed using a stream pipeline operation
     */
    public final void setTableColumnHeaders(List<String> columnNames, DefaultTableModel defaultTableModel) {

        columnNames.stream()
                .forEach(columnName -> defaultTableModel.addColumn(columnName));
    }

}
