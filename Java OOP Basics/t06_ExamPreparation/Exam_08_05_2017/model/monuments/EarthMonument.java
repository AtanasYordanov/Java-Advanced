package t06_ExamPreparation.Exam_08_05_2017.model.monuments;

public class EarthMonument extends Monument  {
    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.earthAffinity = earthAffinity;
    }

    @Override
    public int getAffinity() {
        return this.earthAffinity;
    }

    @Override
    public String toString() {
        return String.format("Earth %s, Earth Affinity: %d"
                ,super.toString(), this.earthAffinity);
    }
}
