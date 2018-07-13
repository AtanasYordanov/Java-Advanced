package t02_IteratorsAndComparators.p07_EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Person> hashSet = new HashSet<>();
        Set<Person> treeSet = new TreeSet<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            hashSet.add(person);
            treeSet.add(person);
        }
        System.out.println(hashSet.size());
        System.out.println(treeSet.size());
    }
}
