

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStatement {
	public static void main(String[] args) {
	    final String URL = "jdbc:h2:~/src/main/resources/trcs_script"; // Modify this URL based on your database configuration
	    final String USER = "tcrs"; // Modify this
	    final String PASSWORD = ""; // Modify this
	    	    
        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Create a statement
            Statement statement = connection.createStatement();
            
            // Execute a query
           ResultSet resultSet = statement.executeQuery("SELECT * FROM TCRS.ACCOUNTS");

            // Process the result set
            while (resultSet.next()) {
                 //Retrieve data by column index or name
                int id = resultSet.getInt("accountid");
                String username = resultSet.getString("username");
                String password = resultSet.getString("passwordacc");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String agency = resultSet.getString("agency");
                
                System.out.println("ID " + id + " username: " + username + " password: " + password + " First Name: " + firstName + " Last Name: " + lastName + " agency: " + agency);
            }

           
           resultSet.close();
           statement.close();
           connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

}
