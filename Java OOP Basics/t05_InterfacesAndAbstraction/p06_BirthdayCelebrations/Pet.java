package t05_InterfacesAndAbstraction.p06_BirthdayCelebrations;

public class Pet implements Birthable {
    String name;
    String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
