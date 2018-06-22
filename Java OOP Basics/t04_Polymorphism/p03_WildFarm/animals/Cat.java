package t04_Inheritance.p03_WildFarm.animals;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat(String name, double weight, String region, String breed) {
        super(name, weight, region);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]"
                , getClass().getSimpleName()
                , super.getName()
                , this.breed
                , df.format(super.getWeight())
                , this.getLivingRegion(), super.getFoodEaten());
    }
}
