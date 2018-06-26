package t05_InterfacesAndAbstraction.p07_FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Buyer> buyers = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Buyer buyer;
            if (tokens.length == 4) {
                String id = tokens[2];
                String birthdate = tokens[3];
                buyer = new Citizen(id, name, age, birthdate);

            } else {
                String group = tokens[2];
                buyer = new Rebel(name, age, group);
            }
            buyers.put(name, buyer);
        }
        for (String name = reader.readLine(); !name.equals("End"); name = reader.readLine()) {
            Buyer buyer = buyers.get(name);
            if (buyer != null) {
                buyer.buyFood();
            }
        }
        int totalFood = buyers.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }
}
