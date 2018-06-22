package t04_Inheritance.p03_WildFarm;

import t04_Inheritance.p03_WildFarm.animals.*;
import t04_Inheritance.p03_WildFarm.foods.Food;
import t04_Inheritance.p03_WildFarm.foods.Meat;
import t04_Inheritance.p03_WildFarm.foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals = new ArrayList<>();

        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            String[] tokens = line.split(" ");
            Animal animal = getAnimal(tokens);
            tokens = reader.readLine().split(" ");
            Food food = getFood(tokens);
            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            animals.add(animal);
        }

        animals.forEach(System.out::println);
    }

    private static Food getFood(String[] tokens) {
        String type = tokens[0];
        int amount = Integer.parseInt(tokens[1]);
        switch (type) {
            case "Vegetable":
                return new Vegetable(amount);
            default:
                return new Meat(amount);
        }
    }

    private static Animal getAnimal(String[] tokens) {
        String type = tokens[0];
        String name = tokens[1];
        double weight = Double.parseDouble(tokens[2]);
        String region = tokens[3];
        switch (type) {
            case "Cat":
                String breed = tokens[4];
                return new Cat(name, weight, region, breed);
            case "Tiger":
                return new Tiger(name, weight, region);
            case "Zebra":
                return new Zebra(name, weight, region);
            default:
                return new Mouse(name, weight, region);
        }
    }
}
