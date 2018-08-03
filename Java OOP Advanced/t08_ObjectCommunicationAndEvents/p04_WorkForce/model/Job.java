package t08_ObjectCommunicationAndEvents.p04_WorkForce.model;

import t08_ObjectCommunicationAndEvents.p04_WorkForce.interfaces.Observer;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.interfaces.Subject;
import t08_ObjectCommunicationAndEvents.p04_WorkForce.model.employees.BaseEmployee;

import java.util.LinkedHashSet;
import java.util.Set;

public class Job implements Subject {

    private Set<Observer> observers;
    private String name;
    private int requiredHours;
    private BaseEmployee employee;

    public Job(String name, int requiredHours, BaseEmployee employee) {
        this.name = name;
        this.requiredHours = requiredHours;
        this.employee = employee;
        this.observers = new LinkedHashSet<>();
    }

    public void update() {
        this.requiredHours -= this.employee.getWorkHours();
        if (this.requiredHours <= 0) {
            this.notifyAllObservers();
        }
    }

    @Override
    public void attachObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : this.observers) {
            observer.update();
        }
    }

    public int getRequiredHours() {
        return this.requiredHours;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        if (this.requiredHours <= 0) {
            return String.format("Job %s done!", this.name);
        }
        return String.format("Job: %s Hours Remaining: %d", this.name, this.requiredHours);
    }
}
