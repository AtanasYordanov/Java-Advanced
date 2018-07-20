package t04_Reflection.p03_BarracksWars.core.commands;

import t04_Reflection.p03_BarracksWars.annotations.Inject;
import t04_Reflection.p03_BarracksWars.contracts.Repository;
import t04_Reflection.p03_BarracksWars.contracts.Unit;
import t04_Reflection.p03_BarracksWars.contracts.UnitFactory;

public class Add extends Command {

    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
