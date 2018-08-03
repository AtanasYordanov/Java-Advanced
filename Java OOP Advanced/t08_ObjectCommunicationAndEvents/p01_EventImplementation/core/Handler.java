package t08_ObjectCommunicationAndEvents.p01_EventImplementation.core;

import t08_ObjectCommunicationAndEvents.p01_EventImplementation.io.Writer;

public class Handler implements NameChangeListener {

    private Writer writer;

    public Handler(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void handleChangedName(NameChange event) {
        this.writer.write("Dispatcher's name changed to " + event.getName() + ".");
    }
}
