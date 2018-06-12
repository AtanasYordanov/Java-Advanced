package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            students.add(line);
        }
        students.stream()
                .filter(s -> {
                    String[] names = s.split(" ");
                    return names[0].compareTo(names[1]) < 0;
                })
                .forEach(System.out::println);
    }
}
