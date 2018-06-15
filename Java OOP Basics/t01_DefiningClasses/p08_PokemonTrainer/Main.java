package t01_DefiningClasses.p08_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        for (String line = reader.readLine(); !line.equals("Tournament"); line = reader.readLine()) {
            String[] tokens = line.split(" ");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            Trainer trainer = trainers.get(trainerName);
            trainer.addPokemon(pokemon);
        }
        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            for (Trainer trainer : trainers.values()) {
                if (trainer.hasElementType(line)) {
                    trainer.addBadge();
                } else {
                    trainer.reducePokemonHealth();
                }
            }
        }
        trainers.values().stream()
                .sorted(Comparator.comparing(Trainer::getBadgesCount, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}
