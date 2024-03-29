package CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;
import databaseManagement.*;

public class VehicleWarrant {
    private DatabaseManager databaseManager;
    
    public String vin;
    public String dateIssued;
    public String warrantReason;
    public Boolean outstanding;

    public VehicleWarrant(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void insertVehicleWarrant(VehicleWarrant vehicleWarrant) {
        insertVehicleWarrant(vehicleWarrant.vin, vehicleWarrant.dateIssued, vehicleWarrant.warrantReason,
                vehicleWarrant.outstanding);
    }

    public void insertVehicleWarrant(String vin, String dateIssued, String warrantReason, Boolean outstanding) {
        VehicleWarrant vehicleWarrant = new VehicleWarrant(databaseManager);

        vehicleWarrant.vin = vin;
        vehicleWarrant.dateIssued = dateIssued;
        vehicleWarrant.warrantReason = warrantReason;
        vehicleWarrant.outstanding = outstanding;

        if (emptyField(vehicleWarrant)) {
            return;
        }

        if (!validVehicleWarrant(vehicleWarrant)) {
            return;
        }

        String sql = String.format(
                "INSERT INTO VEHICLE_WARRANTS (VIN, DATE_ISSUED, WARRANT_REASON, OUTSTANDING) VALUES ('%s', '%s', '%s', %b)",
                vehicleWarrant.vin, vehicleWarrant.dateIssued, vehicleWarrant.warrantReason,
                vehicleWarrant.outstanding);

        databaseManager.executeUpdate(sql);

        System.out.println("Vehicle warrant added to the database!");
    }

    public void editVehicleWarrant(int warrantID, VehicleWarrant newVehicleWarrant) {
        VehicleWarrant vehicleWarrant = findVehicleWarrant(warrantID);

        if (!inSystem(vehicleWarrant)) {
            return;
        }

        String sqlQuery = String.format(
                "UPDATE VEHICLE_WARRANTS SET VIN = '%s', DATE_ISSUED = '%s', WARRANT_REASON = '%s', OUTSTANDING = %b WHERE WARRANT_ID = %d",
                newVehicleWarrant.vin, newVehicleWarrant.dateIssued, newVehicleWarrant.warrantReason,
                newVehicleWarrant.outstanding, warrantID);

        databaseManager.executeUpdate(sqlQuery);

        System.out.println("Vehicle warrant edited");
    }

    public void deleteVehicleWarrant(int warrantID) {
        VehicleWarrant vehicleWarrant = findVehicleWarrant(warrantID);

        if (!inSystem(vehicleWarrant)) {
            return;
        }

        String sqlDelete = String.format("DELETE FROM VEHICLE_WARRANTS WHERE WARRANT_ID = %d", warrantID);

        databaseManager.executeUpdate(sqlDelete);

        System.out.println("Vehicle warrant " + warrantID + " removed from system");
    }

    public VehicleWarrant findVehicleWarrant(int warrantID) {
        VehicleWarrant vehicleWarrant = new VehicleWarrant(this.databaseManager);

        String sqlQuery = String.format("SELECT * FROM VEHICLE_WARRANTS WHERE WARRANT_ID = %d", warrantID);

        ResultSet result = databaseManager.executeQuery(sqlQuery);

        if (nullCheck(result))
            return null;

        return logData(result, vehicleWarrant);
    }

    public String toString() {
        return "VIN: " + this.vin + " Date Issued: " + this.dateIssued + " Warrant Reason: " + this.warrantReason
                + " Outstanding: " + this.outstanding;
    }

    private VehicleWarrant logData(ResultSet result, VehicleWarrant vehicleWarrant) {
        try {
            while (result.next()) {
                vehicleWarrant.vin = result.getString("VIN");
                vehicleWarrant.dateIssued = result.getString("DATE_ISSUED");
                vehicleWarrant.warrantReason = result.getString("WARRANT_REASON");
                vehicleWarrant.outstanding = result.getBoolean("OUTSTANDING");

                return vehicleWarrant;
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
                System.out.println("Vehicle warrant not in the system!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }

        return false;
    }

    private boolean emptyField(VehicleWarrant vehicleWarrant) {
        return emptyField(vehicleWarrant.vin, vehicleWarrant.dateIssued, vehicleWarrant.warrantReason,
                vehicleWarrant.outstanding);
    }

    private boolean emptyField(String vin, String dateIssued, String warrantReason, Boolean outstanding) {
        if (vin == null || vin.isEmpty()) {
            System.out.println("Cannot leave VIN blank!");
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

    private boolean validVehicleWarrant(VehicleWarrant vehicleWarrant) {
        InputDataValidation format = new InputDataValidation();
        RecordValidation records = new RecordValidation(this.databaseManager);

        if (!format.validateVIN(vehicleWarrant.vin)) {
            System.out.println("Unable to add vehicle warrant to database!\nCheck VIN!");

            return false;
        }
        if (!format.validateDate(vehicleWarrant.dateIssued)) {
            System.out.println("Unable to add vehicle warrant to database!\nCheck date issued!");
            return false;
        }

        if (records.checkVehicleRecordExistence(vehicleWarrant.vin)) {
            return false;
        }

        return true;
    }

    private boolean inSystem(VehicleWarrant vehicleWarrant) {
        if (vehicleWarrant == null) {
            System.out.println("Vehicle warrant not in the system!");
            return false;
        }

        return true;
    }
}
