package databaseManagement;

import CRUD.Account;

public class Test_Database {
	
	public static void main(String[] args) {
	    
        // Connect to the database
            
		DatabaseManager connection = new DatabaseManager();
		DataValidation validate = new DataValidation(connection);
		
		connection.connectToTestDatabase();

		//ResultSet result = connection.executeQuery("badewale");;

		Account user = new Account(connection);
		user.findAccount(3);
		
		String vin = "A89012345689012";
		String date = "02-29-2024";
		Boolean check = validate.validateLicenseNumber(vin);
		Boolean checkTwo = validate.validateDate(date);
		
		System.out.println("Validity of License Number: " + check);
		System.out.println(String.format("Validity of %s: %s", date, checkTwo));
        connection.disconnectFromDatabase();
           
	}
}
