package entities;

import interfaces.ComicCharacter;
import interfaces.SuperPower;

import java.util.ArrayList;
import java.util.List;

public abstract class ComicCharacterImpl implements ComicCharacter {
    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> powers;

    protected ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.powers = new ArrayList<>();
    }

    public List<SuperPower> getPowers() {
        return this.powers;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getIntelligence() {
        return this.intelligence;
    }

    @Override
    public String useSuperPowers() {
        if (this.powers.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s has no super powers!", this.name));
        }
        for (SuperPower power : this.powers) {
            double powerPoints = power.getPowerPoints();
            this.energy += powerPoints;
            this.health += powerPoints * 2;
        }
        return String.format("%s used his super powers!", this.name);
    }

    private void setName(String name) {
        String regex = "[A-Za-z_]{2,12}";
        if (!name.matches(regex)) {
            throw new IllegalArgumentException("Comic Character name is not in the correct format!");
        }
        this.name = name;
    }

    private void setEnergy(int energy) {
        if (energy < 0 || energy > 300) {
            throw new IllegalArgumentException("Energy is not in the correct range!");
        }
        this.energy = energy;
    }

    private void setHealth(double health) {
        if (health < 0) {
            throw new IllegalArgumentException("Health should be a possitive number!");
        }
        this.health = health;
    }

    private void setIntelligence(double intelligence) {
        if (intelligence < 0 || intelligence > 200) {
            throw new IllegalArgumentException("Intelligence is not in the correct range!");
        }
        this.intelligence = intelligence;
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.powers.add(superPower);
    }

    @Override
    public void takeDamage(double damage) {
        this.health -= damage;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("#Name: ")
                .append(this.name)
                .append(System.lineSeparator())
                .append("##Health: ").append(String.format("%.2f", this.health))
                .append("// Energy: ").append(this.energy)
                .append("// Intelligence: ").append((String.format("%.2f", this.intelligence)))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
