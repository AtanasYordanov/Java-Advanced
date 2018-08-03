package t08_ObjectCommunicationAndEvents.p03_DependencyInversion;

import t08_ObjectCommunicationAndEvents.p03_DependencyInversion.core.Calculator;
import t08_ObjectCommunicationAndEvents.p03_DependencyInversion.core.Engine;
import t08_ObjectCommunicationAndEvents.p03_DependencyInversion.core.PrimitiveCalculator;
import t08_ObjectCommunicationAndEvents.p03_DependencyInversion.io.ConsoleReader;
import t08_ObjectCommunicationAndEvents.p03_DependencyInversion.io.ConsoleWriter;
import t08_ObjectCommunicationAndEvents.p03_DependencyInversion.io.Reader;
import t08_ObjectCommunicationAndEvents.p03_DependencyInversion.io.Writer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Calculator calculator = new PrimitiveCalculator();
        Engine engine = new Engine(reader, writer, calculator);
        engine.run();
    }
}
