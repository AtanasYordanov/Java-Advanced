package t06_ExamPreparation.Exam_05_01_2018.model.colonists;

public class HardwareEngineer extends Engineer {

    private static final int MAX_AGE = 18;
    private static final int BONUS = 2;
    private static final int NO_BONUS = 0;

    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getBonus() {
        int bonus = super.getAge() < MAX_AGE ? BONUS : NO_BONUS;
        return super.getBonus() + bonus;
    }
}
