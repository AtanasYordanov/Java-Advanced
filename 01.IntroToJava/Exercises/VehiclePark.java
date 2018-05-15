package IntroToJava.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VehiclePark {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> vehicles = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        int soldCount = 0;
        for (String input = reader.readLine(); !input.equals("End of customers!"); input = reader.readLine()) {
            String[] tokens = input.split(" ");
            String type = String.valueOf(tokens[0].charAt(0)).toLowerCase();
            String countAsString = tokens[2];
            String product = type + countAsString;
            if (vehicles.remove(product)) {
                int price = type.charAt(0) * Integer.parseInt(countAsString);
                sb.append(String.format("Yes, sold for %d$%n", price));
                soldCount++;
            } else {
                sb.append("No").append(System.lineSeparator());
            }
        }
        sb.append("Vehicles left: ");
        if (vehicles.size() > 0) {
            for (String vehicle : vehicles) {
                sb.append(vehicle).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(System.lineSeparator());
        sb.append("Vehicles sold: ").append(soldCount).append(System.lineSeparator());
        System.out.println(sb);
    }
}
