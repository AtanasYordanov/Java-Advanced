package t06_ExamPreparation.Exam_05_01_2018.model.colonists;

public class GeneralPractitioner extends Medic {

    private static final String CARING_SIGN = "caring";
    private static final String CARELESS_SIGN = "careless";
    private static final int MIN_AGE = 15;
    private static final int BONUS = 1;
    private static final int NO_BONUS = 0;

    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    protected int getBonus() {
        int bonus = super.getAge() > MIN_AGE ? BONUS : NO_BONUS;

        if (super.getSign().equals(CARING_SIGN)) {
            bonus++;
        } else if (super.getSign().equals(CARELESS_SIGN)) {
            bonus -= 2;
        }
        return super.getBonus() + bonus;
    }
}
