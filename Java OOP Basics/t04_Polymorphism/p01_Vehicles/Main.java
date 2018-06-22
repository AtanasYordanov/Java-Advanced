package t04_Inheritance.p01_Vehicles;

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
        Vehicle car = new Car(fuel, consumption);

        tokens = reader.readLine().split(" ");
        fuel = Double.parseDouble(tokens[1]);
        consumption = Double.parseDouble(tokens[2]);
        Vehicle truck = new Truck(fuel, consumption);

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            tokens = reader.readLine().split(" ");
            String command = tokens[0];
            String vehicleType = tokens[1];
            switch (command) {
                case "Drive":
                    executeDriveCommand(tokens[2], car, truck, vehicleType);
                    break;
                case "Refuel":
                    executeRefuelCommand(tokens[2], car, truck, vehicleType);
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }

    private static void executeRefuelCommand(String token, Vehicle car, Vehicle truck, String vehicleType) {
        double quantity = Double.parseDouble(token);
        switch (vehicleType) {
            case "Car":
                car.refuel(quantity);
                break;
            case "Truck":
                truck.refuel(quantity);
                break;
        }
    }

    private static void executeDriveCommand(String token, Vehicle car, Vehicle truck, String vehicleType) {
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
        }
    }
}
