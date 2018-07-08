package interfaces;

public interface ComicCharacter {
    void takeDamage(double damage);

    void boostCharacter(int energy, double health, double intelligence);

    String getName();

    int getEnergy();

    double getHealth();

    double getIntelligence();

    String useSuperPowers();

    double attack();

    double getSpecial();

    void addSuperPower(SuperPower superPower);
}
