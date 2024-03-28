package CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;
import databaseManagement.*;

public class DriverWarrants {
    private DatabaseManager databaseManager;
    private String licenseNumber;
    private String dateIssued;
    private String warrantReason;
    private Boolean outstanding;

    public DriverWarrants(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void insertDriverWarrant(DriverWarrants driverWarrant) {
        insertDriverWarrant(driverWarrant.licenseNumber, driverWarrant.dateIssued, driverWarrant.warrantReason,
                driverWarrant.outstanding);
    }

    public void insertDriverWarrant(String licenseNumber, String dateIssued, String warrantReason,
            Boolean outstanding) {
        DriverWarrants driverWarrant = new DriverWarrants(databaseManager);

        driverWarrant.licenseNumber = licenseNumber;
        driverWarrant.dateIssued = dateIssued;
        driverWarrant.warrantReason = warrantReason;
        driverWarrant.outstanding = outstanding;

        if (emptyField(driverWarrant)) {
            return;
        }

        if (!validDriverWarrant(driverWarrant)) {
            return;
        }

        String sql = String.format(
                "INSERT INTO DRIVER_WARRANTS (LICENSE_NUMBER, DATE_ISSUED, WARRANT_REASON, OUTSTANDING) VALUES ('%s', '%s', '%s', %b)",
                driverWarrant.licenseNumber, driverWarrant.dateIssued, driverWarrant.warrantReason,
                driverWarrant.outstanding);

        databaseManager.executeUpdate(sql);

        System.out.println("Driver warrant added to the database!");
    }

    public void editDriverWarrant(int warrantID, DriverWarrants newDriverWarrant) {
        DriverWarrants driverWarrant = findDriverWarrant(warrantID);

        if (!inSystem(driverWarrant)) {
            return;
        }

        String sqlQuery = String.format(
                "UPDATE DRIVER_WARRANTS SET LICENSE_NUMBER = '%s', DATE_ISSUED = '%s', WARRANT_REASON = '%s', OUTSTANDING = %b WHERE WARRANT_ID = %d",
                newDriverWarrant.licenseNumber, newDriverWarrant.dateIssued, newDriverWarrant.warrantReason,
                newDriverWarrant.outstanding, warrantID);

        databaseManager.executeUpdate(sqlQuery);

        System.out.println("Driver warrant edited");
    }

    public void deleteDriverWarrant(int warrantID) {
        DriverWarrants driverWarrant = findDriverWarrant(warrantID);

        if (!inSystem(driverWarrant)) {
            return;
        }

        String sqlDelete = String.format("DELETE FROM DRIVER_WARRANTS WHERE WARRANT_ID = %d", warrantID);

        databaseManager.executeUpdate(sqlDelete);

        System.out.println("Driver warrant " + warrantID + " removed from system");
    }

    public DriverWarrants findDriverWarrant(int warrantID) {
        DriverWarrants driverWarrant = new DriverWarrants(this.databaseManager);

        String sqlQuery = String.format("SELECT * FROM DRIVER_WARRANTS WHERE WARRANT_ID = %d", warrantID);

        ResultSet result = databaseManager.executeQuery(sqlQuery);

        if (nullCheck(result))
            return null;

        return logData(result, driverWarrant);
    }

    public String toString() {
        return "License Number: " + this.licenseNumber + " Date Issued: " + this.dateIssued + " Warrant Reason: "
                + this.warrantReason + " Outstanding: " + this.outstanding;
    }

    private DriverWarrants logData(ResultSet result, DriverWarrants driverWarrant) {
        try {
            while (result.next()) {
                driverWarrant.licenseNumber = result.getString("LICENSE_NUMBER");
                driverWarrant.dateIssued = result.getString("DATE_ISSUED");
                driverWarrant.warrantReason = result.getString("WARRANT_REASON");
                driverWarrant.outstanding = result.getBoolean("OUTSTANDING");

                return driverWarrant;
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
                System.out.println("Driver warrant not in the system!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }

        return false;
    }

    private boolean emptyField(DriverWarrants driverWarrant) {
        return emptyField(driverWarrant.licenseNumber, driverWarrant.dateIssued, driverWarrant.warrantReason,
                driverWarrant.outstanding);
    }

    private boolean emptyField(String licenseNumber, String dateIssued, String warrantReason, Boolean outstanding) {
        if (licenseNumber == null || licenseNumber.isEmpty()) {
            System.out.println("Cannot leave license number blank!");
            return true;
        }
        if (dateIssued == null || dateIssued.isEmpty()) {
            System.out.println("Cannot leave date issued blank!");
            return true;
        }
        if (warrantReason == null || warrantReason.isEmpty()) {
            System.out.println("Cannot leave warrant reason blank!");
            return true;
        }
        if (outstanding == null) {
            System.out.println("Cannot leave outstanding field blank!");
            return true;
        }

        return false;
    }

    private boolean validDriverWarrant(DriverWarrants driverWarrant) {
        InputDataValidation format = new InputDataValidation();
        RecordValidation records = new RecordValidation(this.databaseManager);

        if (!format.validateLicenseNumber(driverWarrant.licenseNumber)) {
            System.out.println("Unable to add driver warrant to database!\nCheck license number!");

            return false;
        }
        if (!format.validateDate(driverWarrant.dateIssued)) {
            System.out.println("Unable to add driver warrant to database!\nCheck date issued!");
            return false;
        }

        if (records.checkDriverRecordExistence(driverWarrant.licenseNumber)) {
            return false;
        }

        return true;
    }

    private boolean inSystem(DriverWarrants driverWarrant) {
        if (driverWarrant == null) {
            System.out.println("Driver warrant not in the system!");
            return false;
        }

        return true;
    }
}
