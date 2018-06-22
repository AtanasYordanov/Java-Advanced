package t04_Inheritance.p03_WildFarm.animals;

import t04_Inheritance.p03_WildFarm.foods.Food;
import t04_Inheritance.p03_WildFarm.foods.Meat;

public class Mouse extends Mammal {
    public Mouse(String name, double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.eat(food);
    }
}
