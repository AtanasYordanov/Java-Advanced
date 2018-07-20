package t04_Reflection.p03_BarracksWars.core.commands;

import t04_Reflection.p03_BarracksWars.contracts.Executable;
import t04_Reflection.p03_BarracksWars.contracts.Repository;
import t04_Reflection.p03_BarracksWars.contracts.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
//    private Repository repository;
//    private UnitFactory unitFactory;

    protected Command(String[] data) {
        this.data = data;
//        this.repository = repository;
//        this.unitFactory = unitFactory;
    }

//    protected Repository getRepository() {
//        return this.repository;
//    }
//
//    protected UnitFactory getUnitFactory() {
//        return this.unitFactory;
//    }

    protected String[] getData() {
        return this.data;
    }
}
