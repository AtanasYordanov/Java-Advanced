package t06_OpenClosedLiskov.p02_Blobs.interfaces;

import java.io.IOException;

public interface Reader {
    String readLine() throws IOException;
}
