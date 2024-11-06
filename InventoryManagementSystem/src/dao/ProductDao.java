package dao;

import model.services.ConnectionFactory;
import model.entities.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Locale;
import java.util.Vector;

public class ProductDao {

    Connection conn = null;
    PreparedStatement prepStatement = null;
    PreparedStatement prepStatement2 = null;
    Statement statement = null;
    Statement statement2 = null;
    ResultSet resultSet = null;

    public ProductDao() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
            statement2 = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Getting supply info
    public ResultSet getSuppInfo() {
        try {
            String query = "SELECT * FROM suppliers";
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //Getting costs info
    public ResultSet getCustInfo() {
        try {
            String query = "SELECT * FROM customers";
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //Getting product stock
    public ResultSet getProdStock() {
        try {
            String query = "SELECT * FROM currentstock";
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //Getting product info
    public ResultSet getProdInfo() {
        try {
            String query = "SELECT * FROM products";
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //Getting product cost
    public Double getProdCost(String prodCode) {
        Double costPrice = null;
        try {
            String query = "SELECT costprice FROM products WHERE productcode="
                    + prodCode
                    + "";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                costPrice = resultSet.getDouble("costprice");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return costPrice;
    }

    //Getting product sell
    public Double getProdSell(String prodCode) {
        Double sellPrice = null;
        try {
            String query = "SELECT sellprice FROM products WHERE productcode="
                    + prodCode
                    + "";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                sellPrice = resultSet.getDouble("sellprice");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sellPrice;
    }

    //Getting supply code
    String suppCode;

    public String getSuppCode(String suppName) {
        try {
            String query = "SELECT suppliercode FROM supplies WHERE fullname="
                    + suppName
                    + "";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                suppCode = resultSet.getString("suppliercode");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppCode;
    }

    //Getting product code
    String prodCode;

    public String getProdCode(String prodName) {
        try {
            String query = "SELECT productcode FROM products WHERE productname="
                    + prodName
                    + "";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                prodCode = resultSet.getString("productcode");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodCode;
    }

    //Getting customer code
    String custCode;

    public String getCustCode(String custName) {
        try {
            String query = "SELECT customercode FROM suppliers WHERE fullname="
                    + custName
                    + "";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                suppCode = resultSet.getString("customercode");
            }
        } catch (SQLException e) {
        }
        return custCode;
    }

    //Checking for availability of stock in inventory
    boolean flag = false;

    public boolean checkStock(String prodCode) {
        try {
            String query = "SELECT * FROM currentstock WHERE productcode="
                    + prodCode
                    + "";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //Adding new product
    public void addProductDao(Product product) {
        try {
            String query = "SELECT * FROM products WHERE productname="
                    + product.getProdName()
                    + " AND costprice="
                    + product.getCostPrice()
                    + " AND sellprice="
                    + product.getSellPrice()
                    + " AND brand="
                    + product.getBrand()
                    + "";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Product has already been added.");
            } else {
                addFunction(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addFunction(Product product) {
        try {
            String query = "INSERT INTO products VALUES(null,?,?,?,?,?";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, product.getProdCode());
            prepStatement.setString(2, product.getProdName());
            prepStatement.setDouble(3, product.getCostPrice());
            prepStatement.setDouble(4, product.getSellPrice());
            prepStatement.setString(5, product.getBrand());

            String query2 = "INSERT INTO currentstock VALUES(?,?)";
            prepStatement2 = conn.prepareStatement(query2);
            prepStatement2.setString(1, product.getProdCode());
            prepStatement2.setInt(2, product.getQuantity());

            prepStatement.executeUpdate();
            prepStatement2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product added and ready for sale");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Adding a new purchase transaction
    public void addPurchaseDao(Product product) {
        try {
            String query = "INSERT INTO purchaseinfo VALUES(null,?,?,?,?,?)";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, product.getSuppCode());
            prepStatement.setString(2, product.getProdCode());
            prepStatement.setString(3, product.getDate());
            prepStatement.setInt(4, product.getQuantity());
            prepStatement.setDouble(5, product.getTotalCost());

            prepStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Purchase log added.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String proCode = product.getProdCode();
        if (checkStock(proCode)) {
            try {

                String query = "UPDATE currentstock SET quantity=quantity+? WHERE productcode=?";
                prepStatement = conn.prepareStatement(query);
                prepStatement.setInt(1, product.getQuantity());
                prepStatement.setString(2, proCode);

                prepStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (!checkStock(proCode)) {
            try {
                String query = "INSERT INTO currentstock VALUES(?,?)";
                prepStatement = (PreparedStatement) conn.prepareStatement(query);
                prepStatement.setString(1, product.getProdCode());
                prepStatement.setInt(2, product.getQuantity());

                prepStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        deleteSock();
    }

    //Updating existing product details
    public void editProdDao(Product product) {
        try {
            String query = "UPDATE products SET productname=?,costprice=?,sellprice=?,brand=? WHERE productcode=?";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, product.getProdName());
            prepStatement.setDouble(2, product.getCostPrice());
            prepStatement.setDouble(3, product.getSellPrice());
            prepStatement.setString(4, product.getBrand());
            prepStatement.setString(5, product.getProdCode());

            String query2 = "UPDATE currentstock SET quantity=?  WHERE productcode=?";
            prepStatement2 = conn.prepareStatement(query2);
            prepStatement2.setInt(1, product.getQuantity());
            prepStatement2.setString(2, product.getProdCode());

            prepStatement.executeUpdate();
            prepStatement2.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product details updated.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Handling update of stocks in Inventory upon any transaction made
    public void editPurchaseStock(String code, int quantity) {
        try {
            String query = "SELECT * FROM currentstock WHERE productcode="
                    + code
                    + "";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String query2 = "UPDATE currentstock SET quantity=quantity-? WHERE productcode=?";
                prepStatement = conn.prepareStatement(query2);
                prepStatement.setInt(1, quantity);
                prepStatement.setString(2, code);
                prepStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Delete stock
    public void deleteSock() {
        try {
            String query = "DELETE FROM currentstock WHERE productcode NOT IN(SELECT productcode FROM purchaseinfo)";
            String query2 = "DELETE FROM salesinfo WHERE productcode NOT IN(SELECT productcode FROM products)";
            statement.executeUpdate(query);
            statement.executeUpdate(query2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Deleting permanently a product from inventory
    public void deleteProductDao(String code) {
        try {
            String query = "DELETE FROM products WHERE productcode=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, code);

            String query2 = "DELETE FROM currentstock WHERE productcode=?";
            prepStatement2 = conn.prepareStatement(query2);
            prepStatement2.setString(1, code);

            prepStatement.executeUpdate();
            prepStatement2.executeUpdate();

            JOptionPane.showMessageDialog(null, "Product has been removed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        deleteSock();
    }


    //Deleting permanently a transaction
    public void deletePurchaseDao(int ID) {
        try {
            String query = "DELETE FROM purchaseinfo WHERE purchasedID=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, ID);
            prepStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Transaction has been removed");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        deleteSock();
    }

    //Product data set retrieval for display
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT productcode,productname,costprice,sellprice,brand FROM products ORDER BY pid";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    //Purchase table data set retrieval
    public ResultSet getPurchaseInfo() {
        try {
            String query = "SELECT PurchasedID,purchaseinfo.ProductCode,ProductName,Quantity,Totalcost"
                    + " FROM purchaseinfo INNER JOIN products"
                    + " ON products.productcode=purchaseinfo.productcode ORDER BY purchasedid;";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    //Stock table date set retrieval
    public ResultSet getCurrentStockInfo() {
        try {
            String query = "SELECT currentstock.ProductCode,products.ProductName,currentstock.Quantity,products.CostPrice,products.SellPrice"
                    + " FROM currentstock INNER JOIN products"
                    + " ON currentstock.productcode=products.productcode;";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    //Searching for product
    public ResultSet getProductSearch(String text) {
        try {
            String query = "SELECT productcode,productname,costprice,sellprice,brand FROM products"
                    + " WHERE productcode LIKE '%"
                    + text
                    + " %' OR productname LIKE '%"
                    + text
                    + " %' OR brand LIKE '%"
                    + text
                    + " %'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    //Searching product from code
    public ResultSet getProdFromCode(String text) {
        try {
            String query = "SELECT productcode,productname,costprice,sellprice,brand FROM products"
                    + " WHERE productcode="
                    + text
                    + " LIMIT 1";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    //Searching purchase logs
    public ResultSet getPurchaseSearch(String text) {
        try {
            String query = "SELECT PurchaseID,purchaseinfo.productcode,products.productname,quantity,totalcost"
                    + " FROM purchaseinfo INNER JOIN products ON purchaseinfo.productcode=products.productcode"
                    + " WHERE PurchasedID LIKE '%"
                    + text
                    + " %' OR productcode LIKE '%"
                    + text
                    + " %' OR productname LIKE '%"
                    + text
                    + " %'"
                    + " OR suppliers.fullname LIKE'%"
                    + text
                    + " %' OR purchaseinfo.suppliercode LIKE '%"
                    + text
                    + " %'"
                    + " OR date LIKE '%"
                    + text
                    + " %' ORDER BY purchaseid";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public ResultSet getProdName(String code) {
        try {
            String query = "SELECT productname FROM products WHERE productcode="
                    + code
                    + "";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }


    //Getting supplier name
    public String getSuppName(int ID) {
        String name = null;
        try {
            String query = "SELECT fullname FROM suppliers"
                    + " INNER JOIN purchaseinfo ON suppliers,suppliercode=purchaseinfo.suppliercode"
                    + " WHERE purchaseid="
                    + ID
                    + "";
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                name = resultSet.getString("fullname");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    //Getting customer name
    public String getCustName(int ID) {
        String name = null;
        try {
            String query = "SELECT fullname FROM customers"
                    + " INNER JOIN salesinfo ON customers.customercode=salesinfo.customercode"
                    + " WHERE salesid="
                    + ID
                    + "";

            resultSet = statement.executeQuery(query);
            if (resultSet.next()){
                name = resultSet.getString("fullname");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    //Getting purchased date
    public String getPurchasedDate(int ID) {
        String date = null;
        try {
            String query = "SELECT date FROM purchaseinfo WHERE purchaseid"
                    + ID
                    + "";
            resultSet= statement.executeQuery(query);
            if (resultSet.next()) {
                date= resultSet.getString("date");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    //Getting sale date
    public String getSaleDate(int ID){
        String date = null;
        try {
            String query = "SELECT date FROM salesinfo WHERE salesid="
                    + ID
                    + "";
            resultSet= statement.executeQuery(query);
            if (resultSet.next()){
                date = resultSet.getString("date");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    //Display product-related data set in tabular form
    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Vector<String> columnNames = new Vector<String>();
        int colCount = metaData.getColumnCount();

        for (int col = 1; col <= colCount ; col++) {
            columnNames.add(metaData.getColumnName(col).toUpperCase(Locale.ROOT));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (resultSet.next()){
            Vector<Object> vector = new Vector<Object>();
            for (int col = 1; col <= colCount ; col++) {
                vector.add(resultSet.getObject(col));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }

}









































