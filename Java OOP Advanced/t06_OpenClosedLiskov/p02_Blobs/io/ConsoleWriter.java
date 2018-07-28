package t06_OpenClosedLiskov.p02_Blobs.io;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
