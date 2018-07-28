package t06_OpenClosedLiskov.p02_Blobs.core.commands;

import t06_OpenClosedLiskov.p02_Blobs.annotations.Inject;
import t06_OpenClosedLiskov.p02_Blobs.core.factories.AttackFactory;
import t06_OpenClosedLiskov.p02_Blobs.core.factories.BehaviourFactory;
import t06_OpenClosedLiskov.p02_Blobs.core.services.BlobService;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Attack;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Behaviour;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Executable;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Writer;
import t06_OpenClosedLiskov.p02_Blobs.models.Blob;

public class CreateCommand implements Executable {

    @Inject
    private BehaviourFactory behaviourFactory;

    @Inject
    private AttackFactory attackFactory;

    @Inject
    private BlobService blobService;

    @Inject
    private Writer writer;

    @Override
    public void execute(String... args) {
        String name = args[1];
        int health = Integer.parseInt(args[2]);
        int damage = Integer.parseInt(args[3]);
        String behaviourName = args[4];
        String attackName = args[5];
        Behaviour behaviour = this.behaviourFactory.getInstance(behaviourName);
        Attack attack = this.attackFactory.getInstance(attackName);
        Blob blob = new Blob(name, health, damage, behaviour, attack, this.writer);
        this.blobService.addBlob(blob);
    }
}
