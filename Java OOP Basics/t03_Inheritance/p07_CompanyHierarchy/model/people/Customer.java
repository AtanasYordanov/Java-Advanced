package t03_Inheritance.p07_CompanyHierarchy.model.people;

public class Customer extends Person {
    private double totalAmountSpent;

    public Customer(int id, String firstName, String lastName, double totalAmountSpent) {
        super(id, firstName, lastName);
        this.totalAmountSpent = totalAmountSpent;
    }

    public double getTotalAmountSpent() {
        return this.totalAmountSpent;
    }
}
