package t02_Encapsulation.p05_PizzaCalories_Extended.enums;

public enum ToppingType {
    MEAT(1.2), VEGGIES(0.8), CHEESE(1.1), SAUCE(0.9);

    private double modifier;

    ToppingType(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
