package t04_Inheritance.p02_VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    private static final DecimalFormat DF = new DecimalFormat("#.##");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        double fuel = Double.parseDouble(tokens[1]);
        double consumption = Double.parseDouble(tokens[2]);
        double capacity = Double.parseDouble(tokens[3]);
        Vehicle car = new Car(fuel, consumption, capacity);

        tokens = reader.readLine().split(" ");
        fuel = Double.parseDouble(tokens[1]);
        consumption = Double.parseDouble(tokens[2]);
        capacity = Double.parseDouble(tokens[3]);
        Vehicle truck = new Truck(fuel, consumption, capacity);

        tokens = reader.readLine().split(" ");
        fuel = Double.parseDouble(tokens[1]);
        consumption = Double.parseDouble(tokens[2]);
        capacity = Double.parseDouble(tokens[3]);
        Vehicle bus = new Bus(fuel, consumption, capacity);

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            tokens = reader.readLine().split(" ");
            try {
                String command = tokens[0];
                String vehicleType = tokens[1];
                switch (command) {
                    case "Drive":
                        executeDriveCommand(tokens[2], car, truck, bus, vehicleType);
                        break;
                    case "DriveEmpty":
                        executeDriveEmptyCommand(tokens[2], bus);
                        break;
                    case "Refuel":
                        executeRefuelCommand(tokens[2], car, truck, bus, vehicleType);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static void executeRefuelCommand(String token, Vehicle car, Vehicle truck, Vehicle bus, String vehicleType) {
        double quantity = Double.parseDouble(token);
        switch (vehicleType) {
            case "Car":
                car.refuel(quantity);
                break;
            case "Truck":
                truck.refuel(quantity);
                break;
            case "Bus":
                bus.refuel(quantity);
                break;
        }
    }

    private static void executeDriveEmptyCommand(String token, Vehicle bus) {
        double distance = Double.parseDouble(token);
        if (((Bus) bus).driveEmpty(distance)) {
            System.out.println(String.format("Bus travelled %s km", DF.format(distance)));
        } else {
            System.out.println("Bus needs refueling");
        }
    }

    private static void executeDriveCommand(String token, Vehicle car, Vehicle truck, Vehicle bus, String vehicleType) {
        double distance = Double.parseDouble(token);
        switch (vehicleType) {
            case "Car":
                if (car.drive(distance)) {
                    System.out.println(String.format("Car travelled %s km", DF.format(distance)));
                } else {
                    System.out.println("Car needs refueling");
                }
                break;
            case "Truck":
                if (truck.drive(distance)) {
                    System.out.println(String.format("Truck travelled %s km", DF.format(distance)));
                } else {
                    System.out.println("Truck needs refueling");
                }
                break;
            case "Bus":
                if (bus.drive(distance)) {
                    System.out.println(String.format("Bus travelled %s km", DF.format(distance)));
                } else {
                    System.out.println("Bus needs refueling");
                }
                break;
        }
    }
}
