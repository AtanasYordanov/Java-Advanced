package entities;

import entities.AntiHero;

public class Villain extends AntiHero {
    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (super.getIntelligence() * super.getSpecial()) / super.getEnergy();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("####Villain Attack Power: ").append(String.format("%.2f", this.attack()));
        return sb.toString();
    }
}
