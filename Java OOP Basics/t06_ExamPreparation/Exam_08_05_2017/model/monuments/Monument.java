package t06_ExamPreparation.Exam_08_05_2017.model.monuments;

public abstract class Monument {
    private String name;

    public Monument(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract int getAffinity();

    @Override
    public String toString() {
        return String.format("Monument: %s", this.name);
    }
}
