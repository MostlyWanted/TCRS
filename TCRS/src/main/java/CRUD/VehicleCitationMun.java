package CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;

import databaseManagement.DatabaseManager;
import databaseManagement.InputDataValidation;
import databaseManagement.RecordValidation;

public class VehicleCitationMun {
	
	private DatabaseManager databaseManager;

	private int citationId;
	public String vin;
	public int issuingOfficerBadgeNumber;
	public String dateIssued;
	public String reason;
	public Double fineAmount;
	public boolean Paid;
	
	public VehicleCitationMun(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
	
	public void insertVehicleCitation (VehicleCitationMun citation) {
		
		insertVehicleCitation(citation.vin, citation.issuingOfficerBadgeNumber, citation.dateIssued,
				citation.reason, citation.fineAmount, citation.Paid);

		
	}
	
	public void insertVehicleCitation (String vin, int officerBadge, String dateIssued, String reason,  Double fineAmount, boolean Paid) {		
		VehicleCitationMun citation = new VehicleCitationMun(databaseManager);
		
		citation.vin = vin;
		citation.issuingOfficerBadgeNumber = officerBadge; 
		citation.dateIssued = dateIssued;
		citation.reason = reason;
		citation.fineAmount = fineAmount; 
		citation.Paid = Paid;

		// Check if any fields are empty
		if (emptyField(citation)) {
			 return;
		 }
		
		// Create validation object
		InputDataValidation valid = new InputDataValidation();
		
		// Ensure the VIN is valid
		if(!valid.validateVIN(vin)) {
			return;
		}
		
		// Check if the date is valid
		if (!valid.validateDate(dateIssued)) {
			return;
		}
		
		
		// Validate correct formats of input data
		 if (!validBadgeNumber(officerBadge)) {
			 System.out.println("Officer badge number not in the system!");
			 return;
		 }
		 
		 if (fineAmount < 0) {
			 System.out.println("Invalid fine amount");
			 return;
		 }
		
		 
		 // Create string from paid boolean
		 String paidStr;
		 
		 if(Paid == true) {
			 paidStr = "Yes";
			 }
		else {
			 paidStr = "No";;
			}
		 
		 // Convert numbers to string
		 String badgenumber = Integer.toString(officerBadge);
		 String fineStr = fineAmount.toString();
		 fineStr = "$" + fineStr;
		 
		// Create SQL query string
	    String sql = String.format("INSERT INTO TCRS.VEHICLECITATIONSMUN (ISSUINGOFFICERIDM , VINCITATIONM , "
	    		+ "CITATIONREASON ,  CITATIONDATE , FINEAMOUNT, PAYMENTSTATUS ) "
	    		+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", badgenumber, citation.vin, 
				citation.reason, citation.dateIssued, fineStr, paidStr);
	    
	    // Pass prepared statement to databaseManager for execution
	    databaseManager.executeUpdate(sql);
	    
	    System.out.println("Account added to the database!");
		
	}
	public void editVehicleCitation (int citationID, VehicleCitationMun citationNew) {
		
		// First confirm account exist, and if so return account information
		VehicleCitationMun citation = findCitation(citationID);
		
		// Check to see if the account is in the system
		if (!inSystem(citation)) {
			return;
		}
		
		 // Create string from paid boolean
		 String paidStr;
		 
		 if(Paid == true) {
			 paidStr = "Yes";
			 }
		else {
			 paidStr = "No";;
			}
		 
		 // Convert numbers to string
		 String badgenumber = Integer.toString(citationNew.issuingOfficerBadgeNumber);
		 String fineStr = citationNew.toString();
		 fineStr = "$" + fineStr;
		
		// Build edit query in system based on account ID
		String sqlQuery = String.format("UPDATE TCRS.ACCOUNTS SET USERNAME = '%s', PASSWORDACC = '%s', FIRSTNAME = '%s', LASTNAME = '%s',"
				+ " AGENCY = '%s' WHERE CITATIONID = '%s'", citationNew.username, citationNew.password, 
				citationNew.firstName, citationNew.lastName, citationNew.agency, citation.accountID);

		// Execute query
		databaseManager.executeUpdate(sqlQuery);
		
		System.out.println("Account edited");
	}
	
	}
	public void deleteVehicleCitation (int citationID) {
		
	}
	public void findVehicleCitation (int citationID) {
		
	}
	public void autoInputVehicleCitation(int citationID) {
		
	}
	
