package t02_Encapsulation.p05_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        String pizzaName = tokens[1];
        int numberOfToppings = Integer.parseInt(tokens[2]);
        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);
            tokens = reader.readLine().split(" ");
            String flour = tokens[1];
            String bakingTechnique = tokens[2];
            int weight = Integer.parseInt(tokens[3]);
            Dough dough = new Dough(flour, bakingTechnique, weight);
            pizza.setDough(dough);
            for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
                tokens = line.split(" ");
                String toppingType = tokens[1];
                weight = Integer.parseInt(tokens[2]);
                Topping topping = new Topping(toppingType, weight);
                pizza.addTopping(topping);
            }
            System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getTotalCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
