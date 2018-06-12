package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> studentsEmails = new LinkedHashMap<>();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            int index = line.lastIndexOf(" ");
            String name = line.substring(0, index);
            String phone = line.substring(index + 1);
            studentsEmails.put(name, phone);
        }
        studentsEmails.entrySet().stream()
                .filter(pair -> pair.getValue().startsWith("02") || pair.getValue().startsWith("+3592"))
                .forEach(pair -> System.out.println(pair.getKey()));
    }
}