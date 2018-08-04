package app.contracts;

import app.models.participants.BaseHero;

public interface Special {
    void trigger(BaseHero hero);

    void reset(BaseHero hero);
}
