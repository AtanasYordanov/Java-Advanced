package t06_ExamPreparation.Exam_08_05_2017.model.benders;

public class EarthBender extends Bender {
    private double groundSaturation;

    public EarthBender(String name, int power, double heatAggression) {
        super(name, power);
        this.groundSaturation = heatAggression;
    }

    public double getGroundSaturation() {
        return this.groundSaturation;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.groundSaturation;
    }

    @Override
    public String toString() {
        return String.format("Earth %s, Ground Saturation: %.2f"
                , super.toString(), this.groundSaturation);
    }
}
