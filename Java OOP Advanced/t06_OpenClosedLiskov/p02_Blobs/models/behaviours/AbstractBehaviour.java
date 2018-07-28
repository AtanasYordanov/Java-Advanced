package t06_OpenClosedLiskov.p02_Blobs.models.behaviours;


import t06_OpenClosedLiskov.p02_Blobs.interfaces.Behaviour;

public abstract class AbstractBehaviour implements Behaviour {

    protected boolean isTriggered;
    protected boolean toDelayRecurrentEffect;

    public AbstractBehaviour() {
        this.toDelayRecurrentEffect = true;
    }

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }

    protected void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    protected boolean toDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    protected void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect) {
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }
}
