package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentsEnrolledIn2014Or2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> studentGrades = new LinkedHashMap<>();
        for (String input = reader.readLine(); !input.equals("END"); input = reader.readLine()) {
            String[] tokens = input.split(" ");
            String facultyNumber = tokens[0];
            studentGrades.putIfAbsent(facultyNumber, new ArrayList<>());
            for (int i = 1; i < tokens.length; i++) {
                int grade = Integer.parseInt(tokens[i]);
                studentGrades.get(facultyNumber).add(grade);
            }
        }
        StringBuilder sb = new StringBuilder();
        studentGrades.entrySet().stream()
                .filter(kvp -> kvp.getKey().endsWith("14") || kvp.getKey().endsWith("15"))
                .forEach(kvp -> {
                    for (Integer grade : kvp.getValue()) {
                        sb.append(grade).append(" ");
                    }
                    sb.append(System.lineSeparator());
                });
        System.out.print(sb);
    }
}
