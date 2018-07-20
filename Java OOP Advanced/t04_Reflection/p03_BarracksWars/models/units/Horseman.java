package t04_Reflection.p03_BarracksWars.models.units;

public class Horseman extends AbstractUnit {
    private static final int HORSEMAN_HEALHT = 50;
    private static final int HORSEMAN_DAMAGE = 10;

    public Horseman() {
        super(HORSEMAN_HEALHT, HORSEMAN_DAMAGE);
    }
}
