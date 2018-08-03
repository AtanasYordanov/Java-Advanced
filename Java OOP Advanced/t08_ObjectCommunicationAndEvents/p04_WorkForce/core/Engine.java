package t08_ObjectCommunicationAndEvents.p04_WorkForce.core;

import t08_ObjectCommunicationAndEvents.p04_WorkForce.factories.EmployeeFactory;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.interfaces.Runnable;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.io.Reader;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.io.Writer;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.model.JobObserver;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.model.employees.BaseEmployee;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.model.Job;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.repositories.EmployeeRepository;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.repositories.JobRepository;

import java.io.IOException;

public class Engine implements Runnable {

    private Reader reader;
    private Writer writer;
    private JobRepository jobRepository;
    private EmployeeRepository employeeRepository;
    private EmployeeFactory employeeFactory;


    public Engine(Reader reader, Writer writer, JobRepository jobRepository, EmployeeRepository employeeRepository, EmployeeFactory employeeFactory) {
        this.reader = reader;
        this.writer = writer;
        this.jobRepository = jobRepository;
        this.employeeRepository = employeeRepository;
        this.employeeFactory = employeeFactory;
    }


    @Override
    public void run() throws IOException {
        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Job":
                    String jobName = tokens[1];
                    int hours = Integer.parseInt(tokens[2]);
                    String employeeName = tokens[3];
                    BaseEmployee employee = this.employeeRepository.getEmployee(employeeName);
                    Job job = new Job(jobName, hours, employee);
                    new JobObserver(this.writer, job);
                    this.jobRepository.addJob(job);
                    break;
                case "Pass":
                    this.jobRepository.getAll().forEach(Job::update);
                    break;
                case "Status":
                    this.jobRepository.getAll().forEach(j -> {
                        if (j.getRequiredHours() > 0) {
                            this.writer.write(j);
                        }
                    });
                    break;
                default:
                    BaseEmployee newEmployee = this.employeeFactory.getEmployee(tokens[0], tokens[1]);
                    this.employeeRepository.addEmployee(newEmployee);
            }
        }
    }
}
