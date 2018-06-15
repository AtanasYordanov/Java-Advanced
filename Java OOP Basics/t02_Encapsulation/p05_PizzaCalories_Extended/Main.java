package t02_Encapsulation.p05_PizzaCalories_Extended;

import t02_Encapsulation.p05_PizzaCalories_Extended.models.Dough;
import t02_Encapsulation.p05_PizzaCalories_Extended.models.Ingredient;
import t02_Encapsulation.p05_PizzaCalories_Extended.models.Pizza;
import t02_Encapsulation.p05_PizzaCalories_Extended.models.Topping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String END_COMMAND = "END";
    private static final String SPLIT_DELIMITER = "\\s+";
    private static final int PIZZA_NAME_INDEX = 1;
    private static final int FLOUR_TYPE_INDEX = 1;
    private static final int TOPPING_TYPE_INDEX = 1;
    private static final int NUMBER_OF_TOPPING_INDEX = 2;
    private static final int BAKING_TECHNIQUE_INDEX = 2;
    private static final int TOPPING_WEIGHT_INDEX = 2;
    private static final int DOUGH_WEIGHT_INDEX = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(SPLIT_DELIMITER);
        String pizzaName = tokens[PIZZA_NAME_INDEX];
        int numberOfToppings = Integer.parseInt(tokens[NUMBER_OF_TOPPING_INDEX]);
        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);
            tokens = reader.readLine().split(SPLIT_DELIMITER);
            String flour = tokens[FLOUR_TYPE_INDEX];
            String bakingTechnique = tokens[BAKING_TECHNIQUE_INDEX];
            int weight = Integer.parseInt(tokens[DOUGH_WEIGHT_INDEX]);
            Ingredient dough = new Dough(flour, bakingTechnique, weight);
            pizza.setDough(dough);
            for (String line = reader.readLine(); !line.equals(END_COMMAND); line = reader.readLine()) {
                tokens = line.split(SPLIT_DELIMITER);
                String toppingType = tokens[TOPPING_TYPE_INDEX];
                weight = Integer.parseInt(tokens[TOPPING_WEIGHT_INDEX]);
                Ingredient topping = new Topping(toppingType, weight);
                pizza.addTopping(topping);
            }
            System.out.println(pizza);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
