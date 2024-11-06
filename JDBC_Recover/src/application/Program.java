package application;

import jdbc.DB;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        /*
        Calling the connection with database.
        Connection conn = DB.getConnection();
        DB.closeConnection();
        */

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            //Consulting database returning result on rs-.
            st = conn.createStatement();
            rs = st.executeQuery("select * from department");

            //Going through the resultSet and printing column
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // To avoid memory leak the  needlose to be closed, because they are external.
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
