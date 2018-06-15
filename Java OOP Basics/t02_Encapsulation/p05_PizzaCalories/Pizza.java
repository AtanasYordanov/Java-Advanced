package t02_Encapsulation.p05_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.validateNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void validateNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [1..10].");
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }
    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public double getTotalCalories() {
        double totalCalories = this.dough.getCalories();
        for (Topping topping : this.toppings) {
            totalCalories += topping.getCalories();
        }
        return totalCalories;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }
}
