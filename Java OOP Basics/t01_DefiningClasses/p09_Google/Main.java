package t01_DefiningClasses.p09_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new HashMap<>();
        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            String[] tokens = line.split(" ");
            String name = tokens[0];
            String type = tokens[1];
            people.putIfAbsent(name, new Person(name));
            Person person = people.get(name);
            switch (type) {
                case "car":
                    String carModel = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModel, speed);
                    person.setCar(car);
                    break;
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    person.addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Relative parent = new Relative(parentName, parentBirthday);
                    person.addParent(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Relative child = new Relative(childName, childBirthday);
                    person.addChild(child);
                    break;
            }
        }
        String targetPerson = reader.readLine();
        Person person = people.get(targetPerson);
        System.out.println(person);
    }
}
