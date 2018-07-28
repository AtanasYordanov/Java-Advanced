package t06_OpenClosedLiskov.p02_Blobs.notifiers;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Writer;

public class BlobStateNotifier {

    private static boolean reportMode = false;
    private static Writer writer;

    public static void notify(String message) {
        if (reportMode) {
            report(message);
        }
    }

    private static void report(String message) {
        writer.writeLine(message);
    }

    public static void setWriter(Writer _writer) {
        writer = _writer;
    }

    public static void startReportMode() {
        reportMode = true;
    }
}
