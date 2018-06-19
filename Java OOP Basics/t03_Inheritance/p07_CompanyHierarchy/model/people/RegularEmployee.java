package t03_Inheritance.p07_CompanyHierarchy.model.people;

import t03_Inheritance.p07_CompanyHierarchy.enums.Department;

import java.math.BigDecimal;

public class RegularEmployee extends Employee{

    public RegularEmployee(int id, String firstName, String lastName, BigDecimal salary, Department department) {
        super(id, firstName, lastName, salary, department);
    }

    public RegularEmployee(int id, String firstName, String lastName, Department department) {
        super(id, firstName, lastName, department);
    }

    public RegularEmployee(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}
