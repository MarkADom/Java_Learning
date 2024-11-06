package model.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class ConnectionFactory {

    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public ConnectionFactory() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "!Debaser1978");
            statement = conn.createStatement();
        } catch (Exception e) {
            ;
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "!Debaser1978");
            System.out.println("Connection Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


/*
    //Login Verification
    public boolean checkLogin(String username, String password, String userType) {
        String query = "SELECT * FROM users WHERE username=?"
                + username
                + " AND password=?"
                + password
                + " AND usertype="
                + userType
                + " LIMIT 1";

        try {
            resultSet = statement.executeQuery(query);
            if (resultSet.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
*/


        //Login Verification 1.1
        public boolean checkLogin (String username, String password, String userType){
            String query = "SELECT * FROM users WHERE username=? AND password=? AND usertype=? LIMIT 1";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, userType);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

    }






