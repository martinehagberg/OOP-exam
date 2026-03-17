package db;

import com.mysql.cj.jdbc.MysqlDataSource;
import dto.*;
import properties.ScrapyardProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScrapyardDao {

    private MysqlDataSource ScrapyardDB;

    private static final String INSERT_ELECTRIC_CAR_SQL = "INSERT INTO ElectricCar VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

    private static final String INSERT_FOSSIL_CAR_SQL = "INSERT INTO FossilCar VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

    private static final String INSERT_MOTORCYCLE_SQL = "INSERT INTO Motorcycle VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    private static final String INSERT_SCRAPYARD_SQL = "INSERT INTO Scrapyard VALUES (?,?,?,?);";

    private static final String ALL_FOSSIL_CAR_SQL = "SELECT * FROM FossilCar;";

    private static final String ALL_ELECTRIC_CAR_SQL = "SELECT * FROM ElectricCar;";

    private static final String ALL_MOTORCYCLE_SQL  = "SELECT * FROM Motorcycle;";

    private static final String SUM_FUEL_SQL = "SELECT SUM(fuelAmount) AS totalFuel FROM FossilCar;";



    public ScrapyardDao() {
        ScrapyardDB = new MysqlDataSource();
        ScrapyardDB.setPassword(ScrapyardProperties.PROPS.getProperty("pwd"));
        ScrapyardDB.setUser(ScrapyardProperties.PROPS.getProperty("uname"));
        ScrapyardDB.setDatabaseName(ScrapyardProperties.PROPS.getProperty("db_name"));
        ScrapyardDB.setPortNumber(Integer.parseInt(ScrapyardProperties.PROPS.getProperty("port")));
        ScrapyardDB.setServerName(ScrapyardProperties.PROPS.getProperty("host"));
    }

    public MysqlDataSource getScrapyardDB() {
        return ScrapyardDB;
    }

    public int insertScrapyard(Scrapyard scrapyard) throws SQLException {
        try (Connection connection = ScrapyardDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_SCRAPYARD_SQL);
        ) {
            statement.setInt(1, scrapyard.id());
            statement.setString(2, scrapyard.name());
            statement.setString(3, scrapyard.address());
            statement.setString(4, scrapyard.phoneNumber());
            return statement.executeUpdate();
        }
    }

    public int insertElectricCar(ElectricCar electricCar) throws SQLException {
        try (Connection connection = ScrapyardDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ELECTRIC_CAR_SQL);
        ) {
            statement.setInt(1, electricCar.getId());
            statement.setInt(2, electricCar.getScrapyardId());
            statement.setString(3, electricCar.getType());
            statement.setString(4, electricCar.getBrand());
            statement.setString(5, electricCar.getModel());
            statement.setInt(6, electricCar.getYearModel());
            statement.setString(7, electricCar.getRegistrationNumber());
            statement.setString(8, electricCar.getChassisNumber());
            statement.setBoolean(9, electricCar.isDrivable());
            statement.setInt(10, electricCar.getNumberOfSellableWheels());
            statement.setInt(11, electricCar.getBatteryCapacity());
            statement.setInt(12, electricCar.getChargeLevel());
            return statement.executeUpdate();
        }

    }

    public int insertFossilCar(FossilCar fossilCar) throws SQLException {
        try (Connection connection = ScrapyardDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_FOSSIL_CAR_SQL);
        ) {
            statement.setInt(1, fossilCar.getId());
            statement.setInt(2, fossilCar.getScrapyardId());
            statement.setString(3, fossilCar.getType());
            statement.setString(4, fossilCar.getBrand());
            statement.setString(5, fossilCar.getModel());
            statement.setInt(6, fossilCar.getYearModel());
            statement.setString(7, fossilCar.getRegistrationNumber());
            statement.setString(8, fossilCar.getChassisNumber());
            statement.setBoolean(9, fossilCar.isDrivable());
            statement.setInt(10, fossilCar.getNumberOfSellableWheels());
            statement.setString(11, fossilCar.getFuelType());
            statement.setInt(12, fossilCar.getFuelAmount());
            return statement.executeUpdate();
        }

    }

    public int insertMotorcycle(Motorcycle motorcycle) throws SQLException {
        try (Connection connection = ScrapyardDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_MOTORCYCLE_SQL);
        ) {
            statement.setInt(1, motorcycle.getId());
            statement.setInt(2, motorcycle.getScrapyardId());
            statement.setString(3, motorcycle.getType());
            statement.setString(4, motorcycle.getBrand());
            statement.setString(5, motorcycle.getModel());
            statement.setInt(6, motorcycle.getYearModel());
            statement.setString(7, motorcycle.getRegistrationNumber());
            statement.setString(8, motorcycle.getChassisNumber());
            statement.setBoolean(9, motorcycle.isDrivable());
            statement.setInt(10, motorcycle.getNumberOfSellableWheels());
            statement.setBoolean(11, motorcycle.isHasSideCar());
            statement.setInt(12, motorcycle.getEngineCapacity());
            statement.setBoolean(13, motorcycle.isModified());
            statement.setInt(14, motorcycle.getNumberOgWheels());
            return statement.executeUpdate();
        }
    }

    public List<Vehicle> getAllVehicles() throws SQLException{
        List<Vehicle> vehicleList = new ArrayList<>();

        try (Connection connection = ScrapyardDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(ALL_FOSSIL_CAR_SQL);
        ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                FossilCar fossilCar = new FossilCar(
                        rs.getInt("VehicleId"),
                        rs.getInt("scrapyardId"),
                        rs.getString("type"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("yearModel"),
                        rs.getString("registrationNumber"),
                        rs.getString("chassisNumber"),
                        rs.getBoolean("driveable"),
                        rs.getInt("numberOfSellableWheels"),
                        rs.getString("fuelType"),
                        rs.getInt("fuelAmount")
                );
                vehicleList.add(fossilCar);
            }

        }

        try (Connection connection = ScrapyardDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(ALL_ELECTRIC_CAR_SQL);
        ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                ElectricCar electricCar = new ElectricCar(
                        rs.getInt("VehicleId"),
                        rs.getInt("scrapyardId"),
                        rs.getString("type"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("yearModel"),
                        rs.getString("registrationNumber"),
                        rs.getString("chassisNumber"),
                        rs.getBoolean("driveable"),
                        rs.getInt("numberOfSellableWheels"),
                        rs.getInt("batteryCapacity"),
                        rs.getInt("chargeLevel")
                );
                vehicleList.add(electricCar);
            }

        }

        try (Connection connection = ScrapyardDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(ALL_MOTORCYCLE_SQL);
        ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Motorcycle motorcycle = new Motorcycle(
                        rs.getInt("VehicleId"),
                        rs.getInt("scrapyardId"),
                        rs.getString("type"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("yearModel"),
                        rs.getString("registrationNumber"),
                        rs.getString("chassisNumber"),
                        rs.getBoolean("driveable"),
                        rs.getInt("numberOfSellableWheels"),
                        rs.getBoolean("hasSideCar"),
                        rs.getInt("engineCapacity"),
                        rs.getBoolean("isModified"),
                        rs.getInt("numberOfWheels")
                );
                vehicleList.add(motorcycle);
            }

        }

    return vehicleList;
    }


    public int getAllFuel() throws SQLException{
        try (Connection connection = ScrapyardDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(SUM_FUEL_SQL);
             ){
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return rs.getInt("totalFuel");
            }
        }
        return 0;
    }

    public List<Vehicle> getAllDriveable() throws SQLException{
        List<Vehicle> driveable = new ArrayList<>();

        try (Connection connection = ScrapyardDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(ALL_FOSSIL_CAR_SQL);
        ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                if (rs.getBoolean("driveable")){
                FossilCar fossilCar = new FossilCar(
                        rs.getInt("VehicleId"),
                        rs.getInt("scrapyardId"),
                        rs.getString("type"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("yearModel"),
                        rs.getString("registrationNumber"),
                        rs.getString("chassisNumber"),
                        rs.getBoolean("driveable"),
                        rs.getInt("numberOfSellableWheels"),
                        rs.getString("fuelType"),
                        rs.getInt("fuelAmount")
                );
                driveable.add(fossilCar);
                }
            }

        }

        try (Connection connection = ScrapyardDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(ALL_ELECTRIC_CAR_SQL);
        ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                if (rs.getBoolean("driveable")){
                ElectricCar electricCar = new ElectricCar(
                        rs.getInt("VehicleId"),
                        rs.getInt("scrapyardId"),
                        rs.getString("type"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("yearModel"),
                        rs.getString("registrationNumber"),
                        rs.getString("chassisNumber"),
                        rs.getBoolean("driveable"),
                        rs.getInt("numberOfSellableWheels"),
                        rs.getInt("batteryCapacity"),
                        rs.getInt("chargeLevel")
                );
                driveable.add(electricCar);
                }
            }

        }

        try (Connection connection = ScrapyardDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(ALL_MOTORCYCLE_SQL);
        ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                if (rs.getBoolean("driveable")){
                Motorcycle motorcycle = new Motorcycle(
                        rs.getInt("VehicleId"),
                        rs.getInt("scrapyardId"),
                        rs.getString("type"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("yearModel"),
                        rs.getString("registrationNumber"),
                        rs.getString("chassisNumber"),
                        rs.getBoolean("driveable"),
                        rs.getInt("numberOfSellableWheels"),
                        rs.getBoolean("hasSideCar"),
                        rs.getInt("engineCapacity"),
                        rs.getBoolean("isModified"),
                        rs.getInt("numberOfWheels")
                );
                driveable.add(motorcycle);
                }
            }

        }

        return driveable;
    }


}
