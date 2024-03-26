package databaseManagement;

import CRUD.*;

public class Test_Database {
	
	public static void main(String[] args) {
	    
        // Connect to the database
            
		DatabaseManager connection = new DatabaseManager();
		DataValidation validate = new DataValidation(connection);
		RecordValidation valid = new RecordValidation(connection);
		
		connection.connectToTestDatabase();

		valid.checkLoginInfo("badewale", "239592830", "Admin");
		
		
        connection.disconnectFromDatabase();
           
	}
}
