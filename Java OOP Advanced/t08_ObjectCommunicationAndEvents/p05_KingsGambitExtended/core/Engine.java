package t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.core;

import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.interfaces.Attackable;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.interfaces.Runnable;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io.ConsoleReader;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io.ConsoleWriter;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io.Reader;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.io.Writer;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.model.Footman;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.model.KillableUnit;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.model.King;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.model.RoyalGuard;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.repository.UnitRepository;

import java.io.IOException;
import java.util.Arrays;

public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private UnitRepository repository;

    public Engine(Reader reader, Writer writer, UnitRepository repository) {
        this.reader = reader;
        this.writer = writer;
        this.repository = repository;
    }

    @Override
    public void run() throws IOException {
        String kingName = reader.readLine();
        King king = new King(kingName, this.writer);
        this.repository.setKing(king);

        Arrays.stream(this.reader.readLine().split("\\s+"))
                .map(s -> new RoyalGuard(s, this.writer, king))
                .forEach(s -> this.repository.addSubject(s));

        Arrays.stream(this.reader.readLine().split("\\s+"))
                .map(s -> new Footman(s, this.writer, king))
                .forEach(r -> this.repository.addSubject(r));

        for (String line = this.reader.readLine(); !line.equals("End"); line = this.reader.readLine()) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            if (command.equals("Attack")) {
                Attackable _king = this.repository.getKing();
                _king.takeAttack();
            } else if (command.equals("Kill")) {
                String unitName = tokens[1];
                KillableUnit unit = this.repository.getUnit(unitName);
                unit.kill();
            }
        }
    }
}
