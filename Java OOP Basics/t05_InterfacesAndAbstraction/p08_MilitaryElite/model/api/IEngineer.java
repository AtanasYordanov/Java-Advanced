package t05_InterfacesAndAbstraction.p08_MilitaryElite.model.api;

public interface IEngineer extends ISpecialistSoldier {
    Iterable<IRepair> getRepairs();

    void addRepair(IRepair repair);
}