	public String toString() {
		
		return "VIN Number " + this.vin + " Officer Badge Number: " + this.issuingOfficerBadgeNumber + " Date Issued: " + this.dateIssued
				+ " Reason:" + this.reason + " Fine Amount: $" + this.fineAmount + " Paid: " + this.Paid;
	}
	
	// Find account using account user name
	public VehicleCitationMun findCitation (int citationID) {
		
		// Create account to hold new found account information
		VehicleCitationMun findCitation = new VehicleCitationMun(this.databaseManager);
		
		// Build SQL query using static method
		String sqlQuery = String.format("SELECT * FROM TCRS.VEHICLECITATIONSMUN WHERE CITATIONID=%d", citationID);

		// Execute finding account SELECT query
		ResultSet result = databaseManager.executeQuery(sqlQuery);
		
		// Check if the query did not match  in the system
		if (nullCheck(result))
    		return null;
		
    	
    	// Return the found account logged into findAcc
    	return logData(result, findCitation);
    	
	}
	
	// Find account using account user name
	public VehicleCitationMun findCitation (String vin) {
		
		// Create account to hold new found account information
		VehicleCitationMun findCitation = new VehicleCitationMun(this.databaseManager);
		
		// Build SQL query using static method
		String sqlQuery = String.format("SELECT * FROM TCRS.VEHICLECITATIONSMUN WHERE VINCITATIONM='%s'", vin);

		// Execute finding account SELECT query
		ResultSet result = databaseManager.executeQuery(sqlQuery);
		
		// Check if the query did not match  in the system
		if (nullCheck(result))
    		return null;
		
    	
    	// Return the found account logged into findAcc
    	return logData(result, findCitation);
    	
	}
	
	
	//**************************** Private Helper Methods ********************************************
	
	private VehicleCitationMun logData(ResultSet result, VehicleCitationMun citation) {
		
		try {
			while (result.next()) {
			     //Retrieve data by column index or name
				citation.citationId = result.getInt("CITATIONID");
				citation.vin = result.getString("VINCITATIONM");
				citation.issuingOfficerBadgeNumber = result.getInt("ISSUINGOFFICERIDM");
				citation.dateIssued = result.getString("CITATIONDATE");
				citation.reason = result.getString("CITATIONREASON");
				String fine = result.getString("FINEAMOUNT");
				String paid = result.getString("PAYMENTSTATUS");
				
				//covert fine amount to double
				citation.fineAmount = Double.parseDouble(fine.substring(1));
				
				// convert payment status to boolean
				if(paid.equalsIgnoreCase("Yes")) {
					citation.Paid = true;
				}
				else {
					citation.Paid = false;
				}
			    				
			return citation;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
	        // Close the result set
	        try {
	            if (result != null) {
	                result.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
		return null;
	}
	
	private boolean nullCheck(ResultSet result) {
		
		// Check if the select statement returned a value
    	try {
			if (!result.isBeforeFirst()) {
				System.out.println("Officer not in the system!");
				return true;
			}
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
    	
    	return false;
    	
	}
	
	// Helper method for empty field
	private boolean emptyField(VehicleCitationMun citation) {
		
		return emptyField(citation.vin, citation.dateIssued, citation.reason);
		
	}
	
	// Helper method for empty field
	private boolean emptyField(String vin, String dateIssued, String reason) {
		
		// Check if any of the fields (except accountID) are empty
	    if (vin == null || vin.isEmpty()) {
			 System.out.println(String.format("Cannot leave first name blank!"));
	        return true;
	    }
	    if (dateIssued == null || dateIssued.isEmpty()) {
			 System.out.println(String.format("Cannot leave last name blank!"));

	        return true;
	    }
	    if (reason == null || reason.isEmpty()) {
			 System.out.println(String.format("Cannot leave last name blank!"));

	        return true;
	    }

	    
	    // All fields are non-empty, so return true
	    return false;
	}
	
	// Check to ensure the account information is valid
	private boolean validBadgeNumber(int badgeNumber) {
		
		// Create validation objects
		RecordValidation records = new RecordValidation(this.databaseManager);
	    
		// Check if already in the system
		if(records.checkOfficerRecordExistence(badgeNumber)) {
		        return true;
		}

	    return false;
	}
	
	private boolean inSystem(VehicleCitationMun citation) {
		
		if (citation == null) {
			System.out.println("Officer not in the system!");
			return false;
		}
		
		return true;
	}
	

}
