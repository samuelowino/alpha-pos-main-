/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package alpha;

/**
 *
 * @author samuel owino
 */
import SystemSecurity.SessionIdDaos;
import static alpha.MainPOSInterface.splitPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.*;
import javax.swing.border.LineBorder;

public class WindowsCloseDialogBox extends JDialog {

    private static JButton cancelButton;
    private static JLabel backgroundImageLabel;
    private static ButtonGroup buttonGroup;
    private static JButton homeMoveButton;
    private static JButton switchOffButton;
    private static JButton logOutButton;
    private static JCheckBox viewProfileCheckBox;
    private static JCheckBox viewHelpCheckBox;
    private static JCheckBox viewKeyBoardShortcutsCheckBox;
    private static JCheckBox changeAccountCheckBox;
    private static JButton goButton;
    private static JPanel windowCloseUIPlaceHolderPanel;
    private static JLabel alphaPharmacyPOS;
    private static JLabel adminIconLabel;
    private static JLabel loggedInUserLabel;

    public WindowsCloseDialogBox(Boolean visible) {
        super();
        setSize(700, 400);
        setLocation(250, 200);
        setResizable(false);
        setModal(true);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        cancelButton = new JButton("Cancel");
        backgroundImageLabel = new JLabel(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\Wallpapers 1280x800.jpg"));
        buttonGroup = new ButtonGroup();
        windowCloseUIPlaceHolderPanel = new JPanel(null);
        windowCloseUIPlaceHolderPanel.setBackground(Color.WHITE);
        alphaPharmacyPOS = new JLabel("Alpha Pharmacy POS");
        homeMoveButton = new JButton("Home");
        switchOffButton = new JButton("Close Application");
        logOutButton = new JButton("Log Out");
        viewProfileCheckBox = new JCheckBox("Profile");
        viewHelpCheckBox = new JCheckBox("Help");
        viewKeyBoardShortcutsCheckBox = new JCheckBox("KeyBoard Shotcuts");
        changeAccountCheckBox = new JCheckBox("Log In with another account");
        goButton = new JButton("Go");
        adminIconLabel = new JLabel(new ImageIcon("C:\\Users\\user\\NetBeansProjects\\PharmacyPOS\\src\\appimages\\personpng_1.png"));
        loggedInUserLabel = new JLabel("Admin");
        alphaPharmacyPOS.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 28));
        alphaPharmacyPOS.setForeground(Color.decode("#32CD32"));
        loggedInUserLabel.setForeground(Color.WHITE);
        loggedInUserLabel.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
        cancelButton.setBackground(Color.decode("#B22222"));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));

        buttonGroup.add(viewHelpCheckBox);
        buttonGroup.add(viewKeyBoardShortcutsCheckBox);
        buttonGroup.add(viewProfileCheckBox);
        buttonGroup.add(changeAccountCheckBox);

        homeMoveButton.setBounds(30, 10, 200, 50);
        switchOffButton.setBounds(30, 100, 200, 50);
        logOutButton.setBounds(30, 200, 200, 50);
        cancelButton.setBounds(30, 280, 200, 50);
        alphaPharmacyPOS.setBounds(270, 20, 400, 50);
        adminIconLabel.setBounds(300, 100, 25, 30);
        loggedInUserLabel.setBounds(330, 100, 100, 25);
        backgroundImageLabel.setBounds(0, 0, 700, 400);

        viewProfileCheckBox.setBounds(300, 130, 300, 30);
        viewHelpCheckBox.setBounds(300, 170, 300, 30);
        viewKeyBoardShortcutsCheckBox.setBounds(300, 210, 300, 30);
        changeAccountCheckBox.setBounds(300, 250, 300, 30);
        goButton.setBounds(500, 300, 100, 30);
        List<JCheckBox> comboBoxList = Arrays.asList(
                viewHelpCheckBox, viewHelpCheckBox, viewKeyBoardShortcutsCheckBox, changeAccountCheckBox, viewProfileCheckBox
        );
        setComboBoxFeatures(comboBoxList);
        List<JButton> buttons = Arrays.asList(
                homeMoveButton, switchOffButton, logOutButton, goButton
        );
        setButtonsProperties(buttons);

        homeMoveButton.addActionListener(e -> {
            setVisible(false);
            MainPOSInterface.splitPane.setRightComponent(new SystemHomeScreen());
        });

        cancelButton.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent event) {
                        cancelButton.setBackground(Color.white);
                        cancelButton.setForeground(Color.decode("#B22222"));
                        cancelButton.setBorder(new LineBorder(Color.decode("#B22222")));

                    }

                    @Override
                    public void mouseExited(MouseEvent event) {
                        cancelButton.setBackground(Color.decode("#B22222"));
                        cancelButton.setForeground(Color.white);
                    }

                    @Override
                    public void mouseClicked(MouseEvent event) {
                        cancelButton.setBackground(Color.WHITE);
                        cancelButton.setForeground(Color.decode("#B22222"));

                    }

                }
        );

        cancelButton.addActionListener(e -> {
            this.setVisible(false);
        });

        homeMoveButton.addActionListener(e -> {

            MainPOSInterface.splitPane.remove(MainPOSInterface.splitPane.getRightComponent());
            MainPOSInterface.splitPane.setRightComponent(new SwitchAccountsPanel());
            setVisible(false);
        });
        switchOffButton.addActionListener(e -> {

            LocalTime logoutTime = LocalTime.now();
            try {
                LocalTime logInTime = LocalTime.parse(SessionIdDaos.getLogInTime());
                Duration maturityTime = Duration.between(logInTime, logoutTime);
                SessionIdDaos.terminateASession(logoutTime.toString(), maturityTime.toString(), SessionIdDaos.getCurrentSessionID());
                SessionIdDaos.deleteCurrentSession();
                System.exit(0);
            } catch (java.time.format.DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Session Logging Error. "
                        + "This session has already been terminated.",
                        "Alpha Pharmacy POS", JOptionPane.ERROR_MESSAGE);
            }

        });
        logOutButton.addActionListener(e -> {
            LocalTime logoutTime = LocalTime.now();
            LocalTime logInTime = LocalTime.parse(SessionIdDaos.getLogInTime());
            Duration maturityTime = Duration.between(logInTime, logoutTime);
            SessionIdDaos.terminateASession(logoutTime.toString(), maturityTime.toString(), SessionIdDaos.getCurrentSessionID());
            SessionIdDaos.deleteCurrentSession();
            System.exit(0);
        });
        viewProfileCheckBox.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "...");
        });
        viewKeyBoardShortcutsCheckBox.addActionListener(e -> JOptionPane.showMessageDialog(null, "..."));
        viewHelpCheckBox.addActionListener(e -> JOptionPane.showMessageDialog(null, "..."));

        windowCloseUIPlaceHolderPanel.add(alphaPharmacyPOS);
        windowCloseUIPlaceHolderPanel.add(adminIconLabel);
        windowCloseUIPlaceHolderPanel.add(loggedInUserLabel);
        windowCloseUIPlaceHolderPanel.add(cancelButton);
        windowCloseUIPlaceHolderPanel.add(backgroundImageLabel);
        add(windowCloseUIPlaceHolderPanel);

        changeAccountCheckBox.addActionListener(e -> {
            setVisible(false);
            // MainPOSInterface mainPOSInterface =  new MainPOSInterface(false);
            LogInScreen logInScreen = new LogInScreen(true);
        });

        repaint();
        setVisible(visible);
    }

    public void setComboBoxFeatures(List<JCheckBox> combosList) {
        combosList.stream()
                .forEach(e -> {
                    e.setBackground(Color.decode("#87CEEB"));
                    e.setForeground(Color.WHITE);
                    e.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
                    windowCloseUIPlaceHolderPanel.add(e);
                    e.addMouseListener(
                            new MouseAdapter() {
                                @Override
                                public void mouseEntered(MouseEvent event) {
                                    e.setBackground(Color.white);
                                    e.setForeground(Color.decode("#32CD32"));
                                }

                                @Override
                                public void mouseExited(MouseEvent event) {
                                    e.setBackground(Color.decode("#87CEEB"));
                                    e.setForeground(Color.white);
                                }
                            }
                    );

                });
    }

    public void setButtonsProperties(List<JButton> buttons) {
        buttons.stream().
                forEach(e -> {
                    e.setForeground(Color.WHITE);
                    e.setBackground(Color.decode("#32CD32"));
                    e.setBorder(new LineBorder(Color.decode("#32CD32"), 2, true));
                    e.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
                    windowCloseUIPlaceHolderPanel.add(e);
                    e.addMouseListener(
                            new MouseAdapter() {
                                @Override
                                public void mouseEntered(MouseEvent event) {
                                    e.setBackground(Color.white);
                                    e.setForeground(Color.decode("#32cd32"));
                                    e.setBorder(new LineBorder(Color.decode("#00FF00")));

                                }

                                @Override
                                public void mouseExited(MouseEvent event) {
                                    e.setBackground(Color.decode("#32CD32"));
                                    e.setForeground(Color.white);
                                }

                                @Override
                                public void mouseClicked(MouseEvent event) {
                                    e.setBackground(Color.WHITE);
                                    e.setForeground(Color.decode("#32CD32"));

                                }
                            }
                    );
                });
    }
}
