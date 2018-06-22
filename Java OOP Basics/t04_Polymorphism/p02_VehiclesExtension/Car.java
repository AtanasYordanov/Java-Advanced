package t04_Inheritance.p02_VehiclesExtension;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 0.9, tankCapacity);
    }
}
