package t02_Encapsulation.p05_PizzaCalories;

import java.util.Map;
import java.util.Set;

public class Dough {
    private static final Set<String> FLOUR_TYPES = Set.of("White", "Wholegrain");
    private static final Set<String> BAKING_TYPES = Set.of("Crispy", "Chewy", "Homemade");
    private static final Map<String, Double> FLOUR_MODIFIERS = Map.of(
            "White", 1.5,
            "Wholegrain", 1.0
    );    private static final Map<String, Double> BAKING_MODIFIERS = Map.of(
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0
    );

    private String flour;
    private String bakingTechnique;
    private int weight;

    public Dough(String flour, String bakingTechnique, int weight) {
        this.setWeight(weight);
        this.setFlour(flour);
        this.setBakingTechnique(bakingTechnique);
    }

    public void setFlour(String flour) {
        if (!FLOUR_TYPES.contains(flour)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flour = flour;
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (!BAKING_TYPES.contains(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public void setWeight(int weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double getCalories() {
        double firstModifier = FLOUR_MODIFIERS.get(this.flour);
        double secondModifier = BAKING_MODIFIERS.get(this.bakingTechnique);
        return 2 * this.weight * firstModifier * secondModifier;
    }
}
