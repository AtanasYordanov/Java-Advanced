package t05_InterfacesAndAbstraction.p08_MilitaryElite.model.Impl.soldiers;

import t05_InterfacesAndAbstraction.p08_MilitaryElite.model.api.Soldier;

public abstract class BaseSoldier implements Soldier {
    private String id;
    private String firstName;
    private String lastName;

    protected BaseSoldier(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(this.firstName).append(" ").append(this.lastName).append(" Id: ").append(this.id);
        return sb.toString();
    }
}
