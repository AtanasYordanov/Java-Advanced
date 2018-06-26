package t05_InterfacesAndAbstraction.p08_MilitaryElite.model.Impl.soldiers;

import t05_InterfacesAndAbstraction.p08_MilitaryElite.model.api.ICommando;
import t05_InterfacesAndAbstraction.p08_MilitaryElite.model.api.IMission;

import java.util.*;

public class Commando extends SpecialistSoldier implements ICommando {
    private Set<IMission> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    @Override
    public Iterable<IMission> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(IMission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Missions:");
        for (IMission mission : this.missions) {
            sb.append(System.lineSeparator()).append("  ").append(mission);
        }
        return sb.toString();
    }
}
