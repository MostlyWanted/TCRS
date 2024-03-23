package CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;

import databaseManagement.DatabaseManager;
import databaseManagement.InputDataValidation;
import databaseManagement.RecordValidation;

public class VehicleCitation {
	
	private DatabaseManager databaseManager;

	private int citationId;
	public String vin;
	public int issuingOfficerBadgeNumber;
	public String dateIssued;
	public String reason;
	public Double fineAmount;
	public boolean Paid;
	
	public VehicleCitation(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
	
	public void insertVehicleCitation (VehicleCitation citation) {
		
		insertVehicleCitation(citation.vin, citation.issuingOfficerBadgeNumber, citation.dateIssued,
				citation.reason, citation.fineAmount, citation.Paid);

		
	}
	
	public void insertVehicleCitation (String vin, int officerBadge, String dateIssued, String reason,  Double fineAmount, boolean Paid) {		
		VehicleCitation citation = new VehicleCitation(databaseManager);
		
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
	    		+ "CITATIONREASON ,  CITATIONDATE , FINEAMOUNT, PAYMENTSTATUS )"
	    		+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", badgenumber, citation.vin, 
				citation.reason, citation.dateIssued, fineStr, paidStr);
	    
	    // Pass prepared statement to databaseManager for execution
	    databaseManager.executeUpdate(sql);
	    
	    System.out.println("Account added to the database!");
		
	}
	public void editVehicleCitation (int citationID, VehicleCitation citationNew) {
		
		// First confirm account exist, and if so return account information
		VehicleCitation citation = findCitation(citationID);
		
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
		 String fineStr = Double.toString(citationNew.fineAmount);
		 fineStr = "$" + fineStr;
		
		// Build edit query in system based on citation ID
		String sqlQuery = String.format("UPDATE TCRS.VEHICLECITATIONSMUN SET ISSUINGOFFICERIDM = '%s', VINCITATIONM = '%s', CITATIONREASON = '%s', "
				+ "CITATIONDATE = '%s', FINEAMOUNT = '%s', PAYMENTSTATUS = '%s' WHERE CITATIONID = %d", 
				 badgenumber, citationNew.vin, citationNew.reason, citationNew.dateIssued, fineStr, paidStr, citationNew.citationId);

		// Execute query
		databaseManager.executeUpdate(sqlQuery);
		
		System.out.println("Account edited");
	}
	
	public void deleteVehicleCitation (int citationID) {
		

		// First confirm account exist, and if so return account information
		VehicleCitation citation = findCitation(citationID);
		
		// Check to see if the account is in the system
		if (!inSystem(citation)) {
			return;
		}
				
		// Create query to delete account
		String sqlDelete = String.format("DELETE FROM TCRS.VEHICLECITATIONSMUN WHERE CITATIONID= %d", citationID);
		
		// Execute deleting of account
		databaseManager.executeUpdate(sqlDelete);
		
		System.out.println("Citation " + citationID + " removed from system!");

	}

	public void autoInputVehicleCitation(int citationID) {
		
	}
	
	public String toString() {
		
		return "VIN Number " + this.vin + " Officer Badge Number: " + this.issuingOfficerBadgeNumber + " Date Issued: " + this.dateIssued
				+ " Reason:" + this.reason + " Fine Amount: $" + this.fineAmount + " Paid: " + this.Paid;
	}
	
	// Find account using account user name
	public VehicleCitation findCitation (int citationID) {
		
		// Create account to hold new found account information
		VehicleCitation findCitation = new VehicleCitation(this.databaseManager);
		
		// Build SQL query using static method
		String sqlQuery = String.format("SELECT * FROM TCRS.VEHICLECITATIONSMUN WHERE CITATIONID='%d'", citationID);

		// Execute finding account SELECT query
		ResultSet result = databaseManager.executeQuery(sqlQuery);
		
		// Check if the query did not match  in the system
		if (nullCheck(result))
    		return null;
		
    	
    	// Return the found account logged into findAcc
    	return logData(result, findCitation);
    	
	}
	
	// Find account using account user name
	public VehicleCitation findCitation (String vin) {
		
		// Create account to hold new found account information
		VehicleCitation findCitation = new VehicleCitation(this.databaseManager);
		
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
	
	private VehicleCitation logData(ResultSet result, VehicleCitation citation) {
		
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
				citation.fineAmount = Double.valueOf(fine.substring(1));
				
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
				System.out.println("Citation not in the system!");
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
	private boolean emptyField(VehicleCitation citation) {
		
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
	
	private boolean inSystem(VehicleCitation citation) {
		
		if (citation == null) {
			System.out.println("Vehicle citation not in the system!");
			return false;
		}
		
		return true;
	}
	

}
