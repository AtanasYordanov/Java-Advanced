package t06_OpenClosedLiskov.p02_Blobs.core.commands;

import t06_OpenClosedLiskov.p02_Blobs.annotations.Inject;
import t06_OpenClosedLiskov.p02_Blobs.core.services.BlobService;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Executable;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Writer;

public class StatusCommand implements Executable {
    @Inject
    private Writer writer;

    @Inject
    private BlobService blobService;

    @Override
    public void execute(String... args) {
        this.writer.writeLine(this.blobService.getStatus());
    }
}
