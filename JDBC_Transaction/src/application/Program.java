package application;

import db.DB;
import db.DbException;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        // The transaction must contain the database consistency.
        // ACID: Atomicity, Consistency, Isolation, Durability

        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();

            // Turning setAutocommit(false):
            // All operation will be pending for explicit confirmation by the programmer
            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            /*
             Simulating error to interrupt the execution and create a exception.

             int x = 1;
             if (x < 2) {
                throw new SQLException("Fake Error");
            }
            */

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            /*
              Undoes all changes made in the current transactionand releases
              any database locks currently held by this Connection object.
              This method should be used only when auto-commit mode has been disabled.
             */
            conn.commit();

            System.out.println("rows1: " + rows1);
            System.out.println("rows2: " + rows2);

        } catch (SQLException e) {
            try {
                /*
                  Using rollback() to return to the transaction if she stopped
                  in the middle, then throwing the exception handling.
                 */
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            }
            //Exception if rollback get an error.
            catch (SQLException ex) {
                throw new DbException("Error trying to rollback! Caused by: " + e.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
