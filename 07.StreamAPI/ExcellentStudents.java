package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> studentGrades = new LinkedHashMap<>();
        for (String input = reader.readLine(); !input.equals("END"); input = reader.readLine()) {
            String[] tokens = input.split(" ");
            String name = tokens[0] + " " + tokens[1];
            studentGrades.putIfAbsent(name, new ArrayList<>());
            for (int i = 2; i < tokens.length; i++) {
                int grade = Integer.parseInt(tokens[i]);
                studentGrades.get(name).add(grade);
            }
        }
        studentGrades.entrySet().stream()
                .filter(kvp -> kvp.getValue().stream().anyMatch(g -> g == 6))
                .forEach(kvp -> {
                    System.out.println(kvp.getKey());
                });
    }
}