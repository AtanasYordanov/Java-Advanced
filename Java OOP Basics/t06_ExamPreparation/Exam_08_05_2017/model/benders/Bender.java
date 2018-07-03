package t06_ExamPreparation.Exam_08_05_2017.model.benders;

public abstract class Bender {
    private String name;
    private int power;

    protected Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public abstract double getTotalPower();

    @Override
    public String toString() {
        return String.format("Bender: %s, Power: %d", this.name, this.power);
    }
}
