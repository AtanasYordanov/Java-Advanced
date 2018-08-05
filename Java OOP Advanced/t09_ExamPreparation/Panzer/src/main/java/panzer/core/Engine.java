package panzer.core;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public Engine(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    public void run() throws IOException {

        for (String line = this.reader.readLine(); !line.equals("Terminate"); line = this.reader.readLine()) {

            List<String> args = Arrays.stream(line.split("\\s+"))
                    .collect(Collectors.toList());

            String command = args.get(0);

            switch (command) {
                case "Vehicle":
                    this.writer.println(this.manager.addVehicle(args));
                    break;
                case "Part":
                    this.writer.println(this.manager.addPart(args));
                    break;
                case "Inspect":
                    this.writer.println(this.manager.inspect(args));
                    break;
                case "Battle":
                    this.writer.println(this.manager.battle(args));
                    break;
            }
        }
        this.writer.println(this.manager.terminate(null));
    }
}
