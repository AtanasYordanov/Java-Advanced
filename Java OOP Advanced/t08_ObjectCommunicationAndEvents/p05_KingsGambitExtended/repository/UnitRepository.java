package t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.repository;

import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.interfaces.Attackable;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.model.KillableUnit;
import t08_ObjectCommunicationAndEvents.p05_KingsGambitExtended.model.King;

import java.util.LinkedHashMap;
import java.util.Map;

public class UnitRepository {

    private King king;
    private Map<String, KillableUnit> units;

    public UnitRepository() {
        this.units = new LinkedHashMap<>();
    }

    public KillableUnit getUnit(String name) {
        return this.units.get(name);
    }

    public Attackable getKing() {
        return this.king;
    }

    public void addSubject(KillableUnit subject) {
        this.units.put(subject.getName(), subject);
    }

    public void setKing(King king) {
        this.king = king;
    }
}
