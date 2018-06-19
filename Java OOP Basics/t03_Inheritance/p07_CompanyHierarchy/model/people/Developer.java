package t03_Inheritance.p07_CompanyHierarchy.model.people;

import t03_Inheritance.p07_CompanyHierarchy.enums.Department;
import t03_Inheritance.p07_CompanyHierarchy.model.Project;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Developer extends RegularEmployee {
    private Set<Project> projects;

    public Developer(int id, String firstName, String lastName, BigDecimal salary, Department department) {
        super(id, firstName, lastName, salary, department);
        this.projects = new HashSet<>();
    }

    public Developer(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.projects = new HashSet<>();
    }

    public Set<Project> getProjects() {
        return this.projects;
    }
}
