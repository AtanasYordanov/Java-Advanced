package t03_Inheritance.p06_Animals.model;

import t03_Inheritance.p06_Animals.constants.Genders;

public class Tomcat extends Animal {
    private static final String SOUND = "Give me one million b***h";

    public Tomcat(String name, int age) {
        super(name, age, Genders.MALE);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }
}
