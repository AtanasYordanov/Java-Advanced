package t05_InterfacesAndAbstraction.p07_FoodShortage;

public class Citizen implements Identifiable, Birthable, Buyer {
    private String id;
    private String name;
    private int age;
    private String birthday;
    private int food;

    public Citizen(String id, String name, int age, String birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public int getFood() {
        return this.food;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }
}
