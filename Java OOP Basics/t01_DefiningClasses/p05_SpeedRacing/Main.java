package t01_DefiningClasses.p05_SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Car> carsByModel = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double fuelConsumption = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuel, fuelConsumption);
            carsByModel.put(model, car);
        }

        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            String[] tokens = line.split(" ");
            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);
            Car car = carsByModel.get(model);
            try {
                car.drive(distance);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        carsByModel.values().forEach(System.out::println);
    }
}
