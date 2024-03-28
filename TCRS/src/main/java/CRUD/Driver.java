package CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;

import databaseManagement.*;

public class Driver {

    private DatabaseManager databaseManager;

    private String licenseNumber;
    private String licensePlate;
    private String firstName;
    private String lastName;
    private String licenseStatus;
    private int demeritPoints;

    public Driver(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void insertDriver(Driver driver) {
        insertDriver(driver.licenseNumber, driver.licensePlate, driver.firstName, driver.lastName, driver.licenseStatus,
                driver.demeritPoints);
    }

    public void insertDriver(String licenseNumber, String licensePlate, String firstName, String lastName,
            String licenseStatus, int demeritPoints) {
        Driver driver = new Driver(databaseManager);

        driver.licenseNumber = licenseNumber;
        driver.licensePlate = licensePlate;
        driver.firstName = firstName;
        driver.lastName = lastName;
        driver.licenseStatus = licenseStatus;
        driver.demeritPoints = demeritPoints;

        if (emptyField(driver)) {
            return;
        }

        if (!validDriver(driver)) {
            return;
        }

        String sql = String.format(
                "INSERT INTO TCRS.DRIVERS (LICENSENUMBER, LICENSEPLATE, FIRSTNAME, LASTNAME, LICENSESTATUS, DEMERITPOINTS) "
                        + "VALUES ('%s', '%s', '%s', '%s', '%s', %d)",
                driver.licenseNumber, driver.licensePlate, driver.firstName,
                driver.lastName, driver.licenseStatus, driver.demeritPoints);

        databaseManager.executeUpdate(sql);

        System.out.println("Driver added to the database!");
    }

    public void editDriver(String licenseNumber, Driver newDriver) {
        Driver driver = findDriver(licenseNumber);

        if (!inSystem(driver)) {
            return;
        }
        String sqlQuery = String.format(
                "UPDATE TCRS.DRIVERS SET LICENSEPLATE = '%s', FIRSTNAME = '%s', LASTNAME = '%s', "
                        + "LICENSESTATUS = '%s', DEMERITPOINTS = %d WHERE LICENSENUMBER = '%s'",
                newDriver.licensePlate, newDriver.firstName,
                newDriver.lastName, newDriver.licenseStatus, newDriver.demeritPoints, driver.licenseNumber);
        databaseManager.executeUpdate(sqlQuery);
        System.out.println("Driver edited");
    }

    public void deleteDriver(String licenseNumber) {
        Driver driver = findDriver(licenseNumber);
        if (!inSystem(driver)) {
            return;
        }
        String sqlDelete = String.format("DELETE FROM TCRS.DRIVERS WHERE LICENSENUMBER= '%s'", licenseNumber);
        databaseManager.executeUpdate(sqlDelete);
        System.out.println("Driver " + licenseNumber + " removed from system");
    }

    public Driver findDriver(String licenseNumber) {
        Driver driver = new Driver(this.databaseManager);

        String sqlQuery = String.format("SELECT * FROM TCRS.DRIVERS WHERE LICENSENUMBER='%s'", licenseNumber);

        ResultSet result = databaseManager.executeQuery(sqlQuery);

        if (nullCheck(result))
            return null;

        return logData(result, driver);
    }

    public String toString() {
        return "License Number: " + this.licenseNumber + " License Plate: " + this.licensePlate + " First Name: "
                + this.firstName + " Last Name: "
                + this.lastName + " License Status: " + this.licenseStatus + " Demerit Points: " + this.demeritPoints;
    }

    // helper methods
    private Driver logData(ResultSet result, Driver driver) {
        try {
            while (result.next()) {
                driver.licenseNumber = result.getString("LICENSENUMBER");
                driver.licensePlate = result.getString("LICENSEPLATE");
                driver.firstName = result.getString("FIRSTNAME");
                driver.lastName = result.getString("LASTNAME");
                driver.licenseStatus = result.getString("LICENSESTATUS");
                driver.demeritPoints = result.getInt("DEMERITPOINTS");

                return driver;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
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
        try {
            if (!result.isBeforeFirst()) {
                System.out.println("Driver not in the system!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    private boolean emptyField(Driver driver) {
        return emptyField(driver.licenseNumber, driver.licensePlate, driver.firstName, driver.lastName,
                driver.licenseStatus);
    }

    private boolean emptyField(String licenseNumber, String licensePlate, String firstName, String lastName,
            String licenseStatus) {
        if (licenseNumber == null || licenseNumber.isEmpty()) {
            System.out.println(String.format("Cannot leave License Number blank!"));
            return true;
        }
        if (licensePlate == null || licensePlate.isEmpty()) {
            System.out.println(String.format("Cannot leave License Plate blank!"));
            return true;
        }
        if (firstName == null || firstName.isEmpty()) {
            System.out.println(String.format("Cannot leave First Name blank!"));
            return true;
        }
        if (lastName == null || lastName.isEmpty()) {
            System.out.println(String.format("Cannot leave Last Name blank!"));
            return true;
        }
        if (licenseStatus == null || licenseStatus.isEmpty()) {
            System.out.println(String.format("Cannot leave License Status blank!"));
            return true;
        }

        return false;
    }

    private boolean validDriver(Driver driver) {
        InputDataValidation format = new InputDataValidation();
        RecordValidation records = new RecordValidation(this.databaseManager);

        if (!format.validateLicenseNumber(driver.licenseNumber)) {
            System.out.println("Unable to add driver to database!\nCheck License Number!");
            return false;
        }

        if (records.checkDriverRecordExistence(driver.licenseNumber)) {
            return false;
        }
        return true;
    }

    private boolean inSystem(Driver driver) {
        if (driver == null) {
            System.out.println("Driver not in the system!");
            return false;
        }
        return true;
    }
}
