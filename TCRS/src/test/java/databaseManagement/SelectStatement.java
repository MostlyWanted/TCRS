package databaseManagement;

import java.sql.*;
import CRUD.*;

public class SelectStatement {
	
	public static void main(String[] args) {
	    	    
        // Connect to the database
            
		DatabaseManager connection = new DatabaseManager();
		DataValidation validate = new DataValidation(connection);
		
		connection.connectToTestDatabase();

		//ResultSet result = connection.executeQuery("badewale");;

		Account user = new Account(connection);
		user.findAccount(3);
		
		String vin = "123456789ABCDEFGJ";
		Boolean check = validate.validateVIN(vin);
		
		System.out.println("Validity of vin: " + check);
           connection.disconnectFromDatabase();
           
	}
}
