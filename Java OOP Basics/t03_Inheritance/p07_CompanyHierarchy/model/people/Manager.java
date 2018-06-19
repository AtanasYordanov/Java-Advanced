package t03_Inheritance.p07_CompanyHierarchy.model.people;

import t03_Inheritance.p07_CompanyHierarchy.enums.Department;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Manager extends Employee{

    private Set<Employee> employees;

    public Manager(int id, String firstName, String lastName, BigDecimal salary, Department department) {
        super(id, firstName, lastName, salary, department);
        this.employees = new HashSet<>();
    }
}
