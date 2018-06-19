package t03_Inheritance.p06_Animals.model;

public class Dog extends Animal {
    private static final String SOUND = "BauBau";

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }
}
