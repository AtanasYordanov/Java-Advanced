package t06_OpenClosedLiskov.p02_Blobs.models.behaviours;

import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

public class Aggressive extends AbstractBehaviour {

    private static final int AGGRESSIVE_DAMAGE_MULTIPLY = 2;
    private static final int AGGRESSIVE_DAMAGE_DECREMENT = 5;

    private int sourceInitialDamage;

    public Aggressive() {
        super();
    }

    @Override
    public void trigger(Blob source) {
        this.sourceInitialDamage = source.getInitialDamage();
        super.setIsTriggered(true);
        this.applyTriggerEffect(source);
    }

    @Override
    public void applyRecurrentEffect(Blob source) {
        if (super.isTriggered) {
            if (super.toDelayRecurrentEffect()) {
                super.setToDelayRecurrentEffect(false);
            } else {
                source.setDamage(source.getDamage() - AGGRESSIVE_DAMAGE_DECREMENT);

                if (source.getDamage() <= this.sourceInitialDamage) {
                    source.setDamage(this.sourceInitialDamage);
                }
            }
        }
    }

    private void applyTriggerEffect(Blob source) {
        source.setDamage(source.getDamage() * AGGRESSIVE_DAMAGE_MULTIPLY);
    }
}
