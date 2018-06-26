package t05_InterfacesAndAbstraction.p05_BoderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Identifiable> list = new ArrayList<>();
        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            String[] tokens = line.split(" ");
            if (tokens.length == 3) {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                Identifiable citizen = new Citizen(id, name, age);
                list.add(citizen);
            } else {
                String model = tokens[0];
                String id = tokens[1];
                Identifiable robot = new Robot(id, model);
                list.add(robot);
            }
        }
        String fakeIdLastDigits = reader.readLine();
        list.stream()
                .filter(i -> i.getId().endsWith(fakeIdLastDigits))
                .forEach(i -> System.out.println(i.getId()));
    }
}
