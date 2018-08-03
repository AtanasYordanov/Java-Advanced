package t08_ObjectCommunicationAndEvents.p06_MirrorImages;


import t08_ObjectCommunicationAndEvents.p06_MirrorImages.core.Engine;
import t08_ObjectCommunicationAndEvents.p06_MirrorImages.io.ConsoleReader;
import t08_ObjectCommunicationAndEvents.p06_MirrorImages.io.ConsoleWriter;
import t08_ObjectCommunicationAndEvents.p06_MirrorImages.io.Reader;
import t08_ObjectCommunicationAndEvents.p06_MirrorImages.io.Writer;
import t08_ObjectCommunicationAndEvents.p06_MirrorImages.repository.WizardRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        WizardRepository repository = new WizardRepository();
        Engine engine = new Engine(writer, reader, repository);
        engine.run();
    }
}
