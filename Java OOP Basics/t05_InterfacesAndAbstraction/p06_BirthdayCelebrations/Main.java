package t05_InterfacesAndAbstraction.p06_BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Birthable> list = new ArrayList<>();
        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            String[] tokens = line.split(" ");
            if (tokens[0].equals("Pet")) {
                String name = tokens[1];
                String birthday = tokens[2];
                Birthable pet = new Pet(name, birthday);
                list.add(pet);
            } else if (tokens[0].equals("Citizen")) {
                String name = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String id = tokens[3];
                String birthday = tokens[4];
                Birthable citizen = new Citizen(id, name, age, birthday);
                list.add(citizen);
            }
        }
        String year = reader.readLine();
        list.stream()
                .filter(b -> b.getBirthday().endsWith(year))
                .forEach(b -> System.out.println(b.getBirthday()));
    }
}
