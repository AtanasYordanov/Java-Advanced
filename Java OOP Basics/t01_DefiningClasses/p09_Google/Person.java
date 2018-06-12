package t01_DefiningClasses.p09_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Relative> children;
    private List<Relative> parents;

    public Person(String name) {
        this.name = name;
        pokemons = new ArrayList<>();
        children = new ArrayList<>();
        parents = new ArrayList<>(2);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Relative parent) {
        this.parents.add(parent);
    }

    public void addChild(Relative child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name)
                .append(System.lineSeparator())
                .append("Company:")
                .append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car).append(System.lineSeparator());
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : this.pokemons) {
            sb.append(pokemon).append(System.lineSeparator());
        }
        sb.append("Parents:").append(System.lineSeparator());
        for (Relative parent : this.parents) {
            sb.append(parent).append(System.lineSeparator());
        }
        sb.append("Children:").append(System.lineSeparator());
        for (Relative child : this.children) {
            sb.append(child).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
