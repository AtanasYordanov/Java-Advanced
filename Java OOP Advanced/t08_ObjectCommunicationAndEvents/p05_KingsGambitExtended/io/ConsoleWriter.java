package t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
