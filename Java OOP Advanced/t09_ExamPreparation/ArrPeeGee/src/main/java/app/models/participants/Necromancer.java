package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Necromancer extends BaseHero {

    public Necromancer(String name) {
        super(name, Config.NECROMANCER_BASE_STRENGTH, Config.NECROMANCER_BASE_DEXTERITY, Config.NECROMANCER_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (super.getStrength() * 2) + (super.getDexterity() * 2) + (super.getIntelligence() * 2);
    }

    @Override
    public String attack(Targetable target) {
        String result = super.attack(target);
        super.triggerSpecial();
        return result;
    }
}
