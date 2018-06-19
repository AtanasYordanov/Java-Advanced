package t03_Inheritance.p06_Animals;

import t03_Inheritance.p06_Animals.constants.Animals;
import t03_Inheritance.p06_Animals.constants.Messages;
import t03_Inheritance.p06_Animals.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String END_COMMAND = "Beast!";
    private static final String SPLIT_DELIMTIER = "\\s+";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String type = reader.readLine(); !type.equals(END_COMMAND); type = reader.readLine()) {
            String[] tokens = reader.readLine().split(SPLIT_DELIMTIER);
            try {
                Animal animal = getAnimal(type, tokens);
                System.out.println(animal);
                System.out.println(animal.produceSound());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static Animal getAnimal(String type, String[] tokens) {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String gender = tokens.length == 3 ? tokens[2] : null;
        switch (type) {
            case Animals.CAT:
                return new Cat(name, age, gender);
            case Animals.DOG:
                return new Dog(name, age, gender);
            case Animals.FROG:
                return new Frog(name, age, gender);
            case Animals.KITTEN:
                return new Kitten(name, age);
            case Animals.TOMCAT:
                return new Tomcat(name, age);
            default:
                throw new IllegalArgumentException(Messages.INVALID_INPUT);
        }
    }
}
