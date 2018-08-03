package t08_ObjectCommunicationAndEvents.p03_DependencyInversion.core;

import t08_ObjectCommunicationAndEvents.p03_DependencyInversion.io.Reader;
import t08_ObjectCommunicationAndEvents.p03_DependencyInversion.io.Writer;

import java.io.IOException;

public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private Calculator calculator;

    public Engine(Reader reader, Writer writer, Calculator calculator) {
        this.reader = reader;
        this.writer = writer;
        this.calculator = calculator;
    }

    @Override
    public void run() throws IOException {
        for (String line = this.reader.readLine(); !line.equals("End"); line = this.reader.readLine()) {
            String[] tokens = line.split("\\s+");
            if (tokens[0].equals("mode")) {
                char mode = tokens[1].charAt(0);
                this.calculator.changeStrategy(mode);
            } else {
                int firstOperand = Integer.parseInt(tokens[0]);
                int secondOperand = Integer.parseInt(tokens[1]);
                int result = this.calculator.performCalculation(firstOperand, secondOperand);
                this.writer.write(result);
            }
        }
    }
}
