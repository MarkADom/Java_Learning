package view;

import dao.CustomerDao;
import model.entities.Customer;

import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class CustomerPage extends JPanel {

    JButton addButton;
    JTextField codeText;
    JTextField creditText;
    JTable custTable;
    JTextField debitText;
    JButton deleteButton;
    JPanel entryPanel;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;
    JLabel jLabel7;
    JScrollPane jScrollPane1;
    JSeparator jSeparator1;
    JTextField locationText;
    JTextField nameText;
    JTextField phoneText;

    public CustomerPage() {
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        entryPanel = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        phoneText = new JTextField();
        locationText = new JTextField();
        codeText = new JTextField();
        nameText = new JTextField();
        creditText = new JTextField();
        addButton = new JButton();
        deleteButton = new JButton();
        custTable = new JTable();

        setBackground(new Color(0x609EA2));
        jSeparator1.setBackground(new Color(0X2A5457));
        jLabel1.setFont(new Font("Arial", 0, 15));
        jLabel1.setText("CUSTOMERS");

        entryPanel.setBorder(BorderFactory.createTitledBorder("Enter Customer Details"));

        jLabel2.setText("Customer Code.");
        jLabel3.setText("Full name.");
        jLabel4.setText("Location.");
        jLabel5.setText("Contact.");
        jLabel6.setText("Debit Amount.");
        jLabel7.setText("Credit Amount");

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

        deleteButton.setText("Delete");
        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteButton.setBackground(new Color(0X2A5457));
        deleteButton.setForeground(new Color(0XF0EEED));
        deleteButton.setFocusable(false);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        GroupLayout entryPanelLayout = new GroupLayout(entryPanel);
        entryPanel.setLayout(entryPanelLayout);
        entryPanel.setBackground(new Color(0x609EA2));
        entryPanelLayout.setHorizontalGroup(
                entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(entryPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(phoneText, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                                        .addComponent(creditText)
                                                        .addComponent(debitText)
                                                        .addComponent(locationText)
                                                        .addComponent(codeText)
                                                        .addComponent(nameText)))
                                        .addGroup(entryPanelLayout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(addButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(deleteButton)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        entryPanelLayout.setVerticalGroup(
                entryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(entryPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(codeText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(locationText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(debitText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(creditText, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(entryPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addButton)
                                        .addComponent(deleteButton))
                                .addContainerGap(54, Short.MAX_VALUE))
        );

        custTable.setModel(new DefaultTableModel(
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

        custTable.setBackground(new Color(0XF0EEED));
        custTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        jScrollPane1.setViewportView(custTable);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jSeparator1)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(entryPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(entryPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap(67, Short.MAX_VALUE))
        );
    }

    private void addButtonActionPerformed(ActionEvent evt) {
        if (codeText.getText().equals("") || nameText.getText().equals("")
                || locationText.getText().equals("") || phoneText.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter all the required details.");
        } else {
            Customer customer = new Customer();
            customer.setCustCode(codeText.getText());
            customer.setFullName(nameText.getText());
            customer.setLocation(locationText.getText());
            customer.setPhone(phoneText.getText());
            new CustomerDao().addCustomerDAO(customer);
            loadDataSet();
        }
    }

    private void deleteButtonActionPerformed(ActionEvent evt) {
        new CustomerDao().deleteCustomerDao(custTable.getValueAt(custTable.getSelectedRow(),0).toString());
        loadDataSet();
    }



    private void custTableMouseClicked(MouseEvent evt) {
        int row = custTable.getSelectedRow();
        int col = custTable.getColumnCount();
        Object[] data = new Object[col];

        for (int i = 0; i < col; i++)
            data[i] = custTable.getValueAt(row, i);
        codeText.setText((String) data[0]);
        nameText.setText((String) data[1]);
        locationText.setText((String) data[2]);
        phoneText.setText((String) data[3]);
    }

    public void loadDataSet() {
        try {
            CustomerDao customerDAO = new CustomerDao();
            custTable.setModel(customerDAO.buildTableModel(customerDAO.getQueryResult()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadSearchData(String text) {
        try {
            CustomerDao customerDAO = new CustomerDao();
            custTable.setModel(customerDAO.buildTableModel(customerDAO.getCustomerSearch(text)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


























