package t05_InterfacesAndAbstraction.p02_MultipleImplementation;

import javax.management.ImmutableDescriptor;

public class Citizen implements Person, Identifiable, Birthable {
    private String id;
    private String name;
    private int age;
    private String birthdate;

    public Citizen(String name, int age,String id, String birthdate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthdate() {
        return this.birthdate;
    }
}
