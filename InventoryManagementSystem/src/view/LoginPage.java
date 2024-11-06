package view;


import model.services.ConnectionFactory;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JButton loginButton;
    JPasswordField passText;
    JTextField userText;


    public LoginPage() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        userText = new JTextField();
        passText = new JPasswordField();
        jLabel3 = new JLabel();
        loginButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new Rectangle(400, 100, 0, 0));
        setName("loginFrame");

        jLabel1.setFont(new Font("Arial", Font.BOLD, 12));
        jLabel1.setText("Username:");

        jLabel2.setFont(new Font("Arial", Font.BOLD, 12));
        jLabel2.setText("Password:");

        jLabel3.setFont(new Font("Arial", Font.BOLD, 26));
        jLabel3.setForeground(new Color(0X2A5457));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("MANAGE  INVENTORY");

        loginButton.setText("LOGIN");
        loginButton.setBackground(new Color(0X2A5457));
        loginButton.setForeground(new Color(0XF0EEED));
        loginButton.setFocusable(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        getContentPane().setBackground(new Color(0x609EA2));
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(userText, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(passText)))
                                .addContainerGap(72, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(121, 121, 121))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(userText, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(passText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)))
                                .addGap(27, 27, 27)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }

    private void loginButtonActionPerformed(ActionEvent evt) {
        String username = userText.getText();
        String password = passText.getText();

        if (new ConnectionFactory().checkLogin(username, password, "ADMINISTRATOR")) {
            dispose();
            new Dashboard(username, "ADMINISTRATOR");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
        }

    }


}












































