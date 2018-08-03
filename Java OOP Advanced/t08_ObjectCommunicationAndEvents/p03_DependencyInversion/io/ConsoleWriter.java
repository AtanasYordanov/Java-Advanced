package t08_ObjectCommunicationAndEvents.p03_DependencyInversion.io;

public class ConsoleWriter implements Writer {

    @Override
    public void write(Object line) {
        System.out.println(line);
    }
}
