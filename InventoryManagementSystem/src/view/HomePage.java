package view;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {

    JLabel welcomeLabel;
    JLabel welcomeLabel1;

    public HomePage() {
        initComponents();
    }

    public void initComponents() {
        setBackground(new Color(0X2A5457));

        welcomeLabel = new JLabel();
        welcomeLabel1 = new JLabel();

        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 45));
        welcomeLabel.setText("Welcome");

        welcomeLabel1.setFont(new Font("Arial", Font.BOLD, 45));
        welcomeLabel1.setText("To your Dashboard");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(170, 170, 170)
                                                .addComponent(welcomeLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(welcomeLabel1)))
                                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(welcomeLabel1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(169, Short.MAX_VALUE))

        );
    }
}
