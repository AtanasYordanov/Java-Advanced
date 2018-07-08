package manager;

import interfaces.Arena;
import interfaces.ComicCharacter;
import interfaces.Manager;
import interfaces.SuperPower;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarManager implements Manager {
    private Map<String, ComicCharacter> heroes;
    private Map<String, ComicCharacter> antiHeroes;
    private Map<String, Arena> arenas;
    private Map<String, ComicCharacter> assignedCharacters;
    private Map<String, SuperPower> superPowers;
    private Map<String, SuperPower> assignedSuperPowers;
    private Map<String, List<ComicCharacter>> arenasFighters;
    private int heroesBattlesWon;
    private int antiheroesBattlesWon;

    public WarManager() {
        this.assignedCharacters = new HashMap<>();
        this.heroes = new HashMap<>();
        this.antiHeroes = new HashMap<>();
        this.arenas = new HashMap<>();
        this.superPowers = new HashMap<>();
        this.assignedSuperPowers = new HashMap<>();
        this.arenasFighters = new HashMap<>();
        heroesBattlesWon = 0;
        antiheroesBattlesWon = 0;
    }

    @Override
    public String checkComicCharacter(String characterName) {
        ComicCharacter comicCharacter = this.heroes.get(characterName);
        if (comicCharacter == null) {
            comicCharacter = this.antiHeroes.get(characterName);
            if (comicCharacter == null) {
                return String.format("Sorry, fans! %s doesn't exist in out comics!", characterName);
            }
        }
        if (comicCharacter.getHealth() <= 0) {
            return String.format("%s has fallen in battle!", characterName);
        }
        return comicCharacter.toString();
    }

    @Override
    public String addHero(ComicCharacter hero) {
        if (this.heroes.containsKey(hero.getName())){
            ComicCharacter comicCharacter = this.heroes.get(hero.getName());
            comicCharacter.boostCharacter(hero.getEnergy(), hero.getHealth(), hero.getIntelligence());
            return String.format("%s evolved!", hero.getName());
        }
        this.heroes.put(hero.getName(), hero);
        return String.format("%s is ready for battle!", hero.getName());
    }

    @Override
    public String addAntiHero(ComicCharacter hero) {
        if (this.antiHeroes.containsKey(hero.getName())){
            ComicCharacter comicCharacter = this.antiHeroes.get(hero.getName());
            comicCharacter.boostCharacter(hero.getEnergy(), hero.getHealth(), hero.getIntelligence());
            return String.format("%s is getting stronger!", hero.getName());
        }
        this.antiHeroes.put(hero.getName(), hero);
        return String.format("%s is ready for destruction!", hero.getName());
    }

    @Override
    public String addArena(Arena arena) {
        if (this.arenas.containsKey(arena.getArenaName())){
            return "A battle is about to start there!";
        }
        this.arenas.put(arena.getArenaName(), arena);
        this.arenasFighters.put(arena.getArenaName(), new ArrayList<>());
        return String.format("%s is becoming a fighting ground!", arena.getArenaName());
    }

    @Override
    public String addHeroToArena(String arena, String hero) {
        if (this.assignedCharacters.containsKey(hero)){
            return String.format("%s is fighting!", hero);
        }
        ComicCharacter character = this.heroes.get(hero);
        if (character.getHealth() <= 0){
           return String.format("%s is dead!", hero);
        }
        Arena arenaClass = this.arenas.get(arena);
        if (arenaClass.isArenaFull()){
            return "Arena is full!";
        }
        arenaClass.addHero(character);
        this.assignedCharacters.put(character.getName(), character);
        this.arenasFighters.get(arena).add(character);
        return String.format("%s is fighting for your freedom in %s!", hero, arena);
    }

    @Override
    public String addAntiHeroToArena(String arena, String antiHero) {
        if (this.assignedCharacters.containsKey(antiHero)){
            return String.format("%s is fighting!", antiHero);
        }
        ComicCharacter character = this.antiHeroes.get(antiHero);
        if (character.getHealth() <= 0){
            return String.format("%s is dead!", antiHero);
        }
        Arena arenaClass = this.arenas.get(arena);
        if (arenaClass.isArenaFull()){
            return "Arena is full!";
        }
        arenaClass.addAntiHero(character);
        this.assignedCharacters.put(character.getName(), character);
        this.arenasFighters.get(arena).add(character);
        return String.format("%s and his colleagues are trying to take over %s!", antiHero, arena);
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        if (this.superPowers.containsKey(superPower.getName())){
            return "This super power already exists!";
        }
        this.superPowers.put(superPower.getName(), superPower);
        return String.format("%s added to pool!", superPower.getName());
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        SuperPower superPowerClass = this.superPowers.get(superPower);
        if (this.assignedSuperPowers.containsKey(superPower) || superPowerClass == null){
            return String.format("%s already assigned!", superPower);
        }
        ComicCharacter character = this.heroes.getOrDefault(comicCharacter, this.antiHeroes.get(comicCharacter));
        character.addSuperPower(superPowerClass);
        this.assignedSuperPowers.put(superPower, superPowerClass);
        return String.format("%s has a new super power!", comicCharacter);
    }

    @Override
    public String usePowers(String comicCharacter) {
        ComicCharacter character = this.heroes.getOrDefault(comicCharacter, this.antiHeroes.get(comicCharacter));
        return character.useSuperPowers();
    }

    @Override
    public String startBattle(String arena) {
        Arena arenaClass = this.arenas.get(arena);
        if (this.arenasFighters.get(arena).size() == 0){
            return "SAFE ZONE!";
        }
        if  (arenaClass.fightHeroes()){
            this.heroesBattlesWon++;
            this.arenasFighters.get(arena).forEach(c ->this.assignedCharacters.remove(c.getName()));
            this.arenas.remove(arena);
            this.arenasFighters.remove(arena);
            return String.format("Heroes won the battle of %s!", arena);
        }
        this.antiheroesBattlesWon++;
        this.arenasFighters.get(arena).forEach(c ->this.assignedCharacters.remove(c.getName()));
        this.arenas.remove(arena);
        this.arenasFighters.remove(arena);
        return String.format("Anti Heroes won the battle of %s!", arena);
    }


    @Override
    public String endWar() {
        int allBattles = this.heroesBattlesWon + this.antiheroesBattlesWon;
        if (this.heroesBattlesWon >= this.antiheroesBattlesWon){
            return String.format("After %s battles our FRIENDLY HEROES WON!", allBattles);
        }
        return "WE ARE DOOMED!";
    }
}
