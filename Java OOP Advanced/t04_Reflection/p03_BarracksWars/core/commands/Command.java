package t04_Reflection.p03_BarracksWars.core.commands;

import t04_Reflection.p03_BarracksWars.contracts.Executable;

public abstract class Command implements Executable {
    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }
}
