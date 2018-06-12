package t01_DefiningClasses.p05_SpeedRacing;

public class Car {
    private static final String NO_FUEL_MESSAGE = "Insufficient fuel for the drive";

    private String model;
    private double fuel;
    private double fuelConsumption;
    private int distanceTravelled;

    public Car(String model, double fuel, double fuelCostPerKilometer) {
        this.model = model;
        this.fuel = fuel;
        this.fuelConsumption = fuelCostPerKilometer;
    }

    public void drive(int distance) {
        double requiredFuel = distance * this.fuelConsumption;
        if (requiredFuel <= this.fuel) {
            this.fuel -= requiredFuel;
            this.distanceTravelled += distance;
        } else {
            throw new IllegalArgumentException(NO_FUEL_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTravelled);
    }
}
