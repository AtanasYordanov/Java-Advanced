package t06_ExamPreparation.Exam_08_05_2017.model.benders;

public class AirBender extends Bender {
    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.aerialIntegrity = aerialIntegrity;
    }

    public double getAerialIntegrity() {
        return this.aerialIntegrity;
    }

    @Override
    public double getTotalPower() {
        return super.getPower() * this.aerialIntegrity;
    }

    @Override
    public String toString() {
        return String.format("Air %s, Aerial Integrity: %.2f"
                , super.toString(), this.aerialIntegrity);
    }
}
