package t03_Inheritance.p04_MordorsCrueltyPlan.model;

public class Foods {
    private static final int DEFAULT_POINTS = -1;
    private final int points;

    public Foods() {
        this(DEFAULT_POINTS);
    }

    protected Foods(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }
}
