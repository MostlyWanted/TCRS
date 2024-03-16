package databaseManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataValidation {
	
	private DatabaseManager databaseManager;
	private Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
	
	public DataValidation(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public boolean validateVIN(String vin) {
		
		// Check the length of the VIN
		if (!isValidLength(vin,17)) {
			System.out.println("VIN is the wrong length!");
			return false;
		}
		else if (specialChar(vin)) {
			System.out.println("Invalid character in VIN!");
			return false;
		}

		return isUnique(vin, "VIN", "VEHICLEINFO");
		
	}
	public boolean validateLicensePlate(String plate) {
		
		// Check the length of the VIN
		if (plate.length() != 7) {
			System.out.println("License plate  is the wrong length!");
			return false;
		}
		else if (specialChar(plate)) {
			System.out.println("Invalid character in license plate!");
			return false;
		}
		else if (!isAlpha(plate, 0, 3) || !isNumber(plate, 4, 6)) {
			System.out.println("Incorrect format for license plate!");
			System.out.println("License Plate Format: XXXXNNN");
			return false;
		}

		return isUnique(plate, "LICENSEPLATE", "VEHICLEINFO");
	}
	
	public void validateMake(String make) {
		
	}
	public void validateModel(String model) {
		
	}
	public void validateYear(int year) {
		
	}
	public void validateFirstName(int firstName) {
		
	}
	public void validateLastName(int lastName) {
		
	}
	public void validateLicenseNumber(String licenseNumber) {
		
	}
	public void validateDemeritPoints(int demeritPoints) {
		
	}
	public void validateBadgeNumber(int badgeNumber) {
		
	}
	public void validateCitationID(int citationID) {
		
	}
	public void validateFineAmount(double fineAmount) {
		
	}
	public void validateDate(String date) {
		
	}
	public void validateWarrantID(int warrantID) {
		
	}
	public void validateSessionNumber(int sessionNumber) {
		
	}
	
	// Check if unique
	private boolean isUnique(String entry, String column, String table) {
		
		String query = String.format("SELECT %s FROM TCRS.%s WHERE %s='%s'", column, table, column, entry);
		
		ResultSet result = this.databaseManager.executeQuery(query);
		// If there is no next, then the VIN is not in the database and therefore valid
		try {
			if(result.next()) {
				System.out.println(String.format("%s: %s is already on the system!", column, entry));
				return false;
			}
			else
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	// Check if the length is the correct
	private boolean isValidLength(String data, int length) {
		
		if (data.length() == length)
			return true;
		
		return false;
	}
	
	// Check for special characters
	private boolean specialChar(String str) {
		
		Matcher m = p.matcher(str);
		
		return m.find();
	}
	
	// Check if only letters
	private boolean isAlpha(String str, int begin, int end) {
	    char[] c = str.toCharArray();

	    for (int i = begin; i < end; i++ ) {
	        if(!Character.isLetter(c[i])) {
	            return false;
	        }
	    }

	    return true;
	}
	
	// Check if only numbers
	private boolean isNumber(String str, int begin, int end) {
	    char[] c = str.toCharArray();

	    for (int i = begin; i < end; i++ ) {
	        if(!Character.isLetter(c[i])) {
	            return false;
	        }
	    }

	    return true;
	}

}