package t05_InterfacesAndAbstraction.p06_BirthdayCelebrations;

public class Citizen implements Identifiable, Birthable {
    private String id;
    private String name;
    private int age;
    private String birthday;

    public Citizen(String id, String name, int age, String birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
