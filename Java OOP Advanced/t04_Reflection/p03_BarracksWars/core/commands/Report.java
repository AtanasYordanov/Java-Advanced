package t04_Reflection.p03_BarracksWars.core.commands;

import t04_Reflection.p03_BarracksWars.annotations.Inject;
import t04_Reflection.p03_BarracksWars.contracts.Repository;

public class Report extends Command {

    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
