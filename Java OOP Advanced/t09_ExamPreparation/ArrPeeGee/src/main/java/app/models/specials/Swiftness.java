package app.models.specials;

import app.contracts.Special;
import app.models.Config;
import app.models.participants.BaseHero;

public class Swiftness implements Special {

    boolean isTriggered;

    public Swiftness() {
        this.isTriggered = false;
    }

    @Override
    public void trigger(BaseHero hero) {
        if (!this.isTriggered && hero.getHealth() >= hero.getStrength() * Config.HERO_HEALTH_MULTIPLIER * 0.5) {
            hero.setDexterity(hero.getDexterity() + hero.getIntelligence());
            this.isTriggered = true;
        }
    }

    @Override
    public void reset(BaseHero hero) {
        if (this.isTriggered) {
            hero.setDexterity(hero.getDexterity() - hero.getIntelligence());
            this.isTriggered = false;
        }
    }
}
