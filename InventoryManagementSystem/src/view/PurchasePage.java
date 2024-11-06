package view;

import dao.ProductDao;
import model.entities.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchasePage extends JPanel {

    JTextField codeText;
    JTextField costText;
    JLabel jLabel1;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel6;
    JLabel jLabel7;
    JLabel jLabel8;
    JPanel jPanel1;
    JScrollPane jScrollPane1;
    JSeparator jSeparator1;
    JTextField nameText;
    JButton purchaseButton;
    JTable purchaseTable;
    JTextField quantityText;
    JTextField sellText;

    Product product;

    public PurchasePage(Dashboard dashboard) {
        initComponents();
        loadDataSet();
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        codeText = new JTextField();
        nameText = new JTextField();
        quantityText = new JTextField();
        costText = new JTextField();
        sellText = new JTextField();
        purchaseButton = new JButton();
        jScrollPane1 = new JScrollPane();
        purchaseTable = new JTable();

        setBackground(new Color(0x609EA2));
        jSeparator1.setBackground(new Color(0X2A5457));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 15));
        jLabel1.setText("SALES");

        jPanel1.setBorder(BorderFactory.createTitledBorder("Sales Info"));

        jLabel3.setText("Product Code:");

        jLabel4.setText("Product Name:");

        jLabel6.setText("Quantity:");

        jLabel7.setText("Cost Price:");

        jLabel8.setText("Selling Price:");

        codeText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                codeTextKeyReleased(evt);
            }
        });

        purchaseButton.setText("Sales");
        purchaseButton.setBackground(new Color(0X2A5457));
        purchaseButton.setForeground(new Color(0XF0EEED));
        purchaseButton.setFocusable(false);
        purchaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                purchaseButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1.setBackground(new Color(0x609EA2));
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(codeText, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nameText))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(quantityText))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(costText))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sellText)))
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(purchaseButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(codeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quantityText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(costText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sellText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(purchaseButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
        );

        purchaseTable.setModel(new DefaultTableModel(
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

        purchaseTable.setBackground(new Color(0XF0EEED));

        purchaseTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                purchaseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(purchaseTable);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void purchaseTableMouseClicked(MouseEvent evt) {
        int row = purchaseTable.getSelectedRow();
        int col = purchaseTable.getColumnCount();

        Object[] data = new Object[col];
        for (int i = 0; i < col; i++)
            data[i] = purchaseTable.getValueAt(row, i);

        Integer.parseInt(data[3].toString());
        data[1].toString();
    }

    private void purchaseButtonActionPerformed(ActionEvent evt) {
        product = new Product();
        product.setSuppCode("12");
        product.setProdCode(codeText.getText());
        try {
            ResultSet resultSet = new ProductDao().getProdName(codeText.getText());
            if (resultSet.next()) {
                product.setDate("02/02/2023");
                product.setQuantity(Integer.parseInt(quantityText.getText()));
                Double costPrice = Double.parseDouble(costText.getText());
                Double totalCost = costPrice * Integer.parseInt(quantityText.getText());
                product.setTotalCost(totalCost);

                new ProductDao().addPurchaseDao(product);
                loadDataSet();
            } else
                JOptionPane.showMessageDialog(null, "Please add this product in the \"Products\" section before proceeding.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void codeTextKeyReleased(KeyEvent evt) {
        try {
            ResultSet resultSet = new ProductDao().getProdFromCode(codeText.getText());
            if (resultSet.next()) {
                nameText.setText(resultSet.getString("productname"));
                costText.setText(String.valueOf(resultSet.getDouble("costprice")));
                sellText.setText(String.valueOf(resultSet.getDouble("sellprice")));
            } else {
                nameText.setText("");
                costText.setText("");
                sellText.setText("");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadDataSet() {
        try {
            ProductDao productDao = new ProductDao();
            purchaseTable.setModel(productDao.buildTableModel(productDao.getPurchaseInfo()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadSearchData(String text) {
        try {
            ProductDao productDao = new ProductDao();
            purchaseTable.setModel(productDao.buildTableModel(productDao.getPurchaseSearch(text)));
        } catch (SQLException e) {
        }
    }

}

