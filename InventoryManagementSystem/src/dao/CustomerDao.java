package dao;

import model.services.ConnectionFactory;
import model.entities.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;


public class CustomerDao {

    Connection conn = null;
    PreparedStatement prepStatement = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public CustomerDao() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Adding new customer

    public void addCustomerDAO(Customer customer) {
        try {
            String query = "SELECT * FROM customers WHERE fullname="
                    + customer.getFullName()
                    + " AND location="
                    + customer.getLocation()
                    + " AND phone="
                    + customer.getPhone()
                    + "";
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                JOptionPane.showMessageDialog(null, "Customer already exists");
            else
                addFunction(customer);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void addFunction(Customer customer) {
        try {
            String query = "INSERT INTO customers VALUES(null,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, customer.getCustCode());
            prepStatement.setString(2, customer.getFullName());
            prepStatement.setString(3, customer.getLocation());
            prepStatement.setString(4, customer.getPhone());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, " New customer has been hadded.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Editing existing customers details
    public void editCustomerDao(Customer customer) {
        try {
            String query = "UPDATE customers SET fullname=?,location=?,phone=? WHERE customercode=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, customer.getFullName());
            prepStatement.setString(2, customer.getLocation());
            prepStatement.setString(3, customer.getPhone());
            prepStatement.setString(4, customer.getCustCode());
            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer details have been updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Deleting existing customers
    public void deleteCustomerDao(String custCode) {
        try {
            String query = "DELETE FROM customers WHERE customercode=" + custCode + "";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Removed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Retrieve data set to be displayed
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT customercode,fullname,location,phone FROM customers";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //Retrieving search data
    public ResultSet getCustomerSearch(String text) {
        try {
            String query = "SELECT customercode,fullname,location,phone FROM customers"
                    + " WHERE customercode LIKE '%"
                    + text
                    + " %' OR phone LIKE '%"
                    + text
                    + " %'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getCustName(String custCode) {
        try {
            String query = "SELECT * FORM customers WHERE customercode="
                    + custCode
                    + "";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getProdName(String prodCode) {
        try {
            String query = "SELECT productname,currentstocl.quantity FROM products"
                    + " INNER JOIN currentstock ON products.productcode= currentstock.productcode"
                    + " WHERE currentstock.productcode="
                    + prodCode
                    + "";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //Displaying data set in tabular form
    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int colCount = metaData.getColumnCount();

        for (int col = 1; col <= colCount; col++) {
            columnNames.add(metaData.getColumnName(col).toUpperCase(Locale.ROOT));
        }
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int col = 1; col <= colCount; col++) {
                vector.add(resultSet.getObject(col));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }

}


