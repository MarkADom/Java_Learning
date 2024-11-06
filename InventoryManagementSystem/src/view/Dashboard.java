package view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Dashboard extends JFrame {

    CardLayout layout;
    JButton custButton;
    JPanel displayPanel;
    JMenuBar jMenuBar1;
    JPanel mainPanel;
    JPanel menuPanel;
    JPanel navPanel;
    JButton prodButton;
    JButton purchaseButton;
    JButton stockButton;
    JPanel userPanel;

    public Dashboard(String username, String userType) {
        initComponents();
        navPanel.setVisible(true);
        menuPanel.setVisible(true);
        layout = new CardLayout();

        displayPanel.setLayout(layout);

        displayPanel.add("Home", new HomePage());
        displayPanel.add("Customers", new CustomerPage());
        displayPanel.add("Products", new ProductPage(username, this));
        displayPanel.add("Current Stock", new CurrentStockPage(username));
        displayPanel.add("Sales", new PurchasePage(this));

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });

        setTitle("Inventory Manager");
        setVisible(true);
    }

    public void addHomePage() {
        layout.show(displayPanel, "Home");
    }

    public void addCustPage() {
        layout.show(displayPanel, "Customers");
    }

    public void addProdPage() {
        layout.show(displayPanel, "Products");
    }

    public void addStockPage() {
        layout.show(displayPanel, "Current Stock");
    }

    public void addPurchasePage() {
        layout.show(displayPanel, "Sales");
    }

    private void initComponents() {

        mainPanel = new JPanel();
        menuPanel = new JPanel();
        navPanel = new JPanel();
        prodButton = new JButton();
        stockButton = new JButton();
        custButton = new JButton();
        purchaseButton = new JButton();
        displayPanel = new JPanel();
        userPanel = new JPanel();
        jMenuBar1 = new JMenuBar();

        mainPanel.setBackground(new Color(0x609EA2));
        mainPanel.setBackground(new Color(0x609EA2));
        navPanel.setBackground(new Color(0X2A5457));
        userPanel.setBackground(new Color(0x609EA2));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle(200, 100, 0, 0));

        menuPanel.setPreferredSize(new Dimension(120, 26));

        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );

        navPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));


        prodButton.setText("Products");
        prodButton.setForeground(new Color(0x609EA2));
        prodButton.setBackground(new Color(0X2A5457));
        prodButton.setFocusable(false);
        prodButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        prodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                prodButtonActionPerformed(evt);
            }
        });

        stockButton.setText("Current Stock");
        stockButton.setForeground(new Color(0x609EA2));
        stockButton.setBackground(new Color(0X2A5457));
        stockButton.setFocusable(false);
        stockButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        stockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                stockButtonActionPerformed(evt);
            }
        });

        custButton.setText("Customers");
        custButton.setForeground(new Color(0x609EA2));
        custButton.setBackground(new Color(0X2A5457));
        custButton.setFocusable(false);
        custButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        custButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                custButtonActionPerformed(evt);
            }
        });

        purchaseButton.setText("Products");
        purchaseButton.setForeground(new Color(0x609EA2));
        purchaseButton.setBackground(new Color(0X2A5457));
        purchaseButton.setFocusable(false);
        purchaseButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                purchaseButtonActionPerformed(evt);
            }
        });

        GroupLayout navPanelLayout = new GroupLayout(navPanel);
        navPanel.setLayout(navPanelLayout);
        navPanelLayout.setHorizontalGroup(
                navPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, navPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(navPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(purchaseButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(prodButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(stockButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addComponent(custButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        navPanelLayout.setVerticalGroup(
                navPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(navPanelLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(prodButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(stockButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(custButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(purchaseButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        displayPanel.setLayout(new CardLayout());

        GroupLayout userPanelLayout = new GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
                userPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 780, Short.MAX_VALUE)
        );

        userPanelLayout.setVerticalGroup(
                userPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 38, Short.MAX_VALUE)
        );

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(navPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(userPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(userPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(displayPanel, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(navPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();

    }


    //Adding action events to pages buttons

    private void custButtonActionPerformed(ActionEvent evt) {
        addCustPage();
    }

    private void stockButtonActionPerformed(ActionEvent evt) {
        addStockPage();
    }

    private void prodButtonActionPerformed(ActionEvent evt) {
        addProdPage();
    }

    private void purchaseButtonActionPerformed(ActionEvent evt) {
        addPurchasePage();
    }
}





































