package databaseManagement;

import CRUD.*;

public class Test_Database {
	
	public static void main(String[] args) {
	    
        // Connect to the database
            
		DatabaseManager connection = new DatabaseManager();
		InputDataValidation validate = new InputDataValidation();
		RecordValidation valid = new RecordValidation(connection);
		
		connection.connectToDatabase();
		
        connection.disconnectFromDatabase();
           
	}
}
