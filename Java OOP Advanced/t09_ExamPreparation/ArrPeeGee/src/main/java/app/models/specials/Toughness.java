package app.models.specials;

import app.contracts.Special;
import app.models.Config;
import app.models.participants.BaseHero;

public class Toughness implements Special {

    boolean isTriggered;

    public Toughness() {
        this.isTriggered = false;
    }

    @Override
    public void trigger(BaseHero hero) {
        if (!this.isTriggered && hero.getHealth() <= hero.getStrength() * Config.HERO_HEALTH_MULTIPLIER * 0.5) {
            hero.setStrength(hero.getStrength() + hero.getIntelligence());
            hero.setHealth(hero.getHealth() + hero.getIntelligence() * Config.HERO_HEALTH_MULTIPLIER);
            this.isTriggered = true;
        }
    }

    @Override
    public void reset(BaseHero hero) {
        if (this.isTriggered) {
            hero.setStrength(hero.getStrength() - hero.getIntelligence());
            this.isTriggered = false;
        }
    }
}
