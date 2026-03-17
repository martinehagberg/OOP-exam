package dto;

public class Motorcycle extends Vehicle{

    private final boolean hasSideCar;
    private final int engineCapacity;
    private final boolean isModified;
    private final int numberOgWheels;

    public Motorcycle(int id, int scrapyardId, String type, String brand, String model, int yearModel,
                      String registrationNumber, String chassisNumber, boolean drivable,
                      int numberOfSellableWheels, boolean hasSideCar, int engineCapacity, boolean isModified, int numberOgWheels){
        super(id, scrapyardId, type, brand, model, yearModel, registrationNumber, chassisNumber, drivable, numberOfSellableWheels);
        this.hasSideCar = hasSideCar;
        this.engineCapacity = engineCapacity;
        this.isModified = isModified;
        this.numberOgWheels = numberOgWheels;
    }

    public boolean isHasSideCar() {
        return hasSideCar;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public boolean isModified() {
        return isModified;
    }

    public int getNumberOgWheels() {
        return numberOgWheels;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "hasSideCar=" + hasSideCar +
                ", engineCapacity=" + engineCapacity +
                ", isModified=" + isModified +
                ", numberOgWheels=" + numberOgWheels +
                "} " + super.toString();
    }
}
