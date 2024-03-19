package databaseManagement;

import CRUD.*;

public class Test_Database {
	
	public static void main(String[] args) {
	    
        // Connect to the database
            
		DatabaseManager connection = new DatabaseManager();
		DataValidation validate = new DataValidation(connection);
		
		connection.connectToTestDatabase();

		//ResultSet result = connection.executeQuery("badewale");;

		Account user = new Account(connection);
		//user.agency = "Admin";
		//user.firstName = "Elon";
		//user.lastName = "Musk";
		//user.username = "Bitcoin";
		//user.password = "mars";

		//user.insertAccount(user);
				
		user = user.findAccount("Bitcoin");
		
		user.firstName = "Kanye";
		user.lastName = "Ye";
		user.password = "Yanhdi";
		user.editAccount(user.accountID, user);
		
		user = user.findAccount("Bitcoin");
		
		String vin = "A89012345689012";
		String date = "02-29-2024";
		int citationID = 25;
		Boolean check = validate.validateLicenseNumber(vin);
		Boolean checkTwo = validate.validateDate(date);
		// Boolean checkThree = validate.validateCitationID(citationID);
		
		System.out.println("Validity of License Number: " + check);
		System.out.println(String.format("Validity of %s: %s", date, checkTwo));
		// System.out.println(String.format("Validity of %s: %s", citationID, checkThree));
        connection.disconnectFromDatabase();
           
	}
}
