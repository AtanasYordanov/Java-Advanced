package t05_InterfacesAndAbstraction.p08_MilitaryElite.model.Impl.soldiers;

import t05_InterfacesAndAbstraction.p08_MilitaryElite.model.api.IEngineer;
import t05_InterfacesAndAbstraction.p08_MilitaryElite.model.api.IRepair;

import java.util.*;

public class Engineer extends SpecialistSoldier implements IEngineer {
    private Set<IRepair> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public Iterable<IRepair> getRepairs() {
        return this.repairs;
    }

    @Override
    public void addRepair(IRepair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Repairs:");
        for (IRepair repair : this.repairs) {
            sb.append(System.lineSeparator()).append("  ").append(repair);
        }
        return sb.toString();
    }
}
