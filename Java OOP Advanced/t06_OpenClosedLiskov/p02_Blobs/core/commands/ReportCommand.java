package t06_OpenClosedLiskov.p02_Blobs.core.commands;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Executable;
import t06_OpenClosedLiskov.p02_Blobs.notifiers.BlobStateNotifier;

public class ReportCommand implements Executable {

    @Override
    public void execute(String[] args) {
        BlobStateNotifier.startReportMode();
    }
}
