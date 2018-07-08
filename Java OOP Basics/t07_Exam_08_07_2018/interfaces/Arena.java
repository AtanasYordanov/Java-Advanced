package interfaces;

public interface Arena {
    String getArenaName();

    boolean isArenaFull();

    void addHero(ComicCharacter hero);

    void addAntiHero(ComicCharacter hero);

    boolean fightHeroes();
}
