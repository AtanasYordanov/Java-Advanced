package t03_Inheritance.p06_Animals.model;

import t03_Inheritance.p06_Animals.constants.Genders;

public class Kitten extends Cat {
    private static final String SOUND = "Miau";

    public Kitten(String name, int age) {
        super(name, age, Genders.FEMALE);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }
}
