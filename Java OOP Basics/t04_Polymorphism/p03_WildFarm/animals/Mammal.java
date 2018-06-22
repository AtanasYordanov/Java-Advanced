package t04_Inheritance.p03_WildFarm.animals;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String name, double weight, String livingRegion) {
        super(name, weight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]"
                , getClass().getSimpleName()
                , super.getName()
                , df.format(super.getWeight())
                , this.livingRegion
                , super.getFoodEaten());
    }
}
