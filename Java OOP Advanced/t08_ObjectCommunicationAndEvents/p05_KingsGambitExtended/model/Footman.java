package t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.model;

import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.interfaces.Subject;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io.Writer;

public class Footman extends KillableUnit {

    public Footman(String name, Writer writer, Subject subject) {
        super(name, writer, subject, 2);
    }

    @Override
    public void respond() {
        super.getWriter().write(String.format("Footman %s is panicking!", super.getName()));
    }
}
