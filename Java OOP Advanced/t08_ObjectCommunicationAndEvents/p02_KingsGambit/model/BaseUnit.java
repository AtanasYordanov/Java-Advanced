package t08_ObjectCommunicationAndEvents.p02_KingsGambit.model;


import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.Writer;

public abstract class BaseUnit {
    private Writer writer;
    private String name;

    protected BaseUnit(String name, Writer writer) {
        this.name = name;
        this.writer = writer;
    }

    public Writer getWriter() {
        return this.writer;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
