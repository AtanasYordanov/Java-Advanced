package t03_Inheritance.p03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Human> humans = new ArrayList<>();
        String[] tokens = reader.readLine().split(" ");
        String firstName = tokens[0];
        String lastName = tokens[1];
        String facultyNumber = tokens[2];
        try {
            Student student = new Student(firstName, lastName, facultyNumber);
            humans.add(student);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        tokens = reader.readLine().split(" ");
        firstName = tokens[0];
        lastName = tokens[1];
        double salary = Double.parseDouble(tokens[2]);
        double workHours = Double.parseDouble(tokens[3]);
        try {
            Worker worker = new Worker(firstName, lastName, salary, workHours);
            humans.add(worker);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        for (Human human : humans) {
            System.out.println(human);
        }
    }
}
