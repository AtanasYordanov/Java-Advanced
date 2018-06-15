package t02_Encapsulation.p05_PizzaCalories;

import java.util.Map;
import java.util.Set;

public class Topping {
    private static final Set<String> TOPPING_TYPES = Set.of("Meat", "Veggies", "Cheese", "Sauce");
    private static final Map<String, Double> TOPPING_MODIFIERS = Map.of(
            "Meat", 1.2,
            "Veggies", 0.8,
            "Cheese", 1.1,
            "Sauce", 0.9
    );

    private String type;
    private int weight;

    public Topping(String type, int weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    public void setType(String type) {
        if (!TOPPING_TYPES.contains(type)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    public void setWeight(int weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.type));
        }
        this.weight = weight;
    }

    public double getCalories() {
        double modifier = TOPPING_MODIFIERS.get(this.type);
        return 2 * modifier * this.weight;
    }
}
