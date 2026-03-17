package dto;

public class FossilCar extends Vehicle{

    private final String fuelType;
    private final int fuelAmount;

    public FossilCar(int id, int scrapyardId, String type, String brand, String model, int yearModel,
                     String registrationNumber, String chassisNumber, boolean drivable,
                     int numberOfSellableWheels, String fuelType, int fuelAmount){
        super(id, scrapyardId, type, brand, model, yearModel, registrationNumber, chassisNumber, drivable, numberOfSellableWheels);
        this.fuelType = fuelType;
        this.fuelAmount = fuelAmount;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    @Override
    public String toString() {
        return "FossilCar{" +
                "fuelType='" + fuelType + '\'' +
                ", fuelAmount=" + fuelAmount +
                "} " + super.toString();
    }
}
