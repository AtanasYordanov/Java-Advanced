package t01_DefiningClasses.p08_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
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
            Trainer trainer = trainers.getOrDefault(trainerName, new Trainer(trainerName));
            trainer.getPokemons().add(pokemon);
            trainers.put(trainerName, trainer);
        }
        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            final String element = line;
            for (Trainer trainer : trainers.values()) {
                boolean hasElementType = trainer.getPokemons().stream()
                        .anyMatch(p -> p.getElement().equals(element));
                if (hasElementType) {
                    trainer.addBadge();
                } else {
                    List<Pokemon> pokemons = trainer.getPokemons();
                    for (int i = pokemons.size() - 1; i >= 0; i--) {
                        pokemons.get(i).reduceHealth();
                    }
                    pokemons.removeIf(p -> p.getHealth() <= 0);
                }
            }
        }
        trainers.values().stream()
                .sorted(Comparator.comparing(Trainer::getBadgesCount, Comparator.reverseOrder()))
                .forEach(System.out::println);
    }
}
