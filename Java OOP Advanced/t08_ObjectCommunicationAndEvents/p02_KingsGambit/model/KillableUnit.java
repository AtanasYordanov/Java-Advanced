package t08_ObjectCommunicationAndEvents.p02_KingsGambit.model;

import t08_ObjectCommunicationAndEvents.p02_KingsGambit.interfaces.Killable;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.interfaces.Observer;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.Writer;

public abstract class KillableUnit extends BaseUnit implements Killable, Observer {

    private boolean isDead;

    protected KillableUnit(String name, Writer writer) {
        super(name, writer);
        this.isDead = false;
    }

    @Override
    public void kill() {
        this.isDead = true;
    }

    public boolean isDead() {
        return this.isDead;
    }
}
