package t06_OpenClosedLiskov.p02_Blobs.models.attacks;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Attack;
import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

public class Blobplode implements Attack {
    @Override
    public void execute(Blob attacker, Blob target) {
        target.respond(attacker.getDamage() * 2);
        attacker.setHealth(attacker.getHealth() % 2 == 1 ? (attacker.getHealth() + 1) / 2 : attacker.getHealth() / 2);
    }
}
