package t04_Reflection.p03_BarracksWars.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
