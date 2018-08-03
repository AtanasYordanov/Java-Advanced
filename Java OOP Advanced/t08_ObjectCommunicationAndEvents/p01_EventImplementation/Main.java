package t08_ObjectCommunicationAndEvents.p01_EventImplementation;

import t08_ObjectCommunicationAndEvents.p01_EventImplementation.core.Dispatcher;
import t08_ObjectCommunicationAndEvents.p01_EventImplementation.core.Handler;
import t08_ObjectCommunicationAndEvents.p01_EventImplementation.core.NameChangeListener;
import t08_ObjectCommunicationAndEvents.p01_EventImplementation.io.ConsoleReader;
import t08_ObjectCommunicationAndEvents.p01_EventImplementation.io.ConsoleWriter;
import t08_ObjectCommunicationAndEvents.p01_EventImplementation.io.Reader;
import t08_ObjectCommunicationAndEvents.p01_EventImplementation.io.Writer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener listener = new Handler(writer);
        dispatcher.addNameChangeListener(listener);

        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            dispatcher.setName(line);
        }
    }
}