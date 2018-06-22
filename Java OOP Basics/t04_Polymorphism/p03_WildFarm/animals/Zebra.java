package t04_Inheritance.p03_WildFarm.animals;

import t04_Inheritance.p03_WildFarm.foods.Food;
import t04_Inheritance.p03_WildFarm.foods.Meat;

public class Zebra extends Mammal {
    public Zebra(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }
}
