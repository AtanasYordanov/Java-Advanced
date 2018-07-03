package t06_ExamPreparation.Exam_08_05_2017.model.benders;

public class WaterBender extends Bender {
    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }

    public double getWaterClarity() {
        return this.waterClarity;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.waterClarity;
    }

    @Override
    public String toString() {
        return String.format("Water %s, Water Clarity: %.2f"
                , super.toString(), this.waterClarity);
    }
}
