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


	public void insertAccount (Account account) {
		
	}
	public void editAccount (int accountID) {
		
	}
	public void deleteAccount (int accountID) {
		
	}
	public void findAccount (int accountID) {
		
		String id = String.valueOf(accountID);
		
		String sqlQuery = String.format("SELECT * FROM TCRS.ACCOUNTS WHERE ACCOUNTID='%s'", id);
		
    	ResultSet result = databaseManager.executeQuery(sqlQuery);
    	
    	logData(result);
		
	}
	public void findAccount (String username) {
			
		String sqlQuery = String.format("SELECT * FROM TCRS.ACCOUNTS WHERE USERNAME='%s'", username);
		
    	ResultSet result = databaseManager.executeQuery(sqlQuery);
    	
		logData(result);
	}
	
	public void autoInputAccount (int accountID) {
		
	}

	private void logData(ResultSet result) {
		
		try {
			while (result.next()) {
			     //Retrieve data by column index or name
			    this.accountID = result.getInt("accountid");
			    username = result.getString("username");
			    password = result.getString("passwordacc");
			    firstName = result.getString("firstname");
			    lastName = result.getString("lastname");
			    agency = result.getString("agency");
			    
			    System.out.println("ID " + this.accountID + " username: " + username + " password: " + password + " First Name: " + firstName + " Last Name: " + lastName + " agency: " + agency);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


