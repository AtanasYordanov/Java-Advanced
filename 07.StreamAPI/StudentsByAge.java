package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> students = new LinkedHashMap<>();
        for (String input = reader.readLine(); !input.equals("END"); input = reader.readLine()) {
            int index = input.lastIndexOf(" ");
            String name = input.substring(0, index);
            int age = Integer.parseInt(input.substring(index + 1));
            students.put(name, age);
        }
        students.entrySet().stream()
                .filter(pair -> pair.getValue() >= 18 && pair.getValue() <= 24)
                .forEach(pair -> {
                    System.out.printf("%s %d%n", pair.getKey(), pair.getValue());
                });
    }
}
