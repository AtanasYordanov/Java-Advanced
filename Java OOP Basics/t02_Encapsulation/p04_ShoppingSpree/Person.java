package t02_Encapsulation.p04_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int money;
    private List<Product> products;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.matches("\\s+")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buy(Product product) {
        int cost = product.getCost();
        if (cost > this.money) {
            throw new IllegalArgumentException(String.format("%s can't afford %s"
                    , this.name, product.getName()));
        }
        this.products.add(product);
        this.money -= cost;
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return String.format("%s - Nothing bought", this.name);
        }
        return String.format("%s - %s", this.name
                , this.products.stream().map(Product::getName).collect(Collectors.joining(", ")));
    }
}
