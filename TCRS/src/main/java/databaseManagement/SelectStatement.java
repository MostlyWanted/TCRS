package databaseManagement;

import java.sql.*;

public class SelectStatement {
	
	public static void main(String[] args) {
	    	    
        // Connect to the database
            
		DatabaseManager connection = new DatabaseManager();
		
		connection.connectToDatabase();

		ResultSet result = connection.executeQuery("badewale");;

		try {
    		while (result.next()) {
			     //Retrieve data by column index or name
			    int id = result.getInt("accountid");
			    String username = result.getString("username");
			    String password = result.getString("passwordacc");
			    String firstName = result.getString("firstname");
			    String lastName = result.getString("lastname");
			    String agency = result.getString("agency");
			    
			    System.out.println("ID " + id + " username: " + username + " password: " + password + " First Name: " + firstName + " Last Name: " + lastName + " agency: " + agency);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           connection.disconnectFromDatabase();
           
	}
}
