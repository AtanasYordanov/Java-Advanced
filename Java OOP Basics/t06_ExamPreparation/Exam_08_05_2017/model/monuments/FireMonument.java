package t06_ExamPreparation.Exam_08_05_2017.model.monuments;

public class FireMonument extends Monument  {
    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.fireAffinity = fireAffinity;
    }

    @Override
    public int getAffinity() {
        return this.fireAffinity;
    }

    @Override
    public String toString() {
        return String.format("Fire %s, Fire Affinity: %d"
                ,super.toString(), this.fireAffinity);
    }
}
