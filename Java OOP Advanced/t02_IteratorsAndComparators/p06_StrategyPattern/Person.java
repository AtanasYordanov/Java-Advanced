package t02_IteratorsAndComparators.p06_StrategyPattern;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(Person o) {
        int comp = this.name.compareTo(o.name);
        if (comp == 0) {
            comp = Integer.compare(this.age, o.age);
        }
        return comp;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.age);
    }
}
