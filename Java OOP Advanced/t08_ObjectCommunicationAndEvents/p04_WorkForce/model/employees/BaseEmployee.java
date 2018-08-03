package t08_ObjectCommunicationAndEvents.p04_WorkForce.model.employees;

public abstract class BaseEmployee {
    private String name;
    private int workHours;

    protected BaseEmployee(String name, int workHours) {
        this.name = name;
        this.workHours = workHours;
    }

    public String getName() {
        return this.name;
    }

    public int getWorkHours() {
        return this.workHours;
    }
}
