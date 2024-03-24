package databaseManagement;

import CRUD.*;

public class Test_Database {
	
	public static void main(String[] args) {
	    
        // Connect to the database
            
		DatabaseManager connection = new DatabaseManager();
		DataValidation validate = new DataValidation(connection);
		RecordValidation valid = new RecordValidation(connection);
		
		connection.connectToTestDatabase();

		//ResultSet result = connection.executeQuery("badewale");;

		valid.checkLoginInfo("badewale", "239592830", "Admin");
		
		Account admin = new Account(connection);
		admin.findAccount(2);
		System.out.println(admin.toString());
		
		//officer.firstName = "Elon";
		//officer.lastName = "Musk";
		//officer.badgeNumber = 10060;
				
		//VehicleCitationMun test = citation.findCitation(5);
		
		//System.out.println(citation.toString());
		
		//user.firstName = "Kanye";
		//user.lastName = "Ye";
		//user.password = "Yanhdi";
		//user.editAccount(user.accountID, user);
		
		//user = user.findAccount("Bitcoin");
		
		//String vin = "A89012345689012";
		//String date = "02-29-2024";
		//int citationID = 25;
		//Boolean check = validate.validateLicenseNumber(vin);
		//Boolean checkTwo = validate.validateDate(date);
		// Boolean checkThree = validate.validateCitationID(citationID);
		
		//System.out.println("Validity of License Number: " + check);
		//System.out.println(String.format("Validity of %s: %s", date, checkTwo));
		// System.out.println(String.format("Validity of %s: %s", citationID, checkThree));
        connection.disconnectFromDatabase();
           
	}
}
