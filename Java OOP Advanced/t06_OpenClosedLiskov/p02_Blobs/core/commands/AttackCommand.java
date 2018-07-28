package t06_OpenClosedLiskov.p02_Blobs.core.commands;

import t06_OpenClosedLiskov.p02_Blobs.annotations.Inject;
import t06_OpenClosedLiskov.p02_Blobs.core.services.BlobService;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Executable;
import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

public class AttackCommand implements Executable {

    @Inject
    private BlobService blobService;

    @Override
    public void execute(String... args) {
        String attackerName = args[1];
        String targetName = args[2];
        Blob attacker = this.blobService.getBlobByName(attackerName);
        Blob target = this.blobService.getBlobByName(targetName);
        attacker.attack(target);
    }
}
