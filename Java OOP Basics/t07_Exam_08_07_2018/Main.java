import entities.*;
import interfaces.Arena;
import interfaces.ComicCharacter;
import interfaces.Manager;
import interfaces.SuperPower;
import manager.WarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Manager manager = new WarManager();
        for (String line = reader.readLine(); !line.equals("WAR_IS_OVER"); line = reader.readLine()) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            try {
                switch (command) {
                    case "CHECK_CHARACTER":
                        String characterName = tokens[1];
                        System.out.println(manager.checkComicCharacter(characterName));
                        break;
                    case "REGISTER_HERO":
                        ComicCharacter hero = getCharacter(tokens);
                        System.out.println(manager.addHero(hero));
                        break;
                    case "REGISTER_ANTI_HERO":
                        ComicCharacter antihero = getCharacter(tokens);
                        System.out.println(manager.addAntiHero(antihero));
                        break;
                    case "BUILD_ARENA":
                        String arenaName = tokens[1];
                        int capacity = Integer.parseInt(tokens[2]);
                        Arena arena = new ArenaImpl(arenaName, capacity);
                        System.out.println(manager.addArena(arena));
                        break;
                    case "SEND_HERO":
                        arenaName = tokens[1];
                        characterName = tokens[2];
                        System.out.println(manager.addHeroToArena(arenaName, characterName));
                        break;
                    case "SEND_ANTI_HERO":
                        arenaName = tokens[1];
                        characterName = tokens[2];
                        System.out.println(manager.addAntiHeroToArena(arenaName, characterName));
                        break;
                    case "SUPER_POWER":
                        String superPowerName = tokens[1];
                        double powerPoints = Double.parseDouble(tokens[2]);
                        SuperPower superPower = new Power(superPowerName, powerPoints);
                        System.out.println(manager.loadSuperPowerToPool(superPower));
                        break;
                    case "ASIGN_POWER":
                        characterName = tokens[1];
                        superPowerName = tokens[2];
                        System.out.println(manager.assignSuperPowerToComicCharacter(characterName, superPowerName));
                        break;
                    case "UNLEASH":
                        characterName = tokens[1];
                        System.out.println(manager.usePowers(characterName));
                        break;
                    case "COMICS_WAR":
                        arenaName = tokens[1];
                        System.out.println(manager.startBattle(arenaName));
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(manager.endWar());
    }

    private static ComicCharacter getCharacter(String[] tokens) {
        String characterName = tokens[1];
        String type = tokens[2];
        int energy = Integer.parseInt(tokens[3]);
        double health = Double.parseDouble(tokens[4]);
        double intelligence = Double.parseDouble(tokens[5]);
        double special = Double.parseDouble(tokens[6]);
        switch (type) {
            case "Villain":
                return new Villain(characterName, energy, health, intelligence, special);
            case "Titan":
                return new Titan(characterName, energy, health, intelligence, special);
            case "DCHero":
                return new DCHero(characterName, energy, health, intelligence, special);
            case "MarvelHero":
                return new MarvelHero(characterName, energy, health, intelligence, special);
        }
        return null;
    }
}
