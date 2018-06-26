package t05_InterfacesAndAbstraction.p01_DefineAnInterfacePerson;

public class Citizen implements Person {
    private String name;
    private int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
