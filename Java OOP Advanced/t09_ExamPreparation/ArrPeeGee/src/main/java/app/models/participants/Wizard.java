package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Wizard extends BaseHero {

    public Wizard(String name) {
        super(name, Config.WIZARD_BASE_STRENGTH, Config.WIZARD_BASE_DEXTERITY, Config.WIZARD_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (super.getIntelligence() * 5) + super.getDexterity();
    }

    @Override
    public String attack(Targetable target) {
        super.triggerSpecial();
        return super.attack(target);
    }
}
