package t08_ObjectCommunicationAndEvents.p02_KingsGambit.io;

public class ConsoleWriter implements Writer {

    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
