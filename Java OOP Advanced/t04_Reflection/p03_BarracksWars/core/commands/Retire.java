package t04_Reflection.p03_BarracksWars.core.commands;

import t04_Reflection.p03_BarracksWars.annotations.Inject;
import t04_Reflection.p03_BarracksWars.contracts.Repository;

public class Retire extends Command {

    @Inject
    private Repository repository;

    protected Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        try {
            this.repository.removeUnit(unitType);
            return String.format("%s retired!", unitType);
        }catch (IllegalArgumentException e){
           return e.getMessage();
        }
    }
}
