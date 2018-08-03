package t08_ObjectCommunicationAndEvents.p02_KingsGambit;

import t08_ObjectCommunicationAndEvents.p02_KingsGambit.core.Engine;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.ConsoleReader;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.ConsoleWriter;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.Reader;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.Writer;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.repository.UnitRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        UnitRepository repository = new UnitRepository();
        Engine engine = new Engine(reader, writer, repository);
        engine.run();
    }
}
