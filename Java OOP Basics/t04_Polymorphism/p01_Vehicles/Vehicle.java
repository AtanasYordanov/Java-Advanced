package t04_Inheritance.p01_Vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public boolean drive(double kilometers) {
        double neededFuel = kilometers * this.fuelConsumption;
        if (neededFuel > this.fuelQuantity) {
            return false;
        }
        this.fuelQuantity -= neededFuel;
        return true;
    }

    public void refuel(double fuel) {
        if (fuel >= 0) {
            this.fuelQuantity += fuel;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), this.fuelQuantity);
    }
}
