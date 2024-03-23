package CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;

import databaseManagement.*;

public class Officer {

	public int badgeNumber;
	public String lastName;
	public String firstName;
	
	private DatabaseManager databaseManager;
		
	public Officer(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
	
	// Insert new account using officer class
	public void insertOfficer (Officer officer) {
		
		insertOfficer(officer.badgeNumber, officer.firstName, officer.lastName);
	}
	
	// Insertion helper method / base method
	public void insertOfficer (int badgeNumber, String firstName, String lastName) {
		
		Officer officer = new Officer(databaseManager);
		
		officer.badgeNumber = badgeNumber;
		officer.firstName = firstName; 
		officer.lastName = lastName; 

		// Check if any fields are empty
		if (emptyField(officer)) {
			 return;
		 }
		
		// Validate correct formats of input data
		 if (!validAccount(officer)) {
			 return;
		 }	 
		
		// Create SQL query string
	    String sql = String.format("INSERT INTO TCRS.OFFICERINFO (LASTNAME , FIRSTNAME , BADGENUMBER ) "
	    		+ "VALUES ('%s', '%s', '%s')", officer.lastName, officer.firstName, officer.badgeNumber);
	    
	    // Pass prepared statement to databaseManager for execution
	    databaseManager.executeUpdate(sql);
	    
	    System.out.println("Account added to the database!");
		
	}
	
	// Edit officer based on the badge number
	public void editOfficer (int badgeNumber, Officer newAccount) {
		
		// First confirm account exist, and if so return account information
		Officer officer = findOfficer(badgeNumber);
		
		
		// Check to see if the account is in the system
		if (!inSystem(officer)) {
			return;
		}
		
		// Build edit query in system based on account ID
		String sqlQuery = String.format("UPDATE TCRS.OFFICERINFO SET LASTNAME = '%s', FIRSTNAME = '%s'"
				+ " WHERE BADGENUMBER = %d", newAccount.lastName, newAccount.firstName, officer.badgeNumber);

		// Execute query
		databaseManager.executeUpdate(sqlQuery);
		
		System.out.println("Account edited");
		
	}
	
	public void deleteOfficer (int badgeNumber) {
		
		// First confirm account exist, and if so return account information
		Officer officer = findOfficer(badgeNumber);
		
		// Check to see if the account is in the system
		if (!inSystem(officer)) {
			return;
		}
				
		// Create query to delete account
		String sqlDelete = String.format("DELETE FROM TCRS.OFFICERINFO WHERE BADGENUMBER= %d", badgeNumber);
		
		// Execute deleting of account
		databaseManager.executeUpdate(sqlDelete);
		
		System.out.println("Officer " + badgeNumber + " removed from system");
				
	}
	
	public Officer findOfficer (int badgeNumber) {
		
		// Create account to hold new found account information
		Officer officer = new Officer(this.databaseManager);
		
		/// Create query to delete account
		String sqlQuery = String.format("SELECT * FROM TCRS.OFFICERINFO WHERE BADGENUMBER = %d", badgeNumber);
				
		// Execute finding account SELECT query
		ResultSet result = databaseManager.executeQuery(sqlQuery);
		
		// Check if the query did not match  in the system, return empty account
		if (nullCheck(result)) {
    		return null;
		}
    	
    	// Return the found account logged into findAcc
    	return logData(result, officer);
		    	
	}
	
	public void autoInputOfficer(String badgeNumber) {
		
	}
	
	public String toString() {
		
		return "Badge Number " + this.badgeNumber + " First Name: " + this.firstName + " Last Name: " + this.lastName;
	}
	
	//**************************** Private Helper Methods ********************************************
	
		private Officer logData(ResultSet result, Officer officer) {
			
			try {
				while (result.next()) {
				     //Retrieve data by column index or name
					officer.badgeNumber = result.getInt("badgeNumber");
					officer.firstName = result.getString("firstName");
					officer.lastName = result.getString("lastName");
				    				
				return officer;
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
		private boolean emptyField(Officer officer) {
			
			return emptyField(officer.firstName, officer.lastName);
			
		}
		
		// Helper method for empty field
		private boolean emptyField(String first, String last) {
			
			// Check if any of the fields (except accountID) are empty
		    if (first == null || first.isEmpty()) {
				 System.out.println(String.format("Cannot leave first name blank!"));
		        return true;
		    }
		    if (last == null || last.isEmpty()) {
				 System.out.println(String.format("Cannot leave last name blank!"));

		        return true;
		    }
		    
		    // All fields are non-empty, so return true
		    return false;
		}
		
		// Check to ensure the account information is valid
		private boolean validAccount(Officer officer) {
			
			// Create validation objects
			InputDataValidation format = new InputDataValidation();
			RecordValidation records = new RecordValidation(this.databaseManager);
			
		    if (!format.validateFirstName(firstName)) {
				 System.out.println("Unable to add account to database!\nCheck first name!");

		        return false;
		    }
		    if (!format.validateLastName(lastName)) {
				 System.out.println("Unable to add account to database!\nCheck last name!");
		        return false;
		    }
		    
			// Check if already in the system
			if(records.checkOfficerRecordExistence(officer.badgeNumber)) {
			        return false;
			}

		    // All fields are non-empty, so return true
		    return true;
		}
		
		private boolean inSystem(Officer officer) {
			
			if (officer == null) {
				System.out.println("Officer not in the system!");
				return false;
			}
			
			return true;
		}


}
