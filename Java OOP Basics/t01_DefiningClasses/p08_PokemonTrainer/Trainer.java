package t01_DefiningClasses.p08_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badgesCount;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badgesCount = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadgesCount() {
        return this.badgesCount;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addBadge() {
        this.badgesCount++;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badgesCount, this.pokemons.size());
    }

    public void reducePokemonHealth() {
        for (Pokemon pokemon : pokemons) {
            pokemon.reduceHealth();
        }
        pokemons.removeIf(p -> p.getHealth() <= 0);
    }
}
