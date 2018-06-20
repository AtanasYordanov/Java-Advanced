package t06_ExamPreparation.Exam_05_01_2018.model;

public abstract class Colonist {
    //protected static final int NO_BONUS = 0;

    private String id;
    private String familyId;
    private int talent;
    private int age;

    protected Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public int getTalent() {
        return this.talent;
    }

    public int getAge() {
        return this.age;
    }

    public void grow(int years) {
        this.age += years;
    }

    public int getPotential() {
        return this.talent + this.getBonus();
    }

    abstract protected int getBonus();

    @Override
    public String toString() {
        return this.id + ": " + this.getPotential();
    }
}
