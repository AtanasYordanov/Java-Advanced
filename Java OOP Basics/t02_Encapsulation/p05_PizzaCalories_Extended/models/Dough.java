package t02_Encapsulation.p05_PizzaCalories_Extended.models;

import t02_Encapsulation.p05_PizzaCalories_Extended.enums.BakingType;
import t02_Encapsulation.p05_PizzaCalories_Extended.enums.FlourType;

public class Dough extends BasicIngredient {
    private static final int WEIGHT_MIN_VALUE = 1;
    private static final int WEIGHT_MAX_VALUE = 200;
    private static final String INVALID_DOUGH_TYPE_MESSAGE = "Invalid type of dough.";
    private static final String INVALID_DOUGH_WEIGHT_MESSAGE = "Dough weight should be in the range [1..200].";

    private FlourType flour;
    private BakingType bakingTechnique;

    public Dough(String flour, String bakingTechnique, int weight) {
        this.setWeight(weight);
        this.setFlour(flour);
        this.setBakingTechnique(bakingTechnique);
    }

    public void setFlour(String flour) {
        try {
            this.flour = FlourType.valueOf(flour.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_DOUGH_TYPE_MESSAGE);
        }
    }

    public void setBakingTechnique(String bakingTechnique) {
        try {
            this.bakingTechnique = BakingType.valueOf(bakingTechnique.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_DOUGH_TYPE_MESSAGE);
        }
    }

    public void setWeight(int weight) {
        if (weight < WEIGHT_MIN_VALUE || weight > WEIGHT_MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_DOUGH_WEIGHT_MESSAGE);
        }
        super.weight = weight;
    }

    @Override
    public double getCalories() {
        double firstModifier = this.flour.getModifier();
        double secondModifier = this.bakingTechnique.getModifier();
        return DEFAULT_CALORIES * this.weight * firstModifier * secondModifier;
    }
}
