package t01_DefiningClasses.p06_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire[] tires = new Tire[4];
            int index = 0;
            for (int j = 5; j < tokens.length - 1; j += 2) {
                double tirePressure = Double.parseDouble(tokens[j]);
                int tireAge = Integer.parseInt(tokens[j + 1]);
                Tire tire = new Tire(tireAge, tirePressure);
                tires[index++] = tire;
            }
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }
        String targetType = reader.readLine();
        cars.stream()
                .filter(c -> c.getCargo().getType().equals(targetType))
                .filter(c -> {
                    if (targetType.equals("fragile")) {
                        return Arrays.stream(c.getTires())
                                .anyMatch(t -> t.getPressure() < 1);
                    } else {
                        return c.getEngine().getPower() > 250;
                    }
                })
                .forEach(car -> System.out.println(car.getModel()));

    }
}
