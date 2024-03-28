package CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;

import databaseManagement.*;

public class Vehicle {

    private DatabaseManager databaseManager;

    private String vin;
    private String licensePlate;
    private String make;
    private String model;
    private int year;
    private String registeredStatus;

    public Vehicle(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void insertVehicle(Vehicle vehicle) {
        insertVehicle(vehicle.vin, vehicle.licensePlate, vehicle.make, vehicle.model, vehicle.year,
                vehicle.registeredStatus);
    }

    public void insertVehicle(String vin, String licensePlate, String make, String model, int year,
            String registeredStatus) {
        Vehicle vehicle = new Vehicle(databaseManager);

        vehicle.vin = vin;
        vehicle.licensePlate = licensePlate;
        vehicle.make = make;
        vehicle.model = model;
        vehicle.year = year;
        vehicle.registeredStatus = registeredStatus;

        if (emptyField(vehicle)) {
            return;
        }

        if (!validVehicle(vehicle)) {
            return;
        }

        String sql = String.format("INSERT INTO TCRS.VEHICLES (VIN, LICENSEPLATE, MAKE, MODEL, YEAR, REGISTEREDSTATUS) "
                + "VALUES ('%s', '%s', '%s', '%s', %d, '%s')", vehicle.vin, vehicle.licensePlate, vehicle.make,
                vehicle.model, vehicle.year, vehicle.registeredStatus);

        databaseManager.executeUpdate(sql);

        System.out.println("Vehicle added to the database!");
    }

    public void editVehicle(String vin, Vehicle newVehicle) {
        Vehicle vehicle = findVehicle(vin);

        if (!inSystem(vehicle)) {
            return;
        }
        String sqlQuery = String.format("UPDATE TCRS.VEHICLES SET LICENSEPLATE = '%s', MAKE = '%s', MODEL = '%s', "
                + "YEAR = %d, REGISTEREDSTATUS = '%s' WHERE VIN = '%s'", newVehicle.licensePlate, newVehicle.make,
                newVehicle.model, newVehicle.year, newVehicle.registeredStatus, vehicle.vin);
        databaseManager.executeUpdate(sqlQuery);
        System.out.println("Vehicle edited");
    }

    public void deleteVehicle(String vin) {
        Vehicle vehicle = findVehicle(vin);
        if (!inSystem(vehicle)) {
            return;
        }
        String sqlDelete = String.format("DELETE FROM TCRS.VEHICLES WHERE VIN= '%s'", vin);
        databaseManager.executeUpdate(sqlDelete);
        System.out.println("Vehicle " + vin + " removed from system");
    }

    public Vehicle findVehicle(String vin) {
        Vehicle vehicle = new Vehicle(this.databaseManager);

        String sqlQuery = String.format("SELECT * FROM TCRS.VEHICLES WHERE VIN='%s'", vin);

        ResultSet result = databaseManager.executeQuery(sqlQuery);

        if (nullCheck(result))
            return null;

        return logData(result, vehicle);
    }

    public String toString() {
        return "VIN: " + this.vin + " License Plate: " + this.licensePlate + " Make: " + this.make + " Model: "
                + this.model + " Year: " + this.year + " Registered Status: " + this.registeredStatus;
    }

    // helper methods
    private Vehicle logData(ResultSet result, Vehicle vehicle) {
        try {
            while (result.next()) {
                vehicle.vin = result.getString("VIN");
                vehicle.licensePlate = result.getString("LICENSEPLATE");
                vehicle.make = result.getString("MAKE");
                vehicle.model = result.getString("MODEL");
                vehicle.year = result.getInt("YEAR");
                vehicle.registeredStatus = result.getString("REGISTEREDSTATUS");

                return vehicle;
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
                System.out.println("Vehicle not in the system!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    private boolean emptyField(Vehicle vehicle) {
        return emptyField(vehicle.vin, vehicle.licensePlate, vehicle.make, vehicle.model, vehicle.registeredStatus);
    }

    private boolean emptyField(String vin, String licensePlate, String make, String model, String registeredStatus) {
        if (vin == null || vin.isEmpty()) {
            System.out.println(String.format("Cannot leave VIN blank!"));
            return true;
        }
        if (licensePlate == null || licensePlate.isEmpty()) {
            System.out.println(String.format("Cannot leave license plate blank!"));
            return true;
        }
        if (make == null || make.isEmpty()) {
            System.out.println(String.format("Cannot leave make blank!"));
            return true;
        }
        if (model == null || model.isEmpty()) {
            System.out.println(String.format("Cannot leave model blank!"));
            return true;
        }
        if (registeredStatus == null || registeredStatus.isEmpty()) {
            System.out.println(String.format("Cannot leave registered status blank!"));
            return true;
        }

        return false;
    }

    private boolean validVehicle(Vehicle vehicle) {
        InputDataValidation format = new InputDataValidation();
        RecordValidation records = new RecordValidation(this.databaseManager);

        if (!format.validateVIN(vehicle.vin)) {
            System.out.println("Unable to add vehicle to database!\nCheck VIN!");
            return false;
        }

        if (records.checkVehicleRecordExistence(vehicle.vin)) {
            return false;
        }
        return true;
    }

    private boolean inSystem(Vehicle vehicle) {
        if (vehicle == null) {
            System.out.println("Vehicle not in the system!");
            return false;
        }
        return true;
    }
}
