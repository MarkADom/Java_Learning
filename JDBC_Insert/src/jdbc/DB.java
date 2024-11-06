package jdbc;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    //Instantiating an Object type Connection and save it in conn.
    private static Connection conn = null;


    //Taking the properties from the url and connect to database.
    public static Connection getConnection() {
        if(conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url,props);
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return  conn;
    }

    public static void closeConnection() {
        if (conn != null){
            try{
                conn.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    //Method to close an Object type Statement.
    public static void closeStatement(Statement st){
        if (st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                //Capturing and launching a personalizes exception
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
