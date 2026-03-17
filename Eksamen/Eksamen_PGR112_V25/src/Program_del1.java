import db.ScrapyardDao;
import dto.ElectricCar;
import dto.FossilCar;
import dto.Motorcycle;
import dto.Scrapyard;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program_del1 {

    private final ScrapyardDao dao;

    public Program_del1() {
        dao = new ScrapyardDao();
    }

    public void readFile() throws FileNotFoundException, SQLException {
        System.out.println("Importing data from vehicles.txt to ScrapyardDB");
        File file = new File("files/vehicles.txt");
        try (Scanner scanner = new Scanner(file);
             Connection connection = dao.getScrapyardDB().getConnection()){
            boolean autoCommit = connection.getAutoCommit();
            connection.setAutoCommit(false);
            try {


                while (scanner.hasNextLine()){

                    int nrOfScrapyards = Integer.parseInt(scanner.nextLine().trim());

                    for (int i = 0; i < nrOfScrapyards; i++){
                        Scrapyard scrapyard = readScrapyard(scanner);
                        dao.insertScrapyard(scrapyard);
                        connection.commit();
                    }

                    List<String> vehicles = new ArrayList<>();
                    scanner.nextLine();

                    while (scanner.hasNextLine()){
                        String lineVehicle = scanner.nextLine().trim();
                        if (lineVehicle.equals("---")) {
                            readVehicle(vehicles);
                            connection.commit();
                            vehicles.clear();
                        } else {
                            vehicles.add(lineVehicle);
                        }
                    }
                    if(!vehicles.isEmpty()){
                        readVehicle(vehicles);
                        connection.commit();
                    }
                }
            }
            catch (SQLException e){
                connection.rollback();
                throw new RuntimeException(e);
            } finally {
                connection.setAutoCommit(autoCommit);
            }

        }
        System.out.println("Data imported!");

    }

    private void readVehicle(List<String> vehicles) throws SQLException {
        if(vehicles.size() < 9) return;
        int id = Integer.parseInt(vehicles.get(0).trim());
        int scrapyardId = Integer.parseInt(vehicles.get(1).trim());
        String type = vehicles.get(2).trim();
        String brand = vehicles.get(3).trim();
        String model = vehicles.get(4).trim();
        int yearModel = Integer.parseInt(vehicles.get(5).trim());
        String registrationNumber = vehicles.get(6);
        String chassisNumber = vehicles.get(7);
        boolean drivable = Boolean.parseBoolean(vehicles.get(8));
        int numberOfSellableWheels = Integer.parseInt(vehicles.get(9));

        switch (type){
            case "Motorcycle"->{
                if(vehicles.size() < 14) return;
                boolean hasSideCar = Boolean.parseBoolean(vehicles.get(10));
                int engineCapacity = Integer.parseInt(vehicles.get(11));
                boolean isModified = Boolean.parseBoolean(vehicles.get(12));
                int numberOfWheels = Integer.parseInt(vehicles.get(13));
                Motorcycle motorcycle = new Motorcycle(id, scrapyardId, type, brand, model, yearModel, registrationNumber, chassisNumber, drivable, numberOfSellableWheels, hasSideCar, engineCapacity, isModified, numberOfWheels);
                dao.insertMotorcycle(motorcycle);
            }

            case "ElectricCar"-> {
                if (vehicles.size() < 12) return;
                int batteryCapacity = Integer.parseInt(vehicles.get(10));
                int chargeLevel = Integer.parseInt(vehicles.get(11));
                ElectricCar electricCar = new ElectricCar(id, scrapyardId, type, brand, model, yearModel, registrationNumber, chassisNumber, drivable, numberOfSellableWheels, batteryCapacity, chargeLevel);
                dao.insertElectricCar(electricCar);
            }

            case "FossilCar"-> {
                if(vehicles.size() < 12) return;
                String fuelType = vehicles.get(10);
                int fuelAmount = Integer.parseInt(vehicles.get(11));
                FossilCar fossilCar = new FossilCar(id, scrapyardId, type, brand, model, yearModel, registrationNumber, chassisNumber, drivable, numberOfSellableWheels, fuelType, fuelAmount);
                dao.insertFossilCar(fossilCar);
            }
            default -> System.out.println("Unknown type: "+type);


        }

    }

    private Scrapyard readScrapyard(Scanner scanner) {
        String Id = scanner.nextLine();
        String name = scanner.nextLine();
        String address = scanner.nextLine();
        String phoneNumber = scanner.nextLine();

        //hopper over ---
        scanner.nextLine();

        int id = Integer.parseInt(Id);

        return new Scrapyard(id, name, address, phoneNumber);
    }

}