package t04_Inheritance.p02_VehiclesExtension;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
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
        double total = this.fuelQuantity + fuel;
        if (total > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity += fuel;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), this.fuelQuantity);
    }
}
