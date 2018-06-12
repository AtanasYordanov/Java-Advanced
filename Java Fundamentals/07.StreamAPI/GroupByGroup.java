package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            int index = line.lastIndexOf(" ");
            String name = line.substring(0, index);
            int group = Integer.parseInt(line.substring(index + 1));
            students.add(new Student(name, group));
        }
        students.stream()
                .collect(Collectors.groupingBy(Student::getGroup))
                .forEach((key, value) -> System.out.printf("%d - %s%n", key
                        , value.stream()
                                .map(Student::getName)
                                .collect(Collectors.joining(", "))));
    }

    private static class Student {
        private String name;
        private int group;

        Student(String name, int group) {
            this.name = name;
            this.group = group;
        }

        String getName() {
            return name;
        }

        int getGroup() {
            return group;
        }
    }
}