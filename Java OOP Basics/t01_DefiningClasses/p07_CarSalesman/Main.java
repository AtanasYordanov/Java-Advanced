package t01_DefiningClasses.p07_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = new ArrayList<>();
        Map<String, Engine> enginesByModel = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine;
            if (tokens.length == 2) {
                engine = new Engine(model, power);
            } else if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            enginesByModel.put(model, engine);
        }
        n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            Engine engine = enginesByModel.get(tokens[1]);
            Car car;
            if (tokens.length == 2) {
                car = new Car(model, engine);
            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
            } else {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } else {
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
            }
            cars.add(car);
        }
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
