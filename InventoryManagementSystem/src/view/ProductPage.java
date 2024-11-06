package view;

import dao.ProductDao;
import model.entities.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ProductPage extends JPanel {

    JButton addButton;
    JTextField brandText;
    JTextField codeText;
    JTextField costText;
    JPanel entryPanel;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    JLabel jLabel7;
    JLabel jLabel8;
    JScrollPane jScrollPane1;
    JSeparator jSeparator1;
    JTextField nameText;
    JTable productTable;
    JTextField quantityText;
    JTextField sellText;

    Product product;
    String username = null;
    String supplier = null;
    int userID;
    Dashboard dashboard;

    public ProductPage() {
    }

    public ProductPage(String username, Dashboard dashboard) {
        initComponents();
        this.username = username;
        this.dashboard = dashboard;
        loadDataSet();
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        entryPanel = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        codeText = new JTextField();
        nameText = new JTextField();
        quantityText = new JTextField();
        costText = new JTextField();
        sellText = new JTextField();
        brandText = new JTextField();
        addButton = new JButton();
        jScrollPane1 = new JScrollPane();
        productTable = new JTable();


        setBackground(new Color(0x609EA2));
        jLabel1.setFont(new Font("Arial", 0, 15));
        jLabel1.setText("PRODUCTS");

        entryPanel.setBorder(BorderFactory.createTitledBorder("Enter Product Details"));

        jLabel2.setText("Product code.");
        jLabel3.setText("Product name");
        jLabel5.setText("Quantity");
        jLabel6.setText("Cost Price");
        jLabel8.setText("Brand");

        addButton.setText("Add");
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setBackground(new Color(0X2A5457));
        addButton.setForeground(new Color(0XF0EEED));
        addButton.setFocusable(false);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        GroupLayout entryPanelLayout = new GroupLayout(entryPanel);
        entryPanel.setLayout(entryPanelLayout);
        entryPanel.setBackground(new Color(0X8EE4AF));
        entryPanelLayout.setHorizontalGroup(
                entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(entryPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(codeText))
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nameText))
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(quantityText))
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(costText))
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sellText))
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(brandText)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, entryPanelLayout.createSequentialGroup()
                                                                .addGap(0, 15, Short.MAX_VALUE)
                                                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(28, 28, 28)))))
                                .addContainerGap())
        );
        entryPanelLayout.setVerticalGroup(
                entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(entryPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(codeText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quantityText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(costText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sellText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(brandText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(140, Short.MAX_VALUE))
        );


        productTable.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));

        productTable.setBackground(new Color(0XF0EEED));
        productTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                super.mouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(productTable);

        jSeparator1.setBackground(new Color(0x2A5457));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 596, Short.MAX_VALUE))
                                        .addComponent(jSeparator1)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(entryPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(entryPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    private void addButtonActionPerformed(ActionEvent evt) {
        product = new Product();
        if (nameText.getText().equals("") || costText.getText().equals("")
                || sellText.getText().equals("") || brandText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter all the required details.");
        } else {
            product.setProdCode(codeText.getText());
            product.setProdName(nameText.getText());
            product.setDate("02/02/2023");
            product.setQuantity(Integer.parseInt(quantityText.getText()));
            product.setSellPrice(Double.parseDouble(costText.getText()));
            product.setSellPrice(Double.parseDouble(sellText.getText()));
            product.setBrand(brandText.getText());
            product.setUserID(userID);

            new ProductDao().addProductDao(product);
            loadDataSet();
        }
    }

    private void productTableMouseClicked(MouseEvent evt) {
        int row = productTable.getSelectedRow();
        int col = productTable.getColumnCount();

        Object[] data = new Object[col];
        for (int i = 0; i < col; i++) {
            data[i] = productTable.getValueAt(row, i);

            codeText.setText(data[0].toString());
            nameText.setText(data[1].toString());
            costText.setText(data[2].toString());
            sellText.setText(data[3].toString());
            brandText.setText(data[4].toString());
        }
    }

    public void loadDataSet() {
        try {

            ProductDao productDao = new ProductDao();
            productTable.setModel(productDao.buildTableModel(productDao.getQueryResult()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Display search result in table
    public void loadSearchData(String text) {
        try {
            ProductDao productDao = new ProductDao();
            productTable.setModel(productDao.buildTableModel(productDao.getProductSearch(text)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
