package application;

import jdbc.DB;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Program {
    public static void main(String[] args) {

        /*
        Calling the connection with database.
        Connection conn = DB.getConnection();
        Closing connection
        DB.closeConnection();
        */

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            //Accessing to the fields of the Query and setting insertion on Old
            st = conn.prepareStatement(
                    "INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);


            //Inserting elements on Query fields.
            st.setString(1, "Tomy Lee");
            st.setString(2, "tony@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);


            //Operation to now hoe many lines ware changed on the query.
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            } else {
                System.out.println("No rows affected!");
            }
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        } finally {
            // To avoid memory lost the resources to be closed, because they are external.
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
