package entities;

public class MarvelHero extends Hero {
    public MarvelHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return ((super.getEnergy() + super.getSpecial()) * super.getIntelligence()) / 2.5;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("####Marvel Attack Power: ").append(String.format("%.2f", this.attack()));
        return sb.toString();
    }
}
