package t08_ObjectCommunicationAndEvents.p02_KingsGambit.model;

import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.Writer;

public class Footman extends KillableUnit {

    public Footman(String name, Writer writer) {
        super(name, writer);
    }

    @Override
    public void respond() {
        super.getWriter().write(String.format("Footman %s is panicking!", super.getName()));
    }
}
