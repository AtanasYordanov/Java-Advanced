package t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.model;

import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.interfaces.Killable;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.interfaces.Observer;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.interfaces.Subject;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io.Writer;

public abstract class KillableUnit extends BaseUnit implements Killable, Observer {

    private Subject king;
    private int health;

    protected KillableUnit(String name, Writer writer, Subject subject, int health) {
        super(name, writer);
        this.king = subject;
        this.king.attachObserver(this);
        this.health = health;
    }

    @Override
    public void kill() {
        if (--this.health <= 0) {
            this.king.detachObserver(this);
        }
    }
}
