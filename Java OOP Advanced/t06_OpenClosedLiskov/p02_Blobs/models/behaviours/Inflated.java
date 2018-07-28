package t06_OpenClosedLiskov.p02_Blobs.models.behaviours;

import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

public class Inflated extends AbstractBehaviour {

    private static final int INFLATED_HEALTH_BONUS = 50;
    private static final int INFLATED_HEALTH_DECREMENT = 10;

    private int ticks;

    @Override
    public void trigger(Blob source) {
        super.setIsTriggered(true);
        this.ticks = 5;
        this.applyTriggerEffect(source);
    }

    @Override
    public void applyRecurrentEffect(Blob source) {
        if (super.isTriggered) {
            if (super.toDelayRecurrentEffect()) {
                super.setToDelayRecurrentEffect(false);
            } else {
                if (ticks-- > 0) {
                    source.setHealth(source.getHealth() - INFLATED_HEALTH_DECREMENT);
                }
            }
        }
    }

    private void applyTriggerEffect(Blob source) {
        source.setHealth(source.getHealth() + INFLATED_HEALTH_BONUS);
    }
}
