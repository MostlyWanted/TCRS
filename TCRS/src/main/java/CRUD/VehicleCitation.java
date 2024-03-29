package CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;

import databaseManagement.DatabaseManager;
import databaseManagement.InputDataValidation;
import databaseManagement.RecordValidation;

public class VehicleCitation {
	
	private DatabaseManager databaseManager;

	public int citationId;
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
	
		
		public void setVin(String vin) {
				
				this.vin = vin;
				
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
		
		public void setfine(String fine) {
			
			// Check if account Id is an number
			if(!isNumber(fine)) {
				System.out.println("Unable set demerit points! Demerit points number!");
				return;
			}
			
			double citFine = Double.valueOf(fine);
		 		
		 		this.fineAmount = citFine;
			
		}
		
		public void setPaid(String Paid) {
			
			Boolean PaidBool;
			if (Paid.equalsIgnoreCase("Yes")) {
				PaidBool = true;
			}
			else
				PaidBool = false;
			this.Paid = PaidBool;
			
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
		
		public String getfineamount() {
			
			return String.valueOf(fineAmount);
			
		}
		
		public String getPaid() {
			
			String PaidBool;
			if (Paid) {
				PaidBool = "Yes";
			}
			else
				PaidBool = "No";
			
			return PaidBool;
			
		}
	
		//********** Database Methods **********//

	
	public void insertVehicleCitation (String vin, String officer, String dateIssued, String reason,  String fine, String Paid) {		
		
		if(!isNumber(officer)) {
			System.out.println("Invaild badge number account!");
			return;
		}
		else if(!isNumber(fine)) {
			System.out.println("Invaild fine amount!");
			return;
		}
		
		// Validate format and if officer is in the system
		 if (!validBadgeNumber(Integer.valueOf(officer))) {
			 System.out.println("Officer badge number not in the system!");
			 return;
		 }
		 
		 if (Double.valueOf(fine) < 0) {
			 System.out.println("Invalid fine amount");
			 return;
		 }
				 
		// Create SQL query string
	    String sql = String.format("INSERT INTO TCRS.VEHICLECITATIONSMUN (ISSUINGOFFICERIDM , VINCITATIONM , "
	    		+ "CITATIONREASON ,  CITATIONDATE , FINEAMOUNT, PAYMENTSTATUS )"
	    		+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", officer, vin, 
				reason, dateIssued, fine, Paid);
	    
	    // Pass prepared statement to databaseManager for execution
	    databaseManager.executeUpdate(sql);
	    
	    System.out.println("Vehcile citation added to the database!");
		
	}
	
	public void editVehicleCitation (String citID, String vin, String officer, String dateIssued, String reason,  String fine, String Paid) {
		
		if(!isNumber(citID)) {
			System.out.println("Invaild vehicle citation, unable to edit account!");
			return;
		}
		
		// First confirm account exist, and if so return account information
		VehicleCitation citation = findCitation(Integer.valueOf(citID));
		
		// Check to see if the account is in the system
		if (!inSystem(citation)) {
			return;
		}
		
		// Build edit query in system based on citation ID
		String sqlQuery = String.format("UPDATE TCRS.VEHICLECITATIONSMUN SET ISSUINGOFFICERIDM = '%s', VINCITATIONM = '%s', CITATIONREASON = '%s', "
				+ "CITATIONDATE = '%s', FINEAMOUNT = '%s', PAYMENTSTATUS = '%s' WHERE CITATIONID = %d", 
				officer, vin, reason, dateIssued, fine, Paid, Integer.valueOf(citID));

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
	//********* Object Methods ******
	
	public void insertVehicleCitation (VehicleCitation citation) {
		
		insertVehicleCitation(citation.getVin(), citation.getissuingOfficerBadgeNumber(), citation.getdateIssued(),
				citation.getReason(), citation.getfineamount(), citation.getPaid());
		
	}
	
	public void editVehicleCitation (String citID, VehicleCitation citationNew) {
		
		editVehicleCitation ( citID,  citationNew.getVin(),  citationNew.getissuingOfficerBadgeNumber(),  citationNew.getdateIssued(),  citationNew.getReason(),   citationNew.getfineamount(),  citationNew.getPaid());

		
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
