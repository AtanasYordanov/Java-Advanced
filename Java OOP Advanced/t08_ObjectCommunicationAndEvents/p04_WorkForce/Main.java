package t08_ObjectCommunicationAndEvents.p04_WorkForce;

import t08_ObjectCommunicationAndEvents.p04_WorkForce.core.Engine;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.factories.EmployeeFactory;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.io.ConsoleReader;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.io.ConsoleWriter;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.io.Reader;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.io.Writer;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.repositories.EmployeeRepository;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.repositories.JobRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        JobRepository jobRepository = new JobRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Engine engine = new Engine(reader, writer, jobRepository, employeeRepository, employeeFactory);
        engine.run();
    }
}
