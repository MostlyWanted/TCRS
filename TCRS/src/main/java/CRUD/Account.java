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
	private String table = "ACCOUNTS";
	
	public Account(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}


	
	public void insertAccount(Account account) {
		
		// Create SQL query string
	    String sql = String.format("INSERT INTO TCRS." + account.table + " (USERNAME, PASSWORDACC, FIRSTNAME, LASTNAME, AGENCY) "
	    		+ "VALUES (%s, %s, %s, %s, %s", account.username, account.password, account.firstName, 
	    		account.lastName, account.agency);
	    
	    // Pass prepared statement to databaseManager for execution
	    databaseManager.executeUpdate(sql);
	}

	
	public void editAccount (int accountID) {
		
		// First confirm account exist, and if so return account information
		Account findAcc = findAccount(accountID);
		
		String sqlQuery = String.format("UPDATE TCRS.%s SET USERNAME = %s, PASSWORDACC = %s, FIRSTNAME = %s, LASTNAME = %s,"
				+ "AGENCY = %s WHERE ACCOUNTID = %s", findAcc.table, findAcc.username, findAcc.password, 
				 findAcc.firstName, findAcc.lastName, findAcc.agency, findAcc.accountID);

		databaseManager.executeUpdate(sqlQuery);
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
		
		// First confirm account exist, and if so return account information
		findAccount(username);
		
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
		
		System.out.println(sqlQuery);
		
		// Execute finding account SELECT query
		ResultSet result = databaseManager.executeQuery(sqlQuery);
		
		// Check if the query did not match  in the system
		if (nullCheck(result)) {
			System.out.println("null!!");
    		return null;
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
}


