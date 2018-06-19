package t03_Inheritance.p07_CompanyHierarchy.enums;

public enum Department {
    PRODUCTION, ACCOUNTING, SALES, MARKETING;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
