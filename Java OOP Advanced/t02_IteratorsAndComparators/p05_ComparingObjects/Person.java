package t02_IteratorsAndComparators.p05_ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        int comp = this.name.compareTo(o.name);
        if (comp == 0) {
            comp = Integer.compare(this.age, o.age);
            if (comp == 0) {
                comp = this.town.compareTo(o.town);
            }
        }
        return comp;
    }
}
