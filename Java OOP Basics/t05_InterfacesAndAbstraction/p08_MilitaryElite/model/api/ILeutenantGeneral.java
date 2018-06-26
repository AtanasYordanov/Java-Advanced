package t05_InterfacesAndAbstraction.p08_MilitaryElite.model.api;

public interface ILeutenantGeneral extends IPrivate {
    Iterable<Soldier> getPrivates();

    void addPrivate(Soldier priv);
}
