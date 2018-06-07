package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> studentsEmails = new LinkedHashMap<>();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            int index = line.lastIndexOf(" ");
            String name = line.substring(0, index);
            String email = line.substring(index + 1);
            studentsEmails.put(name, email);
        }
        studentsEmails.entrySet().stream()
                .filter(pair -> pair.getValue().contains("@gmail.com"))
                .forEach(pair -> System.out.println(pair.getKey()));
    }
}