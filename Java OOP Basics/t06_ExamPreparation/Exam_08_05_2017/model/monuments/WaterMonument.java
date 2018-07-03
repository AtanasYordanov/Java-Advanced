package t06_ExamPreparation.Exam_08_05_2017.model.monuments;

public class WaterMonument extends Monument  {
    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.waterAffinity = waterAffinity;
    }

    @Override
    public int getAffinity() {
        return this.waterAffinity;
    }

    @Override
    public String toString() {
        return String.format("Water %s, Water Affinity: %d"
                ,super.toString(), this.waterAffinity);
    }
}
