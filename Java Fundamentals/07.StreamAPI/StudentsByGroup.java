package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, List<String>> studentsByGroup = new HashMap<>();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            int index = line.lastIndexOf(" ");
            String name = line.substring(0, index);
            int group = Integer.parseInt(line.substring(index + 1));
            studentsByGroup.putIfAbsent(group, new ArrayList<>());
            studentsByGroup.get(group).add(name);
        }
        studentsByGroup.entrySet().stream()
                .filter(kvp -> kvp.getKey() == 2)
                .forEach(pair -> {
                    pair.getValue().stream()
                            .sorted()
                            .forEach(System.out::println);
                });
    }
}
