package view;

import dao.ProductDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class CurrentStockPage extends JPanel {

    JLabel jLabel1;
    JScrollPane jScrollPane1;
    JSeparator jSeparator1;
    JTable stockTable;

    public CurrentStockPage(String username) {
        initComponents();
        loadDataSet();
    }

    private void initComponents(){
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        stockTable = new JTable();

        jLabel1.setFont(new Font("Arial",0,15));
        jLabel1.setText("CURRENT STOCK");
        jLabel1.setToolTipText("");

        setBackground(new Color(0x609EA2));

        stockTable.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(stockTable);
        jSeparator1.setBackground(new Color(0X2A5457));
        stockTable.setBackground(new Color(0XF0EEED));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        this.setBackground(new Color(0x609EA2));
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator1)
                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(88, Short.MAX_VALUE))
        );
    }

    private void loadDataSet(){
        try {
            ProductDao productDao = new ProductDao();
            stockTable.setModel(productDao.buildTableModel(productDao.getCurrentStockInfo()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
