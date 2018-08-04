package app.models.specials;

import app.contracts.Special;
import app.models.Config;
import app.models.participants.BaseHero;

public class Heal implements Special {

    @Override
    public void trigger(BaseHero hero) {
        if (hero.getHealth() <= hero.getStrength() * Config.HERO_HEALTH_MULTIPLIER * 0.5) {
            hero.setHealth(hero.getHealth() + hero.getIntelligence());
        }
    }

    @Override
    public void reset(BaseHero hero) {
        return;
    }
}
