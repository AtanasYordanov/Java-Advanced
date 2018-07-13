package t02_IteratorsAndComparators.p05_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();

        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            Person person = new Person(name, age, town);
            people.add(person);
        }
        int index = Integer.parseInt(reader.readLine());
        Person person = people.get(index - 1);

        int equalCount = 0;

        for (Person p : people) {
            if (person.compareTo(p) == 0) {
                equalCount++;
            }
        }
        if (equalCount == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d%n", equalCount, people.size() - equalCount, people.size());
        }
    }
}
