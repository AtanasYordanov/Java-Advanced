package t08_ObjectCommunicationAndEvents.p02_KingsGambit.core;

import t08_ObjectCommunicationAndEvents.p02_KingsGambit.interfaces.Attackable;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.interfaces.Runnable;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.ConsoleReader;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.ConsoleWriter;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.Reader;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.io.Writer;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.model.Footman;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.model.KillableUnit;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.model.King;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.model.RoyalGuard;
import t08_ObjectCommunicationAndEvents.p02_KingsGambit.repository.UnitRepository;

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
                .map(s -> new RoyalGuard(s, this.writer))
                .forEach(r -> {
                    this.repository.addSubject(r);
                    king.attachObserver(r);
                });

        Arrays.stream(this.reader.readLine().split("\\s+"))
                .map(s -> new Footman(s, this.writer))
                .forEach(r -> {
                    this.repository.addSubject(r);
                    king.attachObserver(r);
                });

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
                king.detachObserver(unit);
            }
        }
    }
}
