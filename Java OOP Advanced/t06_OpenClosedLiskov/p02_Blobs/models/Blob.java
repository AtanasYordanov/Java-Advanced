package t06_OpenClosedLiskov.p02_Blobs.models;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Attack;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Behaviour;
import t06_OpenClosedLiskov.p02_Blobs.notifiers.BlobStateNotifier;

public class Blob {

    private String name;
    private int currentHealth;
    private int damage;
    private Behaviour behavior;
    private Attack attack;

    private int initialHealth;
    private int initialDamage;

    public Blob(String name, int health, int damage, Behaviour behavior, Attack attack) {
        this.name = name;
        this.currentHealth = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;
        this.initialHealth = health;
        this.initialDamage = damage;
    }

    public int getHealth() {
        return this.currentHealth;
    }

    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth <= 0) {
            this.currentHealth = 0;
            BlobStateNotifier.notify(String.format("Blob %s was killed", this.name));
        }

        if (this.currentHealth <= this.initialHealth / 2 && !this.behavior.isTriggered()) {
            this.triggerBehavior();
            BlobStateNotifier.notify(String.format("Blob %s toggled %sBehavior"
                    , this.name, this.behavior.getClass().getSimpleName()));
        }
    }

    public int getInitialDamage() {
        return this.initialDamage;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    public void attack(Blob target) {
        this.attack.execute(this, target);
    }

    public void respond(int damage) {
        int currentHealth = this.getHealth();
        currentHealth -= damage;
        this.setHealth(currentHealth);
    }

    private void triggerBehavior() {
        this.behavior.trigger(this);
    }

    public String getName() {
        return this.name;
    }

    public void update() {
        this.behavior.applyRecurrentEffect(this);
    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("Blob %s KILLED", this.getName());
        }
        return String.format("Blob %s: %s HP, %s Damage"
                , this.getName(), this.getHealth(), this.getDamage());
    }
}
