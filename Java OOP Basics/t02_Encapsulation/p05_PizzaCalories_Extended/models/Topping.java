package t02_Encapsulation.p05_PizzaCalories_Extended.models;

import t02_Encapsulation.p05_PizzaCalories_Extended.enums.ToppingType;

public class Topping extends BasicIngredient {
    private static final int WEIGHT_MIN_VALUE = 1;
    private static final int WEIGHT_MAX_VALUE = 50;
    private static final String INVALID_TOPPING_MESSAGE = "Cannot place %s on top of your pizza.";
    private static final String INVALID_TOPPING_WEIGHT_MESSAGE = "%s weight should be in the range [1..50].";
    private ToppingType type;

    public Topping(String type, int weight) {
        this.setType(type);
        this.setWeight(weight);
    }

    public void setWeight(int weight) {
        if (weight < WEIGHT_MIN_VALUE || weight > WEIGHT_MAX_VALUE) {
            throw new IllegalArgumentException(String.format(INVALID_TOPPING_WEIGHT_MESSAGE, this.type.toString()));
        }
        super.weight = weight;
    }

    public void setType(String type) {
        try {
            this.type = ToppingType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(INVALID_TOPPING_MESSAGE, type));
        }
    }

    @Override
    public double getCalories() {
        double modifier = this.type.getModifier();
        return DEFAULT_CALORIES * modifier * this.weight;
    }
}
