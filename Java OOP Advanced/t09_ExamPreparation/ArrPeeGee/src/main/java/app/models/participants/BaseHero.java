package app.models.participants;

import app.contracts.Hero;
import app.contracts.Special;
import app.contracts.Targetable;
import app.models.Config;
import app.models.specials.Swiftness;

public abstract class BaseHero implements Hero {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private double health;
    private double gold;
    private Special special;

    public BaseHero(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;

        this.gold = Config.HERO_START_GOLD;
        this.health = this.strength * Config.HERO_HEALTH_MULTIPLIER;
    }

    protected BaseHero(String name, int strength, int dexterity, int intelligence) {
        this(strength, dexterity, intelligence);
        this.name = name;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }

    protected void triggerSpecial() {
        if (this.special != null) {
            this.special.trigger(this);
        }
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getDexterity() {
        return this.dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()) {
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }

    @Override
    public void takeDamage(double damage) {
        this.health -= damage;
        if (this.health < this.strength * Config.HERO_HEALTH_MULTIPLIER * 0.5) {
            if (this.special instanceof Swiftness) {
                this.special.reset(this);
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
    }

    @Override
    public void receiveReward(double reward) {
        this.gold += reward;
    }

    @Override
    public void levelUp() {
        if (this.special != null) {
            this.special.reset(this);
        }

        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold"
                        , this.getStrength(), this.getDexterity(), this.getIntelligence(), this.gold));

        return sb.toString();
    }
}
