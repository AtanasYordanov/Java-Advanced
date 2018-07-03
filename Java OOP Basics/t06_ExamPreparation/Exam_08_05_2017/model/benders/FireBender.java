package t06_ExamPreparation.Exam_08_05_2017.model.benders;

public class FireBender extends Bender {
    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.heatAggression = heatAggression;
    }

    public double getHeatAggression() {
        return this.heatAggression;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.heatAggression;
    }

    @Override
    public String toString() {
        return String.format("Fire %s, Heat Aggression: %.2f"
                , super.toString(), this.heatAggression);
    }
}
