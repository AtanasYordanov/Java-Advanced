package t03_Inheritance.p07_CompanyHierarchy.model.people;

import t03_Inheritance.p07_CompanyHierarchy.enums.Department;

import java.math.BigDecimal;

public class Employee extends Person {
    private BigDecimal salary;
    private Department department;

    public Employee(int id, String firstName, String lastName, BigDecimal salary, Department department) {
        super(id, firstName, lastName);
        this.salary = salary;
        this.department = department;
    }

    public Employee(int id, String firstName, String lastName, Department department) {
        super(id, firstName, lastName);
        this.department = department;
    }

    public Employee(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
