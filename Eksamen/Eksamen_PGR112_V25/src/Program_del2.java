import db.ScrapyardDao;
import dto.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program_del2 {

    private ScrapyardDao dao;

    public Program_del2(){
        dao = new ScrapyardDao();
    }

    public void menu() {

        String choice = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Choose a option 1-4:");
        System.out.println("1: Show info about all vehicles");
        System.out.println("2: Show info about how much fuel");
        System.out.println("3: Show all drivable vehicles");
        System.out.println("4: Show all vehicles with a model older than a year you choose");
        System.out.println("q: Quit");

        choice = input.nextLine().toLowerCase();

        switch (choice){
            case "q" -> quit();
            case "1" -> allVehicles();
            case "2" -> fuelInfo();
            case "3" -> drivableVehicles();
            case "4" -> vehivlesOlderThan(input);
            default -> System.out.println("You need to write number 1-4 or q to quit");
        }

    }

    private void vehivlesOlderThan(Scanner scanner) {
        System.out.println("Write a year: ");

        int year;

        try{
            year = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            System.out.println("Please write a year");
            return;
        }

        try{
            List<Vehicle> allVehicles = dao.getAllVehicles();
            List<Vehicle> olderThanVehicles = new ArrayList<>();

            for(Vehicle vehicle : allVehicles){
                if(vehicle.getYearModel()< year){
                    olderThanVehicles.add(vehicle);
                }
            }
            if(olderThanVehicles.isEmpty()){
                System.out.println("Cant find vehicles with a model older than: "+year);
            }else {
                System.out.println("Vehicles with models older than year "+year+":");
                olderThanVehicles.forEach(System.out::println);
            }
        } catch (SQLException e){
            System.out.println("Cant get vehicles: "+e.getMessage());
        }


    }

    private void drivableVehicles() {
        try{
            List<Vehicle> drivableList = dao.getAllDriveable();
            if (drivableList.isEmpty()){
                System.out.println("Cant get driveable vehicles");
            } else{
                drivableList.forEach(System.out::println);
            }
        } catch (SQLException e){
            System.out.println("Exception: "+e.getMessage());
        }
    }

    private void fuelInfo() {
        try {
            int totalFuel = dao.getAllFuel();
            System.out.println("Total amount of fuel in the fossil cars: "+totalFuel+ "liter");
        } catch (SQLException e){
            System.out.println("Cant get total fuel amout: "+e.getMessage());
        }
    }

    private void allVehicles() {
        try{
            List<Vehicle> vehicleList = dao.getAllVehicles();
            if (vehicleList.isEmpty()){
                System.out.println("Cant get vehicles");
            } else {
                vehicleList.forEach(System.out::println);
            }
        } catch (SQLException e){
            System.out.println("Exception: "+e.getMessage());
        }
    }

    private void quit() {
        System.out.println("Bye bye! :D");
    }


}
