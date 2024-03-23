package databaseManagement;

import CRUD.*;

public class Test_Database {
	
	public static void main(String[] args) {
	    
        // Connect to the database
            
		DatabaseManager connection = new DatabaseManager();
		DataValidation validate = new DataValidation(connection);
		
		connection.connectToTestDatabase();

		//ResultSet result = connection.executeQuery("badewale");;

		DriverCitation citation = new DriverCitation(connection);
		//officer.firstName = "Elon";
		//officer.lastName = "Musk";
		//officer.badgeNumber = 10060;
		
		//citation = citation.findCitation(1);
		
		citation.license = "M34567890134567";
		citation.ISSUINGOFFICERIDP = 10030; 
		citation.dateIssued = "02-14-2024";
		citation.reason = "DUI";
		citation.fineAmount = 1000.00; 
		citation.Paid = true;

		//citation.editVehicleCitation(35, citation);
		citation.insertDriverCitation(citation);
		
		System.out.println(citation.toString());
				
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
