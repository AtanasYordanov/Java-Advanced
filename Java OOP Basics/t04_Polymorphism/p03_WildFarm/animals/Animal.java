package t04_Inheritance.p03_WildFarm.animals;

import t04_Inheritance.p03_WildFarm.foods.Food;

public abstract class Animal {
    private String name;
    private double weight;
    private int foodEaten;

    protected Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getFoodEaten() {
        return this.foodEaten;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();

    }
}
