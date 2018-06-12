package t01_DefiningClasses.p07_CarSalesman;

public class Engine {
    private static final int NO_DISPLACEMENT = -1;
    private static final String NO_EFFICIENCY = "n/a";

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this(model, power, NO_DISPLACEMENT);
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, NO_EFFICIENCY);
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, NO_DISPLACEMENT, efficiency);
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String displacement = this.displacement == NO_DISPLACEMENT ? "n/a" : String.valueOf(this.displacement);
        return String.format("%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s"
                , this.model, this.power, displacement, this.efficiency);
    }
}
