/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package alpha;

import SystemSecurity.SHA1PasswordHashing;
import SystemSecurity.SessionIdDaos;
import SystemSecurity.UsersAuthentication;
import static alpha.MainPOSInterface.backgroundImageLabel;
import static alpha.MainPOSInterface.splitPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import managedocuments.CompanyInfoTransactions;
import managedocuments.StoreExpensesTracking;

public class SwitchAccountsPanel extends JPanel {

    /**
     *
     * @author samuel owino
     */
    private static JLabel bgImageLabel;
    private static JLabel userNameIconLabel;
    private static JLabel passwordIconLable;
    private static JPanel passwordPanel;
    private static JPanel userNamePanel;
    private Image backgroundImage;
    private static JLabel pharmacyNameLabel;
    private static JButton pharmacyLogOutButton;
    private static JLabel seecondStatementLabel;
    private static JLabel thirdStatementLabel;
    private static JLabel fourthStatementLabel;
    private static JLabel userImageLabelIcon;
    private static JTextField userNameField;
    private static JPasswordField passwordField;
    private static JButton signInButton;
    private static JLabel medicalIconLabel;
    private static JButton passwordRecoveryButton;
    private static JButton aboutButton;
    private static JLabel wrongPasswordorUserNameLabel;
    private static CompanyInfoTransactions companyInformation;

