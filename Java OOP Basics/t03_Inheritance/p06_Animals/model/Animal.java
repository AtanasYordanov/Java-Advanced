package t03_Inheritance.p06_Animals.model;

import t03_Inheritance.p06_Animals.api.SoundProducible;
import t03_Inheritance.p06_Animals.constants.Messages;

public abstract class Animal implements SoundProducible {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                throw new IllegalArgumentException(Messages.INVALID_INPUT);
            }
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
        this.age = age;
    }

    private void setGender(String gender) {
        if (gender == null || (!gender.equals("Male") && !gender.equals("Female"))) {
            throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
        for (int i = 0; i < gender.length(); i++) {
            if (Character.isDigit(gender.charAt(i))) {
                throw new IllegalArgumentException(Messages.INVALID_INPUT);
            }
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s", getClass().getSimpleName(),
                this.name, this.age, this.gender);
    }
}
