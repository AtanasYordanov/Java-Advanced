package t02_IteratorsAndComparators.p06_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> peopleByName = new TreeSet<>(new NameComparator());
        Set<Person> peopleByAge = new TreeSet<>(new AgeComparator());

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            peopleByName.add(person);
            peopleByAge.add(person);
        }

        for (Person person : peopleByName) {
            System.out.println(person);
        }

        for (Person person : peopleByAge) {
            System.out.println(person);
        }
    }
}
