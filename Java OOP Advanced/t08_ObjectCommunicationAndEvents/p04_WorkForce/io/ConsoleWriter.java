package t08_ObjectCommunicationAndEvents.p04_WorkForce.io;

public class ConsoleWriter implements Writer {

    @Override
    public void write(Object line) {
        System.out.println(line);
    }
}
