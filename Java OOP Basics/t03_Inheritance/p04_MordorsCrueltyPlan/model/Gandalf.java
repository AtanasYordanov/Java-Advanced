package t03_Inheritance.p04_MordorsCrueltyPlan.model;

public class Gandalf {
    private static final int INITIAL_HAPPINESS_POINTS = 0;
    private static final int ANGRY_MOON_THRESHOLD = -5;
    private static final int SAD_MOON_THRESHOLD = 0;
    private static final int HAPPY_MOON_THRESHOLD = 15;

    private static final String MOOD_ANGRY = "Angry";
    private static final String MOOD_SAD = "Sad";
    private static final String MOOD_HAPPY = "Happy";
    private static final String MOOD_JS = "JavaScript";
    private int happinessPoints;

    public Gandalf() {
        this.happinessPoints = INITIAL_HAPPINESS_POINTS;
    }

    public String getMood() {
        if (this.happinessPoints < ANGRY_MOON_THRESHOLD) {
            return MOOD_ANGRY;
        } else if (this.happinessPoints < SAD_MOON_THRESHOLD) {
            return MOOD_SAD;
        } else if (this.happinessPoints <= HAPPY_MOON_THRESHOLD) {
            return MOOD_HAPPY;
        } else {
            return MOOD_JS;
        }
    }

    public void eat(Foods food) {
        this.happinessPoints += food.getPoints();
    }

    public int getHappinooessPoints() {
        return this.happinessPoints;
    }
}
