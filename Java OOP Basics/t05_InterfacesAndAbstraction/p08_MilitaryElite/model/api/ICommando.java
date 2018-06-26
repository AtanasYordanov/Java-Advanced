package t05_InterfacesAndAbstraction.p08_MilitaryElite.model.api;

public interface ICommando {
    Iterable<IMission> getMissions();

    void addMission(IMission mission);
}
