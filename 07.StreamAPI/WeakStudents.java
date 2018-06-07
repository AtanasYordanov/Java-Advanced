package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> studentGrades = new LinkedHashMap<>();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            String[] tokens = line.split(" ");
            String name = tokens[0] + " " + tokens[1];
            studentGrades.putIfAbsent(name, new ArrayList<>());
            for (int i = 2; i < tokens.length; i++) {
                int grade = Integer.parseInt(tokens[i]);
                studentGrades.get(name).add(grade);
            }
        }
        studentGrades.entrySet().stream()
                .filter(kvp -> kvp.getValue().stream()
                        .filter(g -> g <= 3)
                        .count() >= 2)
                .forEach(kvp -> {
                    System.out.println(kvp.getKey());
                });
    }
}
