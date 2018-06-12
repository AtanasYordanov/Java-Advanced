package t01_DefiningClasses.p07_CarSalesman;

public class Car {
    private static final int NO_WEIGHT = -1;
    private static final String NO_COLOR = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this(model, engine, NO_WEIGHT, NO_COLOR);
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, NO_COLOR);
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, NO_WEIGHT, color);
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        String weight = this.weight == NO_WEIGHT ? "n/a" : String.valueOf(this.weight);
        return String.format("%s:%n%s%nWeight: %s%nColor: %s"
                , this.model, this.engine.toString(), weight, this.color);
    }
}
