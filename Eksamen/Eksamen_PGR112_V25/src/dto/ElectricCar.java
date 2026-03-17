package dto;

public class ElectricCar extends Vehicle {
    private final int batteryCapacity;
    private final int chargeLevel;

    public ElectricCar(int id, int scrapyardId,String type, String brand, String model, int yearModel,
                       String registrationNumber, String chassisNumber, boolean drivable,
                       int numberOfSellableWheels, int batteryCapacity, int chargeLevel){
        super(id,scrapyardId, type, brand, model, yearModel, registrationNumber, chassisNumber, drivable, numberOfSellableWheels);
        this.batteryCapacity = batteryCapacity;
        this.chargeLevel = chargeLevel;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "batteryCapacity=" + batteryCapacity +
                ", chargeLevel=" + chargeLevel +
                "} " + super.toString();
    }
}
