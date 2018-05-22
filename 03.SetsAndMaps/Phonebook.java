package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> phonebook = new HashMap<>();
        for (String input = reader.readLine(); !input.equals("search"); input = reader.readLine()) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phone = tokens[1];
            phonebook.put(name, phone);
        }
        for (String name = reader.readLine(); !name.equals("stop"); name = reader.readLine()) {
            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
        }
    }
}
