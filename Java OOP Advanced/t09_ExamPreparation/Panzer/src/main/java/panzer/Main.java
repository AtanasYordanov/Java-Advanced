package panzer;

import panzer.contracts.BattleOperator;
import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.core.Engine;
import panzer.core.ManagerImpl;
import panzer.core.PanzerBattleOperator;
import panzer.io.ConsoleReader;
import panzer.io.ConsoleWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        BattleOperator battleOperator = new PanzerBattleOperator();
        Manager manager = new ManagerImpl(battleOperator);
        Engine engine = new Engine(reader, writer, manager);
        engine.run();
    }
}
