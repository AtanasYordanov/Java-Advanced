package interfaces;

import java.util.Map;

public interface Manager {
    String checkComicCharacter(String characterName);

    String addHero(ComicCharacter hero);

    String addAntiHero(ComicCharacter hero);

    String addArena(Arena arena);

    String addHeroToArena(String arena, String hero);

    String addAntiHeroToArena(String arena, String antiHero);

    String loadSuperPowerToPool(SuperPower superPower);

    String assignSuperPowerToComicCharacter(String comicCharacter, String superPower);

    String startBattle(String arena);

    String usePowers(String comicCharacter);

    String endWar();
}
