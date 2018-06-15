package t02_Encapsulation.p05_PizzaCalories_Extended.models;

public abstract class BasicIngredient implements Ingredient {
    protected static final int DEFAULT_CALORIES = 2;

    int weight;

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
