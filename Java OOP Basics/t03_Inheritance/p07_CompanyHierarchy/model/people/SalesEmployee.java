package t03_Inheritance.p07_CompanyHierarchy.model.people;

import t03_Inheritance.p07_CompanyHierarchy.enums.Department;
import t03_Inheritance.p07_CompanyHierarchy.model.Sale;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class SalesEmployee extends RegularEmployee{
    private Set<Sale> sales;


    public SalesEmployee(int id, String firstName, String lastName, BigDecimal salary, Department department) {
        super(id, firstName, lastName, salary, department);
        this.sales = new HashSet<>();
    }

    public SalesEmployee(int id, String firstName, String lastName, Department department) {
        super(id, firstName, lastName, department);
    }

    public Set<Sale> getSales() {
        return this.sales;
    }
}
