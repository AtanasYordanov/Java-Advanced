package t06_ExamPreparation.Exam_05_01_2018.model.colonists;

public class SoftwareEngineer extends Engineer {

    private static final int BONUS = 2;

    public SoftwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getBonus() {
        return super.getBonus() + BONUS;
    }
}
