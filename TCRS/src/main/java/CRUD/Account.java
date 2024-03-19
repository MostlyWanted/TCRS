package CRUD;

import databaseManagement.*;
import java.sql.*;

public class Account {
	private DatabaseManager databaseManager;
	
	public int accountID;
	public String username;
	public String password;
	public String firstName;
	public String lastName;
	public String agency;
	
	public Account(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	// Insert account object into database
	public void insertAccount(Account account) {
		
		
		// Validate correct formats of input data
		 if (!validName(account.firstName, account.lastName)) {
			 System.out.println("Unable to add account to system!");
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
	
	// Create and insert account into database given parameters
	public void insertAccount(String agency, String first, String last, String username, String password) {
		
		Account account = new Account(databaseManager);
		
		account.agency = agency; account.firstName = first; account.lastName = last; account.username = username; 
		account.password = password;
		
		// Validate correct formats of input data
		 if (!validName(account.firstName, account.lastName)) {
			 System.out.println("Unable to add account to system!");
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

	
	public void editAccount (int accountID, Account newAcc) {
		
		// First confirm account exist, and if so return account information
		Account findAcc = findAccount(accountID);
		
		// Build edit query in system based on account ID
		String sqlQuery = String.format("UPDATE TCRS.ACCOUNTS SET USERNAME = '%s', PASSWORDACC = '%s', FIRSTNAME = '%s', LASTNAME = '%s',"
				+ " AGENCY = '%s' WHERE ACCOUNTID = '%s'", newAcc.username, newAcc.password, 
				newAcc.firstName, newAcc.lastName, newAcc.agency, findAcc.accountID);

		// Execute query
		databaseManager.executeUpdate(sqlQuery);
		
		System.out.println("Account edited");
	}
	
	// Delete account based on the account ID
	public void deleteAccount (int accountID) {
				
		// First confirm account exist, and if so return account information
		Account findAcc = findAccount(accountID);
		
		if (findAcc == null) {
			System.out.println("Account not in the system!");
			return;
		}
				
		// Create query to delete account
		String sqlDelete = String.format("DELETE FROM TCRS.ACCOUNTS WHERE ACCOUNTID= %d", accountID);
		
		// Execute deleting of account
		databaseManager.executeUpdate(sqlDelete);
		
	}
	
	// Delete account based on on user name
	public void deleteAccount (String username) {
		
		// First confirm account exist, and if so return account information
		Account findAcc = findAccount(username);
		
		if (findAcc == null) {
			System.out.println("Account not in the system!");
			return;
		}
		
		// Create query to delete account
		String sqlDelete = String.format("DELETE FROM TCRS.ACCOUNTS WHERE USERNAME='%s'", username);
		
		// Execute deleting of account
		databaseManager.executeUpdate(sqlDelete);
		
		
	}
	
	// find account using account ID
	public Account findAccount (int accountID) {
		
		// Create account to hold new found account information
		Account findAcc = new Account(this.databaseManager);
		
		/// Create query to delete account
		String sqlQuery = String.format("SELECT * FROM TCRS.ACCOUNTS WHERE ACCOUNTID = %d", accountID);
				
		// Execute finding account SELECT query
		ResultSet result = databaseManager.executeQuery(sqlQuery);
		
		// Check if the query did not match  in the system, return empty account
		if (nullCheck(result)) {
    		return findAcc;
		}
    	
    	// Return the found account logged into findAcc
    	return logData(result, findAcc);
    	
	}
	
	// Find account using account user name
	public Account findAccount (String username) {
		
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
	
	public void autoInputAccount (int accountID) {
		
	}

	//**************************** Private Helper Methods ********************************************
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
			    
			    System.out.println("ID " + foundAcc.accountID + " username: " + foundAcc.username + " password: " + foundAcc.password + " First Name: " + foundAcc.firstName + " Last Name: " + foundAcc.lastName + " agency: " + foundAcc.agency);
			
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
	
	private boolean validName(String first, String last) {
		
		// Create validation object
		InputDataValidation valid = new InputDataValidation();
		
		// Validate correct formats of input data
		 if (!valid.validateFirstName(first)) {
			 System.out.println("Unable to add account to database!\nCheck first name!");
			 return false;
		 }
		 else if (!valid.validateLastName(last)) {
			 System.out.println("Unable to add account to database!\nCheck last name!");
			 return false;
		 }
		 
		 return true;
	}
}


