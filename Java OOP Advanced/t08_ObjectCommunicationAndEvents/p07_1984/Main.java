package t08_ObjectCommunicationAndEvents.p07_1984;

import t08_ObjectCommunicationAndEvents.p07_1984.core.Engine;
import t08_ObjectCommunicationAndEvents.p07_1984.repositories.EntityRepository;
import t08_ObjectCommunicationAndEvents.p07_1984.repositories.ObserverRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ObserverRepository observerRepository = new ObserverRepository();
        EntityRepository entityRepository = new EntityRepository();
        Engine engine = new Engine(observerRepository, entityRepository);
        engine.run();
    }
}