    public SwitchAccountsPanel() {

        setSize(1000, 650);
        setLocation(200, 50);
        setLayout(null);
        setBackground(Color.WHITE);

        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\Wallpapers 1280x800_2.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(LogInScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        bgImageLabel = new JLabel(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\Wallpapers 1280x800.jpg"));
        bgImageLabel.setBounds(0, 0, 1000, 650);
        wrongPasswordorUserNameLabel = new JLabel("Wrong Password");
        userNameIconLabel = new JLabel(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\personpng.png"));
        passwordIconLable = new JLabel(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\blue key.png"));
        userNamePanel = new JPanel(null);
        passwordPanel = new JPanel(null);
        userNamePanel.setBackground(Color.WHITE);
        userNamePanel.setBorder(new LineBorder(Color.decode("#808080")));
        pharmacyLogOutButton = new JButton(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\turn offpng.png"));
        pharmacyLogOutButton.setBackground(Color.WHITE);
        pharmacyLogOutButton.setBorder(new LineBorder(Color.WHITE));
        passwordRecoveryButton = new JButton("Forgot your password?");
        passwordRecoveryButton.setFont(new Font("", Font.ITALIC, 14));
        aboutButton = new JButton("About.");
        aboutButton.setFont(new Font("", Font.ITALIC, 14));
        signInButton = new JButton("Log in");
        passwordField = new JPasswordField("Password");
        userNameField = new JTextField("User Name");
        userImageLabelIcon = new JLabel(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\userProfileICon.PNG"));
        thirdStatementLabel = new JLabel("D.L No 72/DCA/21/DHS-2014");
        seecondStatementLabel = new JLabel("House # 105,Road # 3,Block F, Banani, Dhaka - 1213");
        pharmacyNameLabel = new JLabel("Goodnews Pharmacy");
        fourthStatementLabel = new JLabel("WholeSale and  Retail");
        medicalIconLabel = new JLabel(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\medicIcon.PNG"));
        seecondStatementLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        pharmacyNameLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        fourthStatementLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        thirdStatementLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        userNameField.setFont(new Font("New Times Roman", Font.ITALIC, 12));
        passwordRecoveryButton.setForeground(Color.decode("#1E90FF"));
        passwordRecoveryButton.setBackground(Color.WHITE);
        passwordRecoveryButton.setBorder(new LineBorder(Color.WHITE));
        passwordRecoveryButton.setFont(new Font("New Times Roman", Font.ITALIC, 12));
        aboutButton.setForeground(Color.WHITE);
        aboutButton.setBackground(Color.decode("#32CD32"));
        aboutButton.setFont(new Font("New Times Roman", Font.ITALIC, 12));
        userNameField.setBorder(new LineBorder(Color.WHITE));
        pharmacyLogOutButton.setToolTipText("Exit System");
        wrongPasswordorUserNameLabel.setForeground(Color.decode("#B22222"));
        wrongPasswordorUserNameLabel.setFont(new Font("New Times Roman", Font.ITALIC, 14));
        medicalIconLabel.setBounds(350, 5, 100, 50);
        pharmacyNameLabel.setBounds(452, 10, 300, 40);
        seecondStatementLabel.setBounds(330, 60, 600, 40);
        thirdStatementLabel.setBounds(380, 105, 600, 40);
        fourthStatementLabel.setBounds(410, 155, 600, 40);
        userImageLabelIcon.setBounds(185, 165, 600, 200);
        userNameField.setBounds(40, 2, 220, 27);
        userNamePanel.setBounds(350, 370, 265, 30);
        passwordField.setBounds(40, 2, 220, 27);
        passwordPanel.setBounds(350, 410, 265, 30);
        signInButton.setBounds(350, 460, 265, 50);
        passwordRecoveryButton.setBounds(350, 520, 180, 25);
        aboutButton.setBounds(532, 520, 80, 25);
        pharmacyLogOutButton.setBounds(900, 20, 25, 25);
        passwordIconLable.setBounds(0, 0, 40, 28);
        userNameIconLabel.setBounds(0, 0, 40, 28);
        wrongPasswordorUserNameLabel.setBounds(430, 330, 200, 20);
        passwordPanel.setBackground(Color.WHITE);
        passwordField.setBorder(new LineBorder(Color.WHITE));
        passwordPanel.setBorder(new LineBorder(Color.decode("#808080")));
        signInButton.setBackground(Color.decode("#1E90FF"));
        signInButton.setForeground(Color.WHITE);
        signInButton.setBorder(new LineBorder(Color.decode("#808080")));
        signInButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        userNamePanel.add(userNameField);
        passwordPanel.add(passwordField);
        passwordPanel.add(passwordIconLable);
        userNamePanel.add(userNameIconLabel);
        add(medicalIconLabel);
        add(pharmacyNameLabel);
        add(seecondStatementLabel);
        add(thirdStatementLabel);
        add(fourthStatementLabel);
        add(userImageLabelIcon);
        add(userNamePanel);
        add(passwordPanel);
        add(signInButton);
        add(passwordRecoveryButton);
        add(aboutButton);
        add(pharmacyLogOutButton);
        add(bgImageLabel);
        //  add(wrongPasswordorUserNameLabel);

        passwordField.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent event) {
                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent event) {
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                }
        );
        userNameField.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent event) {
                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent event) {
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                }
        );

        StoreExpensesTracking.getShiftingBackgroundEffect(signInButton, "#1E90FF", "#00BFF");

        pharmacyLogOutButton.addActionListener(e -> {
            setVisible(false);
            System.exit(0);
        });
        passwordField.addFocusListener(
                new FocusListener() {

                    @Override
                    public void focusGained(FocusEvent e) {
                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        passwordField.setText("");
                        passwordPanel.setBorder(new LineBorder(Color.decode("#1E90FF")));
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                        passwordPanel.setBorder(new LineBorder(Color.decode("#808080")));
                    }
                }
        );

        userNameField.addFocusListener(
                new FocusListener() {

                    @Override
                    public void focusGained(FocusEvent e) {
                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        userNamePanel.setBorder(new LineBorder(Color.decode("#1e90ff")));
                        if (userNameField.getText().equals("User Name")) {
                            userNameField.setText("");
                        } else {
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        userNamePanel.setBorder(new LineBorder(Color.decode("#808080")));
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                        if (userNameField.getText().equals("")) {
                            userNameField.setText("User Name");
                        } else {
                        }
                    }
                }
        );

        signInButton.addActionListener(e -> {

            try {

                String enteredPassword = String.valueOf(passwordField.getPassword());

                //compre paswords
                if (SHA1PasswordHashing.comparePasswords(UsersAuthentication.getUserPasswords().get(userNameField.getText()), SHA1PasswordHashing.hashPassword(enteredPassword)) == true) {
                    try {
                        setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        Thread.sleep(2000);
                        setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        Random random = new Random();

                        Integer randomValue = random.nextInt();
                        LocalTime logInTime = LocalTime.now();
                        LocalDate logInDate = LocalDate.now();
                        //register new sessio for this user
                        String sessionID = SHA1PasswordHashing.generateSessionIds(randomValue.toString());
                        SessionIdDaos.registerASession(userNameField.getText(), logInTime.toString() + "" + logInDate.toString(), sessionID);
                        SessionIdDaos.RecordCurrentRunningSesionInTemp(sessionID, logInTime.toString());
                        MainPOSInterface.splitPane.remove(MainPOSInterface.splitPane.getRightComponent());
                        pharmacyNameLabel.setText(companyInformation.getCompanyInformation().get("name"));
                        MainPOSInterface.companyFooterLabel.setText(companyInformation.getCompanyInformation().get("footer"));
                        MainPOSInterface.clockInAndOutViewPanel.setBackground(Color.white);
                        MainPOSInterface.clockInAndOutViewPanel.add(backgroundImageLabel);
                        MainPOSInterface.splitPane.setRightComponent(MainPOSInterface.clockInAndOutViewPanel);

                        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    } catch (InterruptedException exc) {
                        JOptionPane.showMessageDialog(null, "Authentication Error..\n"
                                + "Please try again later");
                    }
                } else if (SHA1PasswordHashing.comparePasswords(UsersAuthentication.getUserPasswords().get(userNameField.getText()), SHA1PasswordHashing.hashPassword((String.valueOf(passwordField.getPassword())))) == false) {
                    JOptionPane.showMessageDialog(null, "WRONG PASSWORD!!");
                }
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "WRONG USER NAME!!");
            }
        });

        repaint();
    }
}
