package t05_InterfacesAndAbstraction.p10_MooD3;

public class Demon extends BaseHero {
    private double energy;

    protected Demon(String username, int level, double specialPoints) {
        super(username, level);
        this.energy = specialPoints;
        super.setHashedPassword(String.valueOf(username.length() * 217));
    }

    @Override
    public String toString() {
        return super.toString() + this.energy * super.getLevel();
    }
}
