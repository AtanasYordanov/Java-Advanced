package t04_Inheritance.p02_VehiclesExtension;

public class Bus extends Vehicle {

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public boolean driveEmpty(double kilometers) {
        return super.drive(kilometers);
    }

    @Override
    public boolean drive(double kilometers) {
        double neededFuel = kilometers * (super.getFuelConsumption() + 1.4);
        if (neededFuel > super.getFuelQuantity()) {
            return false;
        }
        super.setFuelQuantity(super.getFuelQuantity() - neededFuel);
        return true;
    }
}
