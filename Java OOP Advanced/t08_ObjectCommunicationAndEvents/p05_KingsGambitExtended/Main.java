package t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended;

import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.core.Engine;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io.ConsoleReader;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io.ConsoleWriter;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io.Reader;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io.Writer;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.repository.UnitRepository;

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
