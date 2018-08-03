package t08_ObjectCommunicationAndEvents.p06_MirrorImages.io;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
