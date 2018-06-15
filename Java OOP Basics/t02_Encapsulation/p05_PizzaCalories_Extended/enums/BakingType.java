package t02_Encapsulation.p05_PizzaCalories_Extended.enums;

public enum BakingType {
    CRISPY(0.9), CHEWY(1.1), HOMEMADE(1.0);

    private double modifier;

    BakingType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}
