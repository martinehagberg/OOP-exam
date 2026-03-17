package dto;

import java.util.Objects;

public abstract class Vehicle {
    private final int id;
    private final String type;
    private final String brand;
    private final String model;
    private final int yearModel;
    private final String registrationNumber;
    private final String chassisNumber;
    private final boolean drivable;
    private final int numberOfSellableWheels;
    private final int scrapyardId;

    public Vehicle(int id, int scrapyardId, String type, String brand, String model, int yearModel,
                String registrationNumber, String chassisNumber, boolean drivable,
                int numberOfSellableWheels) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearModel = yearModel;
        this.registrationNumber = registrationNumber;
        this.chassisNumber = chassisNumber;
        this.drivable = drivable;
        this.numberOfSellableWheels = numberOfSellableWheels;
        this.scrapyardId = scrapyardId;
        this.type = type;

    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearModel() {
        return yearModel;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public boolean isDrivable() {
        return drivable;
    }

    public int getNumberOfSellableWheels() {
        return numberOfSellableWheels;
    }

    public int getScrapyardId() {
        return scrapyardId;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id && yearModel == vehicle.yearModel && type == vehicle.type && drivable == vehicle.drivable && numberOfSellableWheels == vehicle.numberOfSellableWheels && scrapyardId == vehicle.scrapyardId && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && Objects.equals(registrationNumber, vehicle.registrationNumber) && Objects.equals(chassisNumber, vehicle.chassisNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, brand, model, yearModel, registrationNumber, chassisNumber, drivable, numberOfSellableWheels, scrapyardId);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearModel=" + yearModel +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", drivable=" + drivable +
                ", numberOfSellableWheels=" + numberOfSellableWheels +
                ", scrapyardId=" + scrapyardId +
                '}';
    }
}
