package t02_Encapsulation.p05_PizzaCalories_Extended.enums;

public enum FlourType {
    WHITE(1.5), WHOLEGRAIN(1.0);

    private double modifier;

    FlourType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}
