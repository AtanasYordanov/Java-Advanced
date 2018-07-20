package t04_Reflection.p03_BarracksWars.core.commands;

public class Fight extends Command {
    protected Fight(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
