package app.models.participants;

import app.models.Config;

public class Warrior extends BaseHero {

    public Warrior() {
        super(Config.WARRIOR_BASE_STRENGTH, Config.WARRIOR_BASE_DEXTERITY, Config.WARRIOR_BASE_INTELLIGENCE);
    }

    public Warrior(String name) {
        super(name, Config.WARRIOR_BASE_STRENGTH, Config.WARRIOR_BASE_DEXTERITY, Config.WARRIOR_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (super.getStrength() * 2) + super.getDexterity();
    }

    @Override
    public void takeDamage(double damage) {
        super.takeDamage(damage);
        super.triggerSpecial();
    }
}
