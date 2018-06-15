package t02_Encapsulation.p05_PizzaCalories_Extended.models;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private static final int MIN_NUMBER_OF_TOPPINGS = 0;
    private static final int MAX_NUMBER_OF_TOPPINGS = 10;
    private static final int MAX_NAME_LENGTH = 15;
    private static final String INVALID_NUMBER_OF_TOPPINGS_MESSAGE = "Number of toppings should be in range [0..10].";
    private static final String INVALID_PIZZA_NAME_MESSAGE = "Pizza name should be between 1 and 15 symbols.";
    private static final String TO_STRING_TEXT = "%s - %.2f";

    private String name;
    private Ingredient dough;
    private List<Ingredient> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.validateNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void validateNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < MIN_NUMBER_OF_TOPPINGS || numberOfToppings > MAX_NUMBER_OF_TOPPINGS) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_TOPPINGS_MESSAGE);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_PIZZA_NAME_MESSAGE);
        }
        this.name = name;
    }

    public void setDough(Ingredient dough) {
        this.dough = dough;
    }

    public double getTotalCalories() {
        double totalCalories = this.dough.getCalories();
        for (Ingredient topping : this.toppings) {
            totalCalories += topping.getCalories();
        }
        return totalCalories;
    }

    public void addTopping(Ingredient topping) {
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEXT, this.name, this.getTotalCalories());
    }
}
