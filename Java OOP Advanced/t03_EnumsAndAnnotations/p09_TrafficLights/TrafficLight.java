package t03_EnumsAndAnnotations.p09_TrafficLights;

public class TrafficLight {
    private Signal signal;

    public TrafficLight(String signal) {
        this.signal = Signal.valueOf(signal);
    }

    public void changeSignal() {
        this.signal = Signal.values()[(this.signal.ordinal() + 1) % 3];
    }

    @Override
    public String toString() {
        return signal.name();
    }
}
