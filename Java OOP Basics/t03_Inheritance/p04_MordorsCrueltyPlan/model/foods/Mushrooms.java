package t03_Inheritance.p04_MordorsCrueltyPlan.model.foods;

import t03_Inheritance.p04_MordorsCrueltyPlan.model.Foods;

public class Mushrooms extends Foods {
    private static final int POINTS = -10;

    public Mushrooms() {
        super(POINTS);
    }
}
