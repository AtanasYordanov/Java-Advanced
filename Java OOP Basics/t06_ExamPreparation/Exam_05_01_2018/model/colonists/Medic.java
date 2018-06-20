package t06_ExamPreparation.Exam_05_01_2018.model.colonists;

import t06_ExamPreparation.Exam_05_01_2018.model.Colonist;

public abstract class Medic extends Colonist {
    private static final int BONUS = 2;

    private String sign;

    protected Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    @Override
    protected int getBonus() {
        return BONUS;
    }
}
