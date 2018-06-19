package t03_Inheritance.p07_CompanyHierarchy.model;

import java.util.Date;

public class Sale {
    private String productName;
    private Date date;
    private double price;

    public Sale(String productName, Date date, double price) {
        this.productName = productName;
        this.date = date;
        this.price = price;
    }
}
