package CRUD;

import databaseManagement.*;
import java.sql.*;

public class Account {
	
	private DatabaseManager databaseManager;
	
	private int accountID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String agency;
	
	public Account(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
	
	// ******** Setter Methods ********//
	
	public void setUsername(String username) {
		
		this.username = username;
		
	}
	
	public void setPassword(String password) {
			
			this.password = password;
			
		}
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
		
	}
	
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
		
	}
	
	public void setAgency(String agency) {
		
		this.agency = agency;
		
	}
	
	//********* Getter Methods ********//
	
	public String getAccountID() {
		
		
		String accId = String.valueOf(accountID);
		
		return accId;
		
	}

	public String getUsername() {
		
		return username;
		
	}
	
	public String getPassword() {
			
			return password;
			
		}
	
	public String getFirstName() {
		
		return firstName;
		
	}
	
	public String getLastName() {
		
		return lastName;
		
	}
	
	public String getAgency() {
		
		return agency;
		
	}
	
	//********** Database Methods **********//
	
	
	// Create and insert account into database given parameters
	public void insertAccount(String agency, String first, String last, String username, String password) {
		
		Account account = new Account(databaseManager);
		
		username = username.toLowerCase();
		
		account.agency = agency; 
		account.firstName = first; 
		account.lastName = last; 
		account.username = username; 
		account.password = password;
		
		// Check if any fields are empty
		if (emptyField(account)) {
			 return;
		 }
		
		// Validate correct formats of input data
		 if (!validateAccount(account)) {
			 return;
		 }	 
		
		// Create SQL query string
	    String sql = String.format("INSERT INTO TCRS.ACCOUNTS (USERNAME , PASSWORDACC , FIRSTNAME , LASTNAME , AGENCY ) "
	    		+ "VALUES ('%s', '%s', '%s', '%s', '%s')", account.username, account.password, account.firstName, 
	    		account.lastName, account.agency);
	    
	    // Pass prepared statement to databaseManager for execution
	    databaseManager.executeUpdate(sql);
	    
	    System.out.println("Account added to the database!");
	}

	
	public void editAccount (String account, Account newAcc) {
		
		if(!isNumber(account)) {
			System.out.println("Unable to edit account!");
			return;
		}
		
		int accountID = Integer.valueOf(account);
		
		// First confirm account exist, and if so return account information
		Account findAcc = findAccount(accountID);
		
		// Check to see if the account is in the system
		if (!inSystem(findAcc)) {
			return;
		}
		
		// Build edit query in system based on account ID
		String sqlQuery = String.format("UPDATE TCRS.ACCOUNTS SET USERNAME = '%s', PASSWORDACC = '%s', FIRSTNAME = '%s', LASTNAME = '%s',"
				+ " AGENCY = '%s' WHERE ACCOUNTID = '%s'", newAcc.username, newAcc.password, 
				newAcc.firstName, newAcc.lastName, newAcc.agency, findAcc.accountID);

		// Execute query
		databaseManager.executeUpdate(sqlQuery);
		
		System.out.println("Account edited");
	}
	
	// Delete account based on the account ID
	public void deleteAccount (String account) {
		
		if(!isNumber(account)) {
			System.out.println("Unable to delete account!");
			return;
		}
		
		int accountID = Integer.valueOf(account);
		
		// First confirm account exist, and if so return account information
		Account findAcc = findAccount(accountID);
		
		// Check to see if the account is in the system
		if (!inSystem(findAcc)) {
			return;
		}
				
		// Create query to delete account
		String sqlDelete = String.format("DELETE FROM TCRS.ACCOUNTS WHERE ACCOUNTID= %d", accountID);
		
		// Execute deleting of account
		databaseManager.executeUpdate(sqlDelete);
		
	}
	
	// find account using account ID
	public Account findAccount (String account) {
		
		if(!isNumber(account)) {
			System.out.println("Unable to find account!");
			return null;
		}
		
		int accountID = Integer.valueOf(account); 
		// Create account to hold new found account information
		Account findAcc = new Account(this.databaseManager);
		
		/// Create query to delete account
		String sqlQuery = String.format("SELECT * FROM TCRS.ACCOUNTS WHERE ACCOUNTID = %d", accountID);
				
		// Execute finding account SELECT query
		ResultSet result = databaseManager.executeQuery(sqlQuery);
		
		// Check if the query did not match  in the system, return empty account
		if (nullCheck(result)) {
			System.out.println("Nothing is being found in the system!");
    		return null;
		}
    	
    	// Return the found account logged into findAcc
    	return logData(result, findAcc);
    	
	}
	
	// Find account using account user name
	public Account findAccountUserName (String username) {
		
		username.toLowerCase();
		
		// Create account to hold new found account information
		Account findAcc = new Account(this.databaseManager);
		
		// Build SQL query using static method
		String sqlQuery = String.format("SELECT * FROM TCRS.ACCOUNTS WHERE USERNAME='%s'", username);

		// Execute finding account SELECT query
		ResultSet result = databaseManager.executeQuery(sqlQuery);
		
		// Check if the query did not match  in the system
		if (nullCheck(result))
    		return null;
		
    	
    	// Return the found account logged into findAcc
    	return logData(result, findAcc);
    	
	}
	
	// Auto fill data
	public void autoInputAccount (int accountID) {
		
	}
	
	// Override to String method
	public String toString() {
		return "ID " + accountID + " username: " + username + " password: " + password + " First Name: " + firstName + " Last Name: " + lastName + " agency: " + agency;

	}

	//**************************** Private Helper Methods ********************************************
	
	// Log found account into specified account
	private Account logData(ResultSet result, Account foundAcc) {
		
		try {
			while (result.next()) {
			     //Retrieve data by column index or name
				foundAcc.accountID = result.getInt("accountid");
				foundAcc.username = result.getString("username");
				foundAcc.password = result.getString("passwordacc");
				foundAcc.firstName = result.getString("firstname");
				foundAcc.lastName = result.getString("lastname");
				foundAcc.agency = result.getString("agency");
			    			
			return foundAcc;
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
	
	// Check if account is in the system
	private boolean nullCheck(ResultSet result) {
		
		// Check if the select statement returned a value
    	try {
			if (!result.isBeforeFirst()) {
				System.out.println("Account not in the system!");
				return true;
			}
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
    	
    	return false;
    	
	}
	
	// Ensure none of the fields are empty
	private boolean emptyField(Account account) {
		
		return emptyField(account.agency, account.firstName, account.lastName, account.username, account.password);
	}
	
	// Helper method for empty field
	private boolean emptyField(String agency, String first, String last, String username, String password) {
		
		// Check if any of the fields (except accountID) are empty
	    if (username == null || username.isEmpty()) {
			 System.out.println("Cannot leave username field blank!");
	        return true;
	    }
	    if (password == null || password.isEmpty()) {
			 System.out.println("Cannot leave password field blank!");

	        return true;
	    }
	    if (firstName == null || firstName.isEmpty()) {
			 System.out.println("Cannot leave first name field blank!");

	        return true;
	    }
	    if (lastName == null || lastName.isEmpty()) {
			 System.out.println("Cannot leave last name field blank!");
	        return true;
	    }
	    if (agency == null || agency.isEmpty()) {
			 System.out.println("Cannot leave agency field blank!");
	        return true;
	    }
	    // All fields are non-empty, so return true
	    return false;
	}
	
	// Check to ensure the account information is valid
	private boolean validateAccount(Account account) {
		
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
	    
	    // Check if any of the fields (except accountID) are empty
 		if(records.checkAccountRecordExistence(account.username)) {
 		        return false;
 		}
	 		
	    // All fields are non-empty, so return true
	    return true;
	}
	
	private boolean inSystem(Account account) {
		
		if (account == null) {
			System.out.println("Account not in the system!");
			return false;
		}
		
		return true;
	}
	
	// find account using account ID
		private Account findAccount (int accountID) {
			
			// Create account to hold new found account information
			Account findAcc = new Account(this.databaseManager);
			
			/// Create query to delete account
			String sqlQuery = String.format("SELECT * FROM TCRS.ACCOUNTS WHERE ACCOUNTID = %d", accountID);
					
			// Execute finding account SELECT query
			ResultSet result = databaseManager.executeQuery(sqlQuery);
			
			// Check if the query did not match  in the system, return empty account
			if (nullCheck(result)) {
				System.out.println("Nothing is being found in the system!");
	    		return null;
			}
	    	
	    	// Return the found account logged into findAcc
	    	return logData(result, findAcc);
	    	
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


