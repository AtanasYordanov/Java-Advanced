package t06_OpenClosedLiskov.p02_Blobs.interfaces;

import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

public interface Attack {
    void execute(Blob attacker, Blob target);
}
