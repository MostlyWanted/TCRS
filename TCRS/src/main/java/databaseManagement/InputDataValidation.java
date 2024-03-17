package databaseManagement;

import java.time.Year;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputDataValidation {

	private Pattern p = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
	
	public InputDataValidation() {
		
	}

	public boolean validateVIN(String vin) {
		
		String type = "VIN";
		int vinLength = 17;
		
		// Check the length of the VIN
		if (!isValidLength(vin,vinLength, type)) {
			return false;
		}
		else if (containsSpecialChar(vin, type)) {
			return false;
		}

		return true;
		
	}
	public boolean validateLicensePlate(String plate) {
		
		String type = "License plate";
		int plateLength = 7;
		
		// Check the length of the VIN
		if (!isValidLength(plate, plateLength,type)){
			return false;
		}
		else if (containsSpecialChar(plate, type)) {
			return false;
		}
		else if (!isAlpha(plate, 0, 3) || !isNumber(plate, 4, 6)) {
			System.out.println("Incorrect format for license plate!");
			System.out.println("License Plate Format: XXXXNNN");
			return false;
		}

		return true;
	}
	
	public boolean validateMake(String make) {
		
		// Check make input contains only letters
		return isAlpha(make);
		
	}
	
	public boolean validateModel(String model) {
		
		String type = "model";
		
		// Check no special characters
		return !containsSpecialChar(model, type);
		
	}
	public void validateYear(int year) {
		
		if (year < 1960 || 2024 < year) {
			System.out.println("Incorrect year! \nPleae enter corect year of car");
		}
		
	}
	public boolean validateFirstName(String firstName) {
		
		// Check if only letters entered
		return isAlpha(firstName);
		
	}
	public boolean validateLastName(String lastName) {
		
		// Check if only letters entered
		return isAlpha(lastName);
				
	}
	public boolean validateLicenseNumber(String licenseNumber) {
		
		String type = "LICENSENUMBER";
		int licenseLength = 15;
		
		// Check length
		if (!isValidLength(licenseNumber, licenseLength, type)) {
			return false;
		}
		else if (!isAlpha(licenseNumber, 0, 1)) {
			return false;
		}
		else if (!isNumber(licenseNumber, 1, licenseLength - 1)) {
			return false;
		}
		return true;
		
	}
	public boolean validateDemeritPoints(int demeritPoints) {
		
		if (demeritPoints < 0 || 99 < demeritPoints)
			return false;
		
		return true;
		
	}
	public boolean validateBadgeNumber(int badgeNumber) {
		
		int badgeStart = 10000;
		
		if (badgeNumber < badgeStart )
			return false;
		
		
		return true;
		
	}
	public boolean validateCitationID(int citationID) {
		
		// Ensure number is valid
		if (negativeNum(citationID) || citationID == 0) {
			return false;
		}
		
		return true;
		
	}
	public boolean validateFineAmount(double fineAmount) {
		
		return negativeNum(fineAmount);
	}
	public boolean validateDate(String date) {
		
		String type = "date";
		
		if(!isValidLength(date, 10, type)){
			return false;
		}
		
		return dateFormat(date);
		
	}
	public boolean validateWarrantID(int warrantID) {
		
		// Ensure number is valid
		if (negativeNum(warrantID) || warrantID == 0) {
			return false;
		}
		
		return true;
		
	}
	public boolean validateSessionNumber(int sessionNumber) {
		
		if(sessionNumber < 1 || 4 < sessionNumber) {
			System.out.println("Invalis session number");
			return false;
		}
		
		return true;
		
	}
	
	//************************ Helper Methods **********************
	
	// Check if the length is the correct
	private boolean isValidLength(String data, int length, String category) {
		
		if (data.length() == length)
			return true;
		
		System.out.println(String.format("%s is the wrong length!", category));
		return false;
	}
	
	// Check for special characters
	private boolean containsSpecialChar(String str, String category) {
		
		Matcher m = p.matcher(str);
		
		if (m.find()) {
			System.out.println(String.format("Invalid character in %s!", category));
			return true;
		}
		return false;
	}
	
	// Check if only letters
	
	private boolean isAlpha(String str) {
	    char[] chars = str.toCharArray();

	    for (char c: chars) {
	        if(!Character.isLetter(c)) {
	        	System.out.println("Character other than letters was entered!\nPlease review");
	            return false;
	        }
	    }

	    return true;
	}
	
	// Check if only letters, with range
	private boolean isAlpha(String str, int begin, int end) {
	    char[] c = str.toCharArray();

	    for (int i = begin; i < end; i++ ) {
	        if(!Character.isLetter(c[i])) {
	        	System.out.println("Incorrect character was entered!\nPlease review");
	            return false;
	        }
	    }

	    return true;
	}
	
	
	// Check if only numbers, with range
	private boolean isNumber(String str, int begin, int end) {
	    char[] c = str.toCharArray();

	    for (int i = begin; i < end; i++ ) {
	        if(!Character.isDigit(c[i])) {
	        	System.out.println("Non number was found in incorrect position!");
	            return false;
	        }
	    }

	    return true;
	}
	
	private boolean dateFormat(String date) {
		
		char seperator = '-';
		String monthString = date.substring(0,2);
		String dayString = date.substring(3,5);
		String yearString = date.substring(6);
		
		int month = Integer.valueOf(monthString);
		int day = Integer.valueOf(dayString);
		int year = Integer.valueOf(yearString);
		int numDays = 31;  
				
		int firstYear = 2024;
		
		String invalid = "Invalid date input";
		
		if (month < 1 || month > 12) {
			System.out.println(invalid);
			return false;
		}
		
		numDays = numOfDays(month, year);
		
		if (day < 1 || numDays < day || year < firstYear) {
			System.out.println(invalid);
			return false;
		}
	
		
		return Character.isDigit(date.charAt(0)) &&
        Character.isDigit(date.charAt(1)) &&
        Objects.equals(date.charAt(2), seperator) &&
        Character.isDigit(date.charAt(3)) &&
        Character.isDigit(date.charAt(4)) &&
        Objects.equals(date.charAt(5), seperator) &&
        Character.isDigit(date.charAt(6)) &&
        Character.isDigit(date.charAt(7)) &&
        Character.isDigit(date.charAt(8));
		
	}
	
	private int numOfDays(int month, int year) {
		int days = 31;
		
		switch (month) {
				
				case 1: case 3: case 5: 
				case 7: case 8: case 10: 
				case 12:{
					days = 31;
					break;
				}
				case 4: case 6: case 9:
				case 11:{
					days = 30;
					break;
				}
				case 2:{
					if (Year.of(year).isLeap())
						days = 29;
					else
						days = 28;
					break;
				}
					
				}
		
		return days;
	}
	
	private boolean negativeNum(int value) {
		
		if (value < 0) {
			System.out.println("Amount must be greater than zero!");
			return true;
		}
		
		return false;
	}
	
private boolean negativeNum(double value) {
		
		if (value < 0) {
			System.out.println("Amount must be greater than zero!");
			return true;
		}
		
		return false;
	}


}
