package t06_OpenClosedLiskov.p02_Blobs;

import t06_OpenClosedLiskov.p02_Blobs.core.Engine;
import t06_OpenClosedLiskov.p02_Blobs.core.factories.AttackFactory;
import t06_OpenClosedLiskov.p02_Blobs.core.factories.BehaviourFactory;
import t06_OpenClosedLiskov.p02_Blobs.core.repositories.BlobRepository;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Reader;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Writer;
import t06_OpenClosedLiskov.p02_Blobs.io.ConsoleReader;
import t06_OpenClosedLiskov.p02_Blobs.io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {
        BlobRepository blobRepository = new BlobRepository();
        BehaviourFactory behaviourFactory = new BehaviourFactory();
        AttackFactory attackFactory = new AttackFactory();
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Engine engine = new Engine(blobRepository, behaviourFactory, attackFactory, reader, writer);
        engine.run();
    }
}
