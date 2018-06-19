package t03_Inheritance.p07_CompanyHierarchy.model;

import t03_Inheritance.p07_CompanyHierarchy.enums.State;

import java.util.Date;

public class Project {
    private String projectName;
    private Date startDate;
    private String details;
    private State state;

    public Project(String projectName, Date startDate, String details) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.details = details;
        this.state = State.OPEN;
    }

    public State getState() {
        return this.state;
    }

    public void closeProject(){
        this.state = State.CLOSED;
    }
}
