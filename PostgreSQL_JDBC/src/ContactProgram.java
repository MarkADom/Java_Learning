import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactProgram {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/testDB";
        String username = "postgres";
        String password = "ernesto69";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database");

            String sql = "INSERT INTO users (name, address, email)"
                    + " VALUES ('Marco', 'Porto', 'marco@gmail.com')";

            Statement statement = connection.createStatement();

            int rows = statement.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("A new user is created.");
            }


            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in connecting to database");
            e.printStackTrace();
        }
    }
}
