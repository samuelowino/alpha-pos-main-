package alpha;

import SystemSecurity.SHA1PasswordHashing;
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
import java.util.function.Predicate;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.text.JTextComponent;
import salesinventory.*;
import staffandEmployeeManagement.*;
import managedocuments.*;
import systemsandmanagementrinterface.UsersInformationTransactions;

public class MainPOSInterface extends JFrame {

    protected static JLabel backgroundImageLabel;
    private static JComboBox<String> ascdescExpensesComboBox;
    private static JMenuItem viewCustomerDetailsMenuItem;
    private static JMenuItem supplyTransactionsMenuItems;
    private static JComboBox<String> customersAscDescCombo;
    private static JComboBox suppliersViewDescAscCombo;
    private static JMenuItem purchaseViewMenuItem;
    private static String expenseSearchText;
    private static String customersSearchText;
    private static String suppliersSearchText;
    private static String stockSearchText;
    private static String salesSearchtext;
    private static ViewReturnsInterface viewReturnsInterface;
    private static JMenuItem addNewDrugItemCategoryMenu;
    private static Icon passwordStatusLabelIcon;
    private static JLabel passwordAvailableLabel;
    private static Boolean imageFileSelected = false;
    private static JMenu reportsMainViewMenu;
    private static JPanel expensesViewMainPanel;
    private static JMenu expensesMenu;
    private static JMenuItem expensesViewMenuItem;
    private static JMenuItem addNewExpenseMenuItem;
    private static JMenu returnsMenu;
    private static JMenuItem viewReturnedGoodsMenuItem;
    private static JMenuItem enterReturnedGoodsMenuItem;
    private static Connection globalDatabaseConnection;
    private static Statement globalSqlStatementObject;
    private static JLabel expensesTopLabel;
    private static DefaultTableModel expensesTableModel;
    private static JPanel expensesTopPanel;
    private static JPanel expensesTableComponentsPanel;
    private static JPanel expensesTableOnlypanel;
    private static JButton addNewExpenseButton;
    private static JButton printExpensesButton;
    private static JButton searchExpensesButton;
    private static JButton sortExpensesByButton;
    private static JTextField searchExpensesField;
    private static JComboBox<String> sortExpensesMethodCombo;
    private static JTable expenseTable;
    private static JScrollPane expenseTableScrollPane;
    private static JLabel expenseTotalLabel;
    //---------------------------------------------------------------------------------------------------------------------------------------------------

    private static JSpinner assignDiscountSpinner;
    private static JLabel itemDiscountLabel;
    private static JButton finalSortButton;
    private static EmployeeDataTransaction employeeDataTransactions;
    private static JMenu logOutMenu;
    private static JLabel companyFooterLabel;
    private static CompanyInfoTransactions companyInformation;
    private static CustomerTransaction customerTransactions;
    protected static DrugInventoryTransactions drugInventoryTransactions;
    private static JButton generateSaleReportsByDateButton;
    private static JLabel drugInventoryLabel;
    private static JMenu suppliersMenu;
    protected static DefaultTableModel suppliersModel;
    private static JLabel suppliersInformationLabel;
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
    protected static JLabel suppliersPatientTotalLabel;

    protected static JPanel suppliersInfoViewPanel;
    //------------------------------------------------------------------------------------------------------------------
    private static DefaultTableModel customerModel;
    protected static DefaultTableModel invoiceTableModel;
    protected static DefaultTableModel stockTabelModel;
    private static JMenu salesReportsMenu;
    private static JMenu salesMenu;
    private static JMenu stockMenu;
    private static JMenuItem salesReportsByCategory;
    private static salesinventory.SalesTableModel saleTableModel;
    private static Double itemPrice;
    private static JPanel addNewEmplyeeViewPanel;
    private static JPanel processPayMentsViewPanel;
    //--------------------------------------------------------------------------------------------------------------------------
    private static JButton addItemToSalesButton;
    public static JPanel addNewPatientCustomerViewPanel;
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
    public static JPanel viewCustomerInformationDetailsView;
    private static JLabel customerInformationLabel;
    public static JPanel customersPatientsTopPanel;
    public static JPanel customerPatientTableComponentsPanel;
    public static JPanel customerpatientTableOnlypanel;
    private static JButton addNewPatientCustomerButton;
    private static JButton patientCustomerPrintButton;
    private static JButton customerPatientSearchButton;
    private static JButton customerPatientSortByButton;
    private static JTextField customerPatientsSearchField;
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
    protected static JPanel inventoryViewPanel;
    private static JPanel inventroyViewTopPanel;
    private static JPanel inventoryViewTableComponentsPanel;
    private static JPanel inventoryViewTableOnlypanel;
    private static JButton inventoryViewsaddNewItemButton;
    private static JButton inventoryPrintButton;
    private static JButton inventorySearchButton;
    private static JComboBox<String> ascendingDescendingCombo;
    private static JButton inventorySortByButton;
    private static JTextField inventorySearchField;
    private static JComboBox<String> inventorySortMethodCombo;
    public JTable inventoryItemsTable;
    private static JScrollPane inventoryTableScrollPane;
    private static JLabel inventoryTotalLabel;

    //-------------------------------------------------------------------------------------------------------------
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
    private static JMenuItem inventoryMenuItem;
    private static JMenuItem invoiceMenuItem;
    //--------------------------------------------------------------------------------------------------------------------------------------------------------
    private static JPanel customersViewPanel;
    private static JPanel shiftsViewPanel;
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
    private static JLabel userAccessLevelPriviledgeLable;
    private static JComboBox usersAccessLevelCombo;
    private static JLabel passwordLabel;
    private static JPasswordField userPasswordField;
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
    private static JLabel pharmacyNameLabel;
    private static JButton clockInButton;
    private static JButton clockOutButton;
    private static JButton clearClockInClockOutButton;
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
    private static JTextArea ClockInClockOutEmployeeIDField;
    private static ClockInClockOutTransactions DAO;

    //-------------------------------------------------------------------------------------------------------------------------------------------
    protected static JPanel inveicePanel;

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
    protected static JLabel statementLineOneLabel;
    protected static JLabel statementLineTwoLabel;
    protected static JLabel statementLineThreeLabel;
    protected static JLabel statementLineFourLabel;
    protected static JLabel statementLineFiveLabel;
    protected static JLabel statementLineSixLabel;
    protected static JLabel statementLineSevenLabel;
    protected static JLabel statementLineEightLabel;
    protected static JLabel statementLineNineLabel;
    protected static JLabel statementLineTenLabel;

    //--------------------------------------------------------------------------------------------------------------------------------------------
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
    private static JComboBox taskFieldFor;
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
    private static JMenu salesRegister;
    private static JLabel searchByCategoryLabel;
    private static JMenu customers;
    private static JMenu PointofSaleLabel;
    private static JMenu users;
    private static JMenu reports;
    private static JMenu currentLoggedEmail;
    private static JMenu titleOfLocggedUser;
    private static JPanel tempPanel;
    //SplitPane
    public static JSplitPane splitPane;
    //PopUPMenu
    private static JMenuBar menuBar;
    //Menues
    private static JMenu fileMenu;
    private static JMenu displaySettingsMenu;
    private static JMenu editMenu;
    private static JMenu viewMenu;
    private static JMenu purchasingMenu;
    private static JMenu configurationMenu;
    private static JMenu helpMenu;
    private static JMenu itemsMenu;
    private static JMenu customersMenu;
    //menuItems --> FileMenue
    private static JMenuItem makeANewSaleMenuItem;
    private static JMenuItem newNoticeMenuItem;
    private static JMenuItem newUserMenuItem;
    private static JMenuItem newEmployeeMenuItem;
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
    private static JMenuItem printNotificationMenuItem;
    private static JMenuItem exitMenuItem;
    private static JMenuItem clockInClockOutMenuItem;
    //menuItems --> configurationMenu
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
    private static Image applicationIconImage;

