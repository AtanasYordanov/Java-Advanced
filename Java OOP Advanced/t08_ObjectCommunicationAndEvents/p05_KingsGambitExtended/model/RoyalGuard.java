package t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.model;


import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.interfaces.Subject;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io.Writer;

public class RoyalGuard extends KillableUnit {

    public RoyalGuard(String name, Writer writer, Subject subject) {
        super(name, writer, subject, 3);
    }

    @Override
    public void respond() {
        super.getWriter().write(String.format("Royal Guard %s is defending!", super.getName()));
    }
}
