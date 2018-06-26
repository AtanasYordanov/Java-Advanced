package t05_InterfacesAndAbstraction.p10_MooD3;

public class Archangel extends BaseHero {
    private int mana;

    protected Archangel(String username, int level, int specialPoints) {
        super(username, level);
        this.mana = specialPoints;
        super.setHashedPassword(new StringBuilder(username).reverse().toString() + username.length() * 21);
    }

    @Override
    public String toString() {
        return super.toString() + this.mana * super.getLevel();
    }
}
