package t06_OpenClosedLiskov.p02_Blobs.models.attacks;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Attack;
import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

public class PutridFart implements Attack {
    public void execute(Blob source, Blob target) {
        target.respond(source.getDamage());
    }
}
