package databaseManagement;
import CRUD.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class RecordValidation {
	
	private DatabaseManager databaseManager;

	
	public RecordValidation(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
	
	public boolean checkVehicleRecordExistence(String vin) {
		
		String type = "VIN";
		String table = "VEHICLEINFO";

		return !isUnique(vin, type, table);
		
	}
	public boolean checkDriverRecordExistence(String licenseNumber) {
		
		String type = "LICENSENUMBER";
		String table = "DRIVERINFO";

		return !isUnique(licenseNumber, type, table);
	}
	public boolean checkVehWarrRecordExistence(int vehicleWarrantID) {
		
		String type = "WARRANTID";
		
		String vehMun = "VEHICLEWARRANTSMUNICIPLE";
		String vehProv = "VEHICLEWARRANTSPROV";
		
		String warrant = String.valueOf(vehicleWarrantID);
		
		// Check if value is in municipal or provincial records
		return !isUnique(warrant, type, vehMun, vehProv);
		
	}
	public boolean checkDriWarrRecordExistence(int driverWarrantID) {
		
		String type = "WARRANTID";
		
		String drivMun = "DRIVERWARRANTSMUNICIPLE";
		String drivProv = "DRIVERWARRANTSPROV";

		
		String warrant = String.valueOf(driverWarrantID);
		
		// Check if value is in municipal or provincial records
		return !isUnique(warrant, type, drivMun, drivProv);
		
	}
	public boolean checkVehCitRecordExistence(int vehicleCitationID) {
		
		String type = "CITATIONID";
		
		String vehMun = "VEHICLECITATIONSMUN";
		String vehProv = "VEHICLECITATIONSPROV";
		
		String citation = String.valueOf(vehicleCitationID);
		
		// Check if value is in municipal or provincial records
		return !isUnique(citation, type, vehMun, vehProv);
		
	}
	public boolean checkDriCitRecordExistence(int driverCitationID) {
		
		String type = "CITATIONID";
		
		String drivMun = "DRIVINGCITATIONSMUN";
		String drivProv = "DRIVINGCITATIONSPROV";

		
		String citation = String.valueOf(driverCitationID);
		
		// Check if value is in municipal or provincial records
		return !isUnique(citation, type, drivMun, drivProv);
		
	}
	public boolean checkOfficerRecordExistence(int badgeNumber) {
		
		String type = "BADGENUMBER";
		String table = "OFFICERINFO";
		
		String badge = String.valueOf(badgeNumber);
		
		return !isUnique(badge, type, table);
		
	}

	public boolean checkTrafficSchoolRecordExistence(int citationID) {
		
		String trafficSchool = "TRAFFICSCHOOL";
		String trafficSchCit = "CITATIONIDTS";
	
		
		String citation = String.valueOf(citationID);
		
		// Check traffic school
		return (!isUnique(citation, trafficSchCit, trafficSchool));
		
	}
	public boolean checkAccountRecordExistence(int accountID) {
		
		String type = "ACCOUNTID";
		String table = "ACCOUNTS";
	
		
		String account = String.valueOf(accountID);
		
		// Check traffic school
		return (!isUnique(account, type, table));
		
	}
	
	public boolean checkAccountRecordExistence(String username) {
		
		String type = "USERNAME";
		String table = "ACCOUNTS";
		
		// Check traffic school
		return (!isUnique(username, type, table));
		
	}
	
	public boolean checkAccountRecordDuplication(String username, String password, String agency) {
		
		return false;
	}
	
	public boolean checkLoginInfo(String username, String password, String agency) {
		
		
		// Build string to search login credentials within database
		String sqlCredentialCheck = String.format("SELECT * FROM TCRS.ACCOUNTS WHERE AGENCY = '%s' AND USERNAME = '%s' AND PASSWORDACC = '%s'", agency, username, password);
		
		// Execute search and return results		
		 ResultSet result = this.databaseManager.executeQuery(sqlCredentialCheck);
		 
			// If there is no next, then the VIN is not in the database and therefore valid
			try {
				if(result.next()) {
					System.out.println("Login succesfull!");
					return true;
				}
				else {
					System.out.println("Account not in the system!");
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	}
	
	//************************ Helper Methods **********************
	// Check if unique
	private boolean isUnique(String entry, String column, String table) {
		
		// Search the system
		String query = String.format("SELECT %s FROM TCRS.%s WHERE %s='%s'", column, table, column, entry);
		
		// Return false if already in the system, true if unique
		ResultSet result = this.databaseManager.executeQuery(query);
		// If there is no next, then the VIN is not in the database and therefore valid
		try {
			if(result.next()) {
				System.out.println(String.format("%s: %s is already in the system!", column, entry));
				return false;
			}
			else
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	private boolean isUnique(String entry, String type, String setOne, String setTwo) {
		
		// Check municipal

		if (!isUnique(entry, type, setOne) || !isUnique(entry, type, setTwo)) {
			return false;
		}
		
		return true;
				
	}
	
}
