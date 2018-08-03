package t08_ObjectCommunicationAndEvents.p02_KingsGambit.model;


import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.Writer;

public class RoyalGuard extends KillableUnit {

    public RoyalGuard(String name, Writer writer) {
        super(name, writer);
    }

    @Override
    public void respond() {
        super.getWriter().write(String.format("Royal Guard %s is defending!", super.getName()));
    }
}
