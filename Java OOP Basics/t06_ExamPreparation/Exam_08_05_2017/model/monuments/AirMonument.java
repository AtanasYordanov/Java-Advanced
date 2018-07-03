package t06_ExamPreparation.Exam_08_05_2017.model.monuments;

public class AirMonument extends Monument {
    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.airAffinity = airAffinity;
    }

    @Override
    public int getAffinity() {
        return this.airAffinity;
    }

    @Override
    public String toString() {
        return String.format("Air %s, Air Affinity: %d"
                ,super.toString(), this.airAffinity);
    }
}