    public MainPOSInterface(Boolean visible) {
        super("Alpha Pharmacy POS     Version 1.2 Build ID:201510222201");
        setSize(1400,800);
        setLocation(0,0);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBackground(Color.WHITE);
        setResizable(false);
        
        addWindowListener(
                new WindowAdapter(){

                    @Override
                    public void windowClosing(WindowEvent event){
                        new WindowsCloseDialogBox(true);
                    }
                    
                }
        );
        
        try {
            applicationIconImage = ImageIO.read(new File("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\4211692-abstract-color-background-picture-8016one.jpg"));
            setIconImage(applicationIconImage);
        } catch (IOException ex) {
        }
        backgroundImageLabel = new JLabel(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\4211692-abstract-color-background-picture-8016one.jpg"));
        backgroundImageLabel.setBounds(0, 0, 1400, 800);
        String[] customersAcsDesc = {"DESC", "ASC"};
        ascdescExpensesComboBox = new JComboBox<String>(customersAcsDesc);
        viewCustomerDetailsMenuItem = new JMenuItem("View Customer Details");
        customersAscDescCombo = new JComboBox<String>(customersAcsDesc);
        getConnection();
        String[] descAsc = {"DESC", "ASC"};
        supplyTransactionsMenuItems = new JMenuItem("View Supplier Accounts");
        suppliersViewDescAscCombo = new JComboBox<String>(descAsc);
        viewReturnsInterface = new ViewReturnsInterface();
        addNewDrugItemCategoryMenu = new JMenuItem("Add New Category");
        passwordStatusLabelIcon = new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\okAnimated2.PNG");
        passwordAvailableLabel = new JLabel("");
        reportsMainViewMenu = new JMenu("DashBoard");
        expensesViewMainPanel = new JPanel(null);
        employeeDataTransactions = new EmployeeDataTransaction();
        logOutMenu = new JMenu();
        itemDiscountLabel = new JLabel("Discount");
        assignDiscountSpinner = new JSpinner();
        assignDiscountSpinner.setMinimumSize(new Dimension(0, 0));
        companyInformation = new CompanyInfoTransactions();
        customerTransactions = new CustomerTransaction();
        productSalesTransactions = new ProductSalesTransactions();
        drugInventoryTransactions = new DrugInventoryTransactions();
        printDate = LocalDate.now();
        companyFooterLabel = new JLabel(companyInformation.getCompanyInformation().get("footer"));
        generateSaleReportsByDateButton = new JButton("Generate");
        drugInventoryLabel = new JLabel("Drugs Inventory");
        drugInventoryLabel.setForeground(Color.WHITE);
        drugInventoryLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        stockTabelModel = new DefaultTableModel();
        suppliersMenu = new JMenu("Suppliers");
        viewSuppliers = new JMenuItem("View Suppliers");
        suppliersInfoViewPanel = new JPanel(null);
        addNewUserPanelView = new JPanel(null);
        saleTableModel = new SalesTableModel();
        addItemToSalesButton = new JButton("Sell");
        addItemToSalesButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
        addItemToSalesButton.setBackground(Color.decode("#1E90FF"));
        addItemToSalesButton.setForeground(Color.WHITE);
        addItemToSalesButton.setBorder(new LineBorder(Color.WHITE, 3, true));
        expensesMenu = new JMenu("Expenses");
        returnsMenu = new JMenu("Returns");
        stockMenu = new JMenu("Stock");
        salesMenu = new JMenu("Sales");
        salesReportsMenu = new JMenu("Sales Reports");
        salesReportsMenu.add(Box.createHorizontalStrut(200));
        salesReportsByCategory = new JMenuItem("View Sales");
        salesReportsMenu.add(salesReportsByCategory);
        viewCustomerInformationDetailsView = new JPanel(null);
        addNewPatientCustomerViewPanel = new JPanel(null);
        addNewEmplyeeViewPanel = new JPanel(null);
        processPayMentsViewPanel = new JPanel(null);
        inventoryViewPanel = new JPanel(null);
        //Prepare the reports menuItems
        inventoryMenuItem = new JMenuItem("Inventory");
        invoiceMenuItem = new JMenuItem("Invoice");
        customerModel = new DefaultTableModel();
        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        suppliersModel = new DefaultTableModel();
        String[] customerInformationSortOptions = {"Suppliers_Name", "Region", "Phone", "Email", "Contact_Person"};
        addNewsuppliersCustomerButton = new JButton("Add Supplier");
        suppliersInformationLabel = new JLabel("Suppliers Information");
        suppliersInformationLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        suppliersInformationLabel.setForeground(Color.WHITE);
        suppliersPrintButton = new JButton("Print");
        suppliersPrintButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
        suppliersPatientSearchButton = new JButton("");
        suppliersPatientTotalLabel = new JLabel();
        suppliersPatientSearchButton.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\searchIcon.jpg"));
        suppliersSortByButton = new JButton("Sort By:");
        suppliersPatiientsSearchField = new JTextField("Search...");
        suppliersPatientSortMethodCombo = new JComboBox<>(customerInformationSortOptions);
        suppliersPatientTable = new JTable(suppliersModel);
        List<String> suppliersTableColumnNames = Arrays.asList("Suppliers_Name", "Contact_Person", "Region", "Phone", "Email");
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
        suppliersViewDescAscCombo.setBounds(690, 5, 200, 30);
        suppliersPatientTableScrollPane.setBounds(5, 25, 990, 415);
        suppliersPatientsTopPanel = new JPanel(null);
        suppliersTableComponentsPanel = new JPanel(null);
        viewsuppliersTableOnlypanel = new JPanel(null);
        suppliersPatientsTopPanel.setBackground(Color.decode("#1E90FF"));
        suppliersTableComponentsPanel.setBackground(Color.LIGHT_GRAY);
        viewsuppliersTableOnlypanel.setBackground(Color.WHITE);
        suppliersPatientSortMethodCombo.setBackground(Color.WHITE);
        suppliersViewDescAscCombo.setBackground(Color.WHITE);
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
        suppliersTableComponentsPanel.add(suppliersViewDescAscCombo);
        viewsuppliersTableOnlypanel.add(suppliersPatientTotalLabel);
        viewsuppliersTableOnlypanel.add(suppliersPatientTableScrollPane);
        addFieldsFocusListener(suppliersPatientSortMethodCombo);
        addFieldsFocusListener(suppliersPatiientsSearchField);
        addFieldsFocusListener(suppliersViewDescAscCombo);
        suppliersInfoViewPanel.add(suppliersPatientsTopPanel);
        suppliersInfoViewPanel.add(suppliersTableComponentsPanel);
        suppliersInfoViewPanel.add(viewsuppliersTableOnlypanel);
        searchTextFieldMouseListener(suppliersPatiientsSearchField);

        suppliersPatiientsSearchField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent event) {
                        suppliersSearchText = suppliersPatiientsSearchField.getText();

                    }

                    @Override
                    public void keyReleased(KeyEvent event) {
                        retrieveDataBySearch("SELECT * FROM suppliers WHERE suppliers_name LIKE '%" + suppliersSearchText
                                + "%' OR contact_Person LIKE '%" + suppliersSearchText + "%' OR Region LIKE '%"
                                + suppliersSearchText + "%' OR email LIKE '%" + suppliersSearchText + "%' OR Contact LIKE '%" + suppliersSearchText + "%';", suppliersModel, "");
                        suppliersPatientTotalLabel.setText("Total:" + suppliersModel.getRowCount() + "  Records Found");
                    }

                    @Override
                    public void keyPressed(KeyEvent event) {
                        suppliersSearchText = suppliersPatiientsSearchField.getText();
                    }
                });
        suppliersPatientSortMethodCombo.addActionListener(e -> {
            retrievedNaturalySortedTableData(suppliersPatientSortMethodCombo.getSelectedItem().toString(), suppliersViewDescAscCombo.getSelectedItem().toString(), suppliersModel, "Suppliers Table", "Suppliers");
            suppliersPatientTotalLabel.setText("Total:" + suppliersModel.getRowCount() + "  Records Found");
            repaint();
        });

        suppliersViewDescAscCombo.addActionListener(e -> {
            retrievedNaturalySortedTableData(suppliersPatientSortMethodCombo.getSelectedItem().toString(), suppliersViewDescAscCombo.getSelectedItem().toString(), suppliersModel, "Suppliers Table", "Suppliers");
            suppliersPatientTotalLabel.setText("Total:" + suppliersModel.getRowCount() + "  Records Found");
            repaint();
        });

        suppliersPrintButton.addActionListener(event -> {
            try {
                suppliersPatientTable.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("Suppliers Records"), new MessageFormat(printDate + "   " + companyInformation.getCompanyInformation().get("name")));
                JOptionPane.showMessageDialog(null, "Print succefull!");
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(null, "Unable To print:" + e.getMessage());
            }
        });
        //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //expenses View 

        expensesTopLabel = new JLabel("Expenses View");
        expensesTableModel = new DefaultTableModel();
        addNewExpenseButton = new JButton("Add New Expense");
        printExpensesButton = new JButton("Print");
        searchExpensesButton = new JButton("");
        expenseTotalLabel = new JLabel("Total: 0 Records Found");
        expenseTotalLabel.setForeground(Color.WHITE);
        sortExpensesByButton = new JButton("Sort By:");
        searchExpensesField = new JTextField("Search...");
        String[] expenseSortMethods = {"Title", "Cost", "ExpID"};
        sortExpensesMethodCombo = new JComboBox<String>(expenseSortMethods);
        expenseTable = new JTable(expensesTableModel);
        List<String> columnNames = Arrays.asList(
                "Expense ID", "Expense Name", "Cost of Expense(Ksh)"
        );
        getExpensesColumnNames(columnNames);
        getExpenseDataFromDB();
        expenseTableScrollPane = new JScrollPane(expenseTable);
        expenseTableScrollPane.getViewport().setBackground(Color.WHITE);
        addNewExpenseButton.setBounds(400, 20, 150, 30);
        printExpensesButton.setBounds(570, 20, 100, 30);
        searchExpensesButton.setBounds(25, 5, 30, 30);
        searchExpensesField.setBounds(55, 5, 300, 30);
        sortExpensesByButton.setBounds(365, 5, 100, 30);
        sortExpensesMethodCombo.setBounds(475, 5, 200, 30);
        sortExpensesMethodCombo.setBackground(Color.WHITE);
        ascdescExpensesComboBox.setBounds(685, 5, 200, 30);
        ascdescExpensesComboBox.setBackground(Color.WHITE);
        expenseTableScrollPane.setBounds(5, 25, 990, 415);
        expensesTopPanel = new JPanel(null);
        expensesTableComponentsPanel = new JPanel(null);
        expensesTableOnlypanel = new JPanel(null);
        expensesTopPanel.setBackground(Color.decode("#1E90FF"));
        expensesTableComponentsPanel.setBackground(Color.LIGHT_GRAY);
        expensesTableOnlypanel.setBackground(Color.WHITE);
        expensesTopPanel.setBounds(100, 0, 1000, 70);
        expensesTableComponentsPanel.setBounds(100, 100, 1000, 90);
        expensesTableOnlypanel.setBounds(100, 190, 1000, 450);
        expenseTotalLabel.setBounds(450, 2, 200, 30);
        expensesTableComponentsPanel.setBorder(new LineBorder(Color.BLUE));
        expensesTableOnlypanel.setBorder(new LineBorder(Color.BLUE));
        expensesTopPanel.setBorder(new LineBorder(Color.BLUE));
        addNewExpenseButton.setBackground(Color.ORANGE);
        printExpensesButton.setBackground(Color.decode("#DC143C"));
        sortExpensesByButton.setBackground(Color.BLUE);
        searchExpensesButton.setBackground(Color.blue);
        expensesTopPanel.add(printExpensesButton);
        expensesTopPanel.add(addNewExpenseButton);
        expensesTableComponentsPanel.add(searchExpensesButton);
        expensesTableComponentsPanel.add(searchExpensesField);
        expensesTableComponentsPanel.add(sortExpensesByButton);
        expensesTableComponentsPanel.add(sortExpensesMethodCombo);
        expensesTableComponentsPanel.add(ascdescExpensesComboBox);
        expensesTableOnlypanel.add(expenseTotalLabel);
        expensesTableOnlypanel.add(expenseTableScrollPane);

        expensesTopLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        expensesTopLabel.setForeground(Color.WHITE);
        expensesTopLabel.setBounds(15, 10, 200, 40);
        addNewExpenseButton.setForeground(Color.WHITE);
        printExpensesButton.setForeground(Color.WHITE);
        sortExpensesByButton.setForeground(Color.WHITE);

        addFieldsFocusListener(sortExpensesMethodCombo);
        addFieldsFocusListener(searchExpensesField);
        expensesViewMainPanel.add(expensesTopPanel);
        expensesTopPanel.add(expensesTopLabel);
        expensesViewMainPanel.add(expensesTableComponentsPanel);
        expensesViewMainPanel.add(expensesTableOnlypanel);
        // repaint();
        // setVisible(true);
        animateGreypanels(expensesTableComponentsPanel);
        animateGreypanels(expensesTableOnlypanel);
        searchTextFieldMouseListener(searchExpensesField);

        addNewExpenseButton.addActionListener((ActionEvent event) -> {
            StoreExpensesTracking storeExpensesTracking = new StoreExpensesTracking(true);
        });
        searchExpensesField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        expenseSearchText = searchExpensesField.getText();
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        expenseSearchText = searchExpensesField.getText();
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        retrieveDataBySearch("SELECT * FROM companyExpenses WHERE expID LIKE '%" + expenseSearchText + "%' OR Title LIKE '%" + expenseSearchText + "%' OR cost LIKE '%" + expenseSearchText + "%';", expensesTableModel, "Expenses");
                        expenseTotalLabel.setText("Total:" + expensesTableModel.getRowCount() + "  Records Found");
                    }

                }
        );
        sortExpensesMethodCombo.addActionListener(e -> {
            retrievedNaturalySortedTableData(sortExpensesMethodCombo.getSelectedItem().toString(), ascdescExpensesComboBox.getSelectedItem().toString(), expensesTableModel, "Expenses Table", "CompanyExpenses");
            expenseTotalLabel.setText("Total:" + expensesTableModel.getRowCount() + "  Records Found");
            repaint();
        });
        ascdescExpensesComboBox.addActionListener(e -> {
            retrievedNaturalySortedTableData(sortExpensesMethodCombo.getSelectedItem().toString(), ascdescExpensesComboBox.getSelectedItem().toString(), expensesTableModel, "Expenses Table", "CompanyExpenses");
            expenseTotalLabel.setText("Total:" + expensesTableModel.getRowCount() + "  Records Found");
            repaint();
        });

        printExpensesButton.addActionListener((ActionEvent event) -> printJTable(expenseTable, "Company Expenses Records"));
        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        patientsTopAddUserPanel = new JPanel(null);
        patientsEditProfilePanel = new JPanel(null);
        patientsAddPrescriptionDetailsButton = new JButton("Add Drugs/Prescription");
        patientsUpdateInfoButton = new JButton("Update Info");
        patientsUpdateUserDetailsButton = new JButton("Update");
        patientsAdminButton = new JButton("Back");
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
        patientsCustomerInformationLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        patientsPatientsDiagnosisField.setBorder(new LineBorder(Color.decode("#1E90FF")));
        patientsEditProfilePanel.setBackground(Color.WHITE);
        patientsUpdateInfoButton.setBackground(Color.decode("#DC143C"));
        patientsAdminButton.setBackground(Color.decode("#DC143C"));
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
        List<JTextComponent> newCustomerstextOnlyFields = Arrays.asList(
                patientsFirstNameField, patientsLastNameField
        );
        List<JTextComponent> newCustomersnumbersOnlyTextFields = Arrays.asList(
                patientsPhoneField
        );
        List<JTextComponent> newCustomersemailsOnlyField = Arrays.asList(
                patientsEmailField
        );
        List<JTextComponent> newCustomersnumbersAndTextFields = Arrays.asList(
                patientsPatientsDiagnosisField
        );
        List<JTextComponent> newCustomersallCustomersTextComponents = Arrays.asList(
                patientsPatientsDiagnosisField, patientsEmailField, patientsPhoneField,
                patientsFirstNameField, patientsLastNameField
        );
        validateFields(newCustomerstextOnlyFields, InputVerification::verifyTextOnlyFields);
        validateFields(newCustomersnumbersOnlyTextFields, InputVerification::verifyNumbersOnlyFields);
        validateFields(newCustomersemailsOnlyField, InputVerification::verifyEmails);
        validateFields(newCustomersnumbersAndTextFields, InputVerification::verifiyNumbersWithTex);

        patientsAddPrescriptionDetailsButton.addActionListener(e -> new systemsandmanagementrinterface.PatientsDiagnosedDrugsDetails().setVisible(true));
        patientsUpdateUserDetailsButton.addActionListener((ActionEvent event) -> {
            if (checkIfFieldsAreBlank(newCustomersallCustomersTextComponents) == false
                    || levelTwoTextFieldsValidation(newCustomersnumbersAndTextFields, InputVerification::verifiyNumbersWithTex) == false
                    || levelTwoTextFieldsValidation(newCustomersemailsOnlyField, InputVerification::verifyEmails) == false
                    || levelTwoTextFieldsValidation(newCustomersnumbersOnlyTextFields, InputVerification::verifyNumbersOnlyFields) == false
                    || levelTwoTextFieldsValidation(newCustomerstextOnlyFields, InputVerification::verifyTextOnlyFields) == false) {
                Toolkit soundToolkit = Toolkit.getDefaultToolkit();
                soundToolkit.beep();
                JOptionPane.showMessageDialog(null, "Ensure All Fields Are Valid", "Alpha Pharmacy POS", JOptionPane.ERROR_MESSAGE);

            } else if (checkIfFieldsAreBlank(newCustomersallCustomersTextComponents) == true
                    && levelTwoTextFieldsValidation(newCustomersnumbersAndTextFields, InputVerification::verifiyNumbersWithTex) == true
                    && levelTwoTextFieldsValidation(newCustomersemailsOnlyField, InputVerification::verifyEmails) == true
                    && levelTwoTextFieldsValidation(newCustomersnumbersOnlyTextFields, InputVerification::verifyNumbersOnlyFields) == true
                    && levelTwoTextFieldsValidation(newCustomerstextOnlyFields, InputVerification::verifyTextOnlyFields) == true) {
                patientsLastVisitField.getDate();
                customerTransactions.insertCustomerDataToDb(patientsFirstNameField.getText(), patientsLastNameField.getText(), patientsPhoneField.getText(), patientsEmailField.getText(), patientsPrescriptionDetailsField.getText(), patientsLastVisitField.getDate().toString(), patientsNextVistField.getDate().toString(), patientsPatientsDiagnosisField.getText());
            }

        });

        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String[] patientCustomerInformationSortOptions = {"FirstName", "lastName", "Phone", "Email", "Prescription", "lastVisit", "NextAppointment", "Diagnosis"};
        addNewPatientCustomerButton = new JButton("Add Customer");
        customerInformationLabel = new JLabel("Customers Information");
        customerInformationLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        customerInformationLabel.setForeground(Color.WHITE);
        patientCustomerPrintButton = new JButton("Print");
        customerPatientSearchButton = new JButton("");

        customerPatientSearchButton.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\searchIcon.jpg"));
        customerPatientSortByButton = new JButton("Sort By:");
        customerPatientsSearchField = new JTextField("Search...");
        customerPatientSortMethodCombo = new JComboBox<>(patientCustomerInformationSortOptions);
        customerPatientTable = new JTable(customerModel);
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
        customerPatientsSearchField.setBounds(55, 5, 300, 30);
        customerPatientSortByButton.setBounds(365, 5, 100, 30);
        customerPatientSortMethodCombo.setBounds(475, 5, 200, 30);
        customersAscDescCombo.setBounds(685, 5, 200, 30);
        customerPatientTableScrollPane.setBounds(5, 25, 990, 415);
        customersPatientsTopPanel = new JPanel(null);
        customerPatientTableComponentsPanel = new JPanel(null);
        customerpatientTableOnlypanel = new JPanel(null);
        customersPatientsTopPanel.setBackground(Color.decode("#1E90FF"));
        customerPatientTableComponentsPanel.setBackground(Color.LIGHT_GRAY);
        customerpatientTableOnlypanel.setBackground(Color.WHITE);
        customerPatientSortMethodCombo.setBackground(Color.WHITE);
        customersAscDescCombo.setBackground(Color.WHITE);
        customersPatientsTopPanel.setBounds(100, 0, 1000, 70);
        customerPatientTableComponentsPanel.setBounds(100, 100, 1000, 90);
        customerpatientTableOnlypanel.setBounds(100, 190, 1000, 450);

        customerPatientTableComponentsPanel.setBorder(new LineBorder(Color.BLUE));
        customerpatientTableOnlypanel.setBorder(new LineBorder(Color.BLUE));
        customersPatientsTopPanel.setBorder(new LineBorder(Color.BLUE));
        addNewPatientCustomerButton.setBackground(Color.decode("#DC143C"));
        patientCustomerPrintButton.setBackground(Color.decode("#B22222"));
        patientCustomerPrintButton.setForeground(Color.WHITE);
        addNewPatientCustomerButton.setForeground(Color.white);
        customerPatientSortByButton.setBackground(Color.BLUE);
        customerPatientSearchButton.setBackground(Color.blue);
        customersPatientsTopPanel.add(patientCustomerPrintButton);
        customersPatientsTopPanel.add(addNewPatientCustomerButton);
        customersPatientsTopPanel.add(customerInformationLabel);
        customerPatientTableComponentsPanel.add(customerPatientSearchButton);
        customerPatientTableComponentsPanel.add(customerPatientsSearchField);
        customerPatientTableComponentsPanel.add(customerPatientSortByButton);
        customerPatientTableComponentsPanel.add(customerPatientSortMethodCombo);
        customerpatientTableOnlypanel.add(customerPatientTableScrollPane);
        customerPatientTableComponentsPanel.add(customersAscDescCombo);
        addFieldsFocusListener(customerPatientSortMethodCombo);
        addFieldsFocusListener(customerPatientsSearchField);
        viewCustomerInformationDetailsView.add(customersPatientsTopPanel);
        viewCustomerInformationDetailsView.add(customerPatientTableComponentsPanel);
        viewCustomerInformationDetailsView.add(customerpatientTableOnlypanel);
        searchTextFieldMouseListener(customerPatientsSearchField);
        customerPatientSortMethodCombo.addActionListener(e -> {
            retrievedNaturalySortedTableData(customerPatientSortMethodCombo.getSelectedItem().toString(), customersAscDescCombo.getSelectedItem().toString(), customerModel, "Customers Table", "Customers");
            customerPatientTotalLabel = new JLabel();
            customerPatientTotalLabel.setText("Total:" + customerModel.getRowCount() + "  Record(s) Found");
            repaint();
        });
        customersAscDescCombo.addActionListener(e -> {
            retrievedNaturalySortedTableData(customerPatientSortMethodCombo.getSelectedItem().toString(), customersAscDescCombo.getSelectedItem().toString(), customerModel, "Customers Table", "Customers");
            customerPatientTotalLabel = new JLabel();
            customerPatientTotalLabel.setText("Total:" + customerModel.getRowCount() + "  Record(s) Found");
            repaint();
        });

        addNewPatientCustomerButton.addActionListener(e -> {
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            addNewPatientCustomerViewPanel.setBackground(Color.WHITE);
            splitPane.setRightComponent(addNewPatientCustomerViewPanel);
            repaint();
        });
        customerPatientsSearchField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        customersSearchText = customerPatientsSearchField.getText();
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        customersSearchText = customerPatientsSearchField.getText();
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        retrieveDataBySearch("SELECT * FROM customers WHERE firstName LIKE '%" + customersSearchText + "%' OR lastName LIKE '%"
                                + customersSearchText + "%' OR phone LIKE '%"
                                + customersSearchText + "%' OR prescription LIKE '%" + customersSearchText + "%' OR lastVisit LIKE '%"
                                + customersSearchText + "%' OR nextAppointment LIKE '%" + customersSearchText + "%' OR diagnosis LIKE '%"
                                + customersSearchText + "%';", customerModel, "Customers");
                        // customerPatientTotalLabel = new JLabel();
                        customerPatientTotalLabel.setText("Total:" + customerModel.getRowCount() + "  Record(s) Found");
                        repaint();
                    }

                }
        );
        patientCustomerPrintButton.addActionListener(e -> printJTable(customerPatientTable, "Customer Records"));
        //New Order Screen
        //---------------------------------------------------------------------------------------------------------------------------------------------------------
        selectCategoryLabel = new JLabel("Select category");
        selectItemLabel = new JLabel("Select item");
        selectQtyLabel = new JLabel("Select Quantity");

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
        deleteButtonPay = new JButton("DELETE LAST");
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
        String[] paymentModes = {"Cash", "M-Pesa", "Cheque", "Visa", "Master Card/EuroCard", "Voucher"};
        payModeComboBox = new JComboBox<>(paymentModes);
        amountDueField = new JTextField();
        amountPaidField = new JTextField();
        amountPaidField.setText("0.00");
        changeField = new JTextField();
        changeField.setText("0.00");
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
        deleteButtonPay.setBounds(500, 10, 240, 100);
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
        addItemToSalesButton.setBounds(1160, 20, 80, 50);
        selectItemLabel.setBounds(720, 0, 100, 20);
        selectQtyLabel.setBounds(931, 0, 100, 20);
        selectQtySpinner.setBounds(931, 25, 100, 40);
        itemDiscountLabel.setBounds(1040, 0, 100, 20);
        assignDiscountSpinner.setBounds(1040, 25, 100, 40);
        processPayTopPayPanel.setBounds(510, 105, 750, 80);
        payNumberButtonsPanel.setBounds(510, 190, 750, 300);
        payModePanel.setBounds(5, 5, 500, 345);
        payTabelPanel.setBounds(5, 355, 500, 400);
        reverseStatusPanel.setBounds(510, 636, 750, 120);
        amountPaidLabel.setBounds(5, 60, 200, 50);
        payModeLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        amountPaidLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        amountDueLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        changeLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        totalNetLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
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
        updatePayTextArea(zeroButtonPay);
        payNumberButtonsPanel.setBackground(Color.decode("#193688"));
        zeroButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        clearFieldButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        addMoreCashButton.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        closeButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        deleteButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        zeroButtonPay.setForeground(Color.WHITE);
        printButtonPay.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
        zeroButtonPay.setBackground(Color.decode("#00BFF"));
        clearFieldButtonPay.setFont(new Font("STENCIL", Font.BOLD, 45));
        addMoreCashButton.setFont(new Font("STENCIL", Font.BOLD, 40));
        closeButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        deleteButtonPay.setFont(new Font("STENCIL", Font.BOLD, 28));
        printButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        zeroButtonPay.setFont(new Font("STENCIL", Font.BOLD, 40));
        zeroButtonPay.setForeground(Color.WHITE);
        amountReceivedWindow.setFont(new Font("STENCIL", Font.BOLD, 40));
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
        addMoreCashButton.setForeground(Color.WHITE);
        addMoreCashButton.setBackground(Color.decode("#00BFFF"));
        clearFieldButtonPay.setBackground(Color.decode("#DC143C"));
        closeButtonPay.setBackground(Color.decode("#DC143C"));
        printButtonPay.setBackground(Color.decode("#1E90FF"));
        deleteButtonPay.setBackground(Color.decode("#DC143C"));
        deleteButtonPay.setForeground(Color.WHITE);
        amountPaidField.setEditable(false);
        amountDueField.setEditable(false);
        changeField.setEditable(false);
        totalNetField.setEditable(false);
        reverseStatusPanel.add(closeButtonPay);
        reverseStatusPanel.add(deleteButtonPay);
        reverseStatusPanel.add(printButtonPay);
        processPayZeroCancelpanel.add(zeroButtonPay);
        processPayZeroCancelpanel.add(clearFieldButtonPay);
        processPayTopPayPanel.add(addMoreCashButton);
        processPayTopPayPanel.add(amountReceivedWindow);
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
        processPayMentsViewPanel.add(itemDiscountLabel);
        processPayMentsViewPanel.add(assignDiscountSpinner);
        processPayMentsViewPanel.add(addItemToSalesButton);
        processPayMentsViewPanel.add(processPayTopPayPanel);
        processPayMentsViewPanel.add(payNumberButtonsPanel);
        processPayMentsViewPanel.add(payModePanel);
        processPayMentsViewPanel.add(payTabelPanel);
        processPayMentsViewPanel.add(reverseStatusPanel);
        processPayMentsViewPanel.add(processPayZeroCancelpanel);
        deleteButtonPay.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel this transaction?");
            if (option == JOptionPane.NO_OPTION || option == JOptionPane.CANCEL_OPTION) {
            } else if (option == JOptionPane.OK_OPTION) {

                Integer costRemoved = DrugInventoryTransactions.deleteLastTransaction();
                Double newCost = new Double(amountDueField.getText()) - costRemoved;
                if (newCost < 1) {
                    newCost = 0.0;
                    amountDueField.setText(newCost.toString());
                    totalNetField.setText(newCost.toString());
                } else {
                    amountDueField.setText(newCost.toString());
                    totalNetField.setText(newCost.toString());
                }

                Double change = new Double(amountPaidField.getText()) - newCost;
                if (change < 1) {
                    change = 0.0;
                    changeField.setText(change.toString());
                } else {
                    changeField.setText(change.toString());
                }
                if (new Double(amountPaidField.getText()) > 0 && new Double(amountDueField.getText()) < 1) {
                    int cancelOption = JOptionPane.showConfirmDialog(null, "Amount Due is 0.0 Do You want to End The Transaction ?", "", JOptionPane.YES_NO_CANCEL_OPTION);
                    switch (cancelOption) {
                        case JOptionPane.YES_OPTION:
                            amountPaidField.setText("0.0");
                            changeField.setText("0.0");
                            break;
                        case JOptionPane.NO_OPTION:
                            //Do nothing
                            break;
                        case JOptionPane.CANCEL_OPTION:
                            //Do nothing
                            break;
                        default:
                            break;
                    }
                }

                saleTableModel.fireTableDataChanged();
                DrugInventoryTransactions.setUpperLimitInvoiceID();

                JOptionPane.showMessageDialog(null, "Transaction Cancelled!");
            }
        });
        printButtonPay.addActionListener(e -> {
            try {
                itemsPaymentTablePay.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat("Goodnew Pharmacy Recpt:"), new MessageFormat(printDate + "   " + companyInformation.getCompanyInformation().get("name")));
                ProductSalesTransactions.deleteTransactionData();
                amountReceivedWindow.setText("");
                amountPaidField.setText("0.00");
                changeField.setText("0.00");
                amountDueField.setText("0.00");
                totalNetField.setText("0.00");
                saleTableModel.fireTableDataChanged();
            } catch (PrinterException ex) {
            }
        });
        closeButtonPay.addActionListener(e -> {
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            pharmacyNameLabel.setText(companyInformation.getCompanyInformation().get("name"));
            companyFooterLabel.setText(companyInformation.getCompanyInformation().get("footer"));
            clockInAndOutViewPanel.setBackground(Color.white);
            splitPane.setRightComponent(clockInAndOutViewPanel);
        });

        clearFieldButtonPay.addActionListener(e -> {
            amountReceivedWindow.setText(amountReceivedWindow.getText().substring(0, amountReceivedWindow.getText().length() - 1));
        });
        addMoreCashButton.addActionListener(e -> {

            Double amountPaid = new Double(amountReceivedWindow.getText() + ".00") + new Double(amountPaidField.getText());
            amountPaidField.setText(amountPaid.toString());
            changeField.setText("" + getChange(new Double(amountReceivedWindow.getText() + ".00"), new Double(amountDueField.getText())));
            totalNetField.setText("" + getNetAmount(getChange(new Double(amountReceivedWindow.getText() + ".00"), new Double(amountDueField.getText())), new Double(amountDueField.getText())));
            amountReceivedWindow.setText("");

            repaint();
        });
        //---------------------------------------------------------------------------------------------------------------------------------------------
        //Add task view properties code
        settingsPanel = new JPanel(null);
        // 
        viewUserPanel = new JPanel(null);
        taskListViewPanel = new JPanel(null);
        clockInAndOutViewPanel = new JPanel(null);
        purchaseViewMenuItem = new JMenuItem("View Purchases");
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
        String[] taskFroSample = {"All", "Waitress", "Supervisor", "Manager", "System administrator", "HR", "Security"};
        taskFieldFor = new JComboBox<>(taskFroSample);
        addtaskButton = new JButton("Send");
        taskFieldFor.setBorder(new LineBorder(Color.decode("#1E90FF")));
        taskFieldFor.setEditable(true);
        descriptionArea.setBorder(new LineBorder(Color.decode("#1E90FF")));
        titleField.setBorder(new LineBorder(Color.decode("#1E90FF")));
        addtaskButton.setForeground(Color.WHITE);
        taskFieldFor.setBackground(Color.WHITE);
        ontopPanel.setBackground(Color.decode("#1E90FF"));
        addtaskPanel.setBackground(Color.WHITE);
        addtaskButton.setBackground(Color.decode("#1E90FF"));
        ontopPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        addtaskPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        addtaskLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        addtaskLabel.setForeground(Color.WHITE);
        taskListInfoLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        taskListInfoLabel.setForeground(Color.WHITE);
        ontopPanel.setBounds(200, 0, 800, 100);
        addtaskPanel.setBounds(200, 150, 800, 500);
        addtaskLabel.setBounds(350, 5, 200, 40);
        taskListInfoLabel.setBounds(70, 50, 900, 20);
        titleLabel.setBounds(50, 35, 200, 20);
        titleField.setBounds(50, 60, 700, 50);
        descriptionLabel.setBounds(50, 120, 200, 25);
        descriptionArea.setBounds(50, 150, 700, 150);
        taskLabel.setBounds(50, 300, 200, 30);
        taskFieldFor.setBounds(50, 340, 700, 50);
        addtaskButton.setBounds(50, 420, 95, 35);
        ontopPanel.add(addtaskLabel);
        ontopPanel.add(taskListInfoLabel);
        addtaskPanel.add(titleLabel);
        addtaskPanel.add(titleField);
        addtaskPanel.add(descriptionLabel);
        addtaskPanel.add(descriptionArea);
        addtaskPanel.add(taskLabel);
        addtaskPanel.add(taskFieldFor);
        addtaskPanel.add(addtaskButton);
        addNewTaskPanel.add(ontopPanel);
        addNewTaskPanel.add(addtaskPanel);
        addFieldsFocusListener(ontopPanel);
        addFieldsFocusListener(addtaskPanel);
        addFieldsFocusListener(titleField);
        addFieldsFocusListener(descriptionArea);
        addFieldsFocusListener(taskFieldFor);
        titleField.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));

        //Verify fields for Notice form
        List<JTextComponent> noticeTextWithNumbersField = Arrays.asList(
                titleField
        );
        List<JTextComponent> allNoticeFields = Arrays.asList(
                titleField, descriptionArea
        );
        validateFields(noticeTextWithNumbersField, InputVerification::verifiyNumbersWithTex);
        addtaskButton.addActionListener(e -> {

            if (checkIfFieldsAreBlank(allNoticeFields) == false
                    || levelTwoTextFieldsValidation(noticeTextWithNumbersField, InputVerification::verifiyNumbersWithTex) == false) {

                Toolkit soundToolkit = Toolkit.getDefaultToolkit();
                soundToolkit.beep();
                JOptionPane.showMessageDialog(null, "Ensure All Fields Are Valid", "Alpha Pharmacy POS", JOptionPane.ERROR_MESSAGE);

            } else if (checkIfFieldsAreBlank(allNoticeFields) == true
                    && levelTwoTextFieldsValidation(noticeTextWithNumbersField, InputVerification::verifiyNumbersWithTex) == true) {
                MemoAndNoticeTransactions.sendTastToDB(titleField.getText(), descriptionArea.getText(), taskFieldFor.getSelectedItem().toString());
                titleField.setText("");
                descriptionArea.setText("");
            }

        });
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
        posSettingsButton.setBackground(Color.decode("#DC143C"));
        posSettingsButton.setForeground(Color.WHITE);
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
        companyField.setText(companyInformation.getCompanyInformation().get("name"));
        companyAddressArea.setText(companyInformation.getCompanyInformation().get("address"));
        phoneNumberField.setText(companyInformation.getCompanyInformation().get("phone"));
        settingsEmailField.setText(companyInformation.getCompanyInformation().get("email"));
        vatField.setText(companyInformation.getCompanyInformation().get("VAT"));
        vatRegNumberField.setText(companyInformation.getCompanyInformation().get("VATRegNo"));
        footerTextArea.setText(companyInformation.getCompanyInformation().get("footer"));
        webAddressField.setText(companyInformation.getCompanyInformation().get("webAddress"));

        //Register all textFields for validation
        //Verify pure text textFields @ Company settings
        List<JTextComponent> pureTextTextComponents = Arrays.asList(
                companyField, footerTextArea
        );
        validateFields(pureTextTextComponents, InputVerification::verifyTextOnlyFields);

        //Verify Numbers Only Fields @ Company settings
        List<JTextComponent> numbersOnlyTextFields = Arrays.asList(
                phoneNumberField
        );
        validateFields(numbersOnlyTextFields, InputVerification::verifyNumbersOnlyFields);

        //Verify numbersAndText fields @Company Settings
        List<JTextComponent> numbersAndTextFields = Arrays.asList(
                vatField, vatRegNumberField, vatField
        );
        validateFields(numbersAndTextFields, InputVerification::verifiyNumbersWithTex);

        //Verify address
        List<JTextComponent> physicalAddressFields = Arrays.asList(
                companyAddressArea
        );
        validateFields(physicalAddressFields, InputVerification::verifyAddress);

        //vaarify Email
        List<JTextComponent> emailAddressFields = Arrays.asList(
                settingsEmailField
        );
        validateFields(emailAddressFields, InputVerification::verifyEmails);

        //verify web address
        List<JTextComponent> webAddressFields = Arrays.asList(
                webAddressField
        );
        validateFields(webAddressFields, InputVerification::verifyWebAddress);

        List<JTextComponent> allFields = Arrays.asList(
                companyField, footerTextArea, phoneNumberField, vatField, vatRegNumberField, vatField,
                companyAddressArea, settingsEmailField, webAddressField
        );

        updateSettingButton.addActionListener(e -> {
            if (checkIfFieldsAreBlank(allFields) == false
                    || levelTwoTextFieldsValidation(webAddressFields, InputVerification::verifyWebAddress) == false
                    || levelTwoTextFieldsValidation(emailAddressFields, InputVerification::verifyEmails) == false
                    || levelTwoTextFieldsValidation(physicalAddressFields, InputVerification::verifyAddress) == false
                    || levelTwoTextFieldsValidation(numbersAndTextFields, InputVerification::verifiyNumbersWithTex) == false
                    || levelTwoTextFieldsValidation(numbersOnlyTextFields, InputVerification::verifyNumbersOnlyFields) == false
                    || levelTwoTextFieldsValidation(pureTextTextComponents, InputVerification::verifyTextOnlyFields) == false) {

                Toolkit soundToolkit = Toolkit.getDefaultToolkit();
                soundToolkit.beep();
                JOptionPane.showMessageDialog(null, "Ensure All Fields are Valid", "", JOptionPane.ERROR_MESSAGE);
            } else if (checkIfFieldsAreBlank(allFields) == true) {
                companyInformation.addCompanyInformationToDB(companyField.getText(), companyAddressArea.getText(), phoneNumberField.getText(), settingsEmailField.getText(), webAddressField.getText(), vatField.getText(), vatRegNumberField.getText(), footerTextArea.getText());
            }
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
        newEmployeeAddNewEmplyeeLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        newEmployeeAddNewEmplyeeLabel.setForeground(Color.WHITE);
        newEmployeeeditProfilePanel.setBackground(Color.WHITE);
        newEmployeeupdateInfoButton.setBackground(Color.decode("#DC143C"));
        newEmployeeadminButton.setBackground(Color.decode("#DC143C"));
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
        newEmployeeAddNewEmplyeeLabel.setBounds(50, 35, 1000, 40);
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
        passwordAvailableLabel.setBounds(820, 260, 250, 50);
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
        newEmployeeeditProfilePanel.add(passwordAvailableLabel);
        newEmployeeeditProfilePanel.add(newEmployeepassword);
        newEmployeeeditProfilePanel.add(newEmployeeconfirmPasswordlabel);
        newEmployeeeditProfilePanel.add(newEmployeeconfirmPasswordField);
        newEmployeeeditProfilePanel.add(newEmployeeupdateUserDetailsButton);
        newEmployeetopAddUserPanel.setBackground(Color.decode("#1E90FF"));
        passwordAvailableLabel.setForeground(Color.red);
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
                imagee = ImageIO.read(filee);
                newEmployeeprofileImageLabel.setIcon(new ImageIcon(imagee));
                imageFileSelected = true;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Unabale to add File...\n" + ex.getMessage());
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "No File Selected...");
            }
        });

        //Verify employee Details form
        List<JTextComponent> employeeTextOnlyFields = Arrays.asList(
                newEmployeefirstNameField, newEmployeelastNameField
        );
        validateFields(employeeTextOnlyFields, InputVerification::verifyTextOnlyFields);
        List<JTextComponent> employeeNumbersOnlyFields = Arrays.asList(
                newEmployeephoneField
        );
        validateFields(employeeNumbersOnlyFields, InputVerification::verifyNumbersOnlyFields);
        List<JTextComponent> employeesEmailFields = Arrays.asList(
                newEmployeeemailField
        );
        validateFields(employeesEmailFields, InputVerification::verifyEmails);
        List<JTextComponent> employeeFullNamesWithInitials = Arrays.asList(
                newEmployeeSupervisorField
        );
        validateFields(employeeFullNamesWithInitials, InputVerification::verifyNamesWithInitials);
        List<JTextComponent> numbersWithTextFields = Arrays.asList(
                newEmployeeemployeeIDField
        );
        validateFields(numbersWithTextFields, InputVerification::verifiyNumbersWithTex);
        List<JTextComponent> allEmployeeTextComponents = Arrays.asList(
                newEmployeeemployeeIDField, newEmployeeSupervisorField, newEmployeeemailField, newEmployeephoneField,
                newEmployeefirstNameField, newEmployeelastNameField, newEmployeepassword, newEmployeeconfirmPasswordField
        );

        //check if password is already in use
        newEmployeepassword.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        if (EmployeeDataTransaction.comparePasswordsForDuplicates(String.valueOf(newEmployeepassword.getPassword()))) {
                            newEmployeeeditProfilePanel.remove(passwordAvailableLabel);
                            repaint();
                            passwordAvailableLabel.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\white.PNG"));
                            passwordAvailableLabel.setText("Password Already In Use");
                            newEmployeeeditProfilePanel.add(passwordAvailableLabel);
                            repaint();
                        } else if (!EmployeeDataTransaction.comparePasswordsForDuplicates(String.valueOf(newEmployeepassword.getPassword()))) {
                            newEmployeeeditProfilePanel.remove(passwordAvailableLabel);
                            repaint();
                            passwordAvailableLabel.setText("");
                            passwordAvailableLabel.setIcon(passwordStatusLabelIcon);
                            newEmployeeeditProfilePanel.add(passwordAvailableLabel);
                            repaint();
                        }
                    }
                }
        );

        newEmployeeupdateUserDetailsButton.addActionListener(e -> {

            //Extra code for image file absent notification
            if (imageFileSelected == false) {
                JOptionPane.showMessageDialog(null, "No imageFile Found !");
            } else {

            }

            if (checkIfFieldsAreBlank(allEmployeeTextComponents) == false
                    || levelTwoTextFieldsValidation(numbersWithTextFields, InputVerification::verifiyNumbersWithTex) == false
                    || levelTwoTextFieldsValidation(employeeFullNamesWithInitials, InputVerification::verifyNamesWithInitials) == false
                    || levelTwoTextFieldsValidation(employeeNumbersOnlyFields, InputVerification::verifyNumbersOnlyFields) == false
                    || levelTwoTextFieldsValidation(employeeTextOnlyFields, InputVerification::verifyTextOnlyFields) == false
                    || imageFileSelected == false) {

                Toolkit soundToolkit = Toolkit.getDefaultToolkit();
                soundToolkit.beep();
                JOptionPane.showMessageDialog(null, "Ensure All Fields Are Valid !", "Alpha Pharmacy POS", JOptionPane.ERROR_MESSAGE);

            } else if (checkIfFieldsAreBlank(allEmployeeTextComponents) == true) {
                String enteredPassword = String.valueOf(newEmployeepassword.getPassword());
                String confirmPassword = String.valueOf(newEmployeeconfirmPasswordField.getPassword());
                int status = employeeDataTransactions.addNewEmployee(newEmployeeemployeeIDField.getText(), newEmployeefirstNameField.getText(), newEmployeelastNameField.getText(), newEmployeephoneField.getText(), newEmployeeemailField.getText(), newEmployeeSupervisorField.getText(), enteredPassword, newEmployeeNewEmpfileChooser.getSelectedFile().getPath(), confirmPassword);
                switch (status) {
                    case EmployeeDataTransaction.EMPLOYEE_ADDITION_SUCCEFULL:
                        newEmployeefirstNameField.setBorder(new LineBorder(Color.decode("#1E90FF"), 3));
                        newEmployeelastNameField.setBorder(new LineBorder(Color.decode("#1E90FF"), 3));
                        newEmployeephoneField.setBorder(new LineBorder(Color.decode("#1E90FF"), 3));
                        newEmployeeemailField.setBorder(new LineBorder(Color.decode("#1E90FF"), 3));
                        newEmployeeSupervisorField.setBorder(new LineBorder(Color.decode("#1E90FF"), 3));
                        newEmployeeemployeeIDField.setBorder(new LineBorder(Color.decode("#1E90FF"), 3));
                        newEmployeepassword.setBorder(new LineBorder(Color.decode("#1E90FF"), 3));
                        newEmployeepassword.setText("");
                        newEmployeeconfirmPasswordField.setText("");
                        List<JTextComponent> textFieldsList = Arrays.asList(newEmployeeemployeeIDField, newEmployeeSupervisorField, newEmployeeemailField, newEmployeefirstNameField, newEmployeelastNameField, newEmployeephoneField);
                        makeFieldsBlank(textFieldsList);
                        break;
                    case EmployeeDataTransaction.ID_DUPLICATION:
                        newEmployeeemployeeIDField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                        newEmployeeemployeeIDField.setForeground(Color.red);
                        makeFieldForegroundBlack(newEmployeeemployeeIDField);
                        break;
                    case EmployeeDataTransaction.PASSWORD_DUPLICATION:
                        newEmployeepassword.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                        newEmployeepassword.setText("");
                        newEmployeeconfirmPasswordField.setText("");
                        makeFieldForegroundBlack(newEmployeepassword);
                        break;
                    case EmployeeDataTransaction.PASSWORD_CONFIRMATION_FAILED:
                        newEmployeeconfirmPasswordField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                        newEmployeepassword.setText("");
                        newEmployeeconfirmPasswordField.setText("");
                        makeFieldForegroundBlack(newEmployeeconfirmPasswordField);
                        break;
                    case EmployeeDataTransaction.EMPLYEE_ADDITION_FAILED:
                        newEmployeefirstNameField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                        newEmployeelastNameField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                        newEmployeephoneField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                        newEmployeeemailField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                        newEmployeeSupervisorField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                        newEmployeeemployeeIDField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                        newEmployeepassword.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                        newEmployeeconfirmPasswordField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                        makeFieldForegroundBlack(newEmployeefirstNameField);
                        makeFieldForegroundBlack(newEmployeelastNameField);
                        makeFieldForegroundBlack(newEmployeephoneField);
                        makeFieldForegroundBlack(newEmployeeemailField);
                        makeFieldForegroundBlack(newEmployeeSupervisorField);
                        makeFieldForegroundBlack(newEmployeeemployeeIDField);
                        makeFieldForegroundBlack(newEmployeepassword);
                        makeFieldForegroundBlack(newEmployeeconfirmPasswordField);
                        break;
                    default:
                        break;
                }
            }
        });
        //---------------------------------------------------------------------------------------------------------------------------------------
        topAddUserPanel = new JPanel(null);
        editProfilePanel = new JPanel(null);
        updateInfooButton = new JButton("Update Info");
        updateUserDetailsButton = new JButton("Save");
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
        userAccessLevelPriviledgeLable = new JLabel("Access Level");
        String[] accesslevels = {"System Administrator", "Manager", "Supervisor", "Staff Member"};
        usersAccessLevelCombo = new JComboBox<>(accesslevels);
        passwordLabel = new JLabel("Password");
        userPasswordField = new JPasswordField();
        confirmPasswordlabel = new JLabel("Confirm Password");
        confirmPasswordField = new JPasswordField();
        topAddUserPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        editProfilePanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
        userProfilelabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        editProfilePanel.setBackground(Color.WHITE);
        updateInfooButton.setBackground(Color.decode("#DC143C"));
        adminButton.setBackground(Color.decode("#DC143C"));
        updateInfooButton.setForeground(Color.WHITE);
        adminButton.setForeground(Color.WHITE);
        updateUserDetailsButton.setBackground(Color.decode("#1E90FF"));
        updateUserDetailsButton.setForeground(Color.WHITE);
        topAddUserPanel.setBounds(100, 0, 1000, 100);
        editProfilePanel.setBounds(100, 150, 1000, 550);
        userProfilelabel.setBounds(50, 35, 1000, 40);
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
        userAccessLevelPriviledgeLable.setBounds(500, 60, 300, 30);
        usersAccessLevelCombo.setBounds(500, 100, 300, 40);
        passwordLabel.setBounds(500, 140, 300, 30);
        userPasswordField.setBounds(500, 170, 300, 30);
        userPasswordField.setBounds(500, 180, 300, 40);
        confirmPasswordlabel.setBounds(500, 220, 300, 30);
        confirmPasswordField.setBounds(500, 260, 300, 40);
        updateUserDetailsButton.setBounds(500, 340, 100, 40);
        usersAccessLevelCombo.setBackground(Color.white);
        usersAccessLevelCombo.setForeground(Color.decode("#1E90FF"));
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
        editProfilePanel.add(userAccessLevelPriviledgeLable);
        editProfilePanel.add(usersAccessLevelCombo);
        editProfilePanel.add(passwordLabel);
        editProfilePanel.add(userPasswordField);
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
        addFieldsFocusListener(usersAccessLevelCombo);
        addFieldsFocusListener(userPasswordField);
        addFieldsFocusListener(confirmPasswordField);
        //Verify and validate fields for users registration
        List<JTextComponent> textOnlyComponents = Arrays.asList(
                firstNameField, lastNameField
        );
        validateFields(textOnlyComponents, InputVerification::verifyTextOnlyFields);
        List<JTextComponent> numbersOnlyTextComponents = Arrays.asList(
                phoneField
        );
        validateFields(numbersOnlyTextComponents, InputVerification::verifyNumbersOnlyFields);
        List<JTextComponent> emailTextComponents = Arrays.asList(
                emailField
        );
        validateFields(emailTextComponents, InputVerification::verifyEmails);
        List<JTextComponent> fullNamesWithInitials = Arrays.asList(
                supervisorField
        );
        validateFields(fullNamesWithInitials, InputVerification::verifyNamesWithInitials);
        List<JTextComponent> allUserDataFormFields = Arrays.asList(
                supervisorField, emailField, phoneField, firstNameField, lastNameField, userPasswordField,
                confirmPasswordField
        );

        updateUserDetailsButton.addActionListener(event -> {

            //Ensure there are no blank fields
            if (checkIfFieldsAreBlank(allFields) == false || levelTwoTextFieldsValidation(fullNamesWithInitials, InputVerification::verifyNamesWithInitials) == false
                    || levelTwoTextFieldsValidation(emailTextComponents, InputVerification::verifyEmails) == false
                    || levelTwoTextFieldsValidation(numbersOnlyTextComponents, InputVerification::verifyNumbersOnlyFields) == false
                    || levelTwoTextFieldsValidation(textOnlyComponents, InputVerification::verifyTextOnlyFields) == false) {

                JOptionPane.showMessageDialog(null, "Ensure All Fields Are Valid", "Alpha Pharmacy POS", JOptionPane.ERROR_MESSAGE);

            } else if (checkIfFieldsAreBlank(allFields) == true) {

                //Confirm password
                if ((String.valueOf(userPasswordField.getPassword())).equals(String.valueOf(confirmPasswordField.getPassword()))) {
                    String userPass = SHA1PasswordHashing.hashPassword(String.valueOf(userPasswordField.getPassword()));
                    int insert_status = UsersInformationTransactions.addUserInformationToDB("232", firstNameField.getText(), lastNameField.getText(), phoneField.getText(), emailField.getText(), supervisorField.getText(), usersAccessLevelCombo.getSelectedItem().toString(), userPass);
                    switch (insert_status) {
                        case UsersInformationTransactions.PASSWORD_NOT_AVAILBLE:
                            userPasswordField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                            confirmPasswordField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                            JOptionPane.showMessageDialog(null, "Password Not Available!");
                            break;
                        case UsersInformationTransactions.PASSWORD_AVAILABLE:
                            //insert user info to db
                            //Clear all fields for next input
                            makeFieldsBlank(allUserDataFormFields);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Unknown Error.\nConsult Root");
                            break;
                    }
                } else if (!(String.valueOf(userPasswordField.getPassword())).equals(String.valueOf(confirmPasswordField.getPassword()))) {
                    confirmPasswordField.setBorder(new LineBorder(Color.decode("#DC143C"), 3));
                    JOptionPane.showMessageDialog(null, "Passwords do not match", "", JOptionPane.ERROR_MESSAGE);
                    confirmPasswordField.setText("");
                    userPasswordField.setText("");
                }
            }

        });
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

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String[] inventoryViewSortMethods = {"TimeRemaining", "Qty", "Reorder_Level", "Name", "SellPrice", "Category", "ID", "PurchasePrice", "Status"};
        inventoryViewsaddNewItemButton = new JButton("Add New Drugs");
        inventoryPrintButton = new JButton("Print");
        inventorySearchButton = new JButton("");
        inventoryTotalLabel = new JLabel("Total:" + stockTabelModel.getRowCount() + "  Records Found");
        inventorySearchButton.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\searchIcon.jpg"));
        inventorySortByButton = new JButton("Sort By:");
        inventorySearchField = new JTextField("Search...");
        String[] optionsASCDCS = {"ASC", "DESC"};
        finalSortButton = new JButton("Sort");
        ascendingDescendingCombo = new JComboBox<>(optionsASCDCS);
        inventorySortMethodCombo = new JComboBox<>(inventoryViewSortMethods);
        inventoryItemsTable = new JTable(stockTabelModel);
        inventoryItemsTable.setForeground(Color.decode("#808080"));
        inventoryItemsTable.setSelectionBackground(Color.decode("#1E90FF"));
        inventoryItemsTable.setSelectionForeground(Color.WHITE);
        inventoryItemsTable.setFillsViewportHeight(true);
        inventoryItemsTable.setShowHorizontalLines(false);
        inventoryItemsTable.setShowVerticalLines(true);
        inventoryItemsTable.setRowHeight(30);
        inventoryItemsTable.setFont(new Font("Calibri", Font.BOLD, 12));
        List<String> stocksTableColumnHeaders = Arrays.asList("Drug ID", "Drug Name", "Purchase Price", "Quantity", "Selling Price", "Category", "Expiry Time(Months)", "Status", "Note");
        setTableColumnHeaders(stocksTableColumnHeaders, stockTabelModel);
        inventoryTableScrollPane = new JScrollPane(inventoryItemsTable);
        inventoryTableScrollPane.getViewport().setBackground(Color.WHITE);
        finalSortButton.setBackground(Color.decode("#1E90FF"));
        finalSortButton.setForeground(Color.WHITE);
        inventoryViewsaddNewItemButton.setBounds(400, 20, 150, 30);
        drugInventoryLabel.setBounds(30, 15, 250, 40);
        inventoryPrintButton.setBounds(570, 20, 100, 30);
        inventorySearchButton.setBounds(25, 5, 30, 30);
        inventorySearchField.setBounds(55, 5, 300, 30);
        inventorySortByButton.setBounds(365, 5, 100, 30);
        inventorySortMethodCombo.setBounds(475, 5, 200, 30);
        ascendingDescendingCombo.setBounds(680, 5, 150, 30);
        finalSortButton.setBounds(840, 5, 100, 30);
        inventoryTableScrollPane.setBounds(5, 25, 990, 415);
        inventroyViewTopPanel = new JPanel(null);
        inventoryViewTableComponentsPanel = new JPanel(null);
        inventoryViewTableOnlypanel = new JPanel(null);
        inventroyViewTopPanel.setBackground(Color.decode("#1E90FF"));
        inventoryViewTableComponentsPanel.setBackground(Color.LIGHT_GRAY);
        inventoryViewTableOnlypanel.setBackground(Color.WHITE);
        inventorySortMethodCombo.setBackground(Color.WHITE);
        ascendingDescendingCombo.setBackground(Color.WHITE);
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
        inventoryViewTableComponentsPanel.add(inventorySearchField);
        inventoryViewTableComponentsPanel.add(inventorySortByButton);
        inventoryViewTableComponentsPanel.add(inventorySortMethodCombo);
        inventoryViewTableComponentsPanel.add(ascendingDescendingCombo);
        inventoryViewTableComponentsPanel.add(finalSortButton);
        inventoryViewTableOnlypanel.add(inventoryTotalLabel);
        inventoryViewTableOnlypanel.add(inventoryTableScrollPane);
        addFieldsFocusListener(inventorySortMethodCombo);
        addFieldsFocusListener(inventorySearchField);
        inventoryViewPanel.add(inventroyViewTopPanel);
        inventoryViewPanel.add(inventoryViewTableComponentsPanel);
        inventoryViewPanel.add(inventoryViewTableOnlypanel);
        searchTextFieldMouseListener(inventorySearchField);

        inventorySearchButton.addActionListener(e -> {
            retrieveDataBySearch(inventorySearchField.getText(), stockTabelModel, "SELECT ID,name,purchasePrice,qty,sellPrice,Category,timeRemaining,Status,Details FROM drugs WHERE category LIKE '%" + inventorySearchField.getText() + "%' OR name LIKE '%" + inventorySearchField.getText() + "%' OR ID LIKE '%" + inventorySearchField.getText() + "%';");
        });
        inventorySearchField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        stockSearchText = inventorySearchField.getText();
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        stockSearchText = inventorySearchField.getText();
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        retrieveDataBySearch("SELECT ID,name,purchasePrice,qty,sellPrice,Category,timeRemaining,Status,Details FROM drugs WHERE category LIKE '%" + stockSearchText + "%' OR name LIKE '%" + stockSearchText + "%' OR ID LIKE '%" + stockSearchText + "%' OR details LIKE '%" + stockSearchText + "%' OR status LIKE '%" + stockSearchText + "%' OR expDate LIKE '%" + stockSearchText + "%' OR sellPrice LIKE '%" + stockSearchText + "%' OR qty LIKE '%" + stockSearchText + "%' OR purchasePrice LIKE '%" + stockSearchText + "%';", stockTabelModel, "Stock");
                    }

                }
        );

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String[] sortMethods = {"Price", "Category", "ID", "Name", "Discount", "Code", "Qty"};
        addNewItemButton = new JButton("Add New Item");
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
        addNewItemButton.addActionListener(e -> {

            if (DrugInventoryTransactions.getApplicationContext() == 0) {
                EditItemsDetailsFrame editItemsDetailsFrame = new EditItemsDetailsFrame(true);
            } else if (DrugInventoryTransactions.getApplicationContext() == 1) {
                while (true) {
                    JOptionPane.showMessageDialog(null, "Connot Connect to Alpha Restaurant POS.sql...");
                }
            }

        });
        printButton.addActionListener(e -> printJTable(itemsTable, "Items Report"));
        //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String staffCatogories[] = {"Genitor", "Cashier", "Sales "};
        DAO = new ClockInClockOutTransactions();
        selectCategory = new JComboBox<>(staffCatogories);
        pharmacyNameLabel = new JLabel(companyInformation.getCompanyInformation().get("name"));
        pharmacyNameLabel.setFont(new Font("STENCIL", Font.BOLD, 36));
        companyFooterLabel.setFont(new Font("OLD ENGLISH TEXT MT", Font.ITALIC, 30));
        pharmacyNameLabel.setBounds(10, 200, 600, 80);
        companyFooterLabel.setBounds(15, 330, 600, 80);
        clearClockInClockOutButton = new JButton("C\nL\nE\nA\nR");
        clockInButton = new JButton("Clock In");
        clockOutButton = new JButton("Clock Out");
        clockInButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        clockOutButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        clockInButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        clockOutButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        clockInButton.setBackground(Color.decode("#00BFFF"));
        clockOutButton.setBackground(Color.decode("#DC143C"));
        clockInButton.setForeground(Color.WHITE);
        clockOutButton.setForeground(Color.WHITE);
        enterButtonPanel = new JPanel();
        ClockInClockOutEmployeeIDField = new JTextArea(1, 20);
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
        clearClockInClockOutButton.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
        clearClockInClockOutButton.setFont(new Font("STENCIL", Font.BOLD, 30));
        clearClockInClockOutButton.setBackground(Color.decode("#DC143C"));
        //Inject blue to blue effect on clock in/out
        List<JButton> clockInOutJItems = Arrays.asList(
                oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, bottomButton
        );
        setClockInButtonsProperties(clockInOutJItems);
        clearClockInClockOutButton.setForeground(Color.white);
        errorPanel = new JPanel();
        clockInOutPanel = new JPanel();
        clockInOutPanel = new JPanel();
        passwordorIdPanel.setLayout(null);
        enterButtonPanel.setLayout(null);
        zeroToTenButtonsPanel.setLayout(new GridLayout(3, 3));
        clockInOutPanel.setLayout(null);
        errorPanel.setLayout(null);
        bottomButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
        enterButtonPanel.setBackground(Color.YELLOW);
        zeroToTenButtonsPanel.setBackground(Color.decode("#F5F5F5"));
        passwordorIdPanel.setBackground(Color.decode("#F5F5F5"));
        clockInOutPanel.setBackground(Color.decode("#F5F5F5"));
        errorPanel.setBackground(Color.WHITE);
        ClockInClockOutEmployeeIDField.setEditable(true);
        ClockInClockOutEmployeeIDField.setFont(new Font("Times New Roman", Font.BOLD, 14));
        ClockInClockOutEmployeeIDField.setForeground(Color.decode("#1E90FF"));
        ClockInClockOutEmployeeIDField.setText("");
        clockInButton.setBounds(400, 15, 100, 80);
        clockOutButton.setBounds(520, 15, 100, 80);
        clearClockInClockOutButton.setBounds(0, 0, 160, 280);
        selectCategory.setBounds(15, 28, 280, 50);
        enterButtonPanel.setBounds(455, 205, 160, 280);
        ClockInClockOutEmployeeIDField.setBounds(10, 20, 585, 60);
        passwordorIdPanel.setBounds(15, 100, 605, 100);
        passwordorIdPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 3), "Enter Staff ID", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", Font.BOLD, 12)));
        clockInOutPanel.setBounds(620, 100, 630, 500);
        clockInOutPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 5), "Clock In/ Clock Out", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", Font.BOLD, 14)));
        zeroToTenButtonsPanel.setBounds(15, 205, 380, 200);
        errorPanel.setBounds(10, 200, 600, 400);
        bottomButton.setBounds(15, 405, 380, 80);
        passwordorIdPanel.add(ClockInClockOutEmployeeIDField);
        clockInOutPanel.add(selectCategory);
        clockInOutPanel.add(clockInButton);
        clockInOutPanel.add(clockOutButton);
        enterButtonPanel.add(clearClockInClockOutButton);
        clockInOutPanel.add(enterButtonPanel);
        clockInOutPanel.add(passwordorIdPanel);
        clockInOutPanel.add(bottomButton);
        clockInOutPanel.add(zeroToTenButtonsPanel);
        clockInAndOutViewPanel.add(pharmacyNameLabel);
        clockInAndOutViewPanel.add(companyFooterLabel);
       // errorPanel.add(backgroundImageLabel);
       // clockInAndOutViewPanel.add(errorPanel);
        clockInAndOutViewPanel.add(clockInOutPanel);
        addTextAreaKeyListenerEvents(ClockInClockOutEmployeeIDField);
        clockOutButton.addActionListener(e -> {
            if (DAO.isIDValid(ClockInClockOutEmployeeIDField.getText())) {
                try {
                    DAO.clockOut(new Integer(ClockInClockOutEmployeeIDField.getText()));
                } catch (NumberFormatException ex) {
                    ClockInClockOutEmployeeIDField.setForeground(Color.decode("#DC143C"));
                    JOptionPane.showMessageDialog(null, "Invalid Employee ID Format");
                }
            } else if (!DAO.isIDValid(ClockInClockOutEmployeeIDField.getText())) {
                ClockInClockOutEmployeeIDField.setForeground(Color.decode("#DC143C"));
                JOptionPane.showMessageDialog(null, "Unregistered Employee ID");
            }

        });

        clockInButton.addActionListener(event -> {

            if (DAO.isIDValid(ClockInClockOutEmployeeIDField.getText())) {
                ClockInClockOutEmployeeIDField.setForeground(Color.decode("#1E90FF"));
                try {
                    int clockInStatus = DAO.clockIn(new Integer(ClockInClockOutEmployeeIDField.getText()));
                    switch (clockInStatus) {
                        case ClockInClockOutTransactions.ALREADY_CLOCKED_IN:
                            JOptionPane.showMessageDialog(null, "Employee ID is Already Clocked In");
                            ClockInClockOutEmployeeIDField.setForeground(Color.decode("#DC143C"));
                            break;
                        case ClockInClockOutTransactions.CLOCK_IN_FAILED:
                            JOptionPane.showMessageDialog(null, "Clock In Failed");
                            break;
                        case ClockInClockOutTransactions.CLOCK_IN_SUCCESSFULL:
                            JOptionPane.showMessageDialog(null, "Clock In Successfull");
                            ClockInClockOutEmployeeIDField.setText("");
                            selectCategoryCombo = new JComboBox<>(drugInventoryTransactions.getCategories());
                            selectCategoryCombo.setBounds(510, 25, 200, 40);
                            processPayMentsViewPanel.add(selectCategoryCombo);
                            selectCategoryCombo = new JComboBox<>(drugInventoryTransactions.getCategories());
                            selectCategoryCombo.setBounds(510, 25, 200, 40);
                            processPayMentsViewPanel.add(selectCategoryCombo);
                            categoriesComboBoxEvents();
                            processPayMentsViewPanel.add(backgroundImageLabel);
                            repaint();
                            replaceRightComponentOnSplitPane(processPayMentsViewPanel);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Unknown Internal Error Occurred...");
                            break;
                    }
                } catch (NumberFormatException e) {
                    ClockInClockOutEmployeeIDField.setForeground(Color.decode("#DC143C"));
                    JOptionPane.showMessageDialog(null, "Invalid Employee ID Format");
                }
            } else if (!DAO.isIDValid(ClockInClockOutEmployeeIDField.getText())) {
                ClockInClockOutEmployeeIDField.setForeground(Color.decode("#DC143C"));
                JOptionPane.showMessageDialog(null, "Unregistered Employee ID");
            }
        });
        clearClockInClockOutButton.addActionListener(e -> ClockInClockOutEmployeeIDField.setText(""));
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
        startDateField = new JDateChooser();
        endDateField = new JDateChooser();
        statementLineOneLabel = new JLabel("Total: " + invoiceTableModel.getRowCount() + "  Records  Found");
        statementLineTwoLabel = new JLabel("Total Sales = " + drugInventoryTransactions.getTotalSales());
        statementLineThreeLabel = new JLabel("Total Vat = 93.96");
        statementLineFourLabel = new JLabel("Total Profit =" + drugInventoryTransactions.getTotalprofitFromSales());
        statementLineFiveLabel = new JLabel(CompanyInfoTransactions.getSpecificComapanyInfo("company_name") + "  Co L.T.d");
        statementLineSixLabel = new JLabel(CompanyInfoTransactions.getSpecificComapanyInfo("\tAddress"));
        statementLineSevenLabel = new JLabel("");
        statementLineEightLabel = new JLabel(CompanyInfoTransactions.getSpecificComapanyInfo("email"));
        LocalDate t2oday = LocalDate.now();
        LocalTime thisTime = LocalTime.now();
        statementLineTenLabel = new JLabel(t2oday.toString() + "  :: " + thisTime.toString());
        statementLineEightLabel = new JLabel(CompanyInfoTransactions.getSpecificComapanyInfo("web_Address"));
        statementLineNineLabel = new JLabel(CompanyInfoTransactions.getSpecificComapanyInfo("phone"));
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
        statementLineSixLabel.setBounds(465, 70, 300, 30);
        statementLineSevenLabel.setBounds(440, 120, 200, 30);
        statementLineEightLabel.setBounds(450, 100, 200, 30);
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
        /* onClickBlueBorder(InvoicesearchField);
         onClickBlueBorder(startDateField);
         onClickBlueBorder(endDateField);*/
        searchTextFieldMouseListener(InvoicesearchField);
        InvoicesearchField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        salesSearchtext = InvoicesearchField.getText();
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        salesSearchtext = InvoicesearchField.getText();

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        retrieveDataBySearch("SELECT * FROM salesinvoice WHERE InvoiceID  LIKE '%" + salesSearchtext + "%' OR SaleDate   LIKE '%" + salesSearchtext + "%' OR SoldItem   LIKE '%" + salesSearchtext
                                + "%' OR Qty LIKE '%" + salesSearchtext + "%' OR Total LIKE '%" + salesSearchtext + "%' OR PROFIT LIKE  '%" + salesSearchtext + "%' OR PayType LIKE '%" + salesSearchtext + "%' OR servedBy  LIKE '%" + salesSearchtext + "%' OR payType LIKE '%" + salesSearchtext + "%';", invoiceTableModel, "Sales");
                    }

                }
        );
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
        paymentButton = new JButton("Payment");
        searchField2 = new JTextField();
        tempPanel = new JPanel();
        tempPanel.setBackground(Color.decode("#DC143C"));
        printNotificationMenuItem = new JMenuItem("Print Notification");
        exitMenuItem = new JMenuItem("Exit");
        makeANewSaleMenuItem = new JMenuItem("New Sale");
        newNoticeMenuItem = new JMenuItem("New Notice");
        newUserMenuItem = new JMenuItem("New User");
        newEmployeeMenuItem = new JMenuItem("New Employee");
        taskMenuItem = new JMenuItem("Task ");
        settingsMenuitem = new JMenuItem("Company Settings");
        logOutMenuItem = new JMenuItem("Log Out");
        fileMenu = new JMenu("File");
        displaySettingsMenu = new JMenu("Display Settings");
        editMenu = new JMenu("Edit");
        viewMenu = new JMenu("View");
        purchasingMenu = new JMenu("Purchasing");
        configurationMenu = new JMenu("Configuration");
        helpMenu = new JMenu("Help");
        customersMenu = new JMenu("Customers");
        //PrepareMenuItems --> itemsMenu
        addNewExpenseMenuItem = new JMenuItem("Record Expense");
        enterReturnedGoodsMenuItem = new JMenuItem("Enter Returned Goods");
        viewReturnedGoodsMenuItem = new JMenuItem("View Returned Goods");
        addnewItemMenuItem = new JMenuItem("Add New Item");
        expensesViewMenuItem = new JMenuItem("View Expenses");
        manageItemMenuItem = new JMenuItem("View Stock");
        itemsListMenuItem = new JMenuItem("Items List");
        categoriesMenuItem = new JMenuItem("Categories");
        //PrepareMenuItems --> customerMenu
        addCustomerMenuItem = new JMenuItem("Add Customer");
        manageCustomersMenuItem = new JMenuItem("Manage Customers");
        //PrepareMenuItems --> usersMenu
        addUsersmenuitem = new JMenuItem("New User");
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
        menuBar = new JMenuBar();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
        splitPane.setDividerLocation(1);
        splitPane.setEnabled(true);
        splitPane.setDividerSize(1);
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
        itemsMenu.setForeground(Color.WHITE);
        fileMenu.setForeground(Color.WHITE);
        suppliersMenu.setForeground(Color.WHITE);
        salesMenu.setForeground(Color.WHITE);
        stockMenu.setForeground(Color.WHITE);
        expensesMenu.setForeground(Color.WHITE);
        returnsMenu.setForeground(Color.WHITE);
        displaySettingsMenu.setForeground(Color.WHITE);
        editMenu.setForeground(Color.WHITE);
        viewMenu.setForeground(Color.WHITE);
        purchasingMenu.setForeground(Color.WHITE);
        configurationMenu.setForeground(Color.WHITE);
        helpMenu.setForeground(Color.WHITE);
        reportsMainViewMenu.setForeground(Color.WHITE);
        itemsMenu.setForeground(Color.WHITE);
        customersMenu.setForeground(Color.WHITE);
        editMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        itemsMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        users.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        PointofSaleLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        titleOfLocggedUser.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        reports.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        customers.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        salesRegister.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        fileMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        suppliersMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        salesMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        stockMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        expensesMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        returnsMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        helpMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        reportsMainViewMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        customersMenu.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        logOutMenu.setIcon(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\logOutMenuIcon.jpg"));
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
                new MouseAdapter() {
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
        customersMenu.add(Box.createHorizontalStrut(200));
        customersMenu.add(addCustomerMenuItem);
        customersMenu.addSeparator();
        customersMenu.add(manageCustomersMenuItem);
        customersMenu.add(viewCustomerDetailsMenuItem);
        stockMenu.add(Box.createHorizontalStrut(200));
        stockMenu.add(addnewItemMenuItem);
        stockMenu.add(manageItemMenuItem);
        stockMenu.add(addNewDrugItemCategoryMenu);
        stockMenu.add(purchaseViewMenuItem);

        expensesMenu.add(Box.createHorizontalStrut(200));
        expensesMenu.add(expensesViewMenuItem);
        expensesMenu.add(addNewExpenseMenuItem);
        returnsMenu.add(Box.createHorizontalStrut(200));
        returnsMenu.add(viewReturnedGoodsMenuItem);
        returnsMenu.add(enterReturnedGoodsMenuItem);
        itemsMenu.add(Box.createHorizontalStrut(200));
        itemsMenu.add(addnewItemMenuItem);
        itemsMenu.add(manageItemMenuItem);
        itemsMenu.add(itemsListMenuItem);
        itemsMenu.addSeparator();
        itemsMenu.add(categoriesMenuItem);
        //menuBar.add(Box.createVerticalStrut(100));
        logOutMenu.add(Box.createHorizontalStrut(200));
        //PrepareMenuItems --> HelpMenu
        contentsMenuItem = new JMenuItem("Contents");
        feedBackmenuItem = new JMenuItem("FeedBack");
        deactivateMenuItem = new JMenuItem("Deactivate");
        aboutMenuItem = new JMenuItem("About");
        reportsMainViewMenu.add(Box.createHorizontalStrut(200));

        helpMenu.add(Box.createHorizontalStrut(200));
        helpMenu.add(contentsMenuItem);
        helpMenu.add(feedBackmenuItem);
        helpMenu.add(deactivateMenuItem);
        helpMenu.add(aboutMenuItem);
        contentsMenuItem.setEnabled(false);
        feedBackmenuItem.setEnabled(false);
        deactivateMenuItem.setEnabled(false);
        aboutMenuItem.setEnabled(false);
        //add menu Items to  ViewMenu
        //add menu Items to File Menu

        fileMenu.add(Box.createHorizontalStrut(200));
        fileMenu.add(makeANewSaleMenuItem);
        fileMenu.add(settingsMenuitem);
        fileMenu.add(addUsersmenuitem);
        fileMenu.add(newNoticeMenuItem);
        fileMenu.add(newEmployeeMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(new JMenuItem("View Employees"));
        fileMenu.add(new JMenuItem("View Users"));
        fileMenu.add(new JMenuItem("View Recent Memos"));
        fileMenu.addSeparator();
        fileMenu.addSeparator();
        fileMenu.add(Box.createVerticalStrut(30));
        fileMenu.add(exitMenuItem);
        //salesMenu -->items
        salesMenu.add(Box.createHorizontalStrut(200));
        salesMenu.add(salesReportsByCategory);
        //PrepareMenuItems --> InventoryMenu
        stockMenu.add(addnewItemMenuItem);
        stockMenu.add(manageItemMenuItem);
        stockMenu.add(new JMenuItem("View Existing Item Categories"));
        //add menu Items to Inventory Menu
        //Set Accelerators for Action Menu MenuItems
        viewReturnedGoodsMenuItem.addActionListener(e -> {
            viewReturnsInterface.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(viewReturnsInterface);
                });
        addNewDrugItemCategoryMenu.addActionListener(e -> new AddNewCategoryDialogBox(true));
        enterReturnedGoodsMenuItem.addActionListener(e -> new StoreReturnsTracking(true));
        addNewExpenseMenuItem.addActionListener(e -> new StoreExpensesTracking(true));
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        exitMenuItem.addActionListener(e -> {
            //Check if a sale is open or not
            if (!(saleTableModel.getRowCount() == 0)) {
                JOptionPane.showMessageDialog(null, "Unable To Close\nPlease Print Pending Receipt.", "Alpha Pharmacy iPOS", JOptionPane.ERROR_MESSAGE);
            } else if (saleTableModel.getRowCount() == 0) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit ?", "Alpha Pharmacy POS", JOptionPane.YES_NO_CANCEL_OPTION);
                switch (option) {
                    case JOptionPane.YES_OPTION:
                        List<JMenu> menues = Arrays.asList(editMenu, customersMenu, suppliersMenu, salesMenu, fileMenu, helpMenu, itemsMenu, stockMenu, customersMenu);
                        disableAllMenues(menues);
                        JPanel greyExitpanel = new JPanel();
                        greyExitpanel.setBackground(Color.red);
                        greyExitpanel.add(backgroundImageLabel);
                        replaceRightComponentOnSplitPane(greyExitpanel);
                        try {
                            JOptionPane.showMessageDialog(null, "System is Exiting...");
                            setCursor(new Cursor(Cursor.WAIT_CURSOR));
                            Thread.sleep(9000);
                            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            System.exit(0);
                        } catch (InterruptedException ex) {
                            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }

                        break;
                    case JOptionPane.NO_OPTION:
                        try {
                            setCursor(new Cursor(Cursor.WAIT_CURSOR));
                            Thread.sleep(1500);
                            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        } catch (InterruptedException ex) {
                            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        break;
                    default:
                        break;
                }
            }
        });

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
        salesMenu.add(makeANewSaleMenuItem);
        salesMenu.add(salesReportsByCategory);
        //add menues to Menu bar
        changeCursorTypesForMenues(suppliersMenu);
        changeCursorTypesForMenues(helpMenu);
        changeCursorTypesForMenues(stockMenu);
        changeCursorTypesForMenues(expensesMenu);
        changeCursorTypesForMenues(returnsMenu);
        changeCursorTypesForMenues(fileMenu);
        changeCursorTypesForMenues(editMenu);
        changeCursorTypesForMenues(salesMenu);
        changeCursorTypesForMenues(stockMenu);
        changeCursorTypesForMenues(customersMenu);
        changeCursorTypesForMenues(logOutMenu);
        changeCursorTypesForMenues(reportsMainViewMenu);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(salesMenu);
        menuBar.add(stockMenu);
        menuBar.add(expensesMenu);
        menuBar.add(customersMenu);
        menuBar.add(returnsMenu);
        logOutMenu.add(logOutMenuItem);
        logOutMenu.addSeparator();
        logOutMenu.add(clockInClockOutMenuItem);
        /*reportsMainViewMenu.add(new JMenuItem("Sales"));
         reportsMainViewMenu.add(new JMenuItem("Stock"));
         reportsMainViewMenu.add(new JMenuItem("Suppliers"));
         reportsMainViewMenu.add(new JMenuItem("Customers"));
         reportsMainViewMenu.add(new JMenuItem("Employees"));
         reportsMainViewMenu.add(new JMenuItem("Expenses"));
         reportsMainViewMenu.add(new JMenuItem("Returns"));
         reportsMainViewMenu.add(new JMenuItem("Overall DashBoard"));*/
        suppliersMenu.add(Box.createHorizontalStrut(200));
        suppliersMenu.add(viewSuppliers);
        suppliersMenu.add(supplyTransactionsMenuItems);
        /*suppliersMenu.add(new JMenuItem("Add New Supplier"));
         suppliersMenu.add(new JMenuItem("Pay Supply Debt"));
         suppliersMenu.add(new JMenuItem("View Payment Status"));*/
        menuBar.add(suppliersMenu);
       // menuBar.add(reportsMainViewMenu);
        menuBar.add(helpMenu);
        menuBar.add(helpMenu);
        menuBar.add(Box.createHorizontalStrut(350));
        menuBar.add(logOutMenu);
        inventoryViewPanel.setBackground(Color.WHITE);
        menuBar.add(Box.createVerticalStrut(50));
        menuBar.setBackground(Color.decode("#1E90FF"));
        ordersViewPanel.setBackground(Color.WHITE);
        clockInAndOutViewPanel.setBackground(Color.WHITE);
        clockInAndOutViewPanel.add(backgroundImageLabel);
        splitPane.setRightComponent(clockInAndOutViewPanel);
        splitPane.getLeftComponent().setBackground(Color.WHITE);
        logOutMenuItem.addActionListener((ActionEvent event) -> {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to Log Out ?", "Alpha POS", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (option) {
                case JOptionPane.YES_OPTION:
                    //display log in
                    setVisible(false);
                    new LogInAndAuthentication(true);
                    break;
                case JOptionPane.NO_OPTION:
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
                default:
                    break;
            }
        });

        supplyTransactionsMenuItems.addActionListener(e -> {
            SupplyTransactionsInformatiionView supplyTransactionsInformatiionView = new SupplyTransactionsInformatiionView();
            supplyTransactionsInformatiionView.paySupplierButton.setEnabled(false);
            supplyTransactionsInformatiionView.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(supplyTransactionsInformatiionView);

        });

        manageItemMenuItem.addActionListener(e -> {
            DrugInventoryTransactions.removeZeroQtyItemsFromStock();
            retrieveTableData("SELECT ID,name,purchasePrice,qty,sellPrice,Category,timeRemaining,Status,Details FROM drugs;", stockTabelModel, "stocks Table", "drugs");
            inventoryTotalLabel.setText("Total:" + stockTabelModel.getRowCount() + "  Records Found");
            splitPane.remove(splitPane.getRightComponent());
            inventoryViewPanel.add(backgroundImageLabel);
            splitPane.setRightComponent(inventoryViewPanel);
            repaint();
        });
        addnewItemMenuItem.addActionListener(e -> new EditItemsDetailsFrame(true));
        viewSuppliers.addActionListener(e -> {
            retrieveTableData("SELECT * FROM suppliers;", suppliersModel, "Suppliers Table", "suppliers");
            suppliersPatientTotalLabel.setText("Total: " + suppliersModel.getRowCount() + "  Records Found");
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            suppliersInfoViewPanel.setBackground(Color.WHITE);
            suppliersInfoViewPanel.add(backgroundImageLabel);
            splitPane.setRightComponent(suppliersInfoViewPanel);
        });
        // inveicePanel
        salesReportsByCategory.addActionListener(e -> {
            retrieveTableData("SELECT * FROM salesInvoice;", invoiceTableModel, "Inventory Table", "salesinvoice");
            statementLineOneLabel.setText("Total: " + invoiceTableModel.getRowCount() + "  Records  Found");
            statementLineFourLabel.setText("Total Profit =" + drugInventoryTransactions.getTotalprofitFromSales());
            statementLineTwoLabel.setText("Total Sales = " + drugInventoryTransactions.getTotalSales());
            statementLineOneLabel.setText("Total: " + invoiceTableModel.getRowCount() + "  Records  Found");
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            inveicePanel.setBackground(Color.WHITE);
            inveicePanel.add(backgroundImageLabel);
            splitPane.setRightComponent(inveicePanel);
        });
        viewCustomerDetailsMenuItem.addActionListener(e -> {
            replaceRightComponentOnSplitPane(new CRMView());
                });

        /*selectItemsCombo = new JComboBox<>(drugInventoryTransactions.getDrugNamesList("Other"));
         selectItemsCombo.setBounds(720, 25, 200, 40);
         processPayMentsViewPanel.add(selectItemsCombo);*/
        //Replce Right split pane views
        newNoticeMenuItem.addActionListener(event -> {
            addNewTaskPanel.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(addNewTaskPanel);
                });
        taskMenuItem.addActionListener(event -> replaceRightComponentOnSplitPane(addNewTaskPanel));
        makeANewSaleMenuItem.addActionListener(event -> {

            selectCategoryCombo = new JComboBox<>(drugInventoryTransactions.getCategories());
            selectCategoryCombo.setBounds(510, 25, 200, 40);
            processPayMentsViewPanel.add(selectCategoryCombo);
            selectCategoryCombo.setSelectedItem("Painkiller");
            selectItemsCombo = new JComboBox<>(drugInventoryTransactions.getDrugNamesList(selectCategoryCombo.getSelectedItem().toString()));
            selectItemsCombo.setBounds(720, 25, 200, 40);
            categoriesComboBoxEvents();
            processPayMentsViewPanel.add(selectItemsCombo);
            repaint();
            
            replaceRightComponentOnSplitPane(processPayMentsViewPanel);
        });
        //DISPLLAY PURCHASES
        purchaseViewMenuItem.addActionListener(e -> {
            
            replaceRightComponentOnSplitPane(new PurchasesView());
                });

        itemsListMenuItem.addActionListener(event -> {
            itemsManagementPanel.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(itemsManagementPanel);
                });
        clockInClockOutMenuItem.addActionListener(event -> {
            splitPane.remove(splitPane.getRightComponent());
            repaint();
            pharmacyNameLabel.setText(companyInformation.getCompanyInformation().get("name"));
            companyFooterLabel.setText(companyInformation.getCompanyInformation().get("footer"));
            clockInAndOutViewPanel.setBackground(Color.white);
            clockInAndOutViewPanel.add(backgroundImageLabel);
            splitPane.setRightComponent(clockInAndOutViewPanel);
        });
        manageUserMenuItem.addActionListener(event -> {
            viewUserPanel.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(viewUserPanel);
                });
        newUserMenuItem.addActionListener(event -> {
            addNewUserPanelView.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(addNewUserPanelView);
        });
        addUsersmenuitem.addActionListener(event -> {
            addNewUserPanelView.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(addNewUserPanelView);
        });
        manageCustomersMenuItem.addActionListener(event -> {
            retrieveTableData("SELECT * FROM customers;", customerModel, "Customers Table", "Customers");
            customerPatientTotalLabel = new JLabel("Total:" + customerModel.getRowCount() + " Records Found");
            customerPatientTotalLabel.setBounds(450, 2, 200, 30);
            customerpatientTableOnlypanel.add(customerPatientTotalLabel);
            viewCustomerInformationDetailsView.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(viewCustomerInformationDetailsView);
        });

        inventorySortMethodCombo.addActionListener(e -> {
            retrievedNaturalySortedTableData(inventorySortMethodCombo.getSelectedItem().toString(), ascendingDescendingCombo.getSelectedItem().toString(), stockTabelModel, "stocks Table", "drugs");
            inventoryTotalLabel.setText("Total:" + stockTabelModel.getRowCount() + "  Records Found");
            repaint();
        });
        ascendingDescendingCombo.addActionListener(e -> {
            retrievedNaturalySortedTableData(inventorySortMethodCombo.getSelectedItem().toString(), ascendingDescendingCombo.getSelectedItem().toString(), stockTabelModel, "stocks Table", "drugs");
            inventoryTotalLabel.setText("Total:" + stockTabelModel.getRowCount() + "  Records Found");
            repaint();
        });
        finalSortButton.addActionListener(e
                -> {

                    retrievedNaturalySortedTableData(inventorySortMethodCombo.getSelectedItem().toString(), ascendingDescendingCombo.getSelectedItem().toString(), stockTabelModel, "stocks Table", "drugs");
                    inventoryTotalLabel.setText("Total:" + stockTabelModel.getRowCount() + "  Records Found");
                    repaint();

                });
        patientsAdminButton.addActionListener(event -> {
            retrieveTableData("SELECT * FROM customers;", customerModel, "Customers Table", "Customers");
            customerPatientTotalLabel = new JLabel("Total:" + customerModel.getRowCount() + " Records Found");
            customerPatientTotalLabel.setBounds(450, 2, 200, 30);
            viewCustomerInformationDetailsView.add(backgroundImageLabel);
            customerpatientTableOnlypanel.add(customerPatientTotalLabel);
            replaceRightComponentOnSplitPane(viewCustomerInformationDetailsView);
        });
        settingsMenuitem.addActionListener(event -> {
            settingsPanel.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(settingsPanel);
        });
        inventoryMenuItem.addActionListener(event -> {
            inventoryViewPanel.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(inventoryViewPanel);
        });
        printNotificationMenuItem.addActionListener(event -> {
            addNewTaskPanel.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(addNewTaskPanel);
        });
        newEmployeeMenuItem.addActionListener(event -> {
            addNewEmplyeeViewPanel.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(addNewEmplyeeViewPanel);
        });
        invoiceMenuItem.addActionListener(event -> {
            inveicePanel.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(inveicePanel);
        });
        addCustomerMenuItem.addActionListener(event -> {
            addNewPatientCustomerViewPanel.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(addNewPatientCustomerViewPanel);
        });
        //print reports
        inventoryViewsaddNewItemButton.addActionListener(event -> {
            new EditItemsDetailsFrame(true);
        });
        expensesViewMenuItem.addActionListener(e -> {
            getExpenseDataFromDB();
            expenseTotalLabel.setText("Total: " + expensesTableModel.getRowCount() + " Records Found");
            expensesViewMainPanel.add(backgroundImageLabel);
            replaceRightComponentOnSplitPane(expensesViewMainPanel);
            expenseTotalLabel.setText("Total:" + expensesTableModel.getRowCount() + "  Records Found");
            repaint();

        });
        inventoryPrintButton.addActionListener(event -> printJTable(inventoryItemsTable, "Inventory Report"));

        addItemToSalesButton.addActionListener(e -> {

            if (drugInventoryTransactions.reduceDrugQtyFromStock(drugInventoryTransactions.getAvailabelDrugQty(selectItemsCombo.getSelectedItem().toString()), new Integer(selectQtySpinner.getValue().toString()), selectItemsCombo.getSelectedItem().toString()) == true) {
                String discount = assignDiscountSpinner.getValue().toString();
                Double price = new Double(productSalesTransactions.getItemPrice(selectItemsCombo.getSelectedItem().toString()));
                Integer qty = new Integer(selectQtySpinner.getValue().toString());
                Double total = getValueAfterDiscount(price, discount + ".00") * qty;
                //Add Consolidated Sale data to sales Invoice Table
                DrugInventoryTransactions.addParticularSaleData(selectItemsCombo.getSelectedItem().toString(), selectQtySpinner.getValue().toString(), productSalesTransactions.getItemPrice("23"), total.toString());

                itemPrice = new Double(drugInventoryTransactions.getItemSellingPrice(selectItemsCombo.getSelectedItem().toString()));
                Double quty = new Double(selectQtySpinner.getValue().toString());
                itemPrice = getValueAfterDiscount(itemPrice, discount + ".00") * quty;
                itemPrice += new Double(amountDueField.getText());
                amountDueField.setText(itemPrice.toString());
                try {
                    if (getChange(new Double(amountPaidField.getText()), new Double(amountDueField.getText())) > 0) {
                        changeField.setText("" + getChange(new Double(amountPaidField.getText()), new Double(amountDueField.getText())));
                    } else {
                        changeField.setText("0.00");
                    }
                } catch (NumberFormatException ex) {
                }

                Double netAmounts = (new Double(amountPaidField.getText()) - new Double(changeField.getText()));
                totalNetField.setText("" + netAmounts);
                //get purchase price per piece
                Double purchasePricePerPice = new Double(drugInventoryTransactions.getItemPurchasePricePerPiece(selectItemsCombo.getSelectedItem().toString()));
                //Get profit
                Double profit = itemPrice - (purchasePricePerPice * quty);
                drugInventoryTransactions.insertTransactionIntoInvoiceTable("3456", selectItemsCombo.getSelectedItem().toString(), selectQtySpinner.getValue().toString(), total.toString(), profit.toString(), payModeComboBox.getSelectedItem().toString(), amountReceivedWindow.getText(), changeField.getText(), "Admin");
                saleTableModel.fireTableDataChanged();
            }
        });
        todaysSalesButton.addActionListener(e -> {
            getTodaySales();
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

        //set pay buttons props
        List<JButton> payButtons = Arrays.asList(
                payOneButton, payTwoButton, payThreeButton, fourButtonPay, fiveButtonPay,
                sixButtonPay, sevenButtonPay, eightButtonPay, nineButtonPay
        );
        List<JComponent> componentsReverse = Arrays.asList(
                zeroButtonPay
        );
        getColorSwitchBackgroundEffect(componentsReverse, "#1E90FF", "#00BFF");
        List<JComponent> components = Arrays.asList(
                clockInButton
        );
        getColorSwitchBackgroundEffect(components, "#00BFF", "#1E90FF");
        setPayButtonsProperties(payButtons);
        //Tables in this file
        List<JTable> viewTables = Arrays.asList(
                inventoryTable, expenseTable, suppliersPatientTable, customerPatientTable, itemsPaymentTablePay, inventoryItemsTable
        );

        UIDefaults defaults = UIManager.getDefaults();
        if (defaults.get("Table.alternateRowColor") == null) {
            defaults.put("Table.alternateRowColor", Color.decode("#F5F5F5"));
        }

        List<JComponent> foregroundChangeComponentsz = Arrays.asList(
                patientsAddPrescriptionDetailsButton, finalSortButton, sortButton, inventorySortByButton, empSortByButton, suppliersSortByButton, sortExpensesByButton, customerPatientSortByButton, newEmployeebrowseForImageButton, generateSaleReportsByDateButton, inventorySortByButton, sortButton, patientsUpdateInfoButton, addtaskButton, last30DaysReportsButton, addItemToSalesButton, customerPatientSortByButton, sortExpensesByButton, suppliersSortByButton, printButtonPay, patientsUpdateUserDetailsButton, newEmployeeupdateUserDetailsButton, updateUserDetailsButton, updateSettingButton, addMoreCashButton
        );
        List<JComponent> redComponents = Arrays.asList(
                clockOutButton, clearFieldButtonPay, clearClockInClockOutButton, posSettingsButton,
                patientsUpdateInfoButton, patientsAdminButton, newEmployeeadminButton, newEmployeeupdateInfoButton,
                updateInfooButton, adminButton, patientsUpdateInfoButton, patientsAdminButton, closeButtonPay,
                deleteButtonPay, inventoryPrintButton, printButton, employeeDataPrintButton,
                suppliersPrintButton, printExpensesButton, patientCustomerPrintButton
        );
        getColorSwitchBackgroundEffect(redComponents, "#FF0000", "#B22222");
        getColorSwitchBackgroundEffect(foregroundChangeComponentsz, "#0BFF", "#1E90FF");
        setTableProperties(viewTables);

        getContentPane().add(splitPane);
        setJMenuBar(menuBar);
        repaint();
        setVisible(visible);
        DrugInventoryTransactions.removeZeroQtyItemsFromStock();
    }

    public final void connectToDatabase() {
        try {
            //Load Driver
            Class.forName("com.mysql.jdbc.Driver");
            //make connection
            globalDatabaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppos", "root", "");
            //create statement
            globalSqlStatementObject = globalDatabaseConnection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "DB ERROR CODE 2972" + e.getMessage());
        }
    }

    public static final void onClickBlueBorder(final JComponent componentObject) {
        //Mouse Listener
        componentObject.addMouseListener(
                new MouseAdapter() {
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
                }
        );
    }

    //Check if field is verified before chnaging border color
    public void secondLevelTextFieldsVerification(final JComponent componentObject) {
        //Verify entered text when field looses focus
        if (componentObject instanceof JTextField) {
            String text = ((JTextField) componentObject).getText();
            if (!InputVerification.verifyTextOnlyFields(text)) {
                componentObject.setBorder(new LineBorder(Color.red));
            } else {
                componentObject.setBorder(new LineBorder(Color.decode("#1E90FF"), 2));
            }
        }
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
                new MouseAdapter() {
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
                }
        );
    }

    public final void updateTextArea(final JButton ValueButton) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ValueButton.addActionListener(event -> {
                ClockInClockOutEmployeeIDField.append(ValueButton.getText());
            });
        });

    }

    public void getSalesByDate(LocalDate startDate, LocalDate endDate) {

        try {
            int row = invoiceTableModel.getRowCount();
            while (row > 0) {
                row--;
                invoiceTableModel.removeRow(row);
            }

            ResultSet resultSet = globalSqlStatementObject.executeQuery("SELECT * FROM salesInvoice WHERE saleDate BETWEEN('" + startDate.toString() + "') AND ('" + endDate.toString() + "')");
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
            JOptionPane.showMessageDialog(null, "Unable to Obtain Sales Report Data:[" + e.getMessage() + "]");
        }
    }

    public void getTodaySales() {
        try {
            int row = invoiceTableModel.getRowCount();
            while (row > 0) {
                row--;
                invoiceTableModel.removeRow(row);
            }

            ResultSet resultSet = globalSqlStatementObject.executeQuery("SELECT * FROM salesInvoice WHERE saleDate IN('" + LocalDate.now() + "');");
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
            JOptionPane.showMessageDialog(null, "Unable to Obtain Sales Report Data:[" + e.getMessage() + "]");
        }
    }

    public final void replaceRightComponentOnSplitPane(JPanel newReplaceablePanel) {

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
            ResultSet resultSet = globalSqlStatementObject.executeQuery("SELECT * FROM salesInvoice WHERE saleDate BETWEEN('" + llastMonth + "') AND ('" + LocalDate.now().toString() + "');");
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
            JOptionPane.showMessageDialog(null, "Unable to Obtain Sales Report Data:[" + e.getMessage() + "]");
        }
    }

    public void printJTable(JTable currentTableObject, String tableHeader) {

        try {
            currentTableObject.print(JTable.PrintMode.FIT_WIDTH, new MessageFormat(tableHeader), new MessageFormat(printDate + "  " + companyInformation.getCompanyInformation().get("name")));
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(null, "Unable To print:" + e.getMessage());
        }
    }

    /**
     * Control the type of Cursor that appears when the mouse hovers over menu
     * Items.
     *
     * @param menueObject
     */
    public final void changeCursorTypesForMenues(final JMenu menueObject) {
        menueObject.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseExited(MouseEvent event) {

                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }

                    @Override
                    public void mouseEntered(MouseEvent event) {
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                }
        );
    }

    /**
     *
     * @param sortCategory
     * @param tableModel
     * @param tableName
     * @param databaseTableName Retrieves database values for this particular
     * table model for The relevant JTable
     */
    public static final void retrievedNaturalySortedTableData(String sortCategory, String ascdesc, DefaultTableModel tableModel, String tableName, String databaseTableName) {
        try {
            int row = tableModel.getRowCount();
            while (row > 0) {
                row--;
                tableModel.removeRow(row);
            }
            try {
                //Execute query
                ResultSet sortDataResults = globalSqlStatementObject.executeQuery("SELECT * FROM  " + databaseTableName + " ORDER BY " + sortCategory + " " + ascdesc + ";");
                //get metadata
                ResultSetMetaData resultSetMetaData = sortDataResults.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();

                Object[] data = new Object[columnCount];
                while (sortDataResults.next()) {

                    for (int i = 1; i <= columnCount; i++) {
                        data[i - 1] = sortDataResults.getString(i);
                    }
                    tableModel.addRow(data);
                }

            } catch (NullPointerException e) {
                //do nothing
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to Retrieve " + tableName + " Information \n[" + e.getMessage());
        }
    }

    public final void retrieveTableData(String queryString, DefaultTableModel tableModel, String tableName, String databaseTableName) {
        try {
            int row = tableModel.getRowCount();
            while (row > 0) {
                row--;
                tableModel.removeRow(row);
            }
            //Execute query
            ResultSet ineventoryResults = globalSqlStatementObject.executeQuery(queryString);

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

        columnNames.stream().forEach(columnName -> defaultTableModel.addColumn(columnName));
    }

    public void makeFieldForegroundBlack(JTextField textField) {
        textField.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        textField.setForeground(Color.BLACK);
                        setCursor(new Cursor(Cursor.TEXT_CURSOR));
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        textField.setForeground(Color.BLACK);
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        textField.setForeground(Color.BLACK);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        textField.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
        );
    }

    public final void addTextAreaKeyListenerEvents(JTextArea textArea) {
        textArea.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        textArea.setForeground(Color.decode("#1E90FF"));
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        textArea.setForeground(Color.decode("#1E90FF"));
                    }
                }
        );
    }

    public void categoriesComboBoxEvents() {

        selectCategoryCombo.addActionListener(e -> {
            if (selectItemsCombo.getItemCount() > 0) {
                //processPayMentsViewPanel.remove(selectItemsCombo);
                selectItemsCombo.removeAllItems();
                Stream.of(drugInventoryTransactions.getDrugNamesList(selectCategoryCombo.getSelectedItem().toString()))
                        .forEach(drugName -> selectItemsCombo.addItem(drugName));

                repaint();
            } else if (selectItemsCombo.getItemCount() <= 0) {
                /*selectItemsCombo = new JComboBox<>(drugInventoryTransactions.getDrugNamesList(selectCategoryCombo.getSelectedItem().toString()));
                 selectItemsCombo.setBounds(720, 25, 200, 40);
                
                 processPayMentsViewPanel.add(selectItemsCombo);*/
                Stream.of(drugInventoryTransactions.getDrugNamesList(selectCategoryCombo.getSelectedItem().toString()))
                        .forEach(drugName -> selectItemsCombo.addItem(drugName));
                repaint();
            }
        });
    }

    public void makeFieldsBlank(List<JTextComponent> textFields) {
        textFields.stream()
                .forEach(e -> e.setText(""));
    }

    public void disableAllMenues(List<JMenu> applicationMenues) {
        applicationMenues.stream().forEach(e -> e.setEnabled(false));
    }

    public Double getValueAfterDiscount(Double ItemPrice, String discount) {

        Double AmtAfterDiscount;
        AmtAfterDiscount = ItemPrice - new Double(discount);
        return AmtAfterDiscount;

    }

    public void getConnection() {
        try {
            //Load Driver
            Class.forName("com.mysql.jdbc.Driver");
            //make connection
            globalDatabaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppos", "root", "");
            //create statement
            globalSqlStatementObject = globalDatabaseConnection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "DB ERROR CODE 2972" + e.getMessage());
        }
    }

    public void getExpenseDataFromDB() {
        try {
            int row = expensesTableModel.getRowCount();
            while (row > 0) {
                row--;
                expensesTableModel.removeRow(row);
            }
            ResultSet resultSet = globalSqlStatementObject.executeQuery("SELECT * FROM companyExpenses");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            Integer columnCount = resultSetMetaData.getColumnCount();
            Object[] data = new Object[columnCount];
            while (resultSet.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    data[i - 1] = resultSet.getObject(i);
                }
                expensesTableModel.addRow(data);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to Obtain Expense Report Data:[" + e.getMessage() + "]");
        }
    }

    public void getExpensesColumnNames(List<String> columnNames) {
        columnNames.stream().forEach(e -> expensesTableModel.addColumn(e));
    }

    //add Fileds Focus Listeners
    public static final void addFieldsFocusListener(final JComponent componentObject) {
        componentObject.addFocusListener(
                new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent event) {
                        componentObject.setBorder(new LineBorder(Color.BLUE, 2));
                    }

                    @Override
                    public void focusLost(FocusEvent event) {
                        componentObject.setBorder(new LineBorder(Color.black, 1));
                    }
                }
        );
    }

    //Animate grey panels
    public final void animateGreypanels(final JPanel panelObject) {
        panelObject.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseEntered(MouseEvent event) {
                        panelObject.setBackground(Color.gray);
                    }

                    @Override
                    public void mouseExited(MouseEvent event) {
                        panelObject.setBackground(Color.lightGray);
                    }

                    @Override
                    public void mousePressed(MouseEvent event) {
                        panelObject.setBackground(Color.gray);
                    }

                    @Override
                    public void mouseReleased(MouseEvent event) {
                        panelObject.setBackground(Color.lightGray);
                    }

                    @Override
                    public void mouseClicked(MouseEvent event) {
                        panelObject.setBackground(Color.gray);
                    }
                }
        );
    }

    public final void validateFields(List<JTextComponent> textComponent, Predicate<Object> predicate) {

        List<JTextComponent> invalidTextFields = new ArrayList<>();

        textComponent.forEach(e -> {
            e.addKeyListener(
                    new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {

                            textComponent.stream().forEach((s) -> {
                                if (!predicate.test(s.getText())) {
                                    s.setBorder(new LineBorder(Color.red));
                                    s.addFocusListener(
                                            new FocusListener() {
                                                @Override
                                                public void focusGained(FocusEvent e) {
                                                    s.setBorder(new LineBorder(Color.red));
                                                }

                                                @Override
                                                public void focusLost(FocusEvent e) {
                                                    s.setBorder(new LineBorder(Color.red));
                                                }
                                            });

                                } else if (predicate.test(s.getText())) {
                                    s.setBorder(new LineBorder(Color.blue));
                                    invalidTextFields.remove(s);

                                    s.addFocusListener(
                                            new FocusListener() {
                                                @Override
                                                public void focusGained(FocusEvent e) {
                                                    s.setBorder(new LineBorder(Color.decode("#1E90FF")));
                                                }

                                                @Override
                                                public void focusLost(FocusEvent e) {
                                                    s.setBorder(new LineBorder(Color.decode("#1E90FF")));
                                                }

                                            }
                                    );
                                }
                            });

                        }

                    }
            );
        });

    }

    public final Boolean checkIfFieldsAreBlank(List<JTextComponent> allFields) {

        Boolean allCheckedOut = false;
        List<JTextComponent> blankFields = allFields.stream()
                .filter(e -> e.getText().isEmpty() || e.getText().startsWith(" "))
                .collect(toList());
        if (blankFields.isEmpty()) {
            System.err.println("no blanks");
            allCheckedOut = true;
        } else if (!blankFields.isEmpty()) {
            blankFields.forEach(e -> e.setBorder(new LineBorder(Color.red)));
            System.err.println("Blanks");
            allCheckedOut = false;
        }

        return allCheckedOut;
    }

    public final Boolean levelTwoTextFieldsValidation(List<JTextComponent> textFields, Predicate<Object> predicate) {
        Boolean isAllFieldsValid = false;
        List<JTextComponent> invalidFields
                = textFields.stream()
                .filter(e -> !predicate.test(e.getText()))
                .collect(toList());

        if (invalidFields.isEmpty()) {
            isAllFieldsValid = true;
        } else if (!invalidFields.isEmpty()) {
            isAllFieldsValid = false;
            invalidFields.stream()
                    .forEach(e -> e.setBorder(new LineBorder(Color.red)));
        }
        return isAllFieldsValid;
    }

    public static void retrieveDataBySearch(String searchQuery, DefaultTableModel tableModel, String tableName) {
        try {
            int row = tableModel.getRowCount();
            while (row > 0) {
                row--;
                tableModel.removeRow(row);
            }
            //Execute query
            ResultSet ineventoryResults = globalSqlStatementObject.executeQuery(searchQuery);

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

    //set table  view properties
    public static final void setTableProperties(List<JTable> tables) {
        tables.forEach(table -> {
            table.setForeground(Color.decode("#708090"));
            table.setSelectionBackground(Color.decode("#1E90FF"));
            table.setSelectionForeground(Color.WHITE);
            table.setFillsViewportHeight(true);
            table.setShowHorizontalLines(false);
            table.setShowVerticalLines(false);
            table.setRowHeight(30);
            table.setFont(new Font("Calibri", Font.BOLD, 13));
        });
    }

    public static final void getColorSwitchBackgroundEffect(List<JComponent> swingComponentObjects, String colorCodeA, String colorCodeB) {

        swingComponentObjects.stream()
                .forEach((JComponent jComponent) -> {
                    jComponent.addMouseListener(
                            new MouseAdapter() {
                                @Override
                                public void mouseEntered(MouseEvent e) {
                                    jComponent.setBackground(Color.decode(colorCodeA));
                                }

                                @Override
                                public void mouseExited(MouseEvent e) {
                                    jComponent.setBackground(Color.decode(colorCodeB));
                                }
                            }
                    );
                });
    }

    protected final void setPayButtonsProperties(List<JButton> buttons) {
        buttons.stream()
                .forEach(button -> {
                    button.setBorder(new LineBorder(Color.decode("#193688"), 4, true));
                    button.setFont(new Font("STENCIL", Font.BOLD, 40));
                    button.setBackground(Color.decode("#00BFF"));
                    button.setForeground(Color.WHITE);
                    payNumberButtonsPanel.add(button);
                    updatePayTextArea(button);
                    button.addMouseListener(
                            new MouseAdapter() {
                                @Override
                                public void mouseEntered(MouseEvent e) {
                                    button.setBackground(Color.decode("#1E90FF"));
                                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                                }

                                @Override
                                public void mouseExited(MouseEvent e) {
                                    button.setBackground(Color.decode("#00BFF"));
                                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                }
                            }
                    );
                });
    }

    public final void setClockInButtonsProperties(List<JButton> buttons) {
        buttons.stream().forEach(button -> {
            button.setBackground(Color.decode("#00BFF"));
            button.setBorder(new LineBorder(Color.decode("#F5F5F5"), 4, true));
            button.setFont(new Font("STENCIL", Font.BOLD, 30));
            button.setBackground(Color.decode("#00BFF"));
            button.setForeground(Color.WHITE);
            zeroToTenButtonsPanel.add(button);
            updateTextArea(button);
            button.addMouseListener(
                    new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            button.setBackground(Color.decode("#1E90FF"));
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            button.setBackground(Color.decode("#00BFF"));
                        }
                    }
            );
        });
    }

    public void setHandCursorComponents(List<JComponent> jComponents) {
        jComponents.stream()
                .forEach(component -> {
                    component.addMouseListener(
                            new MouseAdapter() {
                                @Override
                                public void mouseEntered(MouseEvent e) {
                                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                                }

                                @Override
                                public void mouseExited(MouseEvent e) {
                                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                                }
                            }
                    );
                });

    }

}
