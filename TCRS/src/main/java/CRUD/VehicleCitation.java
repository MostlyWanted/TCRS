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
	
	// ******** Setter Methods ********//
	
		
		public void setVin(String password) {
				
				this.vin = password;
				
			}
		
		public void setIssuingOfficerBadgeNumber(String issuingOfficerBadgeNumber) {
			
			if(!isNumber(issuingOfficerBadgeNumber)) {
				System.out.println("Invaild badge number account!");
				return;
			}
						
			int badge = Integer.valueOf(issuingOfficerBadgeNumber);
			
			this.issuingOfficerBadgeNumber = badge;
			
		}
		
		public void setDateIssued(String dateIssued) {
			
			this.dateIssued = dateIssued;
			
		}
		
		public void setReason(String reason) {
			
			this.reason = reason;
			
		}
		
		public void setPaid(Boolean Paid) {
			
			this.Paid = Paid;
			
		}
		
		//********* Getter Methods ********//
		
		public String getcitationId() {
			
			String citId = String.valueOf(citationId);
			
			return citId;
			
		}

		public String getVin() {
			
			return vin;
			
		}
		
		public String getissuingOfficerBadgeNumber() {
				
			String badge = String.valueOf(issuingOfficerBadgeNumber);

			return badge;
				
			}
		
		public String getdateIssued() {
			
			return dateIssued;
			
		}
		
		public String getReason() {
			
			return reason;
			
		}
		
		public Boolean getPaid() {
			
			return Paid;
			
		}
	
		//********** Database Methods **********//

	public void insertVehicleCitation (VehicleCitation citation) {
		
		
		String badgeNumber = String.valueOf(citation.issuingOfficerBadgeNumber);
		String fine = String.valueOf(citation.fineAmount);
		
		insertVehicleCitation(citation.vin, badgeNumber, citation.dateIssued,
				citation.reason, fine, citation.Paid);

		
	}
	
	public void insertVehicleCitation (String vin, String officer, String dateIssued, String reason,  String fine, boolean Paid) {		
		VehicleCitation citation = new VehicleCitation(databaseManager);
		
		if(!isNumber(officer)) {
			System.out.println("Invaild badge number account!");
			return;
		}
		else if(!isNumber(fine)) {
			System.out.println("Invaild fine amount!");
			return;
		}
		
		int officerBadge = Integer.valueOf(officer);
		double fineAmount = Integer.valueOf(fine);
		
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
		 
		 
		 fine = "$" + fine;
		 
		// Create SQL query string
	    String sql = String.format("INSERT INTO TCRS.VEHICLECITATIONSMUN (ISSUINGOFFICERIDM , VINCITATIONM , "
	    		+ "CITATIONREASON ,  CITATIONDATE , FINEAMOUNT, PAYMENTSTATUS )"
	    		+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", officer, citation.vin, 
				citation.reason, citation.dateIssued, fine, paidStr);
	    
	    // Pass prepared statement to databaseManager for execution
	    databaseManager.executeUpdate(sql);
	    
	    System.out.println("Account added to the database!");
		
	}
	public void editVehicleCitation (String citID, VehicleCitation citationNew) {
		
		if(!isNumber(citID)) {
			System.out.println("Invaild vehicle citation, unable to edit account!");
			return;
		}
		
		int citationID = Integer.valueOf(citID);
		
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
	
	public void deleteVehicleCitation (String citID) {
		
		if(!isNumber(citID)) {
			System.out.println("Invaild vehicle citation, unable to delete account!");
			return;
		}
		
		int citationID = Integer.valueOf(citID);

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
	
	// Check if only numbers, with range
	private boolean isNumber(String str) {
	    
		return isNumber(str, 0, (str.length() - 1));
	}
	
	// Check if only numbers, with range
	private boolean isNumber(String str, int begin, int end) {
	    char[] c = str.toCharArray();

	    for (int i = begin; i < end; i++ ) {
	        if(!Character.isDigit(c[i])) {
	        	System.out.println("Non number was found!");
	            return false;
	        }
	    }

	    return true;
	}
	

}
