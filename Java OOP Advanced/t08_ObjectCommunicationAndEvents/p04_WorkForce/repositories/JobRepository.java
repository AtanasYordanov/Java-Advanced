package t08_ObjectCommunicationAndEvents.p04_WorkForce.repositories;

import t08_ObjectCommunicationAndEvents.p04_WorkForce.model.Job;

import java.util.LinkedHashMap;
import java.util.Map;

public class JobRepository {
    private Map<String, Job> jobs;

    public JobRepository() {
        this.jobs = new LinkedHashMap<>();
    }

    public void addJob(Job job){
        this.jobs.put(job.getName(), job);
    }

    public void removeJob(String name) {
        this.jobs.remove(name);
    }

    public Iterable<Job> getAll() {
        return this.jobs.values();
    }
}
