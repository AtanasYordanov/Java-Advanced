package t06_ExamPreparation.Exam_05_01_2018.model.colonists;

public class Surgeon extends Medic {

    private static final String PRECISE_SIGN = "precise";
    private static final String BUTCHER_SIGN = "butcher";
    private static final int MIN_AGE = 25;
    private static final int MAX_AGE = 35;
    private static final int BONUS = 2;
    private static final int NO_BONUS = 0;

    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    protected int getBonus() {
        int bonus = super.getAge() > MIN_AGE && super.getAge() < MAX_AGE ? BONUS : NO_BONUS;
        if (super.getSign().equals(PRECISE_SIGN)) {
            bonus += 3;
        } else if (super.getSign().equals(BUTCHER_SIGN)) {
            bonus -= 3;
        }
        return super.getBonus() + bonus;
    }
}
