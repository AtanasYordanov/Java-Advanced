package t06_OpenClosedLiskov.p02_Blobs.core;

import t06_OpenClosedLiskov.p02_Blobs.core.factories.AttackFactory;
import t06_OpenClosedLiskov.p02_Blobs.core.factories.BehaviourFactory;
import t06_OpenClosedLiskov.p02_Blobs.core.factories.CommandFactory;
import t06_OpenClosedLiskov.p02_Blobs.core.repositories.BlobRepository;
import t06_OpenClosedLiskov.p02_Blobs.core.services.BlobService;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Executable;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Reader;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Writer;

import java.io.IOException;

public class Engine implements Runnable {

    private static final String SPLIT_DELIMITER = "\\s+";
    private static final String END_COMMAND = "drop";

    private BlobService blobService;
    private CommandFactory commandFactory;
    private Reader reader;

    public Engine(BlobRepository blobRepository, BehaviourFactory behaviourFactory
            , AttackFactory attackFactory, Reader reader, Writer writer) {
        this.reader = reader;
        this.blobService = new BlobService(blobRepository);
        this.commandFactory = new CommandFactory(behaviourFactory, attackFactory, this.blobService, writer);
    }

    @Override
    public void run() {
        try {
            for (String line = reader.readLine(); !line.equals(END_COMMAND); line = reader.readLine()) {
                this.blobService.updateBlobs();
                String[] tokens = line.split(SPLIT_DELIMITER);
                String commandName = tokens[0];
                Executable command = this.commandFactory.getInstance(commandName);
                if (command != null) {
                    command.execute(tokens);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
