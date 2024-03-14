
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:h2:~/src/main/resources/trcs_script"; // Modify this URL based on your database configuration
    private static final String USER = "tcrs"; // Modify this
    private static final String PASSWORD = ""; // Modify this

    public static void main(String[] args) {
        try {
            // Load the H2 JDBC driver
            Class.forName("org.h2.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Use the connection to perform database operations
            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database!");
            }

            // Close the connection
            connection.close();

            // Close the connection when done
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

