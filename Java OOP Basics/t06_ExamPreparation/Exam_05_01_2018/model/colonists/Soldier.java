package t06_ExamPreparation.Exam_05_01_2018.model.colonists;

import t06_ExamPreparation.Exam_05_01_2018.model.Colonist;

public class Soldier extends Colonist {

    private static final int BONUS = 6;

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getBonus() {
        return BONUS;
    }
}
